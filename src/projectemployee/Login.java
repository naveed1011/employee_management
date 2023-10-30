package projectemployee;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JTextField tfusername, tfpassword;
    
    
    
    public Login() {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        
        JLabel lblusername = new JLabel("username :");
        lblusername.setBounds(40, 20, 100, 30);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 30);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("password :");
        lblpassword.setBounds(40, 70, 100, 30);
        add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(150, 70, 150, 30);
        add(tfpassword);
        
        JButton login = new JButton("LOGIN");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.blue);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        //image
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
        
        //frame
        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        try{
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            ConnectionJDBC conn = new ConnectionJDBC();
            
            String query = "select * from login where username = '"+username+"'and password = '"+password+"'";
            ResultSet rs = conn.st.executeQuery(query);
            
            
            if(rs.next()) {
                setVisible(false);
                //next class
                new Home();
            }else {
                JOptionPane.showMessageDialog(null, "Something Went Wrong!");
                setVisible(false);
            }
            
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}
