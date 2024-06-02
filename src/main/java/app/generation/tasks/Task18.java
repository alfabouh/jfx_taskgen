package app.generation.tasks;

import app.JFXMain;
import app.generation.ITask;
import javafx.util.Pair;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.integration.IterativeLegendreGaussIntegrator;

import java.util.Random;

public class Task18 implements ITask {
    @Override
    public String getTheme() {
        return "Тип 18";
    }

    @SuppressWarnings("all")
    @Override
    public Pair<String, String> genRandomTaskTextSolution(Random random) {
        return JFXMain.random.nextBoolean() ? this.type1() : this.type2();
    }

    @SuppressWarnings("all")
    private Pair<String, String> type1() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Дана плотность вероятности f(x) непрерывной случайной величины X, имеющая две ненулевые составляющие формулы. Требуется:");
        stringBuilder.append("\n");
        stringBuilder.append("1) проверить свойство нормировки");
        stringBuilder.append("\n");
        stringBuilder.append("2) построить график f(x)");
        stringBuilder.append("\n");
        stringBuilder.append("3) найти функцию распределения F(x)");
        stringBuilder.append("\n");
        stringBuilder.append("4) найти Р(a <= X <= b) для данных a, b");

        stringBuilder.append("\n");
        stringBuilder.append("       | 0, x <= 0");
        stringBuilder.append("\n");
        stringBuilder.append("F(x) = | x/8, 0 < x <= 2");
        stringBuilder.append("\n");
        stringBuilder.append("       | 1, 2 < x <= 11/4");
        stringBuilder.append("\n");
        stringBuilder.append("       | 0, x > 11/4");
        stringBuilder.append("\na = 1; b = 2,5");

        UnivariateFunction integrand3 = new UnivariateFunction() {
            @Override
            public double value(double x) {
                return (x * x) / 8.0f;
            }
        };

        UnivariateFunction integrand4 = new UnivariateFunction() {
            @Override
            public double value(double x) {
                return x;
            }
        };

        UnivariateFunction integrand5 = new UnivariateFunction() {
            @Override
            public double value(double x) {
                return (x * x * x) / 8.0f;
            }
        };

        UnivariateFunction integrand6 = new UnivariateFunction() {
            @Override
            public double value(double x) {
                return x * x;
            }
        };


        IterativeLegendreGaussIntegrator integrator = new IterativeLegendreGaussIntegrator(5, 1.0e-9, 1.0e-9);
        double result = 2.5f - (7.0f / 4.0f);

        double result3 = integrator.integrate(Integer.MAX_VALUE, integrand3, 0, 2);
        double result4 = integrator.integrate(Integer.MAX_VALUE, integrand4, 2, 11.0f / 4.0f);

        double result5 = integrator.integrate(Integer.MAX_VALUE, integrand5, 0, 2);
        double result6 = integrator.integrate(Integer.MAX_VALUE, integrand6, 2, 11.0f / 4.0f);

        double M = result3 + result4;
        double D = (result5 + result6) - Math.pow(M, 2);
        double c = Math.sqrt(D);

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("\n");
        stringBuilder2.append("       | 0, x <= 0");
        stringBuilder2.append("\n");
        stringBuilder2.append("F(x) = | x^2/16, 0 < x <= 2");
        stringBuilder2.append("\n");
        stringBuilder2.append("       | x-7/4, 2 < x <= 11/4");
        stringBuilder2.append("\n");
        stringBuilder2.append("       | 0, x > 11/4");
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("P(a < x < b) = %.2f", result));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("M(X) = %.2f", M));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("D(X) = %.2f", D));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("σ(X) = %.2f", c));

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }

    @SuppressWarnings("all")
    private Pair<String, String> type2() {
        double b = 1.5f;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Дана плотность вероятности f(x) непрерывной случайной величины X, имеющая две ненулевые составляющие формулы. Требуется:");
        stringBuilder.append("\n");
        stringBuilder.append("1) проверить свойство нормировки");
        stringBuilder.append("\n");
        stringBuilder.append("2) построить график f(x)");
        stringBuilder.append("\n");
        stringBuilder.append("3) найти функцию распределения F(x)");
        stringBuilder.append("\n");
        stringBuilder.append("4) найти Р(a <= x <= b) для данных a, b");

        stringBuilder.append("\n");
        stringBuilder.append("       | 0, x <= 0");
        stringBuilder.append("\n");
        stringBuilder.append("F(x) = | x, 0 < x <= 1");
        stringBuilder.append("\n");
        stringBuilder.append("       | -x+2, 1 < x <= 2");
        stringBuilder.append("\n");
        stringBuilder.append("       | 0, x > 2");
        stringBuilder.append("\n a = -1; b = 1,5");

        UnivariateFunction integrand = new UnivariateFunction() {
            @Override
            public double value(double x) {
                return -(x * x) / 2 + 2 * x - 1;
            }
        };

        UnivariateFunction integrand3 = new UnivariateFunction() {
            @Override
            public double value(double x) {
                return x * x;
            }
        };

        UnivariateFunction integrand4 = new UnivariateFunction() {
            @Override
            public double value(double x) {
                return x * (-x + 2);
            }
        };

        UnivariateFunction integrand5 = new UnivariateFunction() {
            @Override
            public double value(double x) {
                return (x * x * x);
            }
        };

        UnivariateFunction integrand6 = new UnivariateFunction() {
            @Override
            public double value(double x) {
                return x * x * (-x + 2);
            }
        };


        IterativeLegendreGaussIntegrator integrator = new IterativeLegendreGaussIntegrator(5, 1.0e-9, 1.0e-9);
        double result = - ((b * b) / 2.0f) + 2.0f * b - 1.0f;

        double result3 = integrator.integrate(Integer.MAX_VALUE, integrand3, 0, 1);
        double result4 = integrator.integrate(Integer.MAX_VALUE, integrand4, 1, 2);

        double result5 = integrator.integrate(Integer.MAX_VALUE, integrand5, 0, 1);
        double result6 = integrator.integrate(Integer.MAX_VALUE, integrand6, 1, 2);

        double M = result3 + result4;
        double D = (result5 + result6) - Math.pow(M, 2);
        double c = Math.sqrt(D);

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("\n");
        stringBuilder2.append("       | 0, x <= 0");
        stringBuilder2.append("\n");
        stringBuilder2.append("F(x) = | x^2/2, 0 < x <= 1");
        stringBuilder2.append("\n");
        stringBuilder2.append("       | -x^2/2+2x-1, 1 < x <= 2");
        stringBuilder2.append("\n");
        stringBuilder2.append("       | 1, x > 2");
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("P(a < x < b) = %.2f", result));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("M(x) = %.2f", M));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("D(x) = %.2f", D));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("σ(x) = %.2f", c));

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }
}