package mini_project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class HomeClass extends JFrame implements ActionListener
{
    private JLabel T1,Label;
	JButton bookingButton,CancelationButton,DataButton,TrainButton;
	WindowEvent wc;
    Connection conn;
    private JLabel lblNewLabel;  
   public void close() 
    {
        wc=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
    	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wc);
    }
	public HomeClass()
	{
		
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		setSize(600,500);
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    getContentPane().setLayout(null);
	    Font f2=new Font(Font.SERIF,Font.PLAIN,22);
	    Font f=new Font(Font.SERIF,Font.PLAIN,45);
	    
	    T1=new JLabel(" ");
	    T1.setBackground(Color.BLACK);
	    Label=new JLabel("    Home");
	    Label.setForeground(Color.WHITE);
	    bookingButton=new JButton("Ticket Booking");
	    bookingButton.setForeground(Color.WHITE);
	    bookingButton.setBackground(new Color(0, 0, 0));
		CancelationButton=new JButton("Cancellation");
		CancelationButton.setForeground(Color.WHITE);
		CancelationButton.setBackground(new Color(0, 0, 0));
		DataButton=new JButton("Passenger Details");
		DataButton.setForeground(Color.WHITE);
		DataButton.setBackground(Color.BLACK);
		TrainButton=new JButton("Train Details");
		TrainButton.setBackground(new Color(0, 0, 0));
		TrainButton.setForeground(Color.WHITE);
	    
        getContentPane().add(T1);
        getContentPane().add (bookingButton);
		getContentPane().add (CancelationButton);
		getContentPane().add (DataButton);
		getContentPane().add (TrainButton);
		getContentPane().add (Label);
		
		Label.setFont(f);
		T1.setBounds(26,41,526,392);
		Label.setBounds(196, 100, 166, 44);
		bookingButton.setBounds(53,312,205,73);
		CancelationButton.setBounds(310,312,216,73);
		DataButton.setBounds(310,167,216,73);
		TrainButton.setBounds(53,167,205,73);
		bookingButton.setFont(f2);
		CancelationButton.setFont(f2);
		DataButton.setFont(f2);
		TrainButton.setFont(f2);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Pictures\\ab.jpg"));
		lblNewLabel.setBounds(26, 38, 526, 398);
		getContentPane().add(lblNewLabel);
		
		bookingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				BookTicket bt=new   BookTicket();
				close();
			}	
		});
		CancelationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				CancelTicket ct=new CancelTicket();	
				close();
			}	
		});
		DataButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				PassengerDetailsClass P=new  PassengerDetailsClass();
				close();
			}	
		});
		TrainButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				TrainDetailClass T=new  TrainDetailClass();
				close();
			}	
		});
	}
	
			
	public static void main(String[] args) 
	{
		HomeClass h=new  HomeClass();
		
	}
	
	
}

