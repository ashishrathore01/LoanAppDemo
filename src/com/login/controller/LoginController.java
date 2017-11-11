/**
 * 
 */
package com.login.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.loan.helper.LoanHelper;
import com.login.constant.LoanConstant;
import com.login.dto.Customer;
import com.login.dto.SessionValues;
import com.login.dto.User;
import com.login.service.impl.CustomerServiceImpl;
import com.login.service.impl.LoginServiceImpl;
import com.login.service.impl.SessionValueServiceImpl;

/**
 * @author rathoras
 *
 */
@Controller
@RequestMapping(value = "/user")
public class LoginController {

	@Autowired
	private LoginServiceImpl loginService;
	@Autowired
	private SessionValueServiceImpl sessionValuesService;
	@Autowired
	private LoanHelper loanHelper;
	@Autowired
	private CustomerServiceImpl customerService;	

	@RequestMapping(value = "/registration")
	public ModelAndView userRegistration(@ModelAttribute("userForm") User user) {
		System.out.println("Inside User Registration");
		System.out.println("Password " + user.getPassword());
		ModelAndView modelAndView = new ModelAndView("userRegistration");
		return modelAndView;
	}

	@RequestMapping(value = "/home")
	public ModelAndView homeRedirect() {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}

	@RequestMapping(value = "/logout")
	public ModelAndView userLogout(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("login");
		SessionValues sessionValue = new SessionValues();
		try {
			System.out.println("Before Logout" + request.getSession().getAttribute("username"));
			Calendar loginDate = Calendar.getInstance();
			String empId = (String) request.getSession().getAttribute("username");
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
		if (user.getUsername() != null && user.getPassword() != null && user.getRole() != null) {
			System.out.println("Inside If Condition");
			session.setAttribute("username", user.getUsername());
			session.setAttribute("password", user.getPassword());
			session.setAttribute("role", user.getRole());
			if (loginService.userAuthentication(user.getUsername(), user.getPassword())) {
				Calendar loginDate = Calendar.getInstance();
				SessionValues sessionValue = new SessionValues();
				session.setAttribute("sessionValueId", session.getId());
				sessionValue.setEmployeeid(user.getUsername());
				sessionValue.setLoginTime(loginDate.getTime());
				sessionValuesService.addSessionValue(sessionValue);
				modelAndView = new ModelAndView("userHome");
			}
		}
		return modelAndView;
	}

	@RequestMapping(value = "/operator-login")
	@Scope("session")
	public ModelAndView customerLogin(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession(true);
		if (request.getParameter("operatorname") != null && request.getParameter("password") != null) {
			System.out.println("Inside If Condition");
			if (loginService.userAuthentication(request.getParameter("operatorname"),
					request.getParameter("password"))) {
				Calendar loginDate = Calendar.getInstance();
				SessionValues sessionValue = new SessionValues();
				session.setAttribute("sessionValueId", session.getId());
				sessionValue.setEmployeeid(request.getParameter("operatorname"));
				sessionValue.setLoginTime(loginDate.getTime());
				sessionValuesService.addSessionValue(sessionValue);
				List<Customer> customerList = customerService.getAllCustomerList();					
				modelAndView = new ModelAndView("operator_home");
				modelAndView.addObject("customerList", customerList);
			}
		} 
		return modelAndView;
	}
}