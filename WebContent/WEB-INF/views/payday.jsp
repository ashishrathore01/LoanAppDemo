<div id="paydaySection">
	<div class="newRequest"
		style="height: 29px; background-image: url(<c:url value="/resources/images/sub-menu-color.PNG"/>); margin: auto; width: auto; border: 1px solid; margin-left: 403px;">
		<div id="employeeSubMenu">
			<div id="paydayRegistrationMenu" onclick="showInputForm()"
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
			<div id="paydayDetailsMenu" onclick="showManagementVar()"
				style="background-image: url(<c:url value="/resources/images/sub-menu-color.PNG"/>); margin-left: 166px; cursor: pointer; font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px; font-weight: bold; padding-top: 7px; color: #004695; width: 155px; height: 23px; padding-left: 10px;">
				<a style="text-decoration: none; color: white;">Details</a>
			</div>
		</div>
	</div>
	<div id="payday-registration-form"
		style="overflow: scroll; height: 570px; width: 940px; font-size: 12px; margin-left: 405px;">
		<form action="../organizationRegistration.do" method="post">
			<table style="width: 100%;">
				<tr class="rh">
					<td colspan="4">Payday Registration</td>
				</tr>				
				<tr>
					<td>Payday Name:</td>
					<td><input type="text" name="paydayName" id="paydayName" size="20"></td>
					<td>Min Amount:</td>
					<td><input type="text" name="minAmount" id="minAmount" size="20"></td>
				</tr>
				<tr>
					<td>Max Amount:</td>
					<td><input type="text" name="maxAmount" id="maxAmount" size="20"></td>
					<td>Interest Rate:</td>
					<td><input type="text" name="interestRate" id="interestRate" size="20"></td>
				</tr>
				<tr>
					<td>Max Loan Duration:</td>
					<td><input type="text" name="maxLoanDuration" id="maxLoanDuration" size="20"></td>
					<td>Cooling Of Period:</td>
					<td><input type="text" name="coolingOfPeriod" id="coolingOfPeriod" size="20"></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><input type="text" name="paydayDescription" id="paydayDescription" size="20"></td>
					<td>Notes:</td>
					<td><input type="text" name="paydayNotes" id="paydayNotes" size="20"></td>
				</tr>		
				<tr>
								<td colspan="2" align="right"><input type="button" onclick="addNewPayday()"
									value="Register"></td>
								<td colspan="2"><input type="reset" value="Reset"></td>
							</tr>		
			</table>
		</form>
	</div>
	<div id="payday-details"
		style="overflow: scroll; height: 570px; width: 940px; font-size: 12px; margin-left: 405px;">
		<form action="../organizationRegistration.do" method="post">
			<table style="width: 100%;">
				<tr class="rh">
					<td colspan="4">Payday Details</td>
				</tr>				
				<tr>
					<td>Payday Name:</td>
					<td><input type="text" name="paydayNameDisplay" id="paydayNameDisplay" size="20"></td>
					<td>Min Amount:</td>
					<td><input type="text" name="minAmountDisplay" id="minAmountDisplay" size="20"></td>
				</tr>
				<tr>
					<td>Max Amount:</td>
					<td><input type="text" name="maxAmountDisplay" id="maxAmountDisplay" size="20"></td>
					<td>Interest Rate:</td>
					<td><input type="text" name="interestRateDisplay" id="interestRateDisplay" size="20"></td>
				</tr>
				<tr>
					<td>Max Loan Duration:</td>
					<td><input type="text" name="maxLoanDurationDisplay" id="maxLoanDurationDisplay" size="20"></td>
					<td>Cooling Of Period:</td>
					<td><input type="text" name="coolingOfPeriodDisplay" id="coolingOfPeriodDisplay" size="20"></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><input type="text" name="paydayDescriptionDisplay" id="paydayDescriptionDisplay" size="20"></td>
					<td>Notes:</td>
					<td><input type="text" name="paydayNotesDisplay" id="paydayNotesDisplay" size="20"></td>
				</tr>	
				<tr>
					<td colspan="2">&nbsp;</td>
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="button"
						value="Update" class="updatePayday"
						onclick="updatePayday(this.id)" /><input type="button"
						value="Delete" class="deletePayday"
						onclick="deletePayday(this.id)" /></td>
					<td colspan="2"><input type="reset" value="Reset"></td>
				</tr>			
			</table>
		</form>
	</div>
</div>