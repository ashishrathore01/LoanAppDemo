<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Home Page</title>
<script src="<c:url value="/resources/js/common.js"/>"></script>
<script src="<c:url value="/resources/js/function.js"/>"></script>
<script src="<c:url value="/resources/js/scripts.js"/>"></script>
<link href="<c:url value="/resources/css/layout.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/designstyle.css"/>"
	rel="stylesheet">

<link href="<c:url value="/resources/css/first.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/second.css"/>" rel="stylesheet">

<script src="<c:url value="/resources/js/json2.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/js/ajax-jquery-min.js"/>"></script>

<script src="<c:url value="/resources/js/first.js"/>"></script>
<script src="<c:url value="/resources/js/second.js"/>"></script>
<script src="<c:url value="/resources/js/third.js"/>"></script>

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.1/jquery-ui.min.js">
	
</script>
<script
	src="https://jquery-ui.googlecode.com/svn/tags/latest/ui/jquery.effects.core.js"></script>
<script src="<c:url value="/resources/js/jquery-ui.js"/>"></script>
<script type="text/javascript">
	$(document).ready(function() {
		showCustomerRegistration();
		$('#example').DataTable();
	})

	function showCustomerRegistration() {
		$("#customer-search").hide();
		$("#customer-details").hide();
		$("#customer-registration-form").show();
	}
	function showCustomerSearch() {
		$("#customer-search").show();
		$("#customer-details").hide();
		$("#customer-registration-form").hide();
		//getAllCustomerList();
		//		var a = "1205828718220536";
		//	searchCustomer(a);
	}
	
	function showCustomerList() {
		$("#customer-search").hide();
		$("#customer-details").show();
		$("#customer-registration-form").hide();
		//getAllCustomerList();
		//		var a = "1205828718220536";
		//	searchCustomer(a);
	}

	function getHello(id) {
		alert("ID is " + id);
	}

	function getAllCustomerList() {
		$.ajax({
			type : "POST",
			contentType : "application/json",
			dataType : 'json',
			url : "../getAllCustomerList",
			cache : false,
			success : function(response) {
				$("#example tbody").empty();
				$.each(response, function(key, value) {
					$("#example tbody").append(
							'<tr><td><input type="radio" name="customerId" onclick="getHello('
									+ value["customerId"] + ')"></td><td>'
									+ value["firstName"] + '</td><td>'
									+ value["middleName"] + '</td><td>'
									+ value["lastName"] + '</td><td>'
									+ value["dob"] + '</td><td>'
									+ value["license"] + '</td><td>'
									+ value["expiry"] + '</td><td>'
									+ value["province"] + '</td><td>'
									+ value["phone"] + '</td><td>'
									+ value["address"] + '</td><td>'
									+ value["bankName"] + '</td><td>'
									+ value["branchName"] + '</td><td>'
									+ value["instituteNumber"] + '</td><td>'
									+ value["accountNumber"] + '</td><td>'
									+ value["bankAddress"] + '</td><td>'
									+ value["employerName"] + '</td><td>'
									+ value["employerPhone"] + '</td><td>'
									+ value["supervisorPhone"] + '</td><td>'
									+ value["salaryFrequency"] + '</td><td>'
									+ value["employerAddress"] + '</td></tr>');
				});
			},
			error : function() {
				alert("Error while request..");
			}
		});
	}

	function searchCustomer() {
		var customerID = $("#customerIdSearch").val();
		alert("Inside Search Customer")
		$.ajax({
			type : "POST",
			//			contentType : "application/json",
			dataType : 'json',
			url : "../getCustomerDetails",
			cache : false,
			data : {
				customerID : customerID
			},
			success : function(response) {
				alert(response);
				var jsonString = JSON.stringify(response);
				alert(jsonString);
				var jsonObject = JSON.parse(jsonString);
				alert("Array is " + jsonObject.customerId);
				$('#customer-search-form')[0].reset();

				$("#firstNameDisplay").val(jsonObject.firstName);
				$("#middleNameDisplay").val(jsonObject.middleName);
				$("#lastNameDisplay").val(jsonObject.lastName);
				$("#dobDisplay").val(jsonObject.dob);
				$("#licenseDisplay").val(jsonObject.license);
				$("#expiryDisplay").val(jsonObject.expiry);
				$("#provinceDisplay").val(jsonObject.province);
				$("#phoneDisplay").val(jsonObject.phone);
				$("#addressDisplay").val(jsonObject.address);
				$("#bankNameDisplay").val(jsonObject.bankName);
				$("#branchNumberDisplay").val(jsonObject.branchName);
				$("#instituteNumberDisplay").val(jsonObject.instituteNumber);
				$("#accountNumberDisplay").val(jsonObject.accountNumber);
				$("#bankAddressDisplay").val(jsonObject.bankAddress);
				$("#employerNameDisplay").val(jsonObject.employerName);
				$("#employerPhoneDisplay").val(jsonObject.employerPhone);
				$("#supervisorPhoneDisplay").val(jsonObject.supervisorPhone);
				$("#salaryFrequencyDisplay").val(jsonObject.salaryFrequency);
				$("#employerAddressDisplay").val(jsonObject.employerAddress);
			},
			error : function() {
				alert("Error while request..");
			}
		});
	}
