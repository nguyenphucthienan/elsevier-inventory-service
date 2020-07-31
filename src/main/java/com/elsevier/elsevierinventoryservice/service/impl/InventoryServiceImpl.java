package com.elsevier.elsevierinventoryservice.service.impl;

import com.elsevier.elsevierinventoryservice.domain.Inventory;
import com.elsevier.elsevierinventoryservice.repository.InventoryRepository;
import com.elsevier.elsevierinventoryservice.service.InventoryService;
import com.elsevier.elsevierinventoryservice.shared.dto.InventoryDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InventoryServiceImpl implements InventoryService {

  private final InventoryRepository inventoryRepository;

  private final ModelMapper modelMapper;

  public InventoryServiceImpl(InventoryRepository inventoryRepository, ModelMapper modelMapper) {
    this.inventoryRepository = inventoryRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public Long getInventoryQuantityByBookId(UUID bookId) {
    Long quantity = inventoryRepository.getSumQuantityByBookId(bookId);
    return quantity != null ? quantity : 0;
  }

  @Override
  public InventoryDto createInventory(InventoryDto inventoryDto) {
    Inventory inventory = modelMapper.map(inventoryDto, Inventory.class);
    Inventory savedInventory = inventoryRepository.save(inventory);
    return modelMapper.map(savedInventory, InventoryDto.class);
  }
}
