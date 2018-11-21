package Models;


import javafx.scene.control.Button;

public class RoomManagementDetail {
    String date_star, date_end,type,user,phone;
    Button cancel;
    String fxml;

    public RoomManagementDetail(String date_star, String date_end, String type, String user, String phone, Button cancel, String fxml) {
        this.date_star = date_star;
        this.date_end = date_end;
        this.type = type;
        this.user = user;
        this.phone = phone;
        this.cancel = cancel;
        this.fxml = fxml;
    }

    public String getDate_star() {
        return date_star;
    }

    public void setDate_star(String date_star) {
        this.date_star = date_star;
    }

    public String getDate_end() {
        return date_end;
    }

    public void setDate_end(String date_end) {
        this.date_end = date_end;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Button getCancel() {
        return cancel;
    }

    public void setCancel(Button cancel) {
        this.cancel = cancel;
    }

    public String getFxml() {
        return fxml;
    }

    public void setFxml(String fxml) {
        this.fxml = fxml;
    }
}
