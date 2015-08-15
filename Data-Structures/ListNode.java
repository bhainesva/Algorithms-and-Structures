public class ListNode<T> {
    protected T value;
    protected ListNode<T> next;
    protected ListNode<T> previous;

    public ListNode() {
        value = null;
        next = null;
        previous = null;
    }

    public ListNode(T val) {
        this();
        value = val;
    }
}
