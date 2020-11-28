package com.bloodBank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bloodBank.entity.Hospital;
import com.bloodBank.entity.Receiver;
import com.bloodBank.util.DBConnectionUtil;

public class RegistrationDAO {

	Connection connection =null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement =  null;
	
	public boolean insertHospitalDetails(Hospital h) {
		boolean flag=  false;
		
		try {
			String sql="INSERT INTO hospital_registration(hid,name,location,password) values('"+h.getId()+"', '"+h.getName()+"', '"+h.getLocation()+"', '"+h.getPassword()+"')";
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag=true;
		}
		catch(Exception e1){
			e1.printStackTrace();
		}
		
		return flag;
		
	}

	public boolean insertReceiverDetails(Receiver r) {
        boolean flag=  false;
		
		try {
			String sql="INSERT INTO receiver_registration(rid,name,gender,bloodgroup,password) values('"+r.getId()+"', '"+r.getName()+"', '"+r.getGender()+"', '"+r.getBloodgroup()+"', '"+r.getPassword()+"')";
			connection = DBConnectionUtil.openConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			flag=true;
		}
		catch(Exception e1){
			e1.printStackTrace();
		}
		
		return flag;
	}
	
}
