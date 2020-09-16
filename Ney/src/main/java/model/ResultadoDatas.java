package model;

import java.io.Serializable;
import java.util.Date;

public class ResultadoDatas implements Serializable{

	private static final long serialVersionUID = 1L;

	private Date inicio;
	private Date fim;
	private String mensagem;
	
	
	public Date getInicio() {
		return inicio;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public Date getFim() {
		return fim;
	}
	public void setFim(Date fim) {
		this.fim = fim;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String resultado) {
		this.mensagem = resultado;
	}
	
	
	
}
