package com.bloodBank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bloodBank.entity.RequestSample;
import com.bloodBank.util.DBConnectionUtil;

public class RequestSampleDAO {
	
	Connection connection =null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement =  null;

	public boolean insertRequestSample(RequestSample r) {
        boolean flag=  false;
		
		try {
			String sql="INSERT INTO request_sample(uid,hid,bloodgroup) values('"+r.getUid()+"', '"+r.getHid()+"', '"+r.getBloodgroup()+"')";
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
