package com.bloodBank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bloodBank.dao.RegistrationDAO;
import com.bloodBank.entity.Hospital;
import com.bloodBank.entity.Receiver;

public class RegistrationController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		//System.out.println(action);
		
		if(action.equals("hospital-registration")) {
			Hospital hospital = null;
			
			int id = Integer.parseInt(request.getParameter("hid"));
			String name = request.getParameter("hname");
			String location = request.getParameter("hlocation");
			String password = request.getParameter("hpassword");
			
			hospital = new Hospital(id, name, location, password);
			
			//System.out.println(id+ " "+ name+ " "+location+ " "+password);
			RegistrationDAO rdao = new RegistrationDAO();
			
			boolean res = rdao.insertHospitalDetails(hospital);
			//System.out.println(res);
			response.sendRedirect("/bloodBank/views/hospital-login.jsp");
		}
		else if(action.equals("receiver-registration"))
		{
			Receiver receiver = null;
			
			int id = Integer.parseInt(request.getParameter("rid"));
			String name = request.getParameter("rname");
			String gender = request.getParameter("rgender");
			String bloodgroup = request.getParameter("rbloodgroup");
			String password = request.getParameter("rpassword");
			
			receiver = new Receiver(id,name,gender,bloodgroup,password);
			
            RegistrationDAO rdao = new RegistrationDAO();
			
			boolean res = rdao.insertReceiverDetails(receiver);
			
			response.sendRedirect("/bloodBank/views/receiver-login.jsp");
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
