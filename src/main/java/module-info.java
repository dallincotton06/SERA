module org.example.sera {
    requires javafx.fxml;
    requires javafx.web;


    opens org.example.sera to javafx.fxml;
    exports org.example.sera;
    exports org.example.sera.Controllers;
    opens org.example.sera.Controllers to javafx.fxml;
}