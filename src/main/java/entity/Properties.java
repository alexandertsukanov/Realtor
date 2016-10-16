package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by alex on 10/15/16.
 */
@Entity
@Table(name = "properties", schema = "realtor", catalog = "postgres")
public class Properties implements Serializable {
    private long id;
    private long ownerId;
    private String name;
    private Owners ownersByOwnerId;
    private Collection<Visitors> visitorsesById;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "owner_id")
    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Properties that = (Properties) o;

        if (id != that.id) return false;
        if (ownerId != that.ownerId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (ownerId ^ (ownerId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Owners getOwnersByOwnerId() {
        return ownersByOwnerId;
    }

    public void setOwnersByOwnerId(Owners ownersByOwnerId) {
        this.ownersByOwnerId = ownersByOwnerId;
    }

    @OneToMany(mappedBy = "propertiesByReservedProperty")
    public Collection<Visitors> getVisitorsesById() {
        return visitorsesById;
    }

    public void setVisitorsesById(Collection<Visitors> visitorsesById) {
        this.visitorsesById = visitorsesById;
    }
}
