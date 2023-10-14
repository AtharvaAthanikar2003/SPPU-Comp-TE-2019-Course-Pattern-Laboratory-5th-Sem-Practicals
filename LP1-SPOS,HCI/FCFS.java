import java.util.*;
public class FCFS {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of process: ");
        int n = sc.nextInt();
        int pid[] = new int[n];    
        int ar[] = new int[n];     
        int bt[] = new int[n];     
        int ct[] = new int[n];     
        int ta[] = new int[n];     
        int wt[] = new int[n];     
        int temp;
        float avgwt=0,avgta=0;
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter process " + (i+1) + " arrival time: ");
            ar[i] = sc.nextInt();
            System.out.println("Enter process " + (i+1) + " burst time: ");
            bt[i] = sc.nextInt();
            pid[i] = i+1;
        }
        for(int i = 0 ; i <n; i++)
        {
            for(int  j=0;  j < n-(i+1) ; j++)
            {
                if( ar[j] > ar[j+1] )
                {
                    temp = ar[j];
                    ar[j] = ar[j+1];
                    ar[j+1] = temp;
                    temp = bt[j];
                    bt[j] = bt[j+1];
                    bt[j+1] = temp;
                    temp = pid[j];
                    pid[j] = pid[j+1];
                    pid[j+1] = temp;
                }
            }
        }
        for(int  i = 0 ; i < n; i++)
        {
            if( i == 0)
            {   
                ct[i] = ar[i] + bt[i];
            }
            else
            {
                if( ar[i] > ct[i-1])
                {
                    ct[i] = ar[i] + bt[i];
                }
                else
                    ct[i] = ct[i-1] + bt[i];
            }
            ta[i] = ct[i] - ar[i] ;       
            wt[i] = ta[i] - bt[i] ;       
            avgwt += wt[i] ;              
            avgta += ta[i] ;              
        }
        System.out.print("-------------------------------------------------------------------------------------------------------------------");
        System.out.print("\nProcess\t\tArrival Time\tBurst Time\tCompletion Time\t\tTurnaround Time\t\tWaiting Time\n");
        System.out.print("-------------------------------------------------------------------------------------------------------------------");
        for(int  i = 0 ; i< n; i++)
        {
            System.out.print("\n " + (i + 1) + "\t\t" + ar[i] + "\t\t" + bt[i] + "\t\t" + ct[i] + "\t\t\t" + ta[i] + "\t\t\t" + wt[i] + "\n");
        }
        sc.close(); 
        System.out.println("Average TAT : "+ (avgta/n)); 
        System.out.println("\nAverage WT : "+ (avgwt/n)); 
    }
}