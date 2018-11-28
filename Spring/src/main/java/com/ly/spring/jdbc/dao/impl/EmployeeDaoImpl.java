package com.ly.spring.jdbc.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ly.spring.jdbc.beans.Employee;
import com.ly.spring.jdbc.dao.EmployeeDao;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Employee> getEmployees() {
		//写sql语句
		String sql = "select id,last_name lastName,email,salary,dept_id deptId from employees";

		//创建RowMapper对象
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);

		List<Employee> emploees = jdbcTemplate.query(sql, rowMapper);

		return emploees;
	}

}
