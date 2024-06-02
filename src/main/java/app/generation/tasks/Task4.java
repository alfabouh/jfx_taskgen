package app.generation.tasks;

import app.JFXMain;
import app.generation.ITask;
import javafx.util.Pair;

import java.util.Random;

public class Task4 implements ITask {
    @Override
    public String getTheme() {
        return "Тип 4";
    }

    @SuppressWarnings("all")
    @Override
    public Pair<String, String> genRandomTaskTextSolution(Random random) {
        return JFXMain.random.nextBoolean() ? this.type1() : this.type2();
    }

    @SuppressWarnings("all")
    private Pair<String, String> type1() {
        float f1 = (JFXMain.random.nextInt(3) + 5) / 10.0f;
        float f2 = (JFXMain.random.nextInt(4) + 6) / 10.0f;

        String mainPattern = "В библиотеке университета путей сообщения есть две книги по теории вероятностей: В. Е. Гмурмана и А. А. Боровкова. Вероятность того, что в течение семестра будет затребована книга первого автора, равна %.2f, второго — %.2f. Какова вероятность того, что к концу семестра:";
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format(mainPattern, f1, f2));
        stringBuilder.append("\n");
        stringBuilder.append("a) ни одна, ни другая книга не будут затребованы\n");
        stringBuilder.append("б) хотя бы одна из книг будет выдана\n");
        stringBuilder.append("в) будет выдана только книга А. А. Боровкова");

        float F3 = (1.0f - f1) * (1.0f - f2);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(String.format("а) P = (1-%.2f)*(1-%.2f) = ", f1, f2));
        stringBuilder2.append(F3);
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("б) P = 1-(1-%.2f)*(1-%.2f) = ", f1, f2));
        stringBuilder2.append(1.0f - F3);
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("в) P = %.2f*(1-%.2f) = ", f2, f1));
        stringBuilder2.append(f2 * (1.0f - f1));

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }

    @SuppressWarnings("all")
    private Pair<String, String> type2() {
        float f1 = (JFXMain.random.nextInt(3) + 5) / 10.0f;
        float f2 = (JFXMain.random.nextInt(4) + 6) / 10.0f;

        String mainPattern = "Два поэта-песенника предложили по одной песне исполнителю. Известно, что песни первого поэта эстрадный певец включает в свой репертуар с вероятностью %.2f, второго — с вероятностью %.2f. Какова вероятность того, что певец возьмет:";
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format(mainPattern, f1, f2));
        stringBuilder.append("\n");
        stringBuilder.append("a) обе песни\n");
        stringBuilder.append("б) хотя бы одну\n");
        stringBuilder.append("в) только песню второго поэта?");

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(String.format("а) P = %.2f*%.2f = ", f1, f2));
        stringBuilder2.append(f1 * f2);
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("б) P = %.2f+%.2f-%.2f*%.2f = ", f1, f2, f1, f2));
        stringBuilder2.append(f1 + f2 - f1 * f2);
        stringBuilder2.append("\n");
        stringBuilder2.append(String.format("в) P = (1-%.2f)*%.2f = ", f1, f2));
        stringBuilder2.append((1.0f - f1) * f2);

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }
}
