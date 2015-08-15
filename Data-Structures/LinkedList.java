public class LinkedList<T> {

    private ListNode<T> head;
    private ListNode<T> tail;
    private int size;

    public LinkedList() {
        head = new ListNode<T>();
        head.next = tail;

        tail = new ListNode<T>();
        tail.previous = head;

        size = 0;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void append(T val) {
        ListNode<T> node = new ListNode<T>(val);
        node.previous = tail.previous;
        node.next = tail;
        tail.previous.next = node;
        tail.previous = node;

        this.size++;
    }

    public ListIterator<T> first() {
        ListIterator<T> itr = new ListIterator<T>(head.next);
        return itr;
    }

    public ListIterator<T> last() {
        ListIterator<T> itr = new ListIterator<T>(tail.previous);
        return itr;
    }

    public void insertAfter(ListIterator<T> position, T val) {
        ListNode<T> node = new ListNode<T>(val);
        node.previous = position.getCurrent();
        node.next = position.getCurrent().next;

        position.getCurrent().next = node;
        node.next.previous = node;

        size++;
    }

    public int find(T val) {
        ListIterator<T> itr = first();
        int index = 0;
        while (itr.getCurrent() != tail){
            if (itr.getCurrent().value == val) {
                return index;
            }
            index++;
            itr.forward();
        }

        return -1;
    }
            
    public void insertBefore(ListIterator<T> position, T val) {
        position.backwards();
        insertAfter(position, val);

        size++;
    }

    public String toString() {
        String out = "";
        ListIterator<T> itr = first();

        while (itr.getCurrent() != tail) {
            out += itr.getCurrent().value + " ";
            itr.forward();
        }

        return out;
    }



    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.append(5);
        list.append(6);
        list.append(7);
        list.append(8);
        list.append(9);
        list.append(10);
        list.append(11);
        
        System.out.println(list);

    }
}
