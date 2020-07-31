package com.elsevier.elsevierinventoryservice.payload.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class InventoryRequest {

  @NotNull
  @Min(1)
  private String quantity;

  public String getQuantity() {
    return quantity;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }
}
