<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/WEB-INF/includes/header.jsp"%>

<ul>
    <h2>${loginInfo}</h2>
    <h3>${loginInfo.mname}</h3>
    <c:forEach items="${dtoList}" var="dto">
        <li>
            <span><a href="/todo/read?tno=${dto.tno}">${dto.tno}</a></span>
            <span>${dto.title}</span>
            <span>${dto.dueDate}</span>
            <span>${dto.finished? "DONE": "NOT YET"}</span>
        </li>
    </c:forEach>
</ul>

<form action="/logout" method="post">
    <button>LOGOUT</button>
</form>

<%@ include file="/WEB-INF/includes/footer.jsp"%>