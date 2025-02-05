/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nattawut
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorSample implements ActionListener{
    private JFrame fr;
    private JPanel pn;
    private JTextField tf1;
    private JButton btn1, btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnc,btnadd,btnminus,btnmulti,btndivi,btne;
    int num1 = 0, num2 = 0, result = 0;
    String oper;
    
    public CalculatorSample(){
        // frame
        fr = new JFrame("My Calculator");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLayout(new BorderLayout());
        
        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btn4 = new JButton("4");
        btn5 = new JButton("5");
        btn6 = new JButton("6");
        btn7 = new JButton("7");
        btn8 = new JButton("8");
        btn9 = new JButton("9");
        btn0 = new JButton("0");
        btnc = new JButton("c");
        btnadd = new JButton("+");
        btnminus = new JButton("-");
        btnmulti = new JButton("X");
        btndivi = new JButton("/");
        btne = new JButton("=");
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        btn0.addActionListener(this);
        btnc.addActionListener(this);
        btnadd.addActionListener(this);
        btnminus.addActionListener(this);
        btnmulti.addActionListener(this);
        btndivi.addActionListener(this);
        btne.addActionListener(this);
        
        pn = new JPanel();
        tf1 = new JTextField("", 15);
        pn.setLayout(new GridLayout(4,4));
        pn.add(btn7); pn.add(btn8); pn.add(btn9); pn.add(btnadd);
        pn.add(btn4); pn.add(btn5); pn.add(btn6); pn.add(btnminus);
        pn.add(btn1); pn.add(btn2); pn.add(btn3); pn.add(btnmulti);
        pn.add(btn0); pn.add(btnc); pn.add(btne); pn.add(btndivi);
        fr.add(tf1,BorderLayout.NORTH);
        fr.add(pn);
        fr.setSize(300,300);
        fr.setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource().equals(btn0)){
            tf1.setText(tf1.getText().concat("0"));
        }else if(ae.getSource().equals(btn1)){
            tf1.setText(tf1.getText().concat("1"));
        }else if(ae.getSource().equals(btn2)){
            tf1.setText(tf1.getText().concat("2"));
        }else if(ae.getSource().equals(btn3)){
            tf1.setText(tf1.getText().concat("3"));
        }else if(ae.getSource().equals(btn4)){
            tf1.setText(tf1.getText().concat("4"));
        }else if(ae.getSource().equals(btn5)){
            tf1.setText(tf1.getText().concat("5"));
        }else if(ae.getSource().equals(btn6)){
            tf1.setText(tf1.getText().concat("6"));
        }else if(ae.getSource().equals(btn7)){
            tf1.setText(tf1.getText().concat("7"));
        }else if(ae.getSource().equals(btn8)){
            tf1.setText(tf1.getText().concat("8"));
        }else if(ae.getSource().equals(btn9)){
            tf1.setText(tf1.getText().concat("9"));
        }else if(ae.getSource().equals(btnadd)){
            num1 = Integer.parseInt(tf1.getText());
            oper = "+";
            tf1.setText("");
        }else if(ae.getSource().equals(btnminus)){
            num1 = Integer.parseInt(tf1.getText());
            oper = "-";
            tf1.setText("");
        }else if(ae.getSource().equals(btnmulti)){
            num1 = Integer.parseInt(tf1.getText());
            oper = "x";
            tf1.setText("");
        }else if(ae.getSource().equals(btndivi)){
            num1 = Integer.parseInt(tf1.getText());
            oper = "/";
            tf1.setText("");
        }else if(ae.getSource().equals(btnc)){
            tf1.setText("");
            num1 = 0;
            num2 = 0;
        }else if(ae.getSource().equals(btne)){
            num2 = Integer.parseInt(tf1.getText());
            if (oper.equals("+")){
                result = num1 + num2;
                tf1.setText(String.valueOf(result));
                num1 = result;
            }else if (oper.equals("-")){
                result = num1 - num2;
                tf1.setText(String.valueOf(result));
                num1 = result;
            }else if (oper.equals("x")){
                result = num1 * num2;
                tf1.setText(String.valueOf(result));
                num1 = result;
            }else if (oper.equals("/")){
                result = num1 / num2;
                tf1.setText(String.valueOf(result));
                num1 = result;
            }
        }
            
        
    }
}
