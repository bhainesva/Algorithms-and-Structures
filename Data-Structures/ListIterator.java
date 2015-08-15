public class ListIterator<T> {
    private ListNode<T> current;

    public ListIterator(ListNode<T> node) {
        current = node;
    }

    public ListNode<T> getCurrent() {
        return current;
    }

    public void forward() {
        current = current.next;
    }

    public void backwards() {
        current = current.previous;
    }

}
