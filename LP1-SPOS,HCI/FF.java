import java.util.Scanner;
public class FF {
    static int job[];
    static int block[];
    static int js, bs;
    static Scanner input = new Scanner(System.in);
    static int Allocation[];

    public static void main(String args[]) {
        FF MA = new FF();
        while (true) {
            System.out.println("\n1.Read Data - Job No. & Size, Block No. & Size \n2.First Fit \n3.Best Fit \n4.Worst Fit \n5.Next Fit \n6.Exit");
            System.out.println("Enter Your Choice:");
            int ch = Integer.parseInt(input.nextLine());
            switch (ch) {
                case 1:
                    System.out.println("Enter total no. of jobs:");
                    js = Integer.parseInt(input.nextLine());
                    System.out.println("Enter total no. of blocks:");
                    bs = Integer.parseInt(input.nextLine());
                    job = new int[js];
                    block = new int[bs];
                    MA.ReadData(js, bs);
                    break;
                case 2:
                    MA.Firstfit();
                    break;
                case 3:
                    MA.BestFit();
                    break;
                case 4:
                    MA.WorstFit();
                    break;
                case 5:
                    MA.NextFit();
                    break;    
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }

    void ReadData(int n, int m) {
        for (int i = 0; i < n; i++) {
            System.out.println("Enter Job Size:");
            job[i] = Integer.parseInt(input.nextLine());
        }
        for (int i = 0; i < m; i++) {
            System.out.println("Enter Block Size:");
            block[i] = Integer.parseInt(input.nextLine());
        }
    }

    void Firstfit() {
        int flag = 0;
        Allocation = new int[js];
        for (int i = 0; i < Allocation.length; i++) {
            Allocation[i] = -1;
        }
        for (int i = 0; i < js; i++) {
            for (int j = 0; j < bs; j++) {
                flag = 0;
                if (block[j] >= job[i]) {
                    for (int k = 0; k < js; k++) {
                        if (Allocation[k] == j)
                            flag = 1;
                    }
                    if (flag == 0) {
                        Allocation[i] = j;
                        break;
                    }
                }
            }
        }
        Display();
    }

    void Display() {
        System.out.println("Job No.\t\tJob Size\tBlock No.\tFragment");
        for (int i = 0; i < js; i++) {
            System.out.print((i+1) + "\t\t" + job[i] + "\t\t");
            if (Allocation[i] != -1) {
                System.out.println(Allocation[i] + "\t\t" + (block[Allocation[i]] - job[i]));
            } else {
                System.out.println("Not Allocated");
            }
        }
    }

    void BestFit() {
        int flag = 0;
        Allocation = new int[js];
        for (int i = 0; i < Allocation.length; i++) {
            Allocation[i] = -1;
        }
        for (int i = 0; i < js; i++) {
            int BestInd = -1;
            for (int j = 0; j < bs; j++) {
                flag = 0;
                if (block[j] >= job[i]) {
                    for (int k = 0; k < js; k++) {
                        if (Allocation[k] == j) {
                            flag = 1;
                            break;
                        }
                    }
                    if (BestInd == -1 && flag == 0) {
                        BestInd = j;
                    } else if (flag == 0 && block[BestInd] > block[j]) {
                        BestInd = j;
                    } else {
                        continue;
                    }
                }
            }
            if (BestInd != -1) {
                Allocation[i] = BestInd;
            }
        }
        Display();
    }

    void WorstFit() {
        Allocation = new int[js];
        for (int i = 0; i < Allocation.length; i++) {
            Allocation[i] = -1;
        }
        for (int i = 0; i < js; i++) {
            int worstBlockIndex = -1;
            for (int j = 0; j < bs; j++) {
                if (block[j] >= job[i]) {
                    if (worstBlockIndex == -1 || block[j] > block[worstBlockIndex]) {
                        worstBlockIndex = j;
                    }
                }
            }
            if (worstBlockIndex != -1) {
                Allocation[i] = worstBlockIndex;
                block[worstBlockIndex] -= job[i];
            }
        }
        Display();
    }
    void NextFit() {
        int flag = 0;
        Allocation = new int[js];
        int lastBlockIndex = 0;

        for (int i = 0; i < Allocation.length; i++)
            Allocation[i] = -1;

        for (int i = 0; i < js; i++) {
            flag = 0;
            for (int j = lastBlockIndex; j < bs; j++) {
                if (block[j] >= job[i]) {
                    for (int k = 0; k < js; k++) {
                        if (Allocation[k] == j) {
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0) {
                        Allocation[i] = j;
                        lastBlockIndex = j;
                        break;
                    }
                }
            }
        }
        Display();
    }
}
