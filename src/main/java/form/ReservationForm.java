package form;

import entity.Properties;
import entity.Visitors;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by alex on 10/16/16.
 */
public class ReservationForm {

    private String firstName;
    private String secondName;
    private String middleName;
    private String phone;
    private long reservedProperty;
    private Time reservedTime;
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

    public Time getReservedTime() {
        return reservedTime;
    }

    public void setReservedTime(Time reservedTime) {
        this.reservedTime = reservedTime;
    }

    public Properties getPropertiesByReservedProperty() {
        return propertiesByReservedProperty;
    }

    public void setPropertiesByReservedProperty(Properties propertiesByReservedProperty) {
        this.propertiesByReservedProperty = propertiesByReservedProperty;
    }
}
