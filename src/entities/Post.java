package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {

	// data/hora atual
	LocalDateTime agora = LocalDateTime.now();

	// formatar a data
	DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private String dataFormatada = formatterData.format(agora);

	// formatar a hora
	DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm");
	private String horaFormatada = formatterHora.format(agora);
	private String conteudo;

	public Post(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getDataFormatada() {
		return dataFormatada;
	}

	public String getHoraFormatada() {
		return horaFormatada;
	}

	public String getConteudo() {
		return conteudo;
	}

	@Override
	public String toString() {
		return dataFormatada + " às " + horaFormatada + "min - '" + conteudo + "'.\n";
	}
}
