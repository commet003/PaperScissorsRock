module com.corie.paperscissorsrock {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.corie.paperscissorsrock to javafx.fxml;
    exports com.corie.paperscissorsrock;
}