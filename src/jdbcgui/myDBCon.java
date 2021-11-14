/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcgui;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;

/**
 *
 * @author wissam
 */
public class myDBCon {
    private String DBURL = "jdbc:oracle:thin:@coeoracle.aus.edu:1521:orcl";
    private String DBUSER = "b00081542";
    private String DBPASS = "b00081542";
    private Connection con;
    
    public myDBCon(){
        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Connect to Oracle Database
            con = DriverManager.getConnection(this.DBURL, this.DBUSER, this.DBPASS);
        } catch (ClassNotFoundException | SQLException e) {
            javax.swing.JLabel label = new javax.swing.JLabel("SQL Error - Connection error.");
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Connection getCon(){
        return this.con;
    }
    
}
