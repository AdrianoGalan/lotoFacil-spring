package br.com.ngfor.lotofacil.services;

import java.io.IOException;

public class UtilitarioService {

	// desliga o computados
	public void desligar() {

		LocalShell ls = new LocalShell();
		try {
			ls.executeCommand("poweroff");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
