package com.elsevier.elsevierinventoryservice.shared.dto;

import java.util.UUID;

public class InventoryDto {

  private UUID id;
  private UUID bookId;
  private Long quantity = 0L;

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
