module com.example.tptictactoefx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tptictactoefx to javafx.fxml;
    exports com.example.tptictactoefx;
}