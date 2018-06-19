package com.dao;

import com.beans.Assignments;

public interface AssignmentsDao extends Dao<Assignments>{
	// update item
	public void updateStatus(int id);
	
	public void archiveAssignments();
}
