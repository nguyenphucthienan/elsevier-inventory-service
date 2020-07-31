package com.elsevier.elsevierinventoryservice.controller;

import com.elsevier.elsevierinventoryservice.payload.request.InventoryRequest;
import com.elsevier.elsevierinventoryservice.payload.response.InventoryResponse;
import com.elsevier.elsevierinventoryservice.payload.response.InventoryQuantityResponse;
import com.elsevier.elsevierinventoryservice.service.InventoryService;
import com.elsevier.elsevierinventoryservice.shared.dto.InventoryDto;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/books/{bookId}/inventories")
public class InventoryController {

  private final InventoryService inventoryService;

  private final ModelMapper modelMapper;

  public InventoryController(InventoryService inventoryService, ModelMapper modelMapper) {
    this.inventoryService = inventoryService;
    this.modelMapper = modelMapper;
  }

  @GetMapping
  public InventoryQuantityResponse getTotalInventory(@PathVariable UUID bookId) {
    Long quantity = inventoryService.getInventoryQuantityByBookId(bookId);
    InventoryQuantityResponse inventoryQuantityResponse = new InventoryQuantityResponse();
    inventoryQuantityResponse.setQuantity(quantity);
    return inventoryQuantityResponse;
  }

  @PostMapping
  public InventoryResponse createInventory(
      @PathVariable UUID bookId, @Valid @RequestBody InventoryRequest inventoryRequest) {
    InventoryDto inventoryDto = modelMapper.map(inventoryRequest, InventoryDto.class);
    inventoryDto.setBookId(bookId);
    InventoryDto savedInventoryDto = inventoryService.createInventory(inventoryDto);
    return modelMapper.map(savedInventoryDto, InventoryResponse.class);
  }
}
