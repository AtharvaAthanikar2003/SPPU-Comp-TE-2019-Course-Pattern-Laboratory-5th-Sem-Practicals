import java.util.Scanner;
public class NonPreemptiveSJF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of process: ");
        int n = sc.nextInt();
        int pid[] = new int[n]; // process ids
        int ar[] = new int[n]; // arrival times
        int bt[] = new int[n]; // burst or execution times
        int ct[] = new int[n]; // completion times
        int ta[] = new int[n]; // turn around times
        int wt[] = new int[n]; // waiting times;
        int st = 0;
        float avgwt = 0, avgta = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("Enter process " + (i + 1) + " arrival time: ");
            ar[i] = sc.nextInt();
            System.out.println("Enter process " + (i + 1) + " burst time: ");
            bt[i] = sc.nextInt();
            pid[i] = i + 1;
        }

        // Sorting processes based on burst time
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (bt[j] > bt[j + 1]) {
                    int temp = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = temp;

                    temp = bt[j];
                    bt[j] = bt[j + 1];
                    bt[j + 1] = temp;

                    temp = pid[j];
                    pid[j] = pid[j + 1];
                    pid[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            ct[i] = st + bt[i];
            st = ct[i];
            ta[i] = ct[i] - ar[i];
            wt[i] = ta[i] - bt[i];
            avgwt += wt[i];
            avgta += ta[i];
        }
        System.out.println("\nPid  arrival  burst  complete  turn  waiting");
        for (int i = 0; i < n; i++) {
            System.out.println(pid[i] + "\t" + ar[i] + "\t" + bt[i] + "\t" + ct[i] + "\t"
                    + ta[i] + "\t" + wt[i]);
        }
        System.out.println("\nAverage tat is " + (float) (avgta / n));
        System.out.println("Average wt is " + (float) (avgwt / n));
        sc.close();
    }
}