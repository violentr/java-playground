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
}

public class Day02_Generics {

    public static void main(String[] args) {
        Box <Integer> box = new Box<>(3);
        System.out.println(box.getValue());

        Box <Character> box2 = new Box<>('a');
        System.out.println(box2.getValue());

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