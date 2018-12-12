/**
 * @author Ana Garcia
 * Algorithmic Thinking and Problem Solving
 * Final Exam
 * Last Modified on: December 10th, 2018
 */
public class StoneGame {
    public static void main(String[]args){
        int[] piles = {5,3,4,5};
        System.out.println(stoneGame(piles));
    }
    public static boolean stoneGame(int[] piles) {
        int N = piles.length;

        // dp[i+1][j+1] = the value of the game [piles[i], ..., piles[j]].
        int[][] currentScore = new int[N+2][N+2];
        for (int size = 1; size <= N; ++size)
            for (int i = 0; i + size <= N; ++i) {
                int j = i + size - 1;
                int parity = (j + i + N) % 2;  // j - i - N; but +x = -x (mod 2)
                if (parity == 1)
                    currentScore[i+1][j+1] = Math.max(piles[i] + currentScore[i+2][j+1], piles[j] +
                            currentScore[i+1][j]);
                else
                    currentScore[i+1][j+1] = Math.min(-piles[i] +
                            currentScore[i+2][j+1], -piles[j] + currentScore[i+1][j]);
            }

        return currentScore[1][N] > 0;
    }
}