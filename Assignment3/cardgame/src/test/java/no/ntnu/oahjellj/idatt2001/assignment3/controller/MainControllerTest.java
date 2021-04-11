package no.ntnu.oahjellj.idatt2001.assignment3.controller;

import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

import javafx.stage.Stage;

import no.ntnu.oahjellj.idatt2001.assignment3.App;
import no.ntnu.oahjellj.idatt2001.assignment3.model.Hand;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.base.WindowMatchers;
import org.testfx.matcher.control.LabeledMatchers;
import static org.testfx.api.FxAssert.verifyThat;

@DisplayName("Tests for MainController")
@ExtendWith(ApplicationExtension.class)
public class MainControllerTest {
    private MainController mainController;
    private final String checkHandSelector = "#checkHandButton";
    private final String dealHandSelector = "#dealHandButton";

    @Start
    public void start (Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("view/MainView.fxml"));
        stage.setScene(new Scene(loader.load(), 600, 300));
        mainController = loader.getController();
        stage.show();
        stage.toFront();
    }

    @Test
    @DisplayName("Deal hand test")
    public void testOnDealHand(FxRobot robot) {
        robot.clickOn(dealHandSelector);
        CardDisplayController cardDisplayController = mainController.getCardDisplayController();
        ImageView[] imageViews = cardDisplayController.getCardArray();

        for (ImageView imageView : imageViews) {
            assertNotNull(imageView.getImage());
        }
    }

    @Test
    @DisplayName("Check empty hand alert test")
    public void testCheckEmptyHand(FxRobot robot) {
        robot.clickOn(checkHandSelector);
        verifyThat(robot.window("No hand dealt"), WindowMatchers.isShowing());
        robot.push(KeyCode.ENTER);
    }

    @Test
    @DisplayName("Check hand shows correct values")
    public void testCheckHand(FxRobot robot) {
        robot.clickOn(dealHandSelector);
        robot.clickOn(checkHandSelector);
        assertEquals(1, robot.listWindows().size());
        Hand hand = mainController.getCardDisplayController().getHand();

        verifyThat("#sumOfFaces", LabeledMatchers.hasText(hand.sumOfFaces() + ""));
        verifyThat("#heartCards", LabeledMatchers.hasText(hand.getCardsOfHeart()));
        if (hand.isFlush()) {
            verifyThat("#flush", LabeledMatchers.hasText("Yes"));
        }else {
            verifyThat("#flush", LabeledMatchers.hasText("No"));
        }
        if (hand.hasQueenOfSpades()) {
            verifyThat("#spadeQueen", LabeledMatchers.hasText("Yes"));
        }else {
            verifyThat("#spadeQueen", LabeledMatchers.hasText("No"));
        }
    }


}
