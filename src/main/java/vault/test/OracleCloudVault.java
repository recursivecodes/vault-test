package vault.test;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class OracleCloudVault {
    private String ocid;
    private String compartmentOcid;

    public OracleCloudVault(String ocid, String compartmentOcid) {
        this.ocid = ocid;
        this.compartmentOcid = compartmentOcid;
    }

    public String getOcid() {
        return ocid;
    }

    public void setOcid(String ocid) {
        this.ocid = ocid;
    }

    public String getCompartmentOcid() {
        return compartmentOcid;
    }

    public void setCompartmentOcid(String compartmentOcid) {
        this.compartmentOcid = compartmentOcid;
    }
}