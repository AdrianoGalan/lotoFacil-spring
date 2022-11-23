package br.com.ngfor.lotofacil.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ngfor.lotofacil.model.Resultado;
import br.com.ngfor.lotofacil.repository.ResultadoRepository;

@Service
public class ResultadoService {

	private ResultadoRepository rr;
	private RoboService roboService;

	public ResultadoService(ResultadoRepository rr, RoboService roboService) {
		super();
		this.rr = rr;
		this.roboService = roboService;
	}

	// busca todos os concursos no banco
	public List<Resultado> findAll() {

		return rr.findAllByOrderByConcursoDesc();
	}

	// busca concurso passando numero de concursos
	public List<Resultado> buscaLimite(int numeroConcursos) {
		return rr.buscaResultadolimite(numeroConcursos);
	}

	// busca por numero de concurso
	public Resultado buscaConcurso(int numeroConcurso) {
		return rr.getByConcurso(numeroConcurso);
	}

	// busca resultado intervalo de datas
	public List<Resultado> buscaConcusosIntervaloData(String dataInicial, String dataFinal) {
		
		DateTimeFormatter formatterIn = DateTimeFormatter.ofPattern("ddMMuuuu");
		DateTimeFormatter formatterOut = DateTimeFormatter.ofPattern("uuuu-MM-dd");

		LocalDate dataInicio = LocalDate.parse(dataInicial, formatterIn);
		LocalDate dataFim = LocalDate.parse(dataFinal, formatterIn);
		
		
		
		return rr.buscaResultadoIntervaloData(formatterOut.format(dataInicio), formatterOut.format(dataFim));
		
	}

	// busca ultimo resultado no banco
	public Resultado ultimoResultado() {
		return rr.findTop1ByOrderByConcursoDesc();
	}

	// Atualiza banco de dados com os ultimos resultados
	public List<Resultado> atualizaBanco() {
		Resultado resultadoAtual = this.ultimoResultado();

		if (resultadoAtual != null) {

			List<Resultado> resultados = roboService.atualizaResultados(resultadoAtual.getConcurso());

			resultados.sort((r1, r2) -> r1.compareTo(r2));

			for (Resultado resultado : resultados) {
				rr.save(resultado);
				System.out.println(resultado);
			}

			return resultados;
		}

		return null;
	}

	// Carrega banco de dados com todos os sorteios
	public List<Resultado> alimentaBanco() {

		List<Resultado> resultados = roboService.buscaCarregaBanco();

		resultados.sort((r1, r2) -> r1.compareTo(r2));

		for (Resultado resultado : resultados) {
			rr.save(resultado);
			System.out.println(resultado);
		}

		return resultados;
	}

	// Busca sorteios que tenha o numero, passando o numero a ser procurado
	public List<Resultado> buscaSorteioContemNumero(int numero) {
		return rr.buscaResultadoContemNumero(numero);
	}

}