</script>
</head>
<body>
	<div class="main-container">
		<div class="header">
			<div class="header-logo">
				<img src="#" alt="" width="190" height="90" />
			</div>
			<div>
				<span
					style="font-size: 24px; width: 920px; position: absolute; margin-left: 390px; margin-top: 20px;">Operator
					Home Page</span>
			</div>
			<div
				style="position: absolute; font-weight: bold; font-size: small; margin-left: 1280px; margin-top: 70px; color: white;">
				<!-- <form action="./logout.do" method="post">
					<input type="submit" value="Logout" />
				</form> -->
			</div>
		</div>
		<div class="body-container">
			<div
				style="width: 200px; position: absolute; height: 599px; overflow: scroll; background-color: #f6f6f6;">
				<ul id="myUL">
					<li><a href="#" class="header1"
						onclick="showCustomerRegistration()"><b>Customer
								Registration</b></a></li>
					<li><a href="#" onclick="showCustomerSearch()"><b>Customer
								Search</b></a></li>
					<li><a href="#" onclick="showCustomerList()"><b>Customer
								List</b></a></li>								
				</ul>
			</div>
			<div id="employeeSection">
				<%-- <div class="newRequest"
					style="height: 29px; background-image: url(/LoanAppDemo/resources/images/sub-menu-color.PNG); margin: auto; width: 940px; border: 1px solid; margin-left: 280px;">
					<div id="employeeSubMenu">
						<div id="employeeRegistrationMenu"
							style="position: absolute; background-image: url(<c:url value="/resources/images/sub-menu-hover.PNG"/>); cursor: pointer; font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px; font-weight: bold; padding-top: 7px; color: #004695; width: 155px; height: 23px; padding-left: 10px;">
							<a style="text-decoration: none; color: white;">Registration</a>
						</div>
					</div>
				</div> --%>
				<div id="customer-details"
					style="overflow: scroll; height: 600px; width: auto; font-size: 12px; margin-left: 200px;">
					<%@include file="data-table.jsp"%>					
				</div>
				
				<div id="customer-registration-form"
					style="overflow: scroll; height: 600px; width: 940px; font-size: 12px; margin-left: 280px;">
					<form action="../customer-registration.do" method="post">
						<table id="tab1" style="width: 100%;">
							<tr class="rh">
								<td colspan="4">Customer Personal Details</td>
							</tr>
							<tr>
								<td>First Name:</td>
								<td><input type="text" name="firstName" size="20"></td>
								<td>Middle Name:</td>
								<td><input type="text" name="middleName" size="20"></td>
							</tr>
							<tr>
								<td>Last Name:</td>
								<td><input type="text" name="lastName" size="20"></td>
								<td>Date of Birth:</td>
								<td><input type="text" name="dob" size="20"></td>
							</tr>
							<tr>
								<td>License:</td>
								<td><input type="text" name="license" size="20"></td>
								<td>Expiry:</td>
								<td><input type="text" name="expiry" size="20"></td>
							</tr>
							<tr>
								<td>Province:</td>
								<td><input type="text" name="province" size="20"></td>
								<td>Phone:</td>
								<td><input type="text" name="phone" size="20"></td>
							</tr>
							<tr>
								<td>Address:</td>
								<td><textarea rows="4" cols="50" name="address"
										id="address"></textarea></td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr class="rh">
								<td colspan="4">Bank Details</td>
							</tr>
							<tr>
								<td>Bank Name:</td>
								<td><input type="text" name="bankName" size="20"></td>
								<td>Branch Name:</td>
								<td><input type="text" name="branchNumber"
									id="branchNumber"></td>
							</tr>
							<tr>
								<td>Institute Number:</td>
								<td><input type="text" name="instituteNumber" size="20"
									></td>
								<td>Account Number:</td>
								<td><input type="text" name="accountNumber" size="20"></td>
							</tr>
							<tr>
								<td>Bank Address:</td>
								<td><textarea rows="4" cols="50" name="bankAddress"
										id="bankAddress"></textarea></td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
							<tr class="rh">
								<td colspan="4">Employer Details</td>
							</tr>
							<tr>
								<td>Employer Name:</td>
								<td><input type="text" name="employerName"></td>
								<td>Employer Phone:</td>
								<td><input type="text" name="employerPhone" size="20"></td>
							</tr>
							<tr>
								<td>Supervisor Phone:</td>
								<td><input type="text" name="supervisorPhone"></td>
								<td>Salary Frequency:</td>
								<td><select
									id="salaryFrequency" name="salaryFrequency">
										<option value="select">Select</option>
										<option value="Weekly">Weekly</option>
										<option value="By Weekly">By Weekly</option>
										<option value="Monthly">Monthly</option>
										<option value="By Monthly">By Monthly</option>

								</select></td>
							</tr>
							<tr>
								<td>Employer Address:</td>
								<td><textarea rows="5" cols="50" name="employerAddress"></textarea></td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td colspan="2" align="right"><input type="submit"
									value="Register"></td>
								<td colspan="2"><input type="reset" value="Reset"></td>
							</tr>
						</table>
					</form>
				</div>

				<div id="customer-search"
					style="overflow: scroll; height: 600px; width: 940px; font-size: 12px; margin-left: 280px;">
					<form action="#" method="post">
						<table>
							<tr>
								<td>Customer Id:</td>
								<td><input type="text" id="customerIdSearch"></td>
								<td><input type="button" value="Search"
									onclick="searchCustomer()"></td>
							</tr>
							<!-- <tr>
								<td>Search Criteria</td>
								<td><select id="customerCrietria"><option>Select</option>
										<option></option>
										<option></option>
								</select></td>
								<td><span><input type="text" value="Search"
										id="customerIdCriteria" onclick="searchCustomer()"></span><span><input
										type="button" value="Search" onclick="searchCustomer()"></span></td>
							</tr> -->
						</table>
					</form>
					<form id="customer-search-form">
						<table id="tab1" style="width: 100%;">
							<tr class="rh">
								<td colspan="4">Customer Personal Details</td>
							</tr>
							<tr>
								<td>First Name:</td>
								<td><input type="text" name="firstNameDisplay"
									id="firstNameDisplay" size="20" readonly></td>
								<td>Middle Name:</td>
								<td><input type="text" name="middleNameDisplay"
									id="middleNameDisplay" size="20" readonly></td>
							</tr>
							<tr>
								<td>Last Name:</td>
								<td><input type="text" name="lastNameDisplay"
									id="lastNameDisplay" size="20" readonly></td>
								<td>Date of Birth:</td>
								<td><input type="text" name="dobDisplay" id="dobDisplay"
									size="20" readonly></td>
							</tr>
							<tr>
								<td>License:</td>
								<td><input type="text" name="licenseDisplay"
									id="licenseDisplay" size="20" readonly></td>
								<td>Expiry:</td>
								<td><input type="text" name="expiryDisplay"
									id="expiryDisplay" size="20" readonly></td>
							</tr>
							<tr>
								<td>Province:</td>
								<td><input type="text" name="provinceDisplay"
									id="provinceDisplay" size="20" readonly></td>
								<td>Phone:</td>
								<td><input type="text" name="phoneDisplay"
									id="phoneDisplay" size="20" readonly></td>
							</tr>
							<tr>
								<td>Address:</td>
								<td><textarea rows="4" cols="50" name="addressDisplay"
										id="addressDisplay" readonly></textarea></td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr class="rh">
								<td colspan="4">Bank Details</td>
							</tr>
							<tr>
								<td>Bank Name:</td>
								<td><input type="text" name="bankNameDisplay"
									id="bankNameDisplay" size="20" readonly></td>
								<td>Branch Name:</td>
								<td><input type="text" name="branchNumberDisplay"
									id="branchNumberDisplay"></td>
							</tr>
							<tr>
								<td>Institute Number:</td>
								<td><input type="text" name="instituteNumberDisplay"
									id="instituteNumberDisplay" size="20" readonly></td>
								<td>Account Number:</td>
								<td><input type="text" name="accountNumberDisplay"
									id="accountNumberDisplay" size="20" readonly></td>
							</tr>
							<tr>
								<td>Bank Address:</td>
								<td><textarea rows="4" cols="50" name="bankAddressDisplay"
										id="bankAddressDisplay" readonly></textarea></td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
							<tr class="rh">
								<td colspan="4">Employer Details</td>
							</tr>
							<tr>
								<td>Employer Name:</td>
								<td><input type="text" name="employerNameDisplay"
									id="employerNameDisplay" readonly></td>
								<td>Employer Phone:</td>
								<td><input type="text" name="employerPhoneDisplay"
									id="employerPhoneDisplay" size="20" readonly></td>
							</tr>
							<tr>
								<td>Supervisor Phone:</td>
								<td><input type="text" name="supervisorPhoneDisplay"
									id="supervisorPhoneDisplay" readonly></td>
								<td>Salary Frequency:</td>
								<td><input type="text" name="salaryFrequencyDisplay"
									id="salaryFrequencyDisplay" readonly></td>
							</tr>
							<tr>
								<td>Employer Address:</td>
								<td><textarea rows="5" cols="50"
										name="employerAddressDisplay" id="employerAddressDisplay"
										readonly></textarea></td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>