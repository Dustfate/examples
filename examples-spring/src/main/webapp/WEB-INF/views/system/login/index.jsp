<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../../../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>首页</title>
	<!-- Tell the browser to be responsive to screen width -->
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	<%@include file="../../../../AdminLTE-2.3.3/commons/head-css.jsp"%>
	
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<!-- Main Header -->
		<%@include file="main-header.jsp"%>
		
		<!-- Left side column. contains the logo and sidebar -->
		<%@include file="main-sidebar.jsp"%>

		<!-- Content Wrapper. Contains page content -->
		<iframe id="mainFrame" name="mainFrame" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" width="100%"
			src="${ctx }/menu/to_menu_list" ></iframe>
		<!-- /.content-wrapper -->

		<!-- Main Footer -->
		<%@include file="main-footer.jsp"%>
		
		<!-- Control Sidebar -->
		<%@include file="control-sidebar.jsp"%>
		<!-- /.control-sidebar -->
		
		
		<!-- Add the sidebar's background. This div must be placed immediately after the control sidebar -->
		<div class="control-sidebar-bg"></div>
	</div>
	<!-- ./wrapper -->

	<%@include file="../../../../AdminLTE-2.3.3/commons/footer-js.jsp"%>
	
	<script type="text/javascript">
	var browserVersion = window.navigator.userAgent.toUpperCase();
	var isOpera = browserVersion.indexOf("OPERA") > -1 ? true : false;
	var isFireFox = browserVersion.indexOf("FIREFOX") > -1 ? true : false;
	var isChrome = browserVersion.indexOf("CHROME") > -1 ? true : false;
	var isSafari = browserVersion.indexOf("SAFARI") > -1 ? true : false;
	var isIE = (!!window.ActiveXObject || "ActiveXObject" in window);
	var isIE9More = (! -[1, ] == false);
	
	var hi = 0;
	if (isFireFox == true){
		hi = document.body.clientHeight;
	}else if(isIE == true && isIE9More) {//ie9+
		hi = document.documentElement.clientHeight-100;
	}else if (isIE == false && isOpera == false){
		hi = document.documentElement.clientHeight-101;
	}
	//设置默认高度
	startInit('mainFrame', hi);
	
	function reinitIframe(iframeId, minHeight) {
	    try {
	        var iframe = document.getElementById(iframeId);
	        var bHeight = 0;
	        if (isChrome == false && isSafari == false){
	        	//bHeight = iframe.contentWindow.document.body.scrollHeight;
	        }
	        
	        var dHeight = 0;
	        if (isFireFox == true){
	            dHeight = iframe.contentWindow.document.documentElement.offsetHeight + 2;
	        }else if (isIE == false && isOpera == false){
	            dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
	        }else if (isIE == true && isIE9More) {//ie9+
	            var heightDeviation = bHeight - eval("window.IE9MoreRealHeight" + iframeId);
	            if (heightDeviation == 0) {
	                bHeight += 3;
	            } else if (heightDeviation != 3) {
	                eval("window.IE9MoreRealHeight" + iframeId + "=" + bHeight);
	                bHeight += 3;
	            }
	        } else{
	        	//ie[6-8]、OPERA
	            bHeight += 3;
	        }
	        var height = Math.max(bHeight, dHeight);
	        if (height < minHeight){
	        	height = minHeight;
	        }
	        iframe.style.height = height + "px";
	    } catch (ex) { 
	    	alert(ex);
	    }
	}
	
	function startInit(iframeId, minHeight) {
		alert(minHeight);
	    eval("window.IE9MoreRealHeight" + iframeId + "=0");
	    reinitIframe(iframeId, minHeight);
	}
	
	function iFrameHeight() {   
		var ifm= document.getElementById("mainFrame");
		var subWeb = document.frames ? document.frames["mainFrame"].document : ifm.contentDocument;   
		if(ifm != null && subWeb != null) {
		   ifm.height = subWeb.body.scrollHeight-500;
		   ifm.width = subWeb.body.scrollWidth+500;
		}   
	}
	
	function setIframeUrl(url){
		document.getElementById("mainFrame").src = url;
	}
	</script>
</body>
</html>
