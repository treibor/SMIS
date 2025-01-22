package com.smis.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity

public class MasterProcess {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "process_generator")
    @SequenceGenerator(name = "process_generator", sequenceName = "process_sequence", allocationSize = 1)
    private long processId;

    @NotEmpty
    private String processName;
    @NotEmpty
    private String processLabel;
    private int stepOrder; // Defines the order of this step in the workflow.
    private boolean isMandatory;
	public long getProcessId() {
		return processId;
	}
	public void setProcessId(long processId) {
		this.processId = processId;
	}
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public int getStepOrder() {
		return stepOrder;
	}
	public void setStepOrder(int stepOrder) {
		this.stepOrder = stepOrder;
	}
	public boolean isMandatory() {
		return isMandatory;
	}
	public void setMandatory(boolean isMandatory) {
		this.isMandatory = isMandatory;
	}
	public String getProcessLabel() {
		return processLabel;
	}
	public void setProcessLabel(String processLabel) {
		this.processLabel = processLabel;
	}



    
    
}