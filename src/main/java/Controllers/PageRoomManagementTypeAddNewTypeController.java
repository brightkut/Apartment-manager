package Controllers;

import Models.SqlConnection;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class PageRoomManagementTypeAddNewTypeController {
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
    private Button btnIC;

    @FXML
    private Button btnC;

    @FXML
    private TextField tf;

    @FXML
    private Spinner<Integer> spinnerMonth;

    @FXML
    private Spinner<Integer> spinnerDay;

    @FXML
    public  void initialize() {
        setSpinnerMoth(1,100000);
        setSpinnerDay(1,100000);

    }

    @FXML
    void setSpinnerMoth(int min,int max){
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(min, max, min);
        spinnerMonth.setValueFactory(valueFactory);
        spinnerMonth.setEditable(true);
    }

    @FXML
    void setSpinnerDay(int min,int max){
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(min, max, min);
        spinnerDay.setValueFactory(valueFactory);
        spinnerDay.setEditable(true);
    }

    @FXML
    void BtnCorrect(ActionEvent event) {
        System.out.println(tf.getText());
        System.out.println(spinnerMonth.getValue());
        System.out.println(spinnerDay.getValue());


        SqlConnection.getSqlConnection().insertTypeRoom(tf.getText(),spinnerMonth.getValue(),spinnerDay.getValue());
        clear();

    }


    @FXML
    void BtnInCorrect(ActionEvent event) throws IOException {
        GridPane pane = FXMLLoader.load(getClass().getResource("/fxml/PageRoomManagementTypeAll.fxml"));
        gridPane.getChildren().setAll(pane);

    }

    @FXML
    void  clear(){
        tf.setText("");
        spinnerDay.getValueFactory().setValue(1);
        spinnerMonth.getValueFactory().setValue(1);
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
