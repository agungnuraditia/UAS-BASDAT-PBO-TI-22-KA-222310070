/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gani
 */
public class perpustakaan extends javax.swing.JFrame {

    private Connection con;
    private Statement stat;
    private ResultSet res;

    public perpustakaan() {
        initComponents();
        koneksi();
        tabel();
        kosongkan();
        ClearTabel();
    }

    //membuat koneksi kedatabase
    private void koneksi() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/perpus", "root", "");
            stat = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void tabel() {
        DefaultTableModel tb = new DefaultTableModel();
// Memberi nama pada setiap kolom tabel
        tb.addColumn("No.Buku");
        tb.addColumn("Judul Buku");
        tb.addColumn("Pengarang");
        tb.addColumn("Tahun");
        tb.addColumn("Penerbit");
        tabel.setModel(tb);
        try {
// Mengambil data dari database
            res = stat.executeQuery("select * from perpus");

            while (res.next()) {
// Mengambil data dari database berdasarkan nama kolom pada tabel
// Lalu di tampilkan ke dalam JTable
                tb.addRow(new Object[]{
                    res.getInt("no_buku"),
                    res.getString("judul_buku"),
                    res.getString("pengarang"),
                    res.getInt("tahun"),
                    res.getString("penerbit")
                });
            }

        } catch (Exception e) {
        }
    }

    private void kosongkan() {
        no.setText("");
        judul.setText("");
        pengarang.setText("");
        tahun.setText("");
        penerbit.setText("");
        no.requestFocus();
    }

    private void ClearTabel() {
        int cb = tabel.getRowCount();
        int cc = tabel.getColumnCount();
        for (int i = 0; i < cb; i++) {
            for (int j = 0; j < cc; j++) {
                tabel.setValueAt(null, i, j);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        no = new javax.swing.JTextField();
        judul = new javax.swing.JTextField();
        pengarang = new javax.swing.JTextField();
        tahun = new javax.swing.JTextField();
        penerbit = new javax.swing.JTextField();
        simpan = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        baca_tabel = new javax.swing.JButton();
        clear_tabel = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Perpustakaan");
        setBackground(new java.awt.Color(255, 255, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Russo One", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Perpustakaan");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 31, -1, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("No. Buku");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 95, -1, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Judul");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 143, -1, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Pengarang");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 194, -1, -1));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Tahun");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 245, -1, -1));

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Penerbit");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 296, -1, -1));

        no.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        no.setForeground(new java.awt.Color(102, 102, 102));
        no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noActionPerformed(evt);
            }
        });
        getContentPane().add(no, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 93, 70, -1));

        judul.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        judul.setForeground(new java.awt.Color(102, 102, 102));
        getContentPane().add(judul, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 140, 164, -1));

        pengarang.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        pengarang.setForeground(new java.awt.Color(102, 102, 102));
        getContentPane().add(pengarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 191, 164, -1));

        tahun.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tahun.setForeground(new java.awt.Color(102, 102, 102));
        getContentPane().add(tahun, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 242, 70, -1));

        penerbit.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        penerbit.setForeground(new java.awt.Color(102, 102, 102));
        getContentPane().add(penerbit, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 293, 164, -1));

        simpan.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        simpan.setForeground(new java.awt.Color(51, 51, 51));
        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });
        getContentPane().add(simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 113, 91, -1));

        edit.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        edit.setForeground(new java.awt.Color(51, 51, 51));
        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        getContentPane().add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 156, 91, -1));

        baca_tabel.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        baca_tabel.setForeground(new java.awt.Color(51, 51, 51));
        baca_tabel.setText("Baca Tabel");
        baca_tabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baca_tabelActionPerformed(evt);
            }
        });
        getContentPane().add(baca_tabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 199, -1, -1));

        clear_tabel.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        clear_tabel.setForeground(new java.awt.Color(51, 51, 51));
        clear_tabel.setText("Clear Tabel");
        clear_tabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_tabelActionPerformed(evt);
            }
        });
        getContentPane().add(clear_tabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 113, -1, -1));

        hapus.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        hapus.setForeground(new java.awt.Color(51, 51, 51));
        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });
        getContentPane().add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 156, 91, -1));

        keluar.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        keluar.setForeground(new java.awt.Color(51, 51, 51));
        keluar.setText("Keluar");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });
        getContentPane().add(keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 199, 91, -1));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 332, -1, 99));

        setSize(new java.awt.Dimension(540, 480));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_keluarActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        try {
            stat.executeUpdate("insert into perpus values ("
                    + "'" + no.getText() + "',"
                    + "'" + judul.getText() + "',"
                    + "'" + pengarang.getText() + "',"
                    + "'" + tahun.getText() + "',"
                    + "'" + penerbit.getText() + "')"
            );

            kosongkan();//Mengosongkan text field setelah berhasil menyimpan data
            tabel();// Menampilkan isi tabel
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan...");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Keterangan Error : " + e);
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        try {
            stat.executeUpdate("update perpus set "
                    + "judul_buku='" + judul.getText() + "',"
                    + "pengarang='" + pengarang.getText() + "',"
                    + "tahun='" + tahun.getText() + "',"
                    + "penerbit='" + penerbit.getText() + "'"
                    + " where "
                    + "no_buku='" + no.getText() + "'"
            );
            kosongkan();
            tabel();
            JOptionPane.showMessageDialog(rootPane, "Data berhasil Diupdate");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_editActionPerformed

    private void baca_tabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baca_tabelActionPerformed
        tabel();
    }//GEN-LAST:event_baca_tabelActionPerformed

    private void clear_tabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_tabelActionPerformed
        ClearTabel();
    }//GEN-LAST:event_clear_tabelActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        try {
            stat.executeUpdate("delete from perpus where "
                    + "no_buku='" + no.getText() + "'"
            );
            kosongkan();
            tabel();
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "pesan salah : " + e);
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noActionPerformed
        try {
//melakukan pencarian data berdasarkan primary key pada tabel
            res = stat.executeQuery("select * from perpus where " + "no_buku='" + no.getText() + "'"
            );

            while (res.next()) {
                judul.setText(res.getString("judul_buku"));
                pengarang.setText(res.getString("pengarang"));
                tahun.setText(res.getString("tahun"));
                penerbit.setText(res.getString("penerbit"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_noActionPerformed

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
            java.util.logging.Logger.getLogger(perpustakaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(perpustakaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(perpustakaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(perpustakaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new perpustakaan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton baca_tabel;
    private javax.swing.JButton clear_tabel;
    private javax.swing.JButton edit;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField judul;
    private javax.swing.JButton keluar;
    private javax.swing.JTextField no;
    private javax.swing.JTextField penerbit;
    private javax.swing.JTextField pengarang;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField tahun;
    // End of variables declaration//GEN-END:variables
}
