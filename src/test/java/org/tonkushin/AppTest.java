package org.tonkushin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * 3. Написать тест, который проверяет, что для уравнения x^2+1 = 0 корней нет (возвращается пустой массив)
     */
    @Test
    void testNoRoots() {
        Solver solver = new Solver();
        double[] result = solver.solve(1.0, 0, 1.0, 1e-5);
        Assertions.assertEquals(0, result.length);
    }

    /**
     * 5. Написать тест, который проверяет, что для уравнения x^2-1 = 0 есть два корня кратности 1 (x1=1, x2=-1)
     */
    @Test
    void testTwoRoots() {
        Solver solver = new Solver();
        double[] result = solver.solve(1.0, 0, -1.0, 1e-5);

        Assertions.assertEquals(2, result.length);
        Assertions.assertEquals(1, Math.abs(result[0]));
        Assertions.assertEquals(1, Math.abs(result[1]));
    }

    /**
     * 7. Написать тест, который проверяет, что для уравнения x^2+2x+1 = 0 есть один корень кратности 2 (x1= x2 = -1).
     */
    @Test
    void testOneRoot() {
        Solver solver = new Solver();
//        double[] result = solver.solve(1.0, 2.0, 1, 1e-5);
        double[] result = solver.solve(1e-4, 1e-5, 1e-5, 1e-8);
        Assertions.assertEquals(2, result.length);
        Assertions.assertEquals(result[0], result[1]);
    }

    /**
     * 9. Написать тест, который проверяет, что коэффициент a не может быть равен 0. В этом случае solve выбрасывает исключение.
     * Примечание. Учесть, что a имеет тип double и сравнивать с 0 через == нельзя.
     */
    @Test
    void testAisNotZero() {
        Solver solver = new Solver();

        RuntimeException thrown = Assertions.assertThrows(
                RuntimeException.class,
                ()-> solver.solve(1e-6, 2.0, 1, 1e-5)
        );
        Assertions.assertTrue(thrown.getMessage().contains(Solver.aShouldBeNotZeroMessage));
    }

    /**
     * 13. Посмотреть какие еще значения могут принимать числа типа double,
     * кроме числовых и написать тест с их использованием на все коэффициенты.
     * solve должен выбрасывать исключение.
     */
    @Test
    void testAisNotNaN(){
        Solver solver = new Solver();

        RuntimeException thrown = Assertions.assertThrows(
                RuntimeException.class,
                ()-> solver.solve(Double.NaN, Double.NaN, Double.NaN, 1e-5)
        );
        Assertions.assertTrue(thrown.getMessage().contains(Solver.abcShouldBeANumber));
    }
}
