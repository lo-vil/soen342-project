package Iteration1.Implementation;

public class Location {
    private String address;
    private String zipcode;
    private String province;
    private String country;
    private String coordinates;

    public Location() {
        this.address = "";
        this.zipcode = "";
        this.province = "";
        this.country = "";
        this.coordinates = "";
    }

    public Location(String address, String zipcode, String province, String country, String coordinates){
        this.address = address;
        this.zipcode = zipcode;
        this.province = province;
        this.country = country;
        this.coordinates = coordinates;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return address.equals(location.address)
            && zipcode.equals(location.zipcode) 
            && province.equals(location.province)
            && country.equals(location.country)
            && coordinates.equals(location.coordinates);
    }
}
