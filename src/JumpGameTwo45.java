/**
 * tags: #greedy
 */
public class JumpGameTwo45 {
    public static void main(String[] args) {
        JumpGameTwo45 j = new JumpGameTwo45();
        System.out.println(j.jump(new int[]{2, 3, 1, 1, 4}));
    }

    /*
    使用greedy的思路：如果我们能到达位置j，那么我们也能到达i（j>i)，因此我们
    只要每次都选择最远的位置最终到达终点所需要的步数就会最小。
    https://leetcode.com/problems/jump-game-ii/discuss/18014/Concise-O(n)-one-loop-JAVA-solution-based-on-Greedy
    The main idea is based on greedy. Let's say the range of the current jump is [curBegin, curEnd],
    curFarthest is the farthest point that all points in [curBegin, curEnd] can reach.
    Once the current point reaches curEnd, then trigger another jump, and set the new curEnd with curFarthest,
    then keep the above steps, as the following:
    This is an implicit bfs solution. i == curEnd means you visited all the items on the current level.
    Incrementing jumps++ is like incrementing the level you are on.
     And curEnd = curFarthest is like getting the queue size (level size) for the next level you are traversing.
     */
    public int jump(int[] nums) {
        int minJumps = 0, currEnd = 0, currFurthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            currFurthest = Math.max(currFurthest, i + nums[i]);
            if (currFurthest >= nums.length - 1) {
                minJumps++;
                break;
            }

            if (i == currEnd) {
                currEnd = currFurthest;
                minJumps++;
            }
        }

        return minJumps;
    }

    /*
    数组[2,3,1,1,4]可以看成2--3, 2--1, 3--1, 3--1, 3--4这样图的形式，由于问的是需要多少步，
    每条边的weight可以当成1，这么一来就是一个最短路径问题，我们可以使用bfs的方法求解
     */
    public int jump_bfs(int[] nums) {
        if (nums.length <= 1) return 0;
        int curMax = 0; // to mark the last element in a level
        int level = 0, i = 0;
        while (i <= curMax) {
            int furthest = curMax; // to mark the last element in the next level
            // i<=currMax即从当前点出发，能够访问的子节点数
            for (; i <= curMax; i++) {
                furthest = Math.max(furthest, nums[i] + i);
                if (furthest >= nums.length - 1) return level + 1;
            }
            level++;
            // 从当前点出发，能够到达的最远点（实际就是当前节点下能够访问的下一层的节点个数（子节点））
            curMax = furthest;
        }
        return -1; // if i < curMax, i can't move forward anymore (the last element in the array can't be reached)
    }

    public int jump_Mine(int[] nums) {
        int curr = 0;
        int minSteps = 0;
        while (curr < nums.length - 1) {
            int maxJump = 0;
            int nextPos = curr;
            for (int i = 1; i <= nums[curr]; i++) {
                if (curr + i >= nums.length - 1) {
                    nextPos = curr + i;
                    break;
                } else if (i + nums[curr + i] > maxJump) {
                    maxJump = i + nums[curr + i];
                    nextPos = curr + i;
                }
            }
            curr = nextPos;
            minSteps++;
        }

        return minSteps;
    }
}
