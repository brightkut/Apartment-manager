package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Feature1Page1Controller {

    @FXML
    private Button feature1Btn;
    @FXML
    private Button feature2Btn;
    @FXML
    private Button feature4Btn;
    @FXML
    private Button feature5Btn;

    @FXML
    private Button monthlyBtn;
    @FXML
    private Button dailyBtn;

    @FXML
    private DatePicker fromDatePicker;
    @FXML
    private DatePicker toDatePicker;
    @FXML
    private TextField numMonthField;
    @FXML
    private ComboBox<?> roomTypeBox;
    @FXML
    private ComboBox<?> floorBox;

    @FXML
    private Button searchBtn;

    @FXML
    private Label toDateLabel;
    @FXML
    private Label numMonthLabel;
    @FXML
    private Label errorLabel;

    @FXML
    private TableView<?> tableView;
    @FXML
    private TableColumn<?, ?> roomNameCol;
    @FXML
    private TableColumn<?, ?> roomTypeCol;
    @FXML
    private TableColumn<?, ?> floorCol;
    @FXML
    private TableColumn<?, ?> buttonCol;

    @FXML
    void handleFeature1Btn(ActionEvent event) throws IOException {
        Stage stage = (Stage) searchBtn.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Feature1Page1.fxml"));
        stage.setScene(new Scene((Parent) loader.load(), 1280, 800));
        stage.show();
    }

    @FXML
    void handleFeature2Btn(ActionEvent event) {

    }

    @FXML
    void handleFeature4Btn(ActionEvent event) {

    }

    @FXML
    void handleFeature5Btn(ActionEvent event) {

    }


    @FXML
    void handleDailyBtn(ActionEvent event) {

    }

    @FXML
    void handleMonthlyBtn(ActionEvent event) {

    }

    @FXML
    void handleSeachBtn(ActionEvent event) {

    }

}
