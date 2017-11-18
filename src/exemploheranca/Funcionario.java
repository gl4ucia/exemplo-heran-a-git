
package exemploheranca;

public class Funcionario extends Pessoa{
    private String ct;

    public Funcionario() {
    }

    public Funcionario(String ct, String nome, String cpf) {
        super(nome, cpf);
        this.ct = ct;
    }

    public String getCt() {
        return ct;
    }

    public void setCt(String ct) {
        this.ct = ct;
    }

    @Override
    public String toString() {
        return super.toString()+"Funcionario{" + "ct=" + ct + '}';
    } 
}
