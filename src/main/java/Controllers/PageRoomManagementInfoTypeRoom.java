package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class PageRoomManagementInfoTypeRoom {

    @FXML
    private GridPane gridPane;

    @FXML
    private Button feature1Btn;

    @FXML
    private Button feature2Btn;

    @FXML
    private Button feature4Btn;

    @FXML
    private Button feature5Btn;

    @FXML
    private Button leftArrow;

    @FXML
    private Button btnIC;

    @FXML
    private Button btnEdit;

    @FXML
    private Label label_type;

    @FXML
    private Label label_amountD;

    @FXML
    private Label label_amountM;

    @FXML
    void setData(String type,int m,int d){
        label_type.setText(type);
        label_amountD.setText(""+d);
        label_amountM.setText(""+m);
    }

    @FXML
    void BtnDelete(ActionEvent event) {

    }

    @FXML
    void BtnEdit(ActionEvent event) throws IOException {
//        GridPane pane = FXMLLoader.load(getClass().getResource("/fxml/PageRoomManagementEditTypeRoom.fxml"));
//        gridPane.getChildren().setAll(pane);

        Button b = (Button) event.getSource();

        Stage stage = (Stage) b.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PageRoomManagementEditTypeRoom.fxml"));
        try {
            stage.setScene(new Scene((Parent) loader.load(), 1280, 800));

            PageRoomManagementEditTypeRoom controller = loader.getController();
            controller.setData(label_type.getText(),Integer.parseInt(label_amountM.getText()),Integer.parseInt(label_amountD.getText()));

            stage.show();

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @FXML
    void BtnLeftArrow(ActionEvent event) throws IOException {
        GridPane pane = FXMLLoader.load(getClass().getResource("/fxml/PageRoomManagementTypeAll.fxml"));
        gridPane.getChildren().setAll(pane);
    }

    @FXML
    void handleFeature1Btn(ActionEvent event) {

    }

    @FXML
    void handleFeature2Btn(ActionEvent event) {

    }

    @FXML
    void handleFeature4Btn(ActionEvent event) throws IOException {
        GridPane pane = FXMLLoader.load(getClass().getResource("/fxml/PageRoomManagementMain.fxml"));
        gridPane.getChildren().setAll(pane);
    }

    @FXML
    void handleFeature5Btn(ActionEvent event) {

    }
}
