<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>


    <h2>Properties</h2>
    <c:forEach var="property" items="${property}">

        <div class="propertylist">

            <ul>
            <li>Property name: ${property.name}</li>
            <li>Owner: ${property.ownersByOwnerId.firstName} ${property.ownersByOwnerId.secondName}</li>
            <li class="button">Make reservation</li>
            </ul>
        </div>

    </c:forEach>


</div>