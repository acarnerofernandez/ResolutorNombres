import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Resolver {
    public static void main(String[] args) {

        try {
            InetAddress yo = InetAddress.getLocalHost();
            System.out.println("Mi equipo: " + yo.getHostName());
            System.out.println("Mi IP --> " + yo.getHostAddress());
            System.out.println("----------------------------------------");
        } catch (UnknownHostException e) {
            System.err.println("No se pudo obtener la información local: " + e.getMessage());
        }


        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.print("\nIntroduce un dominio (o 'salir' para terminar): ");
            String url = sc.nextLine().trim();

            if (url.equalsIgnoreCase("salir")) {
                break;
            }

            if (url.isEmpty()) {
                continue;
            }

            try {
                InetAddress web = InetAddress.getByName(url);
                System.out.println("Principal: " + web.getHostName() + " -> " + web.getHostAddress());
                System.out.println("Todas las direcciones asociadas:");

 
                for (InetAddress ip : InetAddress.getAllByName(url)) {
               
                    if (ip instanceof Inet4Address) {
                        System.out.println("  [IPv4] " + ip.getHostAddress());
                    } else if (ip instanceof Inet6Address) {
                        System.out.println("  [IPv6] " + ip.getHostAddress());
                    }
                }
            } catch (UnknownHostException e) {
                System.err.println("No se pudo resolver '" + url + "': " + e.getMessage());
            }
        }

        sc.close();
        System.out.println("Fin del bucle");
    }
}
