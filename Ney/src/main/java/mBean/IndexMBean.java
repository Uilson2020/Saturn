package mBean;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import model.ResultadoDatas;

@ManagedBean
@ViewScoped
public class IndexMBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date dtInicio;
	private Date dtFim;
	private List<ResultadoDatas> resultados;


	@PostConstruct
	public void init() {
		limpar();
	}

	public void calcular() {
		if (validarCampos()) {
			ResultadoDatas resultado = new ResultadoDatas();
			resultado.setInicio(dtInicio);
			resultado.setFim(dtFim);
			LocalDate inicio = dtInicio.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();		
			LocalDate fim = dtFim.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			
			Period diferenca = inicio.until(fim);
			
			if (diferenca.getYears() == 666 & diferenca.getDays() == 0 && diferenca.getMonths() == 0) {
				resultado.setMensagem(diferenca.getYears() + " anos, your soul is mine!");
			}else {
				resultado.setMensagem(diferenca.getYears() + " anos " + diferenca.getMonths() + " meses " + diferenca.getDays() + " dias!");
			}
			
			this.resultados.add(resultado);
			
		}
	}

	public boolean validarCampos() {
		if (this.dtInicio == null || this.dtFim == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ambas as datas devem ser informadas", "Ambas as datas devem ser informadas"));
			return false;
		}
		if (this.dtInicio.getTime() > this.dtFim.getTime()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"A data de inicio deve ser menor que a data final", "A data de inicio deve ser menor que a data final"));
			return false;
		}
		if (this.dtInicio.equals(this.dtFim)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"As datas devem ser diferentes", "As datas devem ser diferentes"));
			return false;
		}

		return true;
	}

	public void limpar() {
		this.dtInicio = new Date();
		this.dtFim = new Date();
		this.resultados = new ArrayList<ResultadoDatas>();
	}

	public Date getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Date getDtFim() {
		return dtFim;
	}

	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

	public List<ResultadoDatas> getResultados() {
		return resultados;
	}
	
	public void setResultados(List<ResultadoDatas> resultados) {
		this.resultados = resultados;
	}
}
