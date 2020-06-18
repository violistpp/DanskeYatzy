package dbaranovski.game.yatzy.main;

import dbaranovski.game.yatzy.data.PlayerData;

import java.util.ArrayList;
import java.util.List;

public class YatzyImpl implements YatzyUpper, YatzyLower {

    @Override
    public List<Integer> getRollDice() {
        List<Integer> list = new ArrayList<>();
        while(list.size() < 5) {
            list.add(1 + (int)(Math.random() * ((6 - 1) + 1)));
        }
        return list;
    }

    @Override
    public boolean checkForOnes(List<Integer> diceList, PlayerData player) {
        boolean check = false;

        if(player.getScore()[0] == -1) {
            for(int value : diceList) {
                if(value == 1)
                    check = true;
            }
        }
        return check;
    }

    @Override
    public boolean checkForTwos(List<Integer> diceList, PlayerData player) {
        boolean check = false;

        if(player.getScore()[1] == -1) {
            for(int value : diceList) {
                if(value == 2)
                    check = true;
            }
        }
        return check;
    }

    @Override
    public boolean checkForThrees(List<Integer> diceList, PlayerData player) {
        boolean check = false;

        if(player.getScore()[2] == -1) {
            for(int value : diceList) {
                if(value == 3)
                    check = true;
            }
        }
        return check;
    }

    @Override
    public boolean checkForFours(List<Integer> diceList, PlayerData player) {
        boolean check = false;

        if(player.getScore()[3] == -1) {
            for(int value : diceList) {
                if(value == 4)
                    check = true;
            }
        }
        return check;
    }

    @Override
    public boolean checkForFives(List<Integer> diceList, PlayerData player) {
        boolean check = false;

        if(player.getScore()[4] == -1) {
            for(int value : diceList) {
                if(value == 5)
                    check = true;
            }
        }
        return check;
    }

    @Override
    public boolean checkForSixes(List<Integer> diceList, PlayerData player) {
        boolean check = false;

        if(player.getScore()[5] == -1) {
            for(int value : diceList) {
                if(value == 6)
                    check = true;
            }
        }
        return check;
    }

    @Override
    public boolean checkForOnePair(List<Integer> diceList, PlayerData player) {
        boolean check = false;

        if(player.getScore()[6] == -1) {
            for(int value : diceList) {
                if(value == 6)
                    check = true;
            }
        }
        return check;
    }

    @Override
    public boolean checkForChance(List<Integer> diceList, PlayerData player) {
        boolean check = false;

        if(player.getScore()[7] == -1)
            check = true;

        return check;
    }


}
