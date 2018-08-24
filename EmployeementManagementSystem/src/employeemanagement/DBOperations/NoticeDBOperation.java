package employeemanagement.DBOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import employeemanagement.DbConnection;
import employeemanagement.model.Notice;

public class NoticeDBOperation {
	static Connection conn = DbConnection.getConnection();
	
	public static int saveNotice(Notice notice)
	{
		int i = 0;
		try {
			 
			 long timeNow = Calendar.getInstance().getTimeInMillis();
			 java.sql.Timestamp ts = new java.sql.Timestamp(timeNow);
			
	
			PreparedStatement ps = conn.prepareStatement("insert into notice(datetime1,description) values(?,?)");
		    ps.setTimestamp(1, ts);
		    ps.setString(2,notice.getDescription());
		    i = ps.executeUpdate();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
		
	}
	
	public static List<Notice> getAllNotices()
	{
		List<Notice> noticeList = new ArrayList<Notice>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from notice");
			ResultSet rs = ps.executeQuery();
			rs.last();
			int noofrows = rs.getRow();
			Notice[] notice = new Notice[noofrows];
			rs.beforeFirst();
			int count = 0;
			while(rs.next())
			{
				notice[count] = new Notice();
				notice[count].setDescription(rs.getString("description"));
				notice[count].setDatetime1(rs.getTimestamp("datetime1"));
				noticeList.add(notice[count]);
				count++;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return noticeList;
	}

}
