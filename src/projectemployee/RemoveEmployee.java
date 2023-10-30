
package projectemployee;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RemoveEmployee extends JFrame implements ActionListener{
    
    Choice cEmpId;
    JButton back, remove;
    
    
    public RemoveEmployee() {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        
        JLabel labelempId = new JLabel("Employee ID");
        labelempId.setBounds(50,50,100,30);
        add(labelempId);
        
        cEmpId = new Choice();
        cEmpId.setBounds(200, 50, 150, 30);
        add(cEmpId);
        
        
        try {
            ConnectionJDBC conn = new ConnectionJDBC();
            String query = "select * from employee";
           ResultSet rs = conn.st.executeQuery(query);
           
           while(rs.next()) {
               cEmpId.add(rs.getString("empId"));
           }
           
           
        } catch(Exception e){
            e.printStackTrace();
        }
        
        //name 
        JLabel labelname = new JLabel("Name ");
        labelname.setBounds(50,100,100,30);
        add(labelname);
        
        //uneditable
        JLabel lblname = new JLabel();
        lblname.setBounds(200,100,100,30);
        add(lblname);
        
        //phone
        JLabel labelphone = new JLabel("Phone ");
        labelphone.setBounds(50,150,100,30);
        add(labelphone);
        
        //uneditable
        JLabel lblphone = new JLabel();
        lblphone.setBounds(200,150,100,30);
        add(lblphone);
        
        //email
        JLabel labelemail = new JLabel("Email ");
        labelemail.setBounds(50,200,100,30);
        add(labelemail);
        
        //uneditable
        JLabel lblemail = new JLabel();
        lblemail.setBounds(200,200,100,30);
        add(lblemail);
        
        //data show
        try {
            ConnectionJDBC conn = new ConnectionJDBC();
            String query = "select * from employee where empId = '"+cEmpId.getSelectedItem()+"'";
           ResultSet rs = conn.st.executeQuery(query);
           
           while(rs.next()) {
               lblname.setText(rs.getString("name"));
               lblphone.setText(rs.getString("phone"));
               lblemail.setText(rs.getString("email"));
           }
           
           
        } catch(Exception e){
            e.printStackTrace();
        }
        
        
        
            
            cEmpId.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent ie) {
                    try {
            ConnectionJDBC conn = new ConnectionJDBC();
            String query = "select * from employee where empId = '"+cEmpId.getSelectedItem()+"'";
           ResultSet rs = conn.st.executeQuery(query);
           
           while(rs.next()) {
               lblname.setText(rs.getString("name"));
               lblphone.setText(rs.getString("phone"));
               lblemail.setText(rs.getString("email"));
           }
           
           
        }catch(Exception e ){
            e.printStackTrace();
        }
        }
                
        });
        
        
        remove = new JButton("Remove");
        remove.setBounds(80, 300, 100, 30);
        remove.setBackground(Color.red);
        remove.setForeground(Color.white);
        remove.addActionListener(this);
        add(remove);
        
        back = new JButton("Back");
        back.setBounds(220, 300, 100, 30);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/remove.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550,90,250, 250);
        add(image);
        
        
        
        
        setSize(1000, 400);
        setLocation(300, 150);
        setVisible(true);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == remove) {
            try{
                ConnectionJDBC conn = new ConnectionJDBC();
                String query = "delete from employee where empId = '"+cEmpId.getSelectedItem()+"'";
                conn.st.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Selected Employee Details has been Removed succesfully");
                setVisible(false);
                new Home();
                }catch(Exception e) {
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Home();
        }
    }
    
    
    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
