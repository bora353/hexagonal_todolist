import { Todo } from "../types/todo.interface";
import { TodoRequest } from "../types/todoRequest.interface";
import { TodoResponse } from "../types/todoResponse.interface";

export const todoConvert = (response: TodoResponse): Todo => {
  // 매개변수는 TodoResponse타입의 response, 반환타입은 Todo
  return {
    id: response.id,
    title: response.content,
    description: response.description,
    done: response.complete,
  };
};

export const todoRequestConvert = (response: Todo): TodoRequest => {
  return {
    id: response.id!,
    content: response.title,
    description: response.description,
    complete: response.done,
    name: "tester",
  };
};
