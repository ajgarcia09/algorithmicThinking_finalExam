# 646. Maximum Length of Pair Chain

https://leetcode.com/problems/maximum-length-of-pair-chain/

```
You are given n pairs of numbers. In every pair, the first number is
always smaller than the second number.

Now, we define a pair (c, d) can follow another pair (a, b)
if and only if b < c. Chain of pairs can be formed in this fashion.

Given a set of pairs, find the length longest chain which can be formed.
You needn't use up all the given pairs. You can select pairs in any order.

Example 1:
Input: [[1,2], [2,3], [3,4]]
Output: 2
Explanation: The longest chain is [1,2] -> [3,4]
Note:
The number of given pairs will be in the range [1, 1000].
```

## Recursive Definition & Storing Solutions
In order to find the length of the longest pair chain, I will sort the pairs
in the input list in ascending order. Afterwards, I will look at the first
pair in the list and compare its last element with the first element of every
other element in the list of pairs. For example:

```
A = [[1,2],
     [2,3],
     [3,4]]
```

I will take [1,2] and [2,3] and compare if 2 < 2.
In other words, I will compare if A[0][1] < (A[1][0]) and see if there is a chain.
I will repeat this process comparing [1,2] with every other pair in the list.



As I am computing these comparisons, I will store the result in an array called
"longestLengthSoFar." longestLengthSoFar will keep track of the the length of
the chain so far at the current pair index of A. For example, for array A above:

```
longestLengthSoFar = [1,1,2,2]
```

Each index of longestLengthSoFar contains the length of the longest pair chain up
to the corresponding index of each pair in A; longetLengthSoFar[2] contains the
longest length of the chain so far up until the same index in A (A[2]).


