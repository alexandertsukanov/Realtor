package entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by alex on 10/15/16.
 */
@Entity
@Table(name = "visitors", schema = "realtor", catalog = "postgres")
public class Visitors {
    private long id;
    private String firstName;
    private String secondName;
    private String middleName;
    private String phone;
    private long reservedProperty;
    private Date reservedDate;
    private Properties propertiesByReservedProperty;

    @Id
    @SequenceGenerator(name = "visitors_id_seq", sequenceName = "visitors_id_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "visitors_id_seq")
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
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
    @Column(name = "reserved_date")
    public Date getReservedDate() {
        return reservedDate;
    }

    public void setReservedDate(Date reservedDate) {
        this.reservedDate = reservedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Visitors that = (Visitors) o;

        if (id != that.id) return false;
        if (reservedProperty != that.reservedProperty) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (secondName != null ? !secondName.equals(that.secondName) : that.secondName != null) return false;
        if (middleName != null ? !middleName.equals(that.middleName) : that.middleName != null) return false;
        if (reservedDate != null ? !reservedDate.equals(that.reservedDate) : that.reservedDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (int) (reservedProperty ^ (reservedProperty >>> 32));
        result = 31 * result + (reservedDate != null ? reservedDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "reserved_property", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Properties getPropertiesByReservedProperty() {
        return propertiesByReservedProperty;
    }

    public void setPropertiesByReservedProperty(Properties propertiesByReservedProperty) {
        this.propertiesByReservedProperty = propertiesByReservedProperty;
    }
}
