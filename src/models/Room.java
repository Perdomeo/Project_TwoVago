package models;

/**
 *
 * @author William
 */
public class Room {
    private String hotelName;
    private int hotelCode;
    private int numberRoom;
    private int numberBends;

    public Room(String hotelName, int hotelCode, int numberRoom, int numberBends) {
        this.hotelName = hotelName;
        this.hotelCode = hotelCode;
        this.numberRoom = numberRoom;
        this.numberBends = numberBends;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getHotelCode() {
        return hotelCode;
    }

    public void setHotelCode(int hotelCode) {
        this.hotelCode = hotelCode;
    }

    public int getNumberRoom() {
        return numberRoom;
    }

    public void setNumberRoom(int numberRoom) {
        this.numberRoom = numberRoom;
    }

    public int getNumberBends() {
        return numberBends;
    }

    public void setNumberBends(int numberBends) {
        this.numberBends = numberBends;
    }


}
