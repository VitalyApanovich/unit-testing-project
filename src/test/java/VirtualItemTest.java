import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import shop.VirtualItem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VirtualItemTest {
    private VirtualItem disk;
    private static final String DISK_NAME = "Windows";
    private static final double PRICE = 11;
    private static final int SIZE_ON_DISK = 20000;

    @BeforeEach
    void beforeMethod() {
        disk = getVirtualItemWithValues(new VirtualItem(), DISK_NAME, PRICE, SIZE_ON_DISK);
    }

    @Tag("Business")
    @Test
    void toStringMethodContainsSizeInfoTest() {
        assertTrue(disk.toString().contains("Size on disk: " + Integer.toString(SIZE_ON_DISK)));
        assertEquals(disk.toString(), "Class: " + disk.getClass() + "; Name: " + DISK_NAME + "; Price: " +
                Double.toString(PRICE) + "; Size on disk: " + Double.toString(SIZE_ON_DISK), "'toString' method of " +
        String.format("%s class contains incorrect info.", disk.getClass()));
    }

    static VirtualItem getVirtualItemWithValues(VirtualItem item, String diskName, double price, int sizeOnDisk) {
        item.setName(diskName);
        item.setPrice(price);
        item.setSizeOnDisk(sizeOnDisk);
        return item;
    }
}
