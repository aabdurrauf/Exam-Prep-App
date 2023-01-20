module com.example.finalstudymanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.finalstudymanagementsystem to javafx.fxml;
    exports com.example.finalstudymanagementsystem;
}