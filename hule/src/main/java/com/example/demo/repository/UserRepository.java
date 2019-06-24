package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Users;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<Users, String>{
	Users findByEmailIgnoreCase(String email);
}
