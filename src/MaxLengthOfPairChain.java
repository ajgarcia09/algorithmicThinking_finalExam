import java.util.Arrays;

public class MaxLengthOfPairChain {
    public static void main(String[]args){
        int[][] pairs = {{2,3},{1,2},{3,4}};
        System.out.println(findLongestChain(pairs));


    }

    public static int findLongestChain(int[][] pairs){
        Arrays.sort(pairs, (a,b) -> a[0] - b[0]);
//        for(int row = 0; row < pairs.length; row++){
//            for(int col = 0; col < pairs[1].length; col++){
//                System.out.println(pairs[row][col]);
//            }
//        }
        int N = pairs.length;
        int[] longestLengthSoFar = new int[N];
        Arrays.fill(longestLengthSoFar, 1);
        for (int j = 1; j < N; ++j) {
            for (int i = 0; i < j; ++i) {
                if (pairs[i][1] < pairs[j][0])
                    longestLengthSoFar[j] = Math.max(longestLengthSoFar[j], longestLengthSoFar[i] + 1);
            }
        }

//        System.out.print("longestLengthSoFar: " );
//        for(int i : longestLengthSoFar){
//            System.out.print(i);
//        }

        int ans = 0;
        for (int x: longestLengthSoFar) if (x > ans) ans = x;
        return ans;

    }
}
