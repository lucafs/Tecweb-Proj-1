package br.edu.insper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DAO {
private Connection connection = null;
public DAO() {
 try {
	Class.forName("com.mysql.jdbc.Driver");
	 connection = DriverManager.getConnection(
	"jdbc:mysql://localhost/notes", "root", "/");
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
public List<User> getListaUser() {
	List<User> users = new ArrayList<User>();
	try {
		PreparedStatement stmt = connection.
		prepareStatement("SELECT * FROM User");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setNome(rs.getString("nome"));
			user.setSenha(rs.getString("senha"));
			users.add(user);
		}
		rs.close();
		stmt.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return users;
}
public List<Note> getListaNote() {
	List<Note> notes = new ArrayList<Note>();
	try {
		PreparedStatement stmt = connection.
		 prepareStatement("SELECT * FROM Note");
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Note note = new Note();
			note.setId(rs.getInt("id"));
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("date"));
			note.setTitle(rs.getString("title"));
			note.setContent(rs.getString("content"));
			note.setUserId(rs.getInt("user_id"));
			notes.add(note);
		}
		rs.close();
		stmt.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return notes;
}


public void adicionaUser(User user) {
	String sql = "INSERT INTO User" +
	"(nome,senha) values(?,?)";
	try {
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,user.getNome());
		stmt.setString(2,user.getSenha());
		stmt.execute();
		stmt.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void adicionaNotes(Note note, User user) {
	String sql = "INSERT INTO User" +
	"(title,content,date,user_id) values(?,?,?,?)";
	try {
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,note.getTitle());
		stmt.setString(2,note.getContent());
		stmt.setDate(3, new java.sql.Date(note.getData().getTimeInMillis()));
		stmt.setInt(4,user.getId());
		stmt.execute();
		stmt.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void removeNote(Integer id) {
	try {
		PreparedStatement stmt = connection
		 .prepareStatement("DELETE FROM Note WHERE id=?");
		stmt.setInt(1, id);
		stmt.execute();
		stmt.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void removeUser(Integer id) {
	try {
		PreparedStatement stmt = connection
		 .prepareStatement("DELETE FROM User WHERE id=?");
		stmt.setInt(1, id);
		stmt.execute();
		stmt.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void close() {
	try {
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}	