package Controleur;

import Modele.*;

import java.util.List;

/** Classe Login, permet l'inscription et la connxeion du client et de l'admin*/
public class Login {
    /** Methode d'inscription*/
    public void signUp(Client client){
        ClientDAO clientdao= new ClientDAO();
        clientdao.ajouter(client);
        List<Client> list_c=clientdao.lister();

        // On récupère son id
        client.setId(list_c.get(list_c.size()-1).getId());
        System.out.println(client.getId());

        // Creation de la liste personnalisée du client
        Liste_clientDao listeClientDao=new Liste_clientDao();
        Liste_client list=new Liste_client("Ma Liste","",client.getId());

        listeClientDao.ajouter(list);
    }

    /** Methode de connection client*/
    public boolean signIn(Client client){
        ClientDAO clientdao= new ClientDAO();
        List<Client> clientList;
        clientList=clientdao.lister();

        for (Client value : clientList) {
            Client client1;
            client1 = value;
            if (client1.getEmail().equals(client.getEmail()) && client1.getMdp().equals(client.getMdp())) {
                client.setId(client1.getId());
                return true;
            }
        }
        return false;
    }

    /** Methode de connection Direction*/
    public boolean SignDirection(Direction direction)
    {
        DirectionDao directiondao =  new DirectionDao();
        List<Direction> directionList;
        directionList = directiondao.lister();

        for( Direction value : directionList){
           Direction direction1;
           direction1=value;
           if(direction1.getEmail_ad().equals(direction.getEmail_ad()) && direction1.getMdp_ad().equals(direction.getMdp_ad())){
               direction.setId_admin(direction1.getId_admin());
                return true;
            }
        }
        return false;
    }}
