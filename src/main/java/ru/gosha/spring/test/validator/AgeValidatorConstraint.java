package ru.gosha.spring.test.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidatorConstraint implements ConstraintValidator<Age, Integer> {

    private int lower;
    private int upper;

    @Override
    public void initialize(Age age) {
        this.lower = age.lower();
        this.upper = age.upper();
        System.out.println();
    }

    @Override
    public boolean isValid(Integer age, ConstraintValidatorContext constraintValidatorContext) {

        if(age == null){
            return false;
        }

        if(age < lower || age > upper){
            return false;
        }

        return true;
    }


}
