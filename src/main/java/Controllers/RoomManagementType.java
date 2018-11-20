package Controllers;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class RoomManagementType {
    String name,amountD,amountM,fxml;
    Button detail;

    public RoomManagementType(String name, String amountD, String amountM, Button detail,String fxml) {
        this.name = name;
        this.amountD = amountD;
        this.amountM = amountM;
        this.detail = detail;
        this.fxml = fxml;

        detail.setOnAction(e -> {
            System.out.println("detail: "+getName());

            Button b = (Button) e.getSource();

            Stage stage = (Stage) b.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource(this.fxml));
            try {
                stage.setScene(new Scene((Parent) loader.load(), 1280, 800));

            PageRoomManagementInfoTypeRoom controller = loader.getController();
            controller.setData(getName(),Integer.parseInt(getAmountM()),10);

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

    public String getAmountD() {
        return amountD;
    }

    public void setAmountD(String amountD) {
        this.amountD = amountD;
    }

    public String getAmountM() {
        return amountM;
    }

    public void setAmountM(String amountM) {
        this.amountM = amountM;
    }

    public Button getDetail() {
        return detail;
    }

    public void setDetail(Button detail) {
        this.detail = detail;
    }

}
