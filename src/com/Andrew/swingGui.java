package com.Andrew;

import com.Andrew.SortingClasses.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

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
        JMenu sortMenu = new JMenu("Perform");
        JMenu helpMenu = new JMenu("Help");

        menuBar.add(fileMenu);
        menuBar.add(sortMenu);
        menuBar.add(helpMenu);

        //create two more option in FILE button
        JMenuItem fileMenu1 = new JMenuItem("Generate Array");
        JMenuItem fileMenu2 = new JMenuItem("Provide Array");
        fileMenu.add(fileMenu1);
        fileMenu.add(fileMenu2);

        JMenuItem sortMenu1 = new JMenuItem("Bubble Sort");
        JMenuItem sortMenu2 = new JMenuItem("Counting Sort");
        JMenuItem sortMenu3 = new JMenuItem("Insert Sort");
        JMenuItem sortMenu4 = new JMenuItem("Merge Sort");
        JMenuItem sortMenu5 = new JMenuItem("Quick Sort");
        JMenuItem sortMenu6 = new JMenuItem("Selection Sort");
        JMenuItem sortMenu7 = new JMenuItem("Simple Sort");
        sortMenu.add(sortMenu1);
        sortMenu.add(sortMenu2);
        sortMenu.add(sortMenu3);
        sortMenu.add(sortMenu4);
        sortMenu.add(sortMenu5);
        sortMenu.add(sortMenu6);
        sortMenu.add(sortMenu7);

        textArea = new JTextArea(5, 20);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        //Create the panel at bottom and add label, textArea and buttons
        JPanel panel = new JPanel(); // this panel is not visible in output
        JLabel label = new JLabel("Please Enter Array");
        textField = new JTextField(15); // accepts upto 15 characters

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

        //Sorting Actions
        sortMenu1.addActionListener(this::actionPerformedBubble);
        sortMenu2.addActionListener(this::actionPerformedCounting);
        sortMenu3.addActionListener(this::actionPerformedInsert);
        sortMenu4.addActionListener(this::actionPerformedMerge);
        sortMenu5.addActionListener(this::actionPerformedQuick);
        sortMenu6.addActionListener(this::actionPerformedSelect);
        sortMenu7.addActionListener(this::actionPerformedSort);

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
        textField.setEnabled(false);
    }

    public void actionPerformedReset(ActionEvent e) {
        System.out.println("Testing Reset");
        textArea.selectAll();
        textField.selectAll();
        textField.replaceSelection("");
        textArea.replaceSelection("");
        JOptionPane.showMessageDialog(this.jframe, "Reset");
        textField.setEnabled(true);
    }

    public void actionPerformedGenerate(ActionEvent e) {
        System.out.println("Testing Generate");
        randomArrayGenerator rand = new randomArrayGenerator();
           textArea.setText(rand.convertToString(rand.generateArray(10, 100)));
        JOptionPane.showMessageDialog(this.jframe, "Generate Array");
        textField.setEnabled(false);
    }

    public void actionPerformedBubble(ActionEvent e) {
        try {
            BubbleSort bubble = new BubbleSort();
            int[] arr = convertStringtoInt(textArea.getText());
            bubble.BuSort(arr);
            textArea.setText(Arrays.toString(arr));
            JOptionPane.showMessageDialog(this.jframe, "Not implemented");
        }catch (Exception exception){
            JOptionPane.showMessageDialog(this.jframe, "Error","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actionPerformedInsert(ActionEvent e) {
        try{
            InsertSort sort = new InsertSort();
            int[] arr = convertStringtoInt(textArea.getText());
            sort.insertionSort(arr,arr.length);
            textArea.setText(Arrays.toString(arr));
            JOptionPane.showMessageDialog(this.jframe, "InsertSort");
        }catch (Exception exception){
            JOptionPane.showMessageDialog(this.jframe, "Error","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actionPerformedMerge(ActionEvent e) {
        try{
            MergeSort sort = new MergeSort();
            int[] arr = convertStringtoInt(textArea.getText());
            sort.sort(arr, 0, arr.length-1);
            textArea.setText(Arrays.toString(arr));
            JOptionPane.showMessageDialog(this.jframe, "MergeSort");
        }catch (Exception exception){
            JOptionPane.showMessageDialog(this.jframe, "Error","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actionPerformedQuick(ActionEvent e) {
        try{
            QuickSort qs = new QuickSort();
            int[] arr = convertStringtoInt(textArea.getText());
            qs.quickSort(arr, 0, arr.length - 1);
            textArea.setText(Arrays.toString(arr));
            JOptionPane.showMessageDialog(this.jframe, "QuickSort");
        }catch (Exception exception){
            JOptionPane.showMessageDialog(this.jframe, "Error","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actionPerformedSelect(ActionEvent e) {
        try{
            SelectionSort sort = new SelectionSort();
            int[] arr = convertStringtoInt(textArea.getText());
            sort.sort(arr);
            textArea.setText(Arrays.toString(arr));
            JOptionPane.showMessageDialog(this.jframe, "SelectSort");
        }catch (Exception exception){
            JOptionPane.showMessageDialog(this.jframe, "Error","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actionPerformedSort(ActionEvent e) {
        try{
            int[] arr = convertStringtoInt(textArea.getText());
            Arrays.sort(arr);
            textArea.setText(Arrays.toString(arr));
            JOptionPane.showMessageDialog(this.jframe, "Simple Sort");
        }catch (Exception exception){
            JOptionPane.showMessageDialog(this.jframe, "Error","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    //Not implemented
    public void actionPerformedCounting(ActionEvent e) {
        try {
            CountingSort sort = new CountingSort();
            int[] arr = convertStringtoInt(textArea.getText());
//        sort.(arr);
            textArea.setText(Arrays.toString(arr));
            JOptionPane.showMessageDialog(this.jframe, "CountingSort");
        }catch (Exception exception){
            JOptionPane.showMessageDialog(this.jframe, "Error","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public int[] convertStringtoInt(String str){
        //Parse string into an array.
        String[] string = str.replaceAll("\\[", "")
                .replaceAll("]", "")
                .replaceAll(" ","")
                .split(",");

        // declaring an array with the size of string
        int[] array = new int[string.length];

        for (int i = 0; i < string.length; i++) {
            array[i] = Integer.valueOf(string[i]);
        }

        return array;
    }
}
