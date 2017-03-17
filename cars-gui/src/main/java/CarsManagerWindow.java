import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;

/**
 * Created by jakubwrabel on 11.03.2017.
 */
public class CarsManagerWindow extends JFrame {

    private CarRepository carRepository;
    private JList<Car> carJList;

    public CarRepository getCarRepository() {
        return carRepository;
    }

    public static void main(String[] args) {
        new CarsManagerWindow();
    }

    public CarsManagerWindow() throws HeadlessException {
        setTitle("Manager aut");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 550);
        setLayout(null);

        JLabel labelTxtField = new JLabel("Lista Twoich samochodów");
        labelTxtField.setLocation(10,10);
        labelTxtField.setSize(200,15);
        add(labelTxtField);

        carJList = new JList<Car>();
        carJList.setSize(200, 300);
        carJList.setLocation(10, 30);
        add(carJList);

        JLabel labelEditPanel = new JLabel("Edytor samochodów");
        labelEditPanel.setLocation(230,10);
        labelEditPanel.setSize(200, 15);
        add(labelEditPanel);

        CarEditPanel carEditPanel = new CarEditPanel(this);
        carEditPanel.setLocation(230, 30);
        add(carEditPanel);

        JButton jButton = new JButton("Wczytaj z repozytorium");
        jButton.setLocation(10, 335);
        jButton.setSize(170, 25);
        add(jButton);

        JButton btnLoadFromFile = new JButton("Wczytaj z pliku");
        btnLoadFromFile.setLocation(10, 365);
        btnLoadFromFile.setSize(170, 25);
        add(btnLoadFromFile);

        JButton btnSaveToFile = new JButton("Zapisz do pliku");
        btnSaveToFile.setLocation(10, 395);
        btnSaveToFile.setSize(170, 25);
        add(btnSaveToFile);

        JButton btnRemoveCar = new JButton("Usuń z listy");
        btnRemoveCar.setLocation(10, 435);
        btnRemoveCar.setSize(170, 25);
        add(btnRemoveCar);

        btnRemoveCar.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Car car = carJList.getSelectedValue();
                carRepository.getCarList().remove(car);

                updateCarListRepository();
            }
        });

        btnLoadFromFile.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    carRepository.loadDataFromFile("cars.txt");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                updateCarListRepository();
            }
        });

        btnSaveToFile.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    carRepository.saveStateToFile("cars.txt");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        carRepository = new CarRepository();

        jButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCarListRepository();
            }
        });

        carJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Car selectedCar = carJList.getSelectedValue();
                if (selectedCar != null) {
                    carEditPanel.setEditedCar(selectedCar);
                }
            }
        });
    }

    public void updateCarListRepository() {
        List<Car> carList = carRepository.getCarList();

        // ZAMIANA LISTY NA TABLICĘ
        Car[] cars = new Car[carList.size()];
        for (int i = 0; i < carList.size(); i++) {
            cars[i] = carList.get(i);
        }

        carJList.setListData(cars);
    }
}