import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    Product item1 = new Product(1, "Хлеб", 60);
    Product item2 = new Product(2, "Молоко", 100);
    Product item3 = new Product(3, "Майонез", 90);
    Product item4 = new Product(3, "Масло", 200);

    @Test
    void removeUnExistingElementById() {
        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(4);
        });
    }

    @Test
    void removeExistingElementById() {
        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.remove(2);

        Product[] expected = {item1, item3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void addItemAfterRemoveById() {
        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.remove(3);
        repo.add(item4);

        Product[] expected = {item1, item2, item4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void addElementWithAlreadyExistingId() {
        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(item4);
        });
    }
}