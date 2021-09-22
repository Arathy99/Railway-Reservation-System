//cancellation
package mini_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CancelTicket  extends JFrame implements ActionListener
{   JLabel TrainNo,User_id,Cancelation;
    JTextField UId,TNo;
    JButton ResetButton,CancelationButton,HomeButton;
    Connection conn;
    WindowEvent wc;
    private JLabel lblNewLabel;
	
	 public void close() 
	    {
	        wc=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
	    	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wc);
	    }
	
   
	public CancelTicket()
	 {
		getContentPane().setBackground(Color.BLACK);
       setVisible(true);
	   setSize(800,400);
	   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       getContentPane().setLayout(null);
       Font f2=new Font(Font.SANS_SERIF,Font.PLAIN,20);
       Font f=new Font(Font.SANS_SERIF,Font.PLAIN,35);
       
       Cancelation=new JLabel("Cancellation");
       Cancelation.setForeground(Color.WHITE);
       TrainNo=new JLabel("Train No:");
       TrainNo.setForeground(Color.WHITE);
	   User_id=new JLabel("User Id:");
	   User_id.setForeground(Color.WHITE);
	   TNo=new JTextField(20);
	   UId=new JTextField(20);
	   ResetButton=new JButton("Reset");
	   ResetButton.setBackground(Color.WHITE);
	   CancelationButton=new JButton("Cancel");
	   CancelationButton.setBackground(new Color(240, 240, 240));
	   CancelationButton.setForeground(Color.BLACK);
	   HomeButton=new JButton("Home");
	   
	   getContentPane().add (Cancelation);
	   getContentPane().add (TrainNo);
	   getContentPane().add (User_id);
	   getContentPane().add (TNo);
	   getContentPane().add (UId);
	   getContentPane().add (ResetButton);
	   getContentPane().add (CancelationButton);
	   getContentPane().add (HomeButton);
	   
	   Cancelation.setBounds(447,50,249,56);
	   TrainNo.setBounds(376,149,189,25);
	   TNo.setBounds(520,149,211,25);
	   User_id.setBounds(383,206,141,25);
	   UId.setBounds(520,206,211,25);
	   ResetButton.setBounds(606,276,148,25);
	   CancelationButton.setBounds(417,276,148,25);
	   HomeButton.setBounds(678,11,96,40);
	   HomeButton.setFont(f2);
	   TrainNo.setFont(f2);
	   ResetButton.setFont(f2);
	   User_id.setFont(f2);
	   CancelationButton.setFont(f2);
	   Cancelation.setFont(f);
	   
	   lblNewLabel = new JLabel("New label");
	   lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Pictures\\ab.jpg"));
	   lblNewLabel.setBounds(10, 11, 294, 339);
	   getContentPane().add(lblNewLabel);
	   
	   
	   ResetButton.addActionListener(this);
	   CancelationButton.addActionListener(this);
	   HomeButton.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent ae) {
			HomeClass h=new  HomeClass();
			close();
			}	
		});
	 }
public void actionPerformed(ActionEvent ae)
  {
    if(ae.getSource()==CancelationButton)
	   {
	     try 
		   {
		     Class.forName("com.mysql.cj.jdbc.Driver");
		     Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project","root","root");
	             String sql = "update booking set status= 'cancelled' WHERE train_no= ? And user_id= ?";
			PreparedStatement pr = conn.prepareStatement(sql);
				    
			System.out.println(TNo.getText());
			pr.setString(1,TNo.getText());
			pr.setString(2,UId.getText());
		
			int rowUpdate=pr.executeUpdate();
			if(rowUpdate>0)
				JOptionPane.showMessageDialog(this, "Cancelation successfully!!");
		    }
		catch(Exception e) 
		   {
	            JOptionPane.showMessageDialog(this,"Failed to find" +e,"ERROR", JOptionPane.ERROR_MESSAGE);
					
		   }	 
			
		 }
		
	    if(ae.getSource()==ResetButton)
		 {
			UId.setText("");
			TNo.setText("");
		 }
	    
	}

   
}

