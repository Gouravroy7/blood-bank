package com.bloodBank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bloodBank.entity.Hospital;
import com.bloodBank.entity.Receiver;
import com.bloodBank.util.DBConnectionUtil;

public class LoginDAO {
	
	
	public String authenticateHospital(Hospital h) {
	String sql="select * from hospital_registration where hid=? and password=?";
		
		try{
			Connection connection=DBConnectionUtil.openConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, h.getId());
			ps.setString(2, h.getPassword());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				return "true";
			}
			else
				return "false";
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "error";
	}

	public String authenticateReceiver(Receiver r) {
       String sql="select * from receiver_registration where rid=? and password=?";
		
		try{
			Connection connection=DBConnectionUtil.openConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, r.getId());
			ps.setString(2, r.getPassword());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				return "true";
			}
			else
				return "false";
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "error";
	}
	

}
