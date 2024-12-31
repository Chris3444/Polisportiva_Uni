module it.unife.ip {
    requires javafx.controls;
    requires javafx.fxml;

    opens it.unife.ip to javafx.fxml;
    exports it.unife.ip;
}
