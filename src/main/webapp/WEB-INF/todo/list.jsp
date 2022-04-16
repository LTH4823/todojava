<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/WEB-INF/includes/header.jsp" %>

<div class="list-group">
    <a href="#" class="list-group-item list-group-item-action active" aria-current="true"> List </a>
    <a href="/todo/read?tno=123" class="list-group-item list-group-item-action">Read Test</a>
</div>

<ul>

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

<a href="/todo/add">TodoAdd</a>
<%@ include file="/WEB-INF/includes/footer.jsp" %>