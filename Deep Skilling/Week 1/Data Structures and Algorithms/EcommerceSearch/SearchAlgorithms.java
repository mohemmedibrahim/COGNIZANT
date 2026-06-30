public class SearchAlgorithms {

    // Linear Search
    public static int linearSearch(Product[] products, String targetName) {

        for (int i = 0; i < products.length; i++) {
            if (products[i].productName.equalsIgnoreCase(targetName)) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search (array must be sorted by productName)
    public static int binarySearch(Product[] products, String targetName) {

        int left = 0;
        int right = products.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            int compare = products[mid].productName.compareToIgnoreCase(targetName);

            if (compare == 0) {
                return mid;
            }

            if (compare < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    // Utility: sort by product name (for binary search)
    public static void sortByName(Product[] products) {

        for (int i = 0; i < products.length - 1; i++) {
            for (int j = 0; j < products.length - i - 1; j++) {

                if (products[j].productName.compareToIgnoreCase(products[j + 1].productName) > 0) {

                    Product temp = products[j];
                    products[j] = products[j + 1];
                    products[j + 1] = temp;
                }
            }
        }
    }
}