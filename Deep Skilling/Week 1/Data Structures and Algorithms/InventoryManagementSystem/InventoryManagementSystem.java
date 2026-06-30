public class InventoryManagementSystem {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        Product p1 = new Product(101, "Laptop", 10, 55000);
        Product p2 = new Product(102, "Mouse", 50, 600);
        Product p3 = new Product(103, "Keyboard", 25, 1200);

        // Add Products
        inventory.addProduct(p1);
        inventory.addProduct(p2);
        inventory.addProduct(p3);

        System.out.println("\nInventory After Adding Products:");
        inventory.displayProducts();

        // Update Product
        inventory.updateProduct(102, "Wireless Mouse", 45, 850);

        System.out.println("\nInventory After Updating Product:");
        inventory.displayProducts();

        // Delete Product
        inventory.deleteProduct(101);

        System.out.println("\nInventory After Deleting Product:");
        inventory.displayProducts();
    }
}