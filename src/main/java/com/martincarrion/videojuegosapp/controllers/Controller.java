package com.martincarrion.videojuegosapp.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    //Este metodo devuelve el path donde se encuentra el archivo html
    @GetMapping(value = "/")
    public String index(Model model) {    //model es quien tiene los datos de la app
        String saludo = "Hola mundo";
        /*
        Con este metodo, le damos un valor a la variable que creamos en nuestro index.html
        Esto reemplaza lo que haya dentro del elemento html por lo que sea que este contenido
        en la variable indicada en el index.html
        */
        model.addAttribute("saludo", saludo);
        return "index";
    }
}
