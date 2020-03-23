public class TennisGame {
    private String score = "";
    private int tempScore=0;
    public static String getScore(String playerName1, String playerName2,String score, int score1, int score2,int tempScore) {
        if (score1==score2) {
            hasScore(score,score1,score2);
        }
        else if (score1>=4 || score2>=4) {
            showPlayWin(score,score1,score2);
        }
        else {
            addNumber(tempScore,score,score1,score2);
        }
        return score;
    }
    public static void hasScore(String score,int score1, int score2){
            switch (score1) {
                case 0:
                    score = "Love-All";
                    break;
                case 1:
                    score = "Fifteen-All";
                    break;
                case 2:
                    score = "Thirty-All";
                    break;
                case 3:
                    score = "Forty-All";
                    break;
                default:
                    score = "Deuce";
                    break;
            }
    }
    public static void showPlayWin(String score,int score1,int score2){
            int minusResult = score1-score2;
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
    }
    public static void addNumber(int tempScore,String score,int score1,int score2){
        for (int i=1; i<3; i++) {
            if (i==1) tempScore = score1;
            else { score+="-"; tempScore = score2;}
            switch(tempScore) {
                case 0:
                    score+="Love";
                    break;
                case 1:
                    score+="Fifteen";
                    break;
                case 2:
                    score+="Thirty";
                    break;
                case 3:
                    score+="Forty";
                    break;
            }
        }
    }
}
