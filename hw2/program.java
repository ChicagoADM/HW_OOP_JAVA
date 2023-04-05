package hw2;

import java.util.HashMap;

import javax.swing.UIDefaults.ProxyLazyValue;

public class program {

    public static void main(String[] args) {
        VendingMachine automat = new VendingMachine(5);
        Product product1 = new Product("Apple", 40.50);
        Product product2 = new Product("Chocolate", 89.99);
        Product product3 = new Product("Water", 50.00);
        automat.addProduct(product1);
        automat.addProduct(product2);
        automat.addProduct(product2);
        automat.addProduct(product2);
        automat.addProduct(product3);
        automat.addProduct(product3);
        automat.getAssortment();
        automat.buyProduct(product1);
        automat.getAssortment();
        automat.buyProduct(product1);
    }

}
