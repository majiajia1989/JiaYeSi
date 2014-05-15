var EditMyprofile = function() {
	var handleInit = function(url) {
		$("#btn-update").bind("click", function() {
			var form = $(".registe-form");
			if (form.valid()) {
				form.submit();
			}
		});
	}
	return {
		init : function(url) {
			handleInit(url);
		}
	}
}();