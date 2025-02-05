/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nattawut
 */
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class TellerGUI implements ActionListener {
    private JFrame fr;
    private JPanel pn1,pn2;
    private JTextField tf1, tf2;
    private JLabel lb1,lb2;
    private JButton btn1,btn2,btn3;
    private double balance = 0;
    
    public TellerGUI(){
        // frame
        fr = new JFrame("Teller GUI");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLayout(new GridLayout(2,1));
        
        
        pn1 = new JPanel();
        pn1.setLayout(new GridLayout(2,2));
        lb1 = new JLabel(" Balance"); tf1 = new JTextField("6000");
        tf1.setEditable(false);
        pn1.add(lb1); pn1.add(tf1);
        lb2 = new JLabel(" Amount"); tf2 = new JTextField("");
        pn1.add(lb2); pn1.add(tf2);
        
        
        pn2 = new JPanel();
        pn2.setLayout(new FlowLayout());
        btn1 = new JButton("Deposit"); btn2 =new JButton("Withdraw"); btn3 = new JButton("Exit");
        pn2.add(btn1); pn2.add(btn2); pn2.add(btn3);
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        
        fr.add(pn1);
        fr.add(pn2);
        
        
        fr.setSize(260,180);
        fr.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource().equals((btn1))){
            balance = Double.parseDouble(tf1.getText());
            balance += Double.parseDouble(tf2.getText());
            tf1.setText(String.valueOf(balance));
            tf2.setText("");
        }else if (ae.getSource().equals((btn2))){
            balance = Double.parseDouble(tf1.getText());
            balance -= Double.parseDouble(tf2.getText());
            tf1.setText(String.valueOf(balance));
            tf2.setText("");
        }else if (ae.getSource().equals((btn3))){
            System.exit(0);
        }
    }
}
