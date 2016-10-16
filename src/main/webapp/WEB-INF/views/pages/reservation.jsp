<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<div>

    <h2>Reservation</h2>

    <div class="reservation">


        <sf:form method="post" commandName="ReservationForm">

            <p>Firstname</p>
            <sf:input type="text" path="firstName"></sf:input>
            <p>Secondname</p>
            <sf:input  type="text" path="secondName"></sf:input>
            <p>Middlename</p>
            <sf:input  type="text" path="middleName"></sf:input>
            <p>Phone</p>
            <sf:input type="text" path="phone"></sf:input>
            <p>Date</p>
            <sf:input type="datetime-local" path="reservedTime"></sf:input>

            <input type="submit" value="Submit">

        </sf:form>
    </div>

</div>