import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import shop.RealItem;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RealItemTest {
    private RealItem car;
    private double weight = 1560;
    private static final String CAR_NAME = "Audi";
    private static final double PRICE = 32026.9;

    @BeforeEach
    void beforeMethod() {
        car = getRealItemWithValues(new RealItem(), weight, CAR_NAME, PRICE);
    }

    @Tag("Business")
    @Test
    void toStringMethodOutputInfoTest() {
        assertEquals(car.toString(), "Class: " + car.getClass() + "; Name: " + CAR_NAME + "; Price: " +
                Double.toString(PRICE) + "; Weight: " + Double.toString(weight));
    }

    static RealItem getRealItemWithValues(RealItem item, double weight, String carName, double price) {
        item.setName(carName);
        item.setPrice(price);
        item.setWeight(weight);
        return item;
    }
}
