package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
//indexed Query
	@Query("select u from User u where u.userAddress=?1")
	List<User> findByAddress(String userAddress);

	//named Query
	@Query("select u from User u where u.userName=:userName")
	List<User> findByName(@Param("userName")String Name);
	
	@Transactional
	@Modifying
	@Query("update User u set  u.userAddress=?2 where u.userId =?1")
    public void updateAddress(Long id,String newAddress);
	

	
}