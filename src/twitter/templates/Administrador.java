package twitter.templates;

import java.util.ArrayList;

import twitter.templates.*;

public class Administrador extends Usuaris {

    public Administrador(String userName) {
        super(userName);
    }

    @Override
    public void demanarDades() {

        while (true) {

            super.setPassword(System.console().readLine((" Escriu la contrasenya: ")));

            String contra = System.console().readLine(" Torna a escriure la contrasenya: ");

            if (contra.equals(super.getPassword())) {
                break;
            } else {
                System.out.println(" Les contrasenyes no coincideixen. ");
            }
        }
    }

    @Override
    public void mostrarMenu() {
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
        System.out.println("**********************************");
        for (Usuaris user : alUsuaris) {

            if (user.getClass().getSimpleName().equals(clase)) {
            System.out.println( user.getUserName());
            }

        }

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