package com.Andrew;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class swingGui extends JPanel implements ActionListener {
        private final static String newline = "\n";
        JTextField textField;
        JTextArea textArea;
    JFrame jframe = new JFrame("Main Screen");

    public swingGui(){

           //create JFrame object
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(400,400);         //set size of GUI screen


        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Options");
        JMenu helpMenu = new JMenu("Help");

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        //create two more option in FILE button
        JMenuItem fileMenu1 = new JMenuItem("Generate Array");
        JMenuItem fileMenu2 = new JMenuItem("Provide Array");
        fileMenu.add(fileMenu1);
        fileMenu.add(fileMenu2);
        // Text Area at the Center
//        JTextArea textArea = new JTextArea();

        textArea = new JTextArea(5, 20);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);


        //Create the panel at bottom and add label, textArea and buttons
        JPanel panel = new JPanel(); // this panel is not visible in output
        JLabel label = new JLabel("Please Enter Array");
        textField = new JTextField(15); // accepts upto 15 characters
//        textField.addActionListener(this);

        JButton btn_send = new JButton("Send");
        JButton btn_reset = new JButton("Reset");
        panel.add(label); // Components Added using Flow Layout
        panel.add(textField);
        panel.add(btn_send);
        panel.add(btn_reset);

        //Actions
        btn_send.addActionListener(this::actionPerformed);
        btn_reset.addActionListener(this::actionPerformedReset);
        fileMenu1.addActionListener(this::actionPerformedGenerate);

        jframe.getContentPane().add(BorderLayout.SOUTH, panel);
        jframe.getContentPane().add(BorderLayout.NORTH, menuBar);
        jframe.getContentPane().add(BorderLayout.CENTER, textArea);

        jframe.pack();
        jframe.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Testing submit");
        textArea.append(textField.getText());
        JOptionPane.showMessageDialog(this.jframe, "Submitted");
    }

    public void actionPerformedReset(ActionEvent e) {
        System.out.println("Testing Reset");
        textArea.selectAll();
        textField.selectAll();
        textField.replaceSelection("");
        textArea.replaceSelection("");
        JOptionPane.showMessageDialog(this.jframe, "Reset");
    }

    public void actionPerformedGenerate(ActionEvent e) {
        System.out.println("Testing Generate");
        randomArrayGenerator rand = new randomArrayGenerator();
           textArea.setText(rand.convertToString(rand.generateArray(10, 100)));
        JOptionPane.showMessageDialog(this.jframe, "Generate Array");
    }
}
