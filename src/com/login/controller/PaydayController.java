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
import com.login.dto.Employee;
import com.login.dto.Organization;
import com.login.dto.Payday;
import com.login.service.impl.PaydayServiceImpl;

/**
 * @author rathoras
 *
 */

@Controller
public class PaydayController {
	@Autowired
	private PaydayServiceImpl paydayService;
	@Autowired
	private LoanHelper loanHelper;

	@RequestMapping(value = "/paydayRegistration")
	public @ResponseBody int paydayRegistration(HttpServletRequest request) {
		Payday payday = new Payday();
		int result = 0;
		System.out.println("Value of Request is " + request);
		payday.setPayDayId(loanHelper.generateRandom("1203"));
		payday.setPayDayName(request.getParameter("paydayName"));
		payday.setMinAmount(Integer.parseInt(request.getParameter("minAmount")));
		payday.setMaxAmount(Integer.parseInt(request.getParameter("maxAmount")));
		payday.setInterestRate(Integer.parseInt(request.getParameter("interestRate")));
		payday.setMaxLoanDuration(Integer.parseInt(request.getParameter("maxLoanDuration")));
		payday.setCoolingOfPeriod(Integer.parseInt(request.getParameter("coolingOfPeriod")));
		payday.setDescription(request.getParameter("paydayDescription"));
		payday.setNotes(request.getParameter("paydayNotes"));
		/*employee.setEmployeename(request.getParameter("employeename"));
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
		employee.setPassword(loanHelper.getEncryptedPassword(request.getParameter("password")));*/
		
		/*if (paydayService.addNewPayday(payday)) {
			modelAndView = new ModelAndView("userRegistration");
		} else {
			modelAndView = new ModelAndView("userRegistration");
		}*/
		return paydayService.addNewPayday(payday);
	}	
	
	@RequestMapping(value = "/getPaydayDetails",method = RequestMethod.POST)
	public @ResponseBody String getPaydayDetails(@RequestParam("paydayId") String paydayId) {
		System.out.println("Inside Get Employee ID" + paydayId);
		Payday payday = new Payday();
		payday = paydayService.getPaydayDetails(paydayId);
		System.out.println("Employee Value in Controller 1st " + payday);
		System.out.println("Employee Value in Controller 2nd " + payday.toString());
		Gson gson = new Gson();
		String json = gson.toJson(payday);
		return json;
	}
	
	@RequestMapping(value = "/deletePayday",method = RequestMethod.POST)
	public @ResponseBody int deletePayday(@RequestParam("paydayID") String paydayId) {
		System.out.println("Inside Get Employee ID" + paydayId);		
		int result = paydayService.deletePayday(paydayId);		
		//Gson gson = new Gson();
		//int json = gson.toJson(result);
		//return json;
		return result;
	}
	
	@RequestMapping(value = "/getAllPaydayId",method = RequestMethod.POST,consumes="application/json")
	public @ResponseBody void getAllPaydayId(HttpServletRequest request,  HttpServletResponse response) throws Exception {
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
		JsonElement element = gson.toJsonTree(paydayService.getAllPaydayDetails(), new TypeToken<List<Payday>>() {}.getType());
		System.out.println("Payday iD is " + paydayService.getAllPaydayDetails());
		JsonArray jsonArray = element.getAsJsonArray();
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
	}
	
	@RequestMapping(value = "/getPaydayId",method = RequestMethod.POST,consumes="application/json")
	public @ResponseBody void getPaydayId(HttpServletRequest request,  HttpServletResponse response) throws Exception {
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
		JsonElement element = gson.toJsonTree(paydayService.getAllPaydayId(), new TypeToken<List<Payday>>() {}.getType());
		JsonArray jsonArray = element.getAsJsonArray();
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
	}
}