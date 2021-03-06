package ae.rta.dls.backend.domain.sct;

import ae.rta.dls.backend.domain.AbstractAuditingEntity;
import ae.rta.dls.backend.domain.enumeration.trn.ServiceGroupStatus;
import ae.rta.dls.backend.domain.util.MultilingualJsonConverter;
import ae.rta.dls.backend.domain.type.MultilingualJsonType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * The Service Group entity.
 * @author Tariq Abu Amireh
 */
@ApiModel(description = "The Service Group entity. @author Tariq Abu Amireh")
@Entity
@Table(name = "sct_service_group")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ServiceGroup extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "segrSequenceGenerator")
    @SequenceGenerator(name = "segrSequenceGenerator", sequenceName = "segr_seq", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @NotNull
    @Column(name = "name", nullable = false)
    //@Convert(converter = MultilingualJsonConverter.class)
    @Type(type = "json")
    private MultilingualJsonType name;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ServiceGroupStatus status;

    @OneToMany(mappedBy = "serviceGroup")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Service> services = new HashSet<>();
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public ServiceGroup code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public MultilingualJsonType getName() {
        return name;
    }

    public ServiceGroup name(MultilingualJsonType name) {
        this.name = name;
        return this;
    }

    public void setName(MultilingualJsonType name) {
        this.name = name;
    }

    public ServiceGroupStatus getStatus() {
        return status;
    }

    public ServiceGroup status(ServiceGroupStatus status) {
        this.status = status;
        return this;
    }

    public void setStatus(ServiceGroupStatus status) {
        this.status = status;
    }

    public Set<Service> getServices() {
        return services;
    }

    public ServiceGroup services(Set<Service> services) {
        this.services = services;
        return this;
    }

    public ServiceGroup addService(Service service) {
        this.services.add(service);
        service.setServiceGroup(this);
        return this;
    }

    public ServiceGroup removeService(Service service) {
        this.services.remove(service);
        service.setServiceGroup(null);
        return this;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ServiceGroup serviceGroup = (ServiceGroup) o;
        if (serviceGroup.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), serviceGroup.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ServiceGroup{" +
            "id=" + getId() +
            ", code=" + getCode() +
            ", name='" + getName() + "'" +
            ", status=" + getStatus() +
            "}";
    }
}
