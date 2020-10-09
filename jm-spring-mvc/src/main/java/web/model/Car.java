package web.model;

public class Car {

    private String country;
    private String model;
    private int year;

    public Car() {
    }

    public Car(String country, String model, int year) {
        this.country = country;
        this.model = model;
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
