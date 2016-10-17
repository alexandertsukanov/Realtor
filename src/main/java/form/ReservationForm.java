package form;

import entity.Properties;
import entity.Visitors;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;

/**
 * Created by alex on 10/16/16.
 */
public class ReservationForm {


    @NotNull
    @Size(min = 2, max = 15)
    private String firstName;
    @NotNull
    @Size(min = 2, max = 15)
    private String secondName;
    @NotNull
    @Size(min = 2, max = 15)
    private String middleName;
    @NotNull
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @Size(min = 2, max = 15)
    private String phone;
    private long reservedProperty;
    @NotNull
    @DateTimeFormat
    private Date reservedDate;
    private Properties propertiesByReservedProperty;


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public long getReservedProperty() {
        return reservedProperty;
    }

    public void setReservedProperty(long reservedProperty) {
        this.reservedProperty = reservedProperty;
    }

    public Date getReservedDate() {
        return reservedDate;
    }

    public void setReservedDate(Date reservedDate) {
        this.reservedDate = reservedDate;
    }

    public Properties getPropertiesByReservedProperty() {
        return propertiesByReservedProperty;
    }

    public void setPropertiesByReservedProperty(Properties propertiesByReservedProperty) {
        this.propertiesByReservedProperty = propertiesByReservedProperty;
    }
}
