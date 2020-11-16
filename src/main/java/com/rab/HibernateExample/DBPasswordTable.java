// While declaring this class, I assume DB server is installed and a table: Password(Id, WebsiteName, EmailId, Password) is already created in DB.

package com.rab.HibernateExample;

import javax.persistence.*;

@Entity
@Table(name="Password")
public class DBPasswordTable {
	@Id
	private int Id;
	private String websiteName;
	private String emailId;
	private String password;

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getWebsiteName() {
		return websiteName;
	}
	public void setWebsiteName(String websiteName) {
		this.websiteName = websiteName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "DBPasswordTable [Id=" + Id + ", websiteName=" + websiteName + ", emailId=" + emailId + ", Password="
				+ password + "]";
	}
}
