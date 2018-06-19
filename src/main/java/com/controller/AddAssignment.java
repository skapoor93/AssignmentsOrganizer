package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Assignments;
import com.dao.Dao;
import com.daoimpl.AssignmentsDaoImpl;

/**
 * Servlet implementation class AddAssignment
 */
public class AddAssignment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddAssignment() {
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
			Dao<Assignments> assignmentDao = new AssignmentsDaoImpl();
			Assignments assignment = new Assignments();
			assignment.setCourseId(Integer.parseInt(request.getParameter("courseid")));
			assignment.setDescription(request.getParameter("adescription"));
			assignmentDao.add(assignment);
			System.out.println("added "+request.getParameter("courseid") + " "+ request.getParameter("adescription"));
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
