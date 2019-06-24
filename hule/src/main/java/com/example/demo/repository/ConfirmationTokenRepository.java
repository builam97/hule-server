package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.ConfirmToken;

@Repository
public interface ConfirmationTokenRepository extends CrudRepository<ConfirmToken, String>{
	ConfirmToken findByConfirmToken(String confirmToken);
}
