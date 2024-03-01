package models;

/**
 *
 * @author William
 */
public class Reservation {
    private int Code;
    private int numberPersons;
    private String dateEntry;
    private String dateDeparture;
    private String reserveStatus;
    private float totalPrice;
    private User user;
    private Hotel hotel;
    private Room room;

    public Reservation(int Code, int numberPersons, String dateEntry, String dateDeparture, String reserveStatus, float totalPrice, User user, Hotel hotel, Room room) {
        this.Code = Code;
        this.numberPersons = numberPersons;
        this.dateEntry = dateEntry;
        this.dateDeparture = dateDeparture;
        this.reserveStatus = reserveStatus;
        this.totalPrice = totalPrice;
        this.user = user;
        this.hotel = hotel;
        this.room = room;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int Code) {
        this.Code = Code;
    }

    public int getNumberPersons() {
        return numberPersons;
    }

    public void setNumberPersons(int numberPersons) {
        this.numberPersons = numberPersons;
    }

    public String getDateEntry() {
        return dateEntry;
    }

    public void setDateEntry(String dateEntry) {
        this.dateEntry = dateEntry;
    }

    public String getDateDeparture() {
        return dateDeparture;
    }

    public void setDateDeparture(String dateDeparture) {
        this.dateDeparture = dateDeparture;
    }

    public String getReserveStatus() {
        return reserveStatus;
    }

    public void setReserveStatus(String reserveStatus) {
        this.reserveStatus = reserveStatus;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }


}
