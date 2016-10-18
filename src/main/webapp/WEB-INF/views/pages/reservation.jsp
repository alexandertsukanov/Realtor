<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>

    <div class="reservationlist">

        <h2>Reserved time for this property</h2>
        <c:forEach var="visitor" items="${visitor}">

            <p>${visitor.reservedDate}</p>

        </c:forEach>

    </div>

    <h2>Create reservation</h2>

    <div class="reservation">

        <sf:form method="post" commandName="ReservationForm">

            <p>Firstname</p>
            <sf:input type="text" path="firstName"></sf:input>
            <sf:errors path="firstName" element="div" cssClass="error"/>
            <p>Secondname</p>
            <sf:input  type="text" path="secondName"></sf:input>
            <sf:errors path="secondName" element="div" cssClass="error"/>
            <p>Middlename</p>
            <sf:input  type="text" path="middleName"></sf:input>
            <sf:errors path="middleName" element="div" cssClass="error"/>
            <p>Phone</p>
            <sf:input type="text" path="phone"></sf:input>
            <sf:errors path="phone" element="div" cssClass="error"/>
            <p>Date(YYYY-MM-DD HH:MM)</p>
            <sf:input type="text" path="reservedDate"></sf:input>
            <sf:errors path="reservedDate" element="div" cssClass="error"/>
            <p class="error">${error}</p>

            <p class="success">${success}</p>
            <input type="submit" value="Submit">
        </sf:form>


    </div>


</div>