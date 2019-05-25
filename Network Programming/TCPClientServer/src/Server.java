import java.io.*;
import java.net.*;

class Server {

    public static void main(String[] args) throws IOException
    {


        try
        {
            int port = Integer.parseInt(args[0]);
            int backlog = 1;

            ServerSocket server = new ServerSocket(port,backlog);
            server.setSoTimeout(40000);
            System.out.printf("[SERVER] - Up and Running at port %d with backlog of %d\n", port, backlog);

            while (true) //funcion del servidor:
            {

                System.out.println("[SERVER] - Waiting for a new client...");
                Socket client = server.accept();

                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                String result;

                out.println("[SERVER] - Welcome to the text transformation service.");
                System.out.println("[SERVER] - Waiting for client input.");

                // Get line and print it
                String mode = in.readLine();
                if (!mode.equals("f")){
                    System.out.println("[Client] - Mode: " + mode);

                    // Get message to change
                    String msg = in.readLine();
                    System.out.println("[Client] - Message: " + msg);

                    // Process line accordingly
                    if (mode.equals("u")){
                        // Make code uppercase
                        result = "Uppercase mode activated.\n" + msg.toUpperCase();
                    } else if (mode.equals("l")){
                        // Make code lowercase
                        result = "Lowercase mode activated.\n" + msg.toLowerCase();
                    } else {
                        // Return error option not available
                        result = "Option not available. \nUse 'u' for uppercase or 'l' for lowercase";
                    }
					
					// Send it to client
					out.println(result);

                } else { // We got mode "f"
                    result = "FINISH";
					
					// Send it to client
					out.println(result);
					
					// Close socket
					in.close();
					out.close();
					client.close();
                }

               

                
            }
        }
        catch (Exception e)
        {
            System.out.println("Error");
            e.printStackTrace();
            System.exit(-1);
        }
    }

}
