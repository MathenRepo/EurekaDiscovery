package com.department.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.department.VO.RestTemplateResponseVO;
import com.department.VO.UserList;
import com.department.VO.UserVO;
import com.department.entity.Department;
import com.department.repository.DepartmentRepo;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/departments/")
@Slf4j
public class DepartmentController {

	@Autowired
	private DepartmentRepo repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	private String usersAPIURL = "http://UserAPI/users/departmentusers/";
	
	@RequestMapping("/")
	public Department saveDepartment(@RequestBody Department dept)
	{
		System.out.println("Controller Save Department...");
		return repo.save(dept);
	}
	
	@RequestMapping("/showdepartments")
	public List<Department> findAllDepartments()
	{
		System.out.println("Controller Save Department...");
		return repo.findAll();
	}
	
	@RequestMapping("/finddepartment/{id}")
	public Department findDepartmentByID(@PathVariable("id") Long id)
	{
		System.out.println("Controller findDepartmentByID ...");
		Department  dept =  repo.findById(id).orElse(new Department(0L,"PlaceHolder","PlaceHolder","PlaceHolder"));
		return dept;
	}
	
	@RequestMapping("/alldepartmentsallusers")
	public List<RestTemplateResponseVO> getAllDepartmentsAllUsers()
	{
		System.out.println("Controller getAllDepartmentsAllUsers ...");
		List<RestTemplateResponseVO> responseMasterList = new ArrayList<RestTemplateResponseVO>();
		List<Department> deptList =  repo.findAll();
		for(Department d : deptList)
		{
			Mono<UserList> userMonoContainer = webClientBuilder
												.build()
												.get()
												.uri(usersAPIURL + d.getDepartmentID())
												.retrieve()
												.bodyToMono(UserList.class);
			
			UserList user = userMonoContainer.block();
			RestTemplateResponseVO r = new RestTemplateResponseVO(d,user.getUserList());
			responseMasterList.add(r);
		}
		return responseMasterList;
	}
	
	@RequestMapping("/{id}")
	public RestTemplateResponseVO findUserDepartmentByID(@PathVariable("id") Long id)
	{
		System.out.println("Controller findDepartmentByID ...");
		RestTemplateResponseVO response = new RestTemplateResponseVO();
		Department  dept =  repo.findById(id).orElse(new Department(0L,"PlaceHolder","PlaceHolder","PlaceHolder"));
		UserList user = restTemplate.getForObject(usersAPIURL + dept.getDepartmentID(), UserList.class);
		response.setDepartment(dept);
		response.setUser(user.getUserList());
		return response;
	}
}



