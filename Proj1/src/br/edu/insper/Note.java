package br.edu.insper;

import java.util.Calendar;

public class Note {
private int id;
private int userId;
private String title;
private String content;
private Calendar data;

public Calendar getData() {
	return data;
}
public void setData(Calendar data) {
	this.data = data;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}

}
