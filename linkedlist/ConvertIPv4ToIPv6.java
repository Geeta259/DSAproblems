import java.util.Scanner;

public class ConvertIPv4ToIPv6 {
    
    public static String convertToIpv6(String ipv4Address) {
        // Split the IPv4 address into 4 octets
        String[] octets = ipv4Address.split("\\.");
        int firstOctet = Integer.parseInt(octets[0]);

        // Check if the address is a loopback address (starts with 127)
        if (firstOctet == 127) {
            return "::1";
        }

        // Convert each octet to its hexadecimal equivalent
        String hex1 = String.format("%02X", Integer.parseInt(octets[0]));
        String hex2 = String.format("%02X", Integer.parseInt(octets[1]));
        String hex3 = String.format("%02X", Integer.parseInt(octets[2]));
        String hex4 = String.format("%02X", Integer.parseInt(octets[3]));

        // Form the IPv6 address as ::FFFF:hex1hex2:hex3hex4
        return String.format("::FFFF:%s%s:%s%s", hex1, hex2, hex3, hex4).toUpperCase();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Prompting for input
        System.out.print("Enter an IPv4 address: ");
        String ipv4Address = sc.nextLine().trim();

        // Convert IPv4 to IPv6
        String ipv6Address = convertToIpv6(ipv4Address);

        // Output the IPv6 address
        System.out.println("IPv6 Address: " + ipv6Address);

        sc.close();
    }
}
