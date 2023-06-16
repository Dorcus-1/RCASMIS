<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"/>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="cssfile.css" type="text/css"/>
    <link rel="stylesheet" href="css/displaytag.css" type="text/css"/>
    <link rel="stylesheet" href="css/screen.css" type="text/css"/>
    <link rel="stylesheet" href="css/site.css" type="text/css"/>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@300;400;500&display=swap" rel="stylesheet">
    <title>Student Registrations</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #29375A;
            text-align: left;
            padding: 8px;
        }

        thead {
            background-color: #29375A;
            color: white;
            font-family: 'Quicksand', sans-serif;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div id="layout" style="width: 100vw; height:100vh;display: flex;flex-direction: column;">
    <div id="banner" style="display: flex; flex-direction: column; width: 98%">
        <div class="bannerlogo" style="background-color: #218789;"></div>
        <div class="text_header" style="color: #29375A;font-family: 'Quicksand', sans-serif;">RCA Management Information
            System
        </div>
        <div class="right" style="text-align:right; background-color: #29375A;width:100%; height:40vh;  ">
            <c:if test="${authenticatedUser !=null}">
                <b> <a
                        href="liststudents.php?page=profile&&id=${authenticatedUser.id}">
                    <button>Profile
                    </button>
                </a> | <img src="icons/cou.png"/> <font color="#ffffff">${authenticatedUser.userRole}:
                        ${authenticatedUser.username}</font> | <a href="login.ap?page=logout"><font
                        color="#ffffff">Logout</font></a>
                </b>
            </c:if>
            <c:if test="${authenticatedUser ==null}">
                <div class="menu" align="left">
                    | <a href="login.php?" style="font-family: 'Quicksand', sans-serif;">Login</a> |
                </div>
            </c:if>
        </div>
    </div>
    <div>
        <%@ include file="menu.jsp" %>
    </div>
    <div id="middle">
        <c:if test="${authenticatedUser !=null}">
            <table>
                <thead>
                <tr>
                    <td>Id</td>
                    <td>Name</td>
                    <td>Email</td>
                    <td>Role</td>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="usr" varStatus="usrstatus">
                    <tr>
                        <td name="id">${usr.id}</td>
                        <td name="userfullname">${usr.fullName}</td>
                        <td name="email">${usr.email}</td>
                        <td name="role">${usr.userRole.getRoleDescription()}</td>

                            <%--                            <td>${std.address_id}</td--%>

                            <%--                <td>${csr.isCancelled}</td>--%>
                        <td><input type="checkbox" name="usrIds"
                                   value="${usr.id}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
<%@ include file="footer.jsp" %>