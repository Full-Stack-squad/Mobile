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
import entites.Feedback;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.Statics;

/**
 *
 * @author ayoub
 */
public class FeedbackService {

    public static FeedbackService instance = null;
    private ConnectionRequest req;
    public boolean resultOK;
    public ArrayList<Feedback> feedbacks;
    public List<Map<String, Object>> list;

    public static FeedbackService getInstance() {
        if (instance == null) {
            instance = new FeedbackService();
        }
        return instance;
    }

    private FeedbackService() {
        req = new ConnectionRequest();
    }

    public ArrayList<Feedback> parseFeedbacks(String jsonText) {
        try {
            ArrayList<Feedback> res = new ArrayList<>(); 
            feedbacks = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> FeedbacksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            list = (List<Map<String, Object>>) FeedbacksListJson.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Feedback f = new Feedback();
                float idF = Float.parseFloat(obj.get("idFeedback").toString());
                float R = Float.parseFloat(obj.get("rating").toString());
                
                float idA = 24;//Float.parseFloat(((User)obj.get("idAbonne")).getUserId().toString());
                float idM = 25;//Float.parseFloat(((User)obj.get("idMembre")).getUserId().toString());

                f.setIdFeedback((int)idF);
                f.setDescription(obj.get("description").toString());
                f.setDate(obj.get("date").toString());
                f.setRating((int)R);
                f.setIdAbonne((int)idA);
                f.setIdMembre((int)idM);
                
                feedbacks.add(f);
            }

        } catch (IOException ex) {

        }
        return feedbacks;
    }

    public ArrayList<Feedback> getFeedbacks() {
        String url = Statics.BASE_URL + "/feedback/lister";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                feedbacks = parseFeedbacks(new String(req.getResponseData()));
                System.err.println(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return feedbacks;
    }

    public boolean addFeedback(Feedback f) {

        String url = Statics.BASE_URL + "/feedback/addF/" + f.getDescription() + "/" + f.getDate() + "/" + f.getRating() + "/" + f.getIdAbonne() + "/" + f.getIdMembre();
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
    public boolean modifierFeedback(Feedback f) {

        String url = Statics.BASE_URL + "/feedback/modifierF/" + f.getDescription() + "/" + f.getDate() + "/" + f.getRating();
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
    public boolean supprimerFeedback() {

        String url = Statics.BASE_URL + "/feedback/supprimerF";
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
    public boolean verif() {

        String url = Statics.BASE_URL + "/feedback/verif";
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
                //Supprimer cet actionListener
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
}
