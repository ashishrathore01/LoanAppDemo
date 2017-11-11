<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<!-- <link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="css/data-table.css" /> -->


<script src="<c:url value="/resources/js/first.js"/>"></script>
<script src="<c:url value="/resources/js/data-table.js"/>"></script>
<script src="<c:url value="/resources/js/datatable-jquery.js"/>"></script>

<link href="<c:url value="/resources/css/jquery-ui.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/data-table.css"/>" rel="stylesheet">

<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>
</head>

<body>
	<table id="example" class="display" style="width: 1190px;">
		<thead>
			<tr>
				<!-- <th>Select</th> -->
				<th>First Name</th>
				<th>Middle Name</th>
				<th>Last Name</th>
				<th>Date of Birth</th>
				<th>License</th>
				<th>Expiry</th>
				<th>Province</th>
				<th>Phone</th>
				<th>Address</th>
				<th>Bank Name</th>
				<th>Branch Name</th>
				<th>Institute Number</th>
				<th>Account Number</th>
				<th>Bank Address</th>
				<th>Employer Name</th>
				<th>Employer Phone</th>
				<th>Supervisor Phone</th>
				<th>Salary Frequency</th>
				<th>Employer Address</th>
			</tr>
		</thead>		
		<tbody>
			<c:forEach items="${customerList}" var="customer">
				<tr>
					<td>${customer.firstName}</td>
					<td>${customer.middleName}</td>
					<td>${customer.lastName}</td>
					<td>${customer.dob}</td>
					<td>${customer.license}</td>
					<td>${customer.expiry}</td>
					<td>${customer.province}</td>
					<td>${customer.phone}</td>
					<td>${customer.address}</td>
					<td>${customer.bankName}</td>
					<td>${customer.branchName}</td>
					<td>${customer.instituteNumber}</td>
					<td>${customer.accountNumber}</td>
					<td>${customer.bankAddress}</td>
					<td>${customer.employerName}</td>
					<td>${customer.employerPhone}</td>
					<td>${customer.supervisorPhone}</td>					
					<td>${customer.salaryFrequency}</td>
					<td>${customer.employerAddress}</td>					
				</tr>
				
			</c:forEach>
			<!-- <tr>
					<td>Ashish</td>
					<td>kumar</td>
					<td>Rathore</td>
				</tr>
				<tr>
					<td>Ram</td>
					<td>Singh</td>
					<td>CHopra</td>
				</tr>
				<tr>
					<td>ram</td>
					<td>singh</td>
					<td>chopra</td>
				</tr> -->
		</tbody>
	</table>
</body>
</html>