package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.VO.DepartmentVO;
import com.user.VO.RestTemplateResponseVO;
import com.user.VO.UserList;
import com.user.entiry.User;
import com.user.repository.UserRepo;

@RestController
@RequestMapping("/users/")
public class UserController {
	
	@Autowired
	private UserRepo repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/")
	public User saveDepartment(@RequestBody User user)
	{
		System.out.println("Controller Save User...");
		return repo.save(user);
	}
	
	@RequestMapping("/showusers")
	public List<User> getAllUsers()
	{
		System.out.println("Into User Controller : getAllUsers...");
		return repo.findAll();
	}

	@RequestMapping("/{id}")
	public User findUserByID(@PathVariable("id") Long id)
	{
		System.out.println("Controller findUserByID...");
		User  user =  repo.findById(id).orElse(new User(0L,"PlaceHolder","PlaceHolder",0));
		return user;
	}
	
	@RequestMapping("/getuserdepartment/{id}")
	public RestTemplateResponseVO getUserDepartmentDetails(@PathVariable("id") Long id)
	{
		System.out.println("Controller getUserDepartmentDetails...");
		RestTemplateResponseVO responseVO = new RestTemplateResponseVO();
		User  user =  repo.findById(id).orElse(new User(0L,"PlaceHolder","PlaceHolder",0));
		DepartmentVO  dept = restTemplate.getForObject("http://DepartmentAPI/departments/finddepartment/" + user.getDepartmentID(), DepartmentVO.class);
		responseVO.setUser(user);
		responseVO.setDepartment(dept);
		return responseVO;
	}
	
	@RequestMapping("/departmentusers/{departmentId}")
	public UserList getDepartmentusers(@PathVariable("departmentId") Long departmentId)
	{
		System.out.println("Controller getDepartmentusers...");
		List<User>  ul =  repo.findAllByDepartmentID(departmentId);
		UserList usersListContainer = new UserList();
		usersListContainer.setUserList(ul);
		return usersListContainer;
	}
	
}
