package QuickFitMemory;

public class AllocatedBlock {
    int size;
    String listName;
    int index;

    public AllocatedBlock(int size, String listName, int index) {
        this.size = size;
        this.listName = listName;
        this.index = index;
    }
}