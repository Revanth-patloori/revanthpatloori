import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.regex.*;
import java.sql.*;
public class SignUp extends JFrame {
    JTextField tf1, tf2;
    JPanel p1, p2, p3, p4, p5;
    JLabel l1, l2, l3, l4;
    JButton submit,next;
    JComboBox<String> choice;
    JRadioButton male, female;
    ButtonGroup bg;
    String number[] = { "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74",
            "75", "76", "77", "78", "79", "80" };
    String name, mobile, gender;
    int num,age;
	DriverClass driver1;
    public SignUp(DriverClass driver1)
	{
		this.driver1=driver1;
        initiate();
        addComponents();
        registerListeners();
        setSize(450, 450);
        setLayout(new GridLayout(5, 1));
        setVisible(true);
		setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initiate() {
        l1 = new JLabel("Name:");
        tf1 = new JTextField(20);
        l2 = new JLabel("Mobile Number:");
        tf2 = new JTextField(10);
        l3 = new JLabel("Age:");
        choice = new JComboBox<>(number);
        l4 = new JLabel("Gender:");
        male = new JRadioButton("Male", true);
        female = new JRadioButton("Female", false);
        bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        //submit = new JButton("Submit");
		next=new JButton("NEXT");
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
    }

    public void addComponents() {
        p1.add(l1);p1.add(tf1);add(p1);
        p2.add(l2);p2.add(tf2);add(p2);
        p3.add(l3);p3.add(choice);add(p3);
        p4.add(l4);p4.add(male);p4.add(female);add(p4);
        p5.add(next);add(p5);
    }

    public void registerListeners()
	{
		try
		{
        next.addActionListener(new ActionListener()
		{
            public void actionPerformed(ActionEvent ae)
			{
                /*name = tf1.getText();
                num = choice.getSelectedIndex();
                age = choice.getItemAt(num) + "";
                mobile = tf2.getText();
                if (male.isSelected())
				{
                    gender = "Male";
                }
				else 
				{
                    gender = "Female";
                }*/
				if(tf2.getText().length()!=10)
				{
					JOptionPane.showMessageDialog(SignUp.this,"the phno mst 10 numbers","WARNING",JOptionPane.WARNING_MESSAGE);
				}
				else if(tf2.getText()!=null)
				{
					String a="[0-9]+";
					Pattern p=Pattern.compile(a);
					Matcher m=p.matcher(tf2.getText());
					if(!m.matches())
					{
						JOptionPane.showMessageDialog(SignUp.this,"the phno mst numbers only","WARNING",JOptionPane.WARNING_MESSAGE);
					}
					else
					{
						name = tf1.getText();
						num = choice.getSelectedIndex();
						age =Integer.parseInt(choice.getItemAt(num));
						mobile = tf2.getText();
						if (male.isSelected())
						{
							gender = "Male";
						}
						else 
						{
							gender = "Female";
						}
						driver1.signUp(name,age,gender,mobile);
						
						//JOptionPane.showMessageDialog(SignUp.this,"You are siged in successfully","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
					}
				}
                dispose();
                SwingUtilities.invokeLater(new Runnable() 
				{
                    public void run()
					{
                        MedicalHistory medi = new MedicalHistory(driver1);;
                        medi.setVisible(true);
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