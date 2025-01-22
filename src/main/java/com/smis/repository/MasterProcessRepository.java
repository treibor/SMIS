package com.smis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smis.entity.Scheme;
import com.smis.entity.MasterProcess;


public interface MasterProcessRepository extends JpaRepository<MasterProcess, Long>{
	List<MasterProcess> findByScheme(Scheme scheme);
	MasterProcess findFirstBySchemeOrderByStepOrder(Scheme scheme);
	
	@Query("SELECT COALESCE(MAX(s.stepOrder), 0) FROM SchemeProcess s WHERE s.scheme = :scheme")
	int findMaxStepOrderByScheme(@Param("scheme") Scheme scheme);
}
