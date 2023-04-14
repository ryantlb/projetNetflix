package Controleur;

import Modele.*;

import java.util.List;

public class Login {

    public void signUp(Client client){
        ClientDAO clientdao= new ClientDAO();
        clientdao.ajouter(client);
    }

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

    public boolean SignDirection(Direction direction)
    {
        DirectionDao directiondao =  new DirectionDao();
        List<Direction> directionList;
        directionList = directiondao.lister();

        for( Direction value : directionList){
           Direction direction1;
           direction1=value;
           if(direction1.getEmail_ad().equals(direction.getEmail_ad()) && direction1.getMdp_ad().equals(direction.getMdp_ad())){
                return true;
            }
        }
        return false;
    }}
