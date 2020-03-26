package lesson01generics.task02;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayToList {
    public static void main(String[] args) {
        String[] strings = {"one", "two", "three"};
        Integer[] integers = {1 , 2 , 3, 4 , 5};
        Double[] doubles = {1.0, 2.5, 265.25, -365.2};

        printClasses(strings, objectArrayToList(strings));
        printClasses(integers, objectArrayToList(integers));
        printClasses(doubles, objectArrayToList(doubles));

    }

    private static<T> ArrayList<T> objectArrayToList(T[] array) {
        if(array == null) {
            return null;
       }

        return new ArrayList<>(Arrays.asList(array));
    }

    private static <T> void printClasses(T[] array, List<T> list) {
        if (array == null || list == null){
            System.out.println("The array or list is null");
            return;
        }
        System.out.println("Class of the array: " + array.getClass().getSimpleName() );
        System.out.println("Class of the list: " + list.getClass().getSimpleName());
        System.out.println("ListElement values and their class");
        list.forEach(e -> System.out.println(e + " " + e.getClass().getSimpleName()));
        System.out.println();

    }
}
