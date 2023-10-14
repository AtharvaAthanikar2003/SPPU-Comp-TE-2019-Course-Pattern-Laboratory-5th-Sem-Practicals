import java.util.Scanner;
public class PreemptivePriority {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number of processes:");
            int n = sc.nextInt();
            System.out.println("Enter the burst times:");
            int p[] = new int[n];
            int pt[] = new int[n];
            int at[] = new int[n];
            int bt[] = new int[n];
            int ct[] = new int[n]; 
            int wt[] = new int[n]; 
            int tat[] = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i + 1;
                bt[i] = sc.nextInt();
            }
            System.out.println("Enter arrival times:");
            for (int i = 0; i < n; i++) {
                at[i] = sc.nextInt();
            }
            System.out.println("Enter priority times:");
            for (int i = 0; i < n; i++) {
                pt[i] = sc.nextInt();
            }
            int t = 0;
            int count = 0;
            while (count < n) {
                int minPriority = Integer.MAX_VALUE;
                int minPriorityIndex = -1;
                for (int i = 0; i < n; i++) {
                    if (bt[i] > 0 && pt[i] < minPriority && t >= at[i]) {
                        minPriority = pt[i];
                        minPriorityIndex = i;
                    }
                }
                if (minPriorityIndex == -1) {
                    t++;
                } else {
                    bt[minPriorityIndex]--;
                    t++;
                    if (bt[minPriorityIndex] == 0) {
                        count++;
                        ct[minPriorityIndex] = t;
                        wt[minPriorityIndex] = ct[minPriorityIndex] - at[minPriorityIndex] - bt[minPriorityIndex];
                        tat[minPriorityIndex] = wt[minPriorityIndex] + bt[minPriorityIndex];
                        System.out.println("Process " + p[minPriorityIndex] +
                                "\tPriority: " + pt[minPriorityIndex] +
                                "\tAT: " + at[minPriorityIndex] +
                                "\tBT: " + bt[minPriorityIndex] +
                                "\tCT: " + ct[minPriorityIndex] +
                                "\tTAT: " + tat[minPriorityIndex] +
                                "\tWT: " + wt[minPriorityIndex]);
                    }
                }
            }
        }
    }
}