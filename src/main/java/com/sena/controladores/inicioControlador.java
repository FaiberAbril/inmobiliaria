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
		int contadorporHabitaciones = Listapublica.size();
		return contadorporHabitaciones;
	}

	public int contadorPublicacionApartamentos() {
		List<Publicacion> Listapublica = publicServicio.listAll("APARTAMENTOS");
		int contadorporApartamanetos = Listapublica.size();
		return contadorporApartamanetos;
	}

	public int contadorPublicacionLotes() {
		List<Publicacion> Listapublica = publicServicio.listAll("LOTES");
		int contadorporLotes = Listapublica.size();
		return contadorporLotes;
	}
	
	public int contadorPublicacionTerrenos() {
		List<Publicacion> Listapublica = publicServicio.listAll("TERRENOS");
		int contadorporTerrenos = Listapublica.size();
		return contadorporTerrenos;
	}
	
	public int contadorPublicacionFincas() {
		List<Publicacion> Listapublica = publicServicio.listAll("FINCAS");
		int contadorporFincas = Listapublica.size();
		return contadorporFincas;
	}
	
	public int contadorPublicacionLocales() {
		List<Publicacion> Listapublica = publicServicio.listAll("lOCALES");
		int contadorporLocales = Listapublica.size();
		return contadorporLocales;
	}
	
	public int contadorPublicacionOficinas() {
		List<Publicacion> Listapublica = publicServicio.listAll("OFICINAS");
		int contadorporOficinas = Listapublica.size();
		return contadorporOficinas;
	}
	
	public int contadorPublicacionEdificios() {
		List<Publicacion> Listapublica = publicServicio.listAll("EDIFICIOS");
		int contadorporEdificios = Listapublica.size();
		return contadorporEdificios;
	}
	

}
