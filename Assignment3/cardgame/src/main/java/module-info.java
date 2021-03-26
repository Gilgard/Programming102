module no.ntnu.oahjellj.idatt2001.assignment3.cardgame {
    requires javafx.controls;
    requires javafx.fxml;

    opens no.ntnu.oahjellj.idatt2001.assignment3 to javafx.fxml;
    opens no.ntnu.oahjellj.idatt2001.assignment3.Controller to javafx.fxml;
    opens no.ntnu.oahjellj.idatt2001.assignment3.Model to javafx.base;

    exports no.ntnu.oahjellj.idatt2001.assignment3;
}