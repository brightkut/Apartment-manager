package Controllers.room_mgt;

public class RoomType {
    private int id;
    private String name;
    private double perMonthPrice;
    private double perDayPrice;

    public RoomType(int id, String name, double perMonthPrice, double perDayPrice) {
        this.id = id;
        this.name = name;
        this.perMonthPrice = perMonthPrice;
        this.perDayPrice = perDayPrice;
    }
    public RoomType(String name, double perMonthPrice, double perDayPrice) {
        this.id = -1;
        this.name = name;
        this.perMonthPrice = perMonthPrice;
        this.perDayPrice = perDayPrice;
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

    public double getPerMonthPrice() {
        return perMonthPrice;
    }

    public void setPerMonthPrice(double perMonthPrice) {
        this.perMonthPrice = perMonthPrice;
    }

    public double getPerDayPrice() {
        return perDayPrice;
    }

    public void setPerDayPrice(double perDayPrice) {
        this.perDayPrice = perDayPrice;
    }
}
