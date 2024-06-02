package app.generation.tasks;

import app.JFXMain;
import app.generation.ITask;
import javafx.util.Pair;

import java.util.Random;

public class Task5 implements ITask {
    @Override
    public String getTheme() {
        return "Тип 5";
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
        float f3 = (JFXMain.random.nextInt(3) + 3) / 10.0f;
        boolean reverse = JFXMain.random.nextBoolean();

        String mainPattern = "Два гроссмейстера играют две партии в шахматы. Вероятность выигрыша в одной партии для первого шахматиста равна %.2f, для второго — %.2f; вероятность ничьей — %.2f. ";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(mainPattern, f1, f2, f3));
        stringBuilder.append(reverse ? "Какова вероятность того, что первый гроссмейстер выиграет матч?" : "Какова вероятность того, что второй гроссмейстер выиграет матч?");

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("P = ");
        stringBuilder2.append(reverse ? String.format("(%.2f*%.2f+%.2f*%.2f)", f1, f1, f1, f3) : String.format("(%.2f*%.2f+%.2f*%.2f)", f2, f2, f2, f3));
        stringBuilder2.append(" = ");
        stringBuilder2.append(reverse ? (f1 * f1 + f1 * f3) : (f2 * f2 + f2 * f3));

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }

    @SuppressWarnings("all")
    private Pair<String, String> type2() {
        float f1 = (JFXMain.random.nextInt(5) + 4) / 10.0f;
        float f2 = f1 + 0.1f;
        float f3 = (JFXMain.random.nextInt(3) + 3) / 10.0f;
        boolean reverse = JFXMain.random.nextBoolean();

        String mainPattern = "Два игрока в настольный теннис, А и Б, играют матч из трех игр. Вероятность выигрыша одной игры для игрока А равна %.2f, для игрока Б - %.2f. Вероятность ничьей в одной игре равна %.2f. ";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(mainPattern, f1, f2, f3));
        stringBuilder.append(reverse ? "Какова вероятность того, что игрок А выиграет матч?" : "Какова вероятность того, что игрок Б выиграет матч?");

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("P = ");
        stringBuilder2.append(reverse ? String.format("(%.2f*%.2f+%.2f*%.2f)", f1, f1, f1, f3) : String.format("(%.2f*%.2f+%.2f*%.2f)", f2, f2, f2, f3));
        stringBuilder2.append(" = ");
        stringBuilder2.append(reverse ? (f1 * f1 + f1 * f3) : (f2 * f2 + f2 * f3));

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }
}
