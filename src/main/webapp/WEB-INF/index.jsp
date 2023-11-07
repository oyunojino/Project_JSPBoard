<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <style>
        table{
            width: 60%;
            border-collapse: collapse;
        }
        th{
            border-bottom: 1px solid;
            border-bottom: 2px solid;
        }
        td{
            text-align: center;
            padding: 7px 0 11px;
            border-bottom: 1px solid;
        }
    </style>
</head>
<body>
    <h1> Board</h1>
    <br/>
    <div class="container">
        <table class="table table-hover table table-striped">
            <tr>
                <th>seq</th>
                <th>Title</th>
                <th>Content</th>
                <th>Writer</th>
                <th>RegDate</th>
                <th>Cnt</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>

            <c:forEach items="${boardList}" var="board">
                <tr>
                    <td><a href="readView/${board.getSeq()}">${board.getSeq()}</a></td>
                    <td>${board.getTitle()}</td>
                    <td>${board.getContent()}</td>
                    <td>${board.getWriter()}</td>
                    <fmt:parseDate value="${ board.getRegDate() }" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${ parsedDateTime }" /></td>
                    <td>${board.getCnt()}</td>
                    <td><a href="updateView/${board.getSeq()}">수정</a></td>
                    <td><a href="delete/${board.getSeq()}">삭제</a></td>
                </tr>
            </c:forEach>
        </table>
        <br/>
        <a href="createView">새 글 작성</a>
    </div>

</body>
</html>