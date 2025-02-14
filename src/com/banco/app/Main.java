package com.banco.app;

import com.banco.menu.MenuInterativo;
import com.banco.model.Banco;

public class Main {

    public static void main(String[] args) {
        Banco banco = new Banco("Banco Digital");
        MenuInterativo menu = new MenuInterativo(banco);
        menu.iniciar();
    }
}