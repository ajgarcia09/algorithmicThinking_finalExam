# 931. Minimum Failing Path Sum

https://leetcode.com/problems/minimum-falling-path-sum/

```
Given a square array of integers A, we want the minimum sum of a
falling path through A.

A falling path starts at any element in the first row, and chooses
one element from each row.  The next row's choice must be in a
column that is different from the previous row's column by at most one.

Example 1:

Input: [[1,2,3],[4,5,6],[7,8,9]]
Output: 12
Explanation:
The possible falling paths are:
[1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
[2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
[3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
The falling path with the smallest sum is [1,4,7], so the answer is 12.
```

## Recursive Definition & Storing Solutions

To solve this problem, I can use A instead of an auxiliary
array to store precomputed solutions (by transforming the
values of A into the computed minimum sum results.Take for
example the following array:

```
A = [[1,1,1],
     [5,3,1],
     [2,3,4]]

Take A[1][0] = 5. You can either go to A[2][0] and get a weight
of 2, or you can go to A[2][1] and obtain a weight of 3.
Since 2 is the minimum of both of these values, the min total
weight at A[1][0] is 5 + 2.
```
Once the first pre-computation is completed, we can move on
to a different row, say A[0][0], A[0][1], A[0][2] we do the same
procedure we did above and compute the final answer. (A[0] = 5,
in this case).