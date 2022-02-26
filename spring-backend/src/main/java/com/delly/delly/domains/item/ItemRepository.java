package com.delly.delly.domains.item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

       @Query(value = "SELECT ITEM.ID, ITEM.NAME, ITEM.DESCRIPTION, ITEM.PRICE, ITEM.SIZE FROM COMPANY " +
             "JOIN COMPANY_ITEM ON (COMPANY.ID = COMPANY_ITEM.COMPANY_ID) " +
             "JOIN ITEM ON (ITEM.ID = COMPANY_ITEM.ITEM_ID) " +
             "WHERE COMPANY.NAME = ?1",
               nativeQuery = true)
       List<Item> getItemByCompanies(String companyName);


}
