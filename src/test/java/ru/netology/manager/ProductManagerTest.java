package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.domain.Book;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assumptions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book book1 = new Book (1, "Дети капитана Гранта", 789, "Жюль Верн");
    private Book book2 = new Book(2,"Парфюмер", 456, "Патрик Зюскинд");
    private Book book3 = new Book (3, "Вокруг света за 80 дней", 321, "Жюль Верн");
    private Smartphone smartphone1 = new Smartphone(1, "Apple", 45000, "China");
    private Smartphone smartphone2 = new Smartphone(2, "Samsung", 20000,"Japan");


    @BeforeEach
    public void setUp() {
        manager = new ProductManager(repository);
        manager.productAdd(book1);
        manager.productAdd(book2);
        manager.productAdd(smartphone1);
        manager.productAdd(smartphone2);
    }

    @Test
    void shouldSearchBookByAuthorIfExists (){
        String text = "Патрик Зюскинд";
        Product[] expected = new Product[]{book2};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotSearchBookByAuthorIfNotExists (){
        String text = "Дж.К.Роулинг";
        Book[] expected = new Book[]{};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookByNameIfExists (){
        String text = "Дети капитана Гранта";
        Product [] expected = new Product[]{book1};
        Product [] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotSearchBookByNameIfNotExists (){
        String text = "Мастер и Маргарита";
        Product [] expected = new Book[]{};
        Product [] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByNameIfExists (){
        String text = "Apple";
        Product[] expected = new Product[]{smartphone1};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotSearchSmartphoneByNameIfNotExists (){
        String text = "Xiaomi";
        Smartphone[] expected = new Smartphone[]{};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByManufacturerIfExists () {
        String text = "Japan";
        Product[] expected = new Product[]{smartphone2};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotSearchSmartphoneByManufacturerIfNotExists (){
        String text = "USA";
        Product [] expected = new Smartphone[]{};
        Product [] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchProductWithSameAuthor (){
        manager.productAdd(book3);
        String text = "Жюль Верн";
        Product[] expected = new Product[]{book1, book3};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

}