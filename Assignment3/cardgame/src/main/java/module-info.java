module cardgame {
    requires javafx.controls;
    requires javafx.fxml;

    opens no.ntnu.oahjellj.idatt2001.assignment3 to javafx.fxml;
    opens no.ntnu.oahjellj.idatt2001.assignment3.controller to javafx.fxml;
    opens no.ntnu.oahjellj.idatt2001.assignment3.model to javafx.base;

    exports no.ntnu.oahjellj.idatt2001.assignment3;
}