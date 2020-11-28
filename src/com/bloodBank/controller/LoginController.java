package com.bloodBank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bloodBank.dao.LoginDAO;
import com.bloodBank.entity.Hospital;
import com.bloodBank.entity.Receiver;

public class LoginController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("hospital-login"))
		{
		int id = Integer.parseInt(request.getParameter("hid"));
		String password = request.getParameter("hpassword");
		
		Hospital hospital = new Hospital(id,password);
		LoginDAO ldao = new LoginDAO();
		String status = ldao.authenticateHospital(hospital);
		
		if(status.equals("true")){
			HttpSession session = request.getSession();
			session.setAttribute("hid", id);
			response.sendRedirect("/bloodBank/views/addblood-info.jsp?status=true&user=hospital&id="+id);
			
		}
		else
			response.sendRedirect("/bloodBank/views/hospital-login.jsp?status=false");
		}
		else if(action.equals("receiver-login"))
		{
			int id = Integer.parseInt(request.getParameter("rid"));
			String password = request.getParameter("rpassword");
			
			Receiver receiver = new Receiver(id,password);
			LoginDAO ldao = new LoginDAO();
			String status = ldao.authenticateReceiver(receiver);
			
			if(status.equals("true")){
				HttpSession session = request.getSession();
				session.setAttribute("hid", id);
				response.sendRedirect("/bloodBank/ReceiverController?action=available-blood-samples&user=receiver&uid="+id);
			}
			else
				response.sendRedirect("/bloodBank/views/receiver-login.jsp?status=false");
		}
		}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
