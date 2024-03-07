package yandex.algos_5_0.h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        String[] data;
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            data = bf.readLine().split(" ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] result = helper(data);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static String[] helper(String[] data) {
        int circleLength = Integer.parseInt(data[0]);
        double firstPosition = Integer.parseInt(data[1]);
        double firstVelocity = Integer.parseInt(data[2]);
        double secondPosition = Integer.parseInt(data[3]);
        double secondVelocity = Integer.parseInt(data[4]);

//        double nextFirstPosition = 0;
//        double nextSecondPosition = 0;

//        double radius = circleLength / (2 * Math.PI);
        String[] result = new String[2];
        double sec = 0.0;
        double ratio = 1;
        while (true) {
            double firstAngle = (Math.abs(firstPosition / circleLength)) * 360.0;
            double secondAngle = (Math.abs(secondPosition / circleLength)) * 360.0;

            if (isOk(firstAngle, secondAngle) && sec != 0) {
                result[0] = "YES";
                result[1] = String.valueOf(sec);
                return result;
            }
            double nextStepFirst = firstPosition + firstVelocity * ratio;
            double nextStepSecond = secondPosition + secondVelocity * ratio;
            firstPosition = Math.abs(nextStepFirst) < circleLength ? nextStepFirst : circleLength - (nextStepFirst);
            secondPosition = Math.abs(nextStepSecond) < circleLength ? nextStepSecond : circleLength - (nextStepSecond);
            sec += ratio;
        }
    }

    public static boolean isOk(double firstAngle, double secondAngle) {
        firstAngle = firstAngle <= 180 ? firstAngle : 360.0 - firstAngle;
        secondAngle = secondAngle <= 180 ? secondAngle : 360.0 - secondAngle;
        return firstAngle == secondAngle;
    }


    public static double tan(int circleLength, int arcLength) {
        double angle = (arcLength * 1d / circleLength) * 360.0;
        angle = angle <= 180 ? angle : 360.0 - angle;
        return Math.tan(angle);
    }
}
