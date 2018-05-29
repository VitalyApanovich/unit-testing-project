import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import parser.JsonParser;
import shop.Cart;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParserTest {
    private static final String CART_NAME = "test";
    private JsonParser jpClass;
    private File file;

    @BeforeEach
    void beforeMethod() {
        jpClass = new JsonParser();
        String pathName = "src/main/resources/" + CART_NAME + ".json";
        file = new File(pathName);
    }

    @AfterEach
    void afterMethod() {
        try {
            java.nio.file.Files.deleteIfExists(Paths.get(file.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void readFromFileReturnsCartClassTest() {
        jpClass.writeToFile(new Cart(CART_NAME));
        assertEquals(Cart.class, jpClass.readFromFile(file).getClass());
    }

    @Tag("unit")
    @Disabled
    @Test
    void readFromFileExpectsFileClassTest() {
        String invalidPth1 = "invalid path";
        String invalidPth2 = "";
        Throwable throwable1 = assertThrows(parser.NoSuchFileException.class, () -> jpClass.readFromFile(new File(invalidPth1)));
        Throwable throwable2 = assertThrows(parser.NoSuchFileException.class, () -> jpClass.readFromFile(new File(invalidPth2)));
        assertAll(
                () -> assertEquals(throwable1.getMessage(), "File " + invalidPth1 + ".json not found!"),
                () -> assertEquals(throwable2.getMessage(), "File " + invalidPth2 + ".json not found!")
        );
    }

    @Tag("unit")
    @Test
    void writeToFileReturnsExpectedCartNameTest() {
        jpClass.writeToFile(new Cart(CART_NAME));
        assertEquals(CART_NAME, jpClass.readFromFile(file).getCartName());
    }

    @Tag("unit")
    @ParameterizedTest()
    @ValueSource(strings = {":", "<", ">", "?", "*"})
    void writeToFileHandlesReservedCharactersGracefullyTest(String inputParam) {
        jpClass.writeToFile(new Cart(inputParam));
        assertThrows(parser.NoSuchFileException.class, () -> jpClass.readFromFile(new File("src/main/resources/" + inputParam + ".json")));
    }
}