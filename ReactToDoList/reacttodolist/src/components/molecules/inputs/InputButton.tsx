import Button, { ButtonProps } from "../../atomic/buttons/Button";
import Input, { InputProps } from "../../atomic/inputs/Input";

interface InputButtonProps extends InputProps, ButtonProps {}

export default function InputButton({
  context,
  onClick,
  type,
  onChange,
  value,
}: InputButtonProps) {
  return (
    <div>
      <Input onChange={onChange} value={value} />
      <Button onClick={onClick} context={context} type={type} />
    </div>
  );
}
