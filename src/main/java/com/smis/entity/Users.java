package com.smis.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_generator")
	@SequenceGenerator(name="users_generator", sequenceName = "users_seq", allocationSize=1)
	long userId;
	@NotEmpty
	private String userName;
	@NotEmpty
	private String password;
	@NotEmpty
	private String role;
	@ManyToOne
	@JoinColumn(name="districtId")
	@NotNull
	private District district;
	private boolean enabled;
	private String enteredBy;
	private LocalDate enteredOn;
	private LocalDate pwdChangedDate;
	
	
	
	public LocalDate getPwdChangedDate() {
		return pwdChangedDate;
	}
	public void setPwdChangedDate(LocalDate pwdChangedDate) {
		this.pwdChangedDate = pwdChangedDate;
	}
	public String getEnteredBy() {
		return enteredBy;
	}
	public void setEnteredBy(String enteredBy) {
		this.enteredBy = enteredBy;
	}
	public LocalDate getEnteredOn() {
		return enteredOn;
	}
	public void setEnteredOn(LocalDate enteredOn) {
		this.enteredOn = enteredOn;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Users() {
		//super();
		// TODO Auto-generated constructor stub
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public District getDistrict() {
		return district;
	}
	public void setDistrict(District district) {
		this.district = district;
	}
	
}
