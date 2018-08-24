package employeemanagement.DBOperations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import employeemanagement.DbConnection;
import employeemanagement.model.Message;

public class MessDBOperations {
	
	public static Connection conn = DbConnection.getConnection();
	
	public static int saveMessage(Message message)
	{
		int i =0;
		Date date = new Date(message.getSendDate().getTime());
		try {
			PreparedStatement ps = conn.prepareStatement("insert into message (heading,description,status,employeeId,senderId,sendDate) values(?,?,?,?,?,?)");
			ps.setString(1, message.getHeading());
			ps.setString(2, message.getDescription());
			ps.setString(3, message.getStatus());
			ps.setInt(4, message.getEmpId());
			ps.setInt(5, message.getSenderId());
			ps.setDate(6,date);
		    i = ps.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public static List<Message> messageListById_Status(int employeeId)
	{
		List<Message> messList = new ArrayList<Message>();
		try {
		PreparedStatement ps = conn.prepareStatement("select * from message where employeeId=? and status=?");
		ps.setInt(1, employeeId);
		ps.setString(2,"unread");
		ResultSet rs = ps.executeQuery();
		rs.last();
		System.out.println("size of resultset "+rs.getRow());
		Message[] mess = new Message[rs.getRow()];
		rs.beforeFirst(); 
	
		int count = 0;
	
			while(rs.next())
			{
				mess[count] = new Message();
		
				mess[count].setDescription(rs.getString("description"));
				mess[count].setEmpId(rs.getInt("employeeId"));
				mess[count].setHeading(rs.getString("heading"));
				mess[count].setSendDate(rs.getDate("sendDate"));
				mess[count].setSenderId(rs.getInt("senderId"));
				mess[count].setStatus(rs.getString("status"));
				mess[count].setId(rs.getInt("id"));
				messList.add(mess[count]);
				count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(messList);
		return messList;
		
	}
	
	public static List<Message> messageListById(int employeeId)
	{
		List<Message> messList = new ArrayList<Message>();
		try {
		PreparedStatement ps = conn.prepareStatement("select * from message where employeeId=?");
		ps.setInt(1, employeeId);
		ResultSet rs = ps.executeQuery();
		rs.last();
		System.out.println("size of resultset "+rs.getRow());
		Message[] mess = new Message[rs.getRow()];
		rs.beforeFirst(); 
	
		int count = 0;
	
			while(rs.next())
			{
				mess[count] = new Message();
		
				mess[count].setDescription(rs.getString("description"));
				mess[count].setEmpId(rs.getInt("employeeId"));
				mess[count].setHeading(rs.getString("heading"));
				mess[count].setSendDate(rs.getDate("sendDate"));
				mess[count].setSenderId(rs.getInt("senderId"));
				mess[count].setStatus(rs.getString("status"));
				mess[count].setId(rs.getInt("id"));
				messList.add(mess[count]);
				count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(messList);
		return messList;
		
	}
	
	
	public static Message getMessageById(int id)
	{
		Message mess = new Message();
		try{
		PreparedStatement ps = conn.prepareStatement("select * from message where id=?");
		ps.setInt(1, id);
	
		ResultSet rs = ps.executeQuery();
	
		
	
	          rs.next();
			
				mess = new Message();
		
				mess.setDescription(rs.getString("description"));
				mess.setEmpId(rs.getInt("employeeId"));
				mess.setHeading(rs.getString("heading"));
				mess.setSendDate(rs.getDate("sendDate"));
				mess.setSenderId(rs.getInt("senderId"));
				mess.setStatus(rs.getString("status"));
				mess.setId(rs.getInt("id"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mess;
		
	}
	
	public static void updateMess(int id)
	{
		PreparedStatement ps;
		try {
	    ps = conn.prepareStatement("update message set status=? where id=?");
		ps.setString(1, "read");
		ps.setInt(2,id);
	
		int i = ps.executeUpdate();
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


}
	
	public static int delteMessById(int id)
	{
		int i = 0;
		PreparedStatement ps;
		try {
	    ps = conn.prepareStatement("delete from message where id=?");
		ps.setInt(1, id);
		 i = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return i;
	}
}