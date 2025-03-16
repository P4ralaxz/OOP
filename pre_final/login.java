import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class login implements ActionListener{
    private JFrame jf;
    private JPanel pn1 , pn2,pn3,pnup,pn12,pn22;
    private JLabel lb1,lb2;
    private JTextField tf1,tf2;
    private JButton btn1;
    
    public login(){
        
        try(FileInputStream fis = new FileInputStream("jisso_shop.dat"); ObjectInputStream ois = new ObjectInputStream(fis);){
            Data.data = (ArrayList<Item>) ois.readObject();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        
        jf = new JFrame ();
        jf.setLayout(new GridLayout(4,1));
        
        pn1 = new JPanel();
        pn1.setLayout(new GridLayout(1,2));
        pn1.setBounds(1000, 1000, 1000, 1000);
        pn12 = new JPanel();
        pn12.setLayout(new FlowLayout());
        
        lb1 = new JLabel("Login");
        tf1 = new JTextField();
        tf1.setPreferredSize(new Dimension(200,30));
        pn12.add(tf1);
        pn1.add(lb1);
        pn1.add(pn12);
        
        pn2 = new JPanel();
        pn2.setLayout(new GridLayout(1,2));
        pn22 = new JPanel();
        pn22.setLayout(new FlowLayout());
        lb2 = new JLabel("Password");
        tf2 = new JTextField();
        tf2.setPreferredSize(new Dimension(200,30));
        pn22.add(tf2);
        pn2.add(lb2);
        pn2.add(pn22);
        
        pn3 = new JPanel();
        btn1 = new JButton("Login");
        pn3.add(btn1);
        
        pnup = new JPanel();
        
        jf.add(pnup);
        jf.add(pn1);
        jf.add(pn2);
        jf.add(pn3);
        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(500, 300);
        jf.setVisible(true);
        
        btn1.addActionListener(this);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource().equals(btn1)){
            if (tf1.getText().equals("jisoo") && tf2.getText().equals("flower_me")){
                DashBoard dashBoard = new  DashBoard();

                jf.setVisible(false);
                jf.dispose();
                
            }
        }
    }
}
