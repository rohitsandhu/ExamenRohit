package twitter.funcions;

import java.time.LocalDate;
import java.util.ArrayList;

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

    public static Usuaris buscarUsuari(String user, String contra, ArrayList<Usuaris> alUsuaris) {

        for (Usuaris u : alUsuaris) {
            if (user.equals(u.getUserName())) {
                if (contra.equals(u.getPassword())) {
                    System.out.println(" Usuari autentificat amb exit. ");
                    return u;
                }
            }
        }
        return null;
    }

    public static String buscarClasse(String user, String contra, ArrayList<Usuaris> alUsuaris) {

        for (Usuaris u : alUsuaris) {
            if (user.equals(u.getUserName())) {
                if (contra.equals(u.getPassword())) {
                    System.out.println(" Usuari autentificat amb exit. ");
                    return u.getClass().getSimpleName();
                }
            }
        }
        return null;
    }

    public static void mostrarMenuAdministrador() {
        System.out.println("**************************************");
        System.out.println(" 1 -> Crear un post ");
        System.out.println(" 2 -> Llistar tots els posts ");
        System.out.println(" 3 -> Eliminar un post ");
        System.out.println(" 4 -> Modificar un Lector a Autor ");
        System.out.println(" 5 -> Llistar Autor ");
        System.out.println(" 6 -> Llistar Lectors ");
        System.out.println(" 0 -> Log Out ");
        System.out.println("**************************************");
    }

    public static void mostrarMenuLector() {
        System.out.println("**************************************");
        System.out.println(" 1 -> Seguir a un Autor nou ");
        System.out.println(" 2 -> Veure els Autors que segueixo ");
        System.out.println(" 3 -> Mirar el teu mur ");
        System.out.println(" 0 -> Log Out ");
        System.out.println("**************************************");
    }

    public static void mostrarMenuAutor() {
        System.out.println("**************************************");
        System.out.println(" 1 -> Crear un Post ");
        System.out.println(" 2 -> Seguuir a un Autor nou ");
        System.out.println(" 3 -> Veure els editors que segueixo ");
        System.out.println(" 4 -> Mirar el teu mur ");
        System.out.println(" 0 -> Log Out ");
        System.out.println("**************************************");
    }
}