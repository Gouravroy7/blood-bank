package com.bloodBank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bloodBank.entity.AddBlood;
import com.bloodBank.util.DBConnectionUtil;

public class AddBloodDAO {
	
	Connection connection =null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement =  null;

	public boolean insertBloodInfo(AddBlood ab) {
		
        boolean flag=  false;
		
		try {
			String sql="INSERT INTO addblood_info(id,bloodgroups) values('"+ab.getId()+"', '"+ab.getBloodgroups()+"')";
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
