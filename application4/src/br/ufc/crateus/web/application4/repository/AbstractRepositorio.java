package br.ufc.crateus.web.application4.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.ufc.crateus.web.application4.model.Usuario;

public class AbstractRepositorio<T extends Usuario> {

	protected Map<Integer, T> repository = new HashMap<>();
	private int id = 1;

	public void add(T obj) {
		obj.setId(id++);
		repository.put(obj.getId(), obj);
	}

	public T getbyID(int id) {
		return repository.get(id);
	}

	public Collection<T> getAll() {
		return repository.values();
	}
}
