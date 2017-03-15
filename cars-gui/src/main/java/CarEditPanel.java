import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by RENT on 2017-03-13.
 */
public class CarEditPanel extends JPanel {

    private Car editedCar;
    private JTextField jTextFieldBrand;
    private JTextField jTextFieldModel;
    private JTextField jTextFieldManYear;
    private JTextField jTextFieldPower;
    private JButton jButtonSave;
    private JButton btnAdd;
    private CarsManagerWindow window;


    public CarEditPanel(CarsManagerWindow window) throws HeadlessException {
        this.window = window;

        setSize(300, 600);
        setBackground(Color.white);
        setLayout(null);

        JLabel jLabelBrand = new JLabel("Marka");
        jLabelBrand.setSize(200, 100);
        jLabelBrand.setLocation(10, 50);
        add(jLabelBrand);

        jTextFieldBrand = new JTextField();
        jTextFieldBrand.setSize(150, 50);
        jTextFieldBrand.setLocation(10, 110);
        add(jTextFieldBrand);

        JLabel jLabelModel = new JLabel("Model");
        jLabelModel.setSize(200, 100);
        jLabelModel.setLocation(10, 150);
        add(jLabelModel);

        jTextFieldModel = new JTextField();
        jTextFieldModel.setSize(150, 50);
        jTextFieldModel.setLocation(10, 210);
        add(jTextFieldModel);

        JLabel jLabelManYear = new JLabel("Rok produkcji");
        jLabelManYear.setSize(200, 100);
        jLabelManYear.setLocation(10, 250);
        add(jLabelManYear);

        jTextFieldManYear = new JTextField();
        jTextFieldManYear.setSize(150, 50);
        jTextFieldManYear.setLocation(10, 310);
        add(jTextFieldManYear);

        JLabel jLabelPower = new JLabel("Moc");
        jLabelPower.setSize(200, 100);
        jLabelPower.setLocation(10, 350);
        add(jLabelPower);

        jTextFieldPower = new JTextField();
        jTextFieldPower.setSize(150, 50);
        jTextFieldPower.setLocation(10, 410);
        add(jTextFieldPower);

        jButtonSave = new JButton("Zapisz");
        jButtonSave.setSize(100, 50);
        jButtonSave.setLocation(10, 480);
        add(jButtonSave);

        btnAdd = new JButton("Dodaj");
        btnAdd.setSize(100,50);
        btnAdd.setLocation(110, 480);
        add(btnAdd);

        btnAdd.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String brand = jTextFieldBrand.getText();
                String model = jTextFieldModel.getText();
                int manYear = Integer.parseInt(jTextFieldManYear.getText());
                double power = Double.parseDouble(jTextFieldPower.getText());

                Car car = new Car(brand, model, manYear, power);
                window.getCarRepository().getCarList().add(car);
                window.updateCarListRepository();
            }
        });


        jButtonSave.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editedCar.setBrand(jTextFieldBrand.getText());
                editedCar.setModel(jTextFieldModel.getText());
                int manufactureYear = Integer.parseInt(jTextFieldManYear.getText());
                editedCar.setManufactureYear(manufactureYear);
                editedCar.setPower(Double.parseDouble(jTextFieldPower.getText()));

                window.repaint();

            }
        });
    }

    public void setEditedCar(Car editedCar) {
        this.editedCar = editedCar;

        jTextFieldBrand.setText(editedCar.getBrand());
        jTextFieldModel.setText(editedCar.getModel());
        jTextFieldManYear.setText("" + editedCar.getManufactureYear());
        jTextFieldPower.setText("" + editedCar.getPower());
    }
}