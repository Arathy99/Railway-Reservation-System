//passenger details
package mini_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import net.proteanit.sql.DbUtils;

public class PassengerDetailsClass extends JFrame implements ActionListener,ItemListener  
{
	JLabel TrainNo,P1;
    JTextField TNo;
    JButton SearchButton,HomeButton;
    JTextArea SearchArea;
    Connection conn;
    WindowEvent wc;
    private JTable table;
    private JLabel lblNewLabel;
	
	 public void close() 
	    {
	        wc=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
	    	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wc);
	    }
	
	public PassengerDetailsClass()
	{
		getContentPane().setBackground(Color.BLACK);
		setVisible(true);
		setSize(800,550);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    getContentPane().setLayout(null);
	    Font f2=new Font(Font.SANS_SERIF,Font.PLAIN,20);
	    Font f=new Font(Font.SANS_SERIF,Font.PLAIN,35);
	    
	    P1=new JLabel("Passenger Details");
	    P1.setForeground(Color.WHITE);
	    TrainNo=new JLabel("Train No:");
	    TrainNo.setForeground(Color.WHITE);
		TNo=new JTextField(20);
		SearchButton=new JButton("Search");
		SearchButton.setBackground(Color.WHITE);
		
		HomeButton=new JButton("Home");
		
		getContentPane().add (P1);
		getContentPane().add (TrainNo);
		getContentPane().add (TNo);
		getContentPane().add (SearchButton);
		getContentPane().add (HomeButton);
		
		HomeButton.setBounds(684,11,90,40);
		HomeButton.setFont(f2);
		P1.setFont(f);
		P1.setBounds(239,22,331,85);
		TrainNo.setBounds(163,148,200,25);
		TNo.setBounds(261,148,200,25);
		SearchButton.setBounds(507,147,103,25);
		TrainNo.setFont(f2);
		SearchButton.setFont(f2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(99, 205, 593, 264);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Pictures\\d2.jpg"));
		lblNewLabel.setBounds(10, 11, 764, 489);
		getContentPane().add(lblNewLabel);
		  
		SearchButton.addActionListener(this);
		TNo.addActionListener(this);
		HomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				HomeClass h=new  HomeClass();
				close();
			}	
		});   
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()== SearchButton)
		 {
			try 
			{
				
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project","root","root");
		
			  if((TNo.getText()).equals("12696"))
			   {
			     String sql = "SELECT user_id,name,age,gender,status,seat_no FROM booking natural join user WHERE train_no = '12696'";
				 PreparedStatement pr = conn.prepareStatement(sql);
				
				 ResultSet rs = pr.executeQuery(sql);
				 table.setModel(DbUtils.resultSetToTableModel(rs));
			   }	
			  else if((TNo.getText()).equals("06255"))
			   {
				 String sql = "SELECT user_id,name,age,gender,status,seat_no FROM booking natural join user WHERE  train_no ='06255'";
					PreparedStatement pr = conn.prepareStatement(sql);
					
					ResultSet rs = pr.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(rs)); 
			   }
			 else if((TNo.getText()).equals("02625"))
			  {
				 String sql = "SELECT user_id,name,age,gender,status,seat_no FROM booking natural join user  WHERE  train_no ='02625'";
					PreparedStatement pr = conn.prepareStatement(sql);
					
					ResultSet rs = pr.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
			  }
			 else
			  
                JOptionPane.showMessageDialog(this, "Enter incorrect!!");
			}
			catch(Exception e) 
			{
				JOptionPane.showMessageDialog(this, "Failed to find"+e,"ERROR",JOptionPane.ERROR_MESSAGE);
				
			}
		 }
    }
}

