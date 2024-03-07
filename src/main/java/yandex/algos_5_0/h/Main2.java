package yandex.algos_5_0.h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2 {
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
        double curFirstPosition = Integer.parseInt(data[1]);
        double firstVelocity = Integer.parseInt(data[2]);
        double curSecondPosition = Integer.parseInt(data[3]);
        double secondVelocity = Integer.parseInt(data[4]);

//        double radius = circleLength / (2 * Math.PI);
        String[] result = new String[2];
        double sec = 0.0;
        double ratio = 1;
        double time = 0;
        double curFirstAngle = (Math.abs(curFirstPosition / circleLength)) * 360.0;
        double curSecondAngle = (Math.abs(curSecondPosition / circleLength)) * 360.0;
        while (true) {
            double prevFirstPosition = curFirstPosition;
            double prevSecondPosition = curSecondPosition;

            double nextStepFirst = curFirstPosition + firstVelocity * ratio;
            double nextStepSecond = curSecondPosition + secondVelocity * ratio;
            curFirstPosition = Math.abs(nextStepFirst) < circleLength ? nextStepFirst : circleLength - (nextStepFirst);
            curSecondPosition = Math.abs(nextStepSecond) < circleLength ? nextStepSecond : circleLength - (nextStepSecond);

            double prevFirstAngle = curFirstAngle;
            double prevSecondAngle = curSecondAngle;
            curFirstAngle = (Math.abs(curFirstPosition / circleLength)) * 360.0;
            curSecondAngle = (Math.abs(curSecondPosition / circleLength)) * 360.0;


            if ((time = isOkOk(curFirstAngle, curSecondAngle, prevFirstAngle, prevSecondAngle, sec, firstVelocity, secondVelocity)) != -1) {
                result[0] = "YES";
                result[1] = String.valueOf(time);
                return result;
            }
            if (isOk(curFirstAngle, curSecondAngle) && sec != 0) {
                result[0] = "YES";
                result[1] = String.valueOf(sec);
                return result;
            }
            sec += ratio;
        }
    }

    public static double isOkOk(double curFirstAngle, double curSecondAngle, double prevFirstAngle, double prevSecondAngle,
                                double time, double firstVelocity, double secondVelocity) {
        curFirstAngle = curFirstAngle <= 180 ? curFirstAngle : 360.0 - curFirstAngle;
        prevFirstAngle = prevFirstAngle <= 180 ? prevFirstAngle : 360.0 - prevFirstAngle;
//        double diffFirst = Math.abs(curFirstAngle - prevFirstAngle);
        double[] intervalFirst = new double[]{prevFirstAngle, curFirstAngle};

        curSecondAngle = curSecondAngle <= 180 ? curSecondAngle : 360.0 - curSecondAngle;
        prevSecondAngle = prevSecondAngle <= 180 ? prevSecondAngle : 360.0 - prevSecondAngle;
//        double diffSecond = Math.abs(curSecondAngle - prevSecondAngle);
        double[] intervalSecond = new double[]{prevSecondAngle, curSecondAngle};

        double distance = intervals(intervalFirst, intervalSecond);
        if (distance != -1) {
            time += 1 - (distance / (firstVelocity + secondVelocity));
            return time;
        } else {
            return -1;
        }
    }

    public static double intervals(double[] first, double[] second) {
        double start = Math.max(first[0], second[0]);
        double end = Math.min(first[1], second[1]);

        if (start <= end) {
            return Math.abs(end - start);
        } else {
            return -1; // интервалы не пересекаются
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
