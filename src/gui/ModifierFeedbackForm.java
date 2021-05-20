/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.notifications.LocalNotification;
import com.codename1.notifications.LocalNotificationCallback;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.spinner.NumericSpinner;
import entites.Feedback;
import services.FeedbackService;

/**
 *
 * @author ayoub
 */
public class ModifierFeedbackForm extends Form implements LocalNotificationCallback {

    Form current;

    public ModifierFeedbackForm(Form res) {
        super("Modifier Feedback", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        current = this;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Feedbacks");
        getContentPane().setScrollVisible(true);

        Tabs swipe = new Tabs();
        Label s1 = new Label();
        Label s2 = new Label();

        FlowLayout flow = new FlowLayout(CENTER);
        flow.setValign(BOTTOM);
        Container radioContainer = new Container(flow);
        Component.setSameSize(radioContainer, s1, s2);
        add(LayeredLayout.encloseIn(swipe, radioContainer));

        TextField des = new TextField("", "Description");
        addStringValue("Description", des);

        NumericSpinner rating = new NumericSpinner();
        rating.setMax(6);
        rating.setMin(1);
        addStringValue("Rating", rating);

        Button btnModifier = new Button("Modifier");
        addStringValue("", btnModifier);

        btnModifier.addActionListener((ActionEvent e) -> {

            LocalNotification notif = new LocalNotification();
            notif.setId("feedback à été ajouter avec succes");
            notif.setAlertBody("feedback à été ajouter avec succes");
            notif.setAlertTitle("Feedback");
            localNotificationReceived("feedback");

            Display.getInstance().scheduleLocalNotification(
                    notif,
                    System.currentTimeMillis(), // fire date/time
                    LocalNotification.REPEAT_MINUTE // Whether to repeat and what frequency
            );

            try {

                if (des.getText().equals("")) {
                    Dialog.show("Veuillez remplir la description", "", "Annuler", "OK");

                } else {

                    InfiniteProgress ip = new InfiniteProgress();

                    final Dialog iDialog = ip.showInfiniteBlocking();
                    Feedback f = new Feedback();

                    f.setDescription(des.getText());
                    f.setRating((int) rating.getValue());

                    f.setDate("1111-22-22");
                    f.setIdAbonne(24);
                    f.setIdMembre(25);
                    FeedbackService.getInstance().modifierFeedback(f);
                    iDialog.dispose();

                    new ListerFeedbackForm(current).show();
                    refreshTheme();
                }

            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();

            }

        });
        
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK,e -> res.showBack());   

    }

    private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel"))
                .add(BorderLayout.CENTER, v));

    }

    public void bindButtonSelection(Button btn, Label l) {
        btn.addActionListener(e -> {
            if (btn.isSelected()) {
                updateArrowPosition(btn, l);
            }

        });
    }

    private void updateArrowPosition(Button btn, Label l) {
        l.getUnselectedStyle().setMargin(LEFT, btn.getX() + btn.getWidth() / 2 - l.getWidth() / 2);
    }

    @Override
    public void localNotificationReceived(String notificationId) {
        System.out.println("Received local notification " + notificationId + " in callback localNotificationReceived");
    }
}
