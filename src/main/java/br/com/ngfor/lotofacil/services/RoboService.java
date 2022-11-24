package br.com.ngfor.lotofacil.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

 

import br.com.ngfor.lotofacil.model.Resultado;

@Service
public class RoboService {

	// Atualiza banco de dados com os ultimos sorteios
	public List<Resultado> atualizaResultados(int ultimoConcursoBanco) {

		 ultimoConcursoBanco++;

		return this.buscaResultadosPage(ultimoConcursoBanco);

	}

	// Alimenta banco de dados com todos os sorteios
	public List<Resultado> buscaCarregaBanco() {

		return this.buscaResultadosPage(1);

	}

	// Leitura da pagina da lotoFacil e algoritimo para gravar no banco
	private List<Resultado> buscaResultadosPage(int ConcursoInicial) {
		
		System.out.println("passou aki ......");

		String saida;
		int tamanhoSaida = 0;
		int concurso = 0;
		int concursoFinal = 0;
		int concursoAnterior = 0;
		int bola = 0;
		String data = "";
		List<Resultado> resultados = new ArrayList();

		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium()
					.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
			Page page = browser.newPage();

			page.navigate("https://loterias.caixa.gov.br/Paginas/Lotofacil.aspx");

			saida = page.locator(
					"#wp_resultados > div.content-section.section-text.with-box.no-margin-bottom > div > h2 > span")
					.textContent();
			tamanhoSaida = saida.length();

			concursoFinal = Integer.parseInt(saida.substring(9, (tamanhoSaida - 13)));
			concursoAnterior = concursoFinal;

			for (int i = ConcursoInicial; i <= concursoFinal; i++) {

				Resultado resultado = new Resultado();
				List<Integer> bolas = new ArrayList<>();

				while (concurso != concursoAnterior) {

					saida = page.locator(
							"#wp_resultados > div.content-section.section-text.with-box.no-margin-bottom > div > h2 > span")
							.textContent();
					tamanhoSaida = saida.length();

					if (saida.contains("Concurso")) {
						try {

							concurso = Integer.parseInt(saida.substring(9, (tamanhoSaida - 13)));
							data = saida.substring((tamanhoSaida - 11), (tamanhoSaida - 1));
							data = data.replace("/", "");

						} catch (Exception e) {
							System.err.println(e.getMessage());
						}

					}
				}

				resultado.setConcurso(concurso);
				resultado.setData(data);

				for (int j = 1; j < 16; j++) {
					saida = page.locator(
							"#wp_resultados > div.content-section.section-text.with-box.column-left.no-margin-top > div > div > div:nth-child(3) > ul > li:nth-child("
									+ j + ")")
							.textContent();
					try {

						bola = Integer.parseInt(saida);
						bolas.add(bola);

					} catch (Exception e) {
						System.err.println(e.getMessage());
					}

				}

				resultado.addAll(bolas);

				System.err.println(resultado);
				resultados.add(resultado);

				page.locator("text=< Anterior").click();
				concursoAnterior--;

			}
			return resultados;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}
}
