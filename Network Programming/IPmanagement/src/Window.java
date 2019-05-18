import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Window extends JFrame implements ActionListener {
    private JButton calculatebtn;

    private JTextField ipinput;
    private JTextField submaskinput;

    private JTextField validtxt;
    private JTextField classtxt;
    private JTextField netidtxt;
    private JTextField netmasktxt;
    private JTextField broadcasttxt;
    private JTextField ipnumtxt;
    private JTextField rangetxt;
    private JTextField range2txt;


    private void createWindow() {
        // Main JPanel
        // Panel STRUCTURE
        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        main.setOpaque(true);
        main.setBackground(Color.WHITE);

        // Add top image
        try {
            BufferedImage wPic = ImageIO.read(Window.class.getResource("ipcalculator.png"));
            /*
        TOP:
            LOGO (Label)
     */
            // Logo
            JLabel wIcon = new JLabel(new ImageIcon(wPic));
            main.add(wIcon, BorderLayout.NORTH);
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Grid Layout in BorderLayout.CENTER
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(2, 1));
        center.setOpaque(true);
        center.setBackground(Color.WHITE);

        // Input panel
        JPanel input = new JPanel();
        input.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(3,3,3,3);
        input.setOpaque(true);
        input.setBackground(Color.WHITE);

        // IP
        /*
        INPUT:
            IP (Label & Textfield)
            SubnetMask (Label & Textfield)
            CalculateButton (Button)
     */
        // IP
        JLabel iplab = new JLabel("IP");
        input.add(iplab, c);
        ipinput = new JTextField( 13);
        input.add(ipinput, c);

        // SubnetMask
        // SubnetMask
        JLabel submasklab = new JLabel("Subnet Mask");
        input.add(submasklab, c);
        submaskinput = new JTextField( 13);
        input.add(submaskinput, c);

        // Calculate button
        calculatebtn = new JButton("CALCULATE");
        calculatebtn.addActionListener(this);
        input.add(calculatebtn);

        // Output panel
        JPanel output = new JPanel();
        output.setLayout(new GridLayout(4,0));
        output.setOpaque(true);
        output.setBackground(Color.WHITE);

        // FIRST ROW
        // Output Rows
        JPanel output1 = new JPanel();
        output1.setLayout(new GridLayout(1,4));

        // Valid/NotValid
        /*
        OUTPUT:
            Valid
            Class
            NetID
            NetMask
            Broadcast
            NumIPs
            Range
            Spacer

      */
        // Valid or not
        JLabel validlab = new JLabel("Valid/NotValid");
        validlab.setHorizontalAlignment(JLabel.CENTER);
        output1.add(validlab);
        validtxt = new JTextField( "-" ,13);
        validtxt.setEditable(false);
        validtxt.setHorizontalAlignment(JTextField.CENTER);
        output1.add(validtxt);

        // Class
        // Class
        JLabel classlab = new JLabel("Class");
        classlab.setHorizontalAlignment(JLabel.CENTER);
        output1.add(classlab);
        classtxt = new JTextField( "-" ,13);
        classtxt.setHorizontalAlignment(JTextField.CENTER);
        classtxt.setEditable(false);
        output1.add(classtxt);

        output.add(output1);


        // SECOND ROW
        JPanel output2 = new JPanel();
        output2.setLayout(new GridLayout(1,4));

        // NetID
        // Net ID
        JLabel netidlab = new JLabel("NetID");
        netidlab.setHorizontalAlignment(JLabel.CENTER);
        output2.add(netidlab);
        netidtxt = new JTextField( "-" ,13);
        netidtxt.setHorizontalAlignment(JTextField.CENTER);
        netidtxt.setEditable(false);
        output2.add(netidtxt);

        // Network Mask
        // Network Mask
        JLabel netmasklab = new JLabel("SubNet Mask");
        netmasklab.setHorizontalAlignment(JLabel.CENTER);
        output2.add(netmasklab);
        netmasktxt = new JTextField( "-" ,13);
        netmasktxt.setEditable(false);
        netmasktxt.setHorizontalAlignment(JTextField.CENTER);
        output2.add(netmasktxt);


        output.add(output2);

        // THIRD ROW
        JPanel output3 = new JPanel();
        output3.setLayout(new GridLayout(1,4));

        // Broadcast
        // BroadCast
        JLabel broadcastlab = new JLabel("Broadcast");
        broadcastlab.setHorizontalAlignment(JLabel.CENTER);
        output3.add(broadcastlab);
        broadcasttxt = new JTextField( "-" ,13);
        broadcasttxt.setEditable(false);
        broadcasttxt.setHorizontalAlignment(JTextField.CENTER);
        output3.add(broadcasttxt);

        //  Number of IPs
        // Number of IPs
        JLabel ipnumlab = new JLabel("NumIPs");
        ipnumlab.setHorizontalAlignment(JLabel.CENTER);
        output3.add(ipnumlab);
        ipnumtxt = new JTextField( "-" ,13);
        ipnumtxt.setEditable(false);
        ipnumtxt.setHorizontalAlignment(JTextField.CENTER);
        output3.add(ipnumtxt);

        output.add(output3);

        // Forth ROW
        JPanel output4 = new JPanel();
        output4.setLayout(new GridLayout(1,4));
        //output4.setLayout(new FlowLayout());


        // Range
        // Range
        JLabel rangelab = new JLabel("Range");
        rangelab.setHorizontalAlignment(JLabel.CENTER);
        output4.add(rangelab);
        rangetxt = new JTextField( "-" ,13);
        rangetxt.setEditable(false);
        rangetxt.setHorizontalAlignment(JTextField.CENTER);
        output4.add(rangetxt);
        range2txt = new JTextField( "-" ,13);
        range2txt.setEditable(false);
        output4.add(range2txt);
        range2txt.setHorizontalAlignment(JTextField.CENTER);
        // Spacer
        JLabel spacer = new JLabel("");
        output4.add(spacer);

        output.add(output4);

        // Add input  and output pannels to content pannel
        center.add(input);
        center.add(output);

        // Add center (content) to main frame
        main.add(center);

        // main window
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("IP Calculator - memoriasIT");
        frame.setSize(510,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add the Jpanel to the main window
        frame.add(main);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);


    }

    private void determineIPGroup(int ipgroup){
        char IPGroupSTR;
        if (ipgroup < 128) {
            IPGroupSTR = 'A';
        } else if (ipgroup < 192){
            IPGroupSTR = 'B';
        } else if (ipgroup < 224){
            IPGroupSTR = 'C';
        } else if (ipgroup < 240){
            IPGroupSTR = 'D';
        } else if (ipgroup < 255){
            IPGroupSTR = 'E';
        } else {
            IPGroupSTR = '-';
        }


        classtxt.setText(String.valueOf(IPGroupSTR));
    }

    public static void main(String[] args){
        new Window().createWindow();
    }

    private void invalidIP(){
        // Valid or not
        validtxt.setText("Invalid");
        // Class
        classtxt.setText("-");
        // Net ID
        netidtxt.setText("-");
        // Network Mask
        netmasktxt.setText("-");
        // BroadCast
        broadcasttxt.setText("-");
        // Number of IPs
        ipnumtxt.setText("-");
        // Range
        rangetxt.setText("-");
        range2txt.setText("-");

    }


    private void CalculateAction(){
        String ip;
        String subnetmask;

        ip = ipinput.getText();
        subnetmask = submaskinput.getText();

        // Regex to work with ip
        Pattern pattern = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
        Matcher matcher = pattern.matcher(ip);


        // Do not compute if ip is not valid
        if (!matcher.matches() && !subnetmask.equals("")){
            invalidIP();
        } else {
            // Set IP to Valid
            validtxt.setText("Valid");
            // Determine the IP Group
            int ipgroup = Integer.parseInt(matcher.group(1));
            determineIPGroup(ipgroup);

            // Ask for subnet mask and compute more things
                try {
                    // Compute subnet id, mask, broadcastip and range
                    subnetid(ip, Integer.parseInt(subnetmask));

                } catch (Exception e) {
                    e.printStackTrace();
                    invalidIP();
                }
            }
    }

    // Converting long to String in ip format
    private String inttoip(long ip){
        // We use a stringbuilder
        StringBuilder sb = new StringBuilder(15);

        // We go for the 4 octets
        for (int i = 0; i < 4; i++) {
            sb.insert(0, Long.toString(ip & 0xff));
            if (i < 3) {
                sb.insert(0, '.');
            }
            ip >>= 8;
        }

        return sb.toString();
    }


    // Converting String to long
    private long iptoint(String ip){
        // Must use \\. to get regex "\."
        String[] ipArray = ip.split("\\.");
        long result = 0;
        for (int i = 0; i < ipArray.length; i++) {
            int pow = 3 - i;
            result += ((Integer.parseInt(ipArray[i]) % 256 * Math.pow(256, pow)));
        }

        return result;
    }


    private void subnetid(String ip, int intmask){
        String mask;
        String subnetid;
        String broadcast;
        String maxhost;
        String minhost;


        intmask = 0xffffffff << (32 - intmask);
        long intsubnetid = iptoint(ip) & intmask;
        subnetid = inttoip(intsubnetid);


        mask = inttoip(intmask);


        long intminhost = intsubnetid +1;
        minhost = inttoip(intminhost);


        long intinvertedmask = ~intmask;
        long intbroadcast = intsubnetid | intinvertedmask;
        broadcast = inttoip(intbroadcast);


        long intmaxhost = iptoint(broadcast);
        intmaxhost -= 1;
        maxhost = inttoip(intmaxhost);


        long range = intmaxhost - intminhost +1;
        String strrange = Long.toString(range);



        // Net ID
        netidtxt.setText(subnetid);
        // Network Mask
        netmasktxt.setText(mask);
        // BroadCast
        broadcasttxt.setText(broadcast);
        // Number of IPs
        ipnumtxt.setText(strrange);
        // Range
        rangetxt.setText(minhost);
        range2txt.setText(maxhost);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == calculatebtn){
            CalculateAction();
        }

    }
}
