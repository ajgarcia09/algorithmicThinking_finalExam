/**
 * @author Ana Garcia
 * Algorithmic Thinking and Problem Solving
 * Final Exam
 * Last Modified on: December 11th, 2018
 */
public class PalindromicSubstrings {
    public static void main(String[]args){
        System.out.println(countSubstrings("aaa"));

    }

    public static int countSubstrings(String s) {
        int len = s.length(), count = 0;
        boolean[][] isPalindrome = new boolean[len][len];
        for (int i=0; i< len; i++) {
            isPalindrome[i][i] = true; // single char substrings
            count++;
        }
        for (int i=1; i< len; i++) {
            isPalindrome[i-1][i] = s.charAt(i-1) == s.charAt(i); // double char substrings
            if (isPalindrome[i-1][i]) count++;
        }
        for (int i=2; i<len; i++) {
            for (int j=0; j<len-i; j++) {
                isPalindrome[j][j+i] = s.charAt(j) == s.charAt(j+i) && isPalindrome[j+1][j+i-1];  // three or more char substrings
                if (isPalindrome[j][j+i]) count++;
            }
        }

        return count;
    }
}
