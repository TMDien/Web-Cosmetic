package tmd.project.ShopCosmetic.Until.constants;

public enum Privillages {
    RESET_ANY_USER_PASSWORD(1l, "RESET_ANY_USER_PASSWORD"),
    ACCESS_ADMIN_PANEL(2l, "ACCESS_ADMIN_PANEL");

    private Long Id;
    private String privillages;
    private Privillages(Long id, String privillages) {
        Id = id;
        this.privillages = privillages;
    }
    public Long getId() {
        return Id;
    }
    public String getPrivillages() {
        return privillages;
    }
    
}
