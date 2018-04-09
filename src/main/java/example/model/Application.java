package example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@XmlRootElement(name="APPLICATION")
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "applications")
public class Application {
    @Id
    @Column(name = "APPLICATION_ID")
    @XmlElement(name = "APPLICATION_ID")
    @JsonProperty("APPLICATION_ID")
    private String applicationId;

    @Column(name = "DT_CREATED")
    @XmlElement(name = "DT_CREATED")
    @JsonProperty("DT_CREATED")
    private Date dtCreated;

    @Column(name = "PRODUCT_NAME")
    @XmlElement(name = "PRODUCT_NAME")
    @JsonProperty("PRODUCT_NAME")
    private String productName;

    @ManyToOne
    @JoinColumn(name = "CONTACT_ID")
    @XmlElement(name = "CONTACT_ID")
    @JsonProperty("CONTACT_ID")
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
