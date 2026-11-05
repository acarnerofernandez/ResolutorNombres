import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;
import java.util.Scanner;

public class Resolver {
    public static void main(String[] args) {
        // Comprobacion si salir es true terminar
        boolean salir = false;
        while (!salir)
                try {

                    Scanner sc = new Scanner(System.in);
                    String url = sc.nextLine();

                    //si url es salir romper el bucle

                    if (Objects.equals(url, "salir")){

                        break;
                }
                    //se coge la ip de la url pasasda
                    InetAddress web = InetAddress.getByName(url);
                    System.out.println(web.getHostName() + " -> " + web.getHostAddress());

                    for (InetAddress ip : InetAddress.getAllByName("google.com")) {
                        System.out.println("  " + ip.getHostAddress()); // IPv4 e IPv6
                    }


                    InetAddress yo = InetAddress.getLocalHost();
                    System.out.println("Mi equipo: " + yo.getHostName());

                    System.out.println("Mi ip --> " + InetAddress.getLocalHost().getHostAddress());


                } catch (UnknownHostException e) {
                    System.err.println("No se pudo resolver: " + e.getMessage());
                }

        System.out.println("Fin del bucle");
    }
}