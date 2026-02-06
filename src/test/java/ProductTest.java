import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product item1 = new Product(1, "Хлеб", 60);
    Product item2 = new Product(2, "Молоко", 100);
    Product item3 = new Product(3, "Майонез", 90);
    Product item4 = new Product(4, "Масло", 200);
    Product item5 = new Product(4, "Масло", 200);
    Product item6 = new Product(5, "Мыло", 100);
    Product item7 = new Product(5, "Мыло", 200);
    Product item8 = new Product(5, "Шампунь", 200);


    @Test
    void testEqualsIsReflexive() {

        Assertions.assertTrue(item1.equals(item1));

    }

    @Test
    void testEqualsSymmetric() {

        Assertions.assertTrue(item4.equals(item5));
        Assertions.assertTrue(item5.equals(item4));

        Assertions.assertFalse(item2.equals(item3));
        Assertions.assertFalse(item3.equals(item2));

        Assertions.assertFalse(item7.equals(item8));
        Assertions.assertFalse(item8.equals(item7));

        Assertions.assertFalse(item6.equals(item7));
        Assertions.assertFalse(item7.equals(item6));

    }

    @Test
    void testEqualsHandLessNull() {

        Assertions.assertFalse(item1.equals(null));

    }

    @Test
    void equalsComparesWithDifferentClass() {

        String someString = "Молоко";
        Assertions.assertFalse(item1.equals(someString));
    }
}