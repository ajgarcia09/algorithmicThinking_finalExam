public class ArithmeticSlices {
    public static void main(String[]args){
        int[] A = {1,3,5,7,9,15,20,25,28,29};
        System.out.println("numberOfArithmeticSlices: " + numberOfArithmeticSlices(A));

    }

    public static int numberOfArithmeticSlices(int[]A){
        int[] slicesSoFar = new int[A.length];
        int sum = 0;
        for(int i = 2; i < slicesSoFar.length; i++){
            if(A[i] - A[i-1] == A[i-1] - A[i-2]){
                slicesSoFar[i] = slicesSoFar[i-1] +1;
                sum += slicesSoFar[i];
            }
        }
        return sum;
    }
}
