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
import com.login.dto.Organization;
import com.login.service.impl.OrganizationServiceImpl;

/**
 * @author rathoras
 *
 */
@Controller
public class OrganizationController {

		@Autowired
		private OrganizationServiceImpl organizationService;
		@Autowired
		private LoanHelper loanHelper;		

		@RequestMapping(value = "/organizationRegistration")
		public ModelAndView organizationRegistration(HttpServletRequest request) {
			Organization organization = new Organization();
			ModelAndView modelAndView = new ModelAndView();			
			organization.setOrganizationid(loanHelper.generateRandom("1200"));
			organization.setOrganizationname(request.getParameter("organizationname"));
			organization.setOrganizationnumber(request.getParameter("organizationnumber"));
			organization.setParentorganizationid(request.getParameter("parentorganizationid"));
			organization.setPortalhomepageid(request.getParameter("portalhomepageid"));
			organization.setPrintqueueid(request.getParameter("printqueueid"));
			organization.setSmtptransportid(request.getParameter("smtptransportid"));
			organization.setUserrequiredforesig(Integer.parseInt(request.getParameter("userrequiredforesig")));
			organization.setCdotypeid(Integer.parseInt(request.getParameter("cdotypeid")));
			organization.setChangecount(Integer.parseInt(request.getParameter("changecount")));
			organization.setChangehistoryid(request.getParameter("changehistoryid"));
			organization.setCollectesigforallqualitytxns(Integer.parseInt(request.getParameter("collectesigforallqualitytxns")));
			organization.setDescription(request.getParameter("description"));
			organization.setIconid(Integer.parseInt(request.getParameter("iconid")));
			organization.setIsfrozen(Integer.parseInt(request.getParameter("isfrozen")));
			organization.setNotes(request.getParameter("notes"));			
			if (organizationService.addNewOrganization(organization)) {
				modelAndView = new ModelAndView("userRegistration");
			} else {
				modelAndView = new ModelAndView("userRegistration");
			}
			return modelAndView;
		}
		
		@RequestMapping(value = "/getOrganizationId",method = RequestMethod.POST,consumes="application/json")
		public @ResponseBody void getOrganizationId(HttpServletRequest request,  HttpServletResponse response) throws Exception {
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
			JsonElement element = gson.toJsonTree(organizationService.getAllOrganizationId(), new TypeToken<List<Organization>>() {}.getType());
			JsonArray jsonArray = element.getAsJsonArray();
			response.setContentType("application/json");
			response.getWriter().print(jsonArray);
		}
		
		@RequestMapping(value = "/deleteOrganization",method = RequestMethod.POST)
		public @ResponseBody int deleteOrganization(@RequestParam("organizationID") String organizationID) {
			System.out.println("Inside Get Employee ID" + organizationID);		
			int result = organizationService.deleteOrganization(organizationID);// deleteBranch(organizationID);		
			//Gson gson = new Gson();
			//int json = gson.toJson(result);
			//return json;
			return result;
		}
		
		@RequestMapping(value = "/getOrganizationDetails",method = RequestMethod.POST)
		public @ResponseBody String getOrganizationDetails(@RequestParam("organizationID") String organizationID) {
			System.out.println("Inside Get Branch ID" + organizationID);
			Organization organization = new Organization();
			organization = organizationService.getOrganizationDetails(organizationID);
			System.out.println("Organization Value in Controller 1st " + organization);
			System.out.println("Organization Value in Controller 2nd " + organization.toString());
			Gson gson = new Gson();
			String json = gson.toJson(organization);
			return json;
		}
}
