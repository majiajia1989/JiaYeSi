var Complaint = function() {
	var handleInit = function() {
		$("#submit-btn").bind("click", function() {
					if ($('#complaint-form').valid()) {
						$('#complaint-form').submit();
					}
				});
	}

	return {
		init : function() {
			handleInit();
		}
	}
}();