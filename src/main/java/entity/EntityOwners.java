package entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by alex on 10/15/16.
 */
@Entity
@Table(name = "owners", schema = "realtor", catalog = "postgres")
public class EntityOwners {
    private long id;
    private String firstName;
    private String secondName;
    private Collection<EntityProperties> propertiesById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityOwners that = (EntityOwners) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (secondName != null ? !secondName.equals(that.secondName) : that.secondName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "ownersByOwnerId")
    public Collection<EntityProperties> getPropertiesById() {
        return propertiesById;
    }

    public void setPropertiesById(Collection<EntityProperties> propertiesById) {
        this.propertiesById = propertiesById;
    }
}
