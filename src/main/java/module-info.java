module app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.apache.poi.ooxml;
    requires commons.math3;

    opens app.controllers to javafx.fxml;
    exports app;
    exports app.generation;
    exports app.generation.tasks;
}