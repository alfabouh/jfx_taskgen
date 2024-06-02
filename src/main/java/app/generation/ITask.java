package app.generation;

import javafx.util.Pair;

import java.util.Random;

public interface ITask {
    String getTheme();
    Pair<String, String> genRandomTaskTextSolution(Random random);
}
