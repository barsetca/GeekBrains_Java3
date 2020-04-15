package lesson01generics.task01;

import java.io.InputStream;
import java.util.stream.Stream;

public class SwapArrayElements {



    public static void main(String[] args) {
        String[] strings = {"one", "two", "three"};
        Integer[] integers = {1 , 2 , 3, 4 , 5};
        Double[] doubles = {1.0, 2.5, 265.25, -365.2};

       printObjectArrayElements(swapTwoObjectArrayElements(strings, 0, 2));
       printObjectArrayElements(swapTwoObjectArrayElements(integers, 1, 4));
       printObjectArrayElements(swapTwoObjectArrayElements(doubles, 2, 1));

    }

    private static<T> T[] swapTwoObjectArrayElements(T[] array, int index1, int index2) {

        if (array == null || array.length == 0 || index1 == index2){
            return array;
        }
        if( index1 < 0 || index2 < 0 || index1 >= array.length || index2 >= array.length ){
            return null;
        }

        T help = array[index1];
        array[index1] = array[index2];
        array[index2] = help;
        return array;
    }

    private static <T> void printObjectArrayElements(T[] array){
        if (array == null){
            System.out.println("The array Object[] is null");
            return;
        }
        Stream.of(array).forEach(e -> System.out.print(e + " "));
        System.out.println();
    }
}
