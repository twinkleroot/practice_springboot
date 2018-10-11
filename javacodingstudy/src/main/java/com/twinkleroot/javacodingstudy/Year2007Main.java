package com.twinkleroot.javacodingstudy;

import java.util.Scanner;

public class Year2007Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*  2007년 1월 1일로부터 입력된 날까지 몇 일인지 구한다.
            sumDay % 7 해서 나온 나머지 값을 구한다.
            시작이 월요일 이므로 {월,화,수,목,금,토,일} 배열의 인덱스에 맞춰서 답을 낸다.
         */

        int month = scanner.nextInt();
        int day = scanner.nextInt();
        int[] maxDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] EnglishDay = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int indexMonth = month-1;

        if(!(month > 0 && month <= 12)) {
            System.out.println("month의 입력 값이 잘못되었습니다. 1 <= month <= 12");
        }

        if(day > maxDay[indexMonth]) {
            System.out.println("day의 입력 값이 잘못 되었습니다." + month + "월은 " + maxDay[indexMonth] + "일까지 있습니다.");
        }

        int calculateDay = 0;
        if(month > 1) {
            for (int i = 0; i < month-1; i++) {
                calculateDay += maxDay[i];
            }
        }
        calculateDay = (calculateDay + day) % 7;
        String resultDay = EnglishDay[calculateDay];

        System.out.println(resultDay);
    }
}
