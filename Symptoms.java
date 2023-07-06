import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Symptoms extends JFrame
{
	JLabel sym=new JLabel("Enter the symptoms:");
	JTextField sym1=new JTextField(20);
	JPanel p1=new JPanel(),p2=new JPanel();
	JButton submit=new JButton("Submit");
	int numb1;
	String sys;
	DriverClass driver6;
	public Symptoms(DriverClass driver6)
	{
		this.driver6=driver6;
		setSize(300,300);
		setLayout(new GridLayout(2,1));
		p1.add(sym);p1.add(sym1);add(p1);
		p2.add(submit);add(p2);
		setVisible(true);
		setLocationRelativeTo(null);
		registerListeners();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void registerListeners()
	{
		try
		{
        submit.addActionListener(new ActionListener()
		{
            public void actionPerformed(ActionEvent ae)
			{   
				sys=(String)sym1.getText();
				driver6.symptoms(sys);
                dispose();
                /*SwingUtilities.invokeLater(new Runnable() 
				{
                    public void run()
					{
                        FamilyDetails fm = new FamilyDetails(driver5);
                        fm.setVisible(true);
                    }
				});*/
				JOptionPane.showMessageDialog(Symptoms.this,"You have signed in successfully","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
            }
        });
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}