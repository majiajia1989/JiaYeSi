document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
			WeixinJSBridge.call('hideOptionMenu');
			WeixinJSBridge.call('hideToolbar');
		});
$(document).on("mobileinit", function() {
			$.extend($.mobile, {
						ajaxLinksEnabled : false,
						ajaxFormsEnabled : false,
						ajaxEnabled : false
					});
		});
var App = function() {
	// handle form validate
	var handleFormValidate = function() {
		var $from = $("form.form-validate");
		if ($from.length > 0) {
			$from.each(function() {
				$(this).validate({
					ignore : ".ignore-validate",
					highlight : function(element) {
						$(element).closest('.form-group').addClass('has-error');
					},
					unhighlight : function(element) {
						$(element).closest('.form-group')
								.removeClass('has-error');
					},
					errorElement : 'span',
					errorClass : 'help-block',
					errorPlacement : function(error, element) {
						if (element.parent('.input-group').length) {
							error.insertAfter(element.parent());
						} else {
							error.insertAfter(element);
						}
					},
					submitHandler : function(form) {
						form.submit();
					}
				});
			});
		}
	}
	var toolbarStyleInit = function() {
		$(".box").each(function(index, element) {
			$(this)
					.css(
							"width",
							$(".box").length == 0 ? "" : ((1
									/ Math
											.round(parseInt($(".box").length,
													10)) * 100))
									+ "%");
		});
	};

	var showToast = function(msg) {
		var toastDiv = $('div[data-toast=true]');
		if (toastDiv.length < 1) {
			toastDiv = $('<div data-role="popup" data-toast="true"></div>');
			toastDiv.html("<p>没有更多了</p>");
			$('body').append(toastDiv);
			toastDiv.popup({
						positionTo : "window"
					});
		}
		if (typeof(msg) != 'undefined') {
			toastDiv.html('<p>' + msg + '</p>');
		}
		toastDiv.popup("open");
		setTimeout(function() {
					toastDiv.popup("close");
				}, 1000);
	};

	var successPage = function(backUrl) {
		setTimeout(function() {
					if (typeof(backUrl)=='string'  && backUrl.length > 0) {
						location.href = backUrl;
					} else {
						history.go(-2);
					}

				}, 3000);
	};

	var errorPage = function(backUrl) {
		setTimeout(function() {
					if (typeof(backUrl)=='string'  && backUrl.length > 0) {
						location.href = backUrl;
					} else {
						history.back();
					}

				}, 3000);
	};

	return {
		init : function() {
			handleFormValidate();
			// toolbarStyleInit();
		},
		toast : function(msg) {
			showToast(msg);
		},
		success : function(backUrl) {
			successPage(backUrl);
		},
		error : function(backUrl) {
			errorPage(backUrl);
		}
	}
}();