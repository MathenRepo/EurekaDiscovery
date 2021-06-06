package com.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.entiry.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	
	public List<User> findAllByDepartmentID(long departmentID); //Finds All Users of a department.

}
