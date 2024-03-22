package com.sena.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sena.modelo.Publicacion;
import com.sena.servicio.publicServicio;

@Controller
public class inicioControlador {

	@Autowired
	private publicServicio publicServicio;

	@GetMapping("/inicio")
	public String inicio(Model model) {
		model.addAttribute("totalPublicaciones", contadorTotaldePublicaciones());
		model.addAttribute("totalPublicacionesCasas", contadorPublicacionCasas());
		model.addAttribute("totalPublicacionesHabitaciones", contadorPublicacionHabitaciones());
		model.addAttribute("totalPublicacionesApartamentos", contadorPublicacionApartamentos());
		model.addAttribute("totalPublicacionesLotes", contadorPublicacionLotes());
		model.addAttribute("totalPublicacionesTerrenos", contadorPublicacionTerrenos());
		model.addAttribute("totalPublicacionesFincas", contadorPublicacionFincas());
		model.addAttribute("totalPublicacionesLocales", contadorPublicacionLocales());
		model.addAttribute("totalPublicacionesOficinas", contadorPublicacionOficinas());
		model.addAttribute("totalPublicacionesEdificios", contadorPublicacionEdificios());
		return "inicio";
	}

	public int contadorTotaldePublicaciones() {
		List<Publicacion> Listapublica = publicServicio.listarPublicaciones();
		int contadorTotalPublicaciones = Listapublica.size();
		return contadorTotalPublicaciones;
	}

	public int contadorPublicacionCasas() {
		List<Publicacion> Listapublica = publicServicio.listAll("CASAS");
		int contadorporcasas = Listapublica.size();
		return contadorporcasas;
	}

	public int contadorPublicacionHabitaciones() {
		List<Publicacion> Listapublica = publicServicio.listAll("HABITACIONES");
		int contadorporhabitaciones = Listapublica.size();
		return contadorporhabitaciones;
	}

	public int contadorPublicacionApartamentos() {
		List<Publicacion> Listapublica = publicServicio.listAll("APARTAMENTOS");
		int contadorporapartamanetos = Listapublica.size();
		return contadorporapartamanetos;
	}

	public int contadorPublicacionLotes() {
		List<Publicacion> Listapublica = publicServicio.listAll("LOTES");
		int contadorporlotes = Listapublica.size();
		return contadorporlotes;
	}
	
	public int contadorPublicacionTerrenos() {
		List<Publicacion> Listapublica = publicServicio.listAll("TERRENOS");
		int contadorporterrenos = Listapublica.size();
		return contadorporterrenos;
	}
	
	public int contadorPublicacionFincas() {
		List<Publicacion> Listapublica = publicServicio.listAll("FINCAS");
		int contadorporfincas = Listapublica.size();
		return contadorporfincas;
	}
	
	public int contadorPublicacionLocales() {
		List<Publicacion> Listapublica = publicServicio.listAll("lOCALES");
		int contadorporlocales = Listapublica.size();
		return contadorporlocales;
	}
	
	public int contadorPublicacionOficinas() {
		List<Publicacion> Listapublica = publicServicio.listAll("OFICINAS");
		int contadorporoficinas = Listapublica.size();
		return contadorporoficinas;
	}
	
	public int contadorPublicacionEdificios() {
		List<Publicacion> Listapublica = publicServicio.listAll("EDIFICIOS");
		int contadorporedificios = Listapublica.size();
		return contadorporedificios;
	}
	

}
