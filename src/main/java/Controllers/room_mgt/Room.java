package Controllers.room_mgt;

public class Room {

    private int id;
    private String name;
    private RoomType type;
    private int floor;

    public Room(int id, String name, RoomType type, int floor) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.floor = floor;
    }
    public Room(String name, RoomType type, int floor) {
        this.id = -1;
        this.name = name;
        this.type = type;
        this.floor = floor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
