package app.generation.tasks;

import app.JFXMain;
import app.generation.ITask;
import javafx.util.Pair;
import org.apache.commons.math3.util.CombinatoricsUtils;

import java.util.Random;

public class Task14 implements ITask {
    @Override
    public String getTheme() {
        return "Тип 14";
    }

    @SuppressWarnings("all")
    @Override
    public Pair<String, String> genRandomTaskTextSolution(Random random) {
        return JFXMain.random.nextBoolean() ? this.type1() : this.type2();
    }

    @SuppressWarnings("all")
    private Pair<String, String> type1() {
        float f1 = 0.01f + JFXMain.random.nextInt(3) * 0.01f;
        int a1 = 100 + JFXMain.random.nextInt(4) * 100;

        String mainPattern = "Вероятность для любого абонента позвонить на коммутатор в течение одного часа равна %.2f. " +
                "Телефонная станция обслуживает %d абонентов. Составить ряд распределения числа абонентов, которые могут позвонить на коммутатор в течение одного часа. Найти M(X) этой случайной величины.";
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format(mainPattern, f1, a1));

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(String.format("P(X) = C(%d, k) * %.2f^k * (1 - %.2f)^(%d-k)", a1, f1, f1, a1));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("M(X) = %d * %.2f = %.2f", a1, f1, a1 * f1));

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }

    @SuppressWarnings("all")
    private Pair<String, String> type2() {
        float f1 = 0.001f + JFXMain.random.nextInt(3) * 0.001f;
        int a1 = 1000 + JFXMain.random.nextInt(3) * 1000;

        String mainPattern = "Устройство содержит %d ламп. Вероятность выхода из строя одной лампы в течение одного часа работы устройства равна %.3f. " +
                "Составить ряд распределения числа ламп, вышедших из строя в течение одного часа работы устройства. Найти M(X) этой случайной величины.";
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format(mainPattern, a1, f1));

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(String.format("P(X) = C(%d, k) * %.3f^k * (1 - %.3f)^(%d-k)", a1, f1, f1, a1));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("M(X) = %d * %.3f = %.3f", a1, f1, a1 * f1));

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }
}
