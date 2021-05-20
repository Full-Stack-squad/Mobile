/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.ui.Button;
import com.codename1.ui.Dialog;

import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.table.DefaultTableModel;
import com.codename1.ui.table.Table;
import com.codename1.ui.table.TableModel;
import entites.Feedback;
import entites.User;
import java.util.ArrayList;
import services.FeedbackService;

/**
 *
 * @author ayoub
 */
public class ListerFeedbackForm extends Form {

    Form current;

    public ListerFeedbackForm(Form previous) {

        setTitle("Feedbacks");

        current = this;
        setLayout(BoxLayout.y());

        ArrayList<Feedback> al = FeedbackService.getInstance().getFeedbacks();
        String[][] o = new String[al.size()][2];

        for (int i = 0; i < al.size(); i++) {
            o[i][0] = al.get(i).getDescription();
            o[i][1] = Integer.toString(al.get(i).getRating()) + "  stars";

            System.out.println("yes" + i);
        }

        TableModel model = new DefaultTableModel(new String[]{"Description", "Rating"}, o) {
            public boolean isCellEditable(int row, int col) {
                return col != 0;
            }
        };
        Table table = new Table(model);
        current.add(new Label("Liste des feedbacks"));
        current.add(table);
        Button btnA = new Button("Ajouter");
        Button btnM = new Button("Modifier");
        Button btnS = new Button("Supprimer");
        current.add(btnA);
        current.add(btnM);
        current.add(btnS);

        btnA.addActionListener((ActionEvent e) -> {
            
                new AjoutFeedbackForm(current).show();
            

        });
        btnM.addActionListener((ActionEvent e) -> {
           
            new ModifierFeedbackForm(current).show();
        });
        btnS.addActionListener((ActionEvent e) -> {
            FeedbackService.getInstance().supprimerFeedback();
            new ListerFeedbackForm(current).show();
        });

        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }

}
