package jdbcgui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class UpdateDeleteEmployee extends javax.swing.JFrame {

    String DBURL = "jdbc:oracle:thin:@coeoracle.aus.edu:1521:orcl";
    String DBUSER = "b00081542";
    String DBPASS = "b00081542";

    Connection con;
    Statement statement;
    Statement statement2;
    PreparedStatement prepStatement;
    ResultSet rs;
    ResultSet rsdeptno;
    
    // Custom function to convert dates retrieved from SQL to acceptable input format
    public static String dateF(String date){
        if(date != null && !date.trim().isEmpty()){
            String[] parts = ((date.split(" "))[0]).split("-");
            String month = "";
            switch(parts[1]){
                case "01":
                    month = "jan";
                    break;
                case "02":
                    month = "feb";
                    break;
                case "03":
                    month = "mar";
                    break;
                case "04":
                    month = "apr";
                    break;
                case "05":
                    month = "may";
                    break;
                case "06":
                    month = "jun";
                    break;
                case "07":
                    month = "jul";
                    break;
                case "08":
                    month = "aug";
                    break;
                case "09":
                    month = "sep";
                    break;
                case "10":
                    month = "oct";
                    break;
                case "11":
                    month = "nov";
                    break;
                case "12":
                    month = "dec";
                    break;
            }
            return (parts[2] + "-" + month.toUpperCase() + "-" + parts[0]);
        } else {
            // Defaulting to the first of jan 2000
            return "01-jan-2000";
        }
    }

    /**
     * Creates new form AddEmployee
     */
    public UpdateDeleteEmployee() {
        initComponents();
        this.setLocationRelativeTo(null);

        lblEmpnoError.setVisible(false);
        lblEnameError.setVisible(false);
        lblJobError.setVisible(false);
        lblHiredateError.setVisible(false);
        lblSalaryError.setVisible(false);
        lblCommError.setVisible(false);

        //populate mgr and deptno combo boxes 
        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Connect to Oracle Database
            con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            // make the result set scrolable forward/backward updatable
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//            statement2 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            getNewData();
        } catch (ClassNotFoundException | SQLException e) {
            javax.swing.JLabel label = new javax.swing.JLabel("SQL Error - Connection error.");
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void getNewData() {

        try {
            String str;
            // populate deptno field
            rsdeptno = statement.executeQuery("SELECT deptno, dname FROM dept ORDER BY deptno ASC ");
            cmbDeptno.removeAllItems();
            while (rsdeptno.next()) {
                cmbDeptno.addItem(rsdeptno.getString("deptno"));
            }

            // populate mgr field
            rs = statement.executeQuery("SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno FROM emp ORDER BY empno ASC ");
            cmbMgr.removeAllItems();
            while (rs.next()) {
                cmbMgr.addItem(rs.getString("empno"));
            }

            // populate rest of fields
            rs.beforeFirst();
            rs.first();
            populateFields();
        } catch (SQLException e) {
            javax.swing.JLabel label = new javax.swing.JLabel("SQL Error - Display selected empno.");
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtEname = new javax.swing.JTextField();
        txtJob = new javax.swing.JTextField();
        txtSalary = new javax.swing.JTextField();
        txtComm = new javax.swing.JTextField();
        cmbMgr = new javax.swing.JComboBox<>();
        cmbDeptno = new javax.swing.JComboBox<>();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        ftxtHiredate = new javax.swing.JFormattedTextField();
        txtEmpno = new javax.swing.JTextField();
        btnNext = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        lblEmpnoError = new javax.swing.JLabel();
        lblEnameError = new javax.swing.JLabel();
        lblJobError = new javax.swing.JLabel();
        lblHiredateError = new javax.swing.JLabel();
        lblSalaryError = new javax.swing.JLabel();
        lblCommError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Update/Delete Employee");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Update/Delete Employee");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("EMPNO:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("ENAME:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("JOB:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("MGR:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("HIREDATE:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("SALARY:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("COMMISSION:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("DEPTNO:");

        txtEname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtJob.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJobActionPerformed(evt);
            }
        });

        txtSalary.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtComm.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        cmbMgr.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        cmbDeptno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        ftxtHiredate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd-MMM-yyyy"))));
        ftxtHiredate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtEmpno.setEditable(false);
        txtEmpno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnNext.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnNext.setText("Next >>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrevious.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnPrevious.setText("<< Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        lblEmpnoError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblEmpnoError.setForeground(new java.awt.Color(255, 0, 0));
        lblEmpnoError.setText("error label");

        lblEnameError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblEnameError.setForeground(new java.awt.Color(255, 0, 0));
        lblEnameError.setText("error label");

        lblJobError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblJobError.setForeground(new java.awt.Color(255, 0, 0));
        lblJobError.setText("error label");

        lblHiredateError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblHiredateError.setForeground(new java.awt.Color(255, 0, 0));
        lblHiredateError.setText("error label");

        lblSalaryError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblSalaryError.setForeground(new java.awt.Color(255, 0, 0));
        lblSalaryError.setText("error label");

        lblCommError.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        lblCommError.setForeground(new java.awt.Color(255, 0, 0));
        lblCommError.setText("error label");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnPrevious)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNext))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtEmpno, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ftxtHiredate, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(txtJob, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtComm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(txtSalary, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbMgr, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbDeptno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblEmpnoError, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(lblEnameError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblJobError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblHiredateError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblSalaryError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCommError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEmpno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmpnoError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEnameError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtJob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblJobError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbMgr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ftxtHiredate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHiredateError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSalaryError))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtComm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCommError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(cmbDeptno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnNext)
                    .addComponent(btnPrevious))
                .addGap(0, 51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJobActionPerformed

    private void populateFields() {
        try {
            txtEmpno.setText(rs.getString("empno"));
            txtEname.setText(rs.getString("ename"));
            txtJob.setText(rs.getString("job"));
            cmbMgr.setSelectedItem(rs.getString("mgr"));
            ftxtHiredate.setText(dateF(rs.getString("hiredate")));
            txtSalary.setText(rs.getString("sal"));
            txtComm.setText(rs.getString("comm"));
            cmbDeptno.setSelectedItem(rs.getString("deptno"));

            EnableDisableButtons();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateDeleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void MoveNext() {
        try {
            // TODO add your handling code here:

            if (!rs.isLast()) {

                rs.next();
                populateFields();

            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateDeleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        MoveNext();
    }//GEN-LAST:event_btnNextActionPerformed

    private void MovePrevious() {
        try {
            // TODO add your handling code here:

            if (!rs.isFirst()) {
                rs.previous();
                populateFields();

            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateDeleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void EnableDisableButtons() {
        try {
            if (rs.isFirst()) {
                btnPrevious.setEnabled(false);
            } else {
                btnPrevious.setEnabled(true);
            }
            if (rs.isLast()) {
                btnNext.setEnabled(false);
            } else {
                btnNext.setEnabled(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateDeleteEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        // TODO add your handling code here:
        MovePrevious();
    }//GEN-LAST:event_btnPreviousActionPerformed
    

    // Eyad - Need to change this to add a CONFIRM message dialogue; similar to btnUpdateActionPerformed() could just add a confrim function
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:

        try {
            // make the result set scrolable forward/backward updatable
            prepStatement = con.prepareStatement("DELETE emp WHERE empno = " + txtEmpno.getText().trim());
            // Using JOptionPane Confirm Dialog to confirm the action
            int confirmAction = JOptionPane.showConfirmDialog(this,String.format("Confirm delete of empno: %s?", txtEmpno.getText().trim()));
            if (confirmAction == JOptionPane.YES_OPTION){
                int result = prepStatement.executeUpdate();
                if (result > 0) {
                    javax.swing.JLabel label = new javax.swing.JLabel("Employee No " + txtEmpno.getText().trim() + " deleted successfully.");
                    label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                    JOptionPane.showMessageDialog(null, label, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    getNewData();
                }
            }
            prepStatement.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error adding new employee.");

        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    void clearErrorLabels() {
        lblEmpnoError.setText("");
        lblEmpnoError.setVisible(false);
        lblEnameError.setText("");
        lblEnameError.setVisible(false);
        lblJobError.setText("");
        lblJobError.setVisible(false);
        lblHiredateError.setText("");
        lblHiredateError.setVisible(false);
        lblSalaryError.setText("");
        lblSalaryError.setVisible(false);
        lblCommError.setText("");
        lblCommError.setVisible(false);

    }

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

    boolean isValidData() {

        clearErrorLabels();
        boolean result = true;
        if (txtEmpno.getText().trim().isEmpty() || !isInteger(txtEmpno.getText().trim())) {
            if (txtEmpno.getText().trim().isEmpty()) {
                lblEmpnoError.setText("Invalid. Cannot be empty.");
            } else if (!isInteger(txtEmpno.getText().trim())) {
                lblEmpnoError.setText("Invalid. Must be integer.");
            }

            lblEmpnoError.setVisible(true);
            result = false;
        }

        if (txtEname.getText().trim().isEmpty() || (txtEname.getText().trim().length() > 10)) {
            if (txtEname.getText().trim().isEmpty()) {
                lblEnameError.setText("Invalid. Cannot be empty.");
            } else if ((txtEname.getText().trim().length() > 10)) {
                lblEnameError.setText("Invalid. Must be < 10 chars.");
            }

            lblEnameError.setVisible(true);
            result = false;
        }

        if (txtJob.getText().trim().isEmpty() || (txtJob.getText().trim().length() > 9)) {
            if (txtJob.getText().trim().isEmpty()) {
                lblJobError.setText("Invalid. Cannot be empty.");
            } else if (txtJob.getText().trim().length() > 9) {
                lblJobError.setText("Invalid. Must be < 9 chars.");
            }
            lblJobError.setVisible(true);
            result = false;
        }

        if (ftxtHiredate.getText().trim().isEmpty()) {
            lblHiredateError.setText("Invalid. Cannot be empty.");
            lblHiredateError.setVisible(true);
            result = false;
        }

        if (txtSalary.getText().trim().isEmpty() || !(isInteger(txtSalary.getText().trim()) || isDouble(txtSalary.getText().trim()))) {
            if (txtSalary.getText().trim().isEmpty()) {
                lblSalaryError.setText("Invalid. Cannot be empty.");
            } else if (!(isInteger(txtSalary.getText().trim()) || isDouble(txtSalary.getText().trim()))) {
                lblSalaryError.setText("Invalid. Must be number.");
            }

            lblSalaryError.setVisible(true);
            result = false;
        }

        if (txtComm.getText().trim().isEmpty() || !isInteger(txtComm.getText().trim())) {
            if (txtComm.getText().trim().isEmpty()) {
                lblCommError.setText("Invalid. Cannot be empty.");
            } else if (!isInteger(txtComm.getText().trim())) {
                lblCommError.setText("Invalid. Must be integer");
            }

            lblCommError.setVisible(true);
            result = false;
        }

        return result;
    }
    // Eyad - Need to change this to add a CONFIRM message dialogue; similar to btnDeleteActionPerformed() could just add a confrim function
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:

        try {
            // make the result set scrolable forward/backward updatable
//            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            if (isValidData()) {
                prepStatement = con.prepareStatement("UPDATE emp SET ename = ?, job = ?, mgr = ?, hiredate = ?, sal = ?, comm = ?, deptno = ? WHERE empno = ?");
//                prepStatement.setInt(1, Integer.parseInt(txtEmpno.getText()));
                prepStatement.setString(1, txtEname.getText().toUpperCase());
                prepStatement.setString(2, txtJob.getText().toUpperCase());
                prepStatement.setInt(3, Integer.parseInt(cmbMgr.getSelectedItem().toString()));
                prepStatement.setString(4, ftxtHiredate.getText());
                prepStatement.setInt(5, Integer.parseInt(txtSalary.getText()));
                prepStatement.setInt(6, Integer.parseInt(txtComm.getText()));
                prepStatement.setInt(7, Integer.parseInt(cmbDeptno.getSelectedItem().toString()));
                prepStatement.setInt(8, Integer.parseInt(txtEmpno.getText().trim()));
                // Using JOptionPane Confirm Dialog to confirm the action
                int confirmAction = JOptionPane.showConfirmDialog(this,"Confirm update?");
                if (confirmAction == JOptionPane.YES_OPTION){
                    int result = prepStatement.executeUpdate();
                    if (result > 0) {

                        javax.swing.JLabel label = new javax.swing.JLabel("Employee No " + txtEmpno.getText() + " updated successfully.");
                        label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null, label, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

                        getNewData();

                    } else {
                        // check validation errors 
                    }
                }
                
                prepStatement.close();
            } else {

                javax.swing.JLabel label = new javax.swing.JLabel("Please fix validation errors...");
                label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
                JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);

            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error updating employee." + e.getMessage());

        }
    }//GEN-LAST:event_btnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbDeptno;
    private javax.swing.JComboBox<String> cmbMgr;
    private javax.swing.JFormattedTextField ftxtHiredate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblCommError;
    private javax.swing.JLabel lblEmpnoError;
    private javax.swing.JLabel lblEnameError;
    private javax.swing.JLabel lblHiredateError;
    private javax.swing.JLabel lblJobError;
    private javax.swing.JLabel lblSalaryError;
    private javax.swing.JTextField txtComm;
    private javax.swing.JTextField txtEmpno;
    private javax.swing.JTextField txtEname;
    private javax.swing.JTextField txtJob;
    private javax.swing.JTextField txtSalary;
    // End of variables declaration//GEN-END:variables
}
