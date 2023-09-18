//SPOS 7th Lab Assignment (P-Round Robin)

import java.util.Scanner;
public class RoundRobin {
    public static void main(String args[]) {
        int n, i, qt, count = 0, temp, sq = 0, bt[], wt[], tat[], rem_bt[];
        float awt = 0, atat = 0;
        bt = new int[10];
        wt = new int[10];
        tat = new int[10];
        rem_bt = new int[10];
        try (Scanner s = new Scanner(System.in)) {
            System.out.print("Enter the number of process (maximum 10) = ");
            n = s.nextInt();
            System.out.print("Enter the burst time of the process\n");
            for (i = 0; i < n; i++) {
                System.out.print("P" + i + " = ");
                bt[i] = s.nextInt();
                rem_bt[i] = bt[i];
            }
            System.out.print("Enter the quantum time: ");
            qt = s.nextInt();
        }
        while (true) {
            for (i = 0, count = 0; i < n; i++) {
                temp = qt;
                if (rem_bt[i] == 0) {
                    count++;
                    continue;
                }
                if (rem_bt[i] > qt)
                    rem_bt[i] = rem_bt[i] - qt;
                else if (rem_bt[i] >= 0) {
                    temp = rem_bt[i];
                    rem_bt[i] = 0;
                }
                sq = sq + temp;
                tat[i] = sq;
            }
            if (n == count)
                break;
        }
  System.out.print("--------------------------------------------------------------------------------");
        System.out.print("\nProcess\t      Burst Time\t       Turnaround Time\t          Waiting Time\n");
        System.out.print("--------------------------------------------------------------------------------");
        for (i = 0; i < n; i++) {
            wt[i] = tat[i] - bt[i];
            awt = awt + wt[i];
            atat = atat + tat[i];
            System.out.print("\n " + (i + 1) + "\t\t" + bt[i] + "\t\t\t\t" + tat[i] + "\t\t\t" + wt[i] + "\n");
        }
        awt = awt / n;
        atat = atat / n;
        System.out.println("\nAverage waiting Time = " + awt + "\n");
        System.out.println("Average turnaround time = " + atat);
    }
  }
