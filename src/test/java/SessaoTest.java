import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;
import junit.framework.Assert;

public class SessaoTest {

	@Test
	public void oPrecoDaSessaoDeveSerIgualASOmaDoPrecoDaSalaMaisOPrecoDoFilme() {
		Filme filme = new Filme("Spawn", Duration.ofMinutes(120), "Comedia", new BigDecimal("22.5"));
		Sala sala = new Sala("IMAX", new BigDecimal("40.0"));
		BigDecimal somaDosPrecosDaSalaEFilme = filme.getPreco().add(sala.getPreco());

		Sessao sessao = new Sessao(LocalTime.parse("12:00"), filme, sala);
		
		
		Assert.assertEquals(somaDosPrecosDaSalaEFilme, sessao.getPreco());
	}
}