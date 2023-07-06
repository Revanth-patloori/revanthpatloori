import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Table extends JFrame
{
	public Table(int sid,int sur,int med,String symp)
	{
		JLabel l10=new JLabel("Number of surgeries undergone:"),l11=new JLabel("Medication taken"),l12=new JLabel("Symptoms");
		JTextField tf10=new JTextField(10),tf11=new JTextField(20),tf12=new JTextField(20);
		JPanel p1=new JPanel(),p2=new JPanel(),p3=new JPanel(),p4=new JPanel();
		JButton btn=new JButton("Modify");
		p1.add(l10);p1.add(tf10);add(p1);
		p2.add(l11);p2.add(tf11);add(p2);
		p3.add(l12);p3.add(tf12);add(p3);
		p4.add(btn);add(p4);
		setLayout(new GridLayout(4,1));
		setSize(600,300);
		tf10.setText(sur+"");
		tf11.setText(med+"");
		tf12.setText(symp);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		btn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				DriverClass driver4=new DriverClass();
				driver4.modifydetails(sid,tf10.getText(),tf11.getText(),tf12.getText());
				JOptionPane.showMessageDialog(Table.this,"The details are updated successfully","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
		});
	}	
}
