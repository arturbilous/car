import com.google.common.base.Charsets;
import com.google.common.io.Files;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-03-11.
 */
public class CarRepository {
    private List<Car> carList;

    public CarRepository() {
        carList = new ArrayList<Car>();
        carList.add(new Car("Ford", "Mustang", 2001, 240));
        carList.add(new Car("Opel", "Vectra", 2005, 100));
        carList.add(new Car("Volkswagen", "Passat B5", 2003, 116));
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void saveStateToFile(String patch) throws IOException {
        FileWriter fileWriter = new FileWriter("cars.txt");

        for (Car car : carList) {
            fileWriter.write(car.toString());
//			fileWriter.write("" + car);
//			fileWriter.write(System.lineSeparator());
            fileWriter.write("\n");
        }
        fileWriter.flush();
        fileWriter.close();
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public void loadDataFromFile(String patch) throws IOException {
        List<String> lines = Files.readLines(new File("cars.txt"), Charsets.UTF_8);
        this.carList.clear();
        for (String line : lines) {
            Car car = new Car(line);
            carList.add(car);
        }
        for (Car car : carList) {
            System.out.println(car);
        }
    }
}