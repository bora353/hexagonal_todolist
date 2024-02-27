import { ChangeEvent } from "react";

export interface InputProps {
  value: string;
  onChange: (e: ChangeEvent<HTMLInputElement>) => void;
}

export default function Input({ onChange, value }: InputProps) {
  return <input onChange={onChange} value={value}></input>;
}
