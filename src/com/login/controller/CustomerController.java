/**
 * 
 */
package com.login.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.ui.Model;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.loan.helper.LoanHelper;
import com.login.dto.Customer;
import com.login.service.impl.CustomerServiceImpl;

/**
 * @author rathoras
 *
 */
@Controller
//@RequestMapping(value = "/user")
public class CustomerController {
	@Autowired
	private CustomerServiceImpl customerService;		
	@Autowired
	private LoanHelper loanHelper;

	@RequestMapping(value = "/customer-registration")
	public ModelAndView customerRegistration(HttpServletRequest request, @ModelAttribute Customer customer) {
		ModelAndView modelAndView = new ModelAndView();		
		customer.setCustomerId(loanHelper.generateRandom("1205"));
		System.out.println("Inside Customer Register");
		if (customerService.addNewCustomer(customer)) {
			System.out.println("Inside If Condition");
			modelAndView = new ModelAndView("userRegistration");			
		} else {
			System.out.println("Inside Else Condition");
			modelAndView = new ModelAndView("userRegistration");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/home")
	public ModelAndView homeRedirect() {
		ModelAndView modelAndView = new ModelAndView("login");		
		return modelAndView;
	}

	@RequestMapping(value = "/getAllCustomerList",method = RequestMethod.POST,consumes="application/json")
	public @ResponseBody void getAllCustomerList(HttpServletRequest request,  HttpServletResponse response) throws Exception {
		System.out.println("Inside Get Customer ID");
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
		JsonElement element = gson.toJsonTree(customerService.getAllCustomerList(), new TypeToken<List<Customer>>() {}.getType());
		JsonArray jsonArray = element.getAsJsonArray();
		System.out.println("Element is " + element);
		System.out.println("JSON Array is " + jsonArray);
		response.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();

	    try {  

	        // Writing to a file   
	    	System.out.println("JSON Array " + jsonArray);
	    	System.out.println("JSON Array String" + jsonArray.toString());
	        mapper.writeValue(new File("c:\\country.json"), jsonArray);

	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  
		response.getWriter().print(jsonArray);
	}	
	
	@RequestMapping(value = "/getCustomerDetails",method = RequestMethod.POST)
	public @ResponseBody String getCustomerDetails(@RequestParam("customerID") String customerID) {
		System.out.println("Inside Get Customer ID" + customerID);
		Customer customer = new Customer();
		customer = customerService.getCustomerDetails(customerID);
		System.out.println("Customer Value in Controller 1st " + customer);
		System.out.println("Customer Value in Controller 2nd " + customer.toString());		
		Gson gson = new Gson();
		String json = gson.toJson(customer);
		return json;
	}
	
	/*@RequestMapping(value = "/logout")
	public ModelAndView userLogout(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("login");	
		SessionValues sessionValue = new SessionValues();
		try {
			System.out.println("Before Logout" + request.getSession().getAttribute("username"));						
			Calendar loginDate = Calendar.getInstance();
			String empId = (String)request.getSession().getAttribute("username");
			System.out.println("Emp ID " + empId);
			sessionValue.setEmployeeid(empId);			
			sessionValue.setLogoutTime(new java.sql.Date(loginDate.getTimeInMillis()));
			sessionValuesService.updateSessionValue(sessionValue);
			request.getSession().invalidate();
			System.out.println("After Logout" + request.getSession().getAttribute("username"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return modelAndView;
	}

	@RequestMapping(value = "/login")
	@Scope("session")
	public ModelAndView userLogin(HttpServletRequest request, @ModelAttribute User user) {
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession(true);

		if (user.getUsername()!=null && user.getPassword()!=null
				&& user.getRole()!=null) {
			
			System.out.println("Inside If Condition");
//			HttpSession session = request.getSession(true);
			session.setAttribute("username", user.getUsername());
			session.setAttribute("password", user.getPassword());
			session.setAttribute("role", user.getRole());			
			
//			if (loginService.userAuthentication(user.getUsername(), loanHelper.getEncryptedPassword(user.getPassword()), "operator")) {
				if (loginService.userAuthentication(user.getUsername(), user.getPassword(), "operator")) {
//					&& user.getRole().equals(LoanConstant.OPERATOR)) {				
				Calendar loginDate = Calendar.getInstance();
				SessionValues sessionValue = new SessionValues();
				session.setAttribute("sessionValueId",session.getId());
				sessionValue.setEmployeeid(user.getUsername());
				sessionValue.setLoginTime(loginDate.getTime());
				sessionValuesService.addSessionValue(sessionValue);
				modelAndView = new ModelAndView("userHome");
			} else if (loginService.userAuthentication(user.getUsername(), user.getPassword(), "operator")
					&& user.getRole().equals(LoanConstant.MANAGER)) {
				modelAndView = new ModelAndView("userHome");
			} else if (loginService.userAuthentication(user.getUsername(), user.getPassword(), "operator")
					&& user.getRole().equals(LoanConstant.ADMIN)) {
				modelAndView = new ModelAndView("userHome");
			}						
		} else {
			if (loginService.userAuthentication(session.getAttribute("userName").toString(), loanHelper.getEncryptedPassword(session.getAttribute("userPassword").toString()), "operator")) {
//					&& session.getAttribute("userRole").equals(LoanConstant.OPERATOR)) {
				modelAndView = new ModelAndView("userHome");
			} else if (loginService.userAuthentication(user.getUsername(), user.getPassword(), "operator")
					&& user.getRole().equals(LoanConstant.MANAGER)) {
				modelAndView = new ModelAndView("userHome");
			} else if (loginService.userAuthentication(user.getUsername(), user.getPassword(), "operator")
					&& user.getRole().equals(LoanConstant.ADMIN)) {
				modelAndView = new ModelAndView("userHome");
			}
		}
		return modelAndView;
	}*/
	
	@RequestMapping(value="/list")
	public String list(Model model, Integer offset, Integer maxResults){
		model.addAttribute("persons", customerService.list(offset, maxResults));
		model.addAttribute("count", customerService.count());
		model.addAttribute("offset", offset);
		return "/customer_list";
	}
}
