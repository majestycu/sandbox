package Sandbox.Objects;

import lombok.Data;


@Data
public class ResponseSandboxObject {

    private String id;
    private String name;
    private String description;

    private OwnerOrganisationObj ownerOrganisation;

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public OwnerOrganisationObj getOwnerOrganisation() {
        return ownerOrganisation;
    }
}