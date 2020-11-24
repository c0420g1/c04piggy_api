package com.example.demo.validation;

import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.demo.repository.StockRepository;

public class UniqueShipmentCodeValidator implements ConstraintValidator<UniqueShipmentCode, String> {
    @Autowired
    private StockRepository stockRepository;


    @Override
    public void initialize(UniqueShipmentCode constraintAnnotation) {

    }

    @Override
    public boolean isValid(String shipmentCode, ConstraintValidatorContext constraintValidatorContext) {
        if (stockRepository == null){
            return true;
        }else{
            if(stockRepository.findAllByShipmentCodeAndIsDeletedIsFalse(shipmentCode)!=null) {
                return false;
            }
        }
        return true;
//
//        if (stockRepository == null) {
//            return true;
//        }else{
//            Stock stock1 = stockRepository.findAllByShipmentCodeAndIsDeletedIsFalse(shipmentCode);
//            if (stock1 != null) {
//                return false;
//            }
//        }
//        return true;
    }
}
