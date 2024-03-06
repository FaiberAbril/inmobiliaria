package com.sena.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class inicioControlador {
	
		
		@GetMapping("/inicio")
		public String inicio () {
			return "inicio";
		}

}
