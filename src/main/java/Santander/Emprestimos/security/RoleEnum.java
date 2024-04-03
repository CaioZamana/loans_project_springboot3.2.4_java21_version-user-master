package Santander.Emprestimos.security;

public enum RoleEnum {
    USER("ROLE_USER", "Usuário Normal", "/user/**"),
    ADMIN("ROLE_ADMIN", "Administrador do Sistema", "/admin/**"),
    PRODUCT_MANAGER("ROLE_PRODUCT_MANAGER", "Gerente de Produtos de Empréstimo", "/product-manager/**"),
    CREDIT_ANALYST("ROLE_CREDIT_ANALYST", "Analista de Crédito", "/credit-analyst/**"),
    RISK_MANAGER("ROLE_RISK_MANAGER", "Gestor de Riscos", "/risk-manager/**"),
    COLLATERAL_ANALYST("ROLE_COLLATERAL_ANALYST", "Analista de Garantia", "/collateral-analyst/**"),
    CUSTOMER_SERVICE_REPRESENTATIVE("ROLE_CUSTOMER_SERVICE_REPRESENTATIVE", "Atendente ao Cliente", "/customer-service/**");

    private final String role;
    private final String description;
    private final String path;

    RoleEnum(String role, String description, String path) {
        this.role = role;
        this.description = description;
        this.path = path;
    }

    public String getRole() {
        return role;
    }

    public String getDescription() {
        return description;
    }

    public String getPath() {
        return path;
    }


}
