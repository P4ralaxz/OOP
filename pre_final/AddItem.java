
import java.awt.BorderLayout;
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


public class AddItem implements ActionListener, WindowListener {

    private JFrame fr;
    private JPanel panel, centerPanel, buttonPanel;
    private JLabel idlabel, namelabel, pricelabel;
    private JTextField idTextField, nameTextField, priceTextField;
    private JButton insertButton;
    private ArrayList<Item> data = Data.data;

    public AddItem() {
        fr = new JFrame();
        panel = new JPanel();
        idlabel = new JLabel("Id");
        namelabel = new JLabel("Name");
        pricelabel = new JLabel("Price");
        idTextField = new JTextField();
        nameTextField = new JTextField();
        priceTextField = new JTextField();
        insertButton = new JButton("Insert Item");
        centerPanel = new JPanel();
        buttonPanel = new JPanel();
        panel = new JPanel();
        fr.add(panel,BorderLayout.NORTH);
                
        centerPanel.setLayout(new GridLayout(3, 2));

        centerPanel.add(idlabel);
        centerPanel.add(idTextField);
        centerPanel.add(namelabel);
        centerPanel.add(nameTextField);
        centerPanel.add(pricelabel);
        centerPanel.add(priceTextField);

        fr.add(centerPanel);
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(insertButton);
        insertButton.addActionListener(this);
        fr.add(buttonPanel,BorderLayout.SOUTH);

        fr.addWindowListener(this);
        fr.setSize(500, 200);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(insertButton)) {
            int id = Integer.parseInt(idTextField.getText());
            String name = nameTextField.getText();
            double price = Double.parseDouble(priceTextField.getText());
            Date date = new Date();

            Item item = new Item(id, name, price, date);
            data.add(item);

            if (!((priceTextField.getText().equals("") && idTextField.getText().equals("")) && nameTextField.getText().equals(""))) {
                JOptionPane.showMessageDialog(null, "Done it.");
                fr.setVisible(false);
                fr.dispose();
                new DashBoard();
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