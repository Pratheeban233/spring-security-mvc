package com.spring.security.dao;

import com.spring.security.dto.SignUpDTO;

public interface SignUpDao {

	void saveUsers(SignUpDTO signUpDTO);

}
