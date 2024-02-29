package leetcode;

public class _2125_Number_of_Laser_Beams_in_a_Bank {
    public static void main(String[] args) {
        System.out.println( numberOfBeams(new String[]{"011001", "000000", "010100", "001000"}));
    }

    public static int numberOfBeams(String[] bank) {
        int i = 0;
        int j = 1;
        int countI = 0;
        int countJ = 0;
        int result = 0;
        while (j < bank.length) {
            if (countI == 0) {
                for (int k = 0; k < bank[i].length(); k++) {
                    if (bank[i].charAt(k) =='1') {
                        countI++;
                    }
                }
            }
            if (countI == 0) {
                i++;
                j++;
                continue;
            }
            if (countJ == 0) {
                for (int k = 0; k < bank[j].length(); k++) {
                    if (bank[j].charAt(k) =='1') {
                        countJ++;
                    }
                }
            }
            if (countJ == 0) {
                j++;
                continue;
            }
            result = result + (countJ * countI);
            countJ = 0;
            countI = 0;
            i = j;
            j = i + 1;
        }
        return result;
    }
}
