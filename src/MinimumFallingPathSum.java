/**
 * @author Ana Garcia
 * Algorithmic Thinking and Problem Solving
 * Final Exam
 * Last Modified on: December 10th, 2018
 */
public class MinimumFallingPathSum {
    public static void main(String[]args){
        int[][] A = {{1,1,1},
                     {5,3,1},
                     {2,3,4}};
        System.out.println(minFallingPathSum(A));
    }
    public static int minFallingPathSum(int[][] A) {
        int N = A.length;
        for (int r = N-2; r >= 0; --r) {
            for (int c = 0; c < N; ++c) {
                // best = min(A[r+1][c-1], A[r+1][c], A[r+1][c+1])
                int best = A[r+1][c];
                if (c > 0)
                    best = Math.min(best, A[r+1][c-1]);
                if (c+1 < N)
                    best = Math.min(best, A[r+1][c+1]);
                A[r][c] += best;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int x: A[0])
            ans = Math.min(ans, x);
        return ans;
    }


}
