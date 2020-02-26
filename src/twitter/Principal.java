package twitter;

import java.util.ArrayList;

import twitter.funcions.Funcions;
import twitter.templates.Administrador;
import twitter.templates.Lector;
import twitter.templates.Posts;
import twitter.templates.Usuaris;

public class Principal {
    public static void main(String[] args) {

        ArrayList<Usuaris> alUsuaris = new ArrayList<>();
        ArrayList<Posts> alPosts = new ArrayList<>();
        System.out.println(" ");
        System.out.println("*******************************************");
        System.out.println("**************TwitterPocho*****************");
        System.out.println("*******************************************");
        System.out.println(" ");
        System.out.println(" Escriu el nom d'usuari del administrador: ");
        Administrador admin = new Administrador(System.console().readLine());
        admin.demanarDades();

        alUsuaris.add(admin);

        mainBuncle: while (true) {

            Funcions.mostrarMenuPrincipal();
            int opció = Integer.parseInt(System.console().readLine());

            switch (opció) {

            case 1:
                String user = System.console().readLine(" Escriu el nom d'usuari: ");
                String contra = System.console().readLine(" Escriu la contrasenya: ");
                System.out.println(" ");
                if (Funcions.comprovarUsuari(user, contra, alUsuaris)) {

                    String classe = Funcions.buscarClasse(user, contra, alUsuaris);
                    switch (classe) {
                    case "Administrador":

                        Funcions.mostrarMenuAdministrador();

                        opció = Integer.parseInt(System.console().readLine());

                        switch (opció) {
                        case 1:

                        System.out.println(" Escriu el titol del post: ");
                            break;

                        case 2:

                            break;

                        case 3:

                            break;

                        case 4:

                            break;

                        case 5:

                            break;

                        case 6:

                            break;

                        case 7:

                            break;
                        }

                        break;

                    case "Lector":
                        Funcions.mostrarMenuLector();
                        break;

                    case "Autor":
                        Funcions.mostrarMenuAutor();
                        break;

                    }
                } else {
                    System.out.println(" El nom o la contrasenya son incorrectes: ");
                }
                break;
            case 2:
                System.out.println(" Escriu el nom del usuari lector: ");
                Lector lector = new Lector(System.console().readLine());
                lector.demanarDades();
                alUsuaris.add(lector);
                break;
            case 3:

                break mainBuncle;
            }

        }
    }
}