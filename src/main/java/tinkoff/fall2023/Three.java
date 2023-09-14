package tinkoff.fall2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Three {

    public static void main(String[] args) {

        int numOfSeq;
        char[] cowSeq;
        char[] winSeq;

        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));) {
            numOfSeq = Integer.parseInt(bf.readLine());
            cowSeq = bf.readLine().toCharArray();
            winSeq = bf.readLine().toCharArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(winsSeq(numOfSeq, cowSeq, winSeq));
    }

    public static String winsSeq(int numOfSeq, char[] cowCeq, char[] winSeq) {
        String yes = "YES";
        String no = "NO";

        if (numOfSeq == 1) {
            return yes;
        }

        StringBuilder newStr = new StringBuilder();
        char[] newCharArray = new char[cowCeq.length];

        char[] orderedChar;

        for (int i = 0; i < cowCeq.length - 1; i++) {
            for (int j = i + 1; j < cowCeq.length; j++) {
                if (i > 0) {
                    for (int k = 0; k < i; k++) {
                        newCharArray[k] = cowCeq[k];
                    }
                }
                orderedChar = Arrays.copyOfRange(cowCeq, i, j);
                Arrays.sort(orderedChar);
                for (int k = i, m = 0; k < j; k++, m++) {
                    newCharArray[k] = orderedChar[m];
                }

                if (j < cowCeq.length - 1) {
                    for (int k = j; k < cowCeq.length; k++) {
                        newCharArray[k] = cowCeq[k];
                    }
                }

                if (Arrays.equals(newCharArray, winSeq)) {
                    return yes;
                }
            }
        }
        return no;
    }
}
