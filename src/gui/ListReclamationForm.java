/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import entites.Reclamation;
import java.util.ArrayList;

import services.ServiceReclamation;

/**
 *
 * @author ASUS
 */
public class ListReclamationForm extends Form {

    
    Form current;
    Resources res;

    public ListReclamationForm() {
        super("Newsfeed", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        current = this;
        res = UIManager.initFirstTheme("/theme");
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("");
        getContentPane().setScrollVisible(false);

        tb.addSearchCommand((e) -> {

        });

        Tabs swipe = new Tabs();
        Label s1 = new Label();
        Label s2 = new Label();

        //addTab(swipe,s1,res.getImage("back-logo.jpeg"),"","",res);
        //
        FlowLayout flow = new FlowLayout(CENTER);
        flow.setValign(BOTTOM);
        Container radioContainer = new Container(flow);
        Component.setSameSize(radioContainer, s1, s2);
        add(LayeredLayout.encloseIn(swipe, radioContainer));

        ButtonGroup barGroup = new ButtonGroup();
        RadioButton mesListes = RadioButton.createToggle("Mes Reclamations", barGroup);
        mesListes.setUIID("SelectBar");
        RadioButton photo = RadioButton.createToggle("photo", barGroup);
        photo.setUIID("SelectBar");

        Label arrow = new Label(res.getImage("news-tab-down-arrow.png"), "Container");

        mesListes.addActionListener((e) -> {
            InfiniteProgress ip = new InfiniteProgress();
            final Dialog ipDlg = ip.showInifiniteBlocking();

            //ListReclamationForm a = new ListReclamationForm(res);
            //a.show();
            refreshTheme();
        });

        photo.addActionListener((e) -> {
            InfiniteProgress ip = new InfiniteProgress();
            final Dialog ipDlg = ip.showInifiniteBlocking();

            ListPhotoForm a = new ListPhotoForm();
            a.show();
            refreshTheme();
        });

        add(LayeredLayout.encloseIn(
                GridLayout.encloseIn(2, photo, mesListes),
                FlowLayout.encloseBottom(arrow)
        ));

        arrow.setVisible(false);

        bindButtonSelection(mesListes, arrow);
        bindButtonSelection(photo, arrow);

        // special case for rotation
        addOrientationListener(e -> {
            updateArrowPosition(barGroup.getRadioButton(barGroup.getSelectedIndex()), arrow);
        });

        ArrayList<Reclamation> list = ServiceReclamation.getInstance().affichageReclamations(29);

        for (Reclamation rec : list) {

            String urlImage = "back-logo.jpeg";

            Image placeHolder = Image.createImage(120, 90);
            EncodedImage enc = EncodedImage.createFromImage(placeHolder, false);
            URLImage urlim = URLImage.createToStorage(enc, urlImage, urlImage, URLImage.RESIZE_SCALE);

            addButton(urlim, rec, res);

            ScaleImageLabel image = new ScaleImageLabel(urlim);

            Container containerImg = new Container();

            image.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        }

    }

    private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel"))
                .add(BorderLayout.CENTER, v));
       
    }

    /*
    private void addTab(Tabs swipe,Label spacer, Image image, String string, String text, Resources res) {
        int size = Math.min(Display.getInstance().getDisplayWidth(), Display.getInstance().getDisplayHeight());
        
        if(image.getHeight()<size){
            image = image.scaledHeight(size);
        }
        if(image.getHeight()>Display.getInstance().getDisplayHeight()/2){
            image = image.scaledHeight(Display.getInstance().getDisplayHeight() /2);
        }
        ScaleImageLabel imageScale = new ScaleImageLabel(image);
        imageScale.setUIID("Container");
        imageScale.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        
        Label overLay=new Label("","ImageOverlay");
        
        Container page1=LayeredLayout.encloseIn(imageScale,overLay,BorderLayout.south(BoxLayout.encloseY(new SpanLabel(text,"LargeWhiteText"),FlowLayout.encloseIn(null),spacer)));
        swipe.addTab("",res.getImage("back-logo.jpeg"),page1);
    }
     */
    public void bindButtonSelection(Button btn, Label l) {
        btn.addActionListener(e -> {
            if (btn.isSelected()) {
                updateArrowPosition(btn, l);
            }

        });
    }

    private void updateArrowPosition(Button btn, Label l) {
        l.getUnselectedStyle().setMargin(LEFT, btn.getX() + btn.getWidth() / 2 - l.getWidth() / 2);
        l.getParent().repaint();
    }

    private void addButton(Image img, Reclamation rec, Resources res) {

        int height = Display.getInstance().convertToPixels(11.5f);

        int width = Display.getInstance().convertToPixels(14f);

        Button image = new Button(img.fill(width, height));
        image.setUIID("Label");

        Container cnt = BorderLayout.west(image);
        // TextArea ta=new TextArea(title);
        // ta.setUIID("NewsTopLine");
        // ta.setEditable(false);
        Label titleTxt = new Label("Sujet :" + rec.getSujet(), "NewsTopLine2");
        Label descriptionTxt = new Label("description :" + rec.getDescription(), "NewsTopLine2");
        Label etatTxLabel = new Label("etat :" + rec.getEtat(), "NewsTopLine2");

     

        Label lSupprimer = new Label(" ");
        lSupprimer.setUIID("NewsTopLine");
        Style supprimerStyle = new Style(lSupprimer.getUnselectedStyle());
        supprimerStyle.setFgColor(0xf21f1f);

        FontImage supprimerImage = FontImage.createMaterial(FontImage.MATERIAL_DELETE, supprimerStyle);
        lSupprimer.setIcon(supprimerImage);
        lSupprimer.setTextPosition(RIGHT);

        lSupprimer.addPointerPressedListener(l -> {
            Dialog dig = new Dialog("Suppression");

            if (dig.show("Suppression", "Vous voullez supprimer cette reclamation ?", "Annuler", "Oui")) {
                dig.dispose();

            } else {
                dig.dispose();
                if (ServiceReclamation.getInstance().deleteReclamation(rec.getId())) {
                    new ListReclamationForm().show();

                }

            }

        });

       

       

        cnt.add(BorderLayout.CENTER, BoxLayout.encloseY(BoxLayout.encloseX(titleTxt), BoxLayout.encloseX(descriptionTxt), BoxLayout.encloseX(etatTxLabel, lSupprimer)));

        add(cnt);
    }

}
