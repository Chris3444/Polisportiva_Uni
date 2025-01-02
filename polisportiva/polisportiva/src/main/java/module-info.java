module it.unife.ip {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;

    opens it.unife.ip to javafx.fxml;
    exports it.unife.ip;
}
