# Quick Fit Memory Allocator

## Project Overview

The **Quick Fit Memory Allocator** simulates memory allocation and deallocation using the Quick Fit algorithm. This algorithm is designed to efficiently handle fixed-size memory blocks with low to moderate fragmentation. It is best suited for applications that require frequent allocations of fixed sizes.

This program demonstrates the process of allocating and freeing memory in a system with three types of memory blocks: small, medium, and large. The terminal outputs show how memory is allocated, freed, and managed within these blocks, helping to visualize how memory is reused and recycled.

## Key Features

- **Memory Blocks**: 
  - Small List: 5 bytes, 10 bytes, 15 bytes
  - Medium List: 20 bytes, 30 bytes, 40 bytes
  - Large List: 50 bytes, 70 bytes, 100 bytes

- **Memory Allocation**: 
  - Allocates memory from the most suitable block based on the requested size.
  - Allocates memory smaller or equal to the block size and reduces the size of the block accordingly.
  - Allocates memory that exactly fits a block size.

- **Memory Deallocation**: 
  - Frees allocated memory and restores it to the original block, maintaining the integrity of the list structure.
  - Displays memory status after every allocation and deallocation to show how the blocks are managed.

## Example Output

==========================================
              MEMORY STATUS              
==========================================
Small List:  [5, 10, 15]
Medium List: [20, 30, 40]
Large List:  [50, 70, 100]
==========================================

==========================================
Allocating 1 bytes...
------------------------------------------
Allocated 1 bytes from the small list (block size: 5). Remaining: 4 bytes.
------------------------------------------

==========================================
              MEMORY STATUS              
==========================================
Small List:  [4, 10, 15]
Medium List: [20, 30, 40]
Large List:  [50, 70, 100]
==========================================

==========================================
Allocating 5 bytes...
------------------------------------------
Allocated 5 bytes from the small list (block size: 10). Remaining: 5 bytes.
------------------------------------------

==========================================
              MEMORY STATUS              
==========================================
Small List:  [4, 5, 15]
Medium List: [20, 30, 40]
Large List:  [50, 70, 100]
==========================================

==========================================
Allocating 30 bytes...
------------------------------------------
Allocated 30 bytes from the medium list (block size: 40). Remaining: 10 bytes.
------------------------------------------

==========================================
              MEMORY STATUS              
==========================================
Small List:  [4, 5, 15]
Medium List: [20, 30, 10]
Large List:  [50, 70, 100]
==========================================

==========================================
Freeing 1 bytes...
------------------------------------------
Freed 1 bytes and added it back to the block in the small list.
------------------------------------------

==========================================
              MEMORY STATUS              
==========================================
Small List:  [5, 5, 15]
Medium List: [20, 30, 10]
Large List:  [50, 70, 100]
==========================================

...

(And so on for each allocation and free operation.)