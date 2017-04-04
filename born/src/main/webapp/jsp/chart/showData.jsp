<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
	<title>Demo</title>
	<%@ include file="../common/common.jsp"%>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/jquery.jqplot.css" />
</head>

<body>

	<%@include file="../common/header.jsp" %>
	
	<%@include file="../common/leftLink.jsp" %>

    <div id="right_form">
    
    <div id="chartdiv" style="height:400px;width:750px; "></div>
            
    </div>
	
	<%@ include file="../common/footer.jsp"%>
</body>

	<script src="<%=request.getContextPath()%>/js/jquery-1.9.1.js"></script>
	<script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/jquery.jqplot.min.js"></script>
	<script class="code" type="text/javascript">
// 		$(document).ready(function(){
// 		  // Our data renderer function, returns an array of the form:
// 		  // [[[x1, sin(x1)], [x2, sin(x2)], ...]]
// 		  var sineRenderer = function() {
// 		    var data = [[]];
// 		    for (var i=0; i<13; i+=0.5) {
// 		      data[0].push([i, Math.sin(i)]);
// 		    }
// 		    return data;
// 		  };
// 		  // we have an empty data array here, but use the "dataRenderer"
// 		  // option to tell the plot to get data from our renderer.
// 		  var plot1 = $.jqplot('chartdiv',[],{
// 		      title: 'Demo',
// 		      dataRenderer: sineRenderer
// 		  });
// 		});

$(document).ready(function(){
  // Our ajax data renderer which here retrieves a text file.
  // it could contact any source and pull data, however.
  // The options argument isn't used in this renderer.
  var ajaxDataRenderer = function(url, plot, options) {
    var ret = null;
    $.ajax({
      // have to use synchronous here, else the function 
      // will return before the data is fetched
      async: false,
      url: url,
      dataType:"json",
      success: function(data) {
        ret = data;
      }
    });
    return ret;
  };

  // The url for our json data
  var jsonurl = "/chart/getRealTimeData";

  // passing in the url string as the jqPlot data argument is a handy
  // shortcut for our renderer.  You could also have used the
  // "dataRendererOptions" option to pass in the url.
  var plot2 = $.jqplot('chartdiv', jsonurl,{
    title: "Data Renderer",
    dataRenderer: ajaxDataRenderer,
    dataRendererOptions: {
      unusedOptionalUrl: jsonurl
    }
  });
});


	</script>
</html>