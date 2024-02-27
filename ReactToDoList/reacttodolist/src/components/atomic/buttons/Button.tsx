export interface ButtonProps {
  context: string;
  onClick?: () => void;
  type?: "button" | "submit" | "reset";
}

export default function Button({
  context,
  onClick,
  type = "button",
}: ButtonProps) {
  return (
    <button onClick={onClick} type={type}>
      {context}
    </button>
  );
}
