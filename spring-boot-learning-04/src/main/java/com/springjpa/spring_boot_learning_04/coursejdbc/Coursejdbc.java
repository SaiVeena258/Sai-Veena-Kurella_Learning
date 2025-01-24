package com.springjpa.spring_boot_learning_04.coursejdbc;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Coursejdbc {
	
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	public static String INSERT_QUERY=
			"""
				insert into Student(id,stuname,branch)
	            values(?,?,?);
			""";
	
	public static String DELETE_QUERY=
			"""
				delete from Student 
				where id=?
			""";
	
	public static String SELECT_QUERY=
			"""
				select * from Student 
				where id=?
			""";
	
	public void insert(Coursejdbcfile course) {
		springJdbcTemplate.update(INSERT_QUERY,
				course.getId(),course.getStuname(),course.getBranch());
	}
	
	public void deleteById(long id) {
		springJdbcTemplate.update(DELETE_QUERY,id);
	}
	
	public Coursejdbcfile findById(long id) {
		return springJdbcTemplate.queryForObject(SELECT_QUERY,
				new BeanPropertyRowMapper<>(Coursejdbcfile.class),id);
	}
}
