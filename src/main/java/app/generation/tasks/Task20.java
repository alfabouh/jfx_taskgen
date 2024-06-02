package app.generation.tasks;

import app.JFXMain;
import app.generation.ITask;
import javafx.util.Pair;

import java.util.Random;

public class Task20 implements ITask {
    @Override
    public String getTheme() {
        return "Тип 20";
    }

    @SuppressWarnings("all")
    @Override
    public Pair<String, String> genRandomTaskTextSolution(Random random) {
        return JFXMain.random.nextBoolean() ? this.type1() : this.type2();
    }

    @SuppressWarnings("all")
    private Pair<String, String> type1() {
        int a1 = 50 + JFXMain.random.nextInt(5) * 10;
        float f2 = 0.1f + JFXMain.random.nextInt(4) * 0.1f;
        float f3 = 0.1f + JFXMain.random.nextInt(8) * 0.01f;

        String mainPattern = "Диаметр детали, вытачиваемой на станке, есть нормальная случайная величина (m = %d см; σ = %.2f см). С какой вероятностью отклонение диаметра детали от среднего значения не превосходит по абсолютной величине %.2f см?";
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format(mainPattern, a1, f2, f3));

        double z1 = ((a1 - f3) - a1) / f2;

        double p = 2.0f * MathUtils.laplace(Math.abs(z1));

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(String.format("z = %.2f", z1));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("P(X) = 2Ф(z) = %.2f", p));

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }

    @SuppressWarnings("all")
    private Pair<String, String> type2() {
        int a1 = 3 + JFXMain.random.nextInt(6);
        int a2 = a1 - 2;

        String mainPattern = "Производится взвешивание стандартных узлов. Систематические ошибки взвешивания отсутствуют, а случайные — подчинены нормальному закону с σ = %d кг. С какой вероятностью ошибка очередного взвешивания не превысит по абсолютной величине %d кг?";
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format(mainPattern, a1, a2));

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(String.format("P(X) = 2Ф(%d / %d) = %.2f", a2, a1, 2.0f * MathUtils.laplace((float) a2 / (float) a1)));
        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }
}