package entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by alex on 10/15/16.
 */
@Entity
@Table(name = "properties", schema = "realtor", catalog = "postgres")
public class EntityProperties {
    private long id;
    private long ownerId;
    private String name;
    private EntityOwners ownersByOwnerId;
    private Collection<EntityVisitors> visitorsesById;

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

        EntityProperties that = (EntityProperties) o;

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
    @JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = false)
    public EntityOwners getOwnersByOwnerId() {
        return ownersByOwnerId;
    }

    public void setOwnersByOwnerId(EntityOwners ownersByOwnerId) {
        this.ownersByOwnerId = ownersByOwnerId;
    }

    @OneToMany(mappedBy = "propertiesByReservedProperty")
    public Collection<EntityVisitors> getVisitorsesById() {
        return visitorsesById;
    }

    public void setVisitorsesById(Collection<EntityVisitors> visitorsesById) {
        this.visitorsesById = visitorsesById;
    }
}
