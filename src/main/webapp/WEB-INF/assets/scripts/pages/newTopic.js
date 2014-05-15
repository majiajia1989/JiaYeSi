var Topic = function() {
	var handleInit = function(url) {
		$("#btn-ok").on("click", function() {
			var form = $(".topic-form");
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