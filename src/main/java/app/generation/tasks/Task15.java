package app.generation.tasks;

import app.JFXMain;
import app.generation.ITask;
import javafx.util.Pair;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.Random;

public class Task15 implements ITask {
    @Override
    public String getTheme() {
        return "Тип 15";
    }

    @SuppressWarnings("all")
    @Override
    public Pair<String, String> genRandomTaskTextSolution(Random random) {
        return this.type1();
    }

    @SuppressWarnings("all")
    private Pair<String, String> type1() {
        int a1 = 1 + JFXMain.random.nextInt(5);
        int a2 = JFXMain.random.nextInt(5) - 1;
        int a3 = JFXMain.random.nextInt(5);

        int b1 = JFXMain.random.nextInt(5) - 1;
        int b2 = JFXMain.random.nextInt(5);

        float fa1 = 0.1f + JFXMain.random.nextInt(3) * 0.1f;
        float fa2 = fa1 + 0.1f;
        float fa3 = 1.0f - (fa1 + fa2);

        float fb1 = 0.1f + JFXMain.random.nextInt(3) * 0.1f;
        float fb2 = 1.0f - fb1;

        String mainPattern = "Независимые случайные величины X и Y заданы таблицами распределений.\n" +
                "Найти:\n" +
                "1) M(X), M(Y), D(X), D(Y);\n" +
                "2) Таблицы распределения случайных величин Z1 = 2X+Y, Z2 = X  Y;\n" +
                "3) M(Z1), M(Z2), D(Z1), D(Z2) непосредственно по таблицам распределений и на основании свойств математического ожидания и дисперсии.";
        StringBuilder stringBuilder = new StringBuilder();

        DescriptiveStatistics stats = new DescriptiveStatistics();
        stats.addValue(a1 * fa1);
        stats.addValue(a2 * fa2);
        stats.addValue(a3 * fa3);

        DescriptiveStatistics stats2 = new DescriptiveStatistics();
        stats2.addValue(b1 * fb1);
        stats2.addValue(b2 * fb2);

        stringBuilder.append(String.format(mainPattern));
        stringBuilder.append("\n");
        stringBuilder.append(String.format("xi | %d | %d | %d |", a1, a2, a3));
        stringBuilder.append("\n");
        stringBuilder.append(String.format("pi | p | %.2f | %.2f |", fa1, fa2));
        stringBuilder.append("\n");
        stringBuilder.append(String.format("yi | %d | %d |", b1, b2));
        stringBuilder.append("\n");
        stringBuilder.append(String.format("pi | %.2f | %.2f |", fb1, fb2));

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("1)");
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("M(X) = %.2f", stats.getMean()));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("D(X) = %.2f", stats.getVariance()));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("M(X) = %.2f", stats2.getMean()));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("D(X) = %.2f", stats2.getVariance()));
        stringBuilder2.append("\n");

        float[] fas1 = new float[] {(2 * a1 + b1), (2 * a1 + b2), (2 * a2 + b1), (2 * a2 + b2), (2 * a3 + b1), (2 * a3 + b2)};
        float[] fas2 = new float[] {(a1 * b1), (a1 * b2), (a2 * b1), (a2 * b2), (a3 * b1), (a3 * b2)};

        float[] fab1 = new float[] {(fa1 * fb1), (fa1 * fb2), (fa2 * fb1), (fa2 * fb2), (fa3 * fb1), (fa3 * fb2)};

        stringBuilder2.append("2)");
        stringBuilder2.append("\n");
        stringBuilder2.append("Z1");
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("| %.2f | %.2f | %.2f | %.2f | %.2f | %.2f |", fas1[0], fas1[1], fas1[2], fas1[3], fas1[4], fas1[5]));
        stringBuilder2.append("\n");
        stringBuilder2.append("P1");
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("| %.2f | %.2f | %.2f | %.2f | %.2f | %.2f |", fab1[0], fab1[1], fab1[2], fab1[3], fab1[4], fab1[5]));
        stringBuilder2.append("\n");

        stringBuilder2.append("Z2");
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("| %.2f | %.2f | %.2f | %.2f | %.2f | %.2f |", fas2[0], fas2[1], fas2[2], fas2[3], fas2[4], fas2[5]));
        stringBuilder2.append("\n");
        stringBuilder2.append("P2");
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("| %.2f | %.2f | %.2f | %.2f | %.2f | %.2f |", fab1[0], fab1[1], fab1[2], fab1[3], fab1[4], fab1[5]));
        stringBuilder2.append("\n");

        DescriptiveStatistics stats3 = new DescriptiveStatistics();
        stats3.addValue(fas1[0] * fab1[0]);
        stats3.addValue(fas1[1] * fab1[1]);
        stats3.addValue(fas1[2] * fab1[2]);
        stats3.addValue(fas1[3] * fab1[3]);
        stats3.addValue(fas1[4] * fab1[4]);
        stats3.addValue(fas1[5] * fab1[5]);

        DescriptiveStatistics stats4 = new DescriptiveStatistics();
        stats4.addValue(fas2[0] * fab1[0]);
        stats4.addValue(fas2[1] * fab1[1]);
        stats4.addValue(fas2[2] * fab1[2]);
        stats4.addValue(fas2[3] * fab1[3]);
        stats4.addValue(fas2[4] * fab1[4]);
        stats4.addValue(fas2[5] * fab1[5]);

        stringBuilder2.append("3)");
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("M(Z1) = %.2f", stats3.getMean()));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("D(Z1) = %.2f", stats3.getVariance()));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("M(Z2) = %.2f", stats4.getMean()));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("D(Z2) = %.2f", stats4.getVariance()));

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }
}