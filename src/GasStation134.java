/**
 *
 */
public class GasStation134 {
    public static void main(String[] args) {
        int[] gas = new int[]{5, 8, 2, 8};
        int[] cost = new int[]{6, 5, 6, 6};
        GasStation134 g = new GasStation134();
        System.out.println(g.canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] net = new int[n];
        for (int i = 0; i < n; i++) {
            net[i] = gas[i] - cost[i];
        }

        for (int i = 0; i < n; i++) {
            int sum = net[i];
            int j = i;
            if (sum >= 0) {
                j = j == n - 1 ? 0 : j + 1;
                while (j != i) {
                    sum += net[j++];
                    if (sum < 0) {
                        break;
                    }

                    if (j == n) {
                        j = 0;
                    }
                }
            }

            if (sum >= 0) {
                return i;
            }
            i = Math.max(i, j - 1);
        }

        return -1;
    }
}
