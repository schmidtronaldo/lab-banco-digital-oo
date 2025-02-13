
public class Main {

    public static void main(String[] args) {
        Banco banco = new Banco("Banco Digital");
        MenuInterativo menu = new MenuInterativo(banco);
        menu.iniciar();
    }
}