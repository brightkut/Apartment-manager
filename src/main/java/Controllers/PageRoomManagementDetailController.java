package Controllers;

import Models.RoomManagementDetail;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class PageRoomManagementDetailController {
    @FXML
    private GridPane gridPane;

    @FXML
    private TextField textF_name;

    @FXML
    private TextField textF_type;

    @FXML
    private Spinner<Double> spinner_floor;

//label
    @FXML
    private Label label_nameroom;

    @FXML
    private Label label_typeroom;

    @FXML
    private Label label_floor;

//btn
    @FXML
    private Button btnX;

    @FXML
    private Button btnY;

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
    private Button btnEdit;

    @FXML
    private Button btnIC;

    @FXML
    private TableView<RoomManagementDetail> table_detail;

    @FXML
    private TableColumn<RoomManagementDetail, String> col_dateS;

    @FXML
    private TableColumn<RoomManagementDetail, String> col_dateE;

    @FXML
    private TableColumn<RoomManagementDetail, String> col_tybe;

    @FXML
    private TableColumn<RoomManagementDetail, String> col_user;

    @FXML
    private TableColumn<RoomManagementDetail, String> col_phone;

    @FXML
    private TableColumn<RoomManagementDetail, Button> col_cancel;


    @FXML
    public  void initialize() throws IOException {

        setVisible();

        setSpinner_floor(1,100);
        initTable();
        setStyleCols();
        loadData();
    }


    @FXML
    public void setData(String textF,String textT,Double s){
        label_nameroom.setText(textF);
        label_typeroom.setText(textT);
        label_floor.setText(""+s);
    }

    @FXML
    public void setVisible(){
        btnX.setVisible(false);
        btnY.setVisible(false);
        textF_name.setVisible(false);
        textF_type.setVisible(false);
        spinner_floor.setVisible(false);
    }

    @FXML
    public void setEditDetail(String textF,String textT,Double s){
        textF_name.setText(textF);
        textF_type.setText(textT);
        spinner_floor.getValueFactory().setValue(s);

    }
    @FXML
    void setSpinner_floor(double min,double max){
        SpinnerValueFactory<Double> valueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(min, max, min);
        spinner_floor.setValueFactory(valueFactory);
        spinner_floor.setEditable(false);
    }




    private void initTable(){
        initCols();
    }
    private void initCols(){
        //date_star, date_end,type,user,phone

        col_dateS.setCellValueFactory(new PropertyValueFactory<RoomManagementDetail, String>("date_star"));
        col_dateE.setCellValueFactory(new PropertyValueFactory<RoomManagementDetail, String>("date_end"));
        col_tybe.setCellValueFactory(new PropertyValueFactory<RoomManagementDetail, String>("type"));
        col_user.setCellValueFactory(new PropertyValueFactory<RoomManagementDetail, String>("user"));
        col_phone.setCellValueFactory(new PropertyValueFactory<RoomManagementDetail, String>("phone"));
        col_cancel.setCellValueFactory(new PropertyValueFactory<RoomManagementDetail, Button>("cancel"));
        editTableCols();
    }
    private void setStyleCols(){
        //CENTER-RIGHT,CENTER-LEFT,CENTER
        table_detail.setEditable(false);
        col_dateS.setStyle("-fx-alignment: CENTER");
        col_dateE.setStyle("-fx-alignment: CENTER");
        col_tybe.setStyle("-fx-alignment: CENTER");
        col_user.setStyle("-fx-alignment: CENTER");
        col_phone.setStyle("-fx-alignment: CENTER");
        col_cancel.setStyle("-fx-alignment: CENTER");
    }
    private void editTableCols(){
        col_dateS.setCellFactory(TextFieldTableCell.<RoomManagementDetail>forTableColumn());

        col_dateS.setOnEditCommit(e-> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setDate_star(e.getNewValue());
        });



        col_dateE.setCellFactory(TextFieldTableCell.<RoomManagementDetail>forTableColumn());

        col_dateE.setOnEditCommit( e-> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setDate_end(e.getNewValue());
        });

        col_tybe.setCellFactory(TextFieldTableCell.<RoomManagementDetail>forTableColumn());

        col_tybe.setOnEditCommit( e-> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setType(e.getNewValue());
        });

        col_user.setCellFactory(TextFieldTableCell.<RoomManagementDetail>forTableColumn());

        col_user.setOnEditCommit( e-> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setUser(e.getNewValue());
        });

        col_phone.setCellFactory(TextFieldTableCell.<RoomManagementDetail>forTableColumn());

        col_phone.setOnEditCommit( e-> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setPhone(e.getNewValue());
        });


        table_detail.setEditable(true);

    }

    private void loadData() throws IOException {
        ObservableList<RoomManagementDetail> data_table = FXCollections.observableArrayList();
        String fxml = "/fxml/PageRoomManagementDetail.fxml" ;
        for(int i=0 ; i<7 ; i++){
            data_table.add(new RoomManagementDetail("date"+i, "date"+i,"type"+i,"user"+i,"phone"+i,new Button("ยกเลิกการจอง"),fxml));
        }

        table_detail.setItems(data_table);
    }

    @FXML
    void BtnDelete(ActionEvent event) {

    }

    @FXML
    void BtnEdit(ActionEvent event) {
        btnX.setVisible(true);
        btnY.setVisible(true);
        textF_name.setVisible(true);
        textF_type.setVisible(true);
        spinner_floor.setVisible(true);
        btnEdit.setVisible(false);
        setEditDetail(label_nameroom.getText(),label_typeroom.getText(),Double.parseDouble(label_floor.getText()));
    }

    @FXML
    void BtnX(ActionEvent event) {
        btnX.setVisible(false);
        btnY.setVisible(false);
        btnEdit.setVisible(true);
        textF_name.setVisible(false);
        textF_type.setVisible(false);
        spinner_floor.setVisible(false);
    }

    @FXML
    void BtnY(ActionEvent event) {

    }

    @FXML
    void BtnLeftArrow(ActionEvent event) throws IOException {
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
