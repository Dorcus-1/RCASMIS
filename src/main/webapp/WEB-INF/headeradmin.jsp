<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="cssfile.css" type="text/css" />
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500&display=swap" rel="stylesheet">

	<title>${param.title}</title>
</head>
<body>
	<div id="layout"style="width: 100vw; height:100vh;display: flex;flex-direction: column;">
		<div id="banner" style="display: flex; flex-direction: column; width: 98%">
			<div class="text_header" style="color: #29375A;display:flex;align-items:flex-end; font-family: 'Quicksand', sans-serif; width:100% ">
				<div class="bannerlogo" style="background-color: #218453; height: 80px;background-image: url('https://media.licdn.com/dms/image/C560BAQEl6a9tUkSKfg/company-logo_200_200/0/1558604414993?e=2147483647&amp;v=beta&amp;t=liCSw94UkEjwbMZZh8N23ZMYixEAMmZNq2IftvsF97Y');background-size: cover;background-position: center; background-repeat: no-repeat;"" ></div>
				RCA Management Information System</div>
			<div class="right" style="text-align:right; background-color: #29375A;width:100%; height:40vh;  ">
				<c:if test="${authenticatedUser !=null}">
					<b><a href="listuser.php?page=profile&&id=${authenticatedUser.id}"><button>Profile
						</button></a> | <img src="icons/user.png" /> <font color="#ffffff" style="font-family: 'Quicksand', sans-serif;">${authenticatedUser.fullName}</font>
						| <a href="login.php?logout=logout"><font color="#ffffff" style="font-family: 'Quicksand', sans-serif;">Logout</font></a>
					</b>
				</c:if>
				<c:if test="${authenticatedUser ==null}">
					<div class="menu" align="left">
						| <a href="login.php?"><font color="#ffffff" style="font-family: 'Quicksand', sans-serif;">Login</font></a> |
					</div>
				</c:if>
			</div>

		</div>

		<%@ include file="menu.jsp"%>