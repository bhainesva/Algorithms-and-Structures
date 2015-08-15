public class ArrayList {
    private Object[] store;
    private int capacity;
    private int size;

    public ArrayList() {
        store = new Object[10];
        capacity = 10;
        size = 0;
    }

    public Object get(int index) {
        if (index < size) {
            return store[index];
        }
        else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void set(int index, Object value) {
        if (index < size) {
            store[index] = value;
        }
        else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    
    public int size() {
        return size;
    }

    public Object remove(int index) {
        if (index < size) {
            Object obj = store[index];
            store[index] = null;
            for (int i=index+1;i < size;i++) {
                store[i-1] = store[i];
            }

            size--;
            return store[index];
        }
        else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void add(Object value) {
        //Check that store is < 75% full
        if (((double)size / capacity) > .75) {
            resize();
        }
        store[size] = value;
        size++;
 
    }

    private void resize() {
        Object[] newStore = new Object[2 * capacity];
        for (int i=0; i<size; i++) {
            newStore[i] = store[i];
        }
        store = newStore;
        capacity = capacity * 2;
    }

    public String toString() {
        String out = "";
        for (int i = 0; i < size; i++) {
            out += store[i] + " ";
        }

        return out;
    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        System.out.println(list);

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        System.out.println(list);

        list.remove(7);
        System.out.println(list);

        list.set(0, 10);
        System.out.println(list);
    }
}


