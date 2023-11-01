import java.util.Scanner;
public class Priority {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number of processes: ");
            int n = sc.nextInt();
            int i, pos = 0, temp;
            int totalTime = 0;
            System.out.println("Enter the burst times: ");
            int p[] = new int[n];
            int at[] = new int[n];
            int bt[] = new int[n];
            int pt[] = new int[n];
            int wt[] = new int[n];
            int tat[] = new int[n];
            int ct[] = new int[n];            
            for (i = 0; i < n; i++) {
                p[i] = i + 1;
                bt[i] = sc.nextInt();
            }         
            System.out.println("Enter arrival times: ");
            for (i = 0; i < n; i++) {
                at[i] = sc.nextInt();
            }            
            System.out.println("Enter priority times: ");
            for (i = 0; i < n; i++) {
                pt[i] = sc.nextInt();
            }           
            for (i = 0; i < n; i++) {
                pos = i;
                for (int j = i + 1; j < n; j++) {
                    if (pt[j] < pt[pos]) {
                        pos = j;
                    }
                }
                temp = pt[pos];
                pt[pos] = pt[i];
                pt[i] = temp;
                temp = p[pos];
                p[pos] = p[i];
                p[i] = temp;
                temp = bt[pos];
                bt[pos] = bt[i];
                bt[i] = temp;
                temp = at[pos];
                at[pos] = at[i];
                at[i] = temp;
            }           
            wt[0] = 0;
            for (i = 1; i < n; i++) {
                wt[i] = ct[i - 1] + bt[i - 1];
            }           
            System.out.print("-------------------------------------------------------------------------------------------------------------------");
            System.out.print("\nProcess\t\tArrival Time\tBurst Time\tCompletion Time\t\tTurnaround Time\t\tWaiting Time\n");
            System.out.print("-------------------------------------------------------------------------------------------------------------------");            
            for (i = 0; i < n; i++) {
                ct[i] = at[i] + wt[i] + bt[i];
                tat[i] = ct[i] - at[i];
                totalTime += tat[i];
                System.out.println("\n " + p[i] + "\t\t" + at[i] + "\t\t" + bt[i] + "\t\t" + ct[i] + "\t\t\t" + tat[i] + "\t\t\t" + wt[i]);
            }                 
            float atat = (float) totalTime / n;
            float awt = (float) calculateAverage(wt, n);
            System.out.println("\nAverage TAT : " + atat);
            System.out.println("Average WT : " + awt + "\n");
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
