package dbaranovski.game.yatzy.main;

import dbaranovski.game.yatzy.data.PlayerData;

import java.util.List;

public interface YatzyUpper {

    public List<Integer> getRollDice();
    public boolean checkForOnes(List<Integer> diceList, PlayerData player);
    public boolean checkForTwos(List<Integer> diceList, PlayerData player);
    public boolean checkForThrees(List<Integer> diceList, PlayerData player);
    public boolean checkForFours(List<Integer> diceList, PlayerData player);
    public boolean checkForFives(List<Integer> diceList, PlayerData player);
    public boolean checkForSixes(List<Integer> diceList, PlayerData player);

}
