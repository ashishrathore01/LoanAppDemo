$('.message a').click(function(){
   $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
});

function userRegistration() {	
	$(".register-form").show();
	$(".login-form").hide();
}

function userLogin() {		
	$(".register-form").hide();
	$(".login-form").show();
}
