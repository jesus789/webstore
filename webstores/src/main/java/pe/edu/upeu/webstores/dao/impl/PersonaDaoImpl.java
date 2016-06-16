package pe.edu.upeu.webstores.dao.impl;

import org.springframework.stereotype.Repository;

import pe.edu.upeu.webstores.dao.PersonaDao;
import pe.edu.upeu.webstores.domain.Persona;

@Repository
public class PersonaDaoImpl extends GenericDaoHibernateImpl<Persona, Long> implements PersonaDao{

}
