import java.util.HashMap;

public class Inventory {

    private final HashMap<Integer, Product> inventory;

    public Inventory() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {

        if (inventory.containsKey(product.getProductId())) {
            System.out.println("Product already exists.");
        } else {
            inventory.put(product.getProductId(), product);
            System.out.println("Product added successfully.");
        }
    }

    public void updateProduct(int id, String name, int quantity, double price) {

        Product product = inventory.get(id);

        if (product != null) {
            product.setProductName(name);
            product.setQuantity(quantity);
            product.setPrice(price);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(int id) {

        if (inventory.remove(id) != null) {
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void displayProducts() {

        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        for (Product product : inventory.values()) {
            System.out.println("--------------------------");
            System.out.println(product);
        }
    }
}