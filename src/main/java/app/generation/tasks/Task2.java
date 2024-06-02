package app.generation.tasks;

import app.JFXMain;
import app.generation.ITask;
import javafx.util.Pair;
import org.apache.commons.math3.util.CombinatoricsUtils;

import java.util.Random;

public class Task2 implements ITask {
    @Override
    public String getTheme() {
        return "Тип 2";
    }

    @SuppressWarnings("all")
    @Override
    public Pair<String, String> genRandomTaskTextSolution(Random random) {
        return JFXMain.random.nextBoolean() ? this.type1() : this.type2();
    }

    @SuppressWarnings("all")
    private Pair<String, String> type1() {
        String mainPattern = "Полная колода карт(52 листа) разбивается наугад на две равные стопки по 26 листов. Найти вероятность того, что:";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(mainPattern);
        stringBuilder.append("\n");
        stringBuilder.append("a) в каждой стопке окажется по 2 туза\n");
        stringBuilder.append("б) в одной из стопок окажется хотя бы 2 туза");

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("a)(C(4,0)*C(48,24))/C(52,26) = ");
        stringBuilder2.append(CombinatoricsUtils.binomialCoefficientDouble(4, 2) * CombinatoricsUtils.binomialCoefficientDouble(48, 24) / CombinatoricsUtils.binomialCoefficientDouble(52, 26));
        stringBuilder2.append("\n");
        stringBuilder2.append("б)1-(C(26,2)*C(26,4)+C(26,1)*C(26,1))/C(52,4) = ");
        stringBuilder2.append(1.0d - (CombinatoricsUtils.binomialCoefficientDouble(26, 0) * CombinatoricsUtils.binomialCoefficientDouble(26, 4) + CombinatoricsUtils.binomialCoefficientDouble(26, 1) * CombinatoricsUtils.binomialCoefficientDouble(26, 1)) / CombinatoricsUtils.binomialCoefficientDouble(52, 4));

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }

    @SuppressWarnings("all")
    private Pair<String, String> type2() {
        int a1 = JFXMain.random.nextInt(4) + 9;
        int a2 = JFXMain.random.nextInt(2) + 2;
        int a3 = JFXMain.random.nextInt(3) + 3;

        String mainPattern = String.format("Имеется %d лотерейных билетов, среди которых %d выигрышных. Найти вероятность того, что среди %d наудачу купленных билетов:", a1, a2, a3);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(mainPattern);
        stringBuilder.append("\n");
        stringBuilder.append("a) Один билет выигрышный\n");
        stringBuilder.append("б) Нет выигрышных");

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(String.format("a)(C(%d,1)*C(%d,%d))/C(%d,%d) = ", (int) (a2), (int) (a1 - a2), (int) (a3 - 1), (int) (a1), (int) (a3)));
        stringBuilder2.append(CombinatoricsUtils.binomialCoefficientDouble(a2, 1) * CombinatoricsUtils.binomialCoefficientDouble(a1 - a2, a3 - 1) / CombinatoricsUtils.binomialCoefficientDouble(a1, a3));
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("б)C(%d,%d)/C(%d,%d) = ", (int) (a1 - a2), (int) (a3), (int) (a1), (int) (a3)));
        stringBuilder2.append(CombinatoricsUtils.binomialCoefficientDouble(a1 - a2, a3) / CombinatoricsUtils.binomialCoefficientDouble(a1, a3));

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }
}
