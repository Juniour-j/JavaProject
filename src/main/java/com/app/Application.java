package com.app;

import com.models.*;
import org.springframework.context.annotation.ComponentScan;
import com.services.*;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

/**
 * Main application class for the Retail Purchase Management System.
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.*")
public class Application {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final StoreService storeService;
    private final CustomerService customerService;
    private final PurchaseService purchaseService;

    public Application(ProductService productService,
                       CategoryService categoryService,
                       StoreService storeService,
                       CustomerService customerService,
                       PurchaseService purchaseService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.storeService = storeService;
        this.customerService = customerService;
        this.purchaseService = purchaseService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Initialize test data for the shop system.
     */
    @PostConstruct
    public void initTestData() {
        // Create a category
        Category category = Category.builder()
                .name("Electronics")
                .build();
        category = categoryService.saveCategory(category);

        // Create a product
        Product product = Product.builder()
                .name("Smartphone")
                .price(599.99)
                .category(category)
                .build();
        product = productService.saveProduct(product);

        // Create a store
        Store store = Store.builder()
                .name("Tech World")
                .location("Main Street 123")
                .build();
        store = storeService.saveStore(store);

        // Create a customer
        Customer customer = Customer.builder()
                .name("Alice Johnson")
                .email("alice.johnson@example.com")
                .build();
        customer = customerService.saveCustomer(customer);

        // Create a purchase
        Purchase purchase = Purchase.builder()
                .customer(customer)
                .product(product)
                .purchaseDate(LocalDate.now())
                .build();
        purchaseService.savePurchase(purchase);

        System.out.println("Test data initialized successfully!");
    }
}
