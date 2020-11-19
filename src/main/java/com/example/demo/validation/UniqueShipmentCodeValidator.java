package com.example.demo.validation;

import com.example.demo.model.Stock;
import com.example.demo.repository.StockRepository;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueShipmentCodeValidator implements ConstraintValidator<UniqueShipmentCode, String> {
    @Autowired
    private JPAStreamer jpaStreamer;


    @Override
    public void initialize(UniqueShipmentCode constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (jpaStreamer == null){
            return true;
        }else{
            Stock stock = jpaStreamer.stream(Stock.class).filter(e -> e.getIsDeleted() == 0 && e.getShipmentCode().equals(s)).findFirst().get();
            if(stock!=null) {
                return false;
            }
        }
        return true;
    }
}
