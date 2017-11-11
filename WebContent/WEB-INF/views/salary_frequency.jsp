<div id="salaryFrequencySection">
	<div class="newRequest"
		style="height: 29px; background-image: url(<c:url value="/resources/images/sub-menu-color.PNG"/>); margin: auto; width: auto; border: 1px solid; margin-left: 403px;">
		<div id="employeeSubMenu">
			<div id="salaryFrequencyRegistrationMenu" onclick="showInputForm()"
				style="position: absolute; background-image: url(<c:url value="/resources/images/sub-menu-hover.PNG"/>); cursor: pointer; font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px; font-weight: bold; padding-top: 7px; color: #004695; width: 155px; height: 23px; padding-left: 10px;">
				<a style="text-decoration: none; color: white;"> Registration</a>
			</div>			
			<div id="salaryFrequencyDetailsMenu" onclick="showManagementVar()"
				style="background-image: url(<c:url value="/resources/images/sub-menu-color.PNG"/>); margin-left: 166px; cursor: pointer; font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px; font-weight: bold; padding-top: 7px; color: #004695; width: 155px; height: 23px; padding-left: 10px;">
				<a style="text-decoration: none; color: white;">Details</a>
			</div>
		</div>
	</div>
	<div id="salaryFrequencyRegistrationForm"
		style="overflow: scroll; height: 570px; width: 940px; font-size: 12px; margin-left: 405px;">
		<form action="../organizationRegistration.do" method="post">
			<table style="width: 100%;">
				<tr class="rh">
					<td colspan="4">Salary Frequency Registration</td>
				</tr>
				<tr>
					<td>Enter Salary Frequency Name:</td>
					<td><input type="text" name="salaryFrequencyName" id="salaryFrequencyName" size="20"></td>
					<td>Description</td>
					<td><input type="text" name="salaryFrequencyDescription" id="salaryFrequencyDescription" size="20"></td>
				</tr>				
				<tr>					
					<td>Notes:</td>
					<td><input type="text" name="salaryFrequencyNotes" id="salaryFrequencyNotes" size="20" value="null"></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2">&nbsp;</td>
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="button"
						value="Register" onclick="addNewSalaryFrequency()"></td>
					<td colspan="2"><input type="reset" value="Reset"></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="salaryFrequencyDetails"
		style="overflow: scroll; height: 570px; width: 940px; font-size: 12px; margin-left: 405px;">
		<form action="../organizationRegistration.do" method="post">
			<table style="width: 100%;">
				<tr class="rh">
					<td colspan="4">Salary Frequency Details</td>
				</tr>
				<tr>
					<td>Enter Salary Frequency Name:</td>
					<td><input type="text" name="salaryFrequencyNameDisplay" id="salaryFrequencyNameDisplay" size="20"></td>
					<td>Description</td>
					<td><input type="text" name="salaryFrequencyDescriptionDisplay" id="salaryFrequencyDescriptionDisplay" size="20"></td>
				</tr>				
				<tr>					
					<td>Notes:</td>
					<td><input type="text" name="salaryFrequencyNotesDisplay" id="salaryFrequencyNotesDisplay" size="20" value="null"></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2">&nbsp;</td>
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="button"
						value="Update" class="updateSalaryFrequecny"
						onclick="updateSalaryFrequency(this.id)" /><input type="button"
						value="Delete" class="deleteSalaryFrequency"
						onclick="deleteSalaryFrequency(this.id)" /></td>
					<td colspan="2"><input type="reset" value="Reset"></td>
				</tr>
			</table>
		</form>
	</div>
</div>