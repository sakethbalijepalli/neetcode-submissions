class DynamicArray {

    int capacity;
    int[] arr;
    int length;

    public DynamicArray(int capacity) {
        if(capacity > 0){
            this.capacity = capacity;
            this.length = 0;
            this.arr = new int[this.capacity];
        }
    }

    public int get(int i) {
        return this.arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        // 12345 -> 12453
        if(this.length == this.capacity){
            resize();
        }
        this.arr[this.length] = n;
        this.length++;
    }

    public int popback() {
        if (length > 0) {
            length--;
        }
        return arr[length];
    }

    private void resize() {
        capacity *= 2;
        int[] newArr = new int[capacity];
        if (length >= 0) System.arraycopy(arr, 0, newArr, 0, length);
        arr = newArr;
    }

    public int getSize() {
        return this.length;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
