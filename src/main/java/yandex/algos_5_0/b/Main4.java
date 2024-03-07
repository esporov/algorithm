package yandex.algos_5_0.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main4 {
    public static void main(String[] args) {
        String[] fGame;
        String[] sGame;
        int gPlace;
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            fGame = bf.readLine().split(":");
            sGame = bf.readLine().split(":");
            gPlace = Integer.parseInt(bf.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int result = needToWin(fGame, sGame, gPlace);
        System.out.println(result);
    }

    public static int needToWin(String[] fGame, String[] sGame, int gPlace) {
        int firstTeamFirstGame = Integer.parseInt(fGame[0]);
        int secondTeamFirstGame = Integer.parseInt(fGame[1]);

        int firstTeamSecondGame = Integer.parseInt(sGame[0]);
        int secondTeamSecondGame = Integer.parseInt(sGame[1]);

        int firstRes = secondTeamFirstGame - firstTeamFirstGame;
        int secondRes = secondTeamSecondGame - firstTeamSecondGame;
        int res = 0;
        int diff = secondRes + firstRes;


        if (diff >= 0) {
            res += Math.abs(diff);
            firstTeamSecondGame += Math.abs(diff);
            res += helper(gPlace, firstTeamFirstGame, secondTeamFirstGame, firstTeamSecondGame, secondTeamSecondGame);
        }
        return res;
    }


    public static int helper(int gPlace, int firstTeamFirstGame, int secondTeamFirstGame, int firstTeamSecondGame,
                             int secondTeamSecondGame) {
        int firstTeamGuestGoal = 0;
        int secondTeamGuestGoal = 0;
        int res = 0;

        if (gPlace == 1) {
            firstTeamGuestGoal = firstTeamSecondGame;
            secondTeamGuestGoal = secondTeamFirstGame;
        }
        if (gPlace == 2) {
            firstTeamGuestGoal = firstTeamFirstGame;
            secondTeamGuestGoal = secondTeamSecondGame;
        }
        if (firstTeamGuestGoal <= secondTeamGuestGoal) {
            res++;
        }
        return res;
    }
}
