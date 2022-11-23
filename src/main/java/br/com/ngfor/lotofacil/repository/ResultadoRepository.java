package br.com.ngfor.lotofacil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ngfor.lotofacil.model.Resultado;

@Repository
public interface ResultadoRepository extends JpaRepository<Resultado, Integer> {

	List<Resultado> findAllByOrderByConcursoDesc();

	Resultado findTop1ByOrderByConcursoDesc();
	
	Resultado getByConcurso(int concurso);

	List<Resultado> findTopQtsByOrderByConcursoDesc();

	List<Resultado> buscaResultadolimite(int numeroConcursos);

	List<Resultado> buscaResultadoContemNumero(int numero);
	
	List<Resultado> buscaResultadoIntervaloData(String dataInicial, String dataFinal);

}
