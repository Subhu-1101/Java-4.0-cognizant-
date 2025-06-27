import java.util.Arrays;
import java.util.Comparator;

public class SearchDemo {

    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String targetName) {
        int low = 0, high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(targetName);
            if (cmp == 0) return products[mid];
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }

        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Shirt", "Clothing"),
            new Product(3, "Mouse", "Electronics"),
            new Product(4, "Book", "Education"),
            new Product(5, "Phone", "Electronics")
        };

        System.out.println("🔍 Linear Search:");
        Product result1 = linearSearch(products, "Book");
        System.out.println(result1 != null ? result1 : "Product not found");

        System.out.println("\n📦 Sorting for Binary Search...");
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        System.out.println("🔍 Binary Search:");
        Product result2 = binarySearch(products, "Book");
        System.out.println(result2 != null ? result2 : "Product not found");
    }
}