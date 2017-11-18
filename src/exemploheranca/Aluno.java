
package exemploheranca;

public class Aluno extends Pessoa{
    private String matricula;

    public Aluno() {
        super();
    }

    public Aluno(String matricula, String nome, String cpf) {
        super(nome, cpf);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return super.toString()+"Aluno{" + "matricula=" + matricula + '}';
    }   
}
