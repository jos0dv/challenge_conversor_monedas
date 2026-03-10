import java.util.Scanner;

public class Menu {

    Scanner lectura = new Scanner(System.in);
    ConsultaAPI consulta = new ConsultaAPI();
    Conversor conversor = new Conversor();

    public void mostrarMenu() {

        int opcion = 0;

        while (opcion != 7) {

            System.out.println("****************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda");
            System.out.println("1) Dólar -> Peso Argentino");
            System.out.println("2) Peso Argentino -> Dólar");
            System.out.println("3) Dólar -> Real Brasileño");
            System.out.println("4) Real Brasileño -> Dólar");
            System.out.println("5) Dólar -> Peso Colombiano");
            System.out.println("6) Peso Colombiano -> Dólar");
            System.out.println("7) Salir");
            System.out.println("****************************************");
            System.out.println("Elija una opción:");

            opcion = lectura.nextInt();

            if (opcion == 7) {
                System.out.println("Gracias por usar el conversor.");
                break;
            }

            System.out.println("Ingrese el valor a convertir:");
            double valor = lectura.nextDouble();

            String monedaBase = "";
            String monedaDestino = "";

            switch (opcion) {

                case 1:
                    monedaBase = "USD";
                    monedaDestino = "ARS";
                    break;

                case 2:
                    monedaBase = "ARS";
                    monedaDestino = "USD";
                    break;

                case 3:
                    monedaBase = "USD";
                    monedaDestino = "BRL";
                    break;

                case 4:
                    monedaBase = "BRL";
                    monedaDestino = "USD";
                    break;

                case 5:
                    monedaBase = "USD";
                    monedaDestino = "COP";
                    break;

                case 6:
                    monedaBase = "COP";
                    monedaDestino = "USD";
                    break;

                default:
                    System.out.println("Opción inválida.");
                    continue;
            }

            try {

                String json = consulta.obtenerDatos(monedaBase, monedaDestino);

                double tasa = conversor.obtenerTasa(json);

                double resultado = conversor.convertir(valor, tasa);

                System.out.println(valor + " " + monedaBase +
                        " corresponde a " + resultado + " " + monedaDestino);

            } catch (Exception e) {

                System.out.println("Error al consultar la API");

            }
        }
    }
}