package com.eduardobarrera.todoapp.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
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
	
	
}
