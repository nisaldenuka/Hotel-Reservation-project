/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hotel_reservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.sql.*;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Asus
 */
public class frmsearchresult extends javax.swing.JFrame {

    Date check_in;
    Date check_out;
    String place;
    int a;
    int c;

    public frmsearchresult() {
        initComponents();
        
    }
    public frmsearchresult(Date checkin,Date checkout,String location,int adult,int child) {
        initComponents();
        
         check_in=checkin;
         check_out=checkout;
         place=location;
         a=adult;
         c=child;
        showTable(place,check_in,check_out);
        long days=Math.abs(check_out.getTime()-check_in.getTime());
        long diff=TimeUnit.DAYS.convert(days,TimeUnit.MILLISECONDS);

    }

    @SuppressWarnings("unchecked")
    
    public void showTable(String place ,Date check_in,Date check_out)
    {
        java.sql.Date in=new java.sql.Date(check_in.getTime());
        java.sql.Date out=new java.sql.Date(check_out.getTime());
        
        //long days=check_in.getTime()-check_out.getTime();
        try
        {
            
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection conobj = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelreservationdb","root","");
            String sql="SELECT hoteltbl.hname,hoteltbl.hotelid,roomtbl.roomid,roomtbl.roomtype,roomtbl.bedtype,roomtbl.no_of_bed,pricetbl.pricrid,"
            + "pricetbl.price_per_day ,pricetbl.price_per_night,pricetbl.month  "
           + "FROM hoteltbl INNER JOIN roomtbl ON hoteltbl.hotelid = roomtbl.hotelid INNER JOIN pricetbl ON roomtbl.roomid = pricetbl.roomid "
                    + "where location=?";
            
            
            
            PreparedStatement pst=conobj.prepareStatement(sql);
            pst.setString(1,place);
            ResultSet rs = pst.executeQuery();
            tblresult.setModel(DbUtils.resultSetToTableModel(rs));
            conobj.close();
            //JOptionPane.showMessageDialog(null,check_in);
        }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null,e);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblresult = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnshow = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 204), 2));

        tblresult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Hotel Name", "Room type", "Price per day", "Price per night", "Bed type", "Number of beds"
            }
        ));
        jScrollPane1.setViewportView(tblresult);

        jButton1.setBackground(new java.awt.Color(204, 255, 255));
        jButton1.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnshow.setBackground(new java.awt.Color(204, 255, 255));
        btnshow.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        btnshow.setText("Next");
        btnshow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnshowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(553, 553, 553)
                        .addComponent(btnshow)))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnshow))
                .addGap(20, 20, 20))
        );

        jPanel2.setBackground(new java.awt.Color(51, 255, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Select room");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnshowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnshowActionPerformed
        // TODO add your handling code here:
         if(tblresult.getSelectedRowCount()==1)
         {
             int row=tblresult.getSelectedRow();
         int hotelid=(tblresult.getModel().getValueAt(row,1).hashCode());
         int roomid=(tblresult.getModel().getValueAt(row,2).hashCode());
         int priceid=(tblresult.getModel().getValueAt(row,6).hashCode());
         
         java.sql.Date in=new java.sql.Date(check_in.getTime());
         java.sql.Date out=new java.sql.Date(check_out.getTime());
             try
             {
                 Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conobj = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelreservationdb","root","");
            String sql1="SELECT checkin,checkout,hotelid,roomid from reservationtbl where checkin >= ? AND checkout <= ? AND hotelid=? AND roomid=?";
            PreparedStatement pst1=conobj.prepareStatement(sql1);
            pst1.setDate(1, in);
            pst1.setDate(2,out);
            pst1.setInt(3, hotelid);
            pst1.setInt(4, roomid);
            
            ResultSet rs1 = pst1.executeQuery();
            
            if(rs1.next())
            {
                JOptionPane.showMessageDialog(null,"This room is not available "); 
            }
            else
            {
                frmreservationdata id=new frmreservationdata(hotelid,roomid,priceid,check_in,check_out,place,a,c);

                id.setVisible(true);
             this.setVisible(false);
            }
             }
             catch(Exception e)
             {
                 JOptionPane.showMessageDialog(null,"ERROR");
             }
         }
         else
         {
           JOptionPane.showMessageDialog(null,"Please select the room ");
         }
         
         //frmreservationdata id=new frmreservationdata(hotelid,roomid,priceid);
         
        
    }//GEN-LAST:event_btnshowActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        searchFrm back=new searchFrm();
        back.setVisible(true);
             this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(frmsearchresult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmsearchresult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmsearchresult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmsearchresult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmsearchresult().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnshow;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblresult;
    // End of variables declaration//GEN-END:variables
}
