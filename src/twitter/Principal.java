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
        System.out.println("************* TwitterPocho ****************");
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

                        Usuaris usuariLoged = Funcions.buscarUsuari(user, alUsuaris);
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
                                            usuariLoged.mostrarMur(alUsuaris);
                                            break;

                                        case 3:
                                            // usuariLoged.mostrarMur(alUsuaris);
                                            if(Funcions.llistarPosts(alUsuaris)){
                                                Funcions.borrarPost(alUsuaris,Integer.parseInt(System.console().readLine()));
                                            }else{
                                                System.out.println(" No hi ha posts");
                                            }
                                            
                                            
                                            break;

                                        case 4:
                                            System.out.println(
                                                    " Escriu el nom del usuari Lector que vols convertir en Autor: (ENTER per veure tots els usuaris Lectors) ");
                                            String futurAutor = System.console().readLine();
                                            if (futurAutor.equals("")) {
                                                usuariLoged.llistarUser("Lector", alUsuaris);
                                                futurAutor = System.console().readLine();
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
                                    opció = Integer.parseInt(System.console().readLine());
                                    switch (opció) {
                                        case 0:

                                            break bucle;
                                        case 1:
                                            System.out.println(
                                                    " Escriu el nom del Autor que vols seguir: (ENTER per veure tots els usuaris Autors ) ");
                                            String resposta = System.console().readLine();
                                            if (resposta.equals("")) {
                                                usuariLoged.llistarUser("Autor", alUsuaris);
                                                resposta = System.console().readLine();
                                            }
                                            usuariLoged.seguirAutor(resposta, alUsuaris);
                                            break;
                                        case 2:
                                            usuariLoged.mostrarUsuarisSeguits();
                                            break;
                                        case 3:
                                            usuariLoged.mostrarMur(alUsuaris);
                                            break;

                                    }
                                    break;

                                case "Autor":
                                    usuariLoged.mostrarMenu();
                                    opció = Integer.parseInt(System.console().readLine());
                                    switch (opció) {
                                        case 0:

                                            break bucle;

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
                                            System.out.println(
                                                    " Escriu el nom del Autor que vols seguir: (ENTER per veure tots els usuaris Autors ) ");
                                            String resposta = System.console().readLine();
                                            if (resposta.equals("")) {
                                                usuariLoged.llistarUser("Autor", alUsuaris);
                                                resposta = System.console().readLine();
                                            }
                                            usuariLoged.seguirAutor(resposta, alUsuaris);
                                            break;

                                        case 3:
                                            usuariLoged.mostrarUsuarisSeguits();
                                            break;

                                        case 4:
                                            usuariLoged.mostrarMur(alUsuaris);
                                            break;
                                    }
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