<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<script src="<c:url value="/resources/js/common.js"/>"></script>
<script src="<c:url value="/resources/js/function.js"/>"></script>
<script src="<c:url value="/resources/js/scripts.js"/>"></script>
<link href="<c:url value="/resources/css/layout.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/designstyle.css"/>"
	rel="stylesheet">
<script src="<c:url value="/resources/js/json2.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/js/ajax-jquery-min.js"/>"></script>

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
		showEmployee();
		/*		getAllEmployeeId();
		 getBranchId();
		 getOrganizationId(); */
	})
</script>
</head>
<body>
	<div class="main-container">
		<div class="header">
			<div class="header-logo">
				<img src="images/hpe-logo.png" alt="" width="190" height="90" />
			</div>
			<div>
				<span
					style="font-size: 24px; width: 920px; position: absolute; margin-left: 390px; margin-top: 20px;"
					onclick="deleteEmployee(123)">Loan Application</span>
			</div>
			<div
				style="position: absolute; font-weight: bold; font-size: small; margin-left: 1280px; margin-top: 70px; color: white;">
				<form action="./logout.do" method="post">
					<input type="submit" value="Logout" />
				</form>
			</div>
		</div>
		<div class="body-container">
			<div
				style="width: 200px; position: absolute; height: 599px; overflow: scroll; background-color: #f6f6f6;">
				<input type="text" id="myInput" onkeyup="myFunction()"
					placeholder="Search here..">

				<ul id="myUL">
					<li><a href="#" class="header1" onclick="showEmployee()">Employee</a></li>
					<li><a href="#" onclick="showBranch()">Branch</a></li>
					<li><a href="#" onclick="showOrganization()">Organization</a></li>
					<li><a href="#" onclick="showPayday()">Payday</a></li>
					<li><a href="#" onclick="showSalaryFrequency()">Salary
							Frequency</a></li>
				</ul>
			</div>
			<div
				style="width: 200px; position: absolute; margin-top: 2px; height: 599px; overflow: scroll; margin-left: 202px; background-color: #f6f6f6;">
				<input type="text" id="mySubInput" onkeyup="mySubFunction()"
					placeholder="Search here..">

				<ul id="mySubUL">

				</ul>
			</div>
			<!-- Employee Section Start -->
			<div id="employeeSection">
				<div class="newRequest"
					style="height: 29px; background-image: url(<c:url value="/resources/images/sub-menu-color.PNG"/>); margin: auto; width: auto; border: 1px solid; margin-left: 403px;">
					<div id="employeeSubMenu">
						<div id="employeeRegistrationMenu" onclick="showInputForm()"
							style="position: absolute; background-image: url(<c:url value="/resources/images/sub-menu-hover.PNG"/>); cursor: pointer; font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px; font-weight: bold; padding-top: 7px; color: #004695; width: 155px; height: 23px; padding-left: 10px;">
							<a style="text-decoration: none; color: white;"> Registration</a>
						</div>
						<div id="employeeDetailsMenu" onclick="showManagementVar()"
							style="background-image: url(<c:url value="/resources/images/sub-menu-color.PNG"/>); margin-left: 498px; cursor: pointer; font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px; font-weight: bold; padding-top: 7px; color: #004695; width: 155px; height: 23px; padding-left: 10px;">
							<a style="text-decoration: none; color: white;">Details</a>
						</div>
					</div>
				</div>
				<div id="employee-registration-form"
					style="overflow: scroll; height: 570px; width: 940px; font-size: 12px; margin-left: 405px;">
					<form action="../employeeRegistration.do" method="post">
						<table id="tab1" style="width: 100%;">
							<tr class="rh">
								<td colspan="4">Employee Personal Details</td>
							</tr>
							<tr>
								<td>Enter Employee Name:</td>
								<td><input type="text" name="employeename" size="20"></td>
								<td>Full Name:</td>
								<td><input type="text" name="fullname" size="20"></td>
							</tr>
							<tr>
								<td>Email Address:</td>
								<td><input type="text" name="email" size="20"></td>
								<td>Password:</td>
								<td><input type="password" name="password" size="20"></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr class="rh">
								<td colspan="4">Other Details</td>
							</tr>
							<tr>
								<td>Allow Override of Session Value:</td>
								<td><input type="text" name="allowoverridesessionvalue"
									size="20" value="20"></td>
								<td>Branch ID:</td>
								<td><select name="branchid" id="branchid">
										<option value="null">Select</option>
								</select></td>
							</tr>
							<tr>
								<td>Cancle Login:</td>
								<td><input type="text" name="canclelogin" size="20"
									value="10"></td>
								<td>CDO Type ID:</td>
								<td><select name="cdotypeid"><option value="10">Select</option></select></td>
							</tr>
							<tr>
								<td>Change Count:</td>
								<td><input type="text" name="changecount" size="20"
									value="20"></td>
								<td>Change Status ID:</td>
								<td><select name="changestatusid"><option
											value="null">Select</option></select></td>
							</tr>
							<tr>
								<td>Description:</td>
								<td><input type="text" name="description" size="20"></td>
								<td>History View ID:</td>
								<td><select name="historyviewid"><option
											value="null">Select</option></select></td>
							</tr>
							<tr>
								<td>ESIG Role Group ID:</td>
								<td><select name="esigrolegroupid"><option
											value="null">Select</option></select></td>
								<td>ICON ID:</td>
								<td><select name="iconid"><option value="10">Select</option></select></td>
							</tr>
							<tr>
								<td>Language Dictionary ID:</td>
								<td><select name="languagedicid"><option
											value="null">Select</option></select></td>
								<td>MD Allow Multiple SignIn:</td>
								<td><input type="text" name="mdallowmultiplesignin"
									size="20" value="10"></td>
							</tr>
							<tr>
								<td>Menu Definition ID:</td>
								<td><select name="menudefid"><option value="null">Select</option></select></td>
								<td>Notes:</td>
								<td><input type="text" name="notes" size="20"></td>
							</tr>
							<tr>
								<td>UI Portal Profile ID:</td>
								<td><select name="portalprofileid"><option
											value="null">Select</option></select></td>
								<td>Portal Menu Definition ID:</td>
								<td><select name="portalmenudefid"><option
											value="null">Select</option></select></td>
							</tr>
							<tr>
								<td>Primary Organization ID:</td>
								<td><select name="primaryorgid"><option
											value="null">Select</option></select></td>
								<td>Session Values ID:</td>
								<td><select name="sessionvaluesid"><option
											value="null">Select</option></select></td>
							</tr>
							<tr>
								<td>Terminology Dictionary ID:</td>
								<td><select name="terminologydicid"><option
											value="null">Select</option></select></td>
								<td>Training Plan ID:</td>
								<td><select name="trainingplanid"><option
											value="null">Select</option></select></td>
							</tr>
							<tr>
								<td>User Comment:</td>
								<td><input type="text" name="usercomment" size="20"></td>
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
				<div id="employee-details"
					style="overflow: scroll; height: 570px; width: 940px; font-size: 12px; margin-left: 405px;">
					<form action="../employeeRegistration.do" method="post">
						<table id="tab1" style="width: 100%;">
							<tr class="rh">
								<td colspan="4">Employee Personal Details</td>
							</tr>
							<tr>
								<td>Enter Employee Name:</td>
								<td><input type="text" name="employeeNameDIsplay"
									id="employeeNameDIsplay" size="20"></td>
								<td>Full Name:</td>
								<td><input type="text" name="fullName" id="fullName"
									size="20"></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr class="rh">
								<td colspan="4">Other Details</td>
							</tr>
							<tr>
								<td>Allow Override of Session Value:</td>
								<td><input type="text" name="allowOverrideSessionValue"
									id="allowOverrideSessionValue" size="20" value="20"></td>
								<td>Branch ID:</td>
								<td><select name="branchId" id="branchId">
										<option value="null">Select</option>
								</select></td>
							</tr>
							<tr>
								<td>Cancle Login:</td>
								<td><input type="text" name="cancleLogin" id="cancleLogin"
									size="20" value="10"></td>
								<td>CDO Type ID:</td>
								<td><select name="cdoTypeId" id="cdoTypeId"><option
											value="10">Select</option></select></td>
							</tr>
							<tr>
								<td>Change Count:</td>
								<td><input type="text" name="changeCount" id="changeCount"
									size="20" value="20"></td>
								<td>Change Status ID:</td>
								<td><select name="changeStatusId" id="changeStatusId"><option
											value="null">Select</option></select></td>
							</tr>
							<tr>
								<td>Description:</td>
								<td><input type="text" name="description" id="description"
									size="20"></td>
								<td>History View ID:</td>
								<td><select name="historyViewId" id="historyViewId"><option
											value="null">Select</option></select></td>
							</tr>
							<tr>
								<td>ESIG Role Group ID:</td>
								<td><select name="esigroleGroupId" id="esigroleGroupId"><option
											value="null">Select</option></select></td>
								<td>ICON ID:</td>
								<td><select name="iconId" id="iconId"><option
											value="10">Select</option></select></td>
							</tr>
							<tr>
								<td>Language Dictionary ID:</td>
								<td><select name="languageDicId" id="languageDicId"><option
											value="null">Select</option></select></td>
								<td>MD Allow Multiple SignIn:</td>
								<td><input type="text" name="mdAllowMultipleSignIn"
									id="mdAllowMultipleSignIn" size="20" value="10"></td>
							</tr>
							<tr>
								<td>Menu Definition ID:</td>
								<td><select name="menuDefId" id="menuDefId"><option
											value="null">Select</option></select></td>
								<td>Notes:</td>
								<td><input type="text" name="notes" id="notes" size="20"></td>
							</tr>
							<tr>
								<td>UI Portal Profile ID:</td>
								<td><select name="portalProfileId" id="portalProfileId"><option
											value="null">Select</option></select></td>
								<td>Portal Menu Definition ID:</td>
								<td><select name="portalMenuDefId" id="portalMenuDefId"><option
											value="null">Select</option></select></td>
							</tr>
							<tr>
								<td>Primary Organization ID:</td>
								<td><select name="primaryoOrgId" id="primaryoOrgId"><option
											value="null">Select</option></select></td>
								<td>Session Values ID:</td>
								<td><select name="sessionValuesId" id="sessionValuesId"><option
											value="null">Select</option></select></td>
							</tr>
							<tr>
								<td>Terminology Dictionary ID:</td>
								<td><select name="terminologyDicId" id="terminologyDicId"><option
											value="null">Select</option></select></td>
								<td>Training Plan ID:</td>
								<td><select name="trainingPlanId" id="trainingPlanId"><option
											value="null">Select</option></select></td>
							</tr>
							<tr>
								<td>User Comment:</td>
								<td><input type="text" name="userComment" id="userComment"
									size="20"></td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td colspan="2" align="right"><input type="button"
									value="Update" class="updateEmployee"
									onclick="updateEmployee(this.id)" /><input type="button"
									value="Delete" class="deleteEmployee"
									onclick="deleteEmployee(this.id)" /></td>
								<td colspan="2"><input type="reset" value="Reset"></td>
							</tr>
						</table>
					</form>
				</div>
			</div>

			<!-- Employee Section End -->

			<!-- Branch Section Start -->
			<div id="branchSection">
				<div class="newRequest"
					style="height: 29px; background-image: url(<c:url value="/resources/images/sub-menu-color.PNG"/>); margin: auto; width: auto; border: 1px solid; margin-left: 403px;">
					<div id="employeeSubMenu">
						<div id="branchRegistraionMenu" onclick="showInputForm()"
							style="position: absolute; background-image: url(<c:url value="/resources/images/sub-menu-hover.PNG"/>); cursor: pointer; font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px; font-weight: bold; padding-top: 7px; color: #004695; width: 155px; height: 23px; padding-left: 10px;">
							<a style="text-decoration: none; color: white;"> Registration</a>
						</div>

						<%-- <div id="mVariableFormMenu" onclick="showManagementVar()"
							style="position: absolute; background-image: url(<c:url value="/resources/images/sub-menu-color.PNG"/>); margin-left: 166px; cursor: pointer; font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px; font-weight: bold; padding-top: 7px; color: #004695; width: 155px; height: 23px; padding-left: 10px;">
							<a style="text-decoration: none; color: white;">Delete</a>
						</div>
						<div id="mVariableFormMenu" onclick="showManagementVar()"
							style="position: absolute; background-image: url(<c:url value="/resources/images/sub-menu-color.PNG"/>); margin-left: 332px; cursor: pointer; font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px; font-weight: bold; padding-top: 7px; color: #004695; width: 155px; height: 23px; padding-left: 10px;">
							<a style="text-decoration: none; color: white;">Update</a>
						</div> --%>
						<div id="branchDetailsMenu" onclick="showManagementVar()"
							style="background-image: url(<c:url value="/resources/images/sub-menu-color.PNG"/>); margin-left: 498px; cursor: pointer; font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px; font-weight: bold; padding-top: 7px; color: #004695; width: 155px; height: 23px; padding-left: 10px;">
							<a style="text-decoration: none; color: white;">Details</a>
						</div>
					</div>
				</div>
				<div id="branch-registration-form"
					style="overflow: scroll; height: 570px; width: 940px; font-size: 12px; margin-left: 405px;">
					<form action="../branchRegistration" method="post">
						<table style="width: 100%;">
							<tr class="rh">
								<td colspan="4">Branch Details</td>
							</tr>
							<tr>
								<td>Enter Branch Name:</td>
								<td><input type="text" name="branchname" size="20"></td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td>Branch Address:</td>
								<td><textarea name="branchaddress" rows="4"></textarea></td>
								<td>Branch Phone Number:</td>
								<td><input type="text" name="branchphone" size="20"
									value="10"></td>
							</tr>
							<tr>
								<td>Branch Fax:</td>
								<td><input type="text" name="branchfax" size="20"
									value="10"></td>
								<td>ICON ID:</td>
								<td><select name="iconid"><option value="10">Select</option></select></td>
							</tr>
							<tr>
								<td>Is Frozen:</td>
								<td><input type="text" name="isfrozen" size="20" value="0"></td>
								<td>Max Time Incemsgs Retrieved:</td>
								<td><input type="text" name="maxtimesincemsgsretrived"
									size="20" value="10"></td>
							</tr>
							<tr>
								<td>MFG Calendar ID:</td>
								<td><select name="mfgcalendarid"><option
											value="null">Select</option></select></td>
								<td>Notes:</td>
								<td><input type="text" name="notes" size="20" value="null"></td>
							</tr>
							<tr>
								<td>Organization ID:</td>
								<td><select name="organizationid" id="organizationid"><option
											value="null">Select</option></select></td>
								<td>Print Queue ID:</td>
								<td><select name="printqueueid"><option
											value="null">Select</option></select></td>
							</tr>
							<tr>
								<td>Report Heading:</td>
								<td><input type="text" name="reportheading" size="20"
									value="null"></td>
								<td>Require Location:</td>
								<td><input type="text" name="requirelocation" size="20"
									value="10"></td>
							</tr>
							<tr>
								<td>Retention Days:</td>
								<td><input type="text" name="retentiondays" size="20"
									value="10"></td>
								<td>SMTP Transport ID:</td>
								<td><select name="smtptransportid"><option
											value="null">Select</option></select></td>
							</tr>
							<tr>
								<td>Training Req Group ID:</td>
								<td><select name="trainingreqgroupid"><option
											value="null">Select</option></select></td>
								<td>WIP MSG DEF MGR ID:</td>
								<td><select name="wipmsgdefmgrid"><option
											value="null">Select</option></select></td>
							</tr>
							<tr>
								<td>Can RE-Open Loan:</td>
								<td><input type="text" name="canreopenloan" size="20"
									value="10"></td>
								<td>Can Re-Open CC:</td>
								<td><input type="text" name="canreopencc" size="20"
									value="10"></td>
							</tr>
							<tr>
								<td>Cert Expiry Days:</td>
								<td><input type="text" name="certexpirydays" size="20"
									value="10"></td>
								<td>Cert Not OK Status ID:</td>
								<td><select name="certnotokstatusid"><option
											value="null">Select</option></select></td>
							</tr>
							<tr>
								<td>Cert OK Status ID:</td>
								<td><select name="certokstatusid"><option
											value="null">Select</option></select></td>
								<td>Concate Nation Character:</td>
								<td><input type="text" name="concatenationcharacter"
									size="20" value="null"></td>
							</tr>
							<tr>
								<td colspan="2">&nbsp;</td>
								<td colspan="2">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="2" align="right"><input type="submit"
									value="Register"></td>
								<td colspan="2"><input type="reset" value="Reset"></td>
							</tr>
						</table>
					</form>
				</div>
				<div id="branch-details"
					style="overflow: scroll; height: 570px; width: 940px; font-size: 12px; margin-left: 405px;">
					<form action="../branchRegistration" method="post">
						<table style="width: 100%;">
							<tr class="rh">
								<td colspan="4">Branch Details</td>
							</tr>
							<tr>
								<td>Enter Branch Name:</td>
								<td><input type="text" name="branchNameDisplay"
									id="branchNameDisplay" size="20"></td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td>Branch Address:</td>
								<td><textarea name="branchAddressDisplay"
										id="branchAddressDisplay" rows="4"></textarea></td>
								<td>Branch Phone Number:</td>
								<td><input type="text" name="branchphone" size="20"
									value="10"></td>
							</tr>
							<tr>
								<td>Branch Fax:</td>
								<td><input type="text" name="branchfax" size="20"
									value="10"></td>
								<td>ICON ID:</td>
								<td><select name="iconid"><option value="10">Select</option></select></td>
							</tr>
							<tr>
								<td>Is Frozen:</td>
								<td><input type="text" name="isfrozen" size="20" value="0"></td>
								<td>Max Time Incemsgs Retrieved:</td>
								<td><input type="text" name="maxtimesincemsgsretrived"
									size="20" value="10"></td>
							</tr>
							<tr>
								<td>MFG Calendar ID:</td>
								<td><select name="mfgcalendarid"><option
											value="null">Select</option></select></td>
								<td>Notes:</td>
								<td><input type="text" name="notes" size="20" value="null"></td>
							</tr>
							<tr>
								<td>Organization ID:</td>
								<td><select name="organizationid" id="organizationid"><option
											value="null">Select</option></select></td>
								<td>Print Queue ID:</td>
								<td><select name="printqueueid"><option
											value="null">Select</option></select></td>
							</tr>
							<tr>
								<td>Report Heading:</td>
								<td><input type="text" name="reportheading" size="20"
									value="null"></td>
								<td>Require Location:</td>
								<td><input type="text" name="requirelocation" size="20"
									value="10"></td>
							</tr>
							<tr>
								<td>Retention Days:</td>
								<td><input type="text" name="retentiondays" size="20"
									value="10"></td>
								<td>SMTP Transport ID:</td>
								<td><select name="smtptransportid"><option
											value="null">Select</option></select></td>
							</tr>
							<tr>
								<td>Training Req Group ID:</td>
								<td><select name="trainingreqgroupid"><option
											value="null">Select</option></select></td>
								<td>WIP MSG DEF MGR ID:</td>
								<td><select name="wipmsgdefmgrid"><option
											value="null">Select</option></select></td>
							</tr>
							<tr>
								<td>Can RE-Open Loan:</td>
								<td><input type="text" name="canreopenloan" size="20"
									value="10"></td>
								<td>Can Re-Open CC:</td>
								<td><input type="text" name="canreopencc" size="20"
									value="10"></td>
							</tr>
							<tr>
								<td>Cert Expiry Days:</td>
								<td><input type="text" name="certexpirydays" size="20"
									value="10"></td>
								<td>Cert Not OK Status ID:</td>
								<td><select name="certnotokstatusid"><option
											value="null">Select</option></select></td>
							</tr>
							<tr>
								<td>Cert OK Status ID:</td>
								<td><select name="certokstatusid"><option
											value="null">Select</option></select></td>
								<td>Concate Nation Character:</td>
								<td><input type="text" name="concatenationcharacter"
									size="20" value="null"></td>
							</tr>
							<tr>
								<td colspan="2">&nbsp;</td>
								<td colspan="2">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="2" align="right"><input type="button"
									value="Update" class="updateBranch"
									onclick="updateBranch(this.id)" /><input type="button"
									value="Delete" class="deleteBranch"
									onclick="deleteBranch(this.id)" /></td>
								<td colspan="2"><input type="reset" value="Reset"></td>
							</tr>
						</table>
					</form>
				</div>
			</div>

			<!-- Branch Section End -->

			<!-- Organization Section Start -->

			<div id="organizationSection">
				<div class="newRequest"
					style="height: 29px; background-image: url(<c:url value="/resources/images/sub-menu-color.PNG"/>); margin: auto; width: auto; border: 1px solid; margin-left: 403px;">
					<div id="employeeSubMenu">
						<div id="organizationRegistrationMenu" onclick="showInputForm()"
							style="position: absolute; background-image: url(<c:url value="/resources/images/sub-menu-hover.PNG"/>); cursor: pointer; font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px; font-weight: bold; padding-top: 7px; color: #004695; width: 155px; height: 23px; padding-left: 10px;">
							<a style="text-decoration: none; color: white;"> Registration</a>
						</div>
						<div id="organizationDetailsMenu" onclick="showManagementVar()"
							style="background-image: url(<c:url value="/resources/images/sub-menu-color.PNG"/>); margin-left: 498px; cursor: pointer; font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px; font-weight: bold; padding-top: 7px; color: #004695; width: 155px; height: 23px; padding-left: 10px;">
							<a style="text-decoration: none; color: white;">Details</a>
						</div>
					</div>
				</div>
				<div id="organization-registration-form"
					style="overflow: scroll; height: 570px; width: 940px; font-size: 12px; margin-left: 405px;">
					<form action="../organizationRegistration.do" method="post">
						<table style="width: 100%;">
							<tr class="rh">
								<td colspan="4">Organization Details</td>
							</tr>
							<tr>
								<td>Enter Organization Name:</td>
								<td><input type="text" name="organizationname" size="20"></td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td>Organization Number:</td>
								<td><input type="text" name="organizationnumber" size="20"
									value="null"></td>
								<td>Parents Organization ID:</td>
								<td><select name="parentorganizationid">
										<option value="null">Select</option>
								</select></td>
							</tr>
							<tr>
								<td>Portal Home Page ID:</td>
								<td><select name="portalhomepageid"><option
											value="null">Select</option></select></td>
								<td>Print Queue ID:</td>
								<td><select name="printqueueid"><option
											value="null">Select</option></select></td>
							</tr>
							<tr>
								<td>SMTP Transport ID:</td>
								<td><select name="smtptransportid"><option
											value="null">Select</option></select></td>
								<td>User Required For ESIG:</td>
								<td><input type="text" name="userrequiredforesig" size="20"
									value="10"></td>
							</tr>
							<tr>
								<td>CDO Type ID:</td>
								<td><select name="cdotypeid"><option value="10">Select</option></select></td>
								<td>Change Count:</td>
								<td><input type="text" name="changecount" size="20"
									value="20"></td>
							</tr>
							<tr>
								<td>Change History ID:</td>
								<td><select name="changehistoryid"><option
											value="null">Select</option></select></td>
								<td>Collect ESIG For All Quality Transctions:</td>
								<td><input type="text" name="collectesigforallqualitytxns"
									size="20"></td>
							</tr>
							<tr>
								<td>Description:</td>
								<td><input type="text" name="description" size="20"
									value="null"></td>
								<td>ICON ID:</td>
								<td><select name="iconid"><option value="10">Select</option></select></td>
							</tr>
							<tr>
								<td>Is Frozen:</td>
								<td><input type="text" name="isfrozen" size="20" value="0"></td>
								<td>Notes:</td>
								<td><input type="text" name="notes" size="20" value="null"></td>
							</tr>
							<tr>
								<td colspan="2">&nbsp;</td>
								<td colspan="2">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="2" align="right"><input type="submit"
									value="Register"></td>
								<td colspan="2"><input type="reset" value="Reset"></td>
							</tr>
						</table>
					</form>
				</div>
				<div id="organization-details"
					style="overflow: scroll; height: 570px; width: 940px; font-size: 12px; margin-left: 405px;">
					<form action="../organizationRegistration.do" method="post">
						<table style="width: 100%;">
							<tr class="rh">
								<td colspan="4">Organization Details</td>
							</tr>
							<tr>
								<td>Enter Organization Name:</td>
								<td><input type="text" name="organizationNameDisplay"
									id="organizationNameDisplay" size="20"></td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td>Organization Number:</td>
								<td><input type="text" name="organizationNumberDisplay"
									size="20" value="null"></td>
								<td>Parents Organization ID:</td>
								<td><select name="parentorganizationid">
										<option value="null">Select</option>
								</select></td>
							</tr>
							<tr>
								<td>Portal Home Page ID:</td>
								<td><select name="portalhomepageid"><option
											value="null">Select</option></select></td>
								<td>Print Queue ID:</td>
								<td><select name="printqueueid"><option
											value="null">Select</option></select></td>
							</tr>
							<tr>
								<td>SMTP Transport ID:</td>
								<td><select name="smtptransportid"><option
											value="null">Select</option></select></td>
								<td>User Required For ESIG:</td>
								<td><input type="text" name="userrequiredforesig" size="20"
									value="10"></td>
							</tr>
							<tr>
								<td>CDO Type ID:</td>
								<td><select name="cdotypeid"><option value="10">Select</option></select></td>
								<td>Change Count:</td>
								<td><input type="text" name="changecount" size="20"
									value="20"></td>
							</tr>
							<tr>
								<td>Change History ID:</td>
								<td><select name="changehistoryid"><option
											value="null">Select</option></select></td>
								<td>Collect ESIG For All Quality Transctions:</td>
								<td><input type="text" name="collectesigforallqualitytxns"
									size="20"></td>
							</tr>
							<tr>
								<td>Description:</td>
								<td><input type="text" name="description" size="20"
									value="null"></td>
								<td>ICON ID:</td>
								<td><select name="iconid"><option value="10">Select</option></select></td>
							</tr>
							<tr>
								<td>Is Frozen:</td>
								<td><input type="text" name="isfrozen" size="20" value="0"></td>
								<td>Notes:</td>
								<td><input type="text" name="notes" size="20" value="null"></td>
							</tr>
							<tr>
								<td colspan="2">&nbsp;</td>
								<td colspan="2">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="2" align="right"><input type="button"
									value="Update" class="updateOrganization"
									onclick="updateOrganization(this.id)" /><input type="button"
									value="Delete" class="deleteOrganization"
									onclick="deleteOrganization(this.id)" /></td>
								<td colspan="2"><input type="reset" value="Reset"></td>
							</tr>
						</table>
					</form>
				</div>
			</div>

			<!-- Organization Section End -->

			<!-- Payday Section Start -->

			<%@include file="payday.jsp"%>

			<!-- Payday Section End -->

			<%@include file="salary_frequency.jsp"%>

		</div>
		<div class="footer-container" style="position: relative;">
			<div class="footer-content">
				<div
					style="width: 200px; margin-top: 15px; position: absolute; margin-left: 500px; font-size: 12px;">&copy;
					Copyright Loan Application 2017.</div>
			</div>
		</div>
	</div>
</body>

</html>