package yandex.algos_5_0.g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) {

        int myTeam;
        int barack;
        int reinforcement;
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            myTeam = Integer.parseInt(bf.readLine());
            barack = Integer.parseInt(bf.readLine());
            reinforcement = Integer.parseInt(bf.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(helper(myTeam, barack, reinforcement));
    }

    public static int helper(int myTeam, int barack, int reinforcement) {
        int[] barackHealth = new int[]{barack};
        int[] opponentTeam = new int[1];
        int round = 1;
        int attack = 0;
        int prevOp = -2;
        int curOp = -1;
        int prevBarack = -2;
        int curBarack = -1;

        while (true) {
            //1. мы атакуем
            attack = attack(myTeam, barackHealth, opponentTeam, reinforcement, round);
            if (attack == -1) {
                return -1;
            }
            if (attack == 1) {
                return round;
            }
            curBarack = barackHealth[0];

            //2. атака врага
            myTeam -= opponentTeam[0];

            //3. подкрепление врага
            if (barackHealth[0] > 0) {
                opponentTeam[0] += reinforcement;
            }
            curOp = opponentTeam[0];
            if ((curOp == prevOp && opponentTeam[0] > 0) && (curBarack == prevBarack && barack != 0)) {
                return -1; // зацикливание
            }

            if (myTeam <= 0) {
                return -1;
            }
            if (barackHealth[0] <= 0 && opponentTeam[0] <= 0) {
                break;
            }
            prevBarack = barackHealth[0];
            prevOp = opponentTeam[0];
            round++;
        }
        return round;
    }

    public static int help(int myTeam, int barack, int opponentTeam) {
        int tempBar = Math.max(myTeam - barack, 0); // 250 - 170 = 80
        int tempOp = Math.max(opponentTeam - tempBar, 0); // 230 - (80) = 150
        int tempMy = myTeam - tempOp;
        if (tempOp <= 0) {// 250 - 150 = 100
            return 1;
        }
        if (tempMy > tempOp - tempMy) {
            return help(tempMy, 0, tempOp);
        } else return -1;
    }

    public static int attack(int myTeam, int[] barack, int[] opponentTeam, int reinforcement, int round) {
        if (barack[0] != 0) {
            int tempBar = Math.max(myTeam - barack[0], 0); // 250 - 170 = 80
            int tempOp = Math.max(opponentTeam[0] - tempBar, 0); // 230 - (80) = 150
            int tempMy = myTeam - tempOp; // 250 - 150 = 100
            boolean b = tempMy > tempOp - tempMy;
            int attackk;
            if (b && myTeam >= barack[0]) {
                attackk = barack[0] - myTeam;
                if (attackk >= 0) {
                    barack[0] -= myTeam;
                }
                if (attackk < 0) {
                    attackk = Math.abs(attackk);
                    barack[0] = 0;
                    opponentTeam[0] -= attackk;

                }
                return 0;
            }
            attackk = Math.min(Math.abs(opponentTeam[0] - myTeam), barack[0]);

            barack[0] -= attackk;
            opponentTeam[0] -= Math.abs(myTeam - attackk);
            return 0;

        } else {
            if (myTeam >= opponentTeam[0]) { //мы победили
                return 1;
            }
            if (myTeam <= opponentTeam[0] - myTeam) { //мы проиграли
                return -1;
            }
            int barackAttack = Math.min(Math.abs(opponentTeam[0] - myTeam), barack[0]);
            barack[0] -= barackAttack;
            opponentTeam[0] -= Math.abs(myTeam - barackAttack);
        }
        return 0;
    }
}
