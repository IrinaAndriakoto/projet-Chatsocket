package inc;

import affichage.*;

public class Fonction {
    Fenetre fen;
    public void sendMessage(){
        fen.getWriter().println(fen.getUserName() + " : " + fen.getMsgSent().getText());
        fen.getWriter().flush();

        fen.getMsgRecu().append("\nMe: "+ fen.getMsgSent().getText());
        fen.getMsgSent().setText(" ");
    }
    public Fonction(Fenetre f){
        this.fen = f;
    }
}
