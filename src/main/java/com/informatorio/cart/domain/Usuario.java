package com.informatorio.cart.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.informatorio.cart.util.ValidationHelper;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no debe ser blanco o nulo")
    private String nombre;
    @NotBlank(message = "El apellido no debe ser blanco o nulo")
    private String apellido;

    @Column(unique = true)
    @Email(regexp = ValidationHelper.EMAIL_REGEX)
    private String email;

    @NotBlank(message = "Password no debe ser blanco o nulo")
    @Length(min = 8, max = 32)
    private String password;

    @CreationTimestamp
    private LocalDateTime fechaDeCreacion;

    @NotBlank
    private String ciudad;

    @NotBlank
    private String provincia;

    @NotBlank
    private String pais;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //public String getPassword() {
    //    return password;
    //}

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
