import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.StringTokenizer;
/*public class LoginDetails extends JFrame implements ActionListener
{
	//JLabel name2,age2,ph_no2,gender2,sid2;
	//JPanel p1,p2,p3,p4,p5;
	JMenuBar mb;
	JMenu MedicalHistory,FamilyDetails;
	JMenuItem i1,i2,i3,i4,i5;
	JTextArea textarea=new JTextArea();
	Connection conn;
	Statement stmt;
	ResultSet rs;
	String msg="",mobile;
	int sid;
	public LoginDetails()
	{
		int a=0;
	}
	public LoginDetails(int sid,String sname,int age,String gender,String mobile)
	{
		this.mobile=mobile;
		this.sid=sid;
		String name2="NAME:"+sname;
		String age2="AGE:"+age;
		String ph_no2="MOBILE NUMBER:"+mobile;
		String gender2="GENDER:"+gender;
		String sid2="SID:"+sid;
		msg=name2+"\n"+age2+"\n"+ph_no2+"\n"+gender2+"\n"+sid2+"\n";
		createVar();
		addVar();
		//registerListners();
		setLayout(new FlowLayout());
		setSize(300,300);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void createVar()
	{
		MedicalHistory =new JMenu("MEDICAL HISTORY");
		FamilyDetails=new JMenu("FAMILY DETAILS");
		i1=new JMenuItem("Display Medical Details");
		i2=new JMenuItem("Display Family Details");
		mb=new JMenuBar();
		/*p1=new JPanel();p2=new JPanel();p3=new JPanel();p4=new JPanel();p5=new JPanel();
		p1.add(sid2);add(p1);
		p2.add(name2);add(p2);
		p3.add(age2);add(p3);
		p4.add(gender2);add(p4);
		p5.add(ph_no2);add(p5);
		textarea.setText(msg);
	}
	public void addVar()
	{
		MedicalHistory.add(i1);
		FamilyDetails.add(i2);
		mb.add(MedicalHistory);
		mb.add(FamilyDetails);
		setJMenuBar(mb);
		add(textarea);
		i1.addActionListener(this);
		i2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==i1)
		{
			dispose();
			DriverClass driver7=new DriverClass();
			LoginDetails loginDetails = new LoginDetails();
			driver7.medicaldisplay(loginDetails, sid);

			/*SwingUtilities.invokeLater(new Runnable()
			{
				public void run()
				{
					//MedicalHistory m= new MedicalHistory();
					//m.setVisible(true);
				}
			});
		}
		if(ae.getSource()==i2)
		{
			String a="Family 	Details";
			dispose();
			SwingUtilities.invokeLater(new Runnable()
			{
				public void run()
				{
					FamilyDetails m= new FamilyDetails(a);
					m.setVisible(true);
				}
			});
		}
	}
}*/
public class LoginDetails extends JFrame implements ActionListener {
    JTextArea textarea;
	int sid,age;
	String sname,gender,mobile;
	String msg;
	public LoginDetails()
	{
		createUI("");
	}
    public LoginDetails(int sid,String sname,int age,String gender,String mobile) {
		this.sid=sid;
		this.sname=sname;
		this.age=age;
		this.gender=gender;
		this.mobile=mobile;
		msg="the id number is:"+sid+"\n"+"NAME:"+sname+"\n"+"AGE:"+age+"\n"+"GENDER:"+gender+"\n"+"MOBILE NUMBER:"+mobile;
        createUI(msg);
    }

    public void createUI(String msg) {
        // Create and configure the JTextArea
        textarea = new JTextArea();
        textarea.setEditable(false);
		textarea.setText(msg);
        // Create and configure the JMenuBar, JMenu, and JMenuItem
        JMenuBar mb = new JMenuBar();
        JMenu medicalHistory = new JMenu("MEDICAL HISTORY"),Symptoms=new JMenu("SYMPTOMS"),delete=new JMenu("DELETE ACCOUNT"),modify=new JMenu("MODIFY");
        JMenuItem displayMedicalDetails = new JMenuItem("Display Medical Details"),displaySymptoms=new JMenuItem("Display Symptoms Details");
		JMenuItem del=new JMenuItem("Delete account");
		JMenuItem moddetails=new JMenuItem("Modify details");
        displayMedicalDetails.addActionListener(this);
        medicalHistory.add(displayMedicalDetails);
		displaySymptoms.addActionListener(this);
		Symptoms.add(displaySymptoms);
		del.addActionListener(this);
		delete.add(del);
		moddetails.addActionListener(this);
		modify.add(moddetails);
        mb.add(medicalHistory);
        // Set the JMenuBar and JTextArea in the JFrame
		mb.add(Symptoms);
		mb.add(delete);
		mb.add(modify);
        setJMenuBar(mb);
        add(new JScrollPane(textarea));

        // Set JFrame properties
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void setText(String text) {
        textarea.setText(text);
    }
	public void medicalTextArea(String text)
	{
		JTextArea mta=new JTextArea();
		add(mta);
		mta.setText(text);
	}
	public void symptomsTextArea(String text)
	{
		JTextArea sta=new JTextArea();
		add(sta);
		sta.setText(text);
	}
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Display Medical Details")) 
		{
            DriverClass driver1 = new DriverClass();
            driver1.medicaldisplay(this, sid); // Pass the LoginDetails instance and mid
        }
		if(ae.getActionCommand().equals("Display Symptoms Details"));
		{
			DriverClass driver2 = new DriverClass();
            driver2.Symptomsdisplay(this, sid);
		}
		if(ae.getActionCommand().equals("Delete account"))
		{
			DriverClass driver3=new DriverClass();
			driver3.deletee(this,sid);
			JOptionPane.showMessageDialog(LoginDetails.this,"Your account is deleted successfully","INFORMATION",JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}
		if(ae.getActionCommand().equals("Modify details"))
		{
			int oldsur=0,oldmed=0;
			String oldsym="";
			DriverClass driver4=new DriverClass();
			String totalString=driver4.returnString(sid);
			StringTokenizer token=new StringTokenizer(totalString,"-");
			while(token.hasMoreTokens())
			{
				oldsur=Integer.parseInt(token.nextToken());
				oldmed=Integer.parseInt(token.nextToken());
				oldsym=token.nextToken();
			}
			Table table=new Table(sid,oldsur,oldmed,oldsym);
		}
    }
}