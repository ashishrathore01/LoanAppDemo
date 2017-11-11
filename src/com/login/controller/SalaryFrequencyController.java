/**
 * 
 */
package com.login.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.loan.helper.LoanHelper;
import com.login.dto.Payday;
import com.login.dto.SalaryFrequency;
import com.login.service.impl.SalaryFrequencyServiceImpl;

/**
 * @author rathoras
 *
 */

@Controller
public class SalaryFrequencyController {
	@Autowired
	private SalaryFrequencyServiceImpl salaryFrequencyService;
	@Autowired
	private LoanHelper loanHelper;

	@RequestMapping(value = "/salaryFrequencyRegistration")
	public @ResponseBody int salaryFrequencyRegistration(HttpServletRequest request) {
		SalaryFrequency salaryFrequency = new SalaryFrequency();
		int result = 0;
		System.out.println("Value of Request is " + request);
		salaryFrequency.setSalaryFrequencyId(loanHelper.generateRandom("1204"));
		salaryFrequency.setSalaryFrequencyName(request.getParameter("salaryFrequencyName"));
		salaryFrequency.setNotes(request.getParameter("salaryFrequencyNotes"));
		salaryFrequency.setDescription(request.getParameter("salaryFrequencyDescription"));				
		return salaryFrequencyService.addNewSalaryFrequency(salaryFrequency);
	}	
	
	@RequestMapping(value = "/getSalaryFrequencyDetails",method = RequestMethod.POST)
	public @ResponseBody String getSalaryFrequencyDetails(@RequestParam("salaryFrequencyId") String salaryFrequencyId) {
		System.out.println("Inside Get Salary frequency ID" + salaryFrequencyId);
		SalaryFrequency salaryFrequency = new SalaryFrequency();
		salaryFrequency = salaryFrequencyService.getSalaryFrequencyDetails(salaryFrequencyId);
		System.out.println("Employee Value in Controller 1st " + salaryFrequency);
		System.out.println("Employee Value in Controller 2nd " + salaryFrequency.toString());
		Gson gson = new Gson();
		String json = gson.toJson(salaryFrequency);
		return json;
	}
	
	@RequestMapping(value = "/deleteSalaryFrequency",method = RequestMethod.POST)
	public @ResponseBody int deleteSalaryFrequencyFrequency(@RequestParam("salaryFrequencyId") String salaryFrequencyId) {
		System.out.println("Inside Get Employee ID" + salaryFrequencyId);		
		int result = salaryFrequencyService.deleteSalaryFrequency(salaryFrequencyId);		
		//Gson gson = new Gson();
		//int json = gson.toJson(result);
		//return json;
		return result;
	}
	
	@RequestMapping(value = "/getAllSalaryFrequencyId",method = RequestMethod.POST,consumes="application/json")
	public @ResponseBody void getAllSalaryFrequencyId(HttpServletRequest request,  HttpServletResponse response) throws Exception {
		System.out.println("Inside Get Payday ID");
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
		JsonElement element = gson.toJsonTree(salaryFrequencyService.getAllSalaryFrequencyDetails(), new TypeToken<List<SalaryFrequency>>() {}.getType());
		JsonArray jsonArray = element.getAsJsonArray();
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
	}
	
	@RequestMapping(value = "/getSalaryFrequencyId",method = RequestMethod.POST,consumes="application/json")
	public @ResponseBody void getSalaryFrequencyId(HttpServletRequest request,  HttpServletResponse response) throws Exception {
		System.out.println("Inside Get Salary Frequency ID");
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
		JsonElement element = gson.toJsonTree(salaryFrequencyService.getAllSalaryFrequencyId(), new TypeToken<List<SalaryFrequency>>() {}.getType());
		JsonArray jsonArray = element.getAsJsonArray();
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
	}
}
