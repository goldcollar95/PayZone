package com.example.ecommerce.repository;

import com.example.ecommerce.JpaRepository;
import com.example.ecommerce.entity.CrudEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudEntityRepository extends JpaRepository<CrudEntity, String > {

    @Query(value = "select name, age from sample_member  where name = :name", nativeQuery = true)
    List<CrudEntity> searchParamRepo(@Param("name") String name);
}
