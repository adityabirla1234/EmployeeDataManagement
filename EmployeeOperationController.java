package com.ad.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.ad.model.Student;
import com.ad.service.StudentMgmtServiceImpl;

@Controller
public class EmployeeOperationController {
	@Autowired
	private StudentMgmtServiceImpl service;
@GetMapping("/")
public String showHome() {
	//return lvn
	return"home";
}
@GetMapping("/report")
public String showStudentReport(Map<String,Object> map) {
	//collecting result from jpa repository by calling service method 
	List<Student> list=service.getAllStudents();
	//put result collected from db table to shared memory
	map.put("stdList",list);
	//return lvn
	return"show_student_report";
}
@GetMapping("/std_add")//to launch form page
	public String saveEmployee(@ModelAttribute("std")Student std) {
			//return lvn
	return"register_student";
	}
/*@PostMapping("/emp_add")//for actually form submission to add employee
public String submitEmployee(Map<String,Object> map,@ModelAttribute("emp")Employee emp) {
	String result=service.registerEmployee(emp);
	//put result in shared memory
	map.put("saveResultMsg", result);
	//return lvn
	return"regsiter_employee_result";
}*/
/*@PostMapping("/emp_add")//for actually form submission to add employee
public String submitEmployee(Map<String,Object> map,@ModelAttribute("emp")Employee emp) {
	String result=service.registerEmployee(emp);
	//put result in shared memory
	map.put("saveResultMsg", result);
	//return lvn
	return"redirect:report";
}*/
@PostMapping("/std_add")//for actually form submission to add employee
public String submitEmployee(RedirectAttributes attrs,@ModelAttribute("std")Student std) {
	String result=service.registerStudent(std);
	//put result in flash attribute
	attrs.addFlashAttribute("saveResultMsg", result);
	//return lvn
	return"redirect:report";
}
@GetMapping("/std_edit")
public String launchEditForm(@ModelAttribute("std") Student std,@RequestParam int no) {
	//use service
	Student std1=service.getStudentByNo(no);
	//copying data from emp to emp1 object
	BeanUtils.copyProperties(std1, std);
	//return lvn
	return"update_student";
}
@PostMapping("/std_edit")
public String editEmployeeDetails(@ModelAttribute("std") Student std,RedirectAttributes attrs) {
	//use service
	String msg=service.updateStudent(std);
	//put the result msg intoflashAttribute
	attrs.addFlashAttribute("saveResultMsg",msg);
	//return lvn
	return"redirect:report";
}
/*@GetMapping("emp_delete")
public String deleteEmployeeDetails(RedirectAttributes attrs,@RequestParam int no) {
	//use service
	String msg=service.deleteEmployee(no);
	//put the result msg intoflashAttribute
		attrs.addFlashAttribute("saveResultMsg",msg);
		//return lvn
		return"redirect:report";
}*/
}

