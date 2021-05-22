package vehicle;

public abstract class Vehicle {
    protected String brand;
    protected String model;
    protected Integer nbDoors;
    protected Double price;
    protected Integer releaseYear;


    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getNbDoors() {
        return nbDoors;
    }

    public void setNbDoors(Integer nbDoors) {
        this.nbDoors = nbDoors;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
