package app.generation.tasks;

import app.JFXMain;
import app.generation.ITask;
import javafx.util.Pair;
import org.apache.commons.math3.distribution.LaplaceDistribution;
import org.apache.commons.math3.transform.FastFourierTransformer;
import org.apache.commons.math3.util.CombinatoricsUtils;

import java.util.Random;

public class Task10 implements ITask {
    @Override
    public String getTheme() {
        return "Тип 10";
    }

    @SuppressWarnings("all")
    @Override
    public Pair<String, String> genRandomTaskTextSolution(Random random) {
        return JFXMain.random.nextBoolean() ? this.type1() : this.type2();
    }

    @SuppressWarnings("all")
    private Pair<String, String> type1() {
        int a1 = 500 + JFXMain.random.nextInt(5) * 100;
        float f1 = 0.2f + JFXMain.random.nextInt(3) * 0.1f;
        String mainPattern = "В каждом из %d независимых испытаний событие А происходит с постоянной вероятностью %.2f. Найти вероятность того, что событие А происходит: ";
        StringBuilder stringBuilder = new StringBuilder();

        int b1 = (int) (a1 * f1) - (15 + JFXMain.random.nextInt(5) * 5);
        int b2 = (int) (a1 * f1) + (25 + JFXMain.random.nextInt(3) * 5);
        int b3 = (int) (a1 * f1) + 5 + JFXMain.random.nextInt(3) * 5;

        stringBuilder.append(String.format(mainPattern, a1, f1));
        stringBuilder.append("\n");
        stringBuilder.append(String.format("a) меньше чем %d и больше чем %d раз\n", b2, b1));
        stringBuilder.append(String.format("б) точно %d раз?", b3));

        float c1 = (float) Math.sqrt(a1 * f1 * (1.0f - f1));

        float F3 = (float) ((float) (b1 - a1) * f1) / c1;
        float F4 = (float) ((float) (b2 - a1) * f1) / c1;
        float F5 = (float) ((float) (b3 - a1) * f1) / c1;

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("а)");
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("x1 = (%d-%d*%.2f)/%.2f = ", b1, a1, f1, c1));
        stringBuilder2.append(F3);
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("x2 = (%d-%d*%.2f)/%.2f = ", b2, a1, f1, c1));
        stringBuilder2.append(F4);
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("P = %.5f", Math.abs(MathUtils.laplace(F3) - MathUtils.laplace(F4))));

        stringBuilder2.append("\n");
        stringBuilder2.append("б)");
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("x = (%d-%d*%.2f)/%.2f = ", b3, a1, f1, c1));
        stringBuilder2.append(F5);
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("P = %.5f", Math.abs(MathUtils.laplace(F5) / c1)));

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }

    @SuppressWarnings("all")
    private Pair<String, String> type2() {
        int a1 = 100 + JFXMain.random.nextInt(8) * 10;
        float f1 = 0.6f + JFXMain.random.nextInt(3) * 0.1f;
        String mainPattern = "Имеется %d станков равной мощности, работающих независимо друг от друга в одинаковом режиме при включенном приводе в течение %.2f всего рабочего времени. " +
                "Какова вероятность того, что в произвольный момент окажутся включенными: ";
        StringBuilder stringBuilder = new StringBuilder();

        int b1 = a1 - (30 + JFXMain.random.nextInt(5) * 4);
        int b2 = a1 - (15 + JFXMain.random.nextInt(5) * 4);
        int b3 = a1 - (5 + JFXMain.random.nextInt(5) * 3);


        stringBuilder.append(String.format(mainPattern, a1, f1));
        stringBuilder.append("\n");
        stringBuilder.append(String.format("a) от %d до %d станков\n", b2, b1));
        stringBuilder.append(String.format("б) ровно %d станков?", b3));

        float c1 = (float) Math.sqrt(a1 * f1 * (1.0f - f1));

        float F3 = (float) ((float) (b1 - a1) * f1) / c1;
        float F4 = (float) ((float) (b2 - a1) * f1) / c1;
        float F5 = (float) ((float) (b3 - a1) * f1) / c1;

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("а)");
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("x1 = (%d-%d*%.2f)/%.2f = ", b1, a1, f1, c1));
        stringBuilder2.append(F3);
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("x2 = (%d-%d*%.2f)/%.2f = ", b2, a1, f1, c1));
        stringBuilder2.append(F4);
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("P = %.5f", Math.abs(MathUtils.laplace(F3) - MathUtils.laplace(F4))));

        stringBuilder2.append("\n");
        stringBuilder2.append("б)");
        int k = b3;
        double p = f1;
        double q = 1.0 - p;

        double C = MathUtils.factorial(a1) / (MathUtils.factorial(k) * MathUtils.factorial(a1 - k));
        double result = C * Math.pow(p, k) * Math.pow(q, a1 - k);
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("P = %.12f", result));

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }
}
