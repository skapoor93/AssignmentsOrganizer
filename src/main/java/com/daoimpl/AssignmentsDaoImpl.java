package com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.beans.Assignments;
import com.dao.AssignmentsDao;
import com.dao.DatabaseConnection;

public class AssignmentsDaoImpl implements AssignmentsDao{

	public List<Assignments> getAll() {
		List<Assignments> assignments = new ArrayList<>();
		DatabaseConnection db = new DatabaseConnection();
		try(Connection c = db.connection()){
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM assignments");
			while (rs.next()) {
				assignments.add(new Assignments(
						rs.getInt("id"),
						rs.getString("description"),
						rs.getInt("status"),
						rs.getInt("course_id")
						));
			}
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		return assignments;
	}

	public Optional<Assignments> get(int id) {
		return Optional.empty();
	}

	public void add(Assignments assignment) {
		DatabaseConnection db = new DatabaseConnection();
		try (Connection c = db.connection()) {
			PreparedStatement pstmt = c.prepareStatement("INSERT INTO assignments (description, course_id) VALUES (?, ?)");
			pstmt.setString(1, assignment.getDescription());
			pstmt.setInt(2, assignment.getCourseId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Assignments obj) {

	}

	public void delete(int id) {
		DatabaseConnection db = new DatabaseConnection();
		try (Connection c = db.connection()) {
			PreparedStatement pstmt = c.prepareStatement("Delete from assignments where id = ?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateStatus(int id) {
		DatabaseConnection db = new DatabaseConnection();
		try (Connection c = db.connection()) {
			PreparedStatement pstmt = c.prepareStatement("Update assignments set status = !status where id = ?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void archiveAssignments() {
		DatabaseConnection db = new DatabaseConnection();
		try (Connection c = db.connection()) {
			PreparedStatement pstmt = c.prepareStatement("Delete from assignments where status = 0");
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
