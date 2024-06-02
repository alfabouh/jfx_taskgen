package app.generation.tasks;

import app.JFXMain;
import app.generation.ITask;
import javafx.util.Pair;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.integration.IterativeLegendreGaussIntegrator;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.Random;

public class Task16 implements ITask {
    @Override
    public String getTheme() {
        return "Тип 16";
    }

    @SuppressWarnings("all")
    @Override
    public Pair<String, String> genRandomTaskTextSolution(Random random) {
        return JFXMain.random.nextBoolean() ? this.type1() : this.type2();
    }

    @SuppressWarnings("all")
    private Pair<String, String> type1() {
        float f1 = 0.1f;
        float f2 = 0.5f;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Дана функция распределения F(x) непрерывной случайной величины X. Требуется:");
        stringBuilder.append("\n");
        stringBuilder.append("1) найти плотность вероятности f(x)");
        stringBuilder.append("\n");
        stringBuilder.append("2) построить графики F(x) и f(x)");
        stringBuilder.append("\n");
        stringBuilder.append("3) найти M(X), D(X), σ(Х)");
        stringBuilder.append("\n");
        stringBuilder.append("4) найти Р(a < X < b) для данных a, b");

        stringBuilder.append("\n");
        stringBuilder.append("       | 0, x <= 0");
        stringBuilder.append("\n");
        stringBuilder.append("F(x) = | 3x^2 + 2x, 0 < x <= 1/3");
        stringBuilder.append("\n");
        stringBuilder.append("       | 0, x > 1/3");
        stringBuilder.append(String.format("\n a = %.2f; b = %.2f", f1, f2));

        UnivariateFunction integrand = new UnivariateFunction() {
            @Override
            public double value(double x) {
                return x * (6 * x + 2);
            }
        };


        IterativeLegendreGaussIntegrator integrator = new IterativeLegendreGaussIntegrator(5, 1.0e-9, 1.0e-9);
        double result = integrator.integrate(Integer.MAX_VALUE, integrand, 0, 1/3f);

        UnivariateFunction integrand2 = new UnivariateFunction() {
            @Override
            public double value(double x) {
                return (x * x) * (6 * (x) + 2);
            }
        };

        double result2 = integrator.integrate(Integer.MAX_VALUE, integrand2, 0, 1/3f);

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(String.format("M(X) = %.4f", result));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("M(X^2) = %.4f", result2));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("D(X) = %.4f", result2 - Math.pow(result, 2)));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("σ = %.4f", Math.sqrt(result2 - Math.pow(result, 2))));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("P(a < X < b) = F(b) - F(a) = 1 - (3 * (%.2f)^2 + 2 * %.2f) = %.2f", f1, f1, 1.0f - ((f1 * f1) + 2 * f1)));
        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }

    @SuppressWarnings("all")
    private Pair<String, String> type2() {
        float f1 = 0.0f;
        float f2 = (float) (Math.PI / 2.0f);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Дана функция распределения F(x) непрерывной случайной величины X. Требуется:");
        stringBuilder.append("\n");
        stringBuilder.append("1) найти плотность вероятности f(x)");
        stringBuilder.append("\n");
        stringBuilder.append("2) построить графики F(x) и f(x)");
        stringBuilder.append("\n");
        stringBuilder.append("3) найти M(X), D(X), σ(Х)");
        stringBuilder.append("\n");
        stringBuilder.append("4) найти Р(a < X < b) для данных a, b");

        stringBuilder.append("\n");
        stringBuilder.append("       | 0, x <= 0");
        stringBuilder.append("\n");
        stringBuilder.append("F(x) = | 1/2(1 - cos(x)), 0 < x <= pi");
        stringBuilder.append("\n");
        stringBuilder.append("       | 0, x > pi");
        stringBuilder.append(String.format("\n a = %.2f; b = pi/2", f1));

        UnivariateFunction integrand = new UnivariateFunction() {
            @Override
            public double value(double x) {
                return x * Math.sin(x) / 2.0f;
            }
        };


        IterativeLegendreGaussIntegrator integrator = new IterativeLegendreGaussIntegrator(5, 1.0e-9, 1.0e-9);
        double result = integrator.integrate(Integer.MAX_VALUE, integrand, 0, 1/3f);

        UnivariateFunction integrand2 = new UnivariateFunction() {
            @Override
            public double value(double x) {
                return (x * x) * Math.sin(x) / 2.0f;
            }
        };

        double result2 = integrator.integrate(Integer.MAX_VALUE, integrand2, 0, 1/3f);

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(String.format("M(X) = %.4f", result));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("M(X^2) = %.4f", result2));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("D(X) = %.4f", result2 - Math.pow(result, 2)));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("σ = %.4f", Math.sqrt(result2 - Math.pow(result, 2))));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("P(a < X < b) = F(b) - F(a) = 1/2(1 - cos(pi/2)) = %.2f", 0.5f * (1.0f - Math.cos(Math.PI * 0.5f))));
        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }
}