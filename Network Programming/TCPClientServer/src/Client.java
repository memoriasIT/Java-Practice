import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client
{
    public static void main(String[] args) throws IOException
    {
        try
        {
            Socket echoSocket = new Socket(args[0], Integer.parseInt(args[1]));

            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));

            System.out.printf("[CLIENT] - Sucessfully connected to server %s:%s\n", args[0], args[1]);
            System.out.println(in.readLine());

            // Get data from input
            Scanner sc = new Scanner(System.in);
            System.out.println("Input mode:");
            String mode = sc.nextLine();
            out.print(mode+"\r\n");

            // User wanted to exit
            if (mode.equals("f")){
                // Send signal to server and wait for response
                out.println("f");


                System.out.println("Waiting for a response from server...");
                String msg = in.readLine();
                if (msg.equals("FINISH")){
                    System.out.println("Closing connection...");
                    // Close sockets
                    out.close();
                    in.close();
                    echoSocket.close();
                    System.exit(0);
                } else {
                    throw new Exception();
                }


            }

            // Text to convert
            System.out.println("Text:");
            String text = sc.nextLine();
            out.println(text);

            // Response
            System.out.println("[SERVER] - " + in.readLine()+"\n" + in.readLine());

        }
        catch (Exception e)
        {
            System.err.println("Error");
            e.printStackTrace();
            System.exit(1);

        }
    }
}

