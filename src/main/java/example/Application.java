package example;

import java.util.Date;

public class Application {
    private String APPLICATION_ID;
    private Integer CONTACT_ID;
    private Date DT_CREATED;
    private String PRODUCT_NAME;

    public void setAPPLICATION_ID(String APPLICATION_ID) {
        this.APPLICATION_ID = APPLICATION_ID;
    }

    public void setCONTACT_ID(Integer CONTACT_ID) {
        this.CONTACT_ID = CONTACT_ID;
    }

    public void setDT_CREATED(Date DT_CREATED) {
        this.DT_CREATED = DT_CREATED;
    }

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
