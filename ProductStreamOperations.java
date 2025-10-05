import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.Optional;

class Product {
    private String name;
    private double price;
    private String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return String.format("%s (%.2f) - %s", name, price, category);
    }
}

public class ProductStreamOperations {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 80000, "Electronics"),
            new Product("Mobile", 50000, "Electronics"),
            new Product("Shirt", 2000, "Clothing"),
            new Product("Jeans", 3000, "Clothing"),
            new Product("Apple", 150, "Grocery"),
            new Product("Milk", 60, "Grocery")
        );

     System.out.println("\nProducts Grouped by Category:");
        Map<String, List<Product>> grouped = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
        grouped.forEach((category, list) -> {
            System.out.println(category + ": " + list);
        });

        System.out.println("\nMost Expensive Product in Each Category:");
        Map<String, Optional<Product>> maxPriceByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))));
        maxPriceByCategory.forEach((category, prod) ->
            System.out.println(category + ": " + prod.orElse(null))
        );

       
        double avgPrice = products.stream()
                .collect(Collectors.averagingDouble(Product::getPrice));
        System.out.println("\nAverage Price of All Products: " + avgPrice);
    }
}
