<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 4/21/2023
  Time: 9:42 PM
  To change this template use File | Settings | File Templates.
--%>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"/>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="cssfile.css" type="text/css" />
    <link rel="stylesheet" href="css/displaytag.css" type="text/css" />
    <link rel="stylesheet" href="css/screen.css" type="text/css" />
    <link rel="stylesheet" href="css/site.css" type="text/css" />
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
            border: 1px solid  #29375A;
            text-align: left;
            padding: 8px;
        }

        thead{
            background-color:  #29375A;
            color: white;
            font-family: 'Quicksand', sans-serif;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div id="layout"style="width: 100vw; height:100vh;display: flex;flex-direction: column;">
    <div id="banner" style="display: flex; flex-direction: column; width: 98%">
        <div class="bannerlogo" style="background-color: #218789;"></div>
        <div class="text_header" style="color: #29375A;font-family: 'Quicksand', sans-serif;">RCA Management Information System</div>
        <div class="right" style="text-align:right; background-color: #29375A;width:100%; height:40vh;  ">
            <c:if test="${authenticatedUser !=null}">
                <b> <a
                        href="liststudents.php?page=profile&&id=${authenticatedUser.id}"><button>Profile
                </button></a> | <img src="icons/cou.png" /> <font color="#ffffff">${authenticatedUser.userRole}:
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
        <%@ include file="menu.jsp"%>
    </div>
    <div id="middle">
        <c:if test="${authenticatedUser !=null}">
            <div class="options">

                <a href="createstudent.php?page=createstudent"><button style="">
                    <p>New Registration</p>
                </button></a>
            </div>
<%--            <div class="search">--%>
<%--                <form action="liststudents.php" method="get">--%>
<%--                    <table>--%>
<%--                        <tr>--%>
<%--                            <td style="color: #000000;">Enter Marks ID</td>--%>
<%--                            <td><input type="text" name="id" id="id" /></td>--%>
<%--                            <td><input type='submit' name="marksSearch"--%>
<%--                                       value='search' /></td>--%>
<%--                        </tr>--%>
<%--                    </table>--%>
<%--                </form>--%>
<%--            </div>--%>
<%--            <hr />--%>
            <table style="">
<%--                <td align="left"><input type="text" size="15"--%>
<%--                                        maxlength="50" readonly="readonly" name="savedBy" id="savedBy"--%>
<%--                                        hidden="hidden" value="${authenticatedUser.id}" /></td>--%>


                <table>
                    <thead>
                    <tr>
                        <td>Id</td>
                        <td>First name</td>
                        <td>Last name</td>
                        <td>PhoneNumber</td>
                        <td>Date of Birth</td>
                        <td>International</td>
                        <td>Part time</td>
                        <td>Repeating</td>
<%--                        <td>Address</td>--%>

                            <%--              <td>isCancelled</td>--%>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${students}" var="sdt" varStatus="usrstatus">
                        <tr>
                            <td>${sdt.id}</td>
                            <td>${sdt.firstName}</td>
                            <td>${sdt.lastName}</td>
                            <td>${std.phoneNumber}</td>
                            <td>${std.DateOfBirth}</td>
                            <td>${std.isInternational}</td>
                            <td>${std.isPartTime}</td>
                            <td>${std.isRepeating}</td
<%--                            <td>${std.address_id}</td--%>

                                <%--                <td>${csr.isCancelled}</td>--%>
                            <td><input type="checkbox" name="usrIds"
                                       value="${usr.id}" /></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </table>
        </c:if>
    </div>
<%@ include file="footer.jsp"%>