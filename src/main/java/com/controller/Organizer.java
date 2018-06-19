package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Assignments;
import com.beans.Courses;
import com.dao.Dao;
import com.daoimpl.AssignmentsDaoImpl;
import com.daoimpl.CoursesDaoImpl;

/**
 * Servlet implementation class Organizer
 */
public class Organizer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Organizer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Dao<Courses> courseDao = new CoursesDaoImpl();
			Dao<Assignments> assignmentDao = new AssignmentsDaoImpl();
			request.setAttribute("assignments", assignmentDao.getAll());
			request.setAttribute("courses", courseDao.getAll());
			request.getRequestDispatcher( "/WEB-INF/view/Organizer.jsp" ).forward(
					request, response );
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
