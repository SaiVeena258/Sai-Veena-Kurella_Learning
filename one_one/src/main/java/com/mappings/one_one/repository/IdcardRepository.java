package com.mappings.one_one.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mappings.one_one.model.Idcard;

public interface IdcardRepository extends JpaRepository<Idcard, Long> {
	
}
