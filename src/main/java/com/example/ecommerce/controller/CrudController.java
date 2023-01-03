package com.example.ecommerce.controller;

import com.example.ecommerce.entity.CrudEntity;
import com.example.ecommerce.repository.CrudEntityRepository;
import com.example.ecommerce.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class CrudController {

    private final Logger LOGGER = LoggerFactory.getLogger(CrudController.class);
    private final CrudEntityRepository crudEntityRepository;

    @Autowired
    private CrudService crudService;
    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("searchAll")
    public List<CrudEntity> searchAll(){
        return crudService.searchAll();
    }

    @GetMapping("searchParam")
    public List<CrudEntity> searchParam(@RequestParam(value = "age") int age){
        return crudService.searchParam(age);
    }

    @GetMapping("searchParamRepo")
    public List<CrudEntity> searchParamRepo(@RequestParam(value = "name") String name){
        return crudService.searchParamRepo(name);
    }

    @GetMapping("insert")
    public String insertMember(@RequestParam(value = "name") String name, @RequestParam(value = "age") int age){
        return crudService.insertMember(name, age);
    }

    @GetMapping("update")
    public String updateMember(@RequestParam(value = "name") String name, @RequestParam(value = "age") int age){
        return crudService.updateMember(name, age);
    }

    @GetMapping("delete")
    public String deleteMember(@RequestParam(value = "name") String name){
        return crudService.deleteMember(name);
    }

    @PostMapping("log-test")
    public void logTest(){

        LOGGER.error("Error Log");
        LOGGER.trace("Trace Log");
        LOGGER.debug("Debug Log");
        LOGGER.info("Info Log");
        LOGGER.warn("Warn Log");
    }


    @PostMapping("/exception")
    public void exceptionTest() throws Exception{
        throw new Exception();
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Map<String, String>> ExceptionHandler(Exception e){
        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        LOGGER.info(e.getMessage());
        LOGGER.info("Controller 내 ExceptionHandler 호출");

        Map<String, String>map = new HashMap<>();
        map.put("error type", httpStatus.getReasonPhrase());
        map.put("code", "400");
        map.put("message", "에러 발생");

        return new ResponseEntity<>(map, responseHeaders, httpStatus);


    }

}
