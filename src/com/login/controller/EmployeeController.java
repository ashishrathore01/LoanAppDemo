/**
 * 
 */
package com.login.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.loan.helper.LoanHelper;
import com.login.dto.Branch;
import com.login.dto.Employee;
import com.login.dto.Organization;
import com.login.service.impl.EmployeeServiceImpl;

/**
 * @author rathoras
 *
 */
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;
	@Autowired
	private LoanHelper loanHelper;

	@RequestMapping(value = "/employeeRegistration")
	public ModelAndView userRegistration(HttpServletRequest request) {
		Employee employee = new Employee();
		ModelAndView modelAndView = new ModelAndView();
		employee.setEmployeeid(loanHelper.generateRandom("1202"));
		employee.setEmployeename(request.getParameter("employeename"));
		employee.setAllowoverrideofsessionvalues(Integer.parseInt(request.getParameter("allowoverridesessionvalue")));		
		employee.setBranchid(request.getParameter("branchid"));
		employee.setCanlogin(Integer.parseInt(request.getParameter("canclelogin")));
		employee.setCdotypeid(Integer.parseInt(request.getParameter("cdotypeid")));
		employee.setChangecount(Integer.parseInt(request.getParameter("changecount")));
		employee.setChangestatusid(request.getParameter("changestatusid"));
		employee.setDescription(request.getParameter("description"));
		employee.setFullname(request.getParameter("fullname"));
		employee.setIconid(Integer.parseInt(request.getParameter("iconid")));
		employee.setMenudefinitionid(request.getParameter("menudefid"));
		employee.setSessionvaluesid(request.getParameter("sessionvaluesid"));
		employee.setUsercomment(request.getParameter("usercomment"));
		employee.setLanguagedictionaryid(request.getParameter("languagedicid"));
		employee.setTerminologydictionaryid(request.getParameter("terminologydicid"));
		employee.setHistoryviewid(request.getParameter("historyviewid"));
		employee.setNotes(request.getParameter("notes"));		
		employee.setEsigrolegroupid(request.getParameter("esigrolegroupid"));
		employee.setTrainingplanid(request.getParameter("trainingplanid"));
		employee.setEmailaddress(request.getParameter("email"));
		employee.setUiportalprofileid(request.getParameter("portalprofileid"));
		employee.setPrimaryorganizationid(request.getParameter("primaryorgid"));		
		employee.setPortalmenudefinitionid(request.getParameter("portalmenudefid"));
		employee.setMdallowmultiplesignin(Integer.parseInt(request.getParameter("mdallowmultiplesignin")));
		employee.setPassword(loanHelper.getEncryptedPassword(request.getParameter("password")));
		
		if (employeeService.addNewEmployee(employee)) {
			modelAndView = new ModelAndView("userRegistration");
		} else {
			modelAndView = new ModelAndView("userRegistration");
		}
		return modelAndView;
	}	
	
	@RequestMapping(value = "/getAjax")
	public String getRequest(@RequestBody Branch branch) {
		String result = "";
		System.out.println("Branch Name " + branch.getBranchname());
		System.out.println("Branch Address " + branch.getBranchaddress());
		System.out.println("Branch Phone " + branch.getBranchphone());		
		return result;
	}
	
	@RequestMapping(value = "/getEmployeeDetails",method = RequestMethod.POST)
	public @ResponseBody String getEmployeeDetails(@RequestParam("employeeID") String employeeID) {
		System.out.println("Inside Get Employee ID" + employeeID);
		Employee employee = new Employee();
		employee = employeeService.getEmployeeDetails(employeeID);
		System.out.println("Employee Value in Controller 1st " + employee);
		System.out.println("Employee Value in Controller 2nd " + employee.toString());
		Gson gson = new Gson();
		String json = gson.toJson(employee);
		return json;
	}
	
	@RequestMapping(value = "/deleteEmployee",method = RequestMethod.POST)
	public @ResponseBody int deleteEmployee(@RequestParam("employeeID") String employeeID) {
		System.out.println("Inside Get Employee ID" + employeeID);		
		int result = employeeService.deleteEmployee(employeeID);		
		//Gson gson = new Gson();
		//int json = gson.toJson(result);
		//return json;
		return result;
	}
	
	@RequestMapping(value = "/getAllEmployeeId",method = RequestMethod.POST,consumes="application/json")
	public @ResponseBody void getAllEmployeeId(HttpServletRequest request,  HttpServletResponse response) throws Exception {
		System.out.println("Inside Get Branch ID");
		/*List<String> branchIDs = new ArrayList<String>();
		branchIDs = organizationService.getAllOrganizationId();
		Gson gson = new Gson();
		String json = gson.toJson(branchIDs);
		return json;
*/			
		Gson gson = new Gson();
		//String jso	n = gson.toJson(branchIDs);
		//System.out.println("In Controller json is " + json);
		//return json;
		JsonElement element = gson.toJsonTree(employeeService.getAllEmployeeDetails(), new TypeToken<List<Employee>>() {}.getType());
		System.out.println("Employee iD is " + employeeService.getAllEmployeeDetails());
		JsonArray jsonArray = element.getAsJsonArray();
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
	}
}