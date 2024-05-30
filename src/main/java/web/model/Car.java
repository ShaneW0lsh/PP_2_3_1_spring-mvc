package web.model;

public class Car {
    private String model;
    private String creationYear;
    private String owner;

    public Car(String model, String creationYear, String owner) {
        this.model = model;
        this.creationYear = creationYear;
        this.owner = owner;
    }

    public String getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(String creationYear) {
        this.creationYear = creationYear;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", creationYear='" + creationYear + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
