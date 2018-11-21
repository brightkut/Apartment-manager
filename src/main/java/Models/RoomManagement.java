package Models;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class RoomManagement {

    String name,type,floor;
    Button detail;
    String fxml;

    public RoomManagement(String name, String type, String floor, Button detail,String fxml) {
        this.name = name;
        this.type = type;
        this.floor = floor;
        this.detail = detail;
        this.fxml = fxml;


        detail.setOnAction(e -> {
            System.out.println("detail: "+getName());

            Button b = (Button) e.getSource();

            Stage stage = (Stage) b.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource(this.fxml));
            try {
                stage.setScene(new Scene((Parent) loader.load(), 1280, 800));

//            PageRoomManagementAddNewRoomController controller = loader.getController();
//            controller.setData("606");

                stage.show();

            } catch (IOException e1) {
                e1.printStackTrace();
            }


        });

    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public Button getDetail() {
        return detail;
    }

    public void setDetail(Button detail) {
        this.detail = detail;
    }
}
