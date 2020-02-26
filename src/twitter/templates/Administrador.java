package twitter.templates;

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
            }else{
                System.out.println(" Les contrasenyes no coincideixen. ");
            }
        }
    }

}