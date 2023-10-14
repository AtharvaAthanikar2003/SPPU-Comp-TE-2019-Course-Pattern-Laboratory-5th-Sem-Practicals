import java.util.Scanner;
public class PreemptiveSJF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of process: ");
        int n = sc.nextInt();
        int pid[] = new int[n];
        int ar[] = new int[n];
        int bt[] = new int[n];
        int ct[] = new int[n];
        int ta[] = new int[n];
        int wt[] = new int[n];
        int f[] = new int[n];
        int k[] = new int[n];
        int tot = 0, st = 0;
        float avgwt = 0, avgta = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("Enter process " + (i + 1) + " arrival time: ");
            ar[i] = sc.nextInt();
            System.out.println("Enter process " + (i + 1) + " burst time: ");
            bt[i] = sc.nextInt();
            k[i] = bt[i];
            pid[i] = i + 1;
        }
        while (true) {
            int min = 99, c = n;
            if (tot == n)
                break;
            for (int i = 0; i < n; i++) {
                if (ar[i] <= st && f[i] == 0 && bt[i] < min) {
                    min = bt[i];
                    c = i;
                }
            }
            if (c == n)
                st++;
            else {
                st++;
                if (--bt[c] == 0) {
                    ct[c] = st;
                    f[c] = 1;
                    tot++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            ta[i] = ct[i] - ar[i];
            wt[i] = ta[i] - k[i];
            avgwt += wt[i];
            avgta += ta[i];
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        System.out.println("Process\t\tArrival Time\tBurst Time\tCompletion Time\t\tTurnaround Time\t\tWaiting Time");
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.println("\n" + (i + 1) + "\t\t" + ar[i] + "\t\t" + k[i] + "\t\t" + ct[i] + "\t\t\t" + ta[i] + "\t\t\t" + wt[i]);
        }
        System.out.println("\nAverage TAT: " + (float) (avgta / n));
        System.out.println("Average WT: " + (float) (avgwt / n));
        sc.close();
    }
}