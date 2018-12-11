# Palindromic Substrings

Given a string, your task is to count how many palindromic
substrings in this string.

The substrings with different start indexes or end indexes are
counted as different substrings even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
Note:
The input string length won't exceed 1000.

## Recursive Definition & Storing Solutions

In order to solve this problem, I will use a matrix called "isPalindrome"
to keep track of the palindromic substrings in the input string. For example,
if:

```
isPalindrome[startOfString][endOfString] =  true

then input.substring(startOfString, endOfString+1) is a palindrome.
```

As I iterate through the string I need to set all single characters
to true, since a single character is in itself a palindrome.

Then, I have to check if consecutive two-character substrings are palindromes
and build on the isPalindrome matrix, using the previous result of isPalindrome
(whether the substring up to the current index if a palindrome or not)
to compute the next iteration.
