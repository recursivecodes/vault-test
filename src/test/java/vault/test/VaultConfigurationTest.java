package vault.test;

import io.micronaut.context.ApplicationContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VaultConfigurationTest {

    @Test
    void testConfig() {
        ApplicationContext ctx = ApplicationContext.run();
        OracleCloudVaultClientConfiguration config = ctx.getBean(OracleCloudVaultClientConfiguration.class);

        Assertions.assertEquals(1, config.getVaults().size());
        Assertions.assertEquals("ocid1.vault.oc1.phx....", config.getVaults().get(0).getOcid());
        Assertions.assertEquals("ocid1.compartment.oc1....", config.getVaults().get(0).getCompartmentOcid());

        ctx.close();
    }
}
