package pe.edu.upeu.webstores.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.webstores.dao.PersonaDao;
import pe.edu.upeu.webstores.domain.Persona;
import pe.edu.upeu.webstores.service.PersonaService;

@Service
@Transactional
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaDao personaDao;

	public void guardar(Persona p) {
		personaDao.insert(p);
	}

}
