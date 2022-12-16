package Lab_01;

public class CheckString {

    public static void main(String[] args) {
        System.out.println(CheckString.checkString("(1 * 2 + {1 + 3})"));
    }

    public static Boolean checkString(String str) {
        MyStack<Byte> stack = new MyStack<>();
        byte[] bytes = str.getBytes();
        byte counter = 0;//Счетчик наших скобок

        for (int i = 0; i < bytes.length; i++) {
            if ((bytes[i] == '(') || (bytes[i] == '{') || (bytes[i] == '[')) {

                /** Мы точно уверены что строки в java представлены в byte c java 8 **/
                stack.push(bytes[i]);
                counter++;

            } else if ((bytes[i] == ')') || (bytes[i] == '}') || (bytes[i] == ']')) {

                /** Вообще обработка этого исключения является "КОСТЫЛЕМ" по правильному нужно создать
                 метод проверки на пустоту СТЭКА и использовать его в if() место обертки try_catch*/
                try {

                    byte c = stack.peek();

                    /** если тип последней открывающей скобки совпадает
                     с текущей закрывающей скобкой, скобочная последовательность правильная **/
                    if (( c == '(' && bytes[i] == ')') ||
                            (c == '{' && bytes[i] == '}') ||
                            (c == '[' && bytes[i] == ']')) {
                        stack.pop();
                        counter--;
                    }
                    /** если тип последней открывающей скобки не совпадает
                     с текущей закрывающей скобкой, скобочная последовательность неправильная **/
                    if(( c == '(' && bytes[i] != ')') ||
                            (c == '{' && bytes[i] != '}') ||
                            (c == '[' && bytes[i] != ']')) {
                        return false;
                    }

                } catch (RuntimeException e){
                    return false;
                }

            }
        }
        return counter == 0;
    }
}