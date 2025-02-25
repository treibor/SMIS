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
//@Table(name = "workflow_assignment")
public class ProcessFlow {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "processflow_generator")
	@SequenceGenerator(name = "processflow_generator", sequenceName = "processflow_sequence", allocationSize = 1)
	private long flowId;

	@ManyToOne
	@JoinColumn(name = "userId")
	private Users user;

	@ManyToOne
	@JoinColumn(name = "processId" ,referencedColumnName = "processId")
	private MasterProcess process;

	@ManyToOne
	@JoinColumn(name = "workId")
	private WorkNew work;

	private boolean isComplete;

	private LocalDateTime assignedDate;

	private LocalDateTime completedDate;

	public long getFlowId() {
		return flowId;
	}

	public void setFlowId(long flowId) {
		this.flowId = flowId;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	

	

	

	public MasterProcess getProcess() {
		return process;
	}

	public void setProcess(MasterProcess process) {
		this.process = process;
	}

	public WorkNew getWork() {
		return work;
	}

	public void setWork(WorkNew work) {
		this.work = work;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public LocalDateTime getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(LocalDateTime assignedDate) {
		this.assignedDate = assignedDate;
	}

	public LocalDateTime getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(LocalDateTime completedDate) {
		this.completedDate = completedDate;
	}
	
	
	
}