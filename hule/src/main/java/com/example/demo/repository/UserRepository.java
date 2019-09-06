package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Long>{
	Users findByEmailIgnoreCase(String email);
	
	Users findByUserName(String userName);
	
	@Query("Select u.userName from Users u Where u.tokenKey = :token")
	String findByToken(@Param("token") String token);
}
