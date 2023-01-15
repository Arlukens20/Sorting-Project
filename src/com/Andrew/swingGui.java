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
        JTextField textFieldTwo;
        JTextArea textArea;

        JButton btn_send = new JButton("Send");
        JButton btn_reset = new JButton("Reset");
        JButton btn_Add = new JButton("Add to Array");
        int[] masterArray = null;
        JFrame jframe = new JFrame("Main Screen");
        JFrame visualize = new JFrame("Visualize");

    public swingGui(){

        //create JFrame object
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(400,400);         //set size of GUI screen


        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Options");
        JMenu sortMenu = new JMenu("Perform");
        JMenu helpMenu = new JMenu("Help");

        menuBar.add(sortMenu);
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        //create two more option in FILE button
        JMenuItem fileMenu1 = new JMenuItem("Generate Array");
        fileMenu.add(fileMenu1);

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
//        JScrollPane scrollPane = new JScrollPane(textArea);

//        //Create the panel at bottom and add label, textArea and buttons
//        JPanel panel = new JPanel(); // this panel is not visible in output
//        JLabel label = new JLabel("Utilities");
//        textField = new JTextField(15); // accepts upto 15 characters
//
//        panel.add(label); // Components Added using Flow Layout
//        panel.add(textField);
//        panel.add(btn_send);
//        panel.add(btn_reset);

        //Create the panel at bottom and add label, textArea and buttons
        JPanel panelTwo = new JPanel(); // this panel is not visible in output
        JLabel labelTwo = new JLabel("Please Construct");
        textFieldTwo = new JTextField(15); // accepts upto 15 characters

        panelTwo.add(labelTwo);
        panelTwo.add(textFieldTwo);
        panelTwo.add(btn_Add);
        panelTwo.add(btn_reset);

        //Actions
//        btn_send.addActionListener(this::actionPerformed);
        btn_Add.addActionListener(this::actionPerformed);
        btn_reset.addActionListener(this::actionPerformed_Reset);
        fileMenu1.addActionListener(this::actionPerformed_Generate);

        //Sorting Actions
        sortMenu1.addActionListener(this::actionPerformed_Bubble);
        sortMenu2.addActionListener(this::actionPerformed_Counting);
        sortMenu3.addActionListener(this::actionPerformed_Insert);
        sortMenu4.addActionListener(this::actionPerformed_Merge);
        sortMenu5.addActionListener(this::actionPerformed_Quick);
        sortMenu6.addActionListener(this::actionPerformed_Select);
        sortMenu7.addActionListener(this::actionPerformed_Sort);

        //Adding the constructor options to a simple panel.
//        JPanel optionPanel = new JPanel(new GridLayout(2, 1, 10, 10));
//        optionPanel.add(panel);
//        optionPanel.add(panelTwo);

        jframe.getContentPane().add(BorderLayout.SOUTH, panelTwo);
        jframe.getContentPane().add(BorderLayout.NORTH, menuBar);
        jframe.getContentPane().add(BorderLayout.CENTER, textArea);

        jframe.pack();
        jframe.setVisible(true);
    }

