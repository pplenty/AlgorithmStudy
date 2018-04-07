package step001.bit;

import java.text.DecimalFormat;
import java.util.Stack;

public class BitTest {

    public static void main(String[] args) {

        System.out.println("6 & 5 :" + (6 & 5));// 0110 & 0101
        System.out.println("6 | 5 :" + (6 | 5));
        System.out.println("6 ^ 5 :" + (6 ^ 5));
        System.out.println("~ 6   :" + (~6));

        //  1011 0010 = 178
        System.out.println("10110010 = 178");
        System.out.println(178 >> 2);
        System.out.println(178 >>> 2);

//        System.out.println(~10 + 1);
        System.out.println(-10 >> 2); // 0110
        System.out.println(-10 >>> 2);
        System.out.println(decimalToBinaryString(1073741821));
        System.out.println("****************");


        //  1011 0010 = 178

    }

    public static String decimalToBinaryString(int decimal) {

        boolean isPositive = true;
        if (decimal < 0) {
            isPositive = false;
        }

        Stack stack = remainderPushToStack(Math.abs(decimal), null);

        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static Stack remainderPushToStack(int decimal, Stack stack) {
        if (stack == null) {
            stack = new Stack();
        }

        int quotient = decimal / 2;
        int remainder = decimal % 2;

        stack.push(remainder);

        if (quotient == 1 || quotient == 0) {
            stack.push(quotient);
        } else {
            remainderPushToStack(quotient, stack);
        }

        return stack;

    }

}
