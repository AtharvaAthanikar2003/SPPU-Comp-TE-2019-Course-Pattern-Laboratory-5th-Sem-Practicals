import java.util.Scanner;
public class NonPreemptiveSJF {
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
        int st = 0;
        float avgwt = 0, avgta = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("Enter process " + (i + 1) + " arrival time: ");
            ar[i] = sc.nextInt();
            System.out.println("Enter process " + (i + 1) + " burst time: ");
            bt[i] = sc.nextInt();
            pid[i] = i + 1;
        }
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
        System.out.print("-------------------------------------------------------------------------------------------------------------------");
        System.out.print("\nProcess\t\tArrival Time\tBurst Time\tCompletion Time\t\tTurnaround Time\t\tWaiting Time\n");
        System.out.print("-------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.print("\n " + (i + 1) + "\t\t" + ar[i] + "\t\t" + bt[i] + "\t\t" + ct[i] + "\t\t\t" + ta[i] + "\t\t\t" + wt[i] + "\n");
        }
        System.out.println("\nAverage TAT : " + (float) (avgta / n));
        System.out.println("Average WT : " + (float) (avgwt / n));
        sc.close();
    }
}