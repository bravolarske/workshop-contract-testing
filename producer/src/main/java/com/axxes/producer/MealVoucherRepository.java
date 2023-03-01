package com.axxes.producer;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Map;

@Repository
public class MealVoucherRepository {
    private final Map<Integer, MealVoucher> map = Map.of(
            2, new MealVoucher( 80, LocalDate.of(1996,12,2)),
            6, new MealVoucher( 80,  LocalDate.of(1996,12,2))
            );

    public MealVoucher get(Integer id){
        return map.get(id);
    }
}
