package app.generation.tasks;

import app.generation.ITask;
import javafx.util.Pair;

import java.util.Random;

public class DemoTask implements ITask {
    @Override
    public String getTheme() {
        return "Demo1";
    }

    @Override
    public Pair<String, String> genRandomTaskTextSolution(Random random) {
        int i1 = random.nextInt(5) + 2;
        String s1 = String.format("Было %d козла. Сколько?", i1);
        String s2 = new String("228");

        return new Pair<>(s1, s2);
    }
}
