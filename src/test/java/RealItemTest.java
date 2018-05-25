import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import shop.RealItem;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RealItemTest {
    private RealItem car;
    private int weight = 1560;
    private String carName = "Audi";
    private double price = 32026.9;

    @BeforeEach
    void beforeMethod(){
        car = getRealItemWithValues(new RealItem(), weight, carName, price);
    }

    @Tag("Business")
    @Test
    void toStringMethodContainsWeightInfoTest() {
        assertTrue(car.toString().contains("Weight: " + Integer.toString(weight)));
    }

    static RealItem getRealItemWithValues(RealItem item, int weight, String carName, double price) {
        item.setName(carName);
        item.setPrice(price);
        item.setWeight(weight);
        return item;
    }
}
