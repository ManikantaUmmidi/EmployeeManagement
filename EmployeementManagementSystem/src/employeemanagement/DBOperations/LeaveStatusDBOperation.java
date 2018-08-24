package employeemanagement.DBOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import employeemanagement.DbConnection;
import employeemanagement.GetUserFromSession;
import employeemanagement.model.ApplyLeave;

public class LeaveStatusDBOperation {

	static Connection conn = DbConnection.getConnection();

	public static int saveLeaveStatus(ApplyLeave leave, int hr) throws SQLException {
		System.out.println("saveleave: "+hr);
		conn.setAutoCommit(false);
		int i = 0;
		long numberOfDays = 0;

		try {

			// getting number of days from fromdate and todate
			SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
			String fromDate = myFormat.format(leave.getFromDate());
			String toDate = myFormat.format(leave.getToDate());

			try {
				Date date1 = myFormat.parse(fromDate);
				Date date2 = myFormat.parse(toDate);
				long time = date2.getTime() - date1.getTime();
				numberOfDays = TimeUnit.DAYS.convert(time, TimeUnit.MILLISECONDS);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			PreparedStatement ps = conn.prepareStatement(
					"select " + leave.getTypeofLeave() + " from leavetaken where month=? and empId=?");
			ps.setString(1, leave.getMonth());
			ps.setInt(2, leave.getEmpId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				int typeOfLeave = rs.getInt(1);

				if (typeOfLeave > 2) {

					return -1;

				} else if (typeOfLeave + numberOfDays > 2) {
					return -1;

				} else if (numberOfDays > 0) {
					return -1;
				} else {
					  System.out.println("hr value:  "+hr);
					PreparedStatement ps2 = conn.prepareStatement(
							"insert into leavestatus (fromDate,toDate,reason,typeofLeave,month,status,letter,empId,hr) values(?,?,?,?,?,?,?,?,?)");
					ps2.setDate(1, new java.sql.Date(leave.getFromDate().getTime()));
					ps2.setDate(2, new java.sql.Date(leave.getToDate().getTime()));
					ps2.setString(3, leave.getReason());
					ps2.setString(4, leave.getTypeofLeave());
					ps2.setString(5, leave.getMonth());
					ps2.setString(6, "pending");
					ps2.setString(7, "unread");
					ps2.setInt(8, leave.getEmpId());
					ps2.setInt(9, hr);
					i = ps2.executeUpdate();

					return i;

				}

				/*
				 * PreparedStatement ps3 = conn.prepareStatement("select "
				 * +leavetype+"from leavestatus where month=? and empId=?");
				 */

			} else {

				if (numberOfDays > 2 || numberOfDays == 0) {
					return -1;

					/*
					 * System.out.println(
					 * "no of days for leave should be less than or equals to 2 days "
					 * );
					 */

				}

				else {
					
					

					PreparedStatement ps2 = conn.prepareStatement(
							"insert into leavestatus (fromDate,toDate,reason,typeofLeave,month,status,letter,empId,hr) values(?,?,?,?,?,?,?,?,?)");
					ps2.setDate(1, new java.sql.Date(leave.getFromDate().getTime()));
					ps2.setDate(2, new java.sql.Date(leave.getToDate().getTime()));
					ps2.setString(3, leave.getReason());
					ps2.setString(4, leave.getTypeofLeave());
					ps2.setString(5, leave.getMonth());
					ps2.setString(6, "pending");
					ps2.setString(7, "unread");
					ps2.setInt(8, leave.getEmpId());
					ps2.setInt(9, hr);
					i = ps2.executeUpdate();

					conn.commit();
					return i;
				}

			}

		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return i;
	}

	public static List<ApplyLeave> getAllLeaveLetters(int hrname) {

		List<ApplyLeave> leaveList = new ArrayList<ApplyLeave>();
		try {

			PreparedStatement ps = conn.prepareStatement("select * from leavestatus where hr=?");
			ps.setInt(1, hrname);
			ResultSet rs = ps.executeQuery();
			rs.last();
			int totalRows = rs.getRow();

			ApplyLeave[] leave = new ApplyLeave[totalRows];
			rs.beforeFirst();
			int count = 0;
			while (rs.next()) {
				leave[count] = new ApplyLeave();
				leave[count].setEmpId(rs.getInt("empId"));
				leave[count].setFromDate(rs.getDate("fromDate"));
				leave[count].setId(rs.getInt("id"));
				leave[count].setLetter(rs.getString("letter"));
				leave[count].setMonth(rs.getString("month"));
				leave[count].setReason(rs.getString("reason"));
				leave[count].setStatus(rs.getString("status"));
				leave[count].setToDate(rs.getDate("toDate"));
				leave[count].setTypeofLeave(rs.getString("typeofLeave"));

				leaveList.add(leave[count]);
				count++;

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return leaveList;

	}

	public static List<ApplyLeave> getAllLeaveLettersByStatus() {

		List<ApplyLeave> leaveList = new ArrayList<ApplyLeave>();
		try {

			PreparedStatement ps = conn.prepareStatement("select * from leavestatus where letter=?");
			ps.setString(1, "unread");
			ResultSet rs = ps.executeQuery();
			rs.last();
			int totalRows = rs.getRow();

			ApplyLeave[] leave = new ApplyLeave[totalRows];
			rs.beforeFirst();
			int count = 0;
			while (rs.next()) {
				leave[count] = new ApplyLeave();
				leave[count].setEmpId(rs.getInt("empId"));
				leave[count].setFromDate(rs.getDate("fromDate"));
				leave[count].setId(rs.getInt("id"));
				leave[count].setLetter(rs.getString("letter"));
				leave[count].setMonth(rs.getString("month"));
				leave[count].setReason(rs.getString("reason"));
				leave[count].setStatus(rs.getString("status"));
				leave[count].setToDate(rs.getDate("toDate"));
				leave[count].setTypeofLeave(rs.getString("typeofLeave"));

				leaveList.add(leave[count]);
				count++;

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return leaveList;

	}

	public static ApplyLeave getAllLeaveLetterById(int id) {

		ApplyLeave leave = new ApplyLeave();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from leavestatus where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				leave = new ApplyLeave();
				leave.setEmpId(rs.getInt("empId"));
				leave.setFromDate(rs.getDate("fromDate"));
				leave.setId(rs.getInt("id"));
				leave.setLetter(rs.getString("letter"));
				leave.setMonth(rs.getString("month"));
				leave.setReason(rs.getString("reason"));
				leave.setStatus(rs.getString("status"));
				leave.setToDate(rs.getDate("toDate"));
				leave.setTypeofLeave(rs.getString("typeofLeave"));

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return leave;

	}

	public static ApplyLeave getAllLeaveLetterByEmpId(int empId) {

		ApplyLeave leave = new ApplyLeave();
		try {

			PreparedStatement ps = conn.prepareStatement("select * from leavestatus where empId=? and status=?");
			ps.setInt(1, empId);
			ps.setString(2, "pending");
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				leave = new ApplyLeave();
				leave.setEmpId(rs.getInt("empId"));
				leave.setFromDate(rs.getDate("fromDate"));
				leave.setId(rs.getInt("id"));
				leave.setLetter(rs.getString("letter"));
				leave.setMonth(rs.getString("month"));
				leave.setReason(rs.getString("reason"));
				leave.setStatus(rs.getString("status"));
				leave.setToDate(rs.getDate("toDate"));
				leave.setTypeofLeave(rs.getString("typeofLeave"));

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return leave;

	}
	
	public static List<ApplyLeave> getAllLeaveLetterListByEmpId(int empId) {

		List<ApplyLeave> leaveList = new ArrayList<ApplyLeave>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from leavestatus where empId=?");
			ps.setInt(1, empId);
  			ResultSet rs = ps.executeQuery();
			rs.last();
			int rowCount = rs.getRow();
			rs.beforeFirst();
			
			ApplyLeave[] leave = new ApplyLeave[rowCount];
            int count = 0;
			if (rs.next()) {
				leave[count] = new ApplyLeave();
				leave[count].setEmpId(rs.getInt("empId"));
				leave[count].setFromDate(rs.getDate("fromDate"));
				leave[count].setId(rs.getInt("id"));
				leave[count].setLetter(rs.getString("letter"));
				leave[count].setMonth(rs.getString("month"));
				leave[count].setReason(rs.getString("reason"));
				leave[count].setStatus(rs.getString("status"));
				leave[count].setToDate(rs.getDate("toDate"));
				leave[count].setTypeofLeave(rs.getString("typeofLeave"));
				leaveList.add(leave[count]);
				count++;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return leaveList;

	}

	public static int updateLeaveStatusById(int id) {
		int i = 0;
		try {

			PreparedStatement ps = conn.prepareStatement("update leavestatus set letter=? where id=?");
			ps.setString(1, "read");
			ps.setInt(2, id);
			i = ps.executeUpdate();

		} catch (Exception e) {
		}

		return i;

	}

	public static int updateLeaveStatusToApprove(int id) {
		int i = 0;
		try {

			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("update leavestatus set status=? where empId=?");
			ps.setString(1, "approve");
			ps.setInt(2, id);
			i = ps.executeUpdate();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return i;
	}

	public static int updateLeaveStatusToReject(int id) {
		int i = 0;
		try {

			PreparedStatement ps = conn.prepareStatement("update leavestatus set status=? where empId=?");
			ps.setString(1, "reject");
			ps.setInt(2, id);
			i = ps.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return i;
	}

	public static int saveLeaveTakenData(ApplyLeave leave) {
		int i = 0;
		try {
			SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
			String fromDate = myFormat.format(leave.getFromDate());
			String toDate = myFormat.format(leave.getToDate());

			Date date1 = myFormat.parse(fromDate);
			Date date2 = myFormat.parse(toDate);
			long time = date2.getTime() - date1.getTime();
			int numberOfDays = (int) TimeUnit.DAYS.convert(time, TimeUnit.MILLISECONDS);
			conn.setAutoCommit(false);

			String leavetype = leave.getTypeofLeave();
			PreparedStatement ps = conn
					.prepareStatement("insert into leavetaken(" + leavetype + ",month,empId) values(?,?,?)");
			ps.setInt(1, numberOfDays);
			ps.setString(2, leave.getMonth());
			ps.setInt(3, leave.getEmpId());

			i = ps.executeUpdate();

		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		return i;

	}

	public static int updateActualLeave(ApplyLeave leave) {

		int i = 0;
		try {
			conn.setAutoCommit(false);
			SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
			String fromDate = myFormat.format(leave.getFromDate());
			String toDate = myFormat.format(leave.getToDate());

			Date date1 = myFormat.parse(fromDate);
			Date date2 = myFormat.parse(toDate);
			long time = date2.getTime() - date1.getTime();
			int numberOfDays = (int) TimeUnit.DAYS.convert(time, TimeUnit.MILLISECONDS);

			PreparedStatement ps2 = conn.prepareStatement("select * from leaves where empId=?");
			ps2.setInt(1, leave.getEmpId());
			ResultSet rs = ps2.executeQuery();

			if (rs.next()) {
				int totalLeaves = rs.getInt(leave.getTypeofLeave());
				PreparedStatement ps = conn
						.prepareStatement("update leaves set " + leave.getTypeofLeave() + "=? where empId=?");
				ps.setInt(1, totalLeaves - numberOfDays);
				ps.setInt(2, leave.getEmpId());
				i = ps.executeUpdate();
			} else {
				return -1;
			}

			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return i;
	}

	public static boolean getLeaveStatus(int empId) {
		boolean status = false;

		try {

			PreparedStatement ps = conn.prepareStatement("select * from leavestatus where status=? and empId=?");
			ps.setString(1, "pending");
			ps.setInt(2, empId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				status = true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return status;
	}

}
