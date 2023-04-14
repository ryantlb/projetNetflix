package Vue;

import Controleur.ListageVideos;
import Modele.Video;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.List;

public class Catalogue_video extends JFrame{
    private JPanel mainpanel;
    private JTabbedPane tab;
    private JTextField searchbar;

    private JList<Video> list_rec;
    private JList<Video> list_rec2;
    private JButton searchbutton;
    private JPanel panel2;
    private JLabel titre2;
    private JPanel panel1;
    private JLabel cat1;
    private JLabel cat2;
    private JList<Video> list1;
    private JList<Video> list2;
    private JList<Video> list3;
    private JList<Video> list4;
    private JList<Video> list5;
    private JList<Video> list6;
    private JLabel cat3;
    private JLabel cat4;

    private JLabel cat5;
    private JLabel cat6;
    private JRadioButton note5RB;
    private JRadioButton note8RB;
    private JLabel poplabel;
    private JPanel panel_rec;
    private JComboBox choixbox;


    public Catalogue_video(){
        setLayout(null);

        setContentPane(mainpanel);
        this.pack();
        this.setDefaultLookAndFeelDecorated(true);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Interface Utilisateur");
        setVisible(true);

        // barre de recherche

        searchbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DefaultListModel<Video> model_rec2 = new DefaultListModel<>();
                ListageVideos list2=new ListageVideos();

                String ch= choixbox.getSelectedItem().toString();

                // filtre en fonction des choix de l'utilisateur : popularité, acteur, titre, réalisateur

                if(note5RB.isSelected()) {
                    List<Video> vidlist_rec2 = list2.recherche_sp(searchbar.getText(), ch);
                    List<Video> filtre = list2.filtre(vidlist_rec2,0);
                    for (Video value : filtre) {
                        model_rec2.addElement(value);
                    }
                    list_rec2 = new JList<>(model_rec2);
                    list_rec2.setCellRenderer(new VideoRenderer());
                    list_rec2.setLayoutOrientation(JList.HORIZONTAL_WRAP);
                    list_rec2.setVisibleRowCount(2);
                    list_rec.setModel(model_rec2);
                } else if (note8RB.isSelected()) {
                    List<Video> vidlist_rec2 = list2.recherche_sp(searchbar.getText(), ch);
                    List<Video> filtre = list2.filtre(vidlist_rec2,1);
                    for (Video value : filtre) {
                        model_rec2.addElement(value);
                    }
                    list_rec2 = new JList<>(model_rec2);
                    list_rec2.setCellRenderer(new VideoRenderer());
                    list_rec2.setLayoutOrientation(JList.HORIZONTAL_WRAP);
                    list_rec2.setVisibleRowCount(2);
                    list_rec.setModel(model_rec2);
                }
                else {
                    List<Video> vidlist_rec2 = list2.recherche_sp(searchbar.getText(), ch);
                    for (Video value : vidlist_rec2) {
                        model_rec2.addElement(value);
                    }
                    list_rec2 = new JList<>(model_rec2);
                    list_rec2.setCellRenderer(new VideoRenderer());
                    list_rec2.setLayoutOrientation(JList.HORIZONTAL_WRAP);
                    list_rec2.setVisibleRowCount(2);
                    list_rec.setModel(model_rec2);
                }

            }
        });

        //

        list1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {

                    // Double-click detected
                    int index = list.locationToIndex(evt.getPoint());
                    Video video= (Video) list.getModel().getElementAt(index);
                    new Page_video(video);
                }
            }
        });

        list2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {

                    // Double-click detected
                    int index = list.locationToIndex(evt.getPoint());
                    Video video= (Video) list.getModel().getElementAt(index);
                    new Page_video(video);
                }
            }
        });

        list3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {

                    // Double-click detected
                    int index = list.locationToIndex(evt.getPoint());
                    Video video= (Video) list.getModel().getElementAt(index);
                    new Page_video(video);
                }
            }
        });

        list4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {

                    // Double-click detected
                    int index = list.locationToIndex(evt.getPoint());
                    Video video= (Video) list.getModel().getElementAt(index);
                    new Page_video(video);
                }
            }
        });

        list5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {

                    // Double-click detected
                    int index = list.locationToIndex(evt.getPoint());
                    Video video= (Video) list.getModel().getElementAt(index);
                    new Page_video(video);
                }
            }
        });

        list6.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {

                    // Double-click detected
                    int index = list.locationToIndex(evt.getPoint());
                    Video video= (Video) list.getModel().getElementAt(index);
                    new Page_video(video);
                }
            }
        });

        list_rec.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {

                    // Double-click detected
                    int index = list.locationToIndex(evt.getPoint());
                    Video video= (Video) list.getModel().getElementAt(index);
                    new Page_video(video);
                }
            }
        });

    }


    private void createUIComponents() {
        // TODO: place custom component creation code here

        // Liste de liste de video par categorie;
        ListageVideos listageVideos=new ListageVideos();
        List<List<Video>> liste_cat=listageVideos.Liste_cat();

        // Liste par categorie :

        // Liste 1 filme Drame (catégorie 3)
        DefaultListModel<Video> model1 = new DefaultListModel<>();
        List<Video> vidlist1=liste_cat.get(2);
        for(Video value: vidlist1){
            model1.addElement(value);
        }
        list1=new JList<>(model1);
        list1.setCellRenderer(new VideoRenderer());
        list1.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list1.setVisibleRowCount(1);

        //Liste 2 film Comedie (categorie 2)

        DefaultListModel<Video> model2 = new DefaultListModel<>();

        List<Video> vidlist2=liste_cat.get(1);
        for(Video value: vidlist2){
            model2.addElement(value);
        }
        list2=new JList<>(model2);
        list2.setCellRenderer(new VideoRenderer());
        list2.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list2.setVisibleRowCount(1);

        //Liste 3 film Fiction (categorie 4)

        DefaultListModel<Video> model3 = new DefaultListModel<>();

        List<Video> vidlist3=liste_cat.get(3);
        for(Video value: vidlist3){
            model3.addElement(value);
        }
        list3=new JList<>(model3);
        list3.setCellRenderer(new VideoRenderer());
        list3.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list3.setVisibleRowCount(1);

        //Liste 4 film Fiction (categorie 4)

        DefaultListModel<Video> model4 = new DefaultListModel<>();

        List<Video> vidlist4=liste_cat.get(4);
        for(Video value: vidlist4){
            model4.addElement(value);
        }
        list4=new JList<>(model4);
        list4.setCellRenderer(new VideoRenderer());
        list4.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list4.setVisibleRowCount(1);

        //Liste 5 film Fiction (categorie 5)

        DefaultListModel<Video> model5 = new DefaultListModel<>();

        List<Video> vidlist5=liste_cat.get(5);
        for(Video value: vidlist5){
            model5.addElement(value);
        }
        list5=new JList<>(model5);
        list5.setCellRenderer(new VideoRenderer());
        list5.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list5.setVisibleRowCount(1);


        //Liste 6 film Fiction (categorie 6)

        DefaultListModel<Video> model6 = new DefaultListModel<>();

        List<Video> vidlist6=liste_cat.get(0);
        for(Video value: vidlist6){
            model6.addElement(value);
        }
        list6=new JList<>(model6);
        list6.setCellRenderer(new VideoRenderer());
        list6.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list6.setVisibleRowCount(1);

        DefaultListModel<Video> model_rec = new DefaultListModel<>();
        ListageVideos list=new ListageVideos();

        List<Video> vidlist_rec=list.recherche("");
        for(Video value: vidlist_rec){
            model_rec.addElement(value);
        }
        list_rec=new JList<>(model_rec);
        list_rec.setCellRenderer(new VideoRenderer());
        list_rec.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list_rec.setVisibleRowCount(2);
    }

    public static void main(String[] args) {
        Catalogue_video c=new Catalogue_video();

    }
}
