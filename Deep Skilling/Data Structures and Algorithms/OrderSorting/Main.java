public class Main {

    public static void main(String[] args) {

        Order[] orders = {
            new Order(101, "Arun", 2500),
            new Order(102, "Bala", 1500),
            new Order(103, "Charan", 5000),
            new Order(104, "Divya", 3000),
            new Order(105, "Elan", 1000)
        };

        System.out.println("=== BUBBLE SORT (By Total Price) ===");

        Order[] bubbleArray = orders.clone();
        SortAlgorithms.bubbleSort(bubbleArray);

        for (Order o : bubbleArray) {
            System.out.println(o);
        }

        System.out.println("\n=== QUICK SORT (By Total Price) ===");

        Order[] quickArray = orders.clone();
        SortAlgorithms.quickSort(quickArray, 0, quickArray.length - 1);

        for (Order o : quickArray) {
            System.out.println(o);
        }
    }
}