/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.MultiButton;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import entites.Photo;
import java.util.ArrayList;
import java.util.Map;
import services.PhotoServices;

/**
 *
 * @author YACINE
 */
public class ListPhotoForm extends Form {

    Form current;

    java.util.List<Map<String, Object>> pictures = new ArrayList();

    public ListPhotoForm() {
        current = this;
        setTitle("Home");
        setLayout(BoxLayout.y());

        Image th = null;
        Style s = UIManager.getInstance().getComponentStyle("MultiLine1");
        FontImage p = FontImage.createMaterial(FontImage.MATERIAL_PORTRAIT, s);
        EncodedImage placeholder = EncodedImage.createFromImage(p.scaled(p.getWidth() * 3, p.getHeight() * 3), false);
        EncodedImage placeholder2 = EncodedImage.createFromImage(p.scaled(p.getWidth() * 2, p.getHeight() * 2), false);

        java.util.List<Map<String, Object>> data = PhotoServices.getInstance().getPhotos();

        Form h = new Form("Search", BoxLayout.y());
        h.add(new InfiniteProgress());
        Display.getInstance().scheduleBackgroundTask(() -> {
            MultiButton cmps = new MultiButton();
            current.removeAll();
            for (Map<String, Object> currentListing : PhotoServices.getInstance().getPhotos()) {

                String url = (String) currentListing.get("url");
                double id = (double) currentListing.get("idPhoto");
                String titre = (String) currentListing.get("titre");
                String theme = (String) currentListing.get("theme");
                String loc = (String) currentListing.get("localisation");
                cmps = new MultiButton(titre);
                cmps.setTextLine1(titre);
                cmps.setIcon(URLImage.createToStorage(placeholder, "" + id, url));
                cmps.addActionListener(e -> {
                    Photo pic = new Photo((int) id, url, titre, theme, loc);

                    new ShowPhotoForm(current, pic).show();
                });
                current.add(cmps);
            }
            current.revalidate();

        });
        current.getToolbar().addSearchCommand(e -> {
            String text = (String) e.getSource();
            if (text == null || text.length() == 0) {
                // clear search
                for (Component cmp : current.getContentPane()) {
                    cmp.setHidden(false);
                    cmp.setVisible(true);
                }
                current.getContentPane().animateLayout(150);
            } else {
                text = text.toLowerCase();
                for (Component cmp : current.getContentPane()) {
                    MultiButton mb = (MultiButton) cmp;
                    String line1 = mb.getTextLine1();

                    boolean show = line1 != null && line1.toLowerCase().indexOf(text) > -1;
                    mb.setHidden(!show);
                    mb.setVisible(show);
                }
                current.getContentPane().animateLayout(150);
            }
        }, 4);
        
       Toolbar tb = current.getToolbar();

Container topBar = BorderLayout.east(new Label("feedback"));
topBar.add(BorderLayout.SOUTH, new Label("Menu", "SidemenuTagline"));
topBar.setUIID("SideCommand");
tb.addComponentToSideMenu(topBar);

tb.addMaterialCommandToSideMenu("Feedback", FontImage.MATERIAL_HOME, e -> {
    new ListerFeedbackForm(current).show();
});
    }

}
