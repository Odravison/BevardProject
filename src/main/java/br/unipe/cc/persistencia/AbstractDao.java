/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipe.cc.persistencia;

import br.unipe.cc.exceptions.EntidadeException;
import br.unipe.cc.models.EntidadePersistivel;
import br.unipe.cc.utils.EMFactory;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author odravison
 */
public abstract class AbstractDao<T extends EntidadePersistivel> {
    private final Class<T> tipo;
    private EntityManager em = EMFactory.getEntityManager();

    public AbstractDao() {
            this.tipo = buscarEntidadeDaClasse();
    }

    /**
     * @return
     */
    @SuppressWarnings("unchecked")
    private Class<T> buscarEntidadeDaClasse() {
            Class<?> classeDAO = this.getClass();

            while (classeDAO.getSuperclass() != AbstractDao.class) {
                    classeDAO = classeDAO.getSuperclass();
            }

            ParameterizedType tipo =
                            (ParameterizedType) classeDAO.getGenericSuperclass();

            Class<T> classeDeEntidadeBuscada = null;

            try {
                    classeDeEntidadeBuscada = (Class<T>) tipo.getActualTypeArguments()[0];
            } catch (ClassCastException exception) {
                    String message = "não é possível moldar : "
                            + tipo.getActualTypeArguments()[0];
                    System.out.println(message);
                    throw exception;
            }
            return classeDeEntidadeBuscada;
    }

    private Class<T> getMeuTipo() {
            return this.tipo;
    }

    protected void salvar(T entidade) {
            em.getTransaction().begin();
            em.persist(entidade);
            em.getTransaction().commit();

    }

    protected boolean exists(Long entidadeId) {
            if (em.find(getMeuTipo(), entidadeId) != null) {
                    return true;
            }

            return false;

    }

    protected boolean exists(T entidade) {
            if (em.find(getMeuTipo(), entidade.getId()) != null) {
                    return true;
            }

            return false;

    }

    protected void remover(Long id) throws EntidadeException {
            if (!exists(id)) {

                    throw new EntidadeException("Entidade: " + getMeuTipo() + "com o atributo: " 
                            + id + " não existe no banco de dados");

            } else {
                    em.getTransaction().begin();
                    T entidade = em.find(getMeuTipo(), id);
                    em.remove(entidade);
                    em.getTransaction().commit();
            }
    }

    protected void editar(T entidade) throws EntidadeException {
            if (exists(entidade)) {
                    em.getTransaction().begin();
                    em.merge(entidade);
                    em.getTransaction().commit();
            } else {
                    throw new EntidadeException("Entidade: " + getMeuTipo() + " não existe no banco de dados");
            }
    }

    protected T buscarPorId(Long entidadeId) throws EntidadeException {
            if (exists(entidadeId)) {
                    return em.find(getMeuTipo(), entidadeId);
            } else {
                    throw new EntidadeException("Entidade: " + getMeuTipo() + " não existe no banco de dados");
            }
    }

    @SuppressWarnings("unchecked")
    protected List<T> buscarTodasEntidade(String sql){
            return em.createQuery(sql).getResultList();
    }

    /**
     * @param limitePorPagina
     * @param pagina
     * @return
     */
    public List<T> buscarPorPagina(int limitePorPagina, int pagina, String entidade) {
            String sql = "SELECT t FROM " + entidade + " t";
            Query query = em.createQuery(sql)
                            .setFirstResult(calcularOffset(pagina, limitePorPagina))
                            .setMaxResults(limitePorPagina);
            return query.getResultList();
    }

    /**
     * @param pagina
     * @return
     */
    private int calcularOffset(int pagina, int limite) {
            return ((limite * pagina) - limite);
    }
}
