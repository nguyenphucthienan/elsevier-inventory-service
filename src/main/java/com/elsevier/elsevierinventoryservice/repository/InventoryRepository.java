package com.elsevier.elsevierinventoryservice.repository;

import com.elsevier.elsevierinventoryservice.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, UUID> {

  @Query("select sum(i.quantity) from Inventory i where i.bookId = :bookId")
  Long getSumQuantityByBookId(@Param("bookId") UUID bookId);
}
