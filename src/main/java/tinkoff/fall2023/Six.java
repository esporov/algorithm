package tinkoff.fall2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Six {

    public static void main(String[] args) {
        String[] firstLine;
        String[][] nextLines;

        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            firstLine = bf.readLine().split(" ");
            nextLines = new String[Integer.parseInt(firstLine[1])][];
            for (int i = 0; i < nextLines.length; i++) {
                nextLines[i] = bf.readLine().split(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        questions4(firstLine, nextLines);
    }

    public static void questions4(String[] fistLine, String[][] nextLines) {
        int n = Integer.parseInt(fistLine[0]);
        int m = Integer.parseInt(fistLine[1]);
        int x;
        int y = 0;

        LinkedList<LinkedList<int[]>> listOfGangs = new LinkedList<>();
        ListIterator<LinkedList<int[]>> listOfGangsIterator;

        for (int i = 0; i < n; i++) {
            LinkedList<int[]> gang = new LinkedList<>();
            int[] ghost = new int[]{i + 1, 1};
            gang.addLast(ghost);
            listOfGangs.addLast(gang);
        }
        for (int i = 0; i < m; i++) {
            int qType = Integer.parseInt(nextLines[i][0]);
            x = Integer.parseInt(nextLines[i][1]);
            if (nextLines[i].length > 2) {
                y = Integer.parseInt(nextLines[i][2]);
            }
            if (qType == 1) {
                int[] xGhost = {0};
                int[] yGhost = {0};
                int temp = 0;
                LinkedList<int[]> xyGang = new LinkedList<>();
                listOfGangsIterator = listOfGangs.listIterator();
                while (listOfGangsIterator.hasNext()) {
                    LinkedList<int[]> curGang = listOfGangsIterator.next();
                    //#######################################
                    for (int[] ghost : curGang) {
                        if (ghost[0] == x || ghost[0] == y) {
                            if (xGhost[0] != 0 || yGhost[0] != 0) {
                                if (ghost[0] == x) {
                                    xGhost[0] = ghost[0];
                                } else {
                                    yGhost[0] = ghost[0];
                                }
                                break;
                            }
                            if (ghost[0] == x) {
                                xGhost[0] = ghost[0];
                            } else {
                                yGhost[0] = ghost[0];
                            }
                            temp += 1;
                            xyGang = new LinkedList<>(curGang);
                        }
                    }
                    //#######################################
                    if (xGhost[0] == x && yGhost[0] == y) {
                        if (!curGang.equals(xyGang)) {
                            curGang.addAll(xyGang);
                            curGang.forEach(gh -> gh[1] = gh[1] + 1);
                            break;
                        }
                    }
                    if (temp == 1) {
                        temp = 0;
                        listOfGangsIterator.remove();
                    }
                    //#######################################
                }
            }

            if (qType == 2) {
                LinkedList<int[]> xGang = new LinkedList<>();
                LinkedList<int[]> yGang = new LinkedList<>();
                for (LinkedList<int[]> gangs : listOfGangs) {
                    for (int[] ghost : gangs) {
                        if (ghost[0] == x) {
                            xGang = gangs;
                        }
                        if (ghost[0] == y) {
                            yGang = gangs;
                        }
                        if (!xGang.isEmpty() && !yGang.isEmpty()) {
                            if (xGang == yGang) {
                                System.out.println("YES");
                            } else {
                                System.out.println("NO");
                            }
                            break;
                        }
                    }
                    if (!xGang.isEmpty() && !yGang.isEmpty()) {
                        break;
                    }
                }
            }

            if (qType == 3) {
                int num = 0;
                for (LinkedList<int[]> gangs : listOfGangs) {
                    for (int[] ghost : gangs) {
                        if (ghost[0] == x) {
                            num = ghost[1];
                            System.out.println(num);
                            break;
                        }
                    }
                    if (num != 0) {
                        break;
                    }
                }
            }
        }
    }
}


