package vault.test;

import io.micronaut.context.annotation.BootstrapContextCompatible;
import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.discovery.config.ConfigDiscoveryConfiguration;

import java.util.List;

/**
 *  OracleCloudVault Client.
 *
 *  @author toddsharp
 *  @since 1.3.5
 */
@ConfigurationProperties(OracleCloudVaultClientConfiguration.PREFIX)
@BootstrapContextCompatible
public class OracleCloudVaultClientConfiguration {

    public static final String PREFIX = "oraclecloud.vault";
    private static final Boolean USE_INSTANCE_PRINCIPAL = false;
    private static final String PATH_TO_OCI_CONFIG = "~/.oci/config";
    private static final String DEFAULT_PROFILE = "DEFAULT";

    private final OracleCloudVaultClientDiscoveryConfiguration oracleCloudVaultClientDiscoveryConfiguration = new OracleCloudVaultClientDiscoveryConfiguration();

    private List<OracleCloudVault> vaults;
    private boolean useInstancePrincipal = USE_INSTANCE_PRINCIPAL;
    private String pathToConfig = PATH_TO_OCI_CONFIG;
    private String profile = DEFAULT_PROFILE;
    private String region;

    /**
     * @return The discovery service configuration
     */
    public OracleCloudVaultClientDiscoveryConfiguration getDiscoveryConfiguration() {
        return oracleCloudVaultClientDiscoveryConfiguration;
    }

    /**
     * @return A list of Vaults to retrieve
     */
    public List<OracleCloudVault> getVaults() {
        return vaults;
    }

    /**
     * @param vaults A list of Vaults
     */
    public void setVaults(List<OracleCloudVault> vaults) {
        this.vaults = vaults;
    }

    /**
     * @return Whether or not we should use instance principal authentication
     */
    public boolean isUseInstancePrincipal() {
        return useInstancePrincipal;
    }

    /**
     * @param useInstancePrincipal Should we use instance principal authentication
     */
    public void setUseInstancePrincipal(boolean useInstancePrincipal) {
        this.useInstancePrincipal = useInstancePrincipal;
    }

    /**
     * @return The path to the OCI config file (if not using instance principal auth)
     */
    public String getPathToConfig() {
        return pathToConfig;
    }

    /**
     * @param pathToConfig The path to the OCI config file
     */
    public void setPathToConfig(String pathToConfig) {
        this.pathToConfig = pathToConfig;
    }

    /**
     * @return Which profile in the OCI config file to use (default: DEFAULT)
     */
    public String getProfile() {
        return profile;
    }

    /**
     * @param profile Which profile in the OCI config file to use (default: DEFAULT)
     */
    public void setProfile(String profile) {
        this.profile = profile;
    }

    /**
     * @return Which region in the Oracle Cloud should the client work in?
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region Which region in the Oracle Cloud should the client work in?
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * The Discovery Configuration class for Oracle Cloud Vault.
     */
    @ConfigurationProperties(ConfigDiscoveryConfiguration.PREFIX)
    @BootstrapContextCompatible
    public static class OracleCloudVaultClientDiscoveryConfiguration extends ConfigDiscoveryConfiguration {
        public static final String PREFIX = OracleCloudVaultClientConfiguration.PREFIX + "." + ConfigDiscoveryConfiguration.PREFIX;
    }
}