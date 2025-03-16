
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class EditItem implements ActionListener, WindowListener {

    private JFrame fr;
    private JPanel panel, centerPanel, buttonPanel, leftrightPanel;
    private JLabel idlabel, namelabel, pricelabel;
    private JTextField idTextField, nameTextField, priceTextField;
    private JButton DeleteButton, UpdateButton, CloseButton, leftButton, rightButton;
    private int now = 0;
    private ArrayList<Item> data = Data.data;

    public EditItem() {
        fr = new JFrame();
        panel = new JPanel();
        idlabel = new JLabel("Id");
        namelabel = new JLabel("Name");
        pricelabel = new JLabel("Price");
        idTextField = new JTextField();
        nameTextField = new JTextField();
        priceTextField = new JTextField();
        DeleteButton = new JButton("Delete Item");
        UpdateButton = new JButton("Update Item");
        CloseButton = new JButton("Close Item");
        leftButton = new JButton("<<");
        rightButton = new JButton(">>");
        centerPanel = new JPanel();
        buttonPanel = new JPanel();
        leftrightPanel = new JPanel();

        fr.setLayout(new GridLayout(4, 1));

        fr.add(panel);
        centerPanel.setLayout(new GridLayout(3, 2));

        centerPanel.add(idlabel);
        centerPanel.add(idTextField);
        centerPanel.add(namelabel);
        centerPanel.add(nameTextField);
        centerPanel.add(pricelabel);
        centerPanel.add(priceTextField);

        fr.add(centerPanel);
        leftrightPanel.setLayout(new FlowLayout());
        leftrightPanel.add(leftButton);
        leftrightPanel.add(rightButton);

        fr.add(leftrightPanel);

        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(DeleteButton);
        buttonPanel.add(UpdateButton);
        buttonPanel.add(CloseButton);
        rightButton.addActionListener(this);
        leftButton.addActionListener(this);

        DeleteButton.addActionListener(this);
        UpdateButton.addActionListener(this);
        CloseButton.addActionListener(this);

        fr.add(buttonPanel);
        fr.addWindowListener(this);
        fr.setSize(500, 200);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setVisible(true);
        showData();

    }

    private void showData() {
        if (data.size() == 0) {
            return;
        }
        Item firstindex = data.get(now);
        idTextField.setText(String.valueOf(firstindex.getId()));
        nameTextField.setText(firstindex.getName());
        priceTextField.setText(String.valueOf(firstindex.getPrice()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(DeleteButton)) {
            data.remove(now);
            JOptionPane.showMessageDialog(null, "Done it.");
            if (data.size() == 0) {
                idTextField.setText("");
                nameTextField.setText("");
                priceTextField.setText("");
            } else if ((data.size() >= 0) && (now - 1 == -1)) {
                Item itemData = data.get(now);
                idTextField.setText(String.valueOf(itemData.getId()));
                nameTextField.setText(itemData.getName());
                priceTextField.setText(String.valueOf(itemData.getPrice()));
            } else {
                Item itemData = data.get(now - 1);
                idTextField.setText(String.valueOf(itemData.getId()));
                nameTextField.setText(itemData.getName());
                priceTextField.setText(String.valueOf(itemData.getPrice()));
            }
        } else if (e.getSource().equals(UpdateButton)) {
            int id = Integer.parseInt(idTextField.getText());
            String name = nameTextField.getText();
            double price = Double.parseDouble(priceTextField.getText());
            Date date = new Date();
            Item item = new Item(id, name, price, date);
            data.set(now, item);
            JOptionPane.showMessageDialog(null, "Done it.");
        } else if (e.getSource().equals(CloseButton)) {
            fr.setVisible(false);
            fr.dispose();
            new DashBoard();

        } else if (e.getSource().equals(rightButton)) {
            if ((now + 1) <= (data.size() - 1)) {
                now += 1;
                Item itemData = data.get(now);
                idTextField.setText(String.valueOf(itemData.getId()));
                nameTextField.setText(itemData.getName());
                priceTextField.setText(String.valueOf(itemData.getPrice()));
            }
        } else if (e.getSource().equals(leftButton)) {
            if (now != 0) {
                now -= 1;
                Item itemData = data.get(now);
                idTextField.setText(String.valueOf(itemData.getId()));
                nameTextField.setText(itemData.getName());
                priceTextField.setText(String.valueOf(itemData.getPrice()));
            }
        }
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        new DashBoard();
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

}