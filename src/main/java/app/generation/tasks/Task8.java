package app.generation.tasks;

import app.JFXMain;
import app.generation.ITask;
import javafx.util.Pair;

import java.util.Random;

public class Task8 implements ITask {
    @Override
    public String getTheme() {
        return "Тип 8";
    }

    @SuppressWarnings("all")
    @Override
    public Pair<String, String> genRandomTaskTextSolution(Random random) {
        return JFXMain.random.nextBoolean() ? this.type1() : this.type2();
    }

    @SuppressWarnings("all")
    private Pair<String, String> type1() {
        int book1 = JFXMain.random.nextInt(20) + 10;
        int book2 = JFXMain.random.nextInt(20) + 10;
        int book3 = JFXMain.random.nextInt(20) + 10;
        float prob1 = (JFXMain.random.nextInt(5) + 4) / 10.0f;
        float prob2 = prob1 + 0.1f;
        float prob3 = (JFXMain.random.nextInt(6) + 3) / 10.0f;

        String mainPattern = "Перед математической олимпиадой особой популярностью пользовались книги Якова Исидоровича Перельмана: в библиотеке %d раз заказывали его книгу «Живая математика», %d раз — «Занимательные задачи», %d раз — «Загадки и диковинки в мире чисел». Подбор задач для олимпиады таков, что вероятность решить задачу студенту, прочитавшему книгу «Живая математика», равна %.2f, «Занимательные задачи» — %.2f, «Загадки» — %.2f. Студент Филькин радостно сообщил, что решил задачу на олимпиаде. Какую книгу Перельмана вероятнее всего он прочитал?";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(mainPattern, book1, book2, book3, prob1, prob2, prob3));

        int summ = (book1 + book2 + book3);
        float p1 = (prob1 * (float) (book1 / (float) summ)) / ((prob1 * (float) (book1 / (float) summ)) + (prob2 * (float) (book2 / (float) summ)) + (prob3 * (float) (book3 / (float) summ)));
        float p2 = (prob2 * (float) (book2 / (float) summ)) / ((prob1 * (float) (book1 / (float) summ)) + (prob2 * (float) (book2 / (float) summ)) + (prob3 * (float) (book3 / (float) summ)));
        float p3 = (prob3 * (float) (book3 / (float) summ)) / ((prob1 * (float) (book1 / (float) summ)) + (prob2 * (float) (book2 / (float) summ)) + (prob3 * (float) (book3 / (float) summ)));
        float maxProb = Math.max(p1, Math.max(p2, p3));
        String answer;
        if (maxProb == p1) {
            answer = "«Живая математика»";
        } else if (maxProb == p2) {
            answer = "«Занимательные задачи»";
        } else {
            answer = "«Загадки и диковинки в мире чисел»";
        }

        return new Pair<>(stringBuilder.toString(), answer);
    }

    @SuppressWarnings("all")
    private Pair<String, String> type2() {
        float f1 = (JFXMain.random.nextInt(8) + 2) / 10.0f;
        float f2 = (JFXMain.random.nextInt(8) + 2) / 10.0f;
        float f3 = (JFXMain.random.nextInt(8) + 2) / 10.0f;

        String mainPattern = "Электростанция оборудована генератором электрического тока, приводимым во вращение дизельным двигателем. Состояние оборудования и воспламенительные свойства дизельного топлива (цетановое число) таковы, что при использовании в качестве топлива соляровых фракций прямой перегонки нефти генератор приходит в аварийное состояние с вероятностью %.2f, при использовании керосиновых фракций — с вероятностью %.2f, а при использовании газойлевых фракций — с вероятностью %.2f. %d %s %d года электростанция исправно давала ток. Какова вероятность того, что в этот день дизельный двигатель работал на солярке, если тот или иной вид топлива используется с равной вероятностью? ";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(mainPattern, f1, f2, f3, 23, "декабря", 1999));

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(String.format("P = (1-%.2f)/((1-%.2f)+(1-%.2f)+(1-%.2f)) = %.4f", (f1), (f1), (f2), (f3), (1.0f - f1) / ((1.0f - f1) + (1.0f - f2) + (1.0f - f3))));

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }
}
