import java.util.*;

public class Magic_numbers {

    public static void main(String[] args) {
        String input = "100 1000";
        String[] minMax = input.split(" ");

        int min = Integer.parseInt(minMax[0]);
        int max = Integer.parseInt(minMax[1]);

        for (int i=min; i<=max; i++) {
            int[] digits = getDigits(i);
            if (checkRotation(digits) && checkRepetitiveDigits(digits)) {
                System.out.println(i);
            }
        }
    }

    public static int[] getDigits(int number) {
        String input = Integer.toString(number);
        int[] digits = new int[input.length()];
        for (int i=0; i<input.length(); i++) {
            digits[i] = Integer.parseInt(input.substring(i, i+1));
        }
        return digits;
    }

    public static boolean checkRotation(int[] digits) {
        boolean isMagic = true;
        int newIndex = 0;
        Set<Integer> newIndexes = new HashSet<>();
        for (int j=0; j<digits.length; j++) {
            newIndex = (digits[newIndex] + newIndex)%digits.length;
            if (!newIndexes.add(newIndex)) {
                isMagic = false;
            }
        }
        return newIndex == 0 && isMagic;
    }

    public static boolean checkRepetitiveDigits(int[] digits) {
        boolean isMagic = true;
        Set<Integer> uniqueDigits = new HashSet<>();
        for (int j=0; j<digits.length; j++) {
            if (!uniqueDigits.add(digits[j])) {
                isMagic = false;
            }
        }
        return isMagic;
    }
}
