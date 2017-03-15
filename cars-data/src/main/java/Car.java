/**
 * Created by RENT on 2017-03-11.
 */
public class Car {
    private String brand;
    private String model;
    private int manufactureYear;
    private double power;

    public Car(String brand, String model, int manufactureYear, double power) {
        this.brand = brand;
        this.model = model;
        this.manufactureYear = manufactureYear;
        this.power = power;
    }

    public Car (String text){
        if (text==null){
            throw new IllegalArgumentException("Żle");
        }
        String[] splittet = text.split(",");

        brand = splittet[0].trim();
        model = splittet[1].trim();
        manufactureYear = Integer.parseInt(splittet[2].trim());
        power = Double.parseDouble(splittet[3].trim());

    }

    @Override
    public String toString() {
        return brand + ", "
                + model + ", "
                + manufactureYear + ", "
                + power;
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

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }
}