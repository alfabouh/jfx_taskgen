package app.generation.tasks;

import app.JFXMain;
import app.generation.ITask;
import javafx.util.Pair;
import org.apache.commons.math3.util.CombinatoricsUtils;

import java.util.Random;

public class Task13 implements ITask {
    @Override
    public String getTheme() {
        return "Тип 13";
    }

    @SuppressWarnings("all")
    @Override
    public Pair<String, String> genRandomTaskTextSolution(Random random) {
        return JFXMain.random.nextBoolean() ? this.type1() : this.type2();
    }

    @SuppressWarnings("all")
    private Pair<String, String> type1() {
        float f1 = 0.1f + JFXMain.random.nextInt(3) * 0.1f;

        String mainPattern = "Устройство состоит из трех независимо работающих элементов. Вероятность отказа каждого из них в одном опыте равна %.2f. " +
                "Составить ряд распределения числа отказавших элементов в одном опыте. Найти M(X) и D(X) этой случайной величины.";

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format(mainPattern, f1));

        float b1 = 1.0f - f1;
        float a1 = (float) Math.pow(b1, 3);
        float a2 = (float) (f1 * Math.pow(b1, 2) + b1 * f1 * b1 + b1 * b1 * f1);
        float a3 = (float) (f1 * f1 * b1 + f1 * b1 * f1 + b1 * f1 * f1);
        float a4 = (float) (f1 * f1 * f1);

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(String.format("xi = {%d, %d, %d, %d}", 0, 1, 2, 3));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("pi = {%.4f, %.4f, %.4f, %.4f}", a1, a2, a3, a4));
        stringBuilder2.append("\n");
        float M1 = a2 + 2 * a3 + 3 * a4;
        stringBuilder2.append(String.format("M(X) = 1*%.4f + 2*%.4f + 3*%.4f = %.2f", a2, a3, a4, M1));

        float M2 = a2 + 4 * a3 + 9 * a4;
        float M3 = (float) Math.pow(M1, 2);

        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("D(X) = M(x^2) - M(x)^2 = %.2f", M2 - M3));

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }

    @SuppressWarnings("all")
    private Pair<String, String> type2() {
        int i1 = 2 + JFXMain.random.nextInt(3);

        String mainPattern = "Игральная кость брошена %d раза. Составить ряд распределения числа выпадений шестерки. Найти M(X) и D(X) этой случайной величины.";
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format(mainPattern, i1));

        StringBuilder stringBuilder2 = new StringBuilder();
        for (int i = 0; i <= i1; i++) {
            float p0 = (float) (CombinatoricsUtils.binomialCoefficientDouble(i1, i) * Math.pow((1.0f / 6.0f), i) * Math.pow((5.0f / 6.0f), i1 - i));
            stringBuilder2.append(String.format("p%d = %.3f", i, p0));
            stringBuilder2.append("\n");
        }

        stringBuilder2.append(String.format("M(X) = np = %.2f", i1 / 6.0f));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("D(X) = npq = %.2f", 3.0f * (1.0f / 6.0f) * (5.0f / 6.0f)));

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }
}
