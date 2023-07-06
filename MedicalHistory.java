import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MedicalHistory extends JFrame
{
	JLabel sur=new JLabel("Number of surgeries:"),medication=new JLabel("Medication Taken"),disorder=new JLabel("cognitive disorders:");
	JTextField sur1=new JTextField(20),medical1=new JTextField(20),disorder1=new JTextField(20);
	JPanel p1=new JPanel(),p2=new JPanel(),p3=new JPanel(),p4=new JPanel();
	JButton next=new JButton("NEXT");
	int numb1;
	String med,dis;
	DriverClass driver5;
	public MedicalHistory(DriverClass driver5)
	{
		this.driver5=driver5;
		setSize(300,300);
		setLayout(new GridLayout(4,1));
		p1.add(sur);p1.add(sur1);add(p1);
		p2.add(medication);p2.add(medical1);add(p2);
		p3.add(disorder);p3.add(disorder1);add(p3);
		p4.add(next);add(p4);
		setVisible(true);
		setLocationRelativeTo(null);
		registerListeners();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void registerListeners()
	{
		try
		{
        next.addActionListener(new ActionListener()
		{
            public void actionPerformed(ActionEvent ae)
			{   
				numb1=Integer.parseInt(sur1.getText());
				med=medical1.getText();
				dis=disorder1.getText();
				driver5.medical(numb1,med,dis);
                dispose();
                SwingUtilities.invokeLater(new Runnable() 
				{
                    public void run()
					{
                        Symptoms fm = new Symptoms(driver5);
                        fm.setVisible(true);
                    }
				});
            }
        });
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}