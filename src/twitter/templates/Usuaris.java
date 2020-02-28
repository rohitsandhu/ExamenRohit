package twitter.templates;

import java.util.ArrayList;
import twitter.templates.*;

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

    public abstract void demanarDades();

    public abstract void mostrarMenu();

    public ArrayList<Posts> getAlPosts() {
        return alPosts;
    }

    public void setAlPosts(ArrayList<Posts> alPosts) {
        this.alPosts = alPosts;
    }

    public void borrarPost(int numero) {
        int iterador = 1;
        for (Posts post : alPosts) {
            if (iterador == numero) {
                alPosts.remove(iterador - 1);
            }
            iterador++;
        }
    }

    public abstract String tornarClasse();

    public void llistarUser(String clase, ArrayList<Usuaris> alUsuaris) {
        System.out.println("**********************************");
        for (Usuaris user : alUsuaris) {

            if (user.getClass().getSimpleName().equals(clase)) {
            System.out.println( user.getUserName());
            }

        }
    }

    public ArrayList<Usuaris> getAutorsQueSegueixo() {
        return autorsQueSegueixo;
    }

    public void setAutorsQueSegueixo(ArrayList<Usuaris> autorsQueSegueixo) {
        this.autorsQueSegueixo = autorsQueSegueixo;
    }
}