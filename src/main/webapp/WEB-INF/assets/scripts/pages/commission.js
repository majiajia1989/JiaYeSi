var Commission = function() {
	var initSelect = function(result) {
		changChild($("#type").val(), result);
		$("#type").change(function() {
			changChild($(this).val(), result);
		});
		$("#template").change(function() {
			var contentStr = $(this).find("option:selected").text();
			$("#content").val(contentStr);
		});
	}
	
	var changChild = function(id, result) {
		$("#template").html("");
		$("#template").append("<option value=''>请选择</option>");
		if(result.length!=0){
			for (var i = 0; i < result.length; i++) {
				if (result[i].id == id) {
					var childResult = result[i].children;
					if(childResult.length!=0){
						for (var i = 0; i < childResult.length; i++) {
							$("#template").append(
									"<option value='" + childResult[i].id + "'>"
											+ childResult[i].text + "</option>");
						}
					}
					
				}
			}
		}
	}
	return {
		init : function(result) {
			initSelect(result);
		},
		commissionSubmit:function(){
			if($('#commission-form').valid()){
				$('#commission-form').submit();
			}	
		},
		returnBack:function(ctxUrl){
			var url=ctxUrl+"/community/service";
			window.location.href = url; 
		}
	}
}();