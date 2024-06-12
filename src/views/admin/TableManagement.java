/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.admin;

import dao.Table;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.TableService;

public class TableManagement extends javax.swing.JFrame {

    /**
     * Creates new form UsersManagement
     */
    public TableManagement() {
        initComponents();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtTableId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNumber = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSeats = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUẢN LÝ BÀN");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Quản lý bàn");

        tbTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ID", "Bàn số", "Số ghế", "Tình trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbTable.getTableHeader().setResizingAllowed(false);
        tbTable.getTableHeader().setReorderingAllowed(false);
        tbTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbTable);

        jLabel2.setText("ID:");

        txtTableId.setEditable(false);
        txtTableId.setEnabled(false);

        jLabel3.setText("Bàn số:");

        jButton1.setText("Đóng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnAdd.setText("Thêm mới");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel7.setText("Tìm kiếm theo tên:");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });

        jLabel4.setText("Số ghế:");

        jLabel5.setText("Tình trạng:");

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trống", "Đã đặt", "Đang phục vụ" }));
        cbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(412, 412, 412)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTableId, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                            .addComponent(txtNumber)
                            .addComponent(txtSeats)
                            .addComponent(cbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(0, 41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTableId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtSeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnEdit)
                            .addComponent(btnDelete))
                        .addGap(20, 20, 20))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel7)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:

        List<Table> tables = tableService.getAllTables();

        DefaultTableModel model = (DefaultTableModel) tbTable.getModel();
        model.setRowCount(0);
        for (int i = 0; i < tables.size(); i++) {
            Table table = tables.get(i);
            model.addRow(new Object[]{i + 1, table.getTableId(), table.getNumber(), table.getSeats(), table.getStatus()});
        }
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        AdminScreenMain adminScreenMain = new AdminScreenMain();
        adminScreenMain.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTableMouseClicked

        // TODO add your handling code here:
        DefaultTableModel tableModel = (DefaultTableModel) tbTable.getModel();
        Vector<Object> tableVector = (Vector<Object>) tableModel.getDataVector().elementAt(tbTable.getSelectedRow());

        Table table = new Table();
        table.setTableId(Integer.valueOf(tableVector.get(1).toString()));
        table.setNumber(Integer.valueOf(tableVector.get(2).toString()));
        table.setSeats(Integer.valueOf(tableVector.get(3).toString()));
        table.setStatus(tableVector.get(4).toString());
        
        txtTableId.setText(table.getTableId().toString());
        txtNumber.setText(table.getNumber().toString());
        txtSeats.setText(table.getSeats().toString());
        cbStatus.setSelectedItem(table.getStatus());
    }//GEN-LAST:event_tbTableMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        this.dispose();
        AddTableFrame addTableFrame = new AddTableFrame();
        addTableFrame.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if (txtTableId.getText().trim().compareTo("") == 0) {
            return;
        }

        int responseConfirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa không?", "Xóa bàn", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (responseConfirm == JOptionPane.YES_OPTION) {
            if (!tableService.deleteTable(Integer.valueOf(txtTableId.getText()))) {
                JOptionPane.showConfirmDialog(null, "Xóa bàn thất bại", "Xóa bàn", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showConfirmDialog(null, "Xóa bàn thành công", "Xóa bàn", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            DefaultTableModel model = (DefaultTableModel) tbTable.getModel();
            model.setRowCount(0);
            formWindowOpened(null);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        if (txtTableId.getText().trim().compareTo("") == 0) {
            return;
        }

        if (txtNumber.getText().trim().compareTo("") == 0) {
            JOptionPane.showConfirmDialog(null, "Số bàn không được để trống", "Lỗi thêm mới", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            return;
        }

        Table table = new Table();
        table.setTableId(Integer.valueOf(txtTableId.getText()));
        table.setNumber(Integer.valueOf(txtNumber.getText()));
        table.setSeats(Integer.valueOf(txtSeats.getText()));
        table.setStatus(cbStatus.getSelectedItem().toString());

        if (!tableService.updateTable(table)) {
            JOptionPane.showConfirmDialog(null, "Sửa bàn thất bại", "Sửa bàn", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showConfirmDialog(null, "Sửa bàn thành công", "Sửa bàn", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);

        DefaultTableModel model = (DefaultTableModel) tbTable.getModel();
        model.setRowCount(0);
        formWindowOpened(null);
        ResetForm();
    }//GEN-LAST:event_btnEditActionPerformed

    public void ResetForm() {
        txtNumber.setText("");
        txtSearch.setText("");
        txtSeats.setText("");
        txtTableId.setText("");
        cbStatus.setSelectedIndex(0);
    }

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtSearch.getText().trim().compareTo("") == 0) {
                DefaultTableModel model = (DefaultTableModel) tbTable.getModel();
                model.setRowCount(0);

                List<Table> tables = tableService.getAllTables();

                for (int i = 0; i < tables.size(); i++) {
                    Table table = tables.get(i);
                    model.addRow(new Object[]{i + 1, table.getTableId(), table.getNumber(), table.getSeats(), table.getStatus()});
                }
            } else {
                DefaultTableModel model = (DefaultTableModel) tbTable.getModel();
                model.setRowCount(0);

                List<Table> tables = tableService.getTableLikeText(txtSearch.getText());

                for (int i = 0; i < tables.size(); i++) {
                    Table table = tables.get(i);
                    model.addRow(new Object[]{i + 1, table.getTableId(), table.getNumber(), table.getSeats(), table.getStatus()});
                }
            }
        }
    }//GEN-LAST:event_txtSearchKeyPressed

    private void cbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbStatusActionPerformed

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
            java.util.logging.Logger.getLogger(TableManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableManagement().setVisible(true);
            }
        });
    }

    private TableService tableService = new TableService();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbTable;
    private javax.swing.JTextField txtNumber;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSeats;
    private javax.swing.JTextField txtTableId;
    // End of variables declaration//GEN-END:variables
}
