package com.nanowebhub.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nanowebhub.dao.RegistrationDao;
import com.nanowebub.beans.RegistrationBeans;

@WebServlet("/registrationcontroller")
public class RegistrationController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get Form Data
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println("Name :" + name + "Email :" + email + "Password: " + password);

		// Dao Call
		RegistrationBeans registration = new RegistrationBeans();
		registration.setName(name);
		registration.setEmail(email);
		registration.setPassword(password);
		
		RegistrationDao registerdao = new RegistrationDao();
		
		String status = registerdao.RegisterUser(registration);
		
		if(status.equals("Success"))
		{
			System.out.println("Insert Succesfully");
	        request.setAttribute("status", status);
	        response.sendRedirect("main/login.jsp");
	        
		}
		else
		{
			request.setAttribute("status", status); 
			System.out.println("Not Insert");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
