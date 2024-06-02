import app.JFXMain;
import app.generation.ITask;
import app.generation.tasks.*;
import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestCases {
    @Test
    public void run() {
        for (int i = 0; i < 10000; i++) {
            List<ITask> taskList = new ArrayList<>();
            taskList.add(new Task1());
            taskList.add(new Task2());
            taskList.add(new Task3());
            taskList.add(new Task4());
            taskList.add(new Task5());
            taskList.add(new Task6());
            taskList.add(new Task7());
            taskList.add(new Task8());
            taskList.add(new Task9());
            taskList.add(new Task10());
            taskList.add(new Task11());
            taskList.add(new Task12());
            taskList.add(new Task13());
            taskList.add(new Task14());
            taskList.add(new Task15());
            taskList.add(new Task16());
            taskList.add(new Task17());
            taskList.add(new Task18());
            taskList.add(new Task19());
            taskList.add(new Task20());
            taskList.add(new Task21());

            for (ITask task : taskList) {
                System.out.println(task.getTheme());
                Pair<String, String> stringStringPair = task.genRandomTaskTextSolution(JFXMain.random);
                System.out.println(stringStringPair.getKey());
                System.out.println("----");
                System.out.println(stringStringPair.getValue());
            }

            taskList.clear();
        }
    }
}
