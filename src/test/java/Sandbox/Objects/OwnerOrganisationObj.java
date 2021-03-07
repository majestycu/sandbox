package Sandbox.Objects;

import lombok.Data;

@Data
public class OwnerOrganisationObj {

    private String id;
    private String name;
    private String billingEmail;

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getBillingEmail() {
        return billingEmail;
    }
}
