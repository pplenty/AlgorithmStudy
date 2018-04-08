package step001.kao;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test02 {

    public static void main(String[] args) {
        Pattern p = Pattern.compile("([0-9][0]?)(S|D|T)(#|[*])?");

//        String inputVal = "1S#7T*3D";
        String inputVal = "1S2D*3T";
        inputVal = "1D2S3T*";

        Matcher m = p.matcher(inputVal);

        int totalScore = 0;
        List<Integer> scoreBoard = new ArrayList<>();
        int seq = 0;

        while (m.find()) {
            int result = 0;
            int score = Integer.parseInt(m.group(1));
            char partS = m.group(2).charAt(0);
            char option = m.group(3) != null? m.group(3).charAt(0) : '?';

            switch (partS) {
                case 'S' :
                    result += score;
                    break;
                case 'D' :
                    result += score*score;
                    break;
                case 'T' :
                    result += score*score*score;
                    break;
            }

            if (option == '*') {
                result *= 2;
                if (seq != 0) {
                    scoreBoard.set(seq - 1, scoreBoard.get(seq - 1) * 2);
                }

            } else if (option == '#') {
                result *= -1;
            }
            scoreBoard.add(result);
            seq++;
        }

        for (int i: scoreBoard) {
            totalScore += i;
        }
        System.out.println(inputVal);
        System.out.println("total  = " + totalScore);
        System.out.println(scoreBoard);
    }
}
