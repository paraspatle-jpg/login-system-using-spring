package org.customannotations;

import org.loginsystem.Signup;
import org.springframework.beans.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordConstraintValidator implements ConstraintValidator<MatchPassword, String> {

    private String password;

    @Override
    public void initialize(MatchPassword constraintAnnotation) {
//        password = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        boolean isSame = false;

        final Object obj1 = BeanUtils.getPropertyDescriptor(Signup.class,password);
        try{
            if(s!=null){
                assert obj1 != null;
                isSame = !obj1.equals(s);
            }
        }catch (Exception e){
            // Do nothing
        }

        return isSame;
    }
}
