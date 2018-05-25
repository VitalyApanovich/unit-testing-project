package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shop.VirtualItem;

import static org.junit.jupiter.api.Assertions.assertTrue;

class VirtualItemTest {
    private VirtualItem disk;
    private String diskName = "Windows";
    private int price = 11;
    private int sizeOnDisk = 20000;

    @BeforeEach
    void beforeMethod(){
        disk = getVirtualItemWithValues(new VirtualItem(), diskName, price, sizeOnDisk);
    }

    @Test
    void toStringMethodContainsSizeInfoTest() {
        assertTrue(disk.toString().contains("Size on disk: " + Integer.toString(sizeOnDisk)));
    }

    static VirtualItem getVirtualItemWithValues(VirtualItem item, String diskName, int price, int sizeOnDisk) {
        item.setName(diskName);
        item.setPrice(price);
        item.setSizeOnDisk(sizeOnDisk);
        return item;
    }
}
