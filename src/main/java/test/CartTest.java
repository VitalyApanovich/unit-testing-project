package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static test.RealItemTest.getRealItemWithValues;
import static test.VirtualItemTest.getVirtualItemWithValues;

class CartTest {
    private VirtualItem disk = getVirtualItemWithValues(new VirtualItem(),"Name", 25, 10000);
    private RealItem car = getRealItemWithValues(new RealItem(),2000, "auto", 2344);
    private Cart andrewCart = new Cart("andrew-cart");

    @BeforeEach
    void beforeMethod(){
        andrewCart.addRealItem(car);
        andrewCart.addVirtualItem(disk);
    }

    @Test
    void totalCartPriceTest() {
        double totalPrice = car.getPrice() + car.getPrice()*0.2 + disk.getPrice() + disk.getPrice()*0.2;
        assertEquals(totalPrice, andrewCart.getTotalPrice());
    }



}
