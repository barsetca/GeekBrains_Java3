package lesson01generics.task03;

import javax.crypto.spec.PSource;
import java.util.ArrayList;

public class Main {

    private Main() {
    }

    public static void main(String[] args) {

        Box<Apple> boxApples1 = new Box<>(generateFruitList(new Apple(), 5));
        Box<Apple> boxApples2 = new Box<>(generateFruitList(new Apple(), 15));
        Box<Orange> boxOranges1 = new Box<>(generateFruitList(new Orange(), 5));
        Box<Orange> boxOranges2 = new Box<>(generateFruitList(new Orange(), 10));

        System.out.println("Вес коробки яблок №1: " + boxApples1.getWeight());
        System.out.println("Вес коробки яблок №2: " + boxApples2.getWeight());
        System.out.println("Вес коробки яблок №1 = весу корбки яблок №2? - " + boxApples1.compare(boxApples2));

        System.out.println("Вес коробки апельсин №1: " + boxOranges1.getWeight());
        System.out.println("Вес коробки апельсин №2: " + boxOranges2.getWeight());
        System.out.println("Вес коробки апельсин №2 = весу корбки яблок №2? - " + boxOranges2.compare(boxApples2));

        System.out.println();
        System.out.println("Вес коробки яблок №1: " + boxApples1.getWeight());
        System.out.println("Вес коробки яблок №2: " + boxApples2.getWeight());
        System.out.println("Пересыпаем яблоки в коробку №1 из коробки №2 ");
        boxApples1.moveFruitsOneBoxFromOther(boxApples2);
        System.out.println("Вес коробки яблок №1: " + boxApples1.getWeight());
        System.out.println("Вес коробки яблок №2: " + boxApples2.getWeight());

        //  boxOranges1.moveFruitsOneBoxFromOther(boxApples2); - ошибка компиляции: яблоки не могут быть добавлены к апельсинам
        System.out.println();
        System.out.println("Вес коробки апельсин №1 до добавления одного апельсина: " + +boxOranges1.getWeight());
        System.out.println("Вес одного апельсина: " + new Orange().getWeight());
        boxOranges1.addOneFruit(new Orange());
        System.out.println("Вес коробки апельсин №1 после добавления одного апельсина: " + +boxOranges1.getWeight());

        // boxApples1.addOneFruit(new Orange());  ошибка компиляции: апельсины не могут быть добавлены к яблокам
        System.out.println();
        System.out.println("Вес коробки яблок №1: " + boxApples1.getWeight());
        System.out.println("Вес коробки яблок №2: " + boxApples2.getWeight());
        ArrayList<Apple> addBatch1 = generateFruitList(new Apple(), 7);
        ArrayList<Apple> addBatch2 = generateFruitList(new Apple(), 5);
        System.out.printf("Добавляем в коробку яблок №1 козину из %d шт, а в корзину яблок №2 козину из %d шт %n",
                addBatch2.size(), addBatch1.size());
        boxApples1.addFruits(addBatch2);
        boxApples2.addFruits(addBatch1);
        System.out.println("Вес коробки яблок №1: " + boxApples1.getWeight());
        System.out.println("Вес коробки яблок №2: " + boxApples2.getWeight());

        ArrayList<Orange> addBatchOrange = generateFruitList(new Orange(), 25);

        // boxApples1.addFruits(addBatchOrange); апельсины не могут быть добавлены к яблокам
    }

    public static <T> ArrayList<T> generateFruitList(T fruit, int listSize) {
        ArrayList<T> fruits = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            fruits.add(fruit);
        }
        return fruits;
    }
}


