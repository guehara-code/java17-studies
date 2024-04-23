module org.example._2501helloworldfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example._2501helloworldfx to javafx.fxml;
    exports org.example._2501helloworldfx;
}