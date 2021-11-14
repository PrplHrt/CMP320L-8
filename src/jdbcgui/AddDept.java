package jdbcgui;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author wissam
 */
public class AddDept extends javax.swing.JFrame {

    /**
     * Creates new form AddDept
     */

    Connection con;
    Statement statement;
    PreparedStatement prepStatement;
    ResultSet rs;

    public AddDept(myDBCon connect) {
        initComponents();
        con = connect.getCon();
        // center form in screen 
        this.setLocationRelativeTo(null);
        // set all error labels to invisible
        lbllDeptnoError.setVisible(false);
        lblDnameError.setVisible(false);
        lblLocError.setVisible(false);
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
        txtDeptno = new javax.swing.JTextField();
        txtDname = new javax.swing.JTextField();
        txtLoc = new javax.swing.JTextField();
        btnAddNewDept = new javax.swing.JButton();
        lbllDeptnoError = new javax.swing.JLabel();
        lblLocError = new javax.swing.JLabel();
        lblDnameError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add New Department");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Add New Department");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("DEPTNO:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("DNAME:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("LOC:");

        txtDeptno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtDname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtLoc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLocActionPerformed(evt);
            }
        });

        btnAddNewDept.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAddNewDept.setText("Add New");
        btnAddNewDept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewDeptActionPerformed(evt);
            }
        });

        lbllDeptnoError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lbllDeptnoError.setForeground(new java.awt.Color(255, 0, 0));
        lbllDeptnoError.setText("error label");

        lblLocError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblLocError.setForeground(new java.awt.Color(255, 0, 0));
        lblLocError.setText("error label");

        lblDnameError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblDnameError.setForeground(new java.awt.Color(255, 0, 0));
        lblDnameError.setText("error label");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDeptno)
                    .addComponent(txtDname)
                    .addComponent(txtLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblDnameError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblLocError, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbllDeptnoError, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(btnAddNewDept)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(124, 124, 124))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDeptno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbllDeptnoError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDnameError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLocError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(btnAddNewDept)
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    void clearErrorLabels() {
        lbllDeptnoError.setText("");
        lbllDeptnoError.setVisible(false);
        lblDnameError.setText("");
        lblDnameError.setVisible(false);
        lblLocError.setText("");
        lblLocError.setVisible(false);

    }

    boolean isValidData() {

        clearErrorLabels();
        boolean result = true;

        if (txtDeptno.getText().trim().isEmpty() || !isInteger(txtDeptno.getText().trim())) {
            if (txtDeptno.getText().trim().isEmpty()) {
                lbllDeptnoError.setText("Invalid. Cannot be empty.");
            } else if (!isInteger(txtDeptno.getText().trim())) {
                lbllDeptnoError.setText("Invalid. Must be integer.");
            } else if (Integer.parseInt(txtDeptno.getText().trim()) > 99) {
                lbllDeptnoError.setText("Invalid. Must be two digits.");
            }
            
            lbllDeptnoError.setVisible(true);
            result = false;
        } else {
            try {
                rs = statement.executeQuery("Select Deptno from dept where deptno equals " + txtDeptno.getText().trim());
                if (rs.isBeforeFirst()) {
                    lbllDeptnoError.setText("Invalid. Deptno already exists.");
                    lbllDeptnoError.setVisible(true);
                    result = false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(AddDept.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (txtDname.getText().trim().isEmpty() || (txtDname.getText().trim().length() > 14)) {
            if (txtDname.getText().trim().isEmpty()) {
                lblDnameError.setText("Invalid. Cannot be empty.");
            } else if ((txtDname.getText().trim().length() > 14)) {
                lblDnameError.setText("Invalid. Must be < 15 chars.");
            }

            lblDnameError.setVisible(true);
            result = false;
        }

        if (txtLoc.getText().trim().isEmpty() || (txtLoc.getText().trim().length() > 13)) {
            if (txtLoc.getText().trim().isEmpty()) {
                lblLocError.setText("Invalid. Cannot be empty.");
            } else if (txtLoc.getText().trim().length() > 13) {
                lblLocError.setText("Invalid. Must be < 14 chars.");
            }
            lblLocError.setVisible(true);
            result = false;
        }

        return result;
    }

    void clearInputBoxes() {
        txtDeptno.setText("");
        txtDname.setText("");
        txtLoc.setText("");

    }

    private void btnAddNewDeptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewDeptActionPerformed
        // TODO add your handling code here:

        try {
            // make the result set scrolable forward/backward updatable
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            if (isValidData()) {
                prepStatement = con.prepareStatement("INSERT INTO dept VALUES (?, ?, ?)");
                prepStatement.setInt(1, Integer.parseInt(txtDeptno.getText()));
                prepStatement.setString(2, txtDname.getText().toUpperCase());
                prepStatement.setString(3, txtLoc.getText().toUpperCase());

                int result = prepStatement.executeUpdate();
                if (result > 0) {

                    javax.swing.JLabel label = new javax.swing.JLabel("New department added successfully.");
                    label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                    JOptionPane.showMessageDialog(null, label, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

                    clearInputBoxes();
                } else {
                    // check validation errors 

                }

                rs.close();
                statement.close();
                prepStatement.close();
            } else {

                javax.swing.JLabel label = new javax.swing.JLabel("Please fix validation errors...");
                label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error adding new department.");
        }
    }//GEN-LAST:event_btnAddNewDeptActionPerformed

    private void txtLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLocActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNewDept;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblDnameError;
    private javax.swing.JLabel lblLocError;
    private javax.swing.JLabel lbllDeptnoError;
    private javax.swing.JTextField txtDeptno;
    private javax.swing.JTextField txtDname;
    private javax.swing.JTextField txtLoc;
    // End of variables declaration//GEN-END:variables
}
