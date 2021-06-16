package com.spring.security.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.security.dto.SignUpDTO;

@Repository
public class SignUpDaoImpl implements SignUpDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void saveUsers(SignUpDTO signUpDTO) {

		String saveusers = "INSERT INTO users VALUES (?,?,?)";

		jdbcTemplate.update(saveusers, signUpDTO.getUsername(), signUpDTO.getPassword(), true);

		String saveAuth = "INSERT INTO authorities VALUES (?,?)";

		jdbcTemplate.update(saveAuth, signUpDTO.getUsername(), "User");
	}
}
