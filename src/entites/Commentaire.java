/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.util.Objects;

/**
 *
 * @author YACINE
 */
public class Commentaire {
    private int id_comm;
    private String comm;
    private String nom_user;
    private int id_photo;
    private int idU;




    public Commentaire() {
    }
    

public Commentaire(int id_comm, String comm, String nom_user, int id_photo, int idU) {
        this.id_comm =id_comm;
        this.comm = comm;
        this.nom_user = nom_user;
        this.id_photo =id_photo;
        this.id_comm =idU;
    }
public Commentaire(String comm, String nom_user, int id_photo, int idU) {
        this.comm = comm;
        this.nom_user = nom_user;
        this.id_photo =id_photo;
        this.id_comm =idU;
    }
public Commentaire(String comm,int id_photo) {
        this.comm = comm;
        this.id_photo =id_photo;
  
    }



public int getid_comm() {
        return id_comm;
    }

    public void setid_comm(int id_comm) {
        this.id_comm = id_comm;
    }

    public String getcomm() {
        return comm;
    }

    public void setcomm(String comm) {
        this.comm = comm;
    }

    public String getnom_user() {
        return nom_user;
    }

    public void setnom_user(String nom_user) {
        this.nom_user = nom_user;
    }

    public int getid_photo() {
        return id_photo;
    }

    public void setid_photo(int id_photo) {
        this.id_photo = id_photo;
    }

    public int getidUser() {
        return idU;
    }

    public void setidUser(int idU) {
        this.idU = idU;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id_comm);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final  Commentaire other = ( Commentaire) obj;
        if (!Objects.equals(this.id_comm, other.id_comm)) {
            return false;
        }
        return true;
    }











}
