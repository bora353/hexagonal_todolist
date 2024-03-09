import { create } from "zustand";
import { Todo } from "../types/todo.interface";

/**
 * Store Interface는 State/Reducer로 작성해 주세요.
 
* State    명명법 -> 이름State
 *      store property가 정의되는 구간입니다.
 * 
 * Reducer  명명법 -> 이름Reducer
 *      store의 기능 및 함수가 정의 되는 구간입니다.
 */

// 현재 상태 저장 및 관리
export interface TodoState {
  todoList: Todo[];
}

// store의 상태 변경 함수 정의
export interface TodoReducer {
  setTodo: (todo: TodoState) => void;
  removeTodo: (id: number) => void;
  toggleTodo: (id: number) => void;
}

// 상태와 리듀서를 통합하여 전역 상태 관리
export const useTodoStore = create<TodoState & TodoReducer>((set) => ({
  todoList: [],
  setTodo: (todoState: TodoState) => set({ todoList: todoState.todoList }), // 사용시   setTodo({ todoList: [...todoList, newTodo] });
  removeTodo: (id: number) =>
    set((todoState: TodoState) => ({
      todoList: todoState.todoList.filter((todo) => todo.id !== id),
    })),
  toggleTodo: (id: number) =>
    set((todoState: TodoState) => ({
      todoList: todoState.todoList.map((todo) => {
        if (todo.id === id) {
          return { ...todo, done: !todo.done };
        }
        return todo;
      }),
    })),
}));
