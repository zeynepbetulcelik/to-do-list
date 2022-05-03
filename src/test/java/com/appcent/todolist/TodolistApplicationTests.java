package com.appcent.todolist;

import com.appcent.todolist.auth.TokenManager;
import com.appcent.todolist.entities.ToDoList;
import com.appcent.todolist.entities.User;
import com.appcent.todolist.model.JwtResponseModel;
import com.appcent.todolist.model.ListResponseModel;
import com.appcent.todolist.model.UserInfoDTO;
import com.appcent.todolist.repositories.ToDoListRepository;
import com.appcent.todolist.repositories.UserRepository;
import com.appcent.todolist.services.ListService;
import com.appcent.todolist.services.UserService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TodolistApplicationTests {
	@Autowired
	UserRepository userRepository;
	@Autowired
	ToDoListRepository toDoListRepository;

	@Autowired
	ListService listService;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	UserService userService;


	@Test
	@Order(1)
	public void testSignUp(){
		UserInfoDTO mockUser=new UserInfoDTO();
		UUID id=UUID.randomUUID();
		mockUser.setId(id);
		mockUser.setUsername("zeynep@gmail.com");
		mockUser.setName("betul");
		mockUser.setSurname("celik");
		mockUser.setPassword(encodePassword("123"));
		assertNotNull(userService.registerUser(mockUser));
	}


	@Test
	@Order(2)
	public void testLogin() throws Exception {
		UserInfoDTO mockUser=new UserInfoDTO();
		UUID id=UUID.randomUUID();
		mockUser.setId(id);
		mockUser.setUsername("zeynep@gmail.com");
		mockUser.setPassword("123");
		assertNotNull(userService.login(mockUser));
	}

	@Test
	@Order(3)
	public void createTodoList(){
		ToDoList toDoList=new ToDoList();
		toDoList.setId(UUID.randomUUID());
		toDoList.setName("network-homework");
		toDoList.setCategory("course");
		toDoList.setComplete(false);
		assertNotNull(toDoListRepository.save(toDoList));

	}

	@Test
	@Order(4)
	public void updateTodoListById(){
		List<ToDoList>toDoLists=toDoListRepository.findAll();
		ListResponseModel listResponseModel=new ListResponseModel();
		listResponseModel.setId(toDoLists.get(0).getId());
		listResponseModel.setComplete(toDoLists.get(0).isComplete());
		listResponseModel.setName(toDoLists.get(0).getName());
		listResponseModel.setCategory(toDoLists.get(0).getCategory());
		assertNotNull(listService.updateToDoList(toDoLists.get(0).getId()));
	}

	@Test
	@Order(5)
	public void deleteTodoListById(){
		List<ToDoList>toDoLists=toDoListRepository.findAll();
		assertThat(listService.deleteToDoListById(toDoLists.get(0).getId())).isEqualTo(true);
	}

	private String encodePassword(String password) {return passwordEncoder.encode(password);}

}
