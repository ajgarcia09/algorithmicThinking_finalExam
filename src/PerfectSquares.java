/**
 * @author Ana Garcia
 * Algorithmic Thinking and Problem Solving
 * Final Exam
 * Last Modified on: December 7th, 2018
 */
public class PerfectSquares {
    public static void main(String[]args){
        System.out.println();
        System.out.println("perfectSquares: " + perfectSquares(13));

    }

    public static int perfectSquares(int n) {
        if(n <= 0)
            return 0;

        int[] minSoFar = new int[n+1];
        for(int i=1; i<=n; ++i){
            int min = Integer.MAX_VALUE;
            for(int k = 1; k*k <= i; ++k){
                min = Math.min(min, minSoFar[i - k*k] + 1);
            }
            minSoFar[i] = min;
        }
//        System.out.print("minSoFar: ");
//        for(int i : minSoFar){
//            System.out.print(i);
//        }
        return minSoFar[n];
    }
}
