import java.util.*;

public class BalancedSmileys {

    public static String checkIfBalanced(String input) {
            String result = "YES";
            String[] arr = input.split("");
            Stack<String> stack = new Stack<>();
            int happySmiley = 0;
            int sadSmiley = 0;
            for (int i=0; i<arr.length; i++) {
//                System.out.println(arr[i] + "," + i);
                switch (arr[i]) {
                    case "(" : if (i!=arr.length-1) {stack.push(arr[i]);}
                    else {result = "NO"; happySmiley=0;}
//                        System.out.println(result);
                               break;
                    case ")" : if (stack.empty()) {
                                    if (i==arr.length-1) {
//                                        System.out.println(sadSmiley);
                                        if (sadSmiley>0) {
                                            result = "YES";
                                        } else {
                                            result = "NO";
                                        }
                                    } else {
                                        i = arr.length;
                                        result = "NO";
                                    }
                               } else {
                        stack.pop();
                    }
//                        System.out.println(result);
//                        System.out.println(i);
//                        System.out.println(sadSmiley);
                               break;
                    case ":" : if (i!=arr.length-1) {
                               if (arr[i+1].equals("(")){ i++; sadSmiley++; break;}
                               else if (arr[i+1].equals(")")) i++; happySmiley++;
                               break;
                    }
                }
            }
            if (!stack.empty()) {
                result = "NO";
            }

            if (stack.size()==happySmiley && happySmiley!=0 && stack.peek().equals("(")) {
//                System.out.println(stack.peek());
//                System.out.println(stack.size());
                result = "YES";
            }

        if (stack.size()==sadSmiley && sadSmiley!=0 && stack.peek().equals(")")) {
//                System.out.println(stack.peek());
//                System.out.println(stack.size());
            result = "YES";
        }

        return result;
    }
}
