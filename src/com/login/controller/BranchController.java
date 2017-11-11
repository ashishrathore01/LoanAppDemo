/**
 * 
 */
package com.login.controller;

import java.util.HashMap;
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
import com.login.dto.Employee;
import com.login.service.impl.BranchServiceImpl;

/**
 * @author rathoras
 *
 */
@Controller
public class BranchController {
	@Autowired
	private BranchServiceImpl branchService;
	@Autowired
	private LoanHelper loanHelper;		

	@RequestMapping(value = "/branchRegistration")
	public ModelAndView branchRegistration(HttpServletRequest request) {
		Branch branch = new Branch();
		ModelAndView modelAndView = new ModelAndView();			
		branch.setBranchid(loanHelper.generateRandom("1201"));
		branch.setBranchname(request.getParameter("branchname"));
		branch.setBranchaddress(request.getParameter("branchaddress"));
		branch.setBranchphone(Integer.parseInt(request.getParameter("branchphone")));
		branch.setBranchfax(Integer.parseInt(	request.getParameter("branchfax")));
		branch.setIconid(Integer.parseInt(request.getParameter("iconid")));
		branch.setIsfrozen(Integer.parseInt(request.getParameter("isfrozen")));
		branch.setMaxtimesincemsgsretrived(Float.parseFloat(request.getParameter("maxtimesincemsgsretrived")));
		branch.setMfgcalendarid(request.getParameter("mfgcalendarid"));
		branch.setNotes(request.getParameter("notes"));
		branch.setOrganizationid(request.getParameter("organizationid"));
		branch.setPrintqueueid(request.getParameter("printqueueid"));
		branch.setReportheading(request.getParameter("reportheading"));
		branch.setRequirelocation(Integer.parseInt(request.getParameter("requirelocation")));
		branch.setRetentiondays(Integer.parseInt(request.getParameter("retentiondays")));
		branch.setSmtptransportid(request.getParameter("smtptransportid"));			
		branch.setTrainingreqgroupid(request.getParameter("trainingreqgroupid"));
		branch.setWipmsgdefmgrid(request.getParameter("wipmsgdefmgrid"));
		branch.setCanreopenloan(Integer.parseInt(request.getParameter("canreopenloan")));
		branch.setCanreopencc(Integer.parseInt(request.getParameter("canreopencc")));
		branch.setCertexpirydays(Integer.parseInt(request.getParameter("certexpirydays")));
		branch.setCertnotokstatusid(request.getParameter("certnotokstatusid"));
		branch.setCertokstatusid(request.getParameter("certokstatusid"));
		branch.setConcatenationcharacter(request.getParameter("concatenationcharacter"));
		if (branchService.addNewBranch(branch)) {
			modelAndView = new ModelAndView("userRegistration");
		} else {
			modelAndView = new ModelAndView("userRegistration");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/getBranchDetails",method = RequestMethod.POST)
	public @ResponseBody String getBranchDetails(@RequestParam("branchID") String branchID) {
		System.out.println("Inside Get Branch ID" + branchID);
		Branch branch = new Branch();
		branch = branchService.getBranchDetails(branchID);
		System.out.println("Branch Value in Controller 1st " + branch);
		System.out.println("Branch Value in Controller 2nd " + branch.toString());
		Gson gson = new Gson();
		String json = gson.toJson(branch);
		return json;
	}
	
	@RequestMapping(value = "/getBranchId",method = RequestMethod.POST,consumes="application/json")
	public @ResponseBody void getBranchId(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//ObjectMapper mapper = new ObjectMapper();
		System.out.println("Inside Get Branch ID");
//		List<String,String> branchIDs = new HashMap<String,String>();
		//try {
	//	branchIDs = branchService.getAllBranchId();
			 //json = mapper.writeValueAsString(branchIDs);
		/*}
		catch(Exception ex) {
			ex.printStackTrace();
		}*/
		//return json;
		Gson gson = new Gson();
		//String json = gson.toJson(branchIDs);
		//System.out.println("In Controller json is " + json);
		//return json;
		JsonElement element = gson.toJsonTree(branchService.getAllBranchId(), new TypeToken<List<Branch>>() {}.getType());
		JsonArray jsonArray = element.getAsJsonArray();
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
		// return(new JSONArray(branchIDs.toArray()).toString());
	}
	
	@RequestMapping(value = "/deleteBranch",method = RequestMethod.POST)
	public @ResponseBody int deleteBranch(@RequestParam("branchID") String branchID) {
		System.out.println("Inside Get Employee ID" + branchID);		
		int result = branchService.deleteBranch(branchID);		
		//Gson gson = new Gson();
		//int json = gson.toJson(result);
		//return json;
		return result;
	}
}
