package com.jdbc.practice;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
public class main {
    public static void main(String[] args) {
        try {
            // System.out.println("this the testing ");
            Connection c = ConnectionProvider.getConnection();
            
            
            String q = "insert into images(pic) values(?)";
            PreparedStatement pstmt = c.prepareStatement(q);

            JFileChooser jfc = new JFileChooser();  // Fixed the typo in JFileChooser
            jfc.showOpenDialog(null);
            File file = jfc.getSelectedFile();
            FileInputStream fis = new FileInputStream(file);
            pstmt.setBinaryStream(1, fis, fis.available());
            pstmt.executeUpdate();

            System.out.println("Done...............");
            JOptionPane.showMessageDialog(null, "Success");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}