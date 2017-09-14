import java.util.Stack;

/**
 * Created by amen on 9/7/17.
 */
public class ONP {

    private String equation;

    public ONP(String equation) {
        this.equation = equation;
    }

    /**
     * weryfikujemy czy nie jest operatorem (czyli ze jest liczba)
     *
     * @param token - token do sprawdzenia
     * @return true jesli jest operandem (liczba).
     */
    private boolean is_operand(String token) {
        if (token.equals("+") || token.equals("-")
                || token.equals("*") || token.equals("/")
                || token.equals("(") || token.equals(")")) {
            return false;
        }
        return true;
    }

    private int getPriority(String token) {
        if (token.equals("*") || token.equals("/")) {
            return 2;
        } else if (token.equals("-") || token.equals("+")) {
            return 1;
        }

        System.err.println("Token with priority 0?");
        return 0;
    }

    public void countONP(String equation) {
        Stack<String> stack = new Stack<String>();
        String[] tokens = equation.split(" ");
        for (String token : tokens) {
            if(is_operand(token)){
                stack.push(token);
            }else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                Double result = oblicz(op1, op2, token);
                stack.push(result.toString());
            }
        }
        Double endResult = Double.parseDouble(stack.pop());
        System.out.println("Wynik działania: " + endResult);

    }

    private Double oblicz(String op1, String op2, String token) {
        if (token.equals("*")){
            return Double.parseDouble(op2) * Double.parseDouble(op1);
        }else if (token.equals("+")){
            return Double.parseDouble(op2) + Double.parseDouble(op1);
        }else if (token.equals("-")){
            return Double.parseDouble(op2) - Double.parseDouble(op1);
        }else if (token.equals("/")) {
            return Double.parseDouble(op2) / Double.parseDouble(op1);
        }else {
            System.err.println("Error counting values");
            return 0.0;
        }


    }

    public String convertToONP() {
        String onpEquation = "";
        // pusty stos
        Stack<String> stack = new Stack<String>();

        // dziele wyrazenie na tokeny
        String[] tokens = equation.split(" ");
        for (String token : tokens) { // dla kazdego z tokenów
            // dla każdego tokenu

            if (is_operand(token)) {
                // jeśli to operand, przepisz na wyjscie
                onpEquation += token + " ";
            } else if (token.equals("(")) {
                // przepisujemy token
                stack.push(token);
            } else if (token.equals(")")) {
                // sciagamy tokeny ze stosu dopoki nie trafimy na zamkniecie nawiasu
                while (!stack.isEmpty()) {
                    String tokenFromStack = stack.pop();
                    if (tokenFromStack.equals("(")) {
                        break;
                    } else {
                        onpEquation += tokenFromStack + " ";
                    }
                }
            } else {
                // sprawdzamy tokeny i sciagamy wszystko o nizszym priorytecie
                int priority = getPriority(token);
                while (!stack.isEmpty()) {
                    String tokenFromStack = stack.pop();
                    if (tokenFromStack.equals("(") || (getPriority(tokenFromStack) < priority)) {
                        stack.push(tokenFromStack);
                        break;
                    }
                    onpEquation += tokenFromStack + " ";
                }
                stack.push(token);
            }
        }

        while (!stack.isEmpty()) {
            String item = stack.pop();
            onpEquation += item + " ";
        }

        return onpEquation.substring(0, onpEquation.length() - 1);
    }




}
