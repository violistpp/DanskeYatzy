package dbaranovski.game.yatzy.data;

public class PlayerData {

    private int number;
    private int[] score;
    private int totalScore;

    public PlayerData(int number) {
        this.number = number;
        this.totalScore = 0;
        this.score = new int[]{-1, -1, -1, -1, -1, -1, -1, -1};
    }

    private void updateTotalScore() {
        totalScore = 0;
        for(int point : score) {
            if(point != -1)
                totalScore += point;
        }
    }

    public int getNumber() {
        return number;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int[] getScore() {
//        String score =
//                "Ones - " + this.score[0]
//                + "\nTwos - " + this.score[1]
//                + "\nThrees - " + this.score[2]
//                + "\nFours - " + this.score[3]
//                + "\nFives - " + this.score[4]
//                + "\nSixes - " + this.score[5]
//                + "\nOne Pair - " + this.score[6]
//                + "\nChance - " + this.score[7] + "\n";
        return this.score;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setScore(int index, int score) {
        if(this.score[index] != -1)
            this.score[index] = score;
    }
}
