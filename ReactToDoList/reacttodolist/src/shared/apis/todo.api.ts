import axios from "axios";
import { TodoResponse } from "../types/todoResponse.interface";
import { TodoRequest } from "../types/todoRequest.interface";

const basePath = process.env.REACT_APP_BACK_END_SERVER + "/todoList";

const getTodoList = async () => await axios.get<TodoResponse[]>(basePath);
const saveTodo = async (todo: TodoRequest) =>
  await axios.post<TodoResponse>(basePath, todo); // url과 data 보냄
const deleteTodo = async (id: number) =>
  await axios.delete<TodoResponse>(basePath + `/${id}`);

export const todoApi = {
  getTodoList,
  saveTodo,
  deleteTodo,
};
