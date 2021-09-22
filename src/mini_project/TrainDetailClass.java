package mini_project;

import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class TrainDetailClass extends JFrame implements ActionListener,ItemListener
{
 JLabel T1;
 JButton HomeButton;
    Connection conn;
    WindowEvent wc;
    private JTable table;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
   
	
	 public void close() 
	    {
	        wc=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
	    	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wc);
	    }
	
	public TrainDetailClass()
	{
		getContentPane().setBackground(Color.BLACK);
		setVisible(true);
		setSize(800,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    getContentPane().setLayout(null);
	    Font f2=new Font(Font.SANS_SERIF,Font.PLAIN,20);
	    Font f=new Font(Font.SANS_SERIF,Font.PLAIN,35);
	    
	    T1=new JLabel("Train Details");
	    T1.setForeground(Color.WHITE);
	    
	    HomeButton=new JButton("Home");
	    
        getContentPane().add(T1);
       
        getContentPane().add (HomeButton);
        
        HomeButton.setBounds(684,11,90,40);
        HomeButton.setFont(f2);
		T1.setFont(f);
		T1.setBounds(302,0,286,126);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(72, 135, 660, 168);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		
		HomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				HomeClass h=new  HomeClass();
				close();
			}	
		});
		

		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project","root","root");
			  String sql = "SELECT * FROM train";
				PreparedStatement pr = conn.prepareStatement(sql);
				
				ResultSet rs = pr.executeQuery(sql);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				lblNewLabel = new JLabel("New label");
				lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Pictures\\ab.jpg"));
				lblNewLabel.setBounds(10, 11, 630, 339);
				getContentPane().add(lblNewLabel);
				
				lblNewLabel_1 = new JLabel("New label");
				lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\HP\\Pictures\\ab.jpg"));
				lblNewLabel_1.setBounds(625, 11, 149, 339);
				getContentPane().add(lblNewLabel_1);
			
			
		  
		}
		catch(Exception e) 
		{
			JOptionPane.showMessageDialog(this, "Failed to find"+e,"ERROR", JOptionPane.ERROR_MESSAGE);
			
		}
	}
}
