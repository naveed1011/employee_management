
package projectemployee;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    
    String empId;
    JTextField tfeducation, tfname, tffname, tfaddress, tfidentity, tfemail, tfsalary, tfphone, tfdesignation;
    JButton back, add;
    JLabel lblempid;
    
    public UpdateEmployee(String empId) {
        this.empId = empId;
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Emplyee Information");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.PLAIN, 25));
        heading.setForeground(Color.blue);
        add(heading);
        
        //name
        JLabel labelname = new JLabel("Name :");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(labelname);
        //cannot be changed
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 150, 150, 30);
        add(lblname);
        
        //fathername
        JLabel labelfname = new JLabel("Father's Name :");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(labelfname);
        
        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);
        
        //dateofbirth
        JLabel labeldob = new JLabel("Date Of Birth :");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(labeldob);
        
        JLabel lbldob = new JLabel();
        lbldob.setBounds(200, 200, 150, 30);
        add(lbldob);
        
        //salary
        JLabel labelsalary = new JLabel("Salary :");
        labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(labelsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 150, 30);
        add(tfsalary);
        
        //address
        JLabel labeladdress = new JLabel("Adress :");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);
        
        //phone
        JLabel labelphone = new JLabel("Phone :");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);
        
        //email
        JLabel labelemail = new JLabel("Email :");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
        
        //education
        JLabel labeleducation = new JLabel("Education Level :");
        labeleducation.setBounds(400, 300, 150, 30);
        labeleducation.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(labeleducation);
        
        tfeducation = new JTextField();
        tfeducation.setBounds(600, 300, 150, 30);
        add(tfeducation);
        
        //designation
        JLabel labeldesignation = new JLabel("Designation :");
        labeldesignation.setBounds(50, 350, 150, 30);
        labeldesignation.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(labeldesignation);
        
        tfdesignation = new JTextField();
        tfdesignation.setBounds(200, 350, 150, 30);
        add(tfdesignation);
        
        //identity
        JLabel labelidentity = new JLabel("Identity Number :");
        labelidentity.setBounds(400, 350, 150, 30);
        labelidentity.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(labelidentity);
        
        JLabel lblidentity = new JLabel();
        lblidentity.setBounds(600, 350, 150, 30);
        add(lblidentity);
        
        //employeeID
        JLabel labelempid = new JLabel("Employee ID :");
        labelempid.setBounds(50, 400, 150, 30);
        labelempid.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(labelempid);
        
        lblempid = new JLabel();
        lblempid.setBounds(200, 400, 150, 30);
        lblempid.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        add(lblempid);
        
        try{
            ConnectionJDBC conn  = new ConnectionJDBC();
            String query = "select * from employee where empId = '"+empId+"'";
            ResultSet rs = conn.st.executeQuery(query);
            
            while(rs.next()) {
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfsalary.setText(rs.getString("salary"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                lblidentity.setText(rs.getString("identity_number"));
                lblempid.setText(rs.getString("empId"));
                tfdesignation.setText(rs.getString("designation"));
                
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        
        //buttons
        add = new JButton("Update Information");
        add.setBounds(250, 550, 150, 40);
        add.setBackground(Color.white);
        add.setForeground(Color.black);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.addActionListener(this);
        add(back);
        
        
        
        
        
        
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
       
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == add) {
            
           String fname = tffname.getText();
           String salary = tfsalary.getText();
           String address = tfaddress.getText();
           String phone = tfphone.getText();
           String email = tfemail.getText();
           String education = tfeducation.getText();
           String designation = tfdesignation.getText();
           
              try{
                  
                  ConnectionJDBC conn = new ConnectionJDBC();
                  String query = "update employee set fname = '"+fname+"',salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"', education = '"+education+"', designation = '"+designation+"' where empId = '"+empId+"'";
                  conn.st.executeUpdate(query);
                  JOptionPane.showMessageDialog(null, "Information Updated Succesfully");
                  setVisible(false);
                  new Home();
              }catch(Exception e) {
              
              e.printStackTrace();
              }    
            
        }else {
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}
