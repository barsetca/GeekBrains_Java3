package lesson01generics.task03;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    public ArrayList<T> fruitOneTypeBox = new ArrayList<>();

    public Box(ArrayList<T> fruitOneTypeBox) {
        this.fruitOneTypeBox = fruitOneTypeBox;
    }

    public Box(T fruit) {
        this.fruitOneTypeBox.add(fruit);
    }


    public ArrayList<T> getFruitOneTypeBox() {
        return fruitOneTypeBox;
    }

    public <T extends Fruit> boolean compare(Box<T> box) {
        return this.getWeight() == box.getWeight();
    }

    public float getWeight() {
        List<T> boxT = this.getFruitOneTypeBox();
        if (boxT.isEmpty()) {
            return 0;
        }
        return boxT.get(0).getWeight() * boxT.size();

    }

    public void addOneFruit(T fruit) {
        ArrayList<T> list = this.getFruitOneTypeBox();
        list.add(fruit);
    }

    public void addFruits(ArrayList<T> batch) {
        this.getFruitOneTypeBox().addAll(batch);
    }

    public void moveFruitsOneBoxFromOther(Box<T> box) {
        this.getFruitOneTypeBox().addAll(box.getFruitOneTypeBox());
        box.fruitOneTypeBox.clear();
    }


}
