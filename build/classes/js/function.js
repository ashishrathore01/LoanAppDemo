/* All Function */

function addNewPayday() {
		$.ajax({
			type : "POST",
			dataType : 'json',
			url : "../paydayRegistration",
			cache : false,
			data : {
				paydayName: $("#paydayName").val(),
				minAmount: $("#minAmount").val(),
				maxAmount: $("#maxAmount").val(),
				interestRate: $("#interestRate").val(),
				maxLoanDuration: $("#maxLoanDuration").val(),
				coolingOfPeriod: $("#coolingOfPeriod").val(),
				paydayDescription: $("#paydayDescription").val(),
				paydayNotes: $("#paydayNotes").val()
			},
			success : function(response) {
				alert("Alert is " + response);
				if (response == "1") {
					alert("Payday Registration has completed successfully");
				} else {
					alert("Payday Registration has not completed");
				}
			},
			error : function() {
				alert("Error White Requesting.....");
			}
		});
	}
	
	function addNewSalaryFrequency() {
		alert("Inside Add Salary Frequency");
		$.ajax({
			type : "POST",
			dataType : 'json',
			url : "../salaryFrequencyRegistration",
			cache : false,
			data : {
				salaryFrequencyName: $("#salaryFrequencyName").val(),
				salaryFrequencyDescription: $("#salaryFrequencyDescription").val(),
				salaryFrequencyNotes: $("#salaryFrequencyNotes").val()				
			},
			success : function(response) {
				alert("Alert is " + response);
				if (response == "1") {
					alert("Salary Frequency Registration has completed successfully");
				} else {
					alert("Salary Frequency registration has not completed");
				}
			},
			error : function() {
				alert("Error White Requesting.....");
			}
		});
	}

	function showHome() {
		/* 	$("#employeeRegistration").show();		
			$("#employee-details").hide();		
			$("#branchSection").hide(); */
	}

	function showEmployee() {
		$("#employeeSection").show();
		$("#employee-details").hide();
		$("#branchSection").hide();
		$("#organizationSection").hide();
		$("#paydaySection").hide();
		$("#salaryFrequencySection").hide();
		setEmployeeID();
	}

	function showOrganization() {
		$("#employeeSection").hide();
		$("#branchSection").hide();
		$("#organizationSection").show();
		$("#organization-details").hide();
		$("#organization-registration-form").show();
		$("#paydaySection").hide();
		$("#salaryFrequencySection").hide();
		setOrganizationID();
	}

	function showBranch() {
		$("#employeeSection").hide();
		$("#branchSection").show();
		$("#branch-details").hide();
		$("#branch-registration-form").show();
		$("#organizationSection").hide();
		$("#paydaySection").hide();
		$("#salaryFrequencySection").hide();
		setBranchID();
	}

	function showPayday() {
		$("#employeeSection").hide();
		$("#branchSection").hide();
		$("#organizationSection").hide();
		$("#paydaySection").show();
		$("#payday-details").hide();
		$("#payday-registration-form").show();		
		$("#salaryFrequencySection").hide();
		setPaydayID();
	}

	function showSalaryFrequency() {
		$("#employeeSection").hide();
		$("#branchSection").hide();
		$("#organizationSection").hide();
		$("#paydaySection").hide();
		$("#salaryFrequencySection").show();
		$("#salaryFrequencyDetails").hide();
		$("#salaryFrequencyRegistrationForm").show();
		setSalaryFrequencyID();
	}

	function getAllBranchId() {
		alert("Hello");
		$.ajax({
			type : "POST",
			contentType : "application/json",
			dataType : 'json',
			url : "../getBranchId",
			cache : false,
			success : function(response) {
				/* var data=JSON.parse(response);
				alert("Data is " + data);
				alert("Branch Id is " +data.responseText.branchid);
				alert("Branch Name is " +data.responseText.branchname);
				//alert("Data Value" + re);
				for(var i=0;i<response.length;i++){	            	
					alert("Value of a " + response[i].branchid);
					alert("Value of a " + response[i].branchname);
				    var o = new Option(response[i], response[i]);
				  	$(o).html(response[i]);
				  	$("#branchid").append(o);
				} */
				branchRegistraionMenu();
				$("#branchid").empty();
				var branchSelect = new Option("Select", "select");
				$("#branchid").append(branchSelect);
				$.each(response, function(key, value) {

					/* alert("Branch Id is " + value['branchid']);
					alert("Branch Value is " + value['branchname']); */
					var o = new Option(value['branchname'], value['branchid']);
					//		          	$(o).html(response[i]);
					$("#branchid").append(o);
					$("#mySubUL").append(
							'<li><a href="#" onclick="getBranchDetails('
									+ value["branchid"] + ')">'
									+ value["branchname"] + '</a></li>');

				});

			},
			error : function(e) {
				alert("Not able to load the Branch Id");
			}
		});
	}

	function getAllSalaryFrequencyId() {
		alert("Inside Salary");
		$.ajax({
			type : "POST",
			contentType : "application/json",
			dataType : 'json',
			url : "../getSalaryFrequencyId",
			cache : false,
			success : function(response) {	
				alert("Response is " + response);
				salaryFrequencyRegistrationMenu();
				$.each(response, function(key, value) {					
					$("#mySubUL").append(
							'<li><a href="#" onclick="getSalaryFrequencyDetails('
									+ value["salaryFrequencyId"] + ')">'
									+ value["salaryFrequencyName"] + '</a></li>');
				});
				/* for(var i=0;i<response.length;i++){
				    var o = new Option(response[i], response[i]);
				  	$(o).html(response[i]);
				  	$("#organizationid").append(o);
				  	$("#mySubUL").append('<li><a href="#">'+value["branchname"]+'</a></li>');		          	
				} */
			},
			error : function() {
				alert("Error while request..");
			}
		});
	}
	
	function getAllPaydayId() {
		alert("Hell Inside Payday");		
		$.ajax({
			type : "POST",
			contentType : "application/json",
			dataType : 'json',
			url : "../getPaydayId",
			cache : false,
			success : function(response) {	
				alert("Response is " + response);
				payDayRegistrationMenu();
				$.each(response, function(key, value) {
					alert("Value is " + value["payDayId"] + value["payDayName"]);
					$("#mySubUL").append(
							'<li><a href="#" onclick="getPaydayDetails('
									+ value["payDayId"] + ')">'
									+ value["payDayName"] + '</a></li>');
				});
				/* for(var i=0;i<response.length;i++){
				    var o = new Option(response[i], response[i]);
				  	$(o).html(response[i]);
				  	$("#organizationid").append(o);
				  	$("#mySubUL").append('<li><a href="#">'+value["branchname"]+'</a></li>');		          	
				} */
			},
			error : function() {
				alert("Error while request..");
			}
		});
	}
	
	function getAllOrganizationId() {
		alert("Hello");
		$.ajax({
			type : "POST",
			contentType : "application/json",
			dataType : 'json',
			url : "../getOrganizationId",
			cache : false,
			success : function(response) {
				$("#organizationid").empty();
				var select = new Option("Select", "select");
				$("#organizationid").append(select);
				$.each(response, function(key, value) {

					/* alert("Branch Id is " + value['branchid']);
					alert("Branch Value is " + value['branchname']); */
					var o = new Option(value['organizationname'],
							value['organizationid']);
					//		          	$(o).html(response[i]);
					$("#organizationid").append(o);
					$("#mySubUL").append(
							'<li><a href="#" onclick="getOrganizationDetails('
									+ value["organizationid"] + ')">'
									+ value["organizationname"] + '</a></li>');
				});
				/* for(var i=0;i<response.length;i++){
				    var o = new Option(response[i], response[i]);
				  	$(o).html(response[i]);
				  	$("#organizationid").append(o);
				  	$("#mySubUL").append('<li><a href="#">'+value["branchname"]+'</a></li>');		          	
				} */
			},
			error : function() {
				alert("Error while request..");
			}
		});
	}

	function getAllEmployeeId() {
		alert("Hello");
		$.ajax({
			type : "POST",
			contentType : "application/json",
			dataType : 'json',
			url : "../getAllEmployeeId",
			cache : false,
			success : function(response) {
				$("#mySubUL").empty();
				$.each(response, function(key, value) {
					/* var o = new Option(value['organizationname'], value['organizationid']);
					//		          	$(o).html(response[i]);
					$("#organizationid").append(o); */
					$("#mySubUL").append(
							'<li><a href="#" onclick="getEmployeeDetails('
									+ value["employeeid"] + ')">'
									+ value["employeename"] + '</a></li>');
				});
			},
			error : function() {
				alert("Error while request..");
			}
		});
	}

	function getEmployeeDetails(id) {
		alert("ID is " + id);
	}

	function setEmployeeID() {
		$("#mySubUL").empty();
		getAllEmployeeId();
	}

	function setBranchID() {
		$("#mySubUL").empty();
		getAllBranchId();
	}

	function setOrganizationID() {
		$("#mySubUL").empty();
		getAllOrganizationId();
	}
	
	function setPaydayID() {
		$("#mySubUL").empty();
		getAllPaydayId();
	}
	
	function setSalaryFrequencyID() {
		$("#mySubUL").empty();
		getAllSalaryFrequencyId();
	}

	function deletePayday(id) {
		alert("Inside Organization Details " + id);
		$.ajax({
			type : "POST",
			dataType : 'json',
			url : "../deletePayday",
			cache : false,
			data : {
				paydayID : id
			},
			success : function(response) {
				alert("Alert is " + response);
				if (response == "1") {
					alert("Payday deleted successfully");
				} else {
					alert("Payday is not deleted successfully");
				}
			},
			error : function() {
				alert("Error White Requesting.....");
			}
		});
	}
	
	function deleteSalaryFrequency(id) {
		alert("Inside Organization Details " + id);
		$.ajax({
			type : "POST",
			dataType : 'json',
			url : "../deleteSalaryFrequency",
			cache : false,
			data : {
				salaryFrequencyId : id
			},
			success : function(response) {
				alert("Alert is " + response);
				if (response == "1") {
					alert("Salary Frequency deleted successfully");
				} else {
					alert("Salary Frequency is not deleted successfully");
				}
			},
			error : function() {
				alert("Error White Requesting.....");
			}
		});
	}
	
	function deleteOrganization(id) {
		alert("Inside Organization Details " + id);
		$.ajax({
			type : "POST",
			dataType : 'json',
			url : "../deleteOrganization",
			cache : false,
			data : {
				organizationID : id
			},
			success : function(response) {
				alert("Alert is " + response);
				if (response == "1") {
					alert("Organization deleted successfully");
				} else {
					alert("Organization not deleted successfully");
				}
			},
			error : function() {
				alert("Error White Requesting.....");
			}
		});
	}

	function deleteBranch(id) {
		alert("Inside Branch Details " + id);
		$.ajax({
			type : "POST",
			dataType : 'json',
			url : "../deleteBranch",
			cache : false,
			data : {
				branchID : id
			},
			success : function(response) {
				alert("Alert is " + response);
				if (response == "1") {
					alert("Branch deleted successfully");
				} else {
					alert("Branch not deleted successfully");
				}
			},
			error : function() {
				alert("Error White Requesting.....");
			}
		});
	}

	function deleteEmployee(id) {
		alert("Inside Employee Details " + id);
		$.ajax({
			type : "POST",
			dataType : 'json',
			url : "../deleteEmployee",
			cache : false,
			data : {
				employeeID : id
			},
			success : function(response) {
				if (response == "1") {
					alert("Employee deleted successfully");
				} else {
					alert("Employee not deleted successfully");
				}
			},
			error : function() {
				alert("Error while request..");
			}
		});
	}

	function updateEmployee(id) {
		alert("Hello");
	}

	function getSalaryFrequencyDetails(id) {
		$.ajax({
			type : "POST",
			dataType : 'json',
			url : "../getSalaryFrequencyDetails",
			cache : false,
			data : {
				salaryFrequencyId : id
			},
			success : function(response) {
				salaryFrequencyDetailsMenu();
				$("#salaryFrequencyDetails").show();
				$("#salaryFrequencyRegistrationForm").hide();
				alert(response);
				var jsonString = JSON.stringify(response);
				alert(jsonString);
				var jsonObject = JSON.parse(jsonString);
				//alert("Data is " + data.employeeid);		
				$("#salaryFrequencyNameDisplay").val(jsonObject.salaryFrequencyName);	
				$("#salaryFrequencyDescriptionDisplay").val(jsonObject.description);
				$("#salaryFrequencyNotesDisplay").val(jsonObject.notes);												
				$(".updateSalaryFrequency").attr("id", jsonObject.salaryFrequencyId);
				$(".deleteSalaryFrequency").attr("id", jsonObject.salaryFrequencyId);
				//	        		$("#employeeRegistrationMenu").css("background-image","url('/LoanAppDemo/resources/images/sub-menu-color.PNG')");

			},
			error : function() {
				alert("Error while request..");
			}
		});
	}
	
	function getPaydayDetails(id) {
		alert("Inside Pay Details Id is " + id);
		$.ajax({
			type : "POST",
			dataType : 'json',
			url : "../getPaydayDetails",
			cache : false,
			data : {
				paydayId : id
			},
			success : function(response) {
				payDayDetailsMenu();
				$("#payday-details").show();
				$("#payday-registration-form").hide();
				alert(response);
				var jsonString = JSON.stringify(response);
				alert(jsonString);
				var jsonObject = JSON.parse(jsonString);
				//alert("Data is " + data.employeeid);		
				$("#paydayNameDisplay").val(jsonObject.payDayName);	
				$("#minAmountDisplay").val(jsonObject.minAmount);
				$("#maxAmountDisplay").val(jsonObject.maxAmount);				
				$("#interestRateDisplay").val(jsonObject.interestRate);
				$("#maxLoanDurationDisplay").val(jsonObject.maxLoanDuration);
				$("#coolingOfPeriodDisplay").val(jsonObject.coolingOfPeriod);
				$("#paydayDescriptionDisplay").val(jsonObject.description);
				$("#paydayNotesDisplay").val(jsonObject.notes);					
				$(".updatePayday").attr("id", jsonObject.payDayId);
				$(".deletePayday").attr("id", jsonObject.payDayId);
				//	        		$("#employeeRegistrationMenu").css("background-image","url('/LoanAppDemo/resources/images/sub-menu-color.PNG')");

			},
			error : function() {
				alert("Error while request..");
			}
		});
	}
	
	function getOrganizationDetails(id) {
		alert("Inside Organization Details " + id);
		$.ajax({
			type : "POST",
			dataType : 'json',
			url : "../getOrganizationDetails",
			cache : false,
			data : {
				organizationID : id
			},
			success : function(response) {
				organizationDetailsMenu();
				$("#organization-details").show();
				$("#organization-registration-form").hide();
				alert(response);
				var jsonString = JSON.stringify(response);
				alert(jsonString);
				var jsonObject = JSON.parse(jsonString);
				alert("Array is " + jsonObject.organizationname);
				//alert("Data is " + data.employeeid);			        		
				$("#organizationNameDisplay").val(jsonObject.organizationname);
				//	        		$("#fullName").val(jsonObject.fullname);
				/*$("#allowOverrideSessionValue").val(jsonObject.allowoverrideofsessionvalues);
				$("#branchId").val(jsonObject.branchid);
				$("#cancleLogin").val(jsonObject.canlogin);
				$("#cdoTypeId").val(jsonObject.cdotypeid);
				$("#changeCount").val(jsonObject.changecount);
				$("#changeStatusId").val(jsonObject.changestatusid);
				$("#description").val(jsonObject.description);
				$("#historyViewId").val(jsonObject.historyviewid);
				$("#esigroleGroupId").val(jsonObject.esigrolegroupid);
				$("#iconId").val(jsonObject.iconid);
				$("#languageDicId").val(jsonObject.languagedictionaryid);
				$("#mdAllowMultipleSignIn").val(jsonObject.mdallowmultiplesignin);
				$("#menuDefId").val(jsonObject.menudefinitionid);
				$("#notes").val(jsonObject.notes);
				$("#portalProfileId").val(jsonObject.uiportalprofileid);
				$("#portalMenuDefId").val(jsonObject.portalmenudefinitionid);
				$("#primaryoOrgId").val(jsonObject.primaryorganizationid);
				$("#sessionValuesId").val(jsonObject.sessionvaluesid);
				$("#terminologyDicId").val(jsonObject.terminologydictionaryid);
				$("#trainingPlanId").val(jsonObject.trainingplanid);
				$("#userComment").val(jsonObject.usercomment);*/
				$(".updateOrganization").attr("id", jsonObject.organizationid);
				$(".deleteOrganization").attr("id", jsonObject.organizationid);
				//	        		$("#employeeRegistrationMenu").css("background-image","url('/LoanAppDemo/resources/images/sub-menu-color.PNG')");

			},
			error : function() {
				alert("Error while request..");
			}
		});
	}

	function getBranchDetails(id) {
		alert("Inside Branch Details " + id);
		$.ajax({
			type : "POST",
			dataType : 'json',
			url : "../getBranchDetails",
			cache : false,
			data : {
				branchID : id
			},
			success : function(response) {
				/* branchDetailsMenu();
				$("#employee-details").show();
				$("#employee-registration-form").hide();*/
				$("#branch-details").show();
				$("#branch-registration-form").hide();
				branchDetailsMenu();
				alert(response);
				var jsonString = JSON.stringify(response);
				alert(jsonString);
				var jsonObject = JSON.parse(jsonString);
				alert("Array is " + jsonObject.branchname);
				//alert("Data is " + data.employeeid);			        		
				$("#branchNameDisplay").val(jsonObject.branchname);
				$("#branchAddressDisplay").val(jsonObject.branchaddress);
				/*$("#allowOverrideSessionValue").val(jsonObject.allowoverrideofsessionvalues);
				$("#branchId").val(jsonObject.branchid);
				$("#cancleLogin").val(jsonObject.canlogin);
				$("#cdoTypeId").val(jsonObject.cdotypeid);
				$("#changeCount").val(jsonObject.changecount);
				$("#changeStatusId").val(jsonObject.changestatusid);
				$("#description").val(jsonObject.description);
				$("#historyViewId").val(jsonObject.historyviewid);
				$("#esigroleGroupId").val(jsonObject.esigrolegroupid);
				$("#iconId").val(jsonObject.iconid);
				$("#languageDicId").val(jsonObject.languagedictionaryid);
				$("#mdAllowMultipleSignIn").val(jsonObject.mdallowmultiplesignin);
				$("#menuDefId").val(jsonObject.menudefinitionid);
				$("#notes").val(jsonObject.notes);
				$("#portalProfileId").val(jsonObject.uiportalprofileid);
				$("#portalMenuDefId").val(jsonObject.portalmenudefinitionid);
				$("#primaryoOrgId").val(jsonObject.primaryorganizationid);
				$("#sessionValuesId").val(jsonObject.sessionvaluesid);
				$("#terminologyDicId").val(jsonObject.terminologydictionaryid);
				$("#trainingPlanId").val(jsonObject.trainingplanid);
				$("#userComment").val(jsonObject.usercomment);	*/
				$(".updateBranch").attr("id", jsonObject.branchid);
				$(".deleteBranch").attr("id", jsonObject.branchid);
				//	        		$("#employeeRegistrationMenu").css("background-image","url('/LoanAppDemo/resources/images/sub-menu-color.PNG')");

			},
			error : function() {
				alert("Error while request..");
			}
		});
	}

	function getEmployeeDetails(id) {
		alert("Inside Employee Details " + id);
		$.ajax({
			type : "POST",
			dataType : 'json',
			url : "../getEmployeeDetails",
			cache : false,
			data : {
				employeeID : id
			},
			success : function(response) {
				employeeDetailsMenu();
				$("#employee-details").show();
				$("#employee-registration-form").hide();
				alert(response);
				var jsonString = JSON.stringify(response);
				alert(jsonString);
				var jsonObject = JSON.parse(jsonString);
				alert("Array is " + jsonObject.fullname);
				//alert("Data is " + data.employeeid);			        		
				$("#employeeNameDIsplay").val(jsonObject.employeename);
				$("#fullName").val(jsonObject.fullname);
				$("#allowOverrideSessionValue").val(
						jsonObject.allowoverrideofsessionvalues);
				$("#branchId").val(jsonObject.branchid);
				$("#cancleLogin").val(jsonObject.canlogin);
				$("#cdoTypeId").val(jsonObject.cdotypeid);
				$("#changeCount").val(jsonObject.changecount);
				$("#changeStatusId").val(jsonObject.changestatusid);
				$("#description").val(jsonObject.description);
				$("#historyViewId").val(jsonObject.historyviewid);
				$("#esigroleGroupId").val(jsonObject.esigrolegroupid);
				$("#iconId").val(jsonObject.iconid);
				$("#languageDicId").val(jsonObject.languagedictionaryid);
				$("#mdAllowMultipleSignIn").val(
						jsonObject.mdallowmultiplesignin);
				$("#menuDefId").val(jsonObject.menudefinitionid);
				$("#notes").val(jsonObject.notes);
				$("#portalProfileId").val(jsonObject.uiportalprofileid);
				$("#portalMenuDefId").val(jsonObject.portalmenudefinitionid);
				$("#primaryoOrgId").val(jsonObject.primaryorganizationid);
				$("#sessionValuesId").val(jsonObject.sessionvaluesid);
				$("#terminologyDicId").val(jsonObject.terminologydictionaryid);
				$("#trainingPlanId").val(jsonObject.trainingplanid);
				$("#userComment").val(jsonObject.usercomment);
				$(".updateEmployee").attr("id", jsonObject.employeeid);
				$(".deleteEmployee").attr("id", jsonObject.employeeid);
				//	        		$("#employeeRegistrationMenu").css("background-image","url('/LoanAppDemo/resources/images/sub-menu-color.PNG')");

			},
			error : function() {
				alert("Error while request..");
			}
		});
	}

	function employeeDetailsMenu() {
		alert("Hello");
		$("#employeeRegistrationMenu").css("background-image",
				"url('/LoanAppDemo/resources/images/sub-menu-color.PNG')");
		$("#employeeDetailsMenu").css("background-image",
				"url('/LoanAppDemo/resources/images/sub-menu-hover.PNG')");
		alert("Hello");
	}

	function branchDetailsMenu() {
		$("#branchRegistraionMenu").css("background-image",
				"url('/LoanAppDemo/resources/images/sub-menu-color.PNG')");
		$("#branchDetailsMenu").css("background-image",
				"url('/LoanAppDemo/resources/images/sub-menu-hover.PNG')");
	}

	function branchRegistraionMenu() {
		$("#branchDetailsMenu").css("background-image",
				"url('/LoanAppDemo/resources/images/sub-menu-color.PNG')");
		$("#branchRegistraionMenu").css("background-image",
				"url('/LoanAppDemo/resources/images/sub-menu-hover.PNG')");
	}

	function organizationDetailsMenu() {
		$("#organizationRegistraionMenu").css("background-image",
				"url('/LoanAppDemo/resources/images/sub-menu-color.PNG')");
		$("#organizationDetailsMenu").css("background-image",
				"url('/LoanAppDemo/resources/images/sub-menu-hover.PNG')");
	}

	function organizationRegistrationMenu() {
		$("#organizationDetailsMenu").css("background-image",
				"url('/LoanAppDemo/resources/images/sub-menu-color.PNG')");
		$("#organizationRegistraionMenu").css("background-image",
				"url('/LoanAppDemo/resources/images/sub-menu-hover.PNG')");
	}
	
	function payDayDetailsMenu() {
		$("#paydayRegistrationMenu").css("background-image",
				"url('/LoanAppDemo/resources/images/sub-menu-color.PNG')");
		$("#paydayDetailsMenu").css("background-image",
				"url('/LoanAppDemo/resources/images/sub-menu-hover.PNG')");
	}

	function payDayRegistrationMenu() {
		$("#paydayDetailsMenu").css("background-image",
				"url('/LoanAppDemo/resources/images/sub-menu-color.PNG')");
		$("#paydayRegistrationMenu").css("background-image",
				"url('/LoanAppDemo/resources/images/sub-menu-hover.PNG')");
	}
	
	function salaryFrequencyDetailsMenu() {
		$("#salaryFrequencyRegistrationMenu").css("background-image",
				"url('/LoanAppDemo/resources/images/sub-menu-color.PNG')");
		$("#salaryFrequencyDetailsMenu").css("background-image",
				"url('/LoanAppDemo/resources/images/sub-menu-hover.PNG')");
	}

	function salaryFrequencyRegistrationMenu() {
		$("#salaryFrequencyDetailsMenu").css("background-image",
				"url('/LoanAppDemo/resources/images/sub-menu-color.PNG')");
		$("#salaryFrequencyRegistrationMenu").css("background-image",
				"url('/LoanAppDemo/resources/images/sub-menu-hover.PNG')");
	}


function myFunction() {
    // Declare variables	
    var input, filter, ul, li, a, i;
    input = document.getElementById('myInput');
    filter = input.value.toUpperCase();
    ul = document.getElementById("myUL");
    li = ul.getElementsByTagName('li');

    // Loop through all list items, and hide those who don't match the search query
    for (i = 0; i < li.length; i++) {
        a = li[i].getElementsByTagName("a")[0];
        if (a.innerHTML.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}


function mySubFunction() {
    // Declare variables	
    var input, filter, ul, li, a, i;
    input = document.getElementById('mySubInput');
    filter = input.value.toUpperCase();
    ul = document.getElementById("mySubUL");
    li = ul.getElementsByTagName('li');

    // Loop through all list items, and hide those who don't match the search query
    for (i = 0; i < li.length; i++) {
        a = li[i].getElementsByTagName("a")[0];
        if (a.innerHTML.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}


