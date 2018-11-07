package Controllers;

import Models.SqlConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class ManageApartmentPage1Controller {

    @FXML
    private GridPane gridPane;

    //ปุ่มของเมนู
    @FXML
    private Button feature1Btn;
    @FXML
    private Button feature2Btn;
    @FXML
    private Button feature4Btn;
    @FXML
    private Button feature5Btn;

    //จัดการหอพัก
    //ไบร์ทเขียน
    @FXML
    private Label name_apartment;

    @FXML
    private Label date_pay_money;
    @FXML
    private Button edit_data;



    public void initialize(){
        name_apartment.setText(SqlConnection.selectNameOfApartment());
        date_pay_money.setText(SqlConnection.selectDatePayMoney());


    }





    //ไปหน้าค้นหาจากเมนู
    @FXML
    void handleFeature1Btn(ActionEvent event) throws IOException {
        GridPane pane = FXMLLoader.load(getClass().getResource("/fxml/Feature1Page1.fxml"));
        gridPane.getChildren().setAll(pane);
    }

    //ไปหน้าแจ้งชำระจากเมนู
    @FXML
    void handleFeature2Btn(ActionEvent event) {

    }

    //ไปหน้าจัดการห้องจากเมนู
    @FXML
    void handleFeature4Btn(ActionEvent event) {

    }

    //ไปหน้าจัดการหอพักจากเมนู
    @FXML
    void handleFeature5Btn(ActionEvent event) {

    }



    //
    @FXML
    void changeToEditPageAboutApartment(ActionEvent event) throws IOException {
        GridPane pane = FXMLLoader.load(getClass().getResource("/fxml/ManageApartmentPage2Edit.fxml"));
        gridPane.getChildren().setAll(pane);

    }

}
