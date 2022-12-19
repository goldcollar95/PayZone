package com.example.ecommerce.repository;

import com.example.ecommerce.entity.CrudEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrudEntityRepository extends JpaRepository<CrudEntity, String> {

    @Query(value = "select name, age from ecommercedb  where name = :name", nativeQuery = true)
    List<CrudEntity> searchParamRepo(@Param("name") String name);
}
