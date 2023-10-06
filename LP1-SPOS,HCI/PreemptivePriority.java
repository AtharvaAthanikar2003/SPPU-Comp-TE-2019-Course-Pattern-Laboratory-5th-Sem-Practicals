import java.util.Scanner;
public class PreemptivePriority {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the number of processes:");
            int n = sc.nextInt();

            System.out.println("Enter the burst times:");
            int p[] = new int[n];
            int bt[] = new int[n]; // burst time
            int pt[] = new int[n]; // priority time
            int wt[] = new int[n]; // waiting time
            int tat[] = new int[n]; // turn-around time

            for (int i = 0; i < n; i++) {
                p[i] = i + 1;
                bt[i] = sc.nextInt();
            }

            System.out.println("Enter priority time:");
            for (int i = 0; i < n; i++) {
                pt[i] = sc.nextInt();
            }

            int t = 0; // current time
            int count = 0; // number of completed processes

            while (count < n) {
                int minPriority = Integer.MAX_VALUE;
                int minPriorityIndex = -1;

                for (int i = 0; i < n; i++) {
                    if (bt[i] > 0 && pt[i] < minPriority && t >= pt[i]) {
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
                        wt[minPriorityIndex] = t - pt[minPriorityIndex] - bt[minPriorityIndex];
                        tat[minPriorityIndex] = wt[minPriorityIndex] + bt[minPriorityIndex];

                        System.out.println("Process " + p[minPriorityIndex] + "\tBT: " + bt[minPriorityIndex] +
                                "\tPriority: " + pt[minPriorityIndex] + "\tWT: " + wt[minPriorityIndex] + "\tTAT: " + tat[minPriorityIndex]);
                    }
                }
            }
        }
    }
}