/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo;

/**
 *
 * @author Ida Bagus Mahendra
 */
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import javax.swing.JOptionPane;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class laporan extends javax.swing.JFrame {
    JasperReport jasperReport;
    JasperDesign jasperDesign;
    JasperPrint jasperPrint;
    Map<String, Object> param = new HashMap<String, Object>();
    private DefaultTableModel tabel1;
    private DefaultTableModel tabel2;
    /**
     * Creates new form laporan
     */
    public void loadData()
    {
        tabel1.getDataVector().removeAllElements();
        tabel1.fireTableDataChanged();
        try
        {
            Connection c = KoneksiDB.getkoneksi();
            Statement s = c.createStatement();
            
            String tra= "SELECT * FROM transaksi";
            ResultSet t = s.executeQuery(tra);
            
            while(t.next())
            {
                Object[] y = new Object[5];
                y[0] = t.getString("id_transaksi");
                y[1] = t.getString("total_semua");
                y[2] = t.getString("date");
                y[3] = t.getString("time");
                y[4] = t.getString("username");
                tabel1.addRow(y);
            }

        }         
        catch(SQLException e) 
         { 
             JOptionPane.showMessageDialog(this, e);
         }
    }
    
    public laporan() {
        initComponents();
        tabel1 = new DefaultTableModel();
        jTable1.setModel(tabel1);
        
        tabel1.addColumn("Id");
        tabel1.addColumn("Total");
        tabel1.addColumn("Tanggal");
        tabel1.addColumn("Waktu");
        tabel1.addColumn("Kasir");
       
        loadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        print2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        id_trans = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cari = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton2 = new javax.swing.JButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jToggleButton3 = new javax.swing.JToggleButton();

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Transaksi");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        print2.setText("Print ");
        print2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print2ActionPerformed(evt);
            }
        });

        jButton1.setText("Hapus");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Id Transaksi");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Cari Berdasarkan");

        jToggleButton1.setText("Nama");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Tanggal");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("Id");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Hapus");

        jLabel5.setText("(YYYY-MM-DD)");

        jToggleButton3.setText("Kembali");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(id_trans, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(print2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jToggleButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jToggleButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jToggleButton3))))
                    .addComponent(jLabel3))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton1)
                    .addComponent(jButton2)
                    .addComponent(jToggleButton2)
                    .addComponent(jToggleButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(print2)
                    .addComponent(jLabel1)
                    .addComponent(id_trans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void print2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print2ActionPerformed
        try{
            File file = new File("C:/Users/Ida Bagus Mahendra/Documents/NetBeansProjects/pbo/src/pbo/laporan_transaksi.jrxml");
            jasperDesign = JRXmlLoader.load(file);
            param.clear();
            jasperReport = JasperCompileManager.compileReport(jasperDesign);
            jasperPrint = JasperFillManager.fillReport(jasperReport, param, 
            KoneksiDB.getkoneksi());
            JasperViewer.viewReport(jasperPrint, false);     
        }
        catch(Exception e)
        {
            e.printStackTrace();
        } 
    }//GEN-LAST:event_print2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     int id = Integer.parseInt(id_trans.getText());
     
     try
     {
       Connection c = KoneksiDB.getkoneksi();
       Statement s = c.createStatement();
       String tr= "DELETE FROM transaksi WHERE id_transaksi='"+id+"'";
       s.executeUpdate(tr);
       String be= "DELETE FROM beli WHERE id_transaksi='"+id+"'";
       s.executeUpdate(be);
       JOptionPane.showMessageDialog(this, "data berhasil dihapus");
       }         
      
     catch(SQLException e) 
      { 
       JOptionPane.showMessageDialog(this, e);
      }
        id_trans.setText("");
        loadData();     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int ambil = this.jTable1.getSelectedRow();
        if(ambil == -1)
          return;
      
      id_trans.setText((String)tabel1.getValueAt(ambil, 0));
    }//GEN-LAST:event_jTable1MouseClicked

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
    String cr = cari.getText();        
    try
    {
     tabel1.getDataVector().removeAllElements();
     tabel1.fireTableDataChanged();
     Connection c = KoneksiDB.getkoneksi();
     Statement s = c.createStatement();
     String user = "SELECT * FROM transaksi WHERE username LIKE'%"+cr+"%'";
     ResultSet h = s.executeQuery(user);
     tabel1.setRowCount(0);
     while(h.next()){
     Object[] y = new Object[5];
     y[0] = h.getString("id_transaksi");
     y[1] = h.getString("total_semua");
     y[2] = h.getString("date");
     y[3] = h.getString("time");
     y[4] = h.getString("username");
     tabel1.addRow(y);
     }
     cari.setText("");
     id_trans.setText("");
    }         
    catch(SQLException e) 
    { 
      JOptionPane.showMessageDialog(this, e);
    }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    String cr = cari.getText();        
    try
    {
     tabel1.getDataVector().removeAllElements();
     tabel1.fireTableDataChanged();
     Connection c = KoneksiDB.getkoneksi();
     Statement s = c.createStatement();
     String user = "SELECT * FROM transaksi WHERE date LIKE'%"+cr+"%'";
     ResultSet h = s.executeQuery(user);
     tabel1.setRowCount(0);
     while(h.next()){
     Object[] y = new Object[5];
     y[0] = h.getString("id_transaksi");
     y[1] = h.getString("total_semua");
     y[2] = h.getString("date");
     y[3] = h.getString("time");
     y[4] = h.getString("username");
     tabel1.addRow(y);
     }
     cari.setText("");
     id_trans.setText("");
    }         
    catch(SQLException e) 
    { 
      JOptionPane.showMessageDialog(this, e);
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
    String cr = cari.getText();        
    try
    {
     tabel1.getDataVector().removeAllElements();
     tabel1.fireTableDataChanged();
     Connection c = KoneksiDB.getkoneksi();
     Statement s = c.createStatement();
     String user = "SELECT * FROM transaksi WHERE id_transaksi='"+cr+"'";
     ResultSet h = s.executeQuery(user);
     tabel1.setRowCount(0);
     while(h.next()){
     Object[] y = new Object[5];
     y[0] = h.getString("id_transaksi");
     y[1] = h.getString("total_semua");
     y[2] = h.getString("date");
     y[3] = h.getString("time");
     y[4] = h.getString("username");
     tabel1.addRow(y);
     }
     cari.setText("");
     id_trans.setText("");
    }         
    catch(SQLException e) 
    { 
      JOptionPane.showMessageDialog(this, e);
    }
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
     cari.setText("");
     id_trans.setText("");
     loadData();
    }//GEN-LAST:event_jToggleButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new laporan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari;
    private javax.swing.JTextField id_trans;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JButton print2;
    // End of variables declaration//GEN-END:variables
}
