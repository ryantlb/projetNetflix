package Controleur;
import Modele.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Mise_a_jour {

    // Methode ajout video de la direction
    public void ajoutervid(Direction obj1, Video obj2) {
        VideoDao videodao = new VideoDao();
        DirectionDao directiondao = new DirectionDao();
        videodao.ajouter(obj2);
        directiondao.maj(obj1, obj2);
    }
    //

    // Methode ajout de liste personnalisé du client

    // Creation de liste

    public void ajouterlist(Liste_client obj) {
        Liste_clientDao listeClientDao = new Liste_clientDao();
        listeClientDao.ajouter(obj);
    }

    // Ajout de video dans une liste

    public void ajoutervidlist(Liste_client obj1, Video obj2){
        Liste_clientDao listeClientDao=new Liste_clientDao();
        VideoDao videoDao=new VideoDao();
        listeClientDao.contient(obj1, obj2);
    }

    //

    // Methode ajout de Video dans Visionne ie video vue par le client

    public void ajoutvisionne(Client obj1, Video obj2){
        Visionne visionne=new Visionne(obj2.getId_video(), obj1.getId(), Date.valueOf(LocalDate.now()));
        visionne.setVue(0);
        VisionneDao visionneDao=new VisionneDao();
        List<Visionne> visionneList=visionneDao.lister();

        // ajout si la vidéo n'a pas déjà été vu sinon update

        int a=0;
        for(Visionne value : visionneList){
            if(value.getId_client()==obj1.getId() && value.getId_video()==obj2.getId_video()){
                value.setDate_v(Date.valueOf(LocalDate.now()));
                visionneDao.update(value);
                a++;
            }
        }
        if(a==0){
            visionneDao.ajouter(visionne);
        }

    }

    // Methode note_client

    public void note_visionne(Client obj1, Video obj2, int note_client){
        VisionneDao visionneDao=new VisionneDao();
        List<Visionne> visionneList=visionneDao.lister();

        Visionne vis=new Visionne();

        int a=0;
        for(Visionne value : visionneList){
            if(value.getId_client()==obj1.getId() && value.getId_video()==obj2.getId_video()){
                vis=value;
                a++;
            }
        }

        // Si le client n'a pas visualisé la video mais veut mettre une note, on part du principe qu'il a deja du la voir
        // On ajoute ainsi avant la video dans la BDD

        if(a==0){
            this.ajoutvisionne(obj1,obj2);
        }

        vis.setNote(note_client);
        vis.setVue(1);
        visionneDao.update(vis);
    }
}