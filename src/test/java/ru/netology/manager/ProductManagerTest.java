package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;
import ru.netology.manager.ProductManager;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    @Test
    void shouldSearchByNameBook() {

        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1001, "Book1", 10, "Author1");
        Book book2 = new Book(1002, "Book2", 12, "Author2");
        Book book3 = new Book(1003, "Book3", 20, "Author3");
        Book book4 = new Book(1004, "Book4", 11, "Author2");
        Book book5 = new Book(1005, "Book5", 19, "Author4");

        for (Book book : Arrays.asList(book1, book2, book3, book4, book5)) {
            manager.add(book);
        }
        Product[] actual = manager.searchBy("Book1");
        Product[] expected = new Product[]{book1};
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSearchByAuthorBook() {

        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1001, "Book1", 10, "Author1");
        Book book2 = new Book(1002, "Book2", 12, "Author2");
        Book book3 = new Book(1003, "Book3", 20, "Author3");
        Book book4 = new Book(1004, "Book4", 11, "Author2");
        Book book5 = new Book(1005, "Book5", 19, "Author4");

        for (Book book : Arrays.asList(book1, book2, book3, book4, book5)) {
            manager.add(book);
        }
        Product[] actual = manager.searchBy("Author4");
        Product[] expected = new Product[]{book5};
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSearchByAuthorTwoBook() {

        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Book book1 = new Book(1001, "Book1", 10, "Author1");
        Book book2 = new Book(1002, "Book2", 12, "Author2");
        Book book3 = new Book(1003, "Book3", 20, "Author3");
        Book book4 = new Book(1004, "Book4", 11, "Author2");
        Book book5 = new Book(1005, "Book5", 19, "Author4");

        for (Book book : Arrays.asList(book1, book2, book3, book4, book5)) {
            manager.add(book);
        }
        Product[] actual = manager.searchBy("Author2");
        Product[] expected = new Product[]{book2, book4};
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSearchByModelSmartphone() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Smartphone smartphone1 = new Smartphone(2001, "A50", 149, "Samsung");
        Smartphone smartphone2 = new Smartphone(2002, "S10", 349, "Samsung");
        Smartphone smartphone3 = new Smartphone(2003, "XS Max", 499, "Apple");
        Smartphone smartphone4 = new Smartphone(2004, "12 mini", 449, "Apple");
        Smartphone smartphone5 = new Smartphone(2005, "Mi10", 249, "Xiaomi");
        for (Smartphone smartphone : Arrays.asList(smartphone1, smartphone2, smartphone3, smartphone4, smartphone5)) {
            manager.add(smartphone);
        }
        Product[] actual = manager.searchBy("Xiaomi");
        Product[] expected = new Product[]{smartphone5};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByModelTwoSmartphone() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Smartphone smartphone1 = new Smartphone(2001, "A50", 149, "Samsung");
        Smartphone smartphone2 = new Smartphone(2002, "S10", 349, "Samsung");
        Smartphone smartphone3 = new Smartphone(2003, "XS Max", 499, "Apple");
        Smartphone smartphone4 = new Smartphone(2004, "12 mini", 449, "Apple");
        Smartphone smartphone5 = new Smartphone(2005, "Mi10", 249, "Xiaomi");
        for (Smartphone smartphone : Arrays.asList(smartphone1, smartphone2, smartphone3, smartphone4, smartphone5)) {
            manager.add(smartphone);
        }
        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = new Product[]{smartphone1, smartphone2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNameSmartphone() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Smartphone smartphone1 = new Smartphone(2001, "A50", 149, "Samsung");
        Smartphone smartphone2 = new Smartphone(2002, "S10", 349, "Samsung");
        Smartphone smartphone3 = new Smartphone(2003, "XS Max", 499, "Apple");
        Smartphone smartphone4 = new Smartphone(2004, "12 mini", 449, "Apple");
        Smartphone smartphone5 = new Smartphone(2005, "Mi10", 249, "Xiaomi");
        for (Smartphone smartphone : Arrays.asList(smartphone1, smartphone2, smartphone3, smartphone4, smartphone5)) {
            manager.add(smartphone);
        }
        Product[] actual = manager.searchBy("S10");
        Product[] expected = new Product[]{smartphone2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAllArgs() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Smartphone smartphone1 = new Smartphone(2001, "A50", 149, "Samsung");
        Smartphone smartphone2 = new Smartphone(2002, "S10", 349, "Samsung");
        Smartphone smartphone3 = new Smartphone(2003, "XS Max", 499, "Apple");
        Smartphone smartphone4 = new Smartphone(2004, "12 mini", 449, "Apple");
        Smartphone smartphone5 = new Smartphone(2005, "Mi10", 249, "Xiaomi");
        Book book1 = new Book(1001, "Book1", 10, "Author1");
        Book book2 = new Book(1002, "Book2", 12, "Author2");
        Book book3 = new Book(1003, "Book3", 20, "Author3");
        Book book4 = new Book(1004, "Book4", 11, "Author2");
        Book book5 = new Book(1005, "Samsung", 19, "Author4");
        for (Smartphone smartphone : Arrays.asList(smartphone1, smartphone2, smartphone3, smartphone4, smartphone5)) {
            manager.add(smartphone);
        }
        for (Book book : Arrays.asList(book1, book2, book3, book4, book5)) {
            manager.add(book);
        }

        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = new Product[]{smartphone1, smartphone2, book5};
        assertArrayEquals(expected, actual);
    }
}