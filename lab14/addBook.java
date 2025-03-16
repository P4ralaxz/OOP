import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;

public class addBook implements ActionListener{
private JFrame fr;
    private JLabel nameLabel, priceLabel, TypeLabel;
    private JTextField nameTextField, priceTextField, pageTextField;
    private JComboBox TypeComboBox;
    private JPanel infoPanel, pagePanel;
    private JButton insertButton;
    private ArrayList<Book> data = Data.data;

    public addBook() {
        fr = new JFrame();
        nameLabel = new JLabel("Name");
        priceLabel = new JLabel("Price");
        TypeLabel = new JLabel("Type");
        nameTextField = new JTextField();
        priceTextField = new JTextField();
        pageTextField = new JTextField();
        TypeComboBox = new JComboBox();
        infoPanel = new JPanel();
        pagePanel = new JPanel();
        insertButton = new JButton("Insert");

        fr.setLayout(new BorderLayout());

        infoPanel.setLayout(new GridLayout(3, 2));

        infoPanel.add(nameLabel);
        infoPanel.add(nameTextField);
        infoPanel.add(priceLabel);
        infoPanel.add(priceTextField);
        infoPanel.add(TypeLabel);

        TypeComboBox.addItem("General");
        TypeComboBox.addItem("Computer");
        TypeComboBox.addItem("Math&Sci");
        TypeComboBox.addItem("Photo");
        TypeComboBox.setSelectedItem("General");

        infoPanel.add(TypeComboBox);

        fr.add(infoPanel, BorderLayout.NORTH);

        pagePanel.add(insertButton);

        fr.add(pagePanel);

        insertButton.addActionListener(this);

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(200, 150);
        fr.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(insertButton)) {

            if (!(nameTextField.getText().isEmpty() || priceTextField.getText().isEmpty())) {
                String name = nameTextField.getText();
                Double price = Double.parseDouble(priceTextField.getText());
                String type = (String) TypeComboBox.getSelectedItem();

                Book book = new Book(name, price, type);
                data.add(book);
                System.out.println(data.size());

                JOptionPane.showMessageDialog(null, "Done it.");
                fr.setVisible(false);
                fr.dispose();
            }
        }
    }
}