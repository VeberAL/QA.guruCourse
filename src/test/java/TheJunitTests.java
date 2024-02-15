import org.junit.jupiter.api.*;

public class TheJunitTests {
    int result;

    @BeforeAll
    static void Alls() {
        System.out.println("### beforeall");
    }

    @BeforeEach
    void Eachs() {
        System.out.println("### vv");
        result = getResult();
    }

    private int getResult() {
        return 3;
    }

    @Test
    void firstTest() {
        Assertions.assertTrue(result > 2);
        System.out.println("###  firstTest");
    }

    @Test
    void secondTest() {
        Assertions.assertTrue(result > 2);
        System.out.println("###  secondTest");
    }

    @AfterEach
    void aftEachs() {
        System.out.println("### vvc");
        result = 0;
    }

    @AfterAll
    static void aftAlls() {
        System.out.println("### afterall");
    }
}
