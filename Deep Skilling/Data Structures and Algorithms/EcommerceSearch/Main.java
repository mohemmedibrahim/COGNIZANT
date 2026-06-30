public class Main {

    public static void main(String[] args) {

        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Fashion"),
            new Product(103, "Phone", "Electronics"),
            new Product(104, "Watch", "Accessories"),
            new Product(105, "Tablet", "Electronics")
        };

        System.out.println("=== LINEAR SEARCH ===");
        int result1 = SearchAlgorithms.linearSearch(products, "Phone");

        if (result1 != -1)
            System.out.println("Found: " + products[result1]);
        else
            System.out.println("Product not found");

        // Sort before binary search
        SearchAlgorithms.sortByName(products);

        System.out.println("\n=== BINARY SEARCH ===");
        int result2 = SearchAlgorithms.binarySearch(products, "Phone");

        if (result2 != -1)
            System.out.println("Found: " + products[result2]);
        else
            System.out.println("Product not found");
    }
}