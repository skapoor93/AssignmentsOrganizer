package com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.beans.Courses;
import com.dao.Dao;
import com.dao.DatabaseConnection;

public class CoursesDaoImpl implements Dao<Courses>{

	public List<Courses> getAll() {
		List<Courses> courses = new ArrayList<Courses>();
		DatabaseConnection db = new DatabaseConnection();
		try(Connection c = db.connection()){
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM courses");
			while (rs.next()) {
				courses.add(new Courses(
						rs.getInt("id"),
						rs.getString("number"),
						rs.getString("name")
						));
			}
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		return courses;
	}

	public Optional<Courses> get(int id) {
		return Optional.empty();
	}

	public void add(Courses course) {
		DatabaseConnection db = new DatabaseConnection();
		try (Connection c = db.connection()) {
			PreparedStatement pstmt = c.prepareStatement("INSERT INTO courses (number, name) VALUES (?, ?)");
			pstmt.setString(1, course.getNumber());
			pstmt.setString(2, course.getName());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Courses obj) {


	}

	public void delete(int id) {
		DatabaseConnection db = new DatabaseConnection();
		try (Connection c = db.connection()) {
			PreparedStatement stmt = c.prepareStatement("Delete from courses where id = ?");
			stmt.setInt(1, id);
			stmt.executeUpdate();
			stmt = c.prepareStatement("Delete from assignments where course_id = ?");
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