//    public void actionPerformed(ActionEvent e) {
//        textArea.append(textField.getText());
//        JOptionPane.showMessageDialog(this.jframe, "Submitted");
////        textField.setEnabled(false);
//        btn_send.setEnabled(false);
//    }

    public void actionPerformed(ActionEvent e) {
        String s = addToArray(textFieldTwo.getText());
        if(!s.equals("")) {
            textArea.setText(s);
            JOptionPane.showMessageDialog(this.jframe, "Submitted");
//            textField.setEnabled(false);
            btn_send.setEnabled(false);
        }
    }


    public void actionPerformed_Reset(ActionEvent e) {
        textArea.selectAll();
//        textField.selectAll();
//        textField.replaceSelection("");
        textArea.replaceSelection("");

        masterArray = null;
        JOptionPane.showMessageDialog(this.jframe, "Reset Array");
        textField.setEnabled(true);
        btn_send.setEnabled(true);
    }

    public void actionPerformed_Generate(ActionEvent e) {
        System.out.println("Testing Generate");
        randomArrayGenerator rand = new randomArrayGenerator();
        masterArray = rand.generateArray(10, 100);
        textArea.setText(rand.convertToString(masterArray));
        JOptionPane.showMessageDialog(this.jframe, "Generate Array Successful");
//        textField.setEnabled(false);
        btn_send.setEnabled(false);
    }

    public void actionPerformed_Bubble(ActionEvent e) {
        try {
            BubbleSort bubble = new BubbleSort();
            int[] arr = convertStringtoInt(textArea.getText());
            bubble.BuSort(arr);
            masterArray = arr;
            textArea.setText(Arrays.toString(masterArray));
            JOptionPane.showMessageDialog(this.jframe, "Not implemented");
        }catch (Exception exception){
            JOptionPane.showMessageDialog(this.jframe, "Error","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actionPerformed_Insert(ActionEvent e) {
        try{
            InsertSort sort = new InsertSort();
            int[] arr = convertStringtoInt(textArea.getText());
            sort.insertionSort(arr,arr.length);
            masterArray = arr;
            textArea.setText(Arrays.toString(masterArray));
            JOptionPane.showMessageDialog(this.jframe, "Insert Sort Successful");
        }catch (Exception exception){
            JOptionPane.showMessageDialog(this.jframe, "Error","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actionPerformed_Merge(ActionEvent e) {
        try{
            MergeSort sort = new MergeSort();
            int[] arr = convertStringtoInt(textArea.getText());
            sort.sort(arr, 0, arr.length-1);
            masterArray = arr;
            textArea.setText(Arrays.toString(masterArray));
            JOptionPane.showMessageDialog(this.jframe, "Merge Sort Successful");
        }catch (Exception exception){
            JOptionPane.showMessageDialog(this.jframe, "Error","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actionPerformed_Quick(ActionEvent e) {
        try{
            QuickSort qs = new QuickSort();
            int[] arr = convertStringtoInt(textArea.getText());
            qs.quickSort(arr, 0, arr.length - 1);
            masterArray = arr;
            textArea.setText(Arrays.toString(masterArray));
            JOptionPane.showMessageDialog(this.jframe, "Quick Sort Successful");
        }catch (Exception exception){
            JOptionPane.showMessageDialog(this.jframe, "Error","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actionPerformed_Select(ActionEvent e) {
        try{
            SelectionSort sort = new SelectionSort();
            int[] arr = convertStringtoInt(textArea.getText());
            sort.sort(arr);
            masterArray = arr;
            textArea.setText(Arrays.toString(masterArray));
            JOptionPane.showMessageDialog(this.jframe, "Select Sort Successful");
        }catch (Exception exception){
            JOptionPane.showMessageDialog(this.jframe, "Error","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actionPerformed_Sort(ActionEvent e) {
        try{
//            int[] arr = convertStringtoInt(textArea.getText());
//            masterArray = arr;
            masterArray = convertStringtoInt(textArea.getText());
            Arrays.sort(masterArray);
            textArea.setText(Arrays.toString(masterArray));
            JOptionPane.showMessageDialog(this.jframe, "Simple Sort Successful");
            showVisualizer();
        }catch (Exception exception){
            JOptionPane.showMessageDialog(this.jframe, "Error","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    //Not implemented
    public void actionPerformed_Counting(ActionEvent e) {
        try {
            CountingSort sort = new CountingSort();
            int[] arr = convertStringtoInt(textArea.getText());
            masterArray = arr;
//        sort.(arr);
            textArea.setText(Arrays.toString(arr));
            JOptionPane.showMessageDialog(this.jframe, "Counting Sort Successful");
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

    public void showVisualizer(){
        jframe.pack();
        jframe.setVisible(false);

        textArea = new JTextArea(5, 20);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setText("HelloWorld");
        visualize.add(textArea);

        visualize.pack();
        visualize.setVisible(true);
    }

    public String addToArray(String element){
        try {
            int[] newArray;
            if (masterArray != null) {
                newArray = new int[masterArray.length + 1];
//
                System.arraycopy(masterArray, 0, newArray, 0, masterArray.length);

                newArray[masterArray.length] = Integer.parseInt(element);
            } else {
                newArray = new int[]{Integer.parseInt(element)};
            }
            masterArray = newArray;
            return Arrays.toString(masterArray);
        }catch (Exception e){
            JOptionPane.showMessageDialog(this.jframe, "Please Enter a Number","Error",JOptionPane.ERROR_MESSAGE);
            return "";
        }
    }
}
