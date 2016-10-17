<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>


    <h2>Properties list</h2>
    <c:forEach var="property" items="${property}">

        <div class="propertylist">

            <ul>
            <li>Property name: ${property.name}</li>
            <li>Owner: ${property.ownersByOwnerId.firstName} ${property.ownersByOwnerId.secondName}</li>
                <a href="reservation/${property.id}">
                    <li class="button">Make reservation</li>
                </a>
            </ul>
        </div>

    </c:forEach>


</div>