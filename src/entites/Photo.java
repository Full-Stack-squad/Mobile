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
public class Photo {
      private int id_photo;
    private String url;
    private String titre;
    private String theme;
    private String date_ajout;
    private String couleur;
    private String localisation;
    private int idU;

    public Photo() {
    }

    public Photo( String url, String titre, String theme,  String couleur, String localisation ) {
    
        this.url = url;
        this.titre =titre;
        this.theme = theme;
        
        this.couleur =couleur;
        this.localisation = localisation;
 
    }
    
     public Photo(int id_photo, String url, String titre, String theme, String localisation ) {
    this.id_photo=id_photo;
        this.url = url;
        this.titre =titre;
        this.theme = theme;
        this.localisation = localisation;
 
    }


  

    public int getid_membre() {
        return idU;
    }

    public void setid_membre(int idU) {
        this.idU =idU;
    }

    public int getid_photo() {
        return id_photo;
    }

    public void setid_photo(int id_photo) {
        this.id_photo =id_photo;
    }

    public String geturl() {
        return url;
    }

    public void seturl(String url) {
        this.url = url;
    }

    public String gettitre() {
        return titre;
    }

    public void settitre(String titre) {
        this.titre =titre;
    }

    public String gettheme() {
        return theme;
    }

    public void settheme(String theme) {
        this.theme = theme;
    }

    public String getdate_ajout() {
        return date_ajout;
    }

    public void setdate_ajout(String date_ajout) {
        this.date_ajout = date_ajout;
    }

    public String getcouleur() {
        return couleur;
    }

    public void setcouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getlocalisation() {
        return localisation;
    }

    public void setlocalisation(String localisation) {
        this.localisation = localisation;
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id_photo);
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
        final Photo other = (Photo) obj;
        if (!Objects.equals(this.id_photo, other.id_photo)) {
            return false;
        }
        return true;
    }
    
}
