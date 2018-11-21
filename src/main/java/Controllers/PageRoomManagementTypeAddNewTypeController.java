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
    private Spinner<Double> spinnerMonth;

    @FXML
    private Spinner<Double> spinnerDay;

    @FXML
    public  void initialize() {
        setSpinnerMoth(1,100000);
        setSpinnerDay(1,100000);

    }

    @FXML
    void setSpinnerMoth(double min,double max){
        SpinnerValueFactory<Double> valueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(min, max, min);
        spinnerMonth.setValueFactory(valueFactory);
        spinnerMonth.setEditable(true);
    }

    @FXML
    void setSpinnerDay(double min,double max){
        SpinnerValueFactory<Double> valueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(min, max, min);
        spinnerDay.setValueFactory(valueFactory);
        spinnerDay.setEditable(true);
    }

    @FXML
    void BtnCorrect(ActionEvent event) throws IOException {
        SqlConnection.getSqlConnection().insertTypeRoom(tf.getText(),spinnerMonth.getValue(),spinnerDay.getValue());
        clear();
        GridPane pane = FXMLLoader.load(getClass().getResource("/fxml/PageRoomManagementTypeAll.fxml"));
        gridPane.getChildren().setAll(pane);


    }


    @FXML
    void BtnInCorrect(ActionEvent event) throws IOException {
        GridPane pane = FXMLLoader.load(getClass().getResource("/fxml/PageRoomManagementTypeAll.fxml"));
        gridPane.getChildren().setAll(pane);

    }

    @FXML
    void  clear(){
        tf.setText("");
        spinnerDay.getValueFactory().setValue(1.0);
        spinnerMonth.getValueFactory().setValue(1.0);
    }

    //ไปหน้าค้นหาจากเมนู
    @FXML
    void handleFeature1Btn(ActionEvent event) throws IOException {
        GridPane pane = FXMLLoader.load(getClass().getResource("/fxml/Feature1Page1.fxml"));
        gridPane.getChildren().setAll(pane);
    }

    //ไปหน้าแจ้งชำระจากเมนู
    @FXML
    void handleFeature2Btn(ActionEvent event) throws IOException {

    }

    //ไปหน้าจัดการห้องจากเมนู
    @FXML
    void handleFeature4Btn(ActionEvent event) throws IOException {
        //Fluke Pipatphol coming
        GridPane pane = FXMLLoader.load(getClass().getResource("/fxml/PageRoomManagementMain.fxml"));
        gridPane.getChildren().setAll(pane);

    }

    //ไปหน้าจัดการหอพักจากเมนู
    @FXML
    void handleFeature5Btn(ActionEvent event) throws IOException {
        GridPane pane = FXMLLoader.load(getClass().getResource("/fxml/ManangeApartmentAndEditPage.fxml"));
        gridPane.getChildren().setAll(pane);
    }
}
