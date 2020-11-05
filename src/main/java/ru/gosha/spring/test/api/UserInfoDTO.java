package ru.gosha.spring.test.api;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserInfoDTO {

    @NotBlank(message = "{error.empty}")
    @Size(min = 3, max = 15, message = "{userName.size}")
    private String userName;
    @NotBlank(message = "* Can not be empty")
    @Size(min = 3, max = 15, message = "{crushName.size}")
    private String crushName;
    @AssertTrue(message = "* You have to agree to use our app")
    private boolean termAndCondition;

    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean isTermAndCondition() {
        return termAndCondition;
    }

    public void setTermAndCondition(boolean termAndCondition) {
        this.termAndCondition = termAndCondition;
    }

    public UserInfoDTO() {
        System.out.println("hello");
    }

    @Override
    public String toString() {
        return "UserInfoDTO{" +
                "userName='" + userName + '\'' +
                ", crushName='" + crushName + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCrushName() {
        return crushName;
    }

    public void setCrushName(String crushName) {
        this.crushName = crushName;
    }


}
