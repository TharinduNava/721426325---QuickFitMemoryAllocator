package QuickFitMemory;

public class Main {
    public static void main(String[] args) {
        MemoryAllocator memoryAllocator = new MemoryAllocator(); 

        // Show initial memory blocks
        memoryAllocator.displayMemoryBlocks();

        // Sample allocations and deallocations
        memoryAllocator.allocateMemory(1);   // Requesting 1 byte (small list)
        memoryAllocator.displayMemoryBlocks();  // Display memory status after allocation

        memoryAllocator.allocateMemory(5);   // Requesting 5 bytes (small list)
        memoryAllocator.displayMemoryBlocks();  // Display memory status after allocation

        memoryAllocator.allocateMemory(30);  // Requesting 30 bytes (medium list)
        memoryAllocator.displayMemoryBlocks();  // Display memory status after allocation

        // Freeing some memory
        memoryAllocator.freeMemory(1);      // Free 1 byte
        memoryAllocator.displayMemoryBlocks();  // Display memory status after freeing

        memoryAllocator.freeMemory(5);      // Free 5 bytes
        memoryAllocator.displayMemoryBlocks();  // Display memory status after freeing

        memoryAllocator.freeMemory(30);     // Free 30 bytes
        memoryAllocator.displayMemoryBlocks();  // Display memory status after freeing

        // Allocate more memory after freeing
        memoryAllocator.allocateMemory(10);  // Requesting 10 bytes (small list)
        memoryAllocator.displayMemoryBlocks();  // Display memory status after allocation

        memoryAllocator.allocateMemory(50);  // Requesting 50 bytes (large list)
        memoryAllocator.displayMemoryBlocks();  // Display memory status after allocation

        // Free some more memory
        memoryAllocator.freeMemory(10);      // Free 10 bytes
        memoryAllocator.displayMemoryBlocks();  // Display memory status after freeing

        memoryAllocator.freeMemory(50);      // Free 50 bytes
        memoryAllocator.displayMemoryBlocks();  // Display memory status after freeing

        memoryAllocator.allocateMemory(150); // Requesting memory larger than any block
        memoryAllocator.displayMemoryBlocks();
    }
}