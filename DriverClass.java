import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Properties;
public class DriverClass extends JFrame{
    Connection conn;
    ResultSet rs;
    Statement stmt1,stmt2,stmt3,stmt4,stmt5;
	int c=0;
    public DriverClass(){
        try{
            String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
            String username = "revanth";
            String password = "13021980";

            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(jdbcUrl, username, password);
            stmt1 = conn.createStatement();
			stmt2 = conn.createStatement();
			stmt3 = conn.createStatement();
			stmt4 = conn.createStatement();
			stmt5 = conn.createStatement();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void signUp(String name, int age, String gender, String mobile) {
        try {
            ResultSet st = stmt1.executeQuery("SELECT MAX(SID) FROM senior_citizens");
            int maxval = 0;
            if (st.next()) {
                maxval = st.getInt(1);}
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO senior_citizens VALUES(?, ?, ?, ?, ?)");
            stmt.setInt(1, maxval+1);
            stmt.setString(2, name);
            stmt.setInt(3, age);
            stmt.setString(4, gender);
            stmt.setString(5, mobile);
            stmt.executeUpdate();
        } catch (SQLException sqlex){
            sqlex.printStackTrace();
        }
    }
	public void login(String mobile) throws SQLException {
    try {
        ResultSet st1 = stmt1.executeQuery("SELECT * FROM senior_citizens");
        while (st1.next()){
            if (st1.getString(5).equals(mobile)){
				c=1;
                break;
            }
        }if(c==1){
        final String selectedmobile = mobile; // Use a different variable name

        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                try{
                    int sid = st1.getInt(1);
                    String sname = st1.getString(2);
                    int age = st1.getInt(3);
                    String gender = st1.getString(4);
                    //String mobile = selectedMobile; // Use the correct local variable name
                    LoginDetails loginDetails = new LoginDetails(sid, sname, age, gender, mobile);
                    loginDetails.setVisible(true);
                }catch (SQLException sqlex) {
                    sqlex.printStackTrace();
                }
				}
            });
        }else{
			JOptionPane.showMessageDialog(DriverClass.this,"The user does'nt exist","WARNING",JOptionPane.WARNING_MESSAGE);
		}
    } catch (SQLException sqlex) {
        sqlex.printStackTrace();
    }
	}
	public void medicaldisplay(LoginDetails loginDetails, int mid) {
    try {
        ResultSet st1 = stmt1.executeQuery("SELECT * FROM medical_history");
        boolean exists = false;
        while (st1.next()) {
            if (st1.getInt(1) == mid) {
                exists = true;
                break;
            }
        }
        if (exists) {
            final int selectedMid = mid;

            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    try {
                        String mid1 = "Medical id: " + st1.getInt(1);
                        String numsur = "Number of Surgeries undergone: " + st1.getInt(2);
                        String medication = "The medications taken: " + st1.getString(3);
                        String disorder = "The Cognitive Disorders are: " + st1.getString(4);
                        String number = mid1 + "\n" + numsur + "\n" + medication + "\n" + disorder + "\n";

                        // Set the text in the textarea
                        loginDetails.medicalTextArea(number);;
                        loginDetails.setVisible(true);
                    } catch (SQLException sqlex) {
                        sqlex.printStackTrace();
                    }
                }
            });
        } else {
            JOptionPane.showMessageDialog(null, "The user doesn't exist", "WARNING", JOptionPane.WARNING_MESSAGE);
        }
    } catch (SQLException sqlex) {
        sqlex.printStackTrace();
    }
}
public void Symptomsdisplay(LoginDetails loginDetails, int Symptom_id) {
    try {
        ResultSet st2 = stmt2.executeQuery("SELECT * FROM symptoms");
        boolean exists = false;
        while (st2.next()) {
            if (st2.getInt(1) == Symptom_id) {
                exists = true;
                break;
            }
        }
        if (exists) {
            final int selectedSymptom_sid = Symptom_id;

            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    try {
                        String Symptom_id1 = "Symptom id: " + st2.getInt(1);
                        String name = "Symptom name : " + st2.getString(2);
                        String number1 = Symptom_id1 + "\n" + name + "\n";

                        // Set the text in the textarea
                        loginDetails.symptomsTextArea(number1);
                        loginDetails.setVisible(true);
                    } catch (SQLException sqlex) {
                        sqlex.printStackTrace();
                    }
                }
            });
        }
    } catch (SQLException sqlex) {
        sqlex.printStackTrace();
    }
}

	public void medical(int num,String medication, String disorders) 
	{
        try {
            ResultSet st1 = stmt1.executeQuery("SELECT MAX(MID) FROM medical_history");
            int maxval1 = 0;
            if (st1.next()) {
                maxval1=st1.getInt(1);
            }
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO medical_history VALUES(?, ?, ?, ?)");
            stmt.setInt(1, maxval1+1);
            stmt.setInt(2,num);
            stmt.setString(3,medication);
            stmt.setString(4,disorders);
            stmt.executeUpdate();
        } catch (SQLException sqlex){
            sqlex.printStackTrace();
        }
	}
	public void symptoms(String symp)
	{
		try{
			ResultSet st2=stmt2.executeQuery("SELECT MAX(SYMPTOM_ID) FROM symptoms");
			int maxval2=0;
			if(st2.next()){
				maxval2=st2.getInt(1);
			}
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO symptoms VALUES(?, ?)");
            stmt.setInt(1, maxval2+1);
            stmt.setString(2,symp);
			stmt.executeUpdate();
		}catch (SQLException sqlex){
            sqlex.printStackTrace();
        }
	}
	public void deletee(LoginDetails ldd,int id){
		try{
		String query1 = "DELETE FROM senior_citizens WHERE sid = ?";
		PreparedStatement pstmt1 = conn.prepareStatement(query1);
		pstmt1.setInt(1, id);
		pstmt1.executeUpdate();
		String query2 = "DELETE FROM medical_history WHERE mid = ?";
		PreparedStatement pstmt2 = conn.prepareStatement(query2);
		pstmt2.setInt(1, id);
		pstmt2.executeUpdate();
		String query3 = "DELETE FROM symptoms WHERE symptom_id = ?";
		PreparedStatement pstmt3 = conn.prepareStatement(query3);
		pstmt3.setInt(1, id);
		pstmt3.executeUpdate();
		}catch(SQLException sqlw){
			sqlw.printStackTrace();
		}
	}
	
	public void modifydetails(int id, String numsurg, String medi, String syms) {
    try {
        int num = Integer.parseInt(numsurg);
        String query4 = "UPDATE medical_history SET surgeries=? WHERE mid=?";
        PreparedStatement pstmt4 = conn.prepareStatement(query4);
        pstmt4.setInt(1, num);
        pstmt4.setInt(2, id);
        pstmt4.executeUpdate();

        String query5 = "UPDATE medical_history SET medication_taken=? WHERE mid=?";
        PreparedStatement pstmt5 = conn.prepareStatement(query5);
        pstmt5.setString(1, medi);
        pstmt5.setInt(2, id);
        pstmt5.executeUpdate();

        String query6 = "UPDATE symptoms SET symptom_name=? WHERE symptom_id=?";
        PreparedStatement pstmt6 = conn.prepareStatement(query6);
        pstmt6.setString(1, syms);
        pstmt6.setInt(2, id);
        pstmt6.executeUpdate();
    } catch (SQLException sqlw) {
        sqlw.printStackTrace();
    }
}
	public String returnString(int id)
	{
    String totalstring = "";
    try{
        String query5 = "SELECT surgeries, medication_taken from medical_history where mid=?";
        PreparedStatement pstmt = conn.prepareStatement(query5);
        pstmt.setInt(1, id);
        ResultSet rst5 = pstmt.executeQuery();

        if (rst5.next()) {
            int oldsurgeries = rst5.getInt(1);
            int oldmedical = rst5.getInt(2);

            String query6 = "SELECT symptom_name from symptoms where symptom_id=?";
            PreparedStatement pstmt2 = conn.prepareStatement(query6);
            pstmt2.setInt(1, id);
            ResultSet rst6 = pstmt2.executeQuery();
		
		if (rst6.next()){
			String oldsymptoms = rst6.getString(1);
			totalstring = oldsurgeries + "-" + oldmedical + "-" + oldsymptoms;
		}
		}
    }catch (SQLException sql){
        sql.printStackTrace();
    }
    return totalstring;
	}
}