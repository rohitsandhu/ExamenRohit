package twitter.templates;

import java.util.ArrayList;

public abstract class Usuaris {

    protected String userName, password;
    protected ArrayList<Usuaris> alUsuaris;

    public Usuaris(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract void demanarDades();

    public ArrayList<Usuaris> getAlUsuaris() {
        return alUsuaris;
    }

    public void setAlUsuaris(ArrayList<Usuaris> alUsuaris) {
        this.alUsuaris = alUsuaris;
    }

    public void afegirAlArrayUsuaris(Usuaris user){
        this.alUsuaris.add(user);
    }

    
}