package com.portail.potsfield_club.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.portail.potsfield_club.model.Post;
import com.portail.potsfield_club.model.Suggestion;
import com.portail.potsfield_club.model.User;
import com.portail.potsfield_club.repository.UserRepository;
import com.portail.potsfield_club.service.PostService;
import com.portail.potsfield_club.service.SuggestionService;
import com.portail.potsfield_club.service.UserServiceImpl;


import org.springframework.ui.Model;


@Controller
public class MainController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private SuggestionService suggestionService;
	
	@Autowired
	UserServiceImpl service;
	

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	


	@GetMapping("/")
	public String homeP(Model model) {
		model.addAttribute("listPost", postService.getAllPosts());
		return "home";
	}
	
	@GetMapping("/index")
	public String home(Model model) {
		model.addAttribute("listPost", postService.getAllPosts());
		return "index";
	}


	@GetMapping("/usersTab")
	public String usersTab(Model model) {
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		return "usersTab";
	}
	

	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user) {
		// save employee to database
		service.saveUser(user);
		return "redirect:/usersTab";
	}
	


	@GetMapping("/editTab/{id}")
	public String fileUpdate(@PathVariable(value="id")long id, Model model) {
		User user= service.getUserById(id);
		model.addAttribute("user", user);
		return "editTab";
	}
	
	@GetMapping("/NewFileDelete/{id}")
	public String deleteUser(@PathVariable (value = "id") long id) {
		
		// call delete employee method 
		this.service.deleteUserById(id);
		return "redirect:/usersTab";
	}

	@GetMapping("/403")
	public String error() {
		
		return "403";
	}
	
	@GetMapping("/profile")
	public String profile() {
		
		return "profile";
	}
	
	@GetMapping("/postPage")
	public String viewPostPage(Model model) {
		model.addAttribute("listPost", postService.getAllPosts());
		return "postPage";
	}

	
	
	@GetMapping("/addNewPost")
	public String addNewPost(Model model) {
		Post post = new Post();
		model.addAttribute("post",post);
		return "addNewPost";
	}
	
	
	@PostMapping("/savePost")
	public String savePost(@ModelAttribute("post")Post post) {
		postService.savePost(post);
		return "redirect:/postPage";
	}
	
	@GetMapping("/showPostFprUpdate/{id}")
	public String showPostFprUpdate(@PathVariable(value = "id")long id,Model model) {
		
		Post post = postService.getPostById(id);
		
		model.addAttribute("post",post);
		return "showPostFprUpdate";
	}
	
	
	@GetMapping("/deletePost/{id}")
	public String deletePost(@PathVariable(value = "id")long id) {
		
		this.postService.deletePostById(id);
		return "redirect:/postPage";
	}
	

	
	@GetMapping("/savedPost")
	public String savedPost() {
		
		return "savedPost";
	}

	
	
@GetMapping("/suggestionPage")
	
	public String viewSuggestionPage(Model model) {
		model.addAttribute("listSuggestion", suggestionService.getAllSugg());
		return "suggestionPage";
	}
	


@GetMapping("/addNewSuggestion")
public String addNewSuggestion(Model model) {
	Suggestion suggestion = new Suggestion();
	model.addAttribute("suggestion",suggestion);
	return "addNewSuggestion";
}

@PostMapping("/saveSuggestion")
public String saveSuggestion(@ModelAttribute("suggestion")Suggestion suggestion) {
	suggestionService.saveSuggestion(suggestion);
	return "redirect:/index";
}

@GetMapping("/deleteSuggestion/{id}")
public String deleteSuggestion(@PathVariable(value = "id")long id) {
	
	this.suggestionService.deleteSuggestionById(id);
	return "redirect:/suggestionPage";
}
	
	@GetMapping("/aboutUs")
	public String aboutUs() {
		
		return "aboutUs";
	}
	
	@GetMapping("/settings")
	public String settings() {
		
		return "settings";
	}
	



	

}
