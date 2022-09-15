package org.tonkushin;

/**
 * Класс для решения квадратных уравнений ax^2+bx+c = 0 (a≠0)
 */
public class Solver {
    public static String aShouldBeNotZeroMessage = "а не может быть равен 0";
    public static String abcShouldBeANumber = "a, b, c должны быть числами";

    public double[] solve(double a, double b, double c, double range) {
        if (a < range && a > -1 * range) {
            throw new RuntimeException(aShouldBeNotZeroMessage);
        }

        if (Double.isNaN(a) || Double.isNaN(b) || Double.isNaN(c) || Double.isNaN(range)) {
            throw new RuntimeException(abcShouldBeANumber);
        }

        double d = b * b - 4 * a * c;   // дискриминант

        if (d < -1 * range) {
            return new double[0];       // нет корней
        }

        if (d > range) {
            return new double[]{(-b + Math.sqrt(d)) / (2 * a), (-b - Math.sqrt(d)) / (2 * a)};    // 2 корня
        }

        return new double[]{-b / (2 * a), -b / (2 * a)};    // 1 корень
    }
}
