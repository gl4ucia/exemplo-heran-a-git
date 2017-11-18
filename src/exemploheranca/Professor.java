
package exemploheranca;

public class Professor extends Funcionario{
    private int ch;

    public Professor() {
    }

    public Professor(int ch, String ct, String nome, String cpf) {
        super(ct, nome, cpf);
        this.ch = ch;
    }

    public int getCh() {
        return ch;
    }

    public void setCh(int ch) {
        this.ch = ch;
    }

    @Override
    public String toString() {
        return super.toString()+"Professor{" + "ch=" + ch + '}';
    }
}
