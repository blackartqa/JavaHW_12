package ru.netology.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {

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

    @BeforeEach
    public void setUp() {
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);
        repository.save(smartphone4);
        repository.save(smartphone5);
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);
        repository.save(book5);
    }

    @Test
    void shouldRemoveById() {
        int idToRemove = 1003;
        repository.removeById(idToRemove);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{smartphone1, smartphone2, smartphone3, smartphone4, smartphone5, book1, book2, book4, book5};
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldRemoveByIdWhenIdNotFound(){
        int idToRemove = 3001;
        Exception e = assertThrows(NotFoundException.class, () -> repository.removeById(idToRemove));
        System.out.println(e.getMessage());
        e.printStackTrace();
    }
}
