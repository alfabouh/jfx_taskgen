package app.generation.tasks;

import app.JFXMain;
import app.generation.ITask;
import javafx.util.Pair;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.integration.IterativeLegendreGaussIntegrator;

import java.util.Random;

public class Task19 implements ITask {
    @Override
    public String getTheme() {
        return "Тип 19";
    }

    @SuppressWarnings("all")
    @Override
    public Pair<String, String> genRandomTaskTextSolution(Random random) {
        return JFXMain.random.nextBoolean() ? this.type1() : this.type2();
    }

    @SuppressWarnings("all")
    private Pair<String, String> type1() {
        int a1 = 50 + JFXMain.random.nextInt(5) * 600;
        int a2 = 10 + JFXMain.random.nextInt(8);

        String mainPattern = "Дистанция X между двумя соседними самолетами в строю имеет показательное распределение с MX = %d м. Опасность столкновения самолетов возникает при уменьшении дистанции до %d м. Найти вероятность возникновения этой опасности.";
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format(mainPattern, a1, a2));

        double L = 1.0f / a1;
        double p = 1.0f - Math.exp(-L * a2);

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(String.format("P = 1 - e^(-L*x) = %.2f", p));

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }

    @SuppressWarnings("all")
    private Pair<String, String> type2() {
        int a1 = 1 + JFXMain.random.nextInt(6);

        String mainPattern = "Срок службы прибора — случайная величина X, распределенная по экспоненциальному закону с параметром = %d. Указать плотность вероятности f(x) и числовые характеристики этой случайной величины, построить кривую распределения.";
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format(mainPattern, a1));

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(String.format("f(x) = %d * e^(-%d * x)", a1, a1));
        stringBuilder2.append(String.format("E(X) = 1 / l = %.2f", 1.0f / a1));
        stringBuilder2.append(String.format("D(X) = 1 / l^2 = %.2f", 1.0f / (a1 * a1)));
        stringBuilder2.append(String.format("σ(X) = sqrt(D(x)) = %.2f", Math.sqrt(1.0f / (a1 * a1))));
        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }
}