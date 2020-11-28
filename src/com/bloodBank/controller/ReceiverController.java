package com.bloodBank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bloodBank.dao.RequestSampleDAO;
import com.bloodBank.dao.ShowAllSamplesDAO;
import com.bloodBank.entity.RequestSample;
import com.bloodBank.entity.ShowAllSamples;


public class ReceiverController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("available-blood-samples"))
		{
			ShowAllSamplesDAO sdao = new ShowAllSamplesDAO();
			List<ShowAllSamples> list = sdao.get();
			
			request.setAttribute("list",list);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("views/available-bloodsamples.jsp");     
			dispatcher.forward(request, response);
		} 
		else if(action.equals("request-sample")) {
            RequestSample reqSample = null;
			
			int uid = Integer.parseInt(request.getParameter("uid"));
			int hid = Integer.parseInt(request.getParameter("hid"));
			String bloodgroup = request.getParameter("bloodgroup");
			
			reqSample = new RequestSample(uid, hid, bloodgroup);
			
			//System.out.println(id+ " "+ name+ " "+location+ " "+password);
			RequestSampleDAO rsdao = new RequestSampleDAO();
			ShowAllSamplesDAO sdao = new ShowAllSamplesDAO();
			List<ShowAllSamples> list = sdao.get();
			
			request.setAttribute("list",list);
			
			boolean res = rsdao.insertRequestSample(reqSample);
			RequestDispatcher dispatcher = request.getRequestDispatcher("views/available-bloodsamples.jsp?user=receiver&uid="+uid+"&status=requested");     
			dispatcher.forward(request, response);
			//System.out.println(res);
			//response.sendRedirect("/bloodBank/views/available-bloodsamples.jsp?user=receiver&uid="+uid+"&status=requested");
			
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
