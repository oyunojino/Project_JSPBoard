<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<body>
<h1>Read</h1>
    <table >
        <tr>
            <td>seq : </td>
            <td>${board.seq}</td>
        </tr>
        <tr>
            <td>Title : </td>
            <td>${board.title}</td>
        </tr>
        <tr>
            <td>Content : </td>
            <td>${board.content}</td>
        </tr>
        <tr>
            <td>Writer : </td>
            <td>${board.writer}</td>
        </tr>
        <tr>
            <td>RegDate : </td>
            <td>${board.regDate}</td>
        </tr>
        <tr>
            <td>Cnt : </td>
            <td>${board.cnt}</td>
        </tr>
        <tr>
            <td><a href="/updateView/${board.seq}">수정</a></td>
            <td><a href="/delete/${board.seq}">삭제</a></td>
        </tr>
    </table>
</body>
</html>
