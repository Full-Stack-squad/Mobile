/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import entites.Reclamation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import utils.Statics;

/**
 *
 * @author ASUS
 */
public class ServiceReclamation {

    public static ServiceReclamation instance = null;

    private ConnectionRequest req;
    public static boolean resultOK = true;

    public static ServiceReclamation getInstance() {
        if (instance == null) {
            instance = new ServiceReclamation();
        }
        return instance;
    }

    public ServiceReclamation() {
        req = new ConnectionRequest();
    }

    public void ajouterReclamation(Reclamation reclamation) {
        String url = Statics.BASE_URL + "/api/reclamer?sujet=" + reclamation.getSujet() + "&description=" + reclamation.getDescription() + "&id_user=" + reclamation.getId_user() + "&id_photo=" + reclamation.getId_photo();

        req.setUrl(url);
        req.addResponseListener((e) -> {

            String str = new String(req.getResponseData());

            System.out.println("data == " + str);

        });
        NetworkManager.getInstance().addToQueueAndWait(req);

    }

    //afficher liste
    public ArrayList<Reclamation> affichageReclamations(int id_user) {
        ArrayList<Reclamation> result = new ArrayList<>();
        String url = Statics.BASE_URL + "/api/reclamation?id_user=" + id_user;
        req.setUrl(url);
        System.out.println("123");
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                JSONParser json;
                json = new JSONParser();

                try {
                    Map<String, Object> mapReclamations = json.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                    List<Map<String, Object>> listofMaps = (List<Map<String, Object>>) mapReclamations.get("root");

                    for (Map<String, Object> obj : listofMaps) {
                        Reclamation re = new Reclamation();
                        float id = Float.parseFloat(obj.get("id").toString());

                        String title = obj.get("sujet").toString();
                        String description = obj.get("description").toString();
                        String etat = obj.get("etat").toString();

                        re.setId((int) id);
                        re.setSujet(title);
                        re.setDescription(description);
                        re.setEtat(etat);

                        result.add(re);
                    }
                } catch (Exception e) {

                    e.printStackTrace();
                }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return result;
    }

    //detail reclamation
    public Reclamation detailReclamation(int id, Reclamation reclamation) {
        Reclamation re = new Reclamation();
        String url = Statics.BASE_URL + "/reclamation/addReclamation?id=" + id;
        req.setUrl(url);
        req.addResponseListener(((evt) -> {
            String str = new String(req.getResponseData());

            JSONParser jsonp = new JSONParser();
            try {
                Map<String, Object> obj = jsonp.parseJSON(new CharArrayReader(str.toCharArray()));
                System.out.println(obj);

                re.setDescription(obj.get("description").toString());

            } catch (IOException e) {

                System.out.println("error related to sql " + e.getMessage());
            }

            System.out.println("data == " + str);
        }));

        NetworkManager.getInstance().addToQueueAndWait(req);

        return reclamation;

    }

    //Delete
    public boolean deleteReclamation(int id) {

        Reclamation re = new Reclamation();
        String url = Statics.BASE_URL + "/api/deleteReclamation?id=" + id;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                req.removeResponseCodeListener(this);
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;

    }

    //update
    public boolean modifierReclamation(Reclamation reclamation) {

        Reclamation re = new Reclamation();
        String url = Statics.BASE_URL + "/reclamation/updateReclamation?id=" + reclamation.getId() + "&title=" + "&description=" + reclamation.getDescription();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200;
                req.removeResponseCodeListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

}
