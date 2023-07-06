/*import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Login extends JFrame
{
	JTextField tfl1,tfl2;
	JPanel lp1,lp2,lp3;
	JLabel l1,l2;
	JButton lsubmit;
	String name3;
	public Login()
	{
		initiate();
		addComponents();
		setSize(300,300);
		setLayout(new GridLayout(3,1));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void initiate()
	{
		tfl1=new JTextField(20);
		tfl2=new JTextField(10);
		l1=new JLabel("Name:");
		l2=new JLabel("Mobile Number:");
		lsubmit=new JButton("Submit");
		lp1=new JPanel();
		lp2=new JPanel();
		lp3=new JPanel();
	}
	public void addComponents()
	{
		lp1.add(l1);lp1.add(tfl1);add(lp1);
		lp2.add(l2);lp2.add(tfl2);add(lp2);
		lp3.add(lsubmit);add(lp3);
	}
	public void registerListeners()
	{
		lsubmit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				name3=tfl1.getText();
				dispose();
				
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        LoginDetails loginDetails = new LoginDetails(name3);
                        loginDetails.setVisible(true);
                    }
                });
			}
		});
	}
	public static void main(String[] args)
	{
		new Login();
	}
}*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Login extends JFrame 
{
    JTextField tfl1, tfl2;
    JPanel lp1, lp2, lp3;
    JLabel l1, l2;
    JButton lsubmit;
    String mobile;
	DriverClass driver4;
    public Login(DriverClass driver4)
	{
		this.driver4=driver4;
        initiate();
        addComponents();
        registerListeners();
        setSize(300, 300);
        setLayout(new GridLayout(3, 1));
        setVisible(true);
		setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void initiate() 
	{
        tfl1 = new JTextField(20);
        tfl2 = new JTextField(10);
        l1 = new JLabel("Name:");
        l2 = new JLabel("Mobile Number:");
        lsubmit = new JButton("Submit");
        lp1 = new JPanel();
        lp2 = new JPanel();
        lp3 = new JPanel();
    }

    public void addComponents()
	{
        lp1.add(l1);
        lp1.add(tfl1);
        add(lp1);
        lp2.add(l2);
        lp2.add(tfl2);
        add(lp2);
        lp3.add(lsubmit);
        add(lp3);
    }

    public void registerListeners()
	{
        lsubmit.addActionListener(new ActionListener()
		{
            public void actionPerformed(ActionEvent ae)
			{
                mobile = tfl2.getText();
                dispose();
				try
				{
				driver4.login(mobile);
				}
				catch(SQLException sql)
				{
					sql.printStackTrace();
				}
				/*if(c!=1)
					JOptionPane.showMessageDialog(Login.this,"User does'nt exist","WARNING",JOptionPane.WARNING_MESSAGE);
                SwingUtilities.invokeLater(new Runnable()
				{
                    public void run()
					{
                        LoginDetails loginDetails = new LoginDetails(1,"abcede",56,"male","1234658709");
                        loginDetails.setVisible(true);
                    }
                });*/
            }
        });
	}
}