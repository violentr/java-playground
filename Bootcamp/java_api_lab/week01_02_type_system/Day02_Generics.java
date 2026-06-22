package java_api_lab.week01_02_type_system;

import java.util.ArrayList;
import java.util.HashMap;

class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void print(T[] array) {
        for (T value : array) {
            System.out.println(value);
        }
    }

    public static <E extends Comparable<E>> E max(E a, E b) {
        return a.compareTo(b) >= 0 ? a : b;
    }
    public static <E> Box<E> of(E value) {
        return new Box<>(value);
    }
}

public class Day02_Generics {

    public static void main(String[] args) {
        Box<Integer> box = new Box<>(3);
        System.out.println(box.getValue());

        Box<Double> newBox = new Box<>(3.0);
        newBox.print(new Double[]{10.2, 20.3, 30.2});

        Box<Character> box2 = new Box<>('a');
        System.out.println(box2.getValue());
        System.out.println("MAX: " + Box.max(5, 10));

        Box<String> box3 = Box.of("Hello");
        System.out.println(box3.getValue());

        Box<HashMap<String, Integer>> box4 = new Box<>(new HashMap<String, Integer>());
        /* this is possible because HashMap is a mutable object
        we are not replacing obj reference, the same ref used
        * */
        box4.getValue().put("age", 18);
        System.out.println(box4.getValue().get("age"));

        Box<ArrayList<String>> box5 = new Box<>(new ArrayList<>());
        /* this is possible because ArrayList is a mutable object
        we are not replacing obj reference, the same ref used
        * */
        box5.getValue().add("Java");
        System.out.println(box5.getValue().get(0));
    }
}