package dbaranovski.game.yatzy.main;

import dbaranovski.game.yatzy.data.PlayerData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Main extends YatzyImpl {

    private int playersNum;
    private List<PlayerData> players;
    private List<Integer> dice = new ArrayList<>();

    public Main() {
        System.out.println("Welcome to the Yatzy!\n");
        setPlayersNum();
        displayInfo();

        game();
    }

    /**
     * Set number of players
     */
    private void setPlayersNum() {
        System.out.print("Select number or players: ");
        Scanner in = new Scanner(System.in);
        playersNum = in.nextInt();

        try {
            if(playersNum < 1)
                throw new ExecutionException(new Exception());
        } catch (Exception e) {
            e.printStackTrace();
            setPlayersNum();
        }

        players = new ArrayList<>(); // annul old list if is exist
        for(int i = 0; i < playersNum; i++) {
            players.add(new PlayerData(i+1));
        }

    }

    /**
     * Display info about players score.
     */
    private void displayInfo() {
        System.out.println("\n######################### INFO ############################");
        for (PlayerData data : players) {
            System.out.println("number: " + data.getNumber() + "\n"
                    + "score: " + data.getTotalScore());
        }
        System.out.println("###########################################################\n");
    }

    /**
     *
     * @param n choose the menu
     */
    private void displayOptions(int n) {
        if(n == 1) {        // base menu
            System.out.println("1 - play");
            System.out.println("2 - display info");
            System.out.println("3 - reset players");
            System.out.println("0 - quit");
        } else if(n == 2) { // roll beginning
            System.out.println("1 - roll");
            System.out.println("2 - display score sections");
        } else if(n == 3) { // making decision

        }
        System.out.print("*************** Select: ");
    }

    private boolean[] determinePossibleChoice(int playerNum) {
        boolean possibile[] = new boolean[8];

        if(checkForOnes(dice, players.get(playerNum)))
            possibile[0] = true;
        if(checkForTwos(dice, players.get(playerNum)))
            possibile[1] = true;
        if(checkForThrees(dice, players.get(playerNum)))
            possibile[2] = true;
        if(checkForFours(dice, players.get(playerNum)))
            possibile[3] = true;
        if(checkForFives(dice, players.get(playerNum)))
            possibile[4] = true;
        if(checkForSixes(dice, players.get(playerNum)))
            possibile[5] = true;
        if(checkForOnePair(dice, players.get(playerNum)))
            possibile[6] = true;
        if(checkForChance(dice, players.get(playerNum)))
            possibile[7] = true;

        return possibile;
    }

    /**
     *
     * @param playerNum player id
     * @return possible options
     */
    private void displayPossibleChoice(int playerNum) {
        System.out.println("################## Choose one ");
        if(checkForOnes(dice, players.get(playerNum)))
            System.out.println("1 - Ones");
        if(checkForTwos(dice, players.get(playerNum)))
            System.out.println("2 - Twos");
        if(checkForThrees(dice, players.get(playerNum)))
            System.out.println("3 - Threes");
        if(checkForFours(dice, players.get(playerNum)))
            System.out.println("4 - Fours");
        if(checkForFives(dice, players.get(playerNum)))
            System.out.println("5 - Fives");
        if(checkForSixes(dice, players.get(playerNum)))
            System.out.println("6 - Sixes");
        if(checkForOnePair(dice, players.get(playerNum)))
            System.out.println("7 - OnePair");
        if(checkForChance(dice, players.get(playerNum)))
            System.out.println("8 - Chance");
        System.out.println("0 - Zero");
        System.out.print("*********** make a choice: ");
    }

    /**
     * Base game environment
     */
    private void game() {
        int selection;
        while(true) {
            displayOptions(1);
            Scanner in = new Scanner(System.in);
            selection = in.nextInt();

            if(selection == 1) {
                playYatzy();
            }
            else if(selection == 2)
                displayInfo();
            else if(selection == 3)
                setPlayersNum();
            else if (selection == 0)
                break;
            else
                System.out.println("there is no such option");
        }
    }

    private void playYatzy() {
        for(int i = 0; i < 8; i++) {
            int player = 0;

            while(player < players.size()) {
                int selection;
                boolean[] possibleOptions;
                displayOptions(2);
                Scanner in = new Scanner(System.in);
                selection = in.nextInt();

                if(selection == 1) {
                    dice = getRollDice();
                    System.out.println(">> values of dice <<");
                    for(int value : dice)
                        System.out.print(value + " ");
                    System.out.println();

                    possibleOptions = determinePossibleChoice(player);
                    displayPossibleChoice(player); // display possible options

                    int choice = checkForCorrectChoice(possibleOptions);

                    if(choice > 0 && choice < 7) {
                        int multiply = 0;
                        for(int value : dice) {
                            if(value == choice)
                                multiply++;
                        }
                        players.get(player).setScore(choice-1, choice * multiply);
                    } else if(choice == 0) {
                        System.out.println(">> Choice one from this selections");
                        for(int j = 0; j < 8; j++) {
                            if(possibleOptions[j]) {
                                System.out.print(j+1 + " - ");
                            }
                        }
                        System.out.println("");
                        int zeroGo = in.nextInt();
                        players.get(player).setScore(zeroGo-1, 0);
                    }
                }
                player++;
            }
        }
    }

    private int checkForCorrectChoice(boolean[] possibleOptions) {
        Scanner in = new Scanner(System.in);
        int selection;
        while(true) {
            selection = in.nextInt();
            if(selection != 0) {
                if(!possibleOptions[selection-1]) {
                    System.out.println("Incorrect number, please choice from displayed selections");
                } else
                    break;
            } else
                break;

        }
        return selection;
    }

    public static void main(String[] args) {
        new Main();
    }

}
