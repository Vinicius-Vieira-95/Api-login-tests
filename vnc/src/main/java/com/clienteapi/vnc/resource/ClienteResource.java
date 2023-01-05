package com.clienteapi.vnc.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clienteapi.vnc.model.Cliente;
import com.clienteapi.vnc.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    @Autowired
    private ClienteRepository cliente;

    @GetMapping
	public List<Cliente> listar(){
		return cliente.findAll();
	}
}
