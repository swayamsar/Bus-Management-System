import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class AddBus {
    
    JFrame frame;
    JPanel windowContent = new JPanel();
    char[][] seatStruct = new char[10][10];
    int X, Y;
    
    JButton type = new JButton("Enter Bus Type");
    JButton sorc = new JButton("ADD THE SOURCE");
    JButton des = new JButton("ADD THE DESTINATION");
    JButton pric = new JButton("Enter the price");
    JButton strt = new JButton("Enter the Start Time");
    JButton end = new JButton("Enter the End Time");
    JButton rows = new JButton("ENTER THE NO. OF ROW");
    JButton columns = new JButton("ENTER THE NO. OF COLUMNS ");
    JButton confirm = new JButton("CONFIRM");
    JButton backbut = new JButton("Back");

    JLabel route = new JLabel("Enter Route No.");
    JTextField inputRt = new JTextField(10);
    JLabel uniq = new JLabel("Enter Unique Key");
    JTextField inputUniq = new JTextField(10);

    String inputType, src, dest, price, start, etime, row, column, rtNo;

    AddBus(String company) {
        frame = new JFrame("ADD A " + company + " BUS");
        Toolkit toolKit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolKit.getScreenSize();
        X = screenSize.height;
        Y = screenSize.width;
        
        frame.setSize(X, Y);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setIconImage(new ImageIcon("C:\\Rohit\\Java Stuff\\NetBeans\\busmodfinal\\bus.jpg").getImage());

        // Adding Action Listeners
        type.addActionListener(new TypeHandler());
        sorc.addActionListener(new SrcHandler());
        des.addActionListener(new DestHandler());
        pric.addActionListener(new PriceHandler());
        strt.addActionListener(new StrtHandler());
        end.addActionListener(new EndHandler());
        rows.addActionListener(new RowHandler());
        columns.addActionListener(new ColHandler());
        confirm.addActionListener(new ButtonHandler());
        backbut.addActionListener(new BackHandler());

        // Initializing seat structure
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                seatStruct[i][j] = 'X'; // Adding seats
            }
        }

        windowContent.setLayout(new GridLayout(0, 1));

        windowContent.add(type);
        windowContent.add(sorc);
        windowContent.add(des);
        windowContent.add(pric);
        windowContent.add(strt);
        windowContent.add(end);
        windowContent.add(route);
        windowContent.add(inputRt);
        windowContent.add(rows);
        windowContent.add(columns);
        windowContent.add(confirm);
        windowContent.add(backbut);

        frame.setContentPane(windowContent);
        frame.setVisible(true);
        frame.setBounds(0, 0, 2 * X, Y);
    }

    // Action Handlers
    private class TypeHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String[] options = {"AC SLEEPER", "AC SEMI SLEEPER", "NON AC SLEEPER", "AC"};
            inputType = (String) JOptionPane.showInputDialog(windowContent, "Choose One", "Input",
                    JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        }
    }

    private class SrcHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String[] options = {"Bangalore", "Chennai", "Kochi", "Hyderabad", "Manipal"};
            src = (String) JOptionPane.showInputDialog(windowContent, "Choose One", "Input",
                    JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        }
    }

    private class DestHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String[] options = {"Chennai", "Bangalore", "Kochi", "Hyderabad", "Manipal"};
            dest = (String) JOptionPane.showInputDialog(windowContent, "Choose One", "Input",
                    JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        }
    }

    private class PriceHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String[] options = {"250", "300", "350", "400", "450", "500", "550", "600", "650", "700"};
            price = (String) JOptionPane.showInputDialog(windowContent, "Choose One", "Input",
                    JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        }
    }

    private class StrtHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String[] options = {"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00"};
            start = (String) JOptionPane.showInputDialog(windowContent, "Choose One", "Input",
                    JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        }
    }

    private class EndHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String[] options = {"12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00"};
            etime = (String) JOptionPane.showInputDialog(windowContent, "Choose One", "Input",
                    JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        }
    }

    private class RowHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String[] options = {"1", "2", "3"};
            row = (String) JOptionPane.showInputDialog(windowContent, "Choose One", "Input",
                    JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        }
    }

    private class ColHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String[] options = {"1", "2", "3", "4", "5"};
            column = (String) JOptionPane.showInputDialog(windowContent, "Choose One", "Input",
                    JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        }
    }

    private class BackHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
        }
    }

    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                rtNo = inputRt.getText();
                if (rtNo.isEmpty() || (!rtNo.startsWith("V") && !rtNo.startsWith("D") && !rtNo.startsWith("S"))) {
                    JOptionPane.showMessageDialog(windowContent, "ENTER ROUTE STARTING WITH V/D/S");
                    return;
                }

                JOptionPane.showMessageDialog(windowContent, "THE BUS HAS BEEN ADDED");
                frame.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(windowContent, "ERROR: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new AddBus("VRL");
    }
}
