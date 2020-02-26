package twitter.templates;

public class Posts{

    private String titol, contingut;
    private boolean majors;
    private Usuaris ususari;

    public Posts(String titol) {
        this.titol = titol;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getContingut() {
        return contingut;
    }

    public void setContingut(String contingut) {
        this.contingut = contingut;
    }

    public boolean isMajors() {
        return majors;
    }

    public void setMajors(boolean majors) {
        this.majors = majors;
    }

    public Usuaris getUsusari() {
        return ususari;
    }

    public void setUsusari(Usuaris ususari) {
        this.ususari = ususari;
    }

    
    
}