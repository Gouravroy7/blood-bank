package com.bloodBank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bloodBank.dao.AddBloodDAO;
import com.bloodBank.dao.ShowAllSamplesDAO;
import com.bloodBank.dao.ViewRequestsDAO;
import com.bloodBank.entity.AddBlood;
import com.bloodBank.entity.ShowAllSamples;
import com.bloodBank.entity.ViewRequests;

public class HospitalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		//System.out.println(action);
		if(action.equals("addblood"))
		{
			int id  = Integer.parseInt(request.getParameter("hid"));
            String bloodgroups = request.getParameter("bloodgroups");
			
			AddBlood addBlood = new AddBlood(id, bloodgroups);
			AddBloodDAO abdao = new AddBloodDAO();
			
			boolean res = abdao.insertBloodInfo(addBlood);
			
			response.sendRedirect("/bloodBank/views/addblood-info.jsp?status=true&user=hospital&id="+id+"&sample=added");
		}
		else if(action.equals("available-blood-samples"))
		{
			ShowAllSamplesDAO sdao = new ShowAllSamplesDAO();
			List<ShowAllSamples> list = sdao.get();
			
			request.setAttribute("list",list);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("views/available-bloodsamples.jsp?user=hospital");     
			dispatcher.forward(request, response);
		}
		else if(action.equals("view-requests"))
		{
			int id = Integer.parseInt(request.getParameter("hid"));
			ViewRequestsDAO vdao = new ViewRequestsDAO();
			List<ViewRequests> list = vdao.getAllRequests(id);
			
			request.setAttribute("list", list);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("views/view-requests.jsp?user=hospital&hid="+id);
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
