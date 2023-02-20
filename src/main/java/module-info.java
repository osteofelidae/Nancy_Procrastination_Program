module com.osteofelidae.nancy_procrastination_program {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.osteofelidae.nancy_procrastination_program to javafx.fxml;
    exports com.osteofelidae.nancy_procrastination_program;
}