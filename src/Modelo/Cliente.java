package Modelo;

public class Cliente {

    public int id;
    public String nome;
    public String tel_Residencial;
    public String tel_Comercial;
    public String tel_Celular;
    public String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTel_Residencial() {
        return tel_Residencial;
    }

    public void setTel_Residencial(String tel_Residencial) {
        this.tel_Residencial = tel_Residencial;
    }

    public String getTel_Comercial() {
        return tel_Comercial;
    }

    public void setTel_Comercial(String tel_Comercial) {
        this.tel_Comercial = tel_Comercial;
    }

    public String getTel_Celular() {
        return tel_Celular;
    }

    public void setTel_Celular(String tel_Celular) {
        this.tel_Celular = tel_Celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
