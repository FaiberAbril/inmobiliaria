package com.sena.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/PaginaPrincipal")
public class PaginaPrincipal {

	@GetMapping("/")
	public String index() {
		return "index";
	}

}
