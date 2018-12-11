# Perfect Squares

```
Given a positive integer n, find the least number of perfect square
numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
```

## Recursive Definition & Storing Solutions

In order to compute the minimum number of perfect squares that add up to n,
I will have to subtract other perfect squares from n.

I will use an array called "minSoFar" to keep track of the minimum number of
additions of perfect squares that add up to n. For example:

```
If n = 13, then candidate solutions are

13 -1
13 - 4
13 - 9

Then I'll choose the minimum number from them, which will already have been computed
in the previous iteration. Take for example minSoFar:

minSoFar = [0,1,2,3,1,2,3,4,2,1,2,3,3,2]

minSoFar[1] means that so far, the minimum number of additions is 1 (obtained from
subracting 13 -1)
```




