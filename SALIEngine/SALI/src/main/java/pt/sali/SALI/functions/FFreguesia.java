package pt.sali.SALI.functions;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.sali.SALI.model.Freguesia;
import pt.sali.SALI.model.Utilizador;
import pt.sali.SALI.service.IFreguesia;
import pt.sali.SALI.service.IUtilizador;

@Service("ffreguesia")
public class FFreguesia {
	
	@Autowired
	IFreguesia iFreguesia;
	@Autowired
	IUtilizador iUtilizador;
	
	public int saveFreguesia (Freguesia f, String tok) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenToken(tok);
		boolean isEqual = false;
		
		if (u.isPresent()) {
			for (Freguesia fg: iFreguesia.findAll()) {
				if (fg.getNome().compareToIgnoreCase(f.getNome()) == 0) {
					isEqual = true;
				}
			}
			if (isEqual) {
				return 1;
			}else {
				iFreguesia.save(f);
				return 2;
			}
		}
		return 0;
	}
	
	public List<Freguesia> listarFreguesia (String tok) {
	
		Optional<Utilizador> u = iUtilizador.findByTokenToken(tok);
		
		if (u.isPresent()) {
			return iFreguesia.findAll();
		}else {
			return null;
		}
	}
	
	public boolean updateFreguesia (Freguesia f, String tok) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenToken(tok);
		boolean answer = false;
		
		if (u.isPresent()) {
			iFreguesia.save(f);
			answer = true;
		}
		
		return answer;
	}
	
	public boolean deleteFreguesia (String id, String tok) {
		
		Optional<Utilizador> u = iUtilizador.findByTokenToken(tok);
		boolean answer = false;
		
		if (u.isPresent()) {
			iFreguesia.deleteById(id);
			answer = true;
		}
		
		return answer;
	}
}
