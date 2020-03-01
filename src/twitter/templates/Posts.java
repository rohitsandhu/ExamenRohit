package twitter.templates;

import java.time.LocalDateTime;
// import twitter.templates.*;

public class Posts {

    private String titol, contingut;
    private boolean majors;
    private LocalDateTime ldt;
    private Usuaris user;
    
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

    
    public void demanarDadesPost() {
        this.contingut=(System.console().readLine(" Introduix contingut: "));
        System.out.println(" El contingut és per majors de 18 anys? (S/N)");
        String majors =System.console().readLine();
        if(majors.equalsIgnoreCase("S")){
            this.majors=true;
        }else{
            this.majors=false;
        }
        this.ldt = LocalDateTime.now();
    }

    public LocalDateTime getLdt() {
        return ldt;
    }

    public void setLdt(LocalDateTime ldt) {
        this.ldt = ldt;
    }

    public Usuaris getUser() {
        return user;
    }

    public void setUser(Usuaris user) {
        this.user = user;
    }
    
}