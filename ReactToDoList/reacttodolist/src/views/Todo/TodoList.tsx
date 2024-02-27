import styled from "styled-components";
import { Todo } from "../../shared/types/todo.interface";

interface TodoProps {
  todo: Todo;
}

const TodoItemContainer = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px;
  border: 1px solid #000;
  margin: 10px 0;
  cursor: pointer;
  background: lavender;
  width: 200px;
  transition: 0.3s;
`;

export default function TodoList({ todo }: TodoProps) {
  return (
    <TodoItemContainer>
      <div>{todo.title}</div>
    </TodoItemContainer>
  );
}
