package Controllers;

import Models.RoomManagementType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class PageRoomManagementTypeAllController {
    @FXML
    private GridPane gridPane;

    @FXML
    private TableView<RoomManagementType> table_typeAll;

    @FXML
    private TableColumn<RoomManagementType, String> col_name;

    @FXML
    private TableColumn<RoomManagementType, String> col_amountD;

    @FXML
    private TableColumn<RoomManagementType, String> col_amountM;

    @FXML
    private TableColumn<RoomManagementType, Button> col_detail;

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
    public  void initialize() {
        initTable();
        setStyleCols();
        loadData();
    }

    private void initTable(){
        initCols();
    }
    private void initCols(){
//        name,amountM,detail;

        col_name.setCellValueFactory(new PropertyValueFactory<RoomManagementType, String>("name"));
        col_amountD.setCellValueFactory(new PropertyValueFactory<RoomManagementType, String>("amountD"));
        col_amountM.setCellValueFactory(new PropertyValueFactory<RoomManagementType, String>("amountM"));
        col_detail.setCellValueFactory(new PropertyValueFactory<RoomManagementType, Button>("detail"));
        editTableCols();
    }
    private void setStyleCols(){
        //CENTER-RIGHT,CENTER-LEFT,CENTER
        table_typeAll.setEditable(false);
        col_name.setStyle("-fx-alignment: CENTER");
        col_amountD.setStyle("-fx-alignment: CENTER");
        col_amountM.setStyle("-fx-alignment: CENTER");
        col_detail.setStyle("-fx-alignment: CENTER");
    }
    private void editTableCols(){
        col_name.setCellFactory(TextFieldTableCell.<RoomManagementType>forTableColumn());

        col_name.setOnEditCommit(e-> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setName(e.getNewValue());
        });

        col_amountD.setCellFactory(TextFieldTableCell.<RoomManagementType>forTableColumn());

        col_amountD.setOnEditCommit( e-> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setAmountD(e.getNewValue());
        });

        col_amountM.setCellFactory(TextFieldTableCell.<RoomManagementType>forTableColumn());

        col_amountM.setOnEditCommit( e-> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setAmountM(e.getNewValue());
        });


        table_typeAll.setEditable(true);

    }

    private void loadData(){
        ObservableList<RoomManagementType> data_table = FXCollections.observableArrayList();
        String fxml = "/fxml/PageRoomManagementInfoTypeRoom.fxml" ;
        for(int i=0 ; i<7 ; i++){
            data_table.add(new RoomManagementType("name"+i,""+(i+1),""+(i+1),new Button("รายละเอียด"),fxml));
        }

        table_typeAll.setItems(data_table);
    }





    @FXML
    void BtnLeftArrow(ActionEvent event) throws IOException {
        GridPane pane = FXMLLoader.load(getClass().getResource("/fxml/PageRoomManagementMain.fxml"));
        gridPane.getChildren().setAll(pane);
    }



    @FXML
    void BtnAddNewType(ActionEvent event) throws IOException {
        GridPane pane = FXMLLoader.load(getClass().getResource("/fxml/PageRoomManagementTypeAddNewType.fxml"));
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
