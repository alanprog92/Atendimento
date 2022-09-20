package br.edu.infnet.atendimento.model.test;

import br.edu.infnet.atendimento.interfaces.IPrinter;

public class AppImpressao {
	
	public static void relatorio(String mensagem, IPrinter printer) {
		System.out.println(mensagem);
		printer.impressao();
	}

}
