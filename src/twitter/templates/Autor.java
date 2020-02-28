package twitter.templates;
import twitter.templates.*;

public class Autor extends Usuaris{

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
    
}