package br.edu.semi.presencial.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.semi.presencial.model.Medicamento;

@Stateless
public class MedicamentoDAO {

	@PersistenceContext
	private EntityManager em;

	public  void cadastrar(Medicamento medicamento) {
		this.em.persist(medicamento);
	}

	public void remover(Medicamento medicamento) {
		this.em.remove(this.em.merge(medicamento));
	}

	public List<Medicamento> listar() {
		return this.em.createQuery("SELECT u FROM Medicamento u", Medicamento.class).getResultList();
	}

}
