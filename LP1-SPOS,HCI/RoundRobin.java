import java.util.Scanner;
public class RoundRobin {
    public static void main(String args[]) {
        int n, i, qt, count = 0, temp, sq = 0, at[], bt[], ct[], tat[], wt[], rem_bt[];
        at = new int[10];
        bt = new int[10];
        ct = new int[10];
        tat = new int[10];
        wt = new int[10];
        rem_bt = new int[10];
        try (Scanner s = new Scanner(System.in)) {
            System.out.print("Enter the number of process (maximum 10) = ");
            n = s.nextInt();
            System.out.print("Enter the burst time and arrival time of the process\n");
            for (i = 0; i < n; i++) {
                System.out.print("P" + i + " (Arrival Time) = ");
                at[i] = s.nextInt();
                System.out.print("P" + i + " (Burst Time) = ");
                bt[i] = s.nextInt();
                rem_bt[i] = bt[i];    
            }
            System.out.print("Enter the quantum time: ");
            qt = s.nextInt();
        }
        while (true) {
            for (i = 0, count = 0; i < n; i++) {
                if (rem_bt[i] <= 0) {
                    count++;
                    continue;
                }
                temp = Math.min(qt, rem_bt[i]);
                rem_bt[i] -= temp;
                sq += temp;
                wt[i] += (sq - at[i]) - bt[i];
            }
            if (count == n)
                break;
        }
        calculateTAT(at, bt, ct, tat, n);
        calculateWT(at, bt, ct, tat, wt, n);
        System.out.print("-------------------------------------------------------------------------------------------------------------------");
        System.out.print("\nProcess\t\tArrival Time\tBurst Time\tCompletion Time\t\tTurnaround Time\t\tWaiting Time\n");
        System.out.print("-------------------------------------------------------------------------------------------------------------------");
        for (i = 0; i < n; i++) {
            System.out.print("\n " + (i + 1) + "\t\t" + at[i] + "\t\t" + bt[i] + "\t\t" + ct[i] + "\t\t\t" + tat[i] + "\t\t\t" + wt[i] + "\n");
        }
        float atat = calculateAverage(tat, n);
        float awt = calculateAverage(wt, n);
        System.out.println("Average Turnaround Time (ATAT) = " + atat);
        System.out.println("Average Waiting Time (AWT) = " + awt);
    }
    private static void calculateTAT(int[] at, int[] bt, int[] ct, int[] tat, int n) {
        for (int i = 0; i < n; i++) {
            ct[i] = at[i] + bt[i];
            tat[i] = ct[i] - at[i];
        }
    }
    private static void calculateWT(int[] at, int[] bt, int[] ct, int[] tat, int[] wt, int n) {
        for (int i = 0; i < n; i++) {
            wt[i] = tat[i] - bt[i];
        }
    }
    private static float calculateAverage(int[] arr, int n) {
        float sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        return sum / n;
    }
}