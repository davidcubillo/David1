package com.mesaj.app.builders.data;

import com.mesaj.app.models.User;

public class UserBuilder {
    private User user;
    public static UserBuilder aUser(){
        return new UserBuilder();
    }
    public UserBuilder withDefaultInfo() {
        this.user = User.builder()
                .firstName("David")
                .lastName("Cubillo")
                .email("davidcubillo@gmail.com")
                .country("Costa Rica")
                .day("14")
                .month("February")
                .year("1984")
                .password("Cualquiera1984")
                .passwordConfirm("Cualquiera1984")
                .build();
        return this;
    }
    public UserBuilder but(){
        return withDefaultInfo();
    }
    public User build(){
       return this.user;
    }
}
