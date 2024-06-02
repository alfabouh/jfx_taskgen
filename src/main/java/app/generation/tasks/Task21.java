package app.generation.tasks;

import app.JFXMain;
import app.generation.ITask;
import javafx.util.Pair;

import java.util.Random;

public class Task21 implements ITask {
    @Override
    public String getTheme() {
        return "Тип 21";
    }

    @SuppressWarnings("all")
    @Override
    public Pair<String, String> genRandomTaskTextSolution(Random random) {
        return JFXMain.random.nextBoolean() ? this.type1() : this.type2();
    }

    @SuppressWarnings("all")
    private Pair<String, String> type1() {
        int a1 = 2 + JFXMain.random.nextInt(5);
        int a2 = 30 + JFXMain.random.nextInt(4) * 10;
        int a3 = a2 - 3 - JFXMain.random.nextInt(3);
        int a4 = a2 + 3 + JFXMain.random.nextInt(3);

        String mainPattern = "Колебание прибытия вагонов на промышленную станцию имеет нормальное распределение со средним квадратическим отклонением = %d и средним значением, равным %d вагонам в сутки. Определить вероятность того, что за сутки на станцию прибыло от %d до %d вагонов.";
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format(mainPattern, a1, a2, a3, a4));

        double z1 = (float) (a3 - a2) / (float) a1;
        double z2 = (float) (a4 - a2) / (float) a1;

        double p1 = MathUtils.laplace(Math.abs(z1));
        double p2 = MathUtils.laplace(Math.abs(z2));

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(String.format("z1 = %.2f", z1));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("z2 = %.2f", z2));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("P = P(z <= z2) - P(z <= z1) = %.2f", p2 - p1));

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }

    @SuppressWarnings("all")
    private Pair<String, String> type2() {
        int a1 = 2 + JFXMain.random.nextInt(5);
        int a2 = 30 + JFXMain.random.nextInt(4) * 10;
        int a3 = a2 - 3 - JFXMain.random.nextInt(3);
        int a4 = a2 + 3 + JFXMain.random.nextInt(3);

        String mainPattern = "Время формирования поездов подчиняется нормальному закону распределения со средним квадратическим отклонением %d мин и средним значением %d мин. Определить вероятность того, что время формирования поезда примет значение в интервале от %d до %d мин.";
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format(mainPattern, a1, a2, a3, a4));

        double z1 = (float) (a3 - a2) / (float) a1;
        double z2 = (float) (a4 - a2) / (float) a1;

        double p1 = MathUtils.laplace(Math.abs(z1));
        double p2 = MathUtils.laplace(Math.abs(z2));

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(String.format("z1 = %.2f", z1));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("z2 = %.2f", z2));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("P = P(z <= z2) - P(z <= z1) = %.2f", p2 - p1));

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }
}