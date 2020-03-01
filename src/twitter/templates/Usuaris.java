package twitter.templates;

import java.util.ArrayList;
// import twitter.templates.*;

public abstract class Usuaris {

    private String userName, password;
    private ArrayList<Posts> alPosts = new ArrayList<>();
    private ArrayList<Usuaris> autorsQueSegueixo = new ArrayList<>();

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

    public void afegirPostAlArray(Posts post) {
        this.alPosts.add(post);
    }



    public ArrayList<Posts> getAlPosts() {
        return alPosts;
    }

    public void setAlPosts(ArrayList<Posts> alPosts) {
        this.alPosts = alPosts;
    }


    public ArrayList<Usuaris> getAutorsQueSegueixo() {
        return autorsQueSegueixo;
    }

    public void setAutorsQueSegueixo(ArrayList<Usuaris> autorsQueSegueixo) {
        this.autorsQueSegueixo = autorsQueSegueixo;
    }

    public void afegirAutorASeguir(Usuaris resposta) {
        this.autorsQueSegueixo.add(resposta);
    }

    public abstract void llistarUser(String clase, ArrayList<Usuaris> alUsuaris);
    public abstract String tornarClasse();
    public abstract void demanarDades();
    public abstract void mostrarMenu();
    public abstract void mostrarMur(ArrayList<Usuaris> alUsuaris);


    public void seguirAutor(String aSeguir, ArrayList<Usuaris> alUsuaris) {
        for (Usuaris user : alUsuaris) {
            if (user.getUserName().equals(aSeguir)) {
                this.afegirAutorASeguir(user);
            }
        }
    }

    public void mostrarUsuarisSeguits() {
        for (Usuaris uu : autorsQueSegueixo) {
            System.out.println(uu.getUserName());
        }
    }


}