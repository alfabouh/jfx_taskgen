package app.generation.tasks;

import app.JFXMain;
import app.generation.ITask;
import javafx.util.Pair;

import java.util.Random;

public class Task11 implements ITask {
    @Override
    public String getTheme() {
        return "Тип 11";
    }

    @SuppressWarnings("all")
    @Override
    public Pair<String, String> genRandomTaskTextSolution(Random random) {
        return JFXMain.random.nextBoolean() ? this.type1() : this.type2();
    }

    @SuppressWarnings("all")
    private Pair<String, String> type1() {
        int a1 = 800 + JFXMain.random.nextInt(5) * 100;
        float f1 = (1 + JFXMain.random.nextInt(5)) * 0.0001f;
        String mainPattern = "Аппаратура состоит из 1000 элементов, каждый из которых независимо от остальных выходит из строя за время Т с вероятностью 0,0005. Найти вероятность того, что за время Т откажет не более трех элементов.";
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format(mainPattern, a1, f1));

        double lambda = a1 * f1;

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(String.format("P = ((%.2f^0*e^(-%.2f))/0!) + ((%.2f^1*e^(-%.2f))/1!) + ((%.2f^2*e^(-%.2f))/2!) + ((%.2f^3*e^(-%.2f))/3!) = ", lambda, lambda, lambda, lambda, lambda, lambda, lambda, lambda));
        double d = Math.pow(lambda, 0) * Math.pow(Math.E, -lambda) / MathUtils.factorial(0) + Math.pow(lambda, 1) * Math.pow(Math.E, -lambda) / MathUtils.factorial(1) + Math.pow(lambda, 2) * Math.pow(Math.E, -lambda) / MathUtils.factorial(2) + Math.pow(lambda, 3) * Math.pow(Math.E, -lambda) / MathUtils.factorial(3);
        stringBuilder2.append(d);

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }

    @SuppressWarnings("all")
    private Pair<String, String> type2() {
        int a1 = 100 + JFXMain.random.nextInt(5) * 10;
        int a2 = 2 + JFXMain.random.nextInt(3);

        String mainPattern = "Среднее число вызовов, поступающих на АТС в минуту, равно %d. Найти вероятность того, что за две секунды на АТС поступит менее %d вызовов.\n";
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format(mainPattern, a1, a2));

        double lambda = a1 / 60.0d * a2;

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(String.format("P = ((%.2f^0*e^(-%.2f))/0!) + ((%.2f^1*e^(-%.2f))/1!) = ", lambda, lambda, lambda, lambda));
        double d = Math.pow(lambda, 0) * Math.pow(Math.E, -lambda) / MathUtils.factorial(0) + Math.pow(lambda, 1) * Math.pow(Math.E, -lambda) / MathUtils.factorial(1);
        stringBuilder2.append(d);

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }
}
