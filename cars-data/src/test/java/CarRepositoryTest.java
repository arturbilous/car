import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by RENT on 2017-03-14.
 */
public class CarRepositoryTest {

    @Test
    public void saveState_simple() throws IOException {
        CarRepository carRepository = new CarRepository();
        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car("Ford, MOndeo, 2003, 116.0"));
        cars.add(new Car("Ford, MOndeo, 2003, 116.0"));
        cars.add(new Car("Ford, MOndeo, 2003, 116.0"));
        cars.add(new Car("Ford, MOndeo, 2003, 116.0"));
        carRepository.setCarList(cars);

        carRepository.saveStateToFile("carsTest.txt");

        List<String> lines = Files.readLines(new File("carsTest.txt"), Charsets.UTF_8);
        assertEquals(lines.size(), 4);
    }
}
