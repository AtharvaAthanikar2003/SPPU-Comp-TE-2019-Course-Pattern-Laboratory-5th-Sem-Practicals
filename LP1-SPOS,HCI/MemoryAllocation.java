import java.util.Arrays;
import java.util.Scanner;

public class MemoryAllocation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select memory allocation algorithm:");
        System.out.println("1. First Fit");
        System.out.println("2. Best Fit");
        System.out.println("3. Worst Fit");
        System.out.println("4. Next Fit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                firstFitAllocation();
                break;
            case 2:
                bestFitAllocation();
                break;
            case 3:
                worstFitAllocation();
                break;
            case 4:
                nextFitAllocation();
                break;
            default:
                System.out.println("Invalid choice. Exiting program.");
        }

        scanner.close();
    }

    private static void firstFitAllocation() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the Number of Memory Blocks: ");
        int blockNo = scanner.nextInt();
        int block[] = new int[blockNo];
        int flag[] = new int[blockNo];
        int display[] = new int[blockNo];
        int total = 0, sum = 0;
        Arrays.fill(flag, 0);
        Arrays.fill(display, 0);

        for (int i = 0; i < blockNo; i++) {
            System.out.print("Enter the memory capacity of B" + (i + 1) + ": ");
            block[i] = scanner.nextInt();
            total += block[i];
        }

        System.out.print("Enter the Number of Processes: ");
        int processNo = scanner.nextInt();
        int process[] = new int[processNo];

        for (int i = 0; i < processNo; i++) {
            System.out.print("Enter the memory required for Process" + (i + 1) + ": ");
            process[i] = scanner.nextInt();
        }

        System.out.println("\nBlock Distribution:");
        for (int i = 0; i < blockNo; i++) {
            System.out.println("B" + (i + 1) + "\t" + block[i]);
        }

        System.out.println("\nProcess Distribution:");
        for (int i = 0; i < processNo; i++) {
            System.out.println("P" + (i + 1) + "\t" + process[i]);
        }

        for (int i = 0; i < processNo; i++) {
            for (int j = 0; j < blockNo; j++) {
                if (process[i] < block[j] && flag[j] == 0) {
                    sum += process[i];
                    display[j] = i + 1;
                    flag[j] = 1;
                    break;
                }
            }
        }

        System.out.println("\nProcess Allocation in Blocks:");
        for (int i = 0; i < blockNo; i++) {
            if (display[i] == 0) {
                System.out.println("B" + (i + 1) + "\t" + "0");
            } else {
                System.out.println("B" + (i + 1) + "\t" + "P" + display[i]);
            }
        }

        double efficiency = (sum * 100) / total;
        System.out.println("\nEfficiency: " + efficiency + "%");

        scanner.close();
    }

    private static void bestFitAllocation() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the Number of Memory Blocks: ");
        int blockNo = scanner.nextInt();
        int block[] = new int[blockNo];
        int flag[] = new int[blockNo];
        int display[] = new int[blockNo];
        int total = 0, sum = 0;
        Arrays.fill(flag, 0);
        Arrays.fill(display, 0);

        for (int i = 0; i < blockNo; i++) {
            System.out.print("Enter the memory capacity of B" + (i + 1) + ": ");
            block[i] = scanner.nextInt();
            total += block[i];
        }

        System.out.print("Enter the Number of Processes: ");
        int processNo = scanner.nextInt();
        int process[] = new int[processNo];

        for (int i = 0; i < processNo; i++) {
            System.out.print("Enter the memory required for Process" + (i + 1) + ": ");
            process[i] = scanner.nextInt();
        }

        System.out.println("\nBlock Distribution:");
        for (int i = 0; i < blockNo; i++) {
            System.out.println("B" + (i + 1) + "\t" + block[i]);
        }

        System.out.println("\nProcess Distribution:");
        for (int i = 0; i < processNo; i++) {
            System.out.println("P" + (i + 1) + "\t" + process[i]);
        }

        for (int i = 0; i < processNo; i++) {
            int bestFitIdx = -1;
            for (int j = 0; j < blockNo; j++) {
                if (process[i] < block[j] && flag[j] == 0) {
                    if (bestFitIdx == -1 || block[j] < block[bestFitIdx]) {
                        bestFitIdx = j;
                    }
                }
            }

            if (bestFitIdx != -1) {
                sum += process[i];
                display[bestFitIdx] = i + 1;
                flag[bestFitIdx] = 1;
            }
        }

        System.out.println("\nProcess Allocation in Blocks:");
        for (int i = 0; i < blockNo; i++) {
            if (display[i] == 0) {
                System.out.println("B" + (i + 1) + "\t" + "0");
            } else {
                System.out.println("B" + (i + 1) + "\t" + "P" + display[i]);
            }
        }

        double efficiency = (sum * 100) / total;
        System.out.println("\nEfficiency: " + efficiency + "%");

        scanner.close();
    }

    private static void worstFitAllocation() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the Number of Memory Blocks: ");
        int blockNo = scanner.nextInt();
        int block[] = new int[blockNo];
        int flag[] = new int[blockNo];
        int display[] = new int[blockNo];
        int total = 0, sum = 0;
        Arrays.fill(flag, 0);
        Arrays.fill(display, 0);

        for (int i = 0; i < blockNo; i++) {
            System.out.print("Enter the memory capacity of B" + (i + 1) + ": ");
            block[i] = scanner.nextInt();
            total += block[i];
        }

        System.out.print("Enter the Number of Processes: ");
        int processNo = scanner.nextInt();
        int process[] = new int[processNo];

        for (int i = 0; i < processNo; i++) {
            System.out.print("Enter the memory required for Process" + (i + 1) + ": ");
            process[i] = scanner.nextInt();
        }

        System.out.println("\nBlock Distribution:");
        for (int i = 0; i < blockNo; i++) {
            System.out.println("B" + (i + 1) + "\t" + block[i]);
        }

        System.out.println("\nProcess Distribution:");
        for (int i = 0; i < processNo; i++) {
            System.out.println("P" + (i + 1) + "\t" + process[i]);
        }

        for (int i = 0; i < processNo; i++) {
            int worstFitIdx = -1;
            for (int j = 0; j < blockNo; j++) {
                if (process[i] < block[j]) {
                    if (worstFitIdx == -1 || block[j] > block[worstFitIdx]) {
                        worstFitIdx = j;
                    }
                }
            }
            if (worstFitIdx != -1) {
                sum += process[i];
                display[worstFitIdx] = i + 1;
                flag[worstFitIdx] = 1;
            }
        }
        System.out.println("\nProcess Allocation in Blocks:");
        for (int i = 0; i < blockNo; i++) {
            if (display[i] == 0) {
                System.out.println("B" + (i + 1) + "\t" + "0");
            } else {
                System.out.println("B" + (i + 1) + "\t" + "P" + display[i]);
            }
        }
        double efficiency = (sum * 100) / total;
        System.out.println("\nEfficiency: " + efficiency + "%");
        scanner.close();
    }
    private static void nextFitAllocation() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the Number of Memory Blocks: ");
        int blockNo = scanner.nextInt();
        int block[] = new int[blockNo];
        int flag[] = new int[blockNo];
        int display[] = new int[blockNo];
        int total = 0, sum = 0;
        Arrays.fill(flag, 0);
        Arrays.fill(display, 0);

        for (int i = 0; i < blockNo; i++) {
            System.out.print("Enter the memory capacity of B" + (i + 1) + ": ");
            block[i] = scanner.nextInt();
            total += block[i];
        }

        System.out.print("Enter the Number of Processes: ");
        int processNo = scanner.nextInt();
        int process[] = new int[processNo];

        for (int i = 0; i < processNo; i++) {
            System.out.print("Enter the memory required for Process" + (i + 1) + ": ");
            process[i] = scanner.nextInt();
        }

        System.out.println("\nBlock Distribution:");
        for (int i = 0; i < blockNo; i++) {
            System.out.println("B" + (i + 1) + "\t" + block[i]);
        }

        System.out.println("\nProcess Distribution:");
        for (int i = 0; i < processNo; i++) {
            System.out.println("P" + (i + 1) + "\t" + process[i]);
        }

        int currentIndex = 0;
        for (int i = 0; i < processNo; i++) {
            while (currentIndex < blockNo) {
                if (process[i] <= block[currentIndex]) {
                    sum += process[i];
                    display[currentIndex] = i + 1;
                    block[currentIndex] -= process[i];
                    currentIndex = (currentIndex + 1) % blockNo;
                    break;
                }
                currentIndex = (currentIndex + 1) % blockNo;
            }
        }

        System.out.println("\nProcess Allocation in Blocks:");
        for (int i = 0; i < blockNo; i++) {
            if (display[i] == 0) {
                System.out.println("B" + (i + 1) + "\t" + "0");
            } else {
                System.out.println("B" + (i + 1) + "\t" + "P" + display[i]);
            }
        }
        double efficiency = (sum * 100) / total;
        System.out.println("\nEfficiency: " + efficiency + "%");
        scanner.close();
    }
}