package com.mars.stock.controller;

import com.mars.stock.service.StockService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author: Mars
 * @Description: 库存服务
 * @Date: 2022/05/19 11:49
 */
@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;
    @Autowired
    private Registration registration;

    @GetMapping(value = "/deduct/{productId}/{stockCount}")
    public String deductStock(@PathVariable("productId") Long productId,
                              @PathVariable("stockCount") Integer stockCount){
        return stockService.deductStock(productId,stockCount);
    }

    @GetMapping(value = "/getIpAndPort")
    public String getIpAndPort(){
        return registration.getHost()+":"+registration.getPort();
    }
}
