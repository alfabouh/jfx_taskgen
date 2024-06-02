package app.generation.tasks;

import app.JFXMain;
import app.generation.ITask;
import javafx.util.Pair;
import org.apache.commons.math3.util.CombinatoricsUtils;

import java.util.Random;

public class Task9 implements ITask {
    @Override
    public String getTheme() {
        return "Тип 9";
    }

    @SuppressWarnings("all")
    @Override
    public Pair<String, String> genRandomTaskTextSolution(Random random) {
        return JFXMain.random.nextBoolean() ? this.type1() : this.type2();
    }

    @SuppressWarnings("all")
    private Pair<String, String> type1() {
        float f1 = (JFXMain.random.nextInt(5) + 1) / 10.0f;
        int a1 = JFXMain.random.nextInt(3) + 4;
        String mainPattern = "При передаче сообщения вероятность искажения одного знака равна %.2f. Какова вероятность того, что сообщение из %d знаков содержит: ";
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format(mainPattern, f1, a1));
        stringBuilder.append("\n");
        stringBuilder.append("a) три неправильных знака\n");
        stringBuilder.append("б) не менее трех неправильных знаков?\n");

        float f2 = 1.0f - f1;

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(String.format("а) P = C(%d,%d)*(%.2f^3)*(%.2f^2) = ", (a1), 3, f1, f2));
        stringBuilder2.append(CombinatoricsUtils.binomialCoefficientDouble(a1, 3) * Math.pow(f1, 3) * Math.pow(f2, 2));

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }

    @SuppressWarnings("all")
    private Pair<String, String> type2() {
        int a1 = JFXMain.random.nextInt(4) + 3;
        int a2 = a1 + 1;
        int a3 = JFXMain.random.nextInt(2) + 5;
        int a4 = a3 + 2;

        String mainPattern = "В скольких партиях с равным по силе противником выигрыш более вероятен: в %d партиях из %d или в %d из %d?";
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format(mainPattern, a1, a2, a3, a4));

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(String.format("1) P = C(%d,%d)*p^%d*q = ", a2, a1, a1));
        stringBuilder2.append(CombinatoricsUtils.binomialCoefficientDouble(a2, a1) * Math.pow(0.5f, a1) * 0.5f);
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("2) P = C(%d,%d)*p^%d*q^2 = ", a4, a3, a3));
        stringBuilder2.append(CombinatoricsUtils.binomialCoefficientDouble(a4, a3) * Math.pow(0.5f, a3) * Math.pow(0.5f, 2));

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }
}
