package twitter.templates;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

// import twitter.templates.*;

public class Lector extends Usuaris {

    private boolean major;

    public Lector(String userName) {
        super(userName);
    }

    @Override
    public void demanarDades() {
        super.setPassword(System.console().readLine((" Escriu la contrasenya: ")));
        String edat = System.console().readLine(" Escriu l'edat de neixament (dd/mm/yyyyy)");

        this.setMajor(edat);
    }

    public boolean isMajor() {
        return major;
    }

    public void setMajor(String edat) {
        String[] arrayLD = edat.split("/");
        int[] arrayLDint = new int[3];
        for (int i = 0; i < arrayLD.length; i++) {
            arrayLDint[i] = Integer.parseInt(arrayLD[i]);
        }

        LocalDate ld = LocalDate.of(arrayLDint[2], arrayLDint[1], arrayLDint[0]);

        Period periodi = Period.between(ld, LocalDate.now());

        if (periodi.getYears() >= 18) {
            this.major = true;
        }
        this.major = false;
    }

    @Override
    public void mostrarMenu() {
        System.out.println("**************************************");
        System.out.println(" 1 -> Seguir a un Autor nou ");
        System.out.println(" 2 -> Veure els Autors que segueixo ");
        System.out.println(" 3 -> Mirar el teu mur ");
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

                if (post.getUser().tornarClasse().equals("Administrador")) {
                    if ((post.isMajors()==true && this.isMajor()==true) || (post.isMajors()==false && this.isMajor()==false) || (post.isMajors()==false && this.isMajor()==true)) {
                        System.out.println("*******************************");
                        System.out.println("Data: " + post.getLdt().getDayOfMonth() + "/"
                                + post.getLdt().getMonthValue() + "/" + post.getLdt().getYear() + " - "
                                + post.getLdt().getHour() + ":" + post.getLdt().getMinute());
                        System.out.println(" Autor: " + post.getUser().getUserName());
                        System.out.println(" + 18 ? " + Boolean.toString(post.isMajors()));
                        System.out.println(" Titol: " + post.getTitol());
                        System.out.println(" Contingut: " + post.getContingut());
                        System.out.println("*******************************");
                    }else {
                        System.out.println(" El contingut ha sigut restingit a causa de la teva edat. ");
                    }
                } 

            }
        }
        for (Usuaris u : this.getAutorsQueSegueixo()) {
            for (Posts p : u.getAlPosts()) {
                if (!p.isMajors() || this.isMajor() || p.isMajors() && this.isMajor()) {

                    System.out.println("*******************************");
                    System.out.println("Data: " + p.getLdt().getDayOfMonth() + "/" + p.getLdt().getMonthValue() + "/"
                            + p.getLdt().getYear() + " - " + p.getLdt().getHour() + ":" + p.getLdt().getMinute());
                    System.out.println(" Autor: " + p.getUser().getUserName());
                    System.out.println(" + 18 ? " + Boolean.toString(p.isMajors()));
                    System.out.println(" Titol: " + p.getTitol());
                    System.out.println(" Contingut: " + p.getContingut());
                    System.out.println("*******************************");
                } else {
                    System.out.println(" El contingut ha sigut restingit a causa de la teva edat. ");
                }
            }

        }

    }

    public void setMajor(boolean major) {
        this.major = major;
    }

}