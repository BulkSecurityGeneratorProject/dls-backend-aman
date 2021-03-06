package ae.rta.dls.backend.domain.enumeration.prd;

/**
 * The TestStatus enumeration.
 */
public enum TestStatus {
    REQUIRED("REQUIRED"),
    NOT_REQUIRED("NOT_REQUIRED");

    /**
     * Define related domain code to be used for full domain object retrieval (ex. active/inactive)
     */
    public static final String DOMAIN_CODE = "LEFI_TEST_STATUS";

    private String value;

    TestStatus(final String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return this.value();
    }
}
