package app.generation;

import app.JFXMain;
import app.generation.tasks.*;
import javafx.util.Pair;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSpacing;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STLineSpacingRule;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class GenerationManager {
    private final List<ITask> tasks;

    public GenerationManager() {
        this.tasks = new ArrayList<>();
    }

    public void initTasks() {
        this.getTasks().add(new Task1());
        this.getTasks().add(new Task2());
        this.getTasks().add(new Task3());
        this.getTasks().add(new Task4());
        this.getTasks().add(new Task5());
        this.getTasks().add(new Task6());
        this.getTasks().add(new Task7());
        this.getTasks().add(new Task8());
        this.getTasks().add(new Task9());
        this.getTasks().add(new Task10());
        this.getTasks().add(new Task11());
        this.getTasks().add(new Task12());
        this.getTasks().add(new Task13());
        this.getTasks().add(new Task14());
        this.getTasks().add(new Task15());
        this.getTasks().add(new Task16());
        this.getTasks().add(new Task17());
        this.getTasks().add(new Task18());
        this.getTasks().add(new Task19());
        this.getTasks().add(new Task20());
        this.getTasks().add(new Task21());
    }

    public List<ITask> getTasks() {
        return this.tasks;
    }

    public boolean genDOCXFile(String path, List<Integer> idx, int totalPages) {
        File folder = new File(path);
        if (folder.exists()) {
            if (folder.isDirectory() && folder.canWrite()) {
                try (XWPFDocument doc = new XWPFDocument(); FileOutputStream out = new FileOutputStream(path + "/generated_tasks_" + JFXMain.date() + ".docx")) {
                    for (int i = 0; i < totalPages; i++) {
                        List<Pair<String, String>> list = this.genTasks(idx);

                        XWPFParagraph titleParagraph = doc.createParagraph();
                        titleParagraph.setSpacingAfter(300);
                        CTPPr ppr = titleParagraph.getCTP().addNewPPr();
                        CTSpacing spacing = ppr.addNewSpacing();
                        spacing.setLineRule(STLineSpacingRule.AUTO);
                        spacing.setLine(BigInteger.valueOf(300));

                        XWPFRun titleRun = titleParagraph.createRun();
                        titleRun.setText("Вариант " + (i + 1));
                        titleRun.setFontFamily("Times New Roman");
                        titleRun.setFontSize(12);
                        titleRun.setBold(true);

                        for (int p = 0; p < list.size(); p++) {
                            Pair<String, String> pair = list.get(p);
                            XWPFParagraph keyParagraph = doc.createParagraph();
                            keyParagraph.setSpacingAfter(300);
                            CTPPr ppr1 = keyParagraph.getCTP().addNewPPr();
                            CTSpacing spacing1 = ppr1.addNewSpacing();
                            spacing1.setLineRule(STLineSpacingRule.AUTO);
                            spacing1.setLine(BigInteger.valueOf(300));

                            XWPFRun taskRun = keyParagraph.createRun();
                            taskRun.setText("Задание " + (p + 1) + ". ");
                            taskRun.setFontFamily("Times New Roman");
                            taskRun.setFontSize(12);
                            taskRun.setBold(true);

                            String[] keyLines = pair.getKey().split("\n");
                            for (String keyLine : keyLines) {
                                XWPFRun keyRun = keyParagraph.createRun();
                                keyRun.addBreak();
                                keyRun.setFontFamily("Times New Roman");
                                keyRun.setFontSize(12);
                                keyRun.setText(keyLine);
                            }
                        }

                        if (i < totalPages - 1) {
                            doc.createParagraph().createRun().addBreak(BreakType.PAGE);
                        }
                    }
                    doc.write(out);
                } catch (IOException e) {
                    JFXMain.showWarn(e.getMessage());
                    System.err.println(e.getMessage());
                    return false;
                }
                try (XWPFDocument doc = new XWPFDocument(); FileOutputStream out = new FileOutputStream(path + "/generated_answers_" + JFXMain.date() + ".docx")) {
                    for (int i = 0; i < totalPages; i++) {
                        List<Pair<String, String>> list = this.genTasks(idx);

                        XWPFParagraph answerTitleParagraph = doc.createParagraph();
                        answerTitleParagraph.setSpacingAfter(300);
                        CTPPr ppr2 = answerTitleParagraph.getCTP().addNewPPr();
                        CTSpacing spacing2 = ppr2.addNewSpacing();
                        spacing2.setLineRule(STLineSpacingRule.AUTO);
                        spacing2.setLine(BigInteger.valueOf(300));

                        XWPFRun answerTitleRun = answerTitleParagraph.createRun();
                        answerTitleRun.setText("Вариант " + (i + 1) + " (ответы)");
                        answerTitleRun.setFontFamily("Times New Roman");
                        answerTitleRun.setFontSize(12);
                        answerTitleRun.setBold(true);

                        for (int p = 0; p < list.size(); p++) {
                            Pair<String, String> pair = list.get(p);
                            XWPFParagraph valueParagraph = doc.createParagraph();
                            valueParagraph.setSpacingAfter(300);
                            CTPPr ppr1 = valueParagraph.getCTP().addNewPPr();
                            CTSpacing spacing1 = ppr1.addNewSpacing();

                            spacing1.setLineRule(STLineSpacingRule.AUTO);
                            spacing1.setLine(BigInteger.valueOf(300));

                            XWPFRun taskRun = valueParagraph.createRun();
                            taskRun.setText("Задание " + (p + 1) + ". ");
                            taskRun.setFontFamily("Times New Roman");
                            taskRun.setFontSize(12);
                            taskRun.setBold(true);

                            XWPFRun taskRun2 = valueParagraph.createRun();
                            taskRun2.setFontFamily("Times New Roman");
                            taskRun2.setFontSize(12);
                            taskRun2.setBold(true);

                            String[] keyLines = pair.getValue().split("\n");
                            for (String keyLine : keyLines) {
                                XWPFRun keyRun = valueParagraph.createRun();
                                keyRun.addBreak();
                                keyRun.setFontFamily("Times New Roman");
                                keyRun.setFontSize(12);
                                keyRun.setText(keyLine);
                            }
                        }

                        if (i < totalPages - 1) {
                            doc.createParagraph().createRun().addBreak(BreakType.PAGE);
                        }
                    }
                    doc.write(out);
                } catch (IOException e) {
                    JFXMain.showWarn(e.getMessage());
                    System.err.println(e.getMessage());
                    return false;
                }
            } else {
                JFXMain.showWarn("Невозможно сохранить файлы в указанную папку!");
                return false;
            }
        } else {
            JFXMain.showWarn("Указанной папки не существует!");
            return false;
        }
        return true;
    }

    private List<Pair<String, String>> genTasks(List<Integer> idx) {
        List<Pair<String, String>> list = new ArrayList<>();
        for (int i : idx) {
            list.add(this.getTasks().get(i).genRandomTaskTextSolution(JFXMain.random));
        }
        return list;
    }
}
