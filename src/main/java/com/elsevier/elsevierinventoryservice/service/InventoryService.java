package com.elsevier.elsevierinventoryservice.service;

import com.elsevier.elsevierinventoryservice.shared.dto.InventoryDto;

import java.util.UUID;

public interface InventoryService {

  Long getInventoryQuantityByBookId(UUID bookId);

  InventoryDto createInventory(InventoryDto inventoryDto);
}
