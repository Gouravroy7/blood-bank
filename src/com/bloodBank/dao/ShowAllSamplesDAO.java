package com.bloodBank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bloodBank.entity.ShowAllSamples;
import com.bloodBank.util.DBConnectionUtil;



public class ShowAllSamplesDAO {
	
	
	
	public List<ShowAllSamples> get() {
		
		Connection connection =null;
		Statement statement = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement =  null;
		 
		List<ShowAllSamples> list = null;
		ShowAllSamples show = null;
		
		try
		{
		list=new ArrayList<ShowAllSamples>();
		
		String sql="select * from addblood_info";
		
		connection =DBConnectionUtil.openConnection();
		
		statement = connection.createStatement();
		
		resultSet = statement.executeQuery(sql);
		
		
		
		while(resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = getHospitalName(id);
			String bloodgroups = resultSet.getString("bloodgroups");
			show =new ShowAllSamples(id,name,bloodgroups);
			
			list.add(show);
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

	private String getHospitalName(int id) {
		String name="";
		
		try{
			
			String sql="select * from hospital_registration where hid="+id;
			
			Connection conn =DBConnectionUtil.openConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			//ps.setInt(1,id);
			
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
