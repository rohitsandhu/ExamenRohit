package twitter.templates;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import twitter.templates.*;
import twitter.funcions.Funcions;

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
        this.major = true;
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
        // TODO Auto-generated method stub

    }

    // @Override
    // public void seguirAutor(String aSeguir, ArrayList<Usuaris> alUsuaris) {
    //     // TODO Auto-generated method stub

    // }

}