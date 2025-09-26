import GestionInventario.Inventario;
import GestionInventario.interfaz.InventarioMenu;
import HijasClass.Tablet;
import HijasClass.Desktop;
import HijasClass.Laptop;

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        InventarioMenu menuPrincipal = new InventarioMenu(inventario);
        menuPrincipal.setVisible(true);
    }

}