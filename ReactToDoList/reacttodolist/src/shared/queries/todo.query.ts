import { useQuery, useMutation, useQueryClient } from "@tanstack/react-query";
import { Todo } from "../types/todo.interface";
import { todoApi } from "../apis/todo.api";
import { todoConvert, todoRequestConvert } from "../utils/todoConvert";

// useQuery : HTTP GET 요청 시, 주로 사용
export const useTodoListQuery = () => {
  return useQuery<Todo[]>({
    // useQuery마다 부여되는 고유 Key
    queryKey: ["todoList"],
    // 서버에 API 요청하는 코드
    queryFn: async () => {
      const { data } = await todoApi.getTodoList();
      return data.map((data) => todoConvert(data)); // TodoResponse 타입으로 받아서 Todo로 반환
    },
  });
};

// useMutation : HTTP POST, PUT, DELETE 서버 데이터 변경 시 사용
export const useTodoSaveMutation = () => {
  const queryClient = useQueryClient(); // 쿼리의 무효화, 새로운 쿼리의 실행, 캐시된 데이터에 접근
  return useMutation({
    mutationFn: async (todo: Todo) => {
      const request = todoRequestConvert(todo); // Todo 타입을 TodoRequest로 반환
      const { data } = await todoApi.saveTodo(request);
      return todoConvert(data);
    },
    onSuccess: () => {
      // "todoList" 키 가진 쿼리의 캐시를 무효화하고, 다음에 해당 쿼리가 요청될 때 새로운 데이터를 가져와서 다시 렌더링
      queryClient.invalidateQueries({ queryKey: ["todoList"] });
    },
  });
};

export const useTodoDeleteMutation = () => {
  const queryClient = useQueryClient();
  return useMutation({
    mutationFn: async (todoList: Todo[]) => {
      await Promise.all(
        // 비동기 호출을 병렬로 실행하고 모두 완료되어야 다음 단계로
        todoList.map(async (todo) => {
          console.log("Deleting todo:", todo);
          await todoApi.deleteTodo(todo.id!); // ! 사용해서 null이 아니라고 단언
        })
      );
    },
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: ["todoList"] });
    },
  });
};
