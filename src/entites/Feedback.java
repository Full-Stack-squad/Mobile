/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author ayoub
 */
public class Feedback {
    private int idFeedback;
    private String date;
    private String description;
    private int rating;
    private int idAbonne;
    private int idMembre;

    public Feedback(int idFeedback, String date, String description, int rating, int idAbonne, int idMembre) {
        this.idFeedback = idFeedback;
        this.date = date;
        this.description = description;
        this.rating = rating;
        this.idAbonne = idAbonne;
        this.idMembre = idMembre;
    }

    public Feedback() {
    }

    public int getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(int idFeedback) {
        this.idFeedback = idFeedback;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getIdAbonne() {
        return idAbonne;
    }

    public void setIdAbonne(int idAbonne) {
        this.idAbonne = idAbonne;
    }

    public int getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(int idMembre) {
        this.idMembre = idMembre;
    }

    public Feedback(String date, String description, int rating, int idAbonne, int idMembre) {
        this.date = date;
        this.description = description;
        this.rating = rating;
        this.idAbonne = idAbonne;
        this.idMembre = idMembre;
    }

    @Override
    public String toString() {
        return "Feedback{" + "idFeedback=" + idFeedback + ", date=" + date + ", description=" + description + ", rating=" + rating + ", idAbonne=" + idAbonne + ", idMembre=" + idMembre + '}';
    }
    
}
