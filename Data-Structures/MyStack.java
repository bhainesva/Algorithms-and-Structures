import java.util.List;
import java.util.ArrayList;
class MyStack<T> {
    List<T> store;
    
    public MyStack() {
        store = new ArrayList<T>();
    }

    public void push(T item) {
        store.add(item);
    }

    public T pop() {
        T tmp = store.get(store.size()-1);
        store.remove(store.size()-1);
        return tmp;
    }

    public T top() {
        return store.get(store.size()-1);
    }

    public String toString() {
        String out = "";
        for (int i = 0;i < store.size();i++) {
            out += store.get(i) + ", ";
        }

        return out.substring(0, out.length()-2);
    }

    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<>();
        myStack.push("1");
        myStack.push("2");
        myStack.push("3");
        myStack.push("4");
        myStack.push("5");

        System.out.println(myStack);

        myStack.pop();
        System.out.println(myStack);

        myStack.pop();
        System.out.println(myStack);

        myStack.pop();
        System.out.println(myStack);

        System.out.println(myStack.top());
        System.out.println(myStack);
    }
}


