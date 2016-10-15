package entity;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by alex on 10/15/16.
 */
@Entity
@Table(name = "visitors", schema = "realtor", catalog = "postgres")
public class EntityVisitors {
    private long id;
    private String firstName;
    private String secondName;
    private String middleName;
    private long reservedProperty;
    private Time reservedTime;
    private EntityProperties propertiesByReservedProperty;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "second_name")
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Basic
    @Column(name = "middle_name")
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Basic
    @Column(name = "reserved_property")
    public long getReservedProperty() {
        return reservedProperty;
    }

    public void setReservedProperty(long reservedProperty) {
        this.reservedProperty = reservedProperty;
    }

    @Basic
    @Column(name = "reserved_time")
    public Time getReservedTime() {
        return reservedTime;
    }

    public void setReservedTime(Time reservedTime) {
        this.reservedTime = reservedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityVisitors that = (EntityVisitors) o;

        if (id != that.id) return false;
        if (reservedProperty != that.reservedProperty) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (secondName != null ? !secondName.equals(that.secondName) : that.secondName != null) return false;
        if (middleName != null ? !middleName.equals(that.middleName) : that.middleName != null) return false;
        if (reservedTime != null ? !reservedTime.equals(that.reservedTime) : that.reservedTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (int) (reservedProperty ^ (reservedProperty >>> 32));
        result = 31 * result + (reservedTime != null ? reservedTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "reserved_property", referencedColumnName = "id", nullable = false)
    public EntityProperties getPropertiesByReservedProperty() {
        return propertiesByReservedProperty;
    }

    public void setPropertiesByReservedProperty(EntityProperties propertiesByReservedProperty) {
        this.propertiesByReservedProperty = propertiesByReservedProperty;
    }
}
