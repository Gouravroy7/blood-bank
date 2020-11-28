package com.bloodBank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bloodBank.entity.ViewRequests;
import com.bloodBank.util.DBConnectionUtil;

public class ViewRequestsDAO {

	public List<ViewRequests> getAllRequests(int id) {
		List<ViewRequests> list = null;
		ViewRequests view = null;
		Connection connection =null;
		Statement statement = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement =  null;
		
		try
		{
		list=new ArrayList<ViewRequests>();
		
		String sql="select uid,bloodgroup from request_sample where hid="+id;
		
		connection =DBConnectionUtil.openConnection();
		
		statement = connection.createStatement();
		
		resultSet = statement.executeQuery(sql);
		
		
		
		while(resultSet.next()) {
			int uid = resultSet.getInt("uid");
			String uname = getReceiverName(uid);
			String bloodgroup = resultSet.getString("bloodgroup");
			view =new ViewRequests(uid,uname,bloodgroup);
			
			list.add(view);
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return list;
	}

	private String getReceiverName(int id) {
      String name="";
		
		try{
			
			String sql="select name from receiver_registration where rid="+id;
			
			Connection conn =DBConnectionUtil.openConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery(sql);
			
			if(rs.next())
			{
				name = rs.getString("name");
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return name;
	}

}
