package pe.edu.upeu.webstores.dao.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.edu.upeu.webstores.dao.GenericDao;

@Component
public class GenericDaoHibernateImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll(Class<T> typeClass) {
		return getSession().createCriteria(typeClass).list();
	}

	@SuppressWarnings("unchecked")
	public List<T> getAllRestrictionNE(Class<T> typeClass, String columnaRestriccion, String valorRestriccion) {
		return getSession().createCriteria(typeClass).add(Restrictions.ne(columnaRestriccion, valorRestriccion)).list();
	}

	@SuppressWarnings("unchecked")
	public List<T> getAllRestrictionEQ(Class<T> typeClass, String columnaRestriccion, String valorRestriccion) {
		return getSession().createCriteria(typeClass).add(Restrictions.eq(columnaRestriccion, valorRestriccion)).list();
	}

	@SuppressWarnings("unchecked")
	public List<T> getAllRestrictionTwoStringAndDateEQ(Class<T> typeClass, String columnaRestriccion,
			String valorRestriccion, String columnaRestriccion1, Date valorRestriccion1) {
		return getSession().createCriteria(typeClass).add(Restrictions.eq(columnaRestriccion, valorRestriccion))
				.add(Restrictions.eq(columnaRestriccion1, valorRestriccion1)).list();
	}

	@SuppressWarnings("unchecked")
	public List<T> getAllRestrictionTwoEQ(Class<T> typeClass, String columnaOneRestriccion, String valorOneRestriccion,
			String columnaTwoRestriccion, String valorTwoRestriccion) {
		return getSession().createCriteria(typeClass).add(Restrictions.eq(columnaOneRestriccion, valorOneRestriccion))
				.add(Restrictions.eq(columnaTwoRestriccion, valorTwoRestriccion)).list();
	}

	@SuppressWarnings("unchecked")
	public List<T> getAllOrdered(Class<T> typeClass, String columnaOrden) {
		return getSession().createCriteria(typeClass).addOrder(Order.asc(columnaOrden)).list();
	}

	@SuppressWarnings("unchecked")
	public List<T> getAllOrderedDesc(Class<T> typeClass, String columnaOrden) {
		return getSession().createCriteria(typeClass).addOrder(Order.desc(columnaOrden)).list();
	}

	@SuppressWarnings("unchecked")
	public List<T> getAllOrderedRestrictionNE(Class<T> typeClass, String columnaOrden, String columnaRestriccion,
			String valorRestriccion) {
		return getSession().createCriteria(typeClass).add(Restrictions.ne(columnaRestriccion, valorRestriccion))
				.addOrder(Order.asc(columnaOrden)).list();
	}

	@SuppressWarnings("unchecked")
	public List<T> getAllOrderedRestrictionEQ(Class<T> typeClass, String columnaOrden, String columnaRestriccion,
			String valorRestriccion) {
		return getSession().createCriteria(typeClass).add(Restrictions.eq(columnaRestriccion, valorRestriccion))
				.addOrder(Order.asc(columnaOrden)).list();
	}

	@SuppressWarnings("unchecked")
	public List<T> getAllOrderedRestrictionEQDesc(Class<T> typeClass, String columnaOrden, String columnaRestriccion,
			String valorRestriccion) {
		return getSession().createCriteria(typeClass).add(Restrictions.eq(columnaRestriccion, valorRestriccion))
				.addOrder(Order.desc(columnaOrden)).list();
	}

	@SuppressWarnings("unchecked")
	public List<T> getAllOrderedRestrictionTwoEQ(Class<T> typeClass, String columnaOrden, String columnaRestriccion,
			String valorRestriccion, String columnaRestriccion1, String valorRestriccion1) {
		return getSession().createCriteria(typeClass).add(Restrictions.eq(columnaRestriccion, valorRestriccion))
				.add(Restrictions.eq(columnaRestriccion1, valorRestriccion1)).addOrder(Order.asc(columnaOrden)).list();
	}

	@SuppressWarnings("unchecked")
	public List<T> getAllRestrictionThreeEQ(Class<T> typeClass, String columnaRestriccion, String valorRestriccion,
			String columnaRestriccion1, String valorRestriccion1, String columnaRestriccion2,
			String valorRestriccion2) {
		return getSession().createCriteria(typeClass).add(Restrictions.eq(columnaRestriccion, valorRestriccion))
				.add(Restrictions.eq(columnaRestriccion1, valorRestriccion1))
				.add(Restrictions.eq(columnaRestriccion2, valorRestriccion2)).list();
	}

	@SuppressWarnings("unchecked")
	public List<T> getAllOrderedRestrictionThreeEQ(Class<T> typeClass, String columnaOrden, String columnaRestriccion,
			String valorRestriccion, String columnaRestriccion1, String valorRestriccion1, String columnaRestriccion3,
			boolean valorRestriccion3) {
		return getSession().createCriteria(typeClass).add(Restrictions.eq(columnaRestriccion, valorRestriccion))
				.add(Restrictions.eq(columnaRestriccion1, valorRestriccion1))
				.add(Restrictions.eq(columnaRestriccion3, valorRestriccion3)).addOrder(Order.asc(columnaOrden)).list();
	}

	@SuppressWarnings("unchecked")
	public List<T> getAllOrderedRestrictionTwoBooleanEQ(Class<T> typeClass, String columnaOrden,
			String columnaRestriccion, String valorRestriccion, String columnaRestriccion1, Boolean valorRestriccion1) {
		return getSession().createCriteria(typeClass).add(Restrictions.eq(columnaRestriccion, valorRestriccion))
				.add(Restrictions.eq(columnaRestriccion1, valorRestriccion1)).addOrder(Order.asc(columnaOrden)).list();
	}

	@SuppressWarnings("unchecked")
	public T findByPK(Class<T> typeClass, PK id) {
		return (T) getSession().createCriteria(typeClass).add(Restrictions.idEq(id)).uniqueResult();
	}

	public void DeleteSession(Class<T> typeClass) {
		DeleteSession(typeClass);
	}

	@SuppressWarnings("unchecked")
	public T findByColumnInt(Class<T> typeClass, String columna, Integer valor) {
		return (T) getSession().createCriteria(typeClass).add(Restrictions.eq(columna, new Integer(valor)))
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public T findByColumn(Class<T> typeClass, String columna, String valor) {
		return (T) getSession().createCriteria(typeClass).add(Restrictions.eq(columna, valor)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public T findByTwoColumnBoolean(Class<T> typeClass, String columna, String valor, String columna2, boolean valor2) {
		return (T) getSession().createCriteria(typeClass).add(Restrictions.ilike(columna, valor + "%"))
				.add(Restrictions.like(columna2, valor2)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public T findByThreeColumnBoolean(Class<T> typeClass, String columna, String valor, String columna2, String valor2,
			String columna3, boolean valor3) {
		return (T) getSession().createCriteria(typeClass).add(Restrictions.ilike(columna, valor + "%"))
				.add(Restrictions.ilike(columna2, valor2 + "%")).add(Restrictions.like(columna3, valor3))
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public T findByThreeEQColumn(Class<T> typeClass, String columna, String valor, String columna1, String valor1,
			String columna2, String valor2) {
		return (T) getSession().createCriteria(typeClass).add(Restrictions.eq(columna, valor))
				.add(Restrictions.eq(columna1, valor1)).add(Restrictions.eq(columna2, valor2)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public T findByColumnLike(Class<T> typeClass, String columna, String valor) {
		return (T) getSession().createCriteria(typeClass).add(Restrictions.like(columna, valor)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public T findByTwoColumnLike(Class<T> typeClass, String columna01, String valor01, String columna02,
			String valor02) {
		return (T) getSession().createCriteria(typeClass).add(Restrictions.like(columna01, valor01))
				.add(Restrictions.like(columna02, valor02)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public T findByTwoColumnEQandNe(Class<T> typeClass, String columna, String valor, String columna1, String valor1) {
		return (T) getSession().createCriteria(typeClass).add(Restrictions.eq(columna, valor))
				.add(Restrictions.ne(columna1, valor1)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public T findByTwoColumn(Class<T> typeClass, String columna, String valor, String columna1, String valor1) {
		return (T) getSession().createCriteria(typeClass).add(Restrictions.eq(columna, valor))
				.add(Restrictions.eq(columna1, valor1)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public T loadByPK(Class<T> typeClass, PK id) {
		return (T) getSession().load(typeClass, id);
	}

	public void update(T object) {
		getSession().update(object);
	}

	public void remove(T object) {
		getSession().delete(object);
		getSession().flush();
	}

	public void insert(T object) {
		getSession().save(object);
	}

	@SuppressWarnings("unchecked")
	public List<T> getPaginated(Class<T> typeClass, int startPosition, int maxResult) {
		final StringBuilder sql = new StringBuilder("select c from ").append(typeClass.getSimpleName()).append(" c");

		Query query = getSession().createQuery(sql.toString());

		query.setFirstResult(startPosition);

		query.setMaxResults(maxResult);

		return (List<T>) query.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> getOrderedPaginated(Class<T> typeClass, int startPosition, int maxResult, String order, int dir) {
		String direccion = "ASC";
		if (dir == 2) {
			direccion = "DESC";
		}
		final StringBuilder sql = new StringBuilder("select c from ").append(typeClass.getSimpleName())
				.append(" c order by ").append(order).append(" ").append(direccion);
		Query query = getSession().createQuery(sql.toString());

		query.setFirstResult(startPosition);
		query.setMaxResults(maxResult);

		return (List<T>) query.list();
	}

}