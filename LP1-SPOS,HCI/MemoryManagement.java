import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MemoryBlock {
    int id;
    int size;
    boolean allocated;

    public MemoryBlock(int id, int size) {
        this.id = id;
        this.size = size;
        this.allocated = false;
    }
}

class MemoryManager {
    List<MemoryBlock> memory;

    public MemoryManager(int size) {
        memory = new ArrayList<>();
        memory.add(new MemoryBlock(1, size));
    }

    public void displayMemory() {
        System.out.println("\nMemory Status:");
        for (MemoryBlock block : memory) {
            System.out.println("Block " + block.id + " - Size: " + block.size + " - Allocated: " + (block.allocated ? "Yes" : "No"));
        }
    }

    public void allocateFirstFit(int processId, int size) {
        for (MemoryBlock block : memory) {
            if (!block.allocated && block.size >= size) {
                block.allocated = true;
                System.out.println("Process " + processId + " allocated using First Fit in Block " + block.id);
                displayMemory();
                return;
            }
        }
        System.out.println("Process " + processId + " cannot be allocated using First Fit");
        displayMemory();
    }

    public void allocateBestFit(int processId, int size) {
        MemoryBlock bestFit = null;

        for (MemoryBlock block : memory) {
            if (!block.allocated && block.size >= size) {
                if (bestFit == null || block.size < bestFit.size) {
                    bestFit = block;
                }
            }
        }

        if (bestFit != null) {
            bestFit.allocated = true;
            System.out.println("Process " + processId + " allocated using Best Fit in Block " + bestFit.id);
            displayMemory();
        } else {
            System.out.println("Process " + processId + " cannot be allocated using Best Fit");
            displayMemory();
        }
    }

    public void allocateWorstFit(int processId, int size) {
        MemoryBlock worstFit = null;

        for (MemoryBlock block : memory) {
            if (!block.allocated && block.size >= size) {
                if (worstFit == null || block.size > worstFit.size) {
                    worstFit = block;
                }
            }
        }

        if (worstFit != null) {
            worstFit.allocated = true;
            System.out.println("Process " + processId + " allocated using Worst Fit in Block " + worstFit.id);
            displayMemory();
        } else {
            System.out.println("Process " + processId + " cannot be allocated using Worst Fit");
            displayMemory();
        }
    }

    public void allocateNextFit(int processId, int size, int startIndex) {
        int index = startIndex;

        do {
            MemoryBlock block = memory.get(index);
            if (!block.allocated && block.size >= size) {
                block.allocated = true;
                System.out.println("Process " + processId + " allocated using Next Fit in Block " + block.id);
                displayMemory();
                return;
            }

            index = (index + 1) % memory.size();

        } while (index != startIndex);

        System.out.println("Process " + processId + " cannot be allocated using Next Fit");
        displayMemory();
    }
}

public class MemoryManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the initial size of memory: ");
        int initialSize = scanner.nextInt();
        MemoryManager memoryManager = new MemoryManager(initialSize);

        List<Integer> processIds = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        List<Integer> startIndices = new ArrayList<>();

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Enter process details");
            System.out.println("2. Allocate using First Fit");
            System.out.println("3. Allocate using Best Fit");
            System.out.println("4. Allocate using Worst Fit");
            System.out.println("5. Allocate using Next Fit");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter process ID: ");
                    processIds.add(scanner.nextInt());
                    System.out.print("Enter process size: ");
                    sizes.add(scanner.nextInt());
                    break;
                case 2:
                    if (processIds.isEmpty()) {
                        System.out.println("No process details entered. Please enter process details first.");
                        break;
                    }
                    int processId1 = processIds.remove(0);
                    int size1 = sizes.remove(0);
                    memoryManager.allocateFirstFit(processId1, size1);
                    break;
                case 3:
                    if (processIds.isEmpty()) {
                        System.out.println("No process details entered. Please enter process details first.");
                        break;
                    }
                    int processId2 = processIds.remove(0);
                    int size2 = sizes.remove(0);
                    memoryManager.allocateBestFit(processId2, size2);
                    break;
                case 4:
                    if (processIds.isEmpty()) {
                        System.out.println("No process details entered. Please enter process details first.");
                        break;
                    }
                    int processId3 = processIds.remove(0);
                    int size3 = sizes.remove(0);
                    memoryManager.allocateWorstFit(processId3, size3);
                    break;
                case 5:
                    if (processIds.isEmpty()) {
                        System.out.println("No process details entered. Please enter process details first.");
                        break;
                    }
                    int processId4 = processIds.remove(0);
                    int size4 = sizes.remove(0);
                    System.out.print("Enter starting index for Next Fit: ");
                    startIndices.add(scanner.nextInt());
                    int startIndex = startIndices.remove(0);
                    memoryManager.allocateNextFit(processId4, size4, startIndex);
                    break;
                case 0:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}