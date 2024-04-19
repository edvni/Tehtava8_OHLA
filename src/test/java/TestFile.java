import org.example.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFile {

    private Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0:00:00",
            "3661, 1:01:01",
            "3600, 1:00:00",
            "-100, -1",
            "32000, 8:53:20",
            "59, 0:00:59",
            "60, 0:01:00",
            "36000, 10:00:00",
            "86399, 23:59:59",
            "86400, 24:00:00",
            "172799, 47:59:59",
            "320001, -1",
    })
    void testSecToTime(int input, String expected) {
        String result = main.secToTime(input);
        assertEquals(expected, result);
    }
}
