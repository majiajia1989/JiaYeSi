var Consume = function() {
	var initSelect = function() {
	     var year = new Date().getFullYear();//获取year
	     var month = new Date().getMonth()+1;//获取month
	     
	     for(var i = 0; i < 12; i++)
	    {
	    	 if (month ==0)
	    		 {
	    		 	year = year - 1;
	    		 	month = 12;  		 
	    		 }
			 if (month<10)
				 {
				 	month = "0" + month;
				 }
			 var j = "" + year + "年" + month + "月";
			 var k = "" + year + month;
			 month = month - 1;
			 if (i == 0)
				 {
				 	$("#month").append('<option selected="true" value="'+k+'">'+j+'</option>');
				 }
			 else
				 {
				 	$("#month").append('<option value="'+k+'">'+j+'</option>');
				 } 
	    }
		 $("#month").selectmenu('refresh', true); 	     
	}

	return {
		init : function() {
			initSelect();
//			$('#consumeID').change(function()
//					{
//						$(document).attr("title",$("#consumeID").find("option:selected").text()+"信息");
//						//$("#title").html($("#consumeID").find("option:selected").text()+"信息查询");
//					});
		},
		submit : function(){
			$("#name").val($("#consumeID").find("option:selected").text());
			$("#consume-form").submit();
		}
	}
}();