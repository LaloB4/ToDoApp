package com.eduardobarrera.todoapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eduardobarrera.todoapp.constant.ViewConstant;
import com.eduardobarrera.todoapp.model.TaskModel;
import com.eduardobarrera.todoapp.service.TaskSevice;

@Controller
@RequestMapping("/todoapp")
public class ToDoAppController {
	
	private final Log LOG = LogFactory.getLog(ToDoAppController.class);
	
	@Autowired
	@Qualifier("taskServiceImpl")
	private TaskSevice taskService;

	@GetMapping("/home")
	public String homePage(Model model) {
		LOG.info("METHOD: homePage(); REDIRECTING TO VIEW: " + ViewConstant.INDEX_VIEW);
		org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("username", user.getUsername());
		return ViewConstant.INDEX_VIEW;
	}
	
	@GetMapping("/mytasks")
	public ModelAndView myTaskPage(@RequestParam(name="error", required = false, defaultValue = "null") String error,
								  @RequestParam(name="success", required = false, defaultValue = "null") String success,
								  @RequestParam(name="deleteError", required = false, defaultValue = "null") String deleteError) {
		
		LOG.info("METHOD: myTaskPage(); PARAMS: error=> " +  error + ", success => " + success + ", deleteError => " + deleteError);
		
		ModelAndView mav = new ModelAndView(ViewConstant.MYTASK_VIEW); 
		
		LOG.info("METHOD: myTaskPage(); REDIRECTING TO VIEW: " + ViewConstant.MYTASK_VIEW);
		
		mav.addObject("tasksList", taskService.listAllTasks());
		
		mav.addObject("error", error);
		mav.addObject("success", success);
		mav.addObject("deleteError", deleteError);
		
		return mav;
	}
	
	@GetMapping("/createtask")
	public ModelAndView createTask(@RequestParam(name="taskId", required = false, defaultValue = "null") String taskId) {
		
		LOG.info("METHOD: createTask(); PARAMS: TaskId => " + taskId );
		
		ModelAndView mav = new ModelAndView(ViewConstant.CREATETASK_VIEW);
		
		LOG.info("METHOD: createTask(); REDIRECTING TO VIEW: " + ViewConstant.CREATETASK_VIEW);
		
		if(taskId.equals("null")) {
			
			mav.addObject("taskModel", new TaskModel());
			
		}else {
			
			TaskModel tModel = new TaskModel();
			tModel = taskService.findTaskModelById(Integer.parseInt(taskId));
			mav.addObject("taskModel", tModel);
		}
		
		return mav;
	}
	
	@GetMapping("/viewtaskdetails")
	public ModelAndView viewTaskDetails(@RequestParam(name="taskId") String taskId) {
		
		LOG.info("METHOD: viewTaskDetails(); PARAMS : taskId => " + taskId);
		ModelAndView mav = new ModelAndView(ViewConstant.TASKDETAILS_VIEW);
		LOG.info("METHOD: viewTaskDetails(); REDIRECTING TO VIEW : " + ViewConstant.TASKDETAILS_VIEW);
		mav.addObject("details", taskService.findTaskModelById(Integer.parseInt(taskId)));
		return mav;
		
	}
	
	@GetMapping("/search")
	public String searchTask(Model model) {
		
		model.addAttribute("taskModelForSearch", new TaskModel());
		LOG.info("METHOD: searchTask(); REDIRECTING TO VIEW : " + ViewConstant.SEARCHTASK_VIEW);
		return ViewConstant.SEARCHTASK_VIEW;
		
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	@GetMapping("/about")
	public String aboutToDoApp() {
		
		LOG.info("METHOD: aboutToDoApp(); REDIRECTING TO VIEW : " + ViewConstant.ABOUTTASK_VIEW);
		return ViewConstant.ABOUTTASK_VIEW;
	}
	
	@GetMapping("/searchresults")
	public String showSerchTaskResults() {
		
		LOG.info("METHOD: showSerchTaskResults(); REDIRECTING TO VIEW : " + ViewConstant.SEARCHRESULTS_VIEW);
		return ViewConstant.SEARCHRESULTS_VIEW;
	}
	
	@PostMapping("/newtask")
	public String createNewTask(@ModelAttribute(name = "taskModel") TaskModel taskModel) {
		
		LOG.info("METHOD: createNewTask(); PARAMS: " + taskModel.toString());
		String url = "redirect:/todoapp/mytasks";
		TaskModel tModel = taskService.createOrEditTask(taskModel);
		
		if(tModel == null) {
			
			url += "?error=true";
			
		}else{
			
			url += "?success=true";	
		}
		
		LOG.info("METHOD: createNewTask(); REDIRECTING TO URL: " + url);
		return url;
	}
	
	@GetMapping("/deletetask")
	public String deleteTask(@RequestParam(name = "taskId", required = true) int taskId) {
		
		LOG.info("METHOD: deleteTask(); PARAMS: taskId => " +  taskId);
		String statusDeletion = "false";
		String url = "redirect:/todoapp/mytasks?deleteError=";
		int statusCode = taskService.deleteTaskById(taskId);
		
		if(statusCode == 0) {
			statusDeletion = "true";
		}
		
		url += statusDeletion;
		
		LOG.info("METHOD: createNewTask(); REDIRECTING TO URL: " + url);
		return url;
	}
	
	@PostMapping("/searchTask")
	public String performSearchTask(Model model, 
			@ModelAttribute(name = "taskModelForSearch") TaskModel taskModel) {
		
		LOG.info("METHOD: performSearchTask(); PARAMS: " + taskModel.toString());
		
		HashMap<String, String> searchFilters = new HashMap<String, String>();
		
		if(!(taskModel.getTaskName().equals(" ") && taskModel.getTaskName().equals(""))) {
			searchFilters.put("taskName", taskModel.getTaskName());
		}
		if(!(taskModel.getCreationDate().equals(" ") && taskModel.getCreationDate().equals(""))) {
			searchFilters.put("creationDate", taskModel.getCreationDate());
		}
		if(!(taskModel.getStatus().equals(" ") && taskModel.getStatus().equals(""))) {
			searchFilters.put("status", taskModel.getStatus());
		}
		if(!(taskModel.getCategory().equals(" ") && taskModel.getCategory().equals(""))) {
			searchFilters.put("category", taskModel.getCategory());
		}
		
		LOG.info("METHOD: performSearchTask(); FILTER PARAMS: " + searchFilters);
		
		if(searchFilters.size() != 4) {
			
			LOG.info("METHOD: performSearchTask(); REDIRECTING TO URL: /todoapp/search?criteria=false");
			return "redirect:/todoapp/search?criteria=false";
			
		}else {
			
			List<TaskModel> taskList = new ArrayList<TaskModel>();
			taskList = taskService.searchByUserCriteria(searchFilters.get("taskName"), searchFilters.get("creationDate"), searchFilters.get("status"), searchFilters.get("category"));
			model.addAttribute("taskListSResults", taskList);
			LOG.info("METHOD: performSearchTask(); REDIRECTING TO VIEW: " + ViewConstant.SEARCHRESULTS_VIEW);
			return ViewConstant.SEARCHRESULTS_VIEW;
			
		}
	}	
}
