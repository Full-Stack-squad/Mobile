/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author hp
 */
public class User {

    private Integer userId;
    private SimpleStringProperty userNom;
    private SimpleStringProperty userPrenom;
    private SimpleStringProperty userBio;
    private SimpleIntegerProperty userAge;
    private SimpleIntegerProperty userTel;
    private SimpleStringProperty userEmail;
    private String userPassword;
    private SimpleStringProperty userType;

    public User(Integer userId, String userNom, String userPrenom, String userBio, Integer userAge, Integer userTel, String userEmail, String userPassword, String userType) {
        this.userId = userId;
        this.userNom = new SimpleStringProperty(userNom);
        this.userPrenom = new SimpleStringProperty(userPrenom);
        this.userBio = new SimpleStringProperty(userBio);
        this.userAge = new SimpleIntegerProperty(userAge);
        this.userTel = new SimpleIntegerProperty(userTel);
        this.userEmail = new SimpleStringProperty(userEmail);
        this.userPassword = userPassword;
        this.userType = new SimpleStringProperty(userType);
    }

    public User(Integer userId, String userNom, String userPrenom, String userBio) {
        this.userId = userId;
        this.userNom = new SimpleStringProperty(userNom);
        this.userPrenom = new SimpleStringProperty(userPrenom);
        this.userBio = new SimpleStringProperty(userBio);
    }

    public User(String userNom, String userPrenom, String userBio, Integer userTel) {

        this.userNom = new SimpleStringProperty(userNom);
        this.userPrenom = new SimpleStringProperty(userPrenom);
        this.userBio = new SimpleStringProperty(userBio);
        this.userTel = new SimpleIntegerProperty(userTel);
    }

    public User() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserNom() {
        return userNom.get();
    }

    public void setUserNom(String userNom) {
        this.userNom = new SimpleStringProperty(userNom);
    }

    public String getUserPrenom() {
        return userPrenom.get();
    }

    public void setUserPrenom(String userPrenom) {
        this.userPrenom = new SimpleStringProperty(userPrenom);
    }

    public String getUserBio() {
        return userBio.get();
    }

    public void setUserBio(String userBio) {
        this.userBio = new SimpleStringProperty(userBio);
    }

    public Integer getUserAge() {
        return userAge.get();
    }

    public void setUserAge(Integer userAge) {
        this.userAge = new SimpleIntegerProperty(userAge);
    }

    public Integer getUserTel() {
        return userTel.get();
    }

    public void setUserTel(Integer userTel) {
        this.userTel = new SimpleIntegerProperty(userTel);
    }

    public String getUserEmail() {
        return userEmail.get();
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = new SimpleStringProperty(userEmail);
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserType() {
        return userType.get();
    }

    public void setUserType(String userType) {
        this.userType = new SimpleStringProperty(userType);
    }

    public SimpleStringProperty getUserNomProperty() {
        return userNom;
    }

    public SimpleStringProperty getUserPrenomProperty() {
        return userPrenom;
    }

    public SimpleStringProperty getUserBioProperty() {
        return userBio;
    }

    public SimpleIntegerProperty getUserAgeProperty() {
        return userAge;
    }

    public SimpleIntegerProperty getUserTelProperty() {
        return userTel;
    }

    public SimpleStringProperty getUserEmailProperty() {
        return userEmail;
    }

    public SimpleStringProperty getUserTypeProperty() {
        return userType;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", userNom=" + userNom + ", userPrenom=" + userPrenom + ", userBio=" + userBio + ", userAge=" + userAge + ", userTel=" + userTel + ", userEmail=" + userEmail + ", userPassword=" + userPassword + ", userType=" + userType + '}';
    }

}
