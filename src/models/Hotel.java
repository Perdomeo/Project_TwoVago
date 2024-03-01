package models;

/**
 *
 * @author William
 */
public class Hotel {
    private int code;
    private String name;
    private String city;
    private int roomQuantity;
    private String address;
    private int rating;
    private float priceNight;
    private String amenities;

    public Hotel(int code) {
        this.code = code;
    }

    public Hotel(int code, String name, String city, int roomQuantity, String address, int rating, float priceNight, String amenities) {
        this.code = code;
        this.name = name;
        this.city = city;
        this.roomQuantity = roomQuantity;
        this.address = address;
        this.rating = rating;
        this.priceNight = priceNight;
        this.amenities = amenities;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRoomQuantity() {
        return roomQuantity;
    }

    public void setRoomQuantity(int roomQuantity) {
        this.roomQuantity = roomQuantity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public float getPriceNight() {
        return priceNight;
    }

    public void setPriceNight(float priceNight) {
        this.priceNight = priceNight;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

}
