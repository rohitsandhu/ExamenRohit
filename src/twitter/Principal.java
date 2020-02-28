package twitter;

import java.util.ArrayList;

import twitter.funcions.Funcions;
import twitter.templates.*;

public class Principal {
    public static void main(String[] args) {

        ArrayList<Usuaris> alUsuaris = new ArrayList<>();
        // ArrayList<Posts> alPosts = new ArrayList<>();
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

                        Usuaris usuariLoged = Funcions.buscarUsuari(user, contra, alUsuaris);
                        String classe = usuariLoged.tornarClasse();
                        bucle: while (true) {

                            switch (classe) {

                                case "Administrador":
                                    usuariLoged.mostrarMenu();
                                    opció = Integer.parseInt(System.console().readLine());

                                    switch (opció) {
                                        case 1:

                                            System.out.println(" Escriu el titol del post: el post creat per: "
                                                    + usuariLoged.getUserName());
                                            Posts post = new Posts(System.console().readLine());
                                            post.demanarDadesPost();
                                            post.setUser(usuariLoged);
                                            usuariLoged.afegirPostAlArray(post);
                                            System.out.println(" El post s'ha afegit correctament. ");
                                            break;

                                        case 2:
                                            Funcions.llistarPosts(usuariLoged.getAlPosts());
                                            break;

                                        case 3:
                                            Funcions.llistarPosts(usuariLoged.getAlPosts());

                                            usuariLoged.borrarPost(Integer.parseInt(System.console().readLine()));
                                            break;

                                        case 4:
                                            System.out.println(
                                                    " Escriu el nom del usuari Lector que vols convertir en Autor: (Enter per veure tots els usuaris Lectors) ");
                                            String futurAutor = System.console().readLine();
                                            if (futurAutor.equals("")) {
                                                usuariLoged.llistarUser("Lector", alUsuaris);
                                                futurAutor=System.console().readLine();
                                            }

                                            Funcions.canviarClasse(alUsuaris, futurAutor);

                                            break;

                                        case 5:
                                            usuariLoged.llistarUser("Autor", alUsuaris);
                                            break;

                                        case 6:
                                            usuariLoged.llistarUser("Lector", alUsuaris);
                                            break;

                                        case 0:
                                            break bucle;
                                    }

                                    break;

                                case "Lector":
                                    usuariLoged.mostrarMenu();
                                    break;

                                case "Autor":
                                    usuariLoged.mostrarMenu();
                                    break;

                            }
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