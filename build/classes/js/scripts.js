function myFunction() {
    // Declare variables	
    var input, filter, ul, li, a, i;
    input = document.getElementById('myInput');
    filter = input.value.toUpperCase();
    ul = document.getElementById("table789");
    li = ul.getElementsByTagName('tr');

    // Loop through all list items, and hide those who don't match the search query
    for (i = 0; i < li.length; i++) {
        a = li[i].getElementsByTagName("td")[0];
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


function setEmployeeID() {
	$("#branchSection").hide();
	$("#employeeSection").show();
	$("#organizationSection").hide();	
	$("#mySubUL").empty();
	$("#mySubUL").append('<li><a href="#">ashish</a></li><li><a href="#">ravi</a></li><li><a href="#">arvindar</a></li><li><a href="#">rathore</a></li><li><a href="#">xyz</a></li><li><a href="#">abc</a></li>');
}

function setBranchID() {
	$("#branchSection").show();
	$("#employeeSection").hide();
	$("#organizationSection").hide();
	$("#mySubUL").empty();
	$("#mySubUL").append('<li><a href="#">branch1</a></li><li><a href="#">branch2</a></li><li><a href="#">branch3</a></li><li><a href="#">branch4</a></li><li><a href="#">branch5</a></li><li><a href="#">branch6</a></li>');
}

function setOrganizationID() {
	$("#branchSection").hide();
	$("#employeeSection").hide();
	$("#organizationSection").show();
	$("#mySubUL").empty();
	$("#mySubUL").append('<li><a href="#">organization1</a></li><li><a href="#">organization2</a></li><li><a href="#">organization3</a></li><li><a href="#">organization4</a></li><li><a href="#">organization5</a></li><li><a href="#">organization6</a></li>');
}