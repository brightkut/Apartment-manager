package Models;

public class TypeRoom {

    private int idTypeRoom ;
    private  String typeRoom;
    private double rentPerDay ;
    private  double rentPerMonth;
    private String status;

    public TypeRoom(int idTypeRoom, String typeRoom, double rentPerDay, double rentPerMonth, String status) {
        this.idTypeRoom = idTypeRoom;
        this.typeRoom = typeRoom;
        this.rentPerDay = rentPerDay;
        this.rentPerMonth = rentPerMonth;
        this.status = status;
    }

    public int getIdTypeRoom() {
        return idTypeRoom;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public double getRentPerDay() {
        return rentPerDay;
    }

    public double getRentPerMonth() {
        return rentPerMonth;
    }

    public String getStatus() {
        return status;
    }
}
