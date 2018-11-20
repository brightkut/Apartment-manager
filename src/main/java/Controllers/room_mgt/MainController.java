package Controllers.room_mgt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MainController {
    @FXML
    private BorderPane borderPane;

    @FXML
    void handleFeature1Btn(ActionEvent event) throws IOException {
        GridPane pane = FXMLLoader.load(getClass().getResource("/fxml/Feature1Page1.fxml"));
        setMainPane(pane);
    }

    //ไปหน้าแจ้งชำระจากเมนู
    @FXML
    void handleFeature2Btn(ActionEvent event) throws IOException {
    }

    //ไปหน้าจัดการห้องจากเมนู
    @FXML
    void handleFeature4Btn(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("/fxml/room-mgt/room-main.fxml"));
        setMainPane(pane);
    }

    //ไปหน้าจัดการหอพักจากเมนู
    @FXML
    void handleFeature5Btn(ActionEvent event) {

    }

    public void setMainPane(Pane pane) {
        borderPane.setCenter(pane);
    }

}
