package Controllers.room_mgt;

import Models.SqlConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class RoomListController {

    @FXML
    private TableView tableView;

    @FXML
    private void initialize() {
        setupTableView();
    }

    public void setupTableView() {

//        RoomType t1 = new RoomType("type1", 5000, 450);
//        RoomType t2 = new RoomType("type2", 8000, 600);
//        Room r1 = new Room("lampang", t1, 1);
//        Room r2 = new Room("deemak", t2, 3);
//        Room r3 = new Room("lamken", t1, 1);
//        Room r4 = new Room("deesud", t2, 2);
//        ObservableList<RoomItem> data = FXCollections.observableArrayList(
//                new RoomItem(r1),
//                new RoomItem(r2),
//                new RoomItem(r3),
//                new RoomItem(r4)
//        );
        ArrayList<Room> rooms = Controllers.room_mgt.SqlConnection.getRooms();
        ArrayList<RoomItem> roomItems = new ArrayList<>();
        for (Room room: rooms) {
            roomItems.add(new RoomItem(room));
        }
        ObservableList<RoomItem> data = FXCollections.observableArrayList(roomItems);
        TableColumn nameCol = new TableColumn("Name");
        nameCol.setMinWidth(200);
        nameCol.setCellValueFactory(new PropertyValueFactory<RoomItem, String>("name"));
        TableColumn typeCol = new TableColumn("Type");
        typeCol.setMinWidth(200);
        typeCol.setCellValueFactory(new PropertyValueFactory<RoomItem, String>("type"));
        TableColumn floorCol = new TableColumn("Floor");
        floorCol.setMinWidth(100);
        floorCol.setCellValueFactory(new PropertyValueFactory<RoomItem, Integer>("floor"));

        tableView.setItems(data);
        tableView.getColumns().addAll(nameCol, typeCol, floorCol);
    }

    public class RoomItem {
        private Room room;
        private RoomItem(Room room) { this.room = room; }

        public Room getRoom() {
            return room;
        }

        public String getName() {
            return room.getName();
        }

        public String getType() {
            return room.getType().getName();
        }

        public int getFloor() {
            return room.getFloor();
        }

    }

}
