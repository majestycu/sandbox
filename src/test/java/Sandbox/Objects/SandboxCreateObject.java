package Sandbox.Objects;

import lombok.Data;

@Data
public class SandboxCreateObject {

    public String name;
    public String description;

    public SandboxCreateObject(String name,
                               String description) {
        this.name = name;
        this.description = description;

    }
}



