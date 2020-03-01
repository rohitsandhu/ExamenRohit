package twitter.templates;

import java.util.ArrayList;

// import twitter.templates.*;

public class Autor extends Usuaris {

    private boolean edat;

    public Autor(String userName) {
        super(userName);

    }

    @Override
    public void demanarDades() {

    }

    @Override
    public void mostrarMenu() {
        System.out.println("**************************************");
        System.out.println(" 1 -> Crear un Post ");
        System.out.println(" 2 -> Seguuir a un Autor nou ");
        System.out.println(" 3 -> Veure els editors que segueixo ");
        System.out.println(" 4 -> Mirar el teu mur ");
        System.out.println(" 0 -> Log Out ");
        System.out.println("**************************************");
    }

    @Override
    public String tornarClasse() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void llistarUser(String clase, ArrayList<Usuaris> alUsuaris) {
        System.out.println("**********************************");

        for (Usuaris user : alUsuaris) {

            if (user.getClass().getSimpleName().equals(clase)
                    && user.getClass().getSimpleName() != this.getUserName()) {
                System.out.println(user.getUserName());
            }
        }
        System.out.println("**********************************");
    }

    @Override
    public void mostrarMur(ArrayList<Usuaris> alUsuaris) {


        for (Usuaris user : alUsuaris) {
            
            for (Posts post : user.getAlPosts()) {
                if(user.getClass().getSimpleName().equals("Adminitrador")){
                    System.out.println("*******************************");
                    System.out.println("Data: " + post.getLdt().getDayOfMonth() + "/" + post.getLdt().getMonthValue() + "/"
                            + post.getLdt().getYear() + " - " + post.getLdt().getHour() + ":" + post.getLdt().getMinute());
                    System.out.println(" Autor: " + post.getUser().getUserName());
                    System.out.println(" + 18 ? " + Boolean.toString(post.isMajors()));
                    System.out.println(" Titol: " + post.getTitol());
                    System.out.println(" Contingut: " + post.getContingut());
                    System.out.println("*******************************");
                }
            }
        }
        for (Usuaris u : this.getAutorsQueSegueixo()) {

            for (Posts p : u.getAlPosts()) {
                System.out.println("*******************************");
                System.out.println("Data: " + p.getLdt().getDayOfMonth() + "/" + p.getLdt().getMonthValue() + "/"
                        + p.getLdt().getYear() + " - " + p.getLdt().getHour() + ":" + p.getLdt().getMinute());
                System.out.println(" Autor: " + p.getUser().getUserName());
                System.out.println(" + 18 ? " + Boolean.toString(p.isMajors()));
                System.out.println(" Titol: " + p.getTitol());
                System.out.println(" Contingut: " + p.getContingut());
                System.out.println("*******************************");
            }
        }

    }

}