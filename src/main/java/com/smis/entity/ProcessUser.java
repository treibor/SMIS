package com.smis.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class ProcessUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "processuser_generator")
    @SequenceGenerator(name = "processuser_generator", sequenceName = "processuser_sequence", allocationSize = 1)
    private Long processuserid;

    @ManyToOne
    @JoinColumn(name = "processId", referencedColumnName = "processId")
	private MasterProcess process;
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private Users user; // Links to the user.

    // Optional fields for metadata:
    private LocalDateTime assignedDate; // Tracks when the user was assigned to the process.
    private String assignedBy; // Tracks who assigned the user.
	
	
	public Long getProcessuserid() {
		return processuserid;
	}
	public void setProcessuserid(Long processuserid) {
		this.processuserid = processuserid;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public LocalDateTime getAssignedDate() {
		return assignedDate;
	}
	public void setAssignedDate(LocalDateTime assignedDate) {
		this.assignedDate = assignedDate;
	}
	public String getAssignedBy() {
		return assignedBy;
	}
	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
	}
	public MasterProcess getProcess() {
		return process;
	}
	public void setProcess(MasterProcess process) {
		this.process = process;
	}
	
    
    
}