package twitter.funcions;

import java.net.Authenticator;
import java.time.LocalDate;
import java.util.ArrayList;

import twitter.templates.Autor;
import twitter.templates.Posts;
import twitter.templates.Usuaris;

public class Funcions {

    public static void mostrarMenuPrincipal() {

        System.out.println("*******************************");
        System.out.println(" 1 -> Login ");
        System.out.println(" 2 -> Registre com a lector ");
        System.out.println(" 3 -> Sortir ");
        System.out.println("*******************************");
    }

    public static boolean comprovarUsuari(String user, String contra, ArrayList<Usuaris> alUsuaris) {

        for (Usuaris u : alUsuaris) {
            if (user.equals(u.getUserName())) {
                if (contra.equals(u.getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Usuaris buscarUsuari(String user,  ArrayList<Usuaris> alUsuaris) {

        for (Usuaris u : alUsuaris) {
            if (user.equals(u.getUserName())) {
                
                    return u;
                
            }
        }
        return null;
    }

    public static void llistarPosts(ArrayList<Posts> alPosts) {
        int iterador = 1;
        System.out.println("************************************************************************");
        for (Posts post : alPosts) {
            System.out.println(iterador + " - " + "Data: " + post.getLdt().getDayOfMonth() + "/"
                    + post.getLdt().getMonthValue() + "/" + post.getLdt().getYear() + " - " + post.getLdt().getHour()
                     + " - " + "Autor: " + post.getUser().getUserName() + " - "
                    + "Titol: " + post.getTitol());

            iterador++;
        }
    }

    public static void canviarClasse(ArrayList<Usuaris> alUsuaris, String futurAutor) {
        int iterador = 0;
        for (Usuaris user : alUsuaris) {
            if (user.getUserName().equals(futurAutor)) {
                Autor aut = new Autor(user.getUserName());
                aut.setPassword(user.getPassword());

                alUsuaris.remove(iterador);
                alUsuaris.add(aut);
                break;
            }

            iterador++;
        }

    }

}