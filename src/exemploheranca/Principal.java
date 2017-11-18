
package exemploheranca;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
public class Principal {

    public static void main(String[] args) {
      ArrayList<Pessoa> vetor = new ArrayList<>();
      Pessoa novo;
      int op, op2;
      do{
        op = menuPrincipal();
        switch(op){
            case 1:
                do{
                    op2 = menuInserir();
                    if(op2!=0){
                        novo = cadastro(op2);
                        vetor.add(novo);
                    }
                }while(op2!=0);
                break;
            case 2:
                imprimir(vetor);
                break;
            case 3:
                calcQtdeAlunos(vetor);
                break;
            case 4:
                calcPercFuncionarios(vetor);
                break;
            case 5:
                calcMediaChProfessor(vetor);
                break;
            case 6:
                calcModa(vetor);
                break;
        }
        
      }while(op!=0);
    }
    private static int menuPrincipal(){
        int opcao;
        do{
        opcao = Integer.parseInt(JOptionPane.showInputDialog(
                "Menu de Opções\n"
                        + "0 - Sair\n"
                        + "1 - Inserir\n"
                        + "2 - Imprimir\n"
                        + "3 - Qtde de alunos\n"
                        + "4 - Percentual de Funcionários\n"
                        + "5 - Média da Ch dos Professores\n"
                        + "6 - Moda\n"));
            if(opcao<0 || opcao>6)
                JOptionPane.showMessageDialog(null, 
                        "Opção inválida!");
        }while(opcao<0 || opcao>6);
        return opcao;
    }

    private static int menuInserir() {
        int opcao;
        do{
        opcao = Integer.parseInt(JOptionPane.showInputDialog(
                "Escolha o objeto a ser inserido\n"
                        + "0 - Voltar ao menu anterior\n"
                        + "1 - Aluno\n"
                        + "2 - Funcionario\n"
                        + "3 - Professor\n"));
            if(opcao<0 || opcao>3)
                JOptionPane.showMessageDialog(null, 
                        "Opção inválida!");
        }while(opcao<0 || opcao>3);
        return opcao;
    }

    private static Pessoa cadastro(int op2) {
        Pessoa x;
        switch(op2){
            case 1:
                x = new Aluno();
                x.setNome(JOptionPane.showInputDialog(
                        "Digite o nome:"));
                x.setCpf(JOptionPane.showInputDialog(
                        "Digite o cpf:"));
                if(x instanceof Aluno){
                    ((Aluno)x).setMatricula(JOptionPane.showInputDialog(
                        "Digite a matricula:"));
                }   
                break;
            case 2:
                x = new Funcionario();
                x.setNome(JOptionPane.showInputDialog(
                        "Digite o nome:"));
                x.setCpf(JOptionPane.showInputDialog(
                        "Digite o cpf:"));
                if(x instanceof Funcionario){
                    ((Funcionario)x).setCt(JOptionPane.showInputDialog(
                        "Digite o nº da Carteira de Trabalho:"));
                }   
                break;
            default:
                x = new Professor();
                x.setNome(JOptionPane.showInputDialog(
                        "Digite o nome:"));
                x.setCpf(JOptionPane.showInputDialog(
                        "Digite o cpf:"));
                if(x instanceof Professor){
                    ((Professor)x).setCt(JOptionPane.showInputDialog(
                        "Digite o nº da Carteira de Trabalho:"));
                    ((Professor)x).setCh(Integer.parseInt(
                            JOptionPane.showInputDialog(
                        "Digite a qtde de carga horária:")));
                }   
                break;
        }
        return x;
    }

    private static void imprimir(ArrayList<Pessoa> vetor) {
        if(vetor.isEmpty())
            JOptionPane.showMessageDialog(null,"Lista vazia");
        else{
            String texto="";
            for (Pessoa pessoa : vetor) {
                texto = texto + pessoa.toString()+ "\n";
            }
            JOptionPane.showMessageDialog(null, texto);
        }
    }

    private static void calcQtdeAlunos(ArrayList<Pessoa> vetor) {
        int qtde =0;
        for (Pessoa p : vetor) {
            if(p instanceof Aluno){
                qtde++;
            }
        }
        JOptionPane.showMessageDialog(null, "A quantidade de "
                + "alunos é : " + qtde);
    }

    private static void calcPercFuncionarios(ArrayList<Pessoa> vetor) {
      int qtde=0;
      double perc;
        for (Pessoa p : vetor) {
            if(p instanceof Funcionario){
                qtde++;
            }
        }
        if(vetor.isEmpty()){
             JOptionPane.showMessageDialog(null, 
                     "lista vazia");
        }
        else{
            perc = (double)qtde/vetor.size()*100;
            JOptionPane.showMessageDialog(null, 
                     "O percentual de funcionarios: "
                             + perc + "%");
        }
    }

    private static void calcMediaChProfessor(ArrayList<Pessoa> vetor) {
        int qtde=0;
        int soma=0;
        double media;
        for (Pessoa p : vetor) {
            if(p instanceof Professor){
                qtde++;
                soma = soma + ((Professor)p).getCh();
            }
        }
        if (qtde==0){
              JOptionPane.showMessageDialog(null, 
                     "Não há professores cadastrados");   
        }
        else{
            media = (double)soma/qtde;
              JOptionPane.showMessageDialog(null, 
                     "A média da carga horária dos"
                      + "professores é "+ media);
        }
    }

    private static void calcModa(ArrayList<Pessoa> vetor) {
        String[] tipo = {"Aluno", "Funcionario", "Professor"};
        int [] qtde = {0, 0, 0};
        for (Pessoa p : vetor) {
            if (p instanceof Aluno)
                qtde[0]++;
            if (p instanceof Funcionario)
                qtde[1]++;
            if (p instanceof Professor)
                qtde[2]++;
        }
        // calculo da frequencia de cada objeto
        String texto="";
        for(int i = 0; i< tipo.length; i++){
            texto = texto + tipo[i] + " - " + qtde[i] + "\n";
        }
         JOptionPane.showMessageDialog(null, 
                     "A frequencia de cada objeto:\n"
                      +texto);
       
         //ordaneção
         int auxQtde;
         String auxTipo;
         for (int i = 0; i < qtde.length-1; i++) {
            for (int j = i+1; j < qtde.length; j++) {
                if(qtde[i]>qtde[j]){
                    auxQtde = qtde[i];
                    qtde[i] = qtde[j];
                    qtde[j] = auxQtde;
                    auxTipo = tipo[i];
                    tipo[i] = tipo[j];
                    tipo[j] = auxTipo;
                }
            }
        }
         JOptionPane.showMessageDialog(null, 
            "A moda é :\n"
            +tipo[tipo.length-1] + " com "
            +qtde[qtde.length-1] + " ocorrencias");  
    }
}