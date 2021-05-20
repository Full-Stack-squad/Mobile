/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import entites.Commentaire;
import entites.Photo;
import services.CommentService;

/**
 *
 * @author YACINE
 */
public class ShowPhotoForm extends Form {

    private Container imgContainer;
    private TextField tfcomm;
    Form current;
    
    public ShowPhotoForm(Form previous, Photo p) {
        current = this;
        setLayout(BoxLayout.y());
        setTitle("" + p.gettitre() + " " + p.getid_photo());
        Style s = UIManager.getInstance().getComponentStyle("MultiLine1");
        FontImage c = FontImage.createMaterial(FontImage.MATERIAL_PORTRAIT, s);
        EncodedImage placeholder = EncodedImage.createFromImage(c.scaled(c.getWidth() * 10, c.getHeight() * 10), false);
        URLImage background = URLImage.createToStorage(placeholder, p.gettitre(), p.geturl());
        background.fetch();
        imgContainer = new Container();
        imgContainer.setLayout(BoxLayout.y());
        imgContainer.add(background);
        
        tfcomm = new TextField("", "commenter");
        Button B = new Button("ajouter");
        B.addActionListener(e -> {
            if (tfcomm.getText().length() == 0) {
                Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
            } else {
                try {
                    Commentaire n = new Commentaire(tfcomm.getText(), p.getid_photo());
                    if (CommentService.getInstance().addTask(n)) {
                        Dialog.show("Success", "Connection accepted", new Command("OK"));
                    } else {
                        Dialog.show("ERROR", "Server error", new Command("OK"));
                    }
                } catch (NumberFormatException nb) {
                    Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                }
                
            }
            
        });
        
        Button hi = new Button("Afficher Map");
        
        hi.addActionListener(e -> {
            new MapForm().show();
        });
        
        Button rec = new Button("Reclamer");
        
        rec.addActionListener(e -> {
            new AjoutReclamationForm(UIManager.initFirstTheme("/theme"),p).show();
        });
        
        Container Comm = new Container(BoxLayout.y());
        Comm.addAll(tfcomm, B, hi,rec);
        for (Commentaire cc : CommentService.getInstance().getAllTasks(p.getid_photo())) {
            Label l = new Label(cc.getcomm());
            imgContainer.add(l);
        }
        
        addAll(imgContainer, Comm);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK,
                 e -> previous.showBack()); // Revenir vers l'interface précédente
    }
    
}
