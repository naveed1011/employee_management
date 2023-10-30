
package projectemployee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{
    
    JButton add, view, update, remove;
    
    public Home() {
        setLayout(null);
            
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0,1120,630);
        add(image);

        //label
        JLabel label = new JLabel("Employee Management System");
        label.setBounds(620,5, 400, 40);
        label.setFont(new Font("Ralway", Font.BOLD, 25));
        label.setForeground(Color.blue);
        image.add(label);
        
        //buttons
        add = new JButton("Add Employee");
        add.setBounds(650, 80, 150, 40);
        add.setBackground(Color.white);
        add.setForeground(Color.blue);
        add.addActionListener(this);
        image.add(add);
        
        view = new JButton("View Employees");
        view.setBounds(820, 80, 150, 40);
        view.setBackground(Color.white);
        view.setForeground(Color.blue);
        view.addActionListener(this);
        image.add(view);
        
        update = new JButton("Update Employee");
        update.setBounds(650, 140, 150, 40);
        update.setBackground(Color.white);
        update.setForeground(Color.blue);
        update.addActionListener(this);
        image.add(update);
        
        remove = new JButton("Remove Employee");
        remove.setBounds(820, 140, 150, 40);
        remove.setBackground(Color.white);
        remove.setForeground(Color.blue);
        remove.addActionListener(this);
        image.add(remove);
                
        setSize(1120, 630);
        setLocation(180, 100);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == add) {
            //addclass
            setVisible(false);
            new AddEmployee();
        }else if(ae.getSource() == view) {
            //viewclass
            setVisible(false);
            new ViewEmployee();
        }else if(ae.getSource() == update) {
            //updateclass
            setVisible(false);
            new ViewEmployee();
            
        }else {
            //removeclass
            setVisible(false);
            new RemoveEmployee();
        }
        
        
    }
    
    public static void main(String[] args) {
        new Home();
    }
    
}
