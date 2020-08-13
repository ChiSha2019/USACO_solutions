package demo;

import java.util.HashSet;

public class Demo {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet();
        set.add(2);
        set.add(1);
        set.add(3);
        set.add(5);
        set.add(4);

        System.out.print(set);

    }
}
