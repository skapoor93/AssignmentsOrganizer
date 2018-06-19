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
 * Servlet implementation class DeleteAssignment
 */
public class DeleteAssignment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteAssignment() {
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
			assignmentDao.delete(Integer.parseInt(request.getParameter("deleteId")));
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
