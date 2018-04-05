package example.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class Application {
    private String APPLICATION_ID;
    private Integer CONTACT_ID;
    private Date DT_CREATED;
    private String PRODUCT_NAME;

    @XmlElement
    public void setAPPLICATION_ID(String APPLICATION_ID) {
        this.APPLICATION_ID = APPLICATION_ID;
    }

    @XmlElement
    public void setCONTACT_ID(Integer CONTACT_ID) {
        this.CONTACT_ID = CONTACT_ID;
    }

    @XmlElement
    public void setDT_CREATED(Date DT_CREATED) {
        this.DT_CREATED = DT_CREATED;
    }

    @XmlElement
    public void setPRODUCT_NAME(String PRODUCT_NAME) {
        this.PRODUCT_NAME = PRODUCT_NAME;
    }

    public String getAPPLICATION_ID() {
        return APPLICATION_ID;
    }

    public Integer getCONTACT_ID() {
        return CONTACT_ID;
    }

    public Date getDT_CREATED() {
        return DT_CREATED;
    }

    public String getPRODUCT_NAME() {
        return PRODUCT_NAME;
    }
}
