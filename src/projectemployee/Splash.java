package projectemployee;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Splash extends JFrame implements ActionListener{
    public Splash(){
    
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("EMPLOYEE MANAGMENT SYSTEM");
        heading.setBounds(80, 30, 1200, 60);
        heading.setFont(new Font("serif" , Font.BOLD, 50));
        heading.setForeground(Color.blue);
        add(heading);
        
        
        //image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/spalsh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50,100,1050, 500);
        add(image);
        
        //button
        JButton button = new JButton("Click To Continue");
        button.setFont(new Font("serif" , Font.BOLD, 15));
        button.setBounds(380, 500, 190, 60);
        button.setBackground(Color.white);
        button.setForeground(Color.blue);
        button.addActionListener(this);
        add(button);
        
        
       setSize(1170, 650);
        setLocation(150, 70);
       setVisible(true);
       
       while(true) {
           heading.setVisible(false);
           
           try{
              Thread.sleep(500);
           }catch(Exception e) {
              e.printStackTrace();
           }
           heading.setVisible(true);
           try{
               Thread.sleep(500);
           }catch(Exception e) {
               e.printStackTrace();
           }
       }
      
    
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }
    
    public static void main(String[] args) {
        new Splash();
    }
}
