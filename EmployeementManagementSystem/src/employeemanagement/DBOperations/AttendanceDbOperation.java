package employeemanagement.DBOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import employeemanagement.DbConnection;
import employeemanagement.model.Attendance;

public class AttendanceDbOperation {
	static Connection conn = DbConnection.getConnection();

	public static int saveattance(int empId) {
		int i = 0;

		try {
			PreparedStatement ps = conn.prepareStatement("insert into attendance(empId,Date,month) values(?,?,?)");

			long timeNow = Calendar.getInstance().getTimeInMillis();
			java.sql.Timestamp ts = new java.sql.Timestamp(timeNow);
			System.out.println(ts);
			Calendar cal = Calendar.getInstance();
			String month = new SimpleDateFormat("MMM").format(cal.getTime());

			ps.setInt(1, empId);
			ps.setTimestamp(2, ts);
			ps.setString(3, month);
			i = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;

	}

	public static boolean checkAttendance(int empId) {
		boolean status = false;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		String currentDate = format.format(d);
		System.out.println("currentDate " + currentDate);

		try {
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM attendance WHERE Date LIKE '" + currentDate + "%' and empId=?;");
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("inside if");
				status = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return status;
	}

	public static List<Attendance> getAttandenceList(int empId, String month) {
  List<Attendance> attendancelist=new ArrayList<Attendance>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from attendance  where empId=? and month=?");
			ps.setInt(1, empId);
			ps.setString(2, month);
			ResultSet rs = ps.executeQuery();
			rs.last();
			int rowcount=rs.getRow();
			Attendance[] att=new Attendance[rowcount];
			rs.beforeFirst();
			int count=0;
			while (rs.next()) {
				att[count]=new Attendance();
				att[count].setAttendance(rs.getTimestamp("Date"));
				att[count].setEmpId(rs.getInt("empId"));
				att[count].setMonth(rs.getString("month"));
				attendancelist.add(att[count]);
				count++;
				
				
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return attendancelist;

	}

}
