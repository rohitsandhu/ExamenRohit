package twitter.templates;

import java.util.ArrayList;

import twitter.funcions.Funcions;
import twitter.templates.*;

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
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void llistarUser(String clase, ArrayList<Usuaris> alUsuaris) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mostrarMur() {
        for (Usuaris u : super.getAutorsQueSegueixo()) {

            for (Posts p : super.getAlPosts()) {
                System.out.println("*******************************");
                System.out.println("Data: " + p.getLdt().getDayOfMonth() + "/" + p.getLdt().getMonthValue() + "/"
                        + p.getLdt().getYear() + " - " + p.getLdt().getHour() + ":" + p.getLdt().getMinute());
                        System.out.println(" Autor: "+p.getUser().getUserName());
                        System.out.println(" + 18 ? "+Boolean.toString(p.isMajors()));
                        System.out.println(" Titol: "+ p.getTitol());
                        System.out.println(" Contingut: "+p.getContingut());
                System.out.println("*******************************");
            }
        }

    }

    // @Override
    // public void seguirAutor(String aSeguir, ArrayList<Usuaris> alUsuaris) {

    // }

}