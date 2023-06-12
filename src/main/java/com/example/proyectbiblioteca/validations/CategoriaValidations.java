package com.example.proyectbiblioteca.validations;

import com.example.proyectbiblioteca.entities.Categoria;
import java.util.Optional;

public class CategoriaValidations {

    public static boolean categoriaPresente(Optional<Categoria> categoria) {
        return categoria.isPresent();
    }

    public static boolean verificarNombre(String nombre) {
        return (nombre == null || nombre.length() == 0);
    }

    public static boolean verificarDescripcionCategoria(String descripcion) {
        return descripcion == null || descripcion.length() > 255;
    }

    public static boolean nombrePresenteIgualDiferente(String categoriaNombre, String categoriaId) {
        return !categoriaId.equals(categoriaNombre);
    }
}
