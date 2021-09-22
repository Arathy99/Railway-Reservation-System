//ticket booking
package mini_project;

import java.sql.ResultSet;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;


public class BookTicket extends JFrame implements ActionListener,ItemListener 
{
	JLabel Booking,Age,Gender,TrainNo,PassengerName,userid;
	JTextField PName,PAge,Pid;
	JButton ResetButton,SubmitButton,HomeButton;
	Checkbox Male,Female;
	CheckboxGroup Sex;
	Choice TNo;
	String Train;
	boolean sex=true;
	Connection conn;
    WindowEvent wc;
    private JLabel lblNewLabel;
	
	 public void close() 
	    {
	        wc=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
	    	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wc);
	    }
	

	public  BookTicket()
	{
		getContentPane().setBackground(Color.BLACK);
		setVisible(true);
		setSize(900,500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Font f=new Font(Font.SANS_SERIF,Font.PLAIN,35);
		Font f2=new Font(Font.SANS_SERIF,Font.PLAIN,20);
		getContentPane().setLayout(null);
		
		Booking=new JLabel("Booking");
		Booking.setForeground(Color.WHITE);
		TrainNo=new JLabel("Train No:");
		TrainNo.setForeground(Color.WHITE);
		PassengerName=new JLabel("Passenger Name");
		PassengerName.setForeground(Color.WHITE);
		Age=new JLabel("Age");
		Age.setForeground(Color.WHITE);
		Gender=new JLabel("Gender");
		Gender.setForeground(Color.WHITE);
		userid=new JLabel("User Id:");
		userid.setForeground(Color.WHITE);
		userid.setBackground(Color.WHITE);
		TNo=new Choice();
		PName=new JTextField(20);
		PAge=new JTextField(3);
		Pid=new JTextField(20);
		HomeButton=new JButton("Home");
		SubmitButton=new JButton("Submit");
		SubmitButton.setBackground(Color.WHITE);
		ResetButton=new JButton("Reset");
		ResetButton.setBackground(Color.WHITE);
		Sex=new CheckboxGroup( );
		Male=new Checkbox("Male",Sex,true);
		Male.setForeground(Color.WHITE);
		Female=new Checkbox("Female",Sex, false);
		Female.setForeground(Color.WHITE);
		
		TNo.add("02625");
		TNo.add("06255");
		TNo.add("12696");
		
		getContentPane().add (Booking);
		getContentPane().add (TrainNo);
		getContentPane().add (PassengerName);
		getContentPane().add (Age);
		getContentPane().add (Gender);
		getContentPane().add (TNo);
		getContentPane().add (PName);
		getContentPane().add (PAge);
		getContentPane().add (SubmitButton);
		getContentPane().add (ResetButton);
		getContentPane().add (HomeButton);
		getContentPane().add (Male);
		getContentPane().add (Female);
		getContentPane().add (userid);
		getContentPane().add (Pid);
		
		
		Booking.setFont(f);
		Booking.setBounds(522,9,234,116);
		TrainNo.setBounds(365,126,200,25);
		TNo.setBounds(612,131,200,25);
		PassengerName.setBounds(365,207,200,25);
		PName.setBounds(612,211,200,25);
		Age.setBounds(365,254,200,25);
		PAge.setBounds(612,258,200,25);
		Gender.setBounds(365,304,132,25);
		SubmitButton.setBounds(461,376,163,25);
		ResetButton.setBounds(689,376,163,25);
		HomeButton.setBounds(784,9,90,40);
		TrainNo.setFont(f2);
		Age.setFont(f2);
		Gender.setFont(f2);
		SubmitButton.setFont(f2);
		ResetButton.setFont(f2);
		HomeButton.setFont(f2);
		PassengerName.setFont(f2);
		Male.setFont(f2);
		Male.setBounds(612,304,108,25);
		Female.setFont(f2);
		Female.setBounds(734,304,163,25);
		userid.setBounds(365,171,141,25);
		Pid.setBounds(612,175,200,25);
		userid.setFont(f2);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Pictures\\ab.jpg"));
		lblNewLabel.setBounds(10, 11, 336, 439);
		getContentPane().add(lblNewLabel);
		
		HomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				HomeClass h=new  HomeClass();
				close();
			}	
		});
		SubmitButton.addActionListener(this);
		PName.addActionListener(this);
		PAge.addActionListener(this);
		ResetButton.addActionListener(this);
		Male.addItemListener(this);
		Female.addItemListener(this);
		TNo.addItemListener(this);
		
		
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==SubmitButton)
		 {
			
			if(PName.getText().trim().isEmpty() && PAge.getText().trim().isEmpty())
			  {
				JOptionPane.showMessageDialog(this, "Error");
			  }
			else if(PName.getText().trim().isEmpty())
			  {
				JOptionPane.showMessageDialog(this, "Pasenger Name !!");
			  }
			else if(PAge.getText().trim().isEmpty()) 
			  {
				JOptionPane.showMessageDialog(this, "Passenger age !!");
			  }
		 
			else
			  {
				try 
				{
				  Class.forName("com.mysql.cj.jdbc.Driver");
				  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ mini_project","root","root");
				  String sql = "INSERT INTO `user` (`user_id`, `name`, `age`, `gender`) VALUES (?, ?, ?, ?);";
					
					
					PreparedStatement pr = conn.prepareStatement(sql);
		
					pr.setString(1,Pid.getText());
					pr.setString(2,PName.getText());
					pr.setInt(3,Integer.parseInt(PAge.getText()));
					if(sex==true)
						pr.setString(4,"M");
					else
						pr.setString(4, "F");
					pr.executeUpdate();
					
					String sql4="update count set count_of_i=count_of_i+1,count_of_j=count_of_j+1 WHERE train_no= ?;";
					PreparedStatement pr4= conn.prepareStatement(sql4);
					if(Train==null)
						  Train="02625";
					
					pr4.setString(1,Train);
					String sql3="SELECT * FROM `count`";
					Statement stmt1=conn.createStatement();
					ResultSet pr3= stmt1.executeQuery(sql3);
					while(pr3.next())
					{
						String train_no=pr3.getString("train_no");
						int i=pr3.getInt("count_of_i");
						int j=pr3.getInt("count_of_j");
						if(Train.equals(train_no))
						{
							String sql1="INSERT INTO `booking`(`user_id`,`train_no`,`status`,`seat_no`) VALUES (?,?,?,?);";
							PreparedStatement pr1= conn.prepareStatement(sql1);
							
							String sql2="SELECT * FROM `train`";
							Statement stmt=conn.createStatement();
							ResultSet pr2= stmt.executeQuery(sql2);
							if(Train==null)
							  Train="02625";
							
							pr1.setString(1,Pid.getText());
							pr1.setString(2,Train);
							while(pr2.next())
							{
								int seats = pr2.getInt("no_of_seat");
								String train_no1=pr2.getString("train_no");
								++i;
								if((seats>=i) && (Train.equals(train_no1)))
								{
									pr1.setString(3,"reserved");
									String seat_no="S";
									seat_no=seat_no+j;
									pr1.setString(4, seat_no);
									System.out.print(seats +"reserved"+i+" "+j+" ");
								    break;
								}
								else if((seats<i) && (Train.equals(train_no1)))
								{
									pr1.setString(3,"waiting");
									pr1.setString(4, null);
									System.out.print(seats +"waiting"+i);
									break;
								}
							}
							pr1.executeUpdate();	
						}
						
					    }
					int rowUpdate=pr4.executeUpdate();
					if(rowUpdate>0)
					JOptionPane.showMessageDialog(this, "The Ticket has been successfully booked");
				}
				catch(Exception e) 
				{
					JOptionPane.showMessageDialog(this, "Failed to find"+e,"ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
		 }
		
	    if(ae.getSource()==ResetButton)
		 {
			PName.setText("");
			PAge.setText("");
		 }
	}
	private Object getString(String string) 
	{
		// TODO Auto-generated method stub
		return null;
	}
	public void itemStateChanged(ItemEvent e) 
	{
		if (e.getItemSelectable()==Female)
			sex=false;
               else
			    sex=true;
		 if (e.getSource()==TNo)
		  { 
		    Train = (String)TNo.getSelectedItem();
		  }
	}
}

