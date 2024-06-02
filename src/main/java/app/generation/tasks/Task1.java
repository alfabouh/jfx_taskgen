package app.generation.tasks;

import app.JFXMain;
import app.generation.ITask;
import javafx.util.Pair;
import org.apache.commons.math3.util.CombinatoricsUtils;

import java.util.Random;

public class Task1 implements ITask {
    @Override
    public String getTheme() {
        return "Тип 1";
    }

    @SuppressWarnings("all")
    @Override
    public Pair<String, String> genRandomTaskTextSolution(Random random) {
        return JFXMain.random.nextBoolean() ? this.type1() : this.type2();
    }

    @SuppressWarnings("all")
    private Pair<String, String> type1() {
        int a = 6 + JFXMain.random.nextInt(3);

        String mainPattern = "Наугад выбирается номер телефона из %d цифр. Найти вероятность того, что:";

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(mainPattern, a));
        stringBuilder.append("\n");
        stringBuilder.append("a) это номер телефона Н.М. Урюпина\n");
        stringBuilder.append("б) все цифры номера различны");

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("a)");
        stringBuilder2.append(String.format("1 / (9 * 10^%d) = ", a - 1) + String.format("%.10f", 1 / (9 * Math.pow(10, a - 1))));
        stringBuilder2.append("\n");
        stringBuilder2.append("б)9*");

        int j = 9;
        int b = j;
        for (int i = 0; i < a - 1; i++) {
            b *= j;
            stringBuilder2.append(j--);
            if (i != a - 2) {
                stringBuilder2.append("*");
            }
        }
        stringBuilder2.append(" = " + b);

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }

    @SuppressWarnings("all")
    private Pair<String, String> type2() {
        int a = 3 + JFXMain.random.nextInt(3);
        int O = (int) Math.pow(10, a);

        String mainPattern = "Наугад выбирается автомобиль с %d значным номером. Найти вероятность того, что:";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(mainPattern, a));
        stringBuilder.append("\n");
        stringBuilder.append("a) Это автомобиль Ф.Киркорова\n");
        stringBuilder.append("б) Номер не содержит одинаковых цифр");


        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("a)1 / " + O + " = ");
        stringBuilder2.append((float) 1 / O);
        stringBuilder2.append("\n");
        stringBuilder2.append("б)");

        int j = 10;
        int b = 1;
        for (int i = 0; i < a; i++) {
            b *= j;
            stringBuilder2.append(j--);
            if (i != a - 1) {
                stringBuilder2.append("*");
            }
        }

        stringBuilder2.append("/" + O);
        stringBuilder2.append(" = " + (float) (b / (float) O));

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }
}
