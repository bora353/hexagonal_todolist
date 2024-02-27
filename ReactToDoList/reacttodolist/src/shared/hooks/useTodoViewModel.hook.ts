import {
  useTodoListQuery,
  useTodoSaveMutation,
  useTodoDeleteMutation,
} from "../queries/todo.query";

export const useTodoViewModelHook = () => {
  const { isLoading, isError, data } = useTodoListQuery();
  const saveMutation = useTodoSaveMutation();
  const deleteMutation = useTodoDeleteMutation();

  return {
    todoList: data,
    isLoading,
    isError,
    saveMutation,
    deleteMutation,
  };
};
