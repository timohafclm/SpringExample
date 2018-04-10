package example.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@Table(name = "applications")
public class Application {
    @Id
    @Column(name = "APPLICATION_ID")
    private String applicationId;

    @Column(name = "DT_CREATED")
    private Date dtCreated;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @ManyToOne
    @JoinColumn(name = "CONTACT_ID")
    private Contact contactId;

    public Application() {
    }

    public Application(String applicationId, Date dtCreated, String productName, Contact contactId) {
        this.applicationId = applicationId;
        this.dtCreated = dtCreated;
        this.productName = productName;
        this.contactId = contactId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public Date getDtCreated() {
        return dtCreated;
    }

    public void setDtCreated(Date dtCreated) {
        this.dtCreated = dtCreated;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Contact getContactId() {
        return contactId;
    }

    public void setContactId(Contact contactId) {
        this.contactId = contactId;
    }
}
