package app.generation.tasks;

import app.JFXMain;
import app.generation.ITask;
import javafx.util.Pair;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.integration.IterativeLegendreGaussIntegrator;

import java.util.Random;

public class Task17 implements ITask {
    @Override
    public String getTheme() {
        return "Тип 17";
    }

    @SuppressWarnings("all")
    @Override
    public Pair<String, String> genRandomTaskTextSolution(Random random) {
        return JFXMain.random.nextBoolean() ? this.type1() : this.type2();
    }

    @SuppressWarnings("all")
    private Pair<String, String> type1() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Дана плотность вероятности f(x) непрерывной случайной величины X. Требуется:");
        stringBuilder.append("\n");
        stringBuilder.append("1) найти параметр a");
        stringBuilder.append("\n");
        stringBuilder.append("2) найти функцию распределения F(x)");
        stringBuilder.append("\n");
        stringBuilder.append("3) построить графики f(x) и F(x)");
        stringBuilder.append("\n");
        stringBuilder.append("4) найти асимметрию и эксцесс X");

        stringBuilder.append("\n");
        stringBuilder.append("       | 0, x < 0");
        stringBuilder.append("\n");
        stringBuilder.append("F(x) = | a/3(sin(x)), 0 <= x <= pi/3");
        stringBuilder.append("\n");
        stringBuilder.append("       | 0, x > pi/3");

        UnivariateFunction integrand = new UnivariateFunction() {
            @Override
            public double value(double x) {
                return 2.0f * Math.sin(x);
            }
        };

        IterativeLegendreGaussIntegrator integrator = new IterativeLegendreGaussIntegrator(5, 1.0e-9, 1.0e-9);
        double result = integrator.integrate(Integer.MAX_VALUE, integrand, 0, Math.PI / 3f);

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("a = 6");
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("F(x) = %.4f", result));

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }

    @SuppressWarnings("all")
    private Pair<String, String> type2() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Дана плотность вероятности f(x) непрерывной случайной величины X. Требуется:");
        stringBuilder.append("\n");
        stringBuilder.append("1) найти параметр a");
        stringBuilder.append("\n");
        stringBuilder.append("2) найти функцию распределения F(x)");
        stringBuilder.append("\n");
        stringBuilder.append("3) построить графики f(x) и F(x)");
        stringBuilder.append("\n");
        stringBuilder.append("4) найти асимметрию и эксцесс X");

        stringBuilder.append("\n");
        stringBuilder.append("       | 0, x < 2");
        stringBuilder.append("\n");
        stringBuilder.append("F(x) = | a(x-2)(4-x), 2 <= x <= 4");
        stringBuilder.append("\n");
        stringBuilder.append("       | 0, x > 4");

        UnivariateFunction integrand = new UnivariateFunction() {
            @Override
            public double value(double x) {
                return -0.75f * (x - 2) * (x - 4);
            }
        };

        IterativeLegendreGaussIntegrator integrator = new IterativeLegendreGaussIntegrator(5, 1.0e-9, 1.0e-9);
        double result = integrator.integrate(Integer.MAX_VALUE, integrand, 2, 4);

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("a = -0.75");
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("F(x) = %.4f", result));

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }
}