package stack;

public class ArrayStack {

    private String[] items;
    private int index = -1;
    private int size;

    public ArrayStack(int n) {
        size = n;
        items = new String[n];
    }

    public boolean push(String item) {
        if (index < size) {
            index++;
            items[index] = item;
            return true;
        }
        return false;

    }

    public String pop() {
        if (index >= 0) {
            int tempIndex = index;
            index--;
            return items[tempIndex];
        }
        return null;
    }
}
