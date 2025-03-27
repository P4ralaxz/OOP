/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package service;

import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static javax.swing.text.html.HTML.Tag.SELECT;

/**
 *
 * @author Paral
 */
public class ServicePage extends javax.swing.JFrame {

    /**
     * Creates new form ServicePage
     */
    public ServicePage() {
        initComponents();
        getConnect();
        Show_Service_Table();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Service Name", "Price", "Time"
            }
        ));
        jTable1.setName("Jtable"); // NOI18N
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(162, 162, 162))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            /* Create and display the form */
            FlatArcIJTheme.setup();
        } catch (Exception ex) {
            Logger.getLogger(serviceadd.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new serviceadd().setVisible(true);
            }
        });
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //
    }//GEN-LAST:event_formWindowOpened

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        Show_Service_Table();
    }//GEN-LAST:event_formWindowGainedFocus

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        //
    }//GEN-LAST:event_formWindowActivated

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try {
            int index = jTable1.getSelectedRow();
            ArrayList<Service> list = getServiceList();
            
            Connection con = getConnect();
            PreparedStatement ps = con.prepareStatement("SELECT  `ID` FROM `service` WHERE `Service_Name` = ?");
            ps.setString(1, list.get(index).getName());
            ResultSet resultSet = ps.executeQuery();
            
            if (resultSet.next()) { 
                int serviceId = resultSet.getInt("ID");
                new service_option(serviceId).setVisible(true);
            } else {
                System.out.println("No data found for the given Service_Name.");
            }
        }  catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jTable1MouseClicked
    
        private static String HOST = "127.0.0.1";
        private static int port = 3306;
        private static String DB_NAME = "service";
        private static String USERNAME = "root";
        private static String PASSWORD = "";
        private static  Connection connection;
    public static Connection getConnect(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s", HOST,port,DB_NAME),USERNAME,PASSWORD);
            return connection;
        } catch (SQLException ex) {
            Logger.getLogger(ServicePage.class.getName()).log(Level.SEVERE, null, ex);
            return  null;
        }
    }
    
    public ArrayList<Service> getServiceList(){
        ArrayList<Service> servicelist = new ArrayList<Service>();
        Connection con = getConnect();
        String query = "SELECT * FROM service";
        
        
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
        
        while (rs.next()) {
            String name = rs.getString("Service_Name");
            double price = rs.getDouble("Price");
            int time = rs.getInt("time");
            servicelist.add(new Service(name, price, time));
        }  
             
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return  servicelist;
    }
    
    public void Show_Service_Table(){
        ArrayList<Service> list = getServiceList();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Object[] row = new Object[3];
        for (int i = 0; i < list.size(); i++ ){
            row[0] = list.get(i).getName();
            row[1] = list.get(i).getPrice();
            row[2] = list.get(i).getTime();
            
            model.addRow(row);
        }
    }
    

    
    /**
     * @param args the command line arguments 
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServicePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServicePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServicePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServicePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        try {
            /* Create and display the form */
            FlatArcIJTheme.setup();
        } catch (Exception ex) {
            Logger.getLogger(serviceadd.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServicePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
