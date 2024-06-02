package app.generation.tasks;

import app.JFXMain;
import app.generation.ITask;
import javafx.util.Pair;
import org.apache.commons.math3.util.CombinatoricsUtils;

import java.util.Random;

public class Task3 implements ITask {
    @Override
    public String getTheme() {
        return "Тип 3";
    }

    @SuppressWarnings("all")
    @Override
    public Pair<String, String> genRandomTaskTextSolution(Random random) {
        return JFXMain.random.nextBoolean() ? this.type1() : this.type2();
    }

    @SuppressWarnings("all")
    private Pair<String, String> type1() {
        String mainPattern = "Эксперимент состоит в двух выстрелах по мишени. Событие А — попадание в мишень первым выстрелом; событие В — попадание в мишень вторым выстрелом. Постройте множество элементарных исходов и выявите состав подмножеств, соответствующих событиям:";
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(mainPattern);
        stringBuilder.append("\n");
        stringBuilder.append("a) A ∪ B\n");
        stringBuilder.append("б) A ∩ B\n");
        stringBuilder.append("в) ¬A ∪ ¬B");

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("П - попал\nН – не попал\n");
        stringBuilder2.append("а) A ∪ B = {НП, ПН, ПП}\n");
        stringBuilder2.append("б) A ∩ B = {ПП}\n");
        stringBuilder2.append("в) ¬A ∪ ¬B = {НН, НП, ПН}\n");

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }

    @SuppressWarnings("all")
    private Pair<String, String> type2() {
        int a1 = JFXMain.random.nextInt(3) + 2;
        int a2 = a1 - 1;
        int a3 = a2 + 3;
        String mainPattern = "Эксперимент состоит в бросании игральной кости. Пусть событие А — появление больше %d очков, событие В — появление больше %d и меньше %d очков. Выразите событие С через события А и В. Постройте множество элементарных исходов, и выявите состав подмножеств, соответствующих событиям: ";
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format(mainPattern, a1, a2, a3));
        stringBuilder.append("\n");
        stringBuilder.append("a) A ∪ B\n");
        stringBuilder.append("б) A ∩ ¬B");

        String s = "";

        for (int i = 1; i <= 6; i++) {
            if (i > a1 || (i > a2 && i < a3)) {
                s += i + ",";
            }
        }

        String s2 = "";

        for (int i = 1; i <= 6; i++) {
            if (i > a1 && !(i > a2 && i < a3)) {
                s2 += i + ",";
            }
        }

        if (s.endsWith(",")) {
            s = s.substring(0, s.length() - 1);
        }

        if (s2.endsWith(",")) {
            s2 = s2.substring(0, s2.length() - 1);
        }

        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("а) A ∪ B = {" + s + "}\n");
        stringBuilder2.append("б) A ∩ ¬B = {" + s2 + "}\n");

        return new Pair<>(stringBuilder.toString(), stringBuilder2.toString());
    }
}
