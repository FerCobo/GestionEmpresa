package Modelo;

public class login {
    private int id;
    private String nameEmp;
    private String cif;
    private String place;
    private String user;
    private String pass;
    private String mail;
    private int phone;

    public login() {
    }

    public login(int id, String nameEmp, String cif, String place, String user, String pass, String mail, int phone) {
        this.id = id;
        this.nameEmp = nameEmp;
        this.cif = cif;
        this.place = place;
        this.user = user;
        this.pass = pass;
        this.mail = mail;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameEmp() {
        return nameEmp;
    }

    public void setNameEmp(String nameEmp) {
        this.nameEmp = nameEmp;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    
    
    
}
