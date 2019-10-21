package br.edu.semi.presencialbean;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.semi.presencial.dao.MedicamentoDAO;
import br.edu.semi.presencial.model.Medicamento;
import br.edu.semi.presencial.util.JSFUtil;
import java.io.Serializable;

@Named
@ViewScoped
public class MedicamentoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2360198800479253254L;

	private Medicamento medicamento;
	
	@Inject
	private MedicamentoDAO medicamentoDAO;

	private List<Medicamento> medicamentos;

	public MedicamentoBean() {
		this.medicamento = new Medicamento();
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setUsuario(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public List<Medicamento> getMedicamentos() {
		this.medicamentos = medicamentoDAO.listar();
		return medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}

	public void cadastrar() {
		medicamentoDAO.cadastrar(this.medicamento);
		JSFUtil.enviarMensagemInformacao("Medicamento: " + this.medicamento.getNome() + " Id: "+ this.medicamento.getId() +" - Cadastrado com sucesso.");
		this.medicamento = new Medicamento();
	}

	public void excluir(Medicamento medicamento) {
		medicamentoDAO.remover(medicamento);
		JSFUtil.enviarMensagemInformacao("Medicamento: " + medicamento.getNome() + " excluido com sucesso");
	}

	public MedicamentoDAO getMedicamentoDAO() {
		return medicamentoDAO;
	}

	public void setMedicamentoDAO(MedicamentoDAO medicamentoDAO) {
		this.medicamentoDAO = medicamentoDAO;
	}

}
