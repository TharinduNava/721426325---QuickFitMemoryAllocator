package QuickFitMemory;

import java.util.*;

public class MemoryAllocator {
    // Memory blocks for small, medium, and large lists
    private List<Integer> smallList = new ArrayList<>(Arrays.asList(5, 10, 15));
    private List<Integer> mediumList = new ArrayList<>(Arrays.asList(20, 30, 40));
    private List<Integer> largeList = new ArrayList<>(Arrays.asList(50, 70, 100));

    // To track allocated memory and corresponding block list
    private List<AllocatedBlock> allocatedBlocks = new ArrayList<>();

    // Function to display the current state of memory blocks
    public void displayMemoryBlocks() {
        System.out.println("==========================================");
        System.out.println("              MEMORY STATUS              ");
        System.out.println("==========================================");
        System.out.println("Small Memory Capacity List:  " + smallList);
        System.out.println("Medium Memory Capacity List: " + mediumList);
        System.out.println("Large Memory Capacity List:  " + largeList);
        System.out.println("==========================================");
        System.out.println();
    }

    // Function to allocate memory based on size
    public void allocateMemory(int size) {
        System.out.println("==========================================");
        System.out.println("Allocating " + size + " bytes...");
        System.out.println("------------------------------------------");
    
        // Check if the requested size exceeds the largest block available
        int largestBlock = Math.max(
            Math.max(Collections.max(smallList), Collections.max(mediumList)),
            Collections.max(largeList)
        );
    
        if (size > largestBlock) {
            System.out.println("Error: Requested size of " + size + " bytes exceeds the largest available block (" + largestBlock + " bytes).\n");
            System.out.println("------------------------------------------");
            return;
        }
    
        // Check in the small list first
        if (allocateFromList(smallList, size, "small")) {
            return;
        }
    
        // If not check in the medium list
        if (allocateFromList(mediumList, size, "medium")) {
            return;
        }
    
        // If not check in the large list
        if (allocateFromList(largeList, size, "large")) {
            return;
        }
    
        System.out.println("Unable to allocate " + size + " bytes. No suitable block found.\n");
        System.out.println("------------------------------------------");
    }    

    // Helper function to allocate memory from a given list
    private boolean allocateFromList(List<Integer> list, int size, String listName) {
        for (int i = 0; i < list.size(); i++) {
            int block = list.get(i);

            // If the block is large enough to allocate
            if (block >= size) {
                list.set(i, block - size);  // Update the block size
                allocatedBlocks.add(new AllocatedBlock(size, listName, i));
                System.out.println("Allocated " + size + " bytes from the " + listName + " list (block size: " + block + "). Remaining: " + (block - size) + " bytes.");
                System.out.println("------------------------------------------");
                return true;
            }
        }
        return false;
    }

    // Function to free memory and add back to the respective list
    public void freeMemory(int size) {
        System.out.println("==========================================");
        System.out.println("Freeing " + size + " bytes...");
        System.out.println("------------------------------------------");

        // Try to find the allocated block to free
        boolean freed = false;
        for (AllocatedBlock allocatedBlock : allocatedBlocks) {
            if (allocatedBlock.size == size) {
                // Free the memory by adding it back to the correct list
                if (allocatedBlock.listName.equals("small")) {
                    smallList.set(allocatedBlock.index, smallList.get(allocatedBlock.index) + size);
                } else if (allocatedBlock.listName.equals("medium")) {
                    mediumList.set(allocatedBlock.index, mediumList.get(allocatedBlock.index) + size);
                } else if (allocatedBlock.listName.equals("large")) {
                    largeList.set(allocatedBlock.index, largeList.get(allocatedBlock.index) + size);
                }

                allocatedBlocks.remove(allocatedBlock);  // Remove the block from allocated blocks list
                System.out.println("Freed " + size + " bytes and added it back to the block in the " + allocatedBlock.listName + " list.");
                freed = true;
                break;
            }
        }

        if (!freed) {
            System.out.println("Unable to free " + size + " bytes. It may not have been allocated.\n");
        }

        System.out.println("------------------------------------------");
    }
}