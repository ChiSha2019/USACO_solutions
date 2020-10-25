package bronze.photoShootJan2020;

import java.util.HashSet;

/*
* set doenst guarantee order of input elements
* set doen't allow duplicate
* */
public class SetPractice {
    public static void main(String[] args) {
        HashSet<String> fruitSet = new HashSet<String>();
        fruitSet.add("apples");
        fruitSet.add("banana");
        fruitSet.add("watermelon");
        System.out.println(fruitSet);
        System.out.println(fruitSet.contains("grapes"));
    }
}
