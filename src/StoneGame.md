# 877. Stone Game

https://leetcode.com/problems/stone-game/

```
Alex and Lee play a game with piles of stones.
There are an even number of piles arranged in a row,
and each pile has a positive integer number of stones piles[i].

The objective of the game is to end with the most stones.
The total number of stones is odd, so there are no ties.

Alex and Lee take turns, with Alex starting first.
Each turn, a player takes the entire pile of stones
from either the beginning or the end of the row.
This continues until there are no more piles left, at which point
the person with the most stones wins.

Assuming Alex and Lee play optimally, return True if and only if Alex
wins the game.

Example 1:

Input: [5,3,4,5]
Output: true
Explanation:
Alex starts first, and can only take the first 5 or the last 5.
Say he takes the first 5, so that the row becomes [3, 4, 5].
If Lee takes 3, then the board is [4, 5], and Alex takes 5 to win with 10 points.
If Lee takes the last 5, then the board is [3, 4], and Alex takes
4 to win with 9 points.
This demonstrated that taking the first 5 was a winning move for Alex,
so we return true.


Note:

2 <= piles.length <= 500
piles.length is even.
1 <= piles[i] <= 500
sum(piles) is odd.
```

## Recursive Definition & Storing Solutions

The largest score Alex can receive where the piles remaining are
piles[i], piles[i+1] ... piles[j] and we need to know what the value
of each position in the game is. In order to define this problem recursively,
I can define an array and call it "currentScore" that keeps track of the
current score in the game.

For example, when the piles remaining are piles[i], piles[i+1] ... piles[j],
the player whose turn it is has at most 2 moves. If the player making a move
is Alex, for example ,then the choices are piles[i] or piles[j], increasing
Alex's score by that amount.

Depending on the previous answer (the current score in the game), we can
move on to the next player's move. In this case Lee can either take piles[1]
or piles[j], decreasing Alex's score. The total score so far will be either
-piles[i] + currentScore[i+1][j] or -piles[j] + currentScore[i][j-1]
and we will choose the minimum possible score.
