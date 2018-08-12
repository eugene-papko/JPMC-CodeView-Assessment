import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBalancedSmileys {

    @Test
    public void test1() {
        String expected = "YES";
        String actual = BalancedSmileys.checkIfBalanced("(:)");
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String expected = "NO";
        String actual = BalancedSmileys.checkIfBalanced(")(");
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        String expected = "YES";
        String actual = BalancedSmileys.checkIfBalanced("i am sick today (:()");
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        String expected = "YES";
        String actual = BalancedSmileys.checkIfBalanced("hacker cup: started :):)");
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        String expected = "NO";
        String actual = BalancedSmileys.checkIfBalanced(":))");
        assertEquals(expected, actual);
    }

    @Test
    public void test6() {
        String expected = "YES";
        String actual = BalancedSmileys.checkIfBalanced("(:))");
        assertEquals(expected, actual);
    }

    @Test
    public void test7() {
        String expected = "YES";
        String actual = BalancedSmileys.checkIfBalanced(" ((testing)hard:(is:)my:( ) credo");
        assertEquals(expected, actual);
    }

    @Test
    public void test8() {
        String expected = "NO";
        String actual = BalancedSmileys.checkIfBalanced(" ) should fail :()");
        assertEquals(expected, actual);
    }

    @Test
    public void test9() {
        String expected = "YES";
        String actual = BalancedSmileys.checkIfBalanced("(((((::(:):():))))):");
        assertEquals(expected, actual);
    }

    @Test
    public void test10() {
        String expected = "YES";
        String actual = BalancedSmileys.checkIfBalanced(":(((((::(:):():)))))");
        assertEquals(expected, actual);
    }

    @Test
    public void test11() {
        String expected = "YES";
        String actual = BalancedSmileys.checkIfBalanced(":(:(:()");
        assertEquals(expected, actual);
    }

    @Test
    public void test12() {
        String expected = "NO";
        String actual = BalancedSmileys.checkIfBalanced(":):((:))((((");
        assertEquals(expected, actual);
    }

    @Test
    public void test13() {
        String expected = "NO";
        String actual = BalancedSmileys.checkIfBalanced(":):)(((");
        assertEquals(expected, actual);
    }
}