package com.smis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smis.entity.Scheme;
import com.smis.entity.MasterProcess;


public interface MasterProcessRepository extends JpaRepository<MasterProcess, Long>{
	
}
