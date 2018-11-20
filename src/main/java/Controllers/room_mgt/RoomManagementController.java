package Controllers.room_mgt;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class RoomManagementController {

    @FXML
    private BorderPane mainPane;

    @FXML
    private void initialize() throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("/fxml/room-mgt/room-list.fxml"));
        setMainPane(pane);
    }

    public void setMainPane(Pane pane) {
        this.mainPane.setCenter(pane);
    }
}
