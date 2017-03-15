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
        setTitle("Cars manager");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(null);

        carJList = new JList<Car>();
        carJList.setSize(200, 300);
        carJList.setLocation(10, 10);
        add(carJList);

        CarEditPanel carEditPanel = new CarEditPanel(this);
        carEditPanel.setLocation(300, 50);
        add(carEditPanel);

        JButton jButton = new JButton("Wczytaj");
        jButton.setLocation(300, 0);
        jButton.setSize(100, 50);
        add(jButton);

        JButton btnSaveToFile = new JButton("Zapisz w plik");
        btnSaveToFile.setLocation(410, 0);
        btnSaveToFile.setSize(100, 50);
        add(btnSaveToFile);

        JButton btnLoadFromFile = new JButton("Wczytaj z pliku");
        btnLoadFromFile.setLocation(520, 0);
        btnLoadFromFile.setSize(100, 50);
        add(btnLoadFromFile);

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