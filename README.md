# Quick Fit Memory Allocator

  - Name                  -      K.A.T.N. Hettige
  - Student No.           -      s92066325
  - Registration No.      -      721426325

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

### Initial Memory Status
```
==========================================
              MEMORY STATUS
==========================================
Small Memory Capacity List:  [5, 10, 15]
Medium Memory Capacity List: [20, 30, 40]
Large Memory Capacity List:  [50, 70, 100]
==========================================
```

### Allocating 1 Byte
```
==========================================
Allocating 1 bytes...
------------------------------------------
Allocated 1 bytes from the small list (block size: 5). Remaining: 4 bytes.
------------------------------------------
==========================================
              MEMORY STATUS
==========================================
Small Memory Capacity List:  [4, 10, 15]
Medium Memory Capacity List: [20, 30, 40]
Large Memory Capacity List:  [50, 70, 100]
==========================================
```

### Allocating 5 Bytes
```
==========================================
Allocating 5 bytes...
------------------------------------------
Allocated 5 bytes from the small list (block size: 10). Remaining: 5 bytes.
------------------------------------------
==========================================
              MEMORY STATUS
==========================================
Small Memory Capacity List:  [4, 5, 15]
Medium Memory Capacity List: [20, 30, 40]
Large Memory Capacity List:  [50, 70, 100]
==========================================
```

### Allocating 30 Bytes
```
==========================================
Allocating 30 bytes...
------------------------------------------
Allocated 30 bytes from the medium list (block size: 30). Remaining: 0 bytes.
------------------------------------------
==========================================
              MEMORY STATUS
==========================================
Small Memory Capacity List:  [4, 5, 15]
Medium Memory Capacity List: [20, 0, 40]
Large Memory Capacity List:  [50, 70, 100]
==========================================
```

### Freeing 1 Byte
```
==========================================
Freeing 1 bytes...
------------------------------------------
Freed 1 bytes and added it back to the block in the small list.
------------------------------------------
==========================================
              MEMORY STATUS
==========================================
Small Memory Capacity List:  [5, 5, 15]
Medium Memory Capacity List: [20, 0, 40]
Large Memory Capacity List:  [50, 70, 100]
==========================================
```

### Freeing 5 Bytes
```
==========================================
Freeing 5 bytes...
------------------------------------------
Freed 5 bytes and added it back to the block in the small list.
------------------------------------------
==========================================
              MEMORY STATUS
==========================================
Small Memory Capacity List:  [5, 10, 15]
Medium Memory Capacity List: [20, 0, 40]
Large Memory Capacity List:  [50, 70, 100]
==========================================
```

### Freeing 30 Bytes
```
==========================================
Freeing 30 bytes...
------------------------------------------
Freed 30 bytes and added it back to the block in the medium list.
------------------------------------------
==========================================
              MEMORY STATUS
==========================================
Small Memory Capacity List:  [5, 10, 15]
Medium Memory Capacity List: [20, 30, 40]
Large Memory Capacity List:  [50, 70, 100]
==========================================
```

### Allocating 10 Bytes
```
==========================================
Allocating 10 bytes...
------------------------------------------
Allocated 10 bytes from the small list (block size: 10). Remaining: 0 bytes.
------------------------------------------
==========================================
              MEMORY STATUS
==========================================
Small Memory Capacity List:  [5, 0, 15]
Medium Memory Capacity List: [20, 30, 40]
Large Memory Capacity List:  [50, 70, 100]
==========================================
```

### Allocating 50 Bytes
```
==========================================
Allocating 50 bytes...
------------------------------------------
Allocated 50 bytes from the large list (block size: 50). Remaining: 0 bytes.
------------------------------------------
==========================================
              MEMORY STATUS
==========================================
Small Memory Capacity List:  [5, 0, 15]
Medium Memory Capacity List: [20, 30, 40]
Large Memory Capacity List:  [0, 70, 100]
==========================================
```

### Freeing 10 Bytes
```
==========================================
Freeing 10 bytes...
------------------------------------------
Freed 10 bytes and added it back to the block in the small list.
------------------------------------------
==========================================
              MEMORY STATUS
==========================================
Small Memory Capacity List:  [5, 10, 15]
Medium Memory Capacity List: [20, 30, 40]
Large Memory Capacity List:  [0, 70, 100]
==========================================
```

### Freeing 50 Bytes
```
==========================================
Freeing 50 bytes...
------------------------------------------
Freed 50 bytes and added it back to the block in the large list.
------------------------------------------
==========================================
              MEMORY STATUS
==========================================
Small Memory Capacity List:  [5, 10, 15]
Medium Memory Capacity List: [20, 30, 40]
Large Memory Capacity List:  [50, 70, 100]
==========================================
```

### Allocating 150 Bytes
```
==========================================
Allocating 150 bytes...
------------------------------------------
Error: Requested size of 150 bytes exceeds the largest available block (100 bytes).
------------------------------------------
==========================================
              MEMORY STATUS
==========================================
Small Memory Capacity List:  [5, 10, 15]
Medium Memory Capacity List: [20, 30, 40]
Large Memory Capacity List:  [50, 70, 100]
==========================================
```

### Freeing 15 Bytes
```
==========================================
Freeing 15 bytes...
------------------------------------------
Unable to free 15 bytes. It may not have been allocated.
------------------------------------------
```
