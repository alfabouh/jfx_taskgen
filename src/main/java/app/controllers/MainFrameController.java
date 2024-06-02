package app.controllers;

import app.JFXMain;
import app.generation.GenerationManager;
import app.generation.ITask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainFrameController {
    private final GenerationManager generationManager;

    @FXML
    private Button compileButton;
    @FXML
    private GridPane checkboxContainer;
    private CheckBox[] checkBoxes;

    @FXML
    private TextField numberInput;

    public MainFrameController() {
        this.generationManager = new GenerationManager();
    }

    public void initialize() {
        List<ITask> tasks = this.getGenerationManager().getTasks();
        this.getGenerationManager().initTasks();
        this.checkBoxes = new CheckBox[tasks.size()];

        int numColumns = 3;
        for (int i = 0; i < tasks.size(); i++) {
            CheckBox checkBox = new CheckBox(tasks.get(i).getTheme());
            checkBox.setWrapText(true);
            this.checkboxContainer.add(checkBox, i % numColumns, i / numColumns);
            this.checkBoxes[i] = checkBox;
        }

        this.numberInput.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                numberInput.setText(oldValue);
            }
        });
    }

    public void compileButton(ActionEvent actionEvent) {
        try {
            String olBText = this.compileButton.getText();
            this.compileButton.setText("Сохраняю...");
            String savePath = null;

            String s1 = this.chooseFolder();
            if (s1 != null && !s1.isEmpty()) {
                savePath = s1;
            } else {
                this.compileButton.setText(olBText);
                return;
            }

            if (!this.areAnyOfCheckBoxesSelected()) {
                this.compileButton.setText(olBText);
                JFXMain.showWarn("Ни одно задание не выбрано!");
                return;
            }

            int genTotal = this.numberInput.textProperty().get() == null || this.numberInput.textProperty().get().isEmpty() ? 1 : Integer.parseInt(this.numberInput.textProperty().get());
            if (genTotal < 0 || genTotal > 99) {
                this.compileButton.setText(olBText);
                JFXMain.showWarn("Превышено допустимое количество генераций (0-99)!");
                return;
            }

            if (this.getGenerationManager().genDOCXFile(savePath, this.getSelectedBoxes(), genTotal)) {
                JFXMain.showSuccess("Файл успешно сохранен!");
            } else {
                JFXMain.showWarn("Произошли ошибки при сохранении файла!");
            }
            this.compileButton.setText(olBText);

        } catch (Exception e) {
            JFXMain.showWarn(e.getMessage());
            e.printStackTrace(System.err);
        }
    }

    public List<Integer> getSelectedBoxes() {
        return IntStream.range(0, checkBoxes.length).filter(i -> checkBoxes[i].isSelected()).boxed().collect(Collectors.toList());
    }

    private String chooseFolder() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Выберите папку сохранения");
        File selectedDirectory = directoryChooser.showDialog(null);

        if (selectedDirectory != null) {
            return selectedDirectory.getAbsolutePath();
        }

        return null;
    }

    public GenerationManager getGenerationManager() {
        return this.generationManager;
    }

    public void chooseAllCheckBoxes(ActionEvent actionEvent) {
        if (Arrays.stream(this.checkBoxes).allMatch(CheckBox::isSelected)) {
            for (CheckBox checkBox : this.checkBoxes) {
                checkBox.setSelected(false);
            }
            return;
        }
        for (CheckBox checkBox : this.checkBoxes) {
            checkBox.setSelected(true);
        }
    }

    public boolean areAnyOfCheckBoxesSelected() {
        return !this.getSelectedBoxes().isEmpty();
    }
}
