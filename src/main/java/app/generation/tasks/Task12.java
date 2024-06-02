package app.generation.tasks;

import app.JFXMain;
import app.generation.ITask;
import javafx.util.Pair;
import org.apache.commons.math3.util.CombinatoricsUtils;

import java.util.Random;

public class Task12 implements ITask {
    @Override
    public String getTheme() {
        return "Тип 12";
    }

    @SuppressWarnings("all")
    @Override
    public Pair<String, String> genRandomTaskTextSolution(Random random) {
        return JFXMain.random.nextBoolean() ? this.type2() : this.type2();
    }

    @SuppressWarnings("all")
    private Pair<String, String> type1() {
        int a1 = 1000 + JFXMain.random.nextInt(5) * 100;
        int b1 = 2000 + JFXMain.random.nextInt(5) * 100;
        int b2 = 800 + JFXMain.random.nextInt(5) * 100;
        int b3 = 200 + JFXMain.random.nextInt(5) * 100;
        float CHANCE = 1.0f / a1;

        float f1 = CHANCE * 3.0f;

        String mainPattern = "В лотерее на %d билетов разыгрываются три вещи, стоимость которых %d, %d, %d руб. Составить ряд распределения суммы выигрыша для лица, имеющего одинбилет. Найти М(Х), D(X), σ(X), F(X) суммы выигрыша.";
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format(mainPattern, a1, b1, b2, b3));


        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(String.format("xi = {%d, %d, %d, %d}", 0, b1, b2, b3));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("pi = {%.4f, %.4f, %.4f, %.4f}", 1.0f - f1, CHANCE, CHANCE, CHANCE));
        stringBuilder2.append("\n");
        float M = b1 * CHANCE + b2 * CHANCE + b3 * CHANCE;
        float M2 = (float) (Math.pow(b1, 2) * CHANCE + Math.pow(b2, 2) * CHANCE + Math.pow(b3, 2) * CHANCE);
        float D = (float) (M2 - Math.pow(M, 2));
        stringBuilder2.append(String.format("M(X)=%d*%.4f + %d*%.4f + %d*%.4f = %.4f", b1, CHANCE, b2, CHANCE, b3, CHANCE, M));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("D(X)=M(x^2) - M(x)^2 = %.2f", D));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("σ(X) = %.2f", Math.sqrt(D)));
        stringBuilder2.append("\n F(x):\n");
        stringBuilder2.append(String.format("| 0, x <= 0"));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("| %.4f, 0 < x <= %d", CHANCE, b3));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("| %.4f, %d < x <= %d", CHANCE * 2.0f, b3, b2));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("| %.4f, %d < x <= %d", CHANCE * 3.0f, b2, b1));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("| 1, %d < x", b1));
        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }

    @SuppressWarnings("all")
    private Pair<String, String> type2() {
        float f1 = 0.4f;

        String mainPattern = "Вероятность поражения цели при одном выстреле равна %.2f. Составить ряд распределения числа выстрелов, производимых до первого поражения цели, если у стрелка четыре патрона. Найти М(Х), D(X), (X), F(X) числа выстрелов до первого поражения цели. Построить график F(X).";
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format(mainPattern, f1));

        float p = f1;
        float q = 1.0f - f1;

        float p0 = (float) (CombinatoricsUtils.binomialCoefficientDouble(4, 0) * Math.pow(p, 0) * Math.pow(q, 4));
        float p1 = (float) (CombinatoricsUtils.binomialCoefficientDouble(4, 1) * Math.pow(p, 1) * Math.pow(q, 3));
        float p2 = (float) (CombinatoricsUtils.binomialCoefficientDouble(4, 2) * Math.pow(p, 2) * Math.pow(q, 2));
        float p3 = (float) (CombinatoricsUtils.binomialCoefficientDouble(4, 3) * Math.pow(p, 3) * Math.pow(q, 1));
        float p4 = (float) (CombinatoricsUtils.binomialCoefficientDouble(4, 4) * Math.pow(p, 4) * Math.pow(q, 0));

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(String.format("xi = {%d, %d, %d, %d, %d}", 0, 1, 2, 3, 4));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("pi = {%.4f, %.4f, %.4f, %.4f, %.4f}", p0, p1, p2, p3, p4));
        stringBuilder2.append("\n");

        float M = p1 + 2 * p2 + 3 * p3 + 4 * p4;
        float M2 = p1 + 4 * p2 + 9 * p3 + 16 * p4;
        float D = (float) (M2 - Math.pow(M, 2));

        stringBuilder2.append(String.format("M(X)=%d*%.4f + %d*%.4f + %d*%.4f + %d*%.4f = %.4f", 1, p1, 2, p2, 3, p3, 4, p4, M));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("D(X)=M(x^2) - M(x)^2 = %.2f", D));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("σ(X) = %.2f", Math.sqrt(D)));
        stringBuilder2.append("\n F(x):\n");

        stringBuilder2.append(String.format("| 0, x <= 0"));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("| %.4f, 0 < x <= %d", p1, 1));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("| %.4f, %d < x <= %d", p1 + p2, 1, 2));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("| %.4f, %d < x <= %d", p1 + p2 + p3, 2, 3));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("| %.4f, %d < x", p1 + p2 + p3 + p4, 3));
        stringBuilder2.append("\n");

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }
}
