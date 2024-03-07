package yandex.algos_5_0.i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2 {

    public static Map<String, Integer> monthOrderMap = new HashMap<>() {{
        put("January", 0); //Monday
        put("February", 1);//Tuesday
        put("March", 2);//Wednesday
        put("April", 3);//Thursday
        put("May", 4);//Friday
        put("June", 5);//Saturday
        put("July", 6);//Sunday
        put("August", 7);//Sunday
        put("September", 8);//Sunday
        put("October", 9);//Sunday
        put("November", 10);//Sunday
        put("December", 11);//Sunday
    }};

    public static void main(String[] args) {
        int holidayCount;
        int year;
        String[][] dayMonth;
        String dayOfWeek;
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            holidayCount = Integer.parseInt(bf.readLine());
            dayMonth = new String[holidayCount][2];
            year = Integer.parseInt(bf.readLine());
            for (int i = 0; i < holidayCount; i++) {
                dayMonth[i] = bf.readLine().split(" ");
            }
            dayOfWeek = bf.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        String res = helper(holidayCount, year, dayMonth, dayOfWeek);
        System.out.println(res);
    }

    static class DateComparator implements Comparator<String[]> {
        @Override
        public int compare(String[] array1, String[] array2) {
            // Сначала сравниваем месяцы
            int monthComparison = 0;
            int month1 = monthOrderMap.get(array1[1]);
            int month2 = monthOrderMap.get(array2[1]);
            if (month1 > month2) monthComparison = 1;
            if (month1 < month2) monthComparison = -1;
            if (month1 != month2) {
                return monthComparison;
            }
            // Если месяцы одинаковые, сравниваем дни
            return Integer.compare(Integer.parseInt(array1[0]), Integer.parseInt(array2[0]));
        }
    }

    public static String helper(int holidayCount, int year, String[][] dayMonth, String dayOfWeek) {
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
        int allDay = isLeapYear ? 366 : 365;

        Arrays.sort(dayMonth, new DateComparator());
        List<String[]> monthList = new ArrayList<>() {
            {
                add(new String[]{"January", "31"});
                if (isLeapYear) {
                    add(new String[]{"February", "29"});
                } else add(new String[]{"February", "28"});
                add(new String[]{"March", "31"});
                add(new String[]{"April", "30"});
                add(new String[]{"May", "31"});
                add(new String[]{"June", "30"});
                add(new String[]{"July", "31"});
                add(new String[]{"August", "31"});
                add(new String[]{"September", "30"});
                add(new String[]{"October", "31"});
                add(new String[]{"November", "30"});
                add(new String[]{"December", "31"});
            }
        };

        int[] dayWeekArray = new int[]{
                0,  //Monday
                0,  //Tuesday
                0,  //Wednesday
                0,  //Thursday
                0,  //Friday
                0,  //Saturday
                0}; //Sunday
        Map<String, Integer> dayWeekMap = new HashMap<>() {{
            put("Monday", 0); //Monday
            put("Tuesday", 1);//Tuesday
            put("Wednesday", 2);//Wednesday
            put("Thursday", 3);//Thursday
            put("Friday", 4);//Friday
            put("Saturday", 5);//Saturday
            put("Sunday", 6);//Sunday
        }};

        int curDayOfWeek = dayWeekMap.get(dayOfWeek);
        int curMonthMaxDays = Integer.parseInt(monthList.get(0)[1]);
        int curDayOfMonth = 1;
        int curMonth = 1;

        int dayMonthArrayLength = dayMonth.length; // максимальное число праздников
        int curHoliday = 0;

        for (int i = 0; i < allDay; i++, curDayOfWeek++, curDayOfMonth++) {
            if (curDayOfMonth > curMonthMaxDays) { // каждый месяц меняется счетчик дней месяца
                curDayOfMonth = 1;
                curMonth += 1;
                curMonthMaxDays = Integer.parseInt(monthList.get(curMonth - 1)[1]);
            }
            if (curDayOfWeek > 6) { // каждую неделю меняется счетчик дней недели
                curDayOfWeek = 0;
            }

            if (curHoliday < dayMonthArrayLength) {
                int month = monthOrderMap.get(dayMonth[curHoliday][1]) + 1;
                if (month == curMonth) { // сравниваем месяцы
                    int day = Integer.parseInt(dayMonth[curHoliday][0]);
                    if (day == (curDayOfMonth)) { //сравниваем дни
                        switch (curDayOfWeek) {
                            case 0 -> dayWeekArray[0] -= 1;
                            case 1 -> dayWeekArray[1] -= 1;
                            case 2 -> dayWeekArray[2] -= 1;
                            case 3 -> dayWeekArray[3] -= 1;
                            case 4 -> dayWeekArray[4] -= 1;
                            case 5 -> dayWeekArray[5] -= 1;
                            case 6 -> dayWeekArray[6] -= 1;
                        }
                        curHoliday++;
                    }
                }
            }
            switch (curDayOfWeek) {
                case 0 -> dayWeekArray[0] += 1;
                case 1 -> dayWeekArray[1] += 1;
                case 2 -> dayWeekArray[2] += 1;
                case 3 -> dayWeekArray[3] += 1;
                case 4 -> dayWeekArray[4] += 1;
                case 5 -> dayWeekArray[5] += 1;
                case 6 -> dayWeekArray[6] += 1;
            }
        }
        int maxBadDays = -1;
        int minGoodDays = 1000;
        int indexBad = 0;
        int indexGood = 0;
        for (int i = 0; i < dayWeekArray.length; i++) {
            if (maxBadDays <= dayWeekArray[i]) {
                maxBadDays = dayWeekArray[i];
                indexBad = i;
            }
            if (minGoodDays >= dayWeekArray[i]) {
                minGoodDays = dayWeekArray[i];
                indexGood = i;
            }
        }
        String[] result = new String[2];
        for (Map.Entry<String, Integer> entry : dayWeekMap.entrySet()) {
            if (entry.getValue() == indexGood) {
                result[0] = entry.getKey();
            }
            if (entry.getValue() == indexBad) {
                result[1] = entry.getKey();
            }
        }
        return result[1] + " " + result[0];
    }
}