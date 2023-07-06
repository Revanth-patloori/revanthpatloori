import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class FamilyDetails extends JFrame
{
	JLabel l1=new JLabel();
	public FamilyDetails(String a)
	{
		l1.setText(a);
		setSize(300,300);
		setLayout(new FlowLayout());
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		add(l1);
	}
}