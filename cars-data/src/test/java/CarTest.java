import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by RENT on 2017-03-11.
 */
public class CarTest {

    @Test
    public void constructor_shouldCreateCorrectObjectFor() {
        //given
        String text = "Ford, Mustang, 2001, 240";
        String expectedBrand = "Ford";
        String expectedModel = "Mustang";
        int expectedManYear = 2001;
        double expectedPower = 240;
        //when
        Car car = new Car(text);

        //then
        assertEquals(expectedBrand, car.getBrand());
        assertEquals(expectedModel, car.getModel());
        assertEquals(expectedManYear, car.getManufactureYear());
        assertEquals(expectedPower, car.getPower(), 0.000001d);
    }
}
