package hw2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private int size;
    private int maxSize;

    HashMap<Product, Integer> machine;

    VendingMachine(int maxSize) {
        machine = new HashMap<>();
        this.maxSize = maxSize;
        size = 0;
    }

    public void getAssortment() {
        if (!machine.isEmpty()) {
            System.out.println(machine.keySet().toString().replaceAll("[\\[\\]]", ""));
        } else {
            System.out.println("Автомат пуст");
        }
    }

    private boolean checkVendingMachine() {
        if (size < maxSize) {
            return true;
        } else {
            return false;
        }
    }

    public void addProduct(Product someProduct) {
        if (checkVendingMachine()) {
            if (machine.containsKey(someProduct)) {
                machine.put(someProduct, (machine.get(someProduct) + 1));
            } else {
                machine.put(someProduct, 1);
            }
            size++;
            System.out.println("Товар добавлен");
        } else {
            System.out.println("Автомат переполнен");
        }
    }

    public void buyProduct(Product someProduct) {
        if (!machine.isEmpty()) {
            if (machine.containsKey(someProduct)) {
                if ((machine.get(someProduct)) == 1) {
                    machine.remove(someProduct);
                } else {
                    machine.put(someProduct, machine.get(someProduct) - 1);
                }
                System.out.println("Получите свой товар");
                size--;
            } else {
                System.out.println("Товара нет в автомате");
            }
        } else {
            System.out.println("Автомат пуст");
        }
    }

}