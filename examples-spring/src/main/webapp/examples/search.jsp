<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>动画搜索框</title>
	<%@ include file="../commons/common.jsp"%>
	<link rel="stylesheet" href="../styles/search.css" media="screen" type="text/css" />
</head>
<body>
	<h1>CSS Animated Search Boxes</h1>
	<p>(with occasional help from javascript to assign focus)</p>
	<div class="sample one">
		<input type="text" name="search" placeholder="search">
		<button type="submit" class="btn btn-search fa fa-search"></button>
	</div>
	<div class="sample two">
		<input type="text" name="search" placeholder="search">
		<button type="submit" class="btn btn-search fa fa-search"></button>
		<button type="reset" class="btn btn-reset fa fa-times"></button>
	</div>
	<div class="sample three">
		<input type="text" name="search" placeholder="search">
		<button type="submit" class="btn btn-search">
			<i class="fa fa-search fa-flip-horizontal"></i>
		</button>
	</div>
	<div class="sample four">
		<input type="text" name="search" placeholder="search">
		<button type="submit" class="btn btn-search">
			<i class="fa fa-search fa-flip-horizontal"></i>
		</button>
		<button type="reset" class="btn btn-reset fa fa-times"></button>
	</div>
	<div class="sample five">
		<input type="text" name="search" placeholder="search">
		<button type="submit" class="btn btn-search">
			<i class="fa fa-search fa-flip-horizontal"></i>
		</button>
	</div>
	<div class="sample six">
		<input type="text" name="search" placeholder="search">
		<button type="submit" class="btn btn-search">
			<i class="fa fa-search fa-flip-horizontal"></i>
		</button>
		<button type="reset" class="btn btn-reset fa fa-times"></button>
	</div>
	<div class="sample seven">
		<input type="text" name="search" placeholder="search">
		<button type="submit" class="btn btn-search">
			<i class="fa fa-search"></i>
		</button>
	</div>
	<div class="sample eight">
		<input type="text" name="search" placeholder="search">
		<button type="submit" class="btn btn-search">
			<i class="fa fa-search"></i>
		</button>
		<button type="reset" class="btn btn-reset fa fa-times"></button>
	</div>
	<div class="sample nine">
		<input type="text" name="search" placeholder="search">
		<button type="submit" class="btn btn-search">
			<i class="fa fa-search"></i>
		</button>
	</div>
	<div class="sample ten">
		<input type="text" name="search" placeholder="search">
		<button type="submit" class="btn btn-search">
			<i class="fa fa-search"></i>
		</button>
		<button type="reset" class="btn btn-reset fa fa-times"></button>
	</div>
	<div class="sample eleven">
		<input type="text" name="search" placeholder="search">
		<button type="submit" class="btn btn-search">
			<i class="fa fa-search"></i>
		</button>
	</div>
	<div class="sample twelve">
		<input type="text" name="search" placeholder="search">
		<button type="submit" class="btn btn-search">
			<i class="fa fa-search"></i>
		</button>
		<button type="reset" class="btn btn-reset fa fa-times"></button>
	</div>
	<div class="sample thirteen">
		<input type="text" name="search" placeholder="search">
		<button type="submit" class="btn btn-search">
			<i class="fa fa-search"></i>
		</button>
	</div>
	<div class="sample fourteen">
		<input type="text" name="search" placeholder="search">
		<button type="submit" class="btn btn-search">
			<i class="fa fa-search"></i>
		</button>
		<button type="reset" form="form" class="btn btn-reset fa fa-times">
		</button>
	</div>
	<script src="../js/jquery-2.2.2/jquery-2.2.2.min.js"></script>
	<script>
		$('body').on('click', 'div.three button.btn-search', function(event) {
			event.preventDefault();
			var $input = $('div.three input');
			$input.focus();
			if ($input.val().length() > 0) {
				// submit form
			}
		}).on('click', 'div.four button.btn-search', function(event) {
			event.preventDefault();
			var $input = $('div.four input');
			$input.focus();
			if ($input.val().length() > 0) {
				// submit form
			}
		}).on('click', 'div.five button.btn-search', function(event) {
			event.preventDefault();
			var $input = $('div.five input');
			$input.focus();
			if ($input.val().length() > 0) {
				// submit form
			}
		}).on('click', 'div.six button.btn-search', function(event) {
			event.preventDefault();
			var $input = $('div.six input');
			$input.focus();
			if ($input.val().length() > 0) {
				// submit form
			}
		}).on('click', 'div.seven button.btn-search', function(event) {
			event.preventDefault();
			var $input = $('div.seven input');
			$input.focus();
			if ($input.val().length() > 0) {
				// submit form
			}
		}).on('click', 'div.eight button.btn-search', function(event) {
			event.preventDefault();
			var $input = $('div.eight input');
			$input.focus();
			if ($input.val().length() > 0) {
				// submit form
			}
		}).on('click', 'div.thirteen button.btn-search', function(event) {
			event.preventDefault();
			var $input = $('div.thirteen input');
			$input.focus();
			if ($input.val().length() > 0) {
				// submit form
			}
		}).on('click', 'div.fourteen button.btn-search', function(event) {
			event.preventDefault();
			var $input = $('div.fourteen input');
			$input.focus();
			if ($input.val().length() > 0) {
				// submit form
			}
		}); //@ sourceURL=pen.js
	</script>
</body>
</html>
