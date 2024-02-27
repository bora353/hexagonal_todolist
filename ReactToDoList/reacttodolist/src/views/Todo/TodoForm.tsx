import { useState } from "react";
import { Todo } from "../../shared/types/todo.interface";
import InputButton from "../../components/molecules/inputs/InputButton";

interface TodoFormProps {
  onSubmit: (todo: Todo) => void; // Todo 타입 받아들이고, 반환 안함
}

export default function TodoForm({ onSubmit }: TodoFormProps) {
  const [keyword, setKeyword] = useState<string>("");

  //debugger; // 이거 신기하네

  const handleAddTodo = () => {
    onSubmit({
      title: keyword,
      description: "설명",
      done: false,
    });
    setKeyword("");
  };

  const handleChange = (e: any) => {
    setKeyword(e.target.value);
  };

  return (
    <div>
      <form
        onSubmit={(e) => {
          e.preventDefault();
          handleAddTodo();
        }}
      >
        <InputButton
          context="추가"
          value={keyword}
          onChange={handleChange}
          type="submit"
        />
      </form>
    </div>
  );
}
