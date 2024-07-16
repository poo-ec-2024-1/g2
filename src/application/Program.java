package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import br.ufg.poo.g2.DadosDeCadastro;
import br.ufg.poo.g2.Passageiro;
import br.ufg.poo.g2.PassageiroDAO;

public class Program {
	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		PassageiroDAO passageiroDAO = new PassageiroDAO();
		List<Passageiro> todosPasssageiros = new ArrayList<>();
		
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("CPF: ");
		String CPF = sc.next();
		System.out.print("Data de nascimento: (dd/MM/yyyy): ");
		Date nascimento = sdf.parse(sc.next());
		
		List<Passageiro> todosPassageiros = passageiroDAO(nome, CPF, nascimento);
		DadosDeCadastro dados = new DadosDeCadastro(nome, CPF, nascimento);
		System.out.println("DADOS DE CADASTRO " + dados);
	
		
        System.out.println("Todos os passageiros:");
        for (Passageiro passageiro : todosPassageiros) {
            System.out.println(passageiro);
        }

        Passageiro passageiroEncontrado = passageiroDAO.buscarPassageiroPorNome("João");
        if (passageiroEncontrado != null) {
            System.out.println("\nPassageiro encontrado:");
            System.out.println(passageiroEncontrado);
        } else {
            System.out.println("\nPassageiro não encontrado.");
        }

        boolean passageiroAtualizado = passageiroDAO.atualizarPassageiro("Maria", 26);
        if (passageiroAtualizado) {
            System.out.println("\nIdade do passageiro atualizada com sucesso.");
        } else {
            System.out.println("\nPassageiro não encontrado para atualizar.");
        }

        boolean passageiroRemovido = passageiroDAO.deletarPassageiro("João");
        if (passageiroRemovido) {
            System.out.println("\nPassageiro removido com sucesso.");
        } else {
            System.out.println("\nPassageiro não encontrado para remover.");
        }

        System.out.println("\nPassageiros atualizados:");
        todosPassageiros = passageiroDAO.listarPassageiros();
        for (Passageiro passageiro : todosPassageiros) {
            System.out.println(passageiro);
        }
        
        sc.close();
	}

	private static List<Passageiro> passageiroDAO(String nome, String cPF, Date nascimento) {
		// TODO Auto-generated method stub
		return null;
	}
}
