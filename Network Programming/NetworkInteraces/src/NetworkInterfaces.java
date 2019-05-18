import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Dimension;
import java.awt.GridLayout;

import java.net.NetworkInterface;
import java.net.SocketException;

import java.util.*;


public class NetworkInterfaces extends JPanel {
    // Display data also on console
    boolean DEBUG = true;

    // Add content to JTable
    public NetworkInterfaces() throws SocketException{
        super(new GridLayout(1,0));

        String[] columnNames = {"Short Name",
                "MAC",
                "Globally/Locally Managed",
                "Up/Down",
                };

        // Get data to table
        String [][] data = getAllData();


        // Print Data to console in DEBUG mode
        if (DEBUG) {
            StringJoiner sj = new StringJoiner(System.lineSeparator());
            for (String[] row : data) {
                sj.add(row[0]+":" + row[1] + " - " + row[2] + " - (" + row[3] + ").");
            }
            String result = sj.toString();
            System.out.println(result);

        }


        final JTable table = new JTable(data, columnNames);
        table.setRowHeight(20);

        int height = (data.length > 15) ? 300 : data.length*20;
        table.setPreferredScrollableViewportSize(new Dimension(600, height));
        table.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

    public static void main(String[] args) {

        // Due to Event Dispatcher Thread (EDT) we use invokeLater to ensure that the code modifies the GUI
        // Anonymous class is used as a reference is not needed.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    ShowGUI();
                } catch (SocketException e){
                    System.out.println("Socket Exception raised::" + e);
                } catch (Exception e){
                    System.out.println("Unexpected Exception::" + e);
                }

            }
        });
    }


    // EDT GUI Creation and display
    private static void ShowGUI() throws SocketException{
        //Create JFrame Window
        JFrame frame = new JFrame("Network Interfaces");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add content
        NetworkInterfaces newContentPane = new NetworkInterfaces();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the frame
        frame.pack();
        frame.setVisible(true);
    }

    private String[][] getAllData() throws SocketException {
        // Get network interfaces
        Enumeration<NetworkInterface> NetInterfaces = NetworkInterface.getNetworkInterfaces();
        ArrayList<NetworkInterface> NetInterfacesList = Collections.list(NetInterfaces);

        // Create fixed size array for JTable data, can't be greater than that
        String[][] data = new String[NetInterfacesList.size()][4];

        // Get required data into array
        int counter = 0;
        for (NetworkInterface currentInt : NetInterfacesList){

            // MAC Address must be processed as it is given as a byte[]
            final byte[] mac = currentInt.getHardwareAddress();
            if (mac != null && mac.length > 0){
                final StringBuilder sb = new StringBuilder();
                for (int i = 0; i < mac.length; i++) {
                    // %02X print at least 2 digits + ternary conditon for -
                    sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                }
                data[counter][1] = sb.toString();


                // Globally or Locally managed
                try {
                    // Apply mask to check second least significant bit
                    // 1 means locally administered, else global.
                    byte masked = (byte) (mac[0] & 0x02);
                    if (masked == 2){
                        data[counter][2] = "local";
                    } else if (masked == 0){
                        data[counter][2] = "global";
                    } else {
                        throw new Exception("MAC Address not correct");
                    }
                } catch (Exception e){
                    // mac[0] was NULL or was not correctly processed
                    data[counter][2] = "NULL";
                }


                // Is up?
                if (currentInt.isUp()){
                    data[counter][3] =  "up";
                } else {
                    data[counter][3] =  "down";
                }

                // Short name
                data[counter][0] = currentInt.getName();


                counter++;

            }

        }

        // Just get the rows without NULL values
        String[][] fixed_data = new String[counter][4];
        for (int i = 0; i < counter; i++){
            for (int j = 0; j < 4; j++) {
                fixed_data[i][j] = data[i][j];
            }
        }


        return fixed_data;


    }


}
