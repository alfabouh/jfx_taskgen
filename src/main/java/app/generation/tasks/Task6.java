package app.generation.tasks;

import app.JFXMain;
import app.generation.ITask;
import javafx.util.Pair;

import java.util.Random;

public class Task6 implements ITask {
    @Override
    public String getTheme() {
        return "Тип 6";
    }

    @SuppressWarnings("all")
    @Override
    public Pair<String, String> genRandomTaskTextSolution(Random random) {
        return JFXMain.random.nextBoolean() ? this.type1() : this.type2();
    }

    @SuppressWarnings("all")
    private Pair<String, String> type1() {
        int i1 = (JFXMain.random.nextInt(3) + 4);
        int i2 = i1 + 3;

        String mainPattern = "В мешке %d красных и %d зеленых шаров. Проводится испытание по последовательному извлечению двух шаров без возвращения. Найдите вероятность того, что второй шар будет зеленый, если известно, что первый шар был красный. ";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(mainPattern, i1, i2));

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("P = ");
        stringBuilder2.append(String.format("%d/%d = %.2f", i2, (i2 + i1 - 1), i2 / (float) (i2 + i1 - 1)));

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }

    @SuppressWarnings("all")
    private Pair<String, String> type2() {
        int i1 = 100 + (10 * (JFXMain.random.nextInt(5) + 1));
        int i2 = JFXMain.random.nextInt(6) + 5;

        String mainPattern = "В ящике %d деталей, из которых %d бракованных. Из него поочередно извлекается по одной детали (с возвратом и без возврата). Найти вероятность того, что во второй раз будет вынута стандартная деталь при условии, что в первый раз извлечена деталь: ";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(mainPattern, i1, i2));
        stringBuilder.append("\n");
        stringBuilder.append("a) стандартная\n");
        stringBuilder.append("б) бракованная");

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("С возвратом:\n");
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("a) P = (%d-%d)/%d = ", i1, i2, i1));
        stringBuilder2.append((i1 - i2) / (float) i1);
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("б) P = (%d-%d)/%d = ", i1, i2, i1));
        stringBuilder2.append((i1 - i2) / (float) i1);
        stringBuilder2.append("\n");

        stringBuilder2.append("Без возврата:\n");
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("a) P = %d/%d = ", (i1 - i2 - 1), i1 - 1));
        stringBuilder2.append((i1 - i2 - 1) / (float) (i1 - 1));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("б) P = %d/%d = ", i1 - i2, i1 - 1));
        stringBuilder2.append((i1 - i2) / (float) (i1 - 1));

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }
}
