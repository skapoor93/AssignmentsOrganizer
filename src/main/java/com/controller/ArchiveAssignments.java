package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AssignmentsDao;
import com.daoimpl.AssignmentsDaoImpl;

/**
 * Servlet implementation class ArchiveCourses
 */
@WebServlet("/final/ArchiveAssignments")
public class ArchiveAssignments extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ArchiveAssignments() {
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
			AssignmentsDao assignments = new AssignmentsDaoImpl();
			assignments.archiveAssignments();
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
