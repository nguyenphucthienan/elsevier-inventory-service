package com.elsevier.elsevierinventoryservice.payload.response;

import java.util.UUID;

public class InventoryResponse {

  private UUID id;
  private UUID bookId;
  private Long quantity;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public UUID getBookId() {
    return bookId;
  }

  public void setBookId(UUID bookId) {
    this.bookId = bookId;
  }

  public Long getQuantity() {
    return quantity;
  }

  public void setQuantity(Long quantity) {
    this.quantity = quantity;
  }
}
