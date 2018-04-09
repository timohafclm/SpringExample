package example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name="APPLICATION")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseTransfer {
    @XmlElement(name = "APPLICATION_ID")
    @JsonProperty("APPLICATION_ID")
    private String applicationId;

    @XmlElement(name = "CONTACT_ID")
    @JsonProperty("CONTACT_ID")
    private Integer contactId;

    @XmlElement(name = "DT_CREATED")
    @JsonProperty("DT_CREATED")
    private Date dtCreated;

    @XmlElement(name = "PRODUCT_NAME")
    @JsonProperty("PRODUCT_NAME")
    private String productName;

    public ResponseTransfer(String applicationId, Integer contactId, Date dtCreated, String productName) {
        this.applicationId = applicationId;
        this.contactId = contactId;
        this.dtCreated = dtCreated;
        this.productName = productName;
    }

    public ResponseTransfer() {
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
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
}
