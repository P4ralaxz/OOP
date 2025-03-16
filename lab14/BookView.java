import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Paral
 */
public class BookView implements ActionListener , WindowListener {
    private JFrame jf;
    private JPanel  pn1 , pn2 , pn3;
    private JLabel lb1 , lb2 , lb3 ;
    private JTextField  tf1,tf2, tf3;
    private JComboBox type;
    private JButton btn1,btn2,btn3,btn4,btn5;
    private int page = 0;
    
    public BookView() {
        jf = new JFrame("BookView");
        jf.setLayout(new BorderLayout());
        
        pn1 = new JPanel();
        pn1.setLayout(new GridLayout(3,2));
        
        lb1 = new JLabel("Name");
        tf1 = new JTextField();
        lb2 = new JLabel("Price");
        tf2 = new JTextField();
        lb3 = new JLabel("Type");
        
        type = new JComboBox();
        type.addItem("Computer");
        type.addItem("Math&Sci");
        type.addItem("Photo");
        type.addItem("General");
        type.setSelectedItem("General");
        
        pn1.add(lb1);
        pn1.add(tf1);
        pn1.add(lb2);
        pn1.add(tf2);
        pn1.add(lb3);
        pn1.add(type);
        
        jf.add(pn1,BorderLayout.NORTH);
        
        pn2 = new JPanel();
        pn2.setLayout(new FlowLayout());
        btn1 = new JButton("<<<");
        btn2 = new JButton(">>>");
        tf3 = new JTextField();
        tf3.setPreferredSize(new Dimension(60,30));
        pn2.add((btn1));
        pn2.add(tf3);
        pn2.add(btn2);
        
        
        jf.add(pn2,BorderLayout.CENTER);
        
        pn3 = new JPanel();
        btn3 = new JButton("ADD");
        btn4 = new JButton("Update");
        btn5 = new JButton("Delete");
        
        pn3.add(btn3);
        pn3.add(btn4);
        pn3.add(btn5);
        
        jf.add(pn3,BorderLayout.SOUTH);
        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(300, 200);
        jf.setVisible(true);
        jf.addWindowListener(this);
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        
        
    }
    @Override
    public void actionPerformed (ActionEvent ae){
        Object source = ae.getSource();
        
        if (source.equals(btn1)){
            if (page !=0) {
                page -= 1;
                Book bookData = Data.data.get(page);
                tf1.setText(bookData.getName());
                tf2.setText(String.valueOf(bookData.getPrice()));
                type.setSelectedItem(bookData.getType());
                tf3.setText(String.valueOf(page + 1));
            }
        }else if (source.equals(btn2)){
            if (page +1 <= Data.data.size() - 1) {
                page += 1;
                Book bookData = Data.data.get(page);
                tf1.setText(bookData.getName());
                tf2.setText(String.valueOf(bookData.getPrice()));
                type.setSelectedItem(bookData.getType());
                tf3.setText(String.valueOf(page + 1));
            }
        }else if (source.equals(btn3)){
            new addBook();
        }else if (source.equals(btn4)){
            JOptionPane.showMessageDialog(null, "Done it.", "Update Command", JOptionPane.INFORMATION_MESSAGE);
            if (Data.data.size() != 0) {
                Book bookData = Data.data.get(page);
                bookData.setName(tf1.getText());
                bookData.setPrice(Double.parseDouble(tf2.getText()));
                bookData.setType((String) type.getSelectedItem());
                Data.data.set(page, bookData);
                
                tf1.setText(bookData.getName());
                tf2.setText(String.valueOf(bookData.getPrice()));
                type.setSelectedItem(bookData.getType());
                tf3.setText(String.valueOf(page + 1));
            }
        }else if (source.equals(btn5) && Data.data.size() != 0){
            JOptionPane.showMessageDialog(null, "Done it.", "Delete Command", JOptionPane.INFORMATION_MESSAGE);
            Data.data.remove(page);
            if (Data.data.size() == 0) {
                tf1.setText("");
                tf2.setText("");
                type.setSelectedItem("General");
                tf3.setText("0");
            } else if (page == 0) {
                Book bookData = Data.data.get(page);
                tf1.setText(bookData.getName());
                tf2.setText(String.valueOf(bookData.getPrice()));
                type.setSelectedItem(bookData.getType());
                tf3.setText(String.valueOf(page + 1));
            } else {
                Book bookData = Data.data.get(page - 1);
                tf1.setText(bookData.getName());
                tf2.setText(String.valueOf(bookData.getPrice()));
                type.setSelectedItem(bookData.getType());
                tf3.setText(String.valueOf(page));
                page -= 1;
            }
        }
    }
    @Override
    public void windowClosing (WindowEvent we){
        try (FileOutputStream fos = new FileOutputStream("Book.data"); ObjectOutputStream oos = new ObjectOutputStream(fos);){
            oos.writeObject(Data.data);
            System.out.println(Data.data.size());
        }
        catch (FileNotFoundException ex){
            ex.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        
        
        
    }
    @Override
    public void windowOpened(WindowEvent e) {
        try (FileInputStream fin = new FileInputStream("Book.data"); ObjectInputStream oin = new ObjectInputStream(fin);){
            Data.data = (ArrayList<Book>) oin.readObject();
        }catch (IOException ex){
            ex.printStackTrace();
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        
        if (Data.data.size() == 0) {
            tf3.setText("0");
            return;
        }
        
        Book bookData = Data.data.get(page);
        tf1.setText(bookData.getName());
        tf2.setText(String.valueOf(bookData.getPrice()));
        type.setSelectedItem(bookData.getType());
        tf3.setText(String.valueOf(page + 1));
    }

    @Override
    public void windowActivated(WindowEvent e
    ) {
    }

    @Override
    public void windowIconified(WindowEvent e
    ) {
    }

    @Override
    public void windowDeiconified(WindowEvent e
    ) {
    }

    @Override
    public void windowDeactivated(WindowEvent e
    ) {
    }

    @Override
    public void windowClosed(WindowEvent e
    ) {
    }

}
