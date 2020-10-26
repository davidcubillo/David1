package com.mesaj.app.tasks;

import com.mesaj.app.models.User;
import com.mesaj.app.pageobjects.SignUpServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSignUp {

    @Autowired
    private SignUpServices signUp;

    public void withInfo(User user){

        signUp.writeFirstName(user.getFirstName());
        signUp.writeLastName(user.getLastName());
        signUp.writeEmail(user.getEmail());
        signUp.writePhone();
        signUp.clickGender();
        signUp.selectCountry(user.getCountry());
        signUp.selectYear(user.getYear());
        signUp.selectMonth(user.getMonth());
        signUp.selectDay(user.getDay());
        signUp.writePassword(user.getPassword());
        signUp.writeConfirmPassword(user.getPasswordConfirm());
        signUp.clickSubmitButton();

    }
}
