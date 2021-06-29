/**
 * 该题简单来说就是相同任务执行有一个冷却期，如何安排才能让时间最短
 * tags:
 */
public class TaskScheduler621 {
    public static void main(String[] args) {
        char[] tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C'};
        TaskScheduler621 ts = new TaskScheduler621();
        System.out.println(ts.leastInterval(tasks, 2));
    }

    /*
    所有任务执行时间最短即idle尽量少，有以下这两种情况：
    1. idle=0：此时总的时间即任务的数量
    2. idle！=0：
    这种方法属于找规律，没有太多参考意义。
     */
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int max = 0;
        int maxCount = 0;

        for (char task : tasks) {
            count[task - 'A']++;
            max = Math.max(count[task - 'A'], max);
        }

        for (int i : count) {
            if (i == max)
                maxCount++;
        }

        return Math.max(tasks.length, (max - 1) * (n + 1) + maxCount);
    }
}
