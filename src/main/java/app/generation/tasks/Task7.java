package app.generation.tasks;

import app.JFXMain;
import app.generation.ITask;
import javafx.util.Pair;

import java.util.Random;

public class Task7 implements ITask {
    @Override
    public String getTheme() {
        return "Тип 7";
    }

    @SuppressWarnings("all")
    @Override
    public Pair<String, String> genRandomTaskTextSolution(Random random) {
        return JFXMain.random.nextBoolean() ? this.type1() : this.type2();
    }

    @SuppressWarnings("all")
    private Pair<String, String> type1() {
        float f1 = (JFXMain.random.nextInt(5) + 4) / 10.0f;
        float f2 = f1 + 0.1f;
        float f3 = (JFXMain.random.nextInt(6) + 3) / 10.0f;

        String mainPattern = "К кладу ведут три дороги. Вероятность погибнуть на первой дороге равна %.2f, на второй — %.2f, на третьей — %.2f. Найти вероятность того, что ковбой доберется до клада по одной из них при условии, что дорога выбирается им наудачу. ";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(mainPattern, f1, f2, f3));

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("P = ");
        stringBuilder2.append(String.format("1/3*(%.2f+%.2f+%.2f) = %.2f", (1.0f - f1), (1.0f - f2), (1.0f - f3), ((1.0f / 3.0f) * ((1.0f - f1) + (1.0f - f2) + (1.0f - f3)))));

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }

    @SuppressWarnings("all")
    private Pair<String, String> type2() {
        float f1 = (JFXMain.random.nextInt(5) + 4) / 10.0f;
        float f2 = f1 + 0.1f;
        float f3 = (JFXMain.random.nextInt(6) + 3) / 10.0f;

        String mainPattern = "В скачках участвуют три лошади. Первая лошадь выигрывает скачки с вероятностью %.2f, вторая — %.2f, третья — %.2f. Какова вероятность того, что лошадь, на которую поставил игрок, придет на скачках первой, если он выбирает ее наудачу? ";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(mainPattern, f1, f2, f3));

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("P = ");
        stringBuilder2.append(String.format("1/3*(%.2f+%.2f+%.2f) = %.2f", (f1), (f2), (f3), ((1.0f / 3.0f) * ((f1) + (f2) + (f3)))));

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }
}
