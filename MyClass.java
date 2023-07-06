import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MyClass extends JFrame
{
	DriverClass driver;
	JLabel l1,l2,background;
	JButton login,signup;
	JPanel p1,p2,p3;
	public MyClass(DriverClass driver)
	{
		this.driver=driver;
		initializeComponents();
		addComponents();
		registerListeners();
		setSize(600,300);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(3,1));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	public void initializeComponents()
	{
		l1=new JLabel("OR");
		login=new JButton("LOGIN");
		signup=new JButton("SIGN UP");
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
	}
	public void addComponents()
	{
		p1.add(login);add(p1);
		p2.add(l1);add(p2);
		p3.add(signup);add(p3);
	}
	public void registerListeners()
	{
		try
		{
		login.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("login successfull");
				//Login l=new Login();
				//l.setVisible(true);
				//dispose();
			
			SwingUtilities.invokeLater(new Runnable() 
			{
                public void run()
				{
                    new Login(driver).setVisible(true);
                }
			});
			}
		});
		}
		catch(Exception e)
		{
			System.out.println("hello");
		}
		
		signup.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				System.out.println("signup successfull");
				//new SignUp();
				//dispose();
				
				SwingUtilities.invokeLater(new Runnable() 
			{
                public void run()
				{
                    new SignUp(driver).setVisible(true);
                }
			});
			}
		});
	}
	public static void main(String[] args)
	{
		DriverClass driver3=new DriverClass();
		new MyClass(driver3);
	}
}		