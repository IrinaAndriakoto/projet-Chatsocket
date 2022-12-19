package affichage;
import java.awt.Color;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Fenetre extends JFrame {
    static JTextArea msgRecu;
    static JTextArea msgSent;
    JButton send;
    String userName;
    PrintWriter writer;
    String ipAddress = null;

    public JTextArea getMsgRecu(){
        return msgRecu;
    }
    public void setMsgRecu(JTextArea msg){
        msgRecu = msg;
    }
    public JTextArea getMsgSent(){
        return msgSent;
    }
    public void setMsgSent(JTextArea msg){
        msgSent = msg;
    }
    public JButton getButtonSend(){
        return this.send;
    }
    public void setButtonSend(JButton s){
        this.send = s;
    }
    public String getUserName(){
        return this.userName;
    }
    public void setUserName(String u){
        this.userName = u;
    }
    public PrintWriter getWriter(){
        return this.writer;
    }
    public void setWriter(PrintWriter w){
        this.writer = w;
    }
    public String getIpAddress(){
        return this.ipAddress;
    }
    public void setIpAddress(String i){
        this.ipAddress = i;
    }

    public Fenetre(){
        JTextArea msgRecu = new JTextArea(100,50);
        setMsgRecu(msgRecu);

        JTextArea msgSent = new JTextArea(100,50);
        setMsgSent(msgSent);

        JButton send = new JButton("Send");
        setButtonSend(send);

        String userName = "";
        setUserName(userName);

        PrintWriter w = null;
        setWriter(w);

        setBounds(0,0,400,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setVisible(true);

        getMsgRecu().setEditable(false);
        getMsgRecu().setBackground(Color.black);
        getMsgRecu().setText(" ");

        getMsgSent().setBackground(Color.cyan);
        getMsgSent().setText("Vous pouvez commencer a ecrire...");
    }
}
