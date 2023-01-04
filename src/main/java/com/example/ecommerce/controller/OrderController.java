package com.example.ecommerce.controller;

import com.example.ecommerce.dto.OrderProductDto;
import com.example.ecommerce.exception.ResourceNotFoundException;
import com.example.ecommerce.model.Order;
import com.example.ecommerce.model.OrderProduct;
import com.example.ecommerce.model.OrderStatus;
import com.example.ecommerce.service.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    ProductService productService;
    OrderService prderService;
    OrderProductService orderProductService;

    public OrderController(ProductService productService, OrderService prderService, OrderProductService orderProductService) {
        this.productService = productService;
        this.prderService = prderService;
        this.orderProductService = orderProductService;
    }
    //모든 주문건들이 조회가 될수 있도록 list형태로 만들어주려한다.
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @NotNull Iterable<Order> list(){
        return this.orderService.getAllOrders();
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody OrderForm form){
        List<OrderProductDto> formDtos = form.getProductOrders();
        validateProductsExistence(formDtos);
        Order order = new Order();
        order.setStatus(OrderStatus.PAID.name());
        order = this.orderService.create(order);

        List<orderProduct> orderProducts = new ArrayList<>();
        for(OrderProductDto dto : formDtos){
            orderProducts.add(orderProductService.create(new OrderProduct(order, productService.getProduct(dto
                    .getProduct()
                    .getId()), dto.getQuantity())));
        }

        order.setOrderProducts(orderProducts);

        this.orderService.update(order);

        String url = ServletUriComponentsBuilder
                .fromCurrentServletMapping()
                .path("/orders/{id}")
                .bildAndExpand(order.getId())
                .toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", uri);

        return new ResponseEntity<>(order, headers, HttpStatus.CREATED);
    }

    private void validateProductsExistence(List<OrderProductDto> orderProducts){
        List<OrderProductDto> list = orderProducts
                .stream()
                .filter(op -> Objects.isNull(productService.getProduct(op
                        .getProduct()
                        .getId())))
                .collect(Collectors.toList());

        if(!CollectionUtils.isEmpty(list)){
            new ResourceNotFoundException("Product not found");
        }
    }

    public static class OrderForm{
        private List<OrderProductDto> productOrders;

        public List<OrderProductDto> getProductOrders(){
            return productOrders;
        }
        public void setProductOrders(List<OrderProductDto> productOrders){
            this.productOrders = productOrders;
        }
    }
}
