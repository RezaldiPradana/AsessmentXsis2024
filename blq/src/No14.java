import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class No14 {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();


        int Step = 3;
        leftRotate(input, Step);
        System.out.println("Input 3 : " + input);

        Step = 1;
        leftRotate(input, Step);
        System.out.println("Input 1 : " + input);
    }

    public static void insertArray(List<Integer> list){
        list.clear();
        list.add(3);
        list.add(9);
        list.add(0);
        list.add(7);
        list.add(1);
        list.add(2);
        list.add(4);
    }

    public static void leftRotate(List<Integer> list, int Step) {
        insertArray(list);
        Collections.rotate(list, -Step);
    }
}