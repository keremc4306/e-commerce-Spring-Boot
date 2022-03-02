package coding.example.ecommerce.type;

import lombok.Getter;

public class EnumDefinition {
  protected EnumDefinition() {
  }

  public enum ProductStatus {
    ACTIVE("active", "Active"),
    INACTIVE("inactive", "Inactive"),
    DELETED("deleted", "Deleted");

    @Getter
    private final String code;
    @Getter
    private final String description;

    ProductStatus(String code, String description) {
      this.code = code;
      this.description = description;
    }
  }
}
