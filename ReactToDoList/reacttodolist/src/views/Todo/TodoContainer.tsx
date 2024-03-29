import TodoForm from "./TodoForm";
import TodoList from "./TodoList";
import { Todo } from "../../shared/types/todo.interface";
import { useTodoViewModelHook } from "../../shared/hooks/useTodoViewModel.hook";
import Button from "../../components/atomic/buttons/Button";
import styled from "styled-components";

const TitleContainer = styled.h1`
  text-align: center;
`;

export default function TodoContainer() {
  const { todoList, saveMutation, deleteMutation } = useTodoViewModelHook();
  const handleTodoSubmit = (todo: Todo) => saveMutation.mutate(todo); // todo가 mutationFn의 매개변수로 들어감
  const handleCleanAll = () => deleteMutation.mutate(todoList || []);

  return (
    <div>
      <TitleContainer>TodoList</TitleContainer>
      <div>
        <TodoForm onSubmit={handleTodoSubmit} />
      </div>
      <div>
        {todoList?.map((todo) => (
          <TodoList key={todo.id} todo={todo}></TodoList>
        ))}
      </div>
      <Button context="Clean All" onClick={handleCleanAll} />
    </div>
  );
}
