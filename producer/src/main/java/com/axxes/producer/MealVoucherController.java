package com.axxes.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/meal-vouchers")
public class MealVoucherController {
    @Autowired
    MealVoucherRepository repository;
    @GetMapping(value = "/{id}")
    public MealVoucher get(@PathVariable("id") Integer id){
        return repository.get(id);
    }

}
