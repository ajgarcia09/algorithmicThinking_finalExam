# 413. Arithmetic Slices

https://leetcode.com/problems/arithmetic-slices/

```
A sequence of number is called arithmetic if it consists of at least three elements
and if the difference between any two consecutive elements is the same.

For example, these are arithmetic sequence:

1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9

The following sequence is not arithmetic.

1, 1, 2, 5, 7

A zero-indexed array A consisting of N numbers is given.
A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.

A slice (P, Q) of array A is called arithmetic if the sequence:
A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

The function should return the number of arithmetic slices in the array A.


Example:

A = [1, 2, 3, 4]

return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.

```

## Recursive Definition & Storing Solutions

In order to find the arithmetic slices, I have to traverse each subset of three array
indices and verify if the difference between each consecutive item is the same. For example:

A = [1,3,5,7,8,15,20,25,28,29]

each slice of size three to examine is:

```
[1,3,5]
[3,5,7]
[5,7,8]
[7,8,15]
[8,15,20]
[15,20,25]
[20,25,28]
[25,28,29]
```

I will use an integer array called "slicesSofar" that keeps track of the number of (valid) slices
up to the current index of A.

For example, slicesSoFar computed for A in the example above will result in:

```
slicesSoFar = [0,0,1,2,3,0,0,1,0,0]
```

This means that each index contains the number of slices up until the current index in A.
Therefore, slicesSoFar[2] means that up until A[2] there is one slice in A so far.
slicesSoFar[3] means that up until A[3] there are 2 slices in A so far.
And so on.

Building slicesSoFar requires the previous index in this array in order to compute the next.
For example, slicesSoFar[2] = 1.
In order to compute slicesSoFar[3], I need the previous value (slicesSoFar[2]) and add 1 to it
if a slice was found in the next iteration.

As slicesSoFar updates, I will have a counter (sum) that adds the number of slices so far
as slicesSoFar is being computed.