package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Courses;
import com.dao.Dao;
import com.daoimpl.CoursesDaoImpl;

/**
 * Servlet implementation class AddCourse
 */
public class AddCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCourse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			Dao<Courses> courseDao = new CoursesDaoImpl();
			Courses course = new Courses();
			course.setName(request.getParameter("cname"));
			course.setNumber(request.getParameter("cnumber"));
			courseDao.add(course);
			System.out.println("added "+request.getParameter("cnumber") + " "+ request.getParameter("cname"));
		}
		catch( Exception e )
		{
			throw new ServletException( e );
		}
		response.sendRedirect("/AssignmentsOrganizer/Organizer");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
