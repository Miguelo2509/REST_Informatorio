package com.informatorio.cart.controller;

import com.informatorio.cart.domain.Usuario;
import com.informatorio.cart.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public ResponseEntity<?> createUsuario(@Valid @RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioRepository.save(usuario), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        return new ResponseEntity(usuarioRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Usuario getUsuarioPorId(@PathVariable("id") Long id) {
        return usuarioRepository.findById(id).get();
    }

    //Falta cambiar el pasword que no tiene GETTER
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Usuario modificarUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
        Usuario usuarioExistente = usuarioRepository.findById(id).get();
        usuarioExistente.setNombre(usuario.getNombre());
        usuarioExistente.setApellido(usuario.getApellido());
        usuarioExistente.setEmail(usuario.getEmail());
        usuarioExistente.setCiudad(usuario.getCiudad());
        usuarioExistente.setProvincia(usuario.getCiudad());
        usuarioExistente.setPais(usuario.getPais());
        return usuarioRepository.save(usuarioExistente);
    }

    //Falta
    //CONSULTA (OBTENER TODOS LOS USUARIOS DE LA CIUDAD DE RESISTENCIA)
    //CONSULTA (OBTENER TODOS LOS USUARIOS QUE FUERON CREADOS LUEGO DE UNA FECHA DADA)

   /*
   @GetMapping
   public ResponseEntity<?> obtenerTodosLosUsuarios(
           @RequestParam(name = "fechaDeCreacion", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaDeCreacion) {
           return new ResponseEntity<>(usuarioRepository.findByFechaDeCreacionAfter(fechaDeCreacion.atStartOfDay()), HttpStatus.OK);
   }
   */
}


