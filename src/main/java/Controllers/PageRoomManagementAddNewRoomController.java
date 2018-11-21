package Controllers;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.ArrayList;

public class PageRoomManagementAddNewRoomController {

    @FXML
    private TextField tf;

    @FXML
    private Spinner<Integer> spinner = new Spinner<Integer>();


    @FXML
    private ComboBox<String> cb;

    @FXML
    private Button btnIC;

    @FXML
    private Button btnC;

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
    public  void initialize() {
        ArrayList<String> lstTest = new ArrayList<String>();
        lstTest.add("A");
        lstTest.add("B");
        setSpinner(1,8);
        setComboBox(lstTest);

    }


    @FXML
    void setSpinner(int min,int max){
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(min, max, min);
        spinner.setValueFactory(valueFactory);

    }

    @FXML
    void setComboBox(ArrayList<String> lst){
        cb.setItems(FXCollections.observableArrayList(
                lst));
    }

    @FXML
    void  clear(){
        cb.getSelectionModel().select("");
        tf.setText("");
        spinner.getValueFactory().setValue(1);
    }

    @FXML
    void BtnCorrect(ActionEvent event) {
        System.out.println(tf.getText());
        System.out.println(cb.getValue());
        System.out.println(spinner.getValue());

        clear();
    }

    @FXML
    void BtnInCorrect(ActionEvent event) throws IOException {
        GridPane pane = FXMLLoader.load(getClass().getResource("/fxml/PageRoomManagementMain.fxml"));
        gridPane.getChildren().setAll(pane);

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