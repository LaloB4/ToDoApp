package com.eduardobarrera.todoapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	public String homePage() {
		LOG.info("METHOD: homePage(); REDIRECTING TO VIEW: " + ViewConstant.INDEX_VIEW);
		return ViewConstant.INDEX_VIEW;
	}
	
	@GetMapping("/mytasks")
	public ModelAndView myTaskPage() {
		LOG.info("METHOD: homePage(); REDIRECTING TO VIEW: " + ViewConstant.MYTASK_VIEW);
		ModelAndView mav = new ModelAndView(ViewConstant.MYTASK_VIEW); 
		mav.addObject("tasksList", taskService.listAllTasks());
		return mav;
	}
	
	@GetMapping("/createtask")
	public ModelAndView createTask(@RequestParam(name="taskId", required = false, defaultValue = "null") String taskId) {
		
		ModelAndView mav = new ModelAndView(ViewConstant.CREATETASK_VIEW);
		
		if(taskId.equals("null")) {
			mav.addObject("taskModel", new TaskModel());
		}else {
			TaskModel tModel = new TaskModel();
			tModel = taskService.findTaskModelById(Integer.parseInt(taskId));
			mav.addObject("taskModel", tModel);
		}
		
		return mav;
	}
	
	@GetMapping("/search")
	public String searchTask(Model model) {
		model.addAttribute("taskModelForSearch", new TaskModel());
		return ViewConstant.SEARCHTASK_VIEW;
	}
	
	@GetMapping("/about")
	public String aboutToDoApp() {
		return ViewConstant.ABOUTTASK_VIEW;
	}
	
	@GetMapping("/searchresults")
	public String showSerchTaskResults() {
		return ViewConstant.SEARCHRESULTS_VIEW;
	}
	
	@PostMapping("/newtask")
	public String createNewTask(@ModelAttribute(name = "taskModel") TaskModel taskModel) {
		
		LOG.info("METHOD: createNewTask(); PARAMS: " + taskModel.toString());
		taskService.createOrEditTask(taskModel);
		return "redirect:/todoapp/mytasks";
			
	}
	
	@GetMapping("/deletetask")
	public String deleteTask(@RequestParam(name = "taskId", required = true) int taskId) {
		LOG.info("METHOD: deleteTask(); The task id is: " +  taskId);
		taskService.deleteTaskById(taskId);
		return "redirect:/todoapp/mytasks";
	}
	
	@PostMapping("/searchTask")
	public String performSearchTask(Model model, 
			@ModelAttribute(name = "taskModelForSearch") TaskModel taskModel) {
		
		LOG.info("METHOD: performSearchTask(); PARAMS: " + taskModel.toString());
		
		HashMap<String, String> searchFilters = new HashMap<String, String>();
		
		if(!(taskModel.getTaskName().equals(" ") || taskModel.getTaskName().equals(""))) {
			searchFilters.put("taskName", taskModel.getTaskName());
		}
		if(!(taskModel.getCreationDate().equals(" ") || taskModel.getCreationDate().equals(""))) {
			searchFilters.put("creationDate", taskModel.getCreationDate());
		}
		if(!(taskModel.getStatus().equals(" ") || taskModel.getStatus().equals(""))) {
			searchFilters.put("status", taskModel.getStatus());
		}
		if(!(taskModel.getCategory().equals(" ") || taskModel.getCategory().equals(""))) {
			searchFilters.put("category", taskModel.getCategory());
		}
		
		LOG.info("These are the filters: " + searchFilters);
		
		if(searchFilters.size() != 4) {
			return "redirect:/todoapp/search?criteria=false";
		}else {
			List<TaskModel> taskList = new ArrayList<TaskModel>();
			taskList = taskService.searchByUserCriteria(searchFilters.get("taskName"), searchFilters.get("creationDate"), searchFilters.get("status"), searchFilters.get("category"));
			LOG.info("The results: " + taskList);
			model.addAttribute("taskListSResults", taskList);
			//return "redirect:/todoapp/searchresults";
			return ViewConstant.SEARCHRESULTS_VIEW;
		}
	}	
}
