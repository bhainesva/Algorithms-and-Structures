import java.util.List;
import java.util.ArrayList;
class Test<T> {
    List<T> store;

    public Test() {
        store = new ArrayList<T>();
    }


    public static void main(String[] args) {
        Test<String> myStack = new Test<>();
    }
}
