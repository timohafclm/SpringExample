package example.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    private Integer contactId;

    @OneToMany(mappedBy = "contactId",cascade = CascadeType.ALL)
    private Set<Application> applications;

    public Contact() {
    }

    public Contact(Integer contactId) {
        this.contactId = contactId;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }
}
