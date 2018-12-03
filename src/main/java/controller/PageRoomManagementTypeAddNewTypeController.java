package controller;

import model.SqlConnection;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.Optional;

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
        setSpinnerMoth(0,Double.MAX_VALUE);
        setSpinnerDay(0,Double.MAX_VALUE);

    }

    @FXML
    void setSpinnerMoth(double min,double max){
        SpinnerValueFactory<Double> valueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(min, max, min);
        spinnerMonth.setValueFactory(valueFactory);
        spinnerMonth.setEditable(true);
        spinnerMonth.getValueFactory().setValue(0.00);
        TextFormatter formatter = new TextFormatter(valueFactory.getConverter(), valueFactory.getValue());
        spinnerMonth.getEditor().setTextFormatter(formatter);
        valueFactory.valueProperty().bindBidirectional(formatter.valueProperty());
    }

    @FXML
    void setSpinnerDay(double min,double max){
        SpinnerValueFactory<Double> valueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(min, max, min);
        spinnerDay.setValueFactory(valueFactory);
        spinnerDay.setEditable(true);
        spinnerDay.getValueFactory().setValue(0.00);
        TextFormatter formatter = new TextFormatter(valueFactory.getConverter(), valueFactory.getValue());
        spinnerDay.getEditor().setTextFormatter(formatter);
        valueFactory.valueProperty().bindBidirectional(formatter.valueProperty());
    }

    @FXML
    void BtnCorrect(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("คอนเฟิร์ม การเพิ่มประเภทห้อง");
        alert.setHeaderText("คอนเฟิร์ม การเพิ่ม");
        alert.setContentText("คุณแน่ใจที่จะเพิ่ม ประเภทห้อง: "+tf.getText()+" รายวัน: "+spinnerDay.getValue()+" รายเดือน: "+spinnerMonth.getValue()+" ?");
        Optional<ButtonType> action = alert.showAndWait();

        if (action.get() == ButtonType.OK){
            SqlConnection.getSqlConnection().insertTypeRoom(tf.getText(),spinnerMonth.getValue(),spinnerDay.getValue());
            clear();
            GridPane pane = FXMLLoader.load(getClass().getResource("/fxml/PageRoomManagementTypeAll.fxml"));
            gridPane.getChildren().setAll(pane);
        }


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
        GridPane pane = FXMLLoader.load(getClass().getResource("/fxml/DebtReminder.fxml"));
        gridPane.getChildren().setAll(pane);
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
        GridPane pane = FXMLLoader.load(getClass().getResource("/fxml/ManageApartmentAndEditPage.fxml"));
        gridPane.getChildren().setAll(pane);
    }
}
