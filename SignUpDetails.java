import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class SignUpDetails //extends JFrame
{
	JLabel name1,age1,ph_no1,gender1;
	JPanel pnl;
	public SignUpDetails(String name,String age,String ph_no,String gender)
	{
		/*name1=new JLabel(name);
		age1=new JLabel("Age:"+age);
		ph_no1=new JLabel("Phone Number:"+ph_no);
		gender1=new JLabel("Gender:"+gender);
		pnl=new JPanel();
		pnl.add(name1);add(pnl);
		add(age1);
		add(ph_no1);
		add(gender1);
		setLayout(new FlowLayout());
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);*/
		try
		{
			DriverClass ds=new DriverClass();
			conn=ds.getC();
			stmt1=conn.createStatement();
			try
			{
				stmt1.executeUpdate("INSERT INTO senior_citizens VALUES(1,name,age,gender,ph_no)");
			}
			catch(SQLException sqlex)
			{
				sqlex.printStackTrace();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}