package dbaranovski.game.yatzy.main;

import dbaranovski.game.yatzy.data.PlayerData;

import java.util.List;

public interface YatzyLower {

    public boolean checkForOnePair(List<Integer> diceList, PlayerData player);
    public boolean checkForChance(List<Integer> diceList, PlayerData player);

}
