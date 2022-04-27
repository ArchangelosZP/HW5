import javax.script.ScriptException;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Calc {
    static String originalSentence;
    static Scanner scanner = new Scanner(System.in);



    // Again, I wrote the code incorrectly - I wrote it as I would do if it were a real task. Now all the same, he began to plan a relocation abroad. Not enough time to do quality homework.
    public void calcM() throws ScriptException {
        System.out.println("Введите выражение которое надо вычислить или же введите exit для выхода");
        String text = scanner.nextLine();
        switch (text) {
            case "exit":
                return;
        }
        Expressions object = new Expressions();
        try {
            System.out.println(object.make(text));
        } catch (IndexOutOfBoundsException e) {
            calcM();
        } catch (NoSuchElementException e) {
            calcM();
        } catch (NumberFormatException e) {
            calcM();
        }
        calcM();
    }

    public class Expressions {


        public boolean isOperation(char c) {
            return c == '+' || c == '-' || c == '/' || c == '%' || c == '*';
        }

        public boolean interval(char c) {
            return c == ' ';
        }

        public int opearatorsPriority(char operand) {
            switch (operand) {
                case '+':
                case '-':
                    return 1;
                case '*':
                case '/':
                case '%':
                    return 2;
                default:
                    return -1;
            }
        }

        public void operator(LinkedList<Integer> cislo, char znak) {
            int r = cislo.removeLast();
            int l = cislo.removeLast();
            switch (znak) {
                case '+':
                    cislo.add(l + r);
                    break;
                case '-':
                    cislo.add(l - r);
                    break;
                case '*':
                    cislo.add(l * r);
                    break;
                case '/':
                    cislo.add(l / r);
                    break;
                case '%':
                    cislo.add(l % r);
                    break;
            }
        }


        public int make(String s) {
            Expressions obj = new Expressions();
            LinkedList<Integer> h = new LinkedList<Integer>();
            LinkedList<Character> op = new LinkedList<Character>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (obj.interval(c))
                    continue;

                if (c == '(') {
                    op.add('(');
                } else if (c == ')') {
                    while (op.getLast() != '(')
                        operator(h, op.removeLast());
                    op.removeLast();
                } else if (obj.isOperation(c)) {
                    while (!op.isEmpty() && obj.opearatorsPriority(op.getLast()) >= obj.opearatorsPriority(c))
                        operator(h, op.removeLast());
                    op.add(c);
                } else {
                    String operand = "";
                    while (i < s.length() && Character.isDigit(s.charAt(i)))
                        operand += s.charAt(i++);
                    --i;
                    h.add(Integer.parseInt(operand));
                }
            }

            while (!op.isEmpty())
                operator(h, op.removeLast());
            return h.get(0);

        }

    }

}


