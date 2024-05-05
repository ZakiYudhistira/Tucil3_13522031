package GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import DataStructs.*;
import Util.*;

// The GUI Setup

public class Frame extends JFrame implements ActionListener{
    JButton acc_button;
    JRadioButton ucs_button;
    JRadioButton greedy_BFS;
    JRadioButton astar_button;
    JTextField input_first_word;
    JTextField input_second_word;

    Map<String, Boolean> dictionary;

    Boolean ucs = false;
    Boolean astar = false;
    Boolean greedy = false;
    Boolean loaded_dict = false;
    
    public Frame(String title, int hex){ // Main menu setup
        super();

        File workingDirectory = new File(System.getProperty("user.dir") + "/src/Dictionary");

        JFileChooser select = new JFileChooser();
        select.setDialogTitle("Select your dictionary file");
        select.setFileFilter(new FileNameExtensionFilter(".txt", "txt", "text"));
        select.setCurrentDirectory(workingDirectory);

        try {
            int response = select.showOpenDialog(null);

            if(response == JFileChooser.APPROVE_OPTION){
                dictionary = Loader.loadDictionary(select.getSelectedFile().getAbsolutePath());
            } else {
                throw new Exception("No file is choosen");
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "No file is choosen", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        JPanel title_panel = new JPanel();
        title_panel.setBackground(new Color(hex));
        title_panel.setBounds(0, 0, 700, 370);

        JLabel label = new JLabel();
        ImageIcon giga_main = new ImageIcon("bin/images/ez.png");
        label.setBounds(0, 0, 740, 370);
        label.setIcon(giga_main);
        label.setText("Word Ladder Solver");
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(Color.white);
        label.setFont(new Font("Nunito", Font.BOLD, 48));
        label.setIconTextGap(20);

        title_panel.add(label);
        
        JPanel input_panel1 = new JPanel();
        input_panel1.setBounds(0, 360, 370, 30);
        input_panel1.setBackground(new Color(hex));
        
        JLabel input_label1 = new JLabel();
        input_label1.setForeground(Color.WHITE);
        input_label1.setBounds(0, 0, 300, 24);
        input_label1.setFont(new Font("Nunito", Font.PLAIN, 14));
        input_label1.setText("First word Here:");
        input_label1.setHorizontalAlignment(JLabel.CENTER);
        
        input_panel1.add(input_label1);
        
        JPanel input_panel11 = new JPanel();
        input_panel11.setBounds(0, 390, 370, 30);
        input_panel11.setBackground(new Color(hex));
        
        input_first_word = new JTextField(22);
        input_first_word.setFont(new Font("Nunito", Font.BOLD, 14));
        input_panel11.add(input_first_word);

        JPanel input_panel2 = new JPanel();
        input_panel2.setBackground(new Color(hex));
        input_panel2.setBounds(370, 360, 370, 30);
        
        JLabel input_label2 = new JLabel();
        input_label2.setForeground(Color.WHITE);
        input_label2.setBounds(0, 0, 300, 24);
        input_label2.setText("Second word Here:");
        input_label2.setFont(new Font("Nunito", Font.PLAIN, 14));
        input_label2.setHorizontalAlignment(JLabel.CENTER);
        
        input_panel2.add(input_label2);
        
        JPanel input_panel22 = new JPanel();
        input_panel22.setBounds(370, 390, 370, 30);
        input_panel22.setBackground(new Color(hex));
        
        input_second_word = new JTextField(22);
        input_second_word.setFont(new Font("Nunito", Font.BOLD, 14));
        input_panel22.add(input_second_word);

        JPanel button_panel = new JPanel();
        button_panel.setBounds(-20, 420, 740, 30);

        ucs_button = new JRadioButton("Uniform Cost Seach");
        greedy_BFS = new JRadioButton("Greedy Best First Search");
        astar_button = new JRadioButton("A*");

        ucs_button.addActionListener(this);
        greedy_BFS.addActionListener(this);
        astar_button.addActionListener(this);

        ucs_button.setBackground(new Color(hex));
        greedy_BFS.setBackground(new Color(hex));
        astar_button.setBackground(new Color(hex));

        ucs_button.setFont(new Font("Nunito", Font.PLAIN, 14));
        ucs_button.setForeground(Color.WHITE);

        greedy_BFS.setFont(new Font("Nunito", Font.PLAIN, 14));
        greedy_BFS.setForeground(Color.WHITE);

        astar_button.setFont(new Font("Nunito", Font.PLAIN, 14));
        astar_button.setForeground(Color.WHITE);

        ButtonGroup button_group = new ButtonGroup();

        button_group.add(ucs_button);
        button_group.add(greedy_BFS);
        button_group.add(astar_button);

        button_panel.add(ucs_button);
        button_panel.add(greedy_BFS);
        button_panel.add(astar_button);

        button_panel.setBackground(new Color(hex));

        JPanel button_acc_panel = new JPanel();
        button_acc_panel.setBounds(0, 460, 740, 50);
        button_acc_panel.setBackground(new Color(hex));

        acc_button = new JButton("Compute");
        acc_button.setPreferredSize(new Dimension(120,40));
        acc_button.setFont(new Font("Nunito", Font.BOLD, 14));
        acc_button.addActionListener(this);

        button_acc_panel.add(acc_button);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(title);
        this.setLayout(null);
        this.setSize(740, 580);
        this.setResizable(false);
        ImageIcon image = new ImageIcon("bin/images/giga.jpg");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(hex));
        
        
        this.add(title_panel);
        this.add(input_panel1);
        this.add(input_panel11);
        this.add(input_panel2);
        this.add(input_panel22);
        this.add(button_panel);
        this.add(button_acc_panel);
        this.setVisible(true);
    }

    // @Override
    public void actionPerformed(ActionEvent e){ // Button and radio button handling
        if(e.getSource() == ucs_button){
            ucs = true;
            astar = false;
            greedy = false;
        } else if (e.getSource() == astar_button) {
            ucs = false;
            astar = true;
            greedy = false;
        } else if (e.getSource() == greedy_BFS){
            ucs = false;
            astar = false;
            greedy = true;
        }

        if(e.getSource() == acc_button){
            try {
                String first_word = input_first_word.getText().toUpperCase();
                String second_word = input_second_word.getText().toUpperCase();
                if(!ucs && !astar && !greedy ){
                    throw new Exception("Select an algorithm first!");
                }

                if(input_first_word.getText().length() != input_second_word.getText().length()){
                    throw new Exception("Different word length");
                }
                
                if(!dictionary.containsKey(first_word) || !dictionary.containsKey(second_word)){
                    throw new Exception("The words are not recognized");
                }

                if(first_word.equals(second_word)){
                    throw new Exception("Both words can't be the same");
                }

                Run r = new Run(dictionary, first_word, second_word);
                if(ucs){
                    ResultFrame res = new ResultFrame(r.runUCS(), 0x272829, "Uniform Cost Search");
                } else if (astar) {
                    ResultFrame res = new ResultFrame(r.runAStar(), 0x272829, "A*");
                } else if (greedy) {
                    ResultFrame res = new ResultFrame(r.runBFS(), 0x272829, "Greedy Best First Search");
                }
            } catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

class ResultFrame extends JFrame {
    
    ResultFrame(Return output, int hex, String algorithm_name){
        super();

        JLabel title_label = new JLabel();
        title_label.setText("Result");
        title_label.setFont(new Font("Nunito", Font.BOLD, 62));
        title_label.setForeground(Color.WHITE);

        JPanel title_panel = new JPanel();
        title_panel.setBounds(0, 0, 580, 70);
        title_panel.setBackground(new Color(hex));

        title_panel.add(title_label);

        JLabel al_label = new JLabel();
        al_label.setFont(new Font("Nunito", Font.ITALIC, 14));
        al_label.setForeground(Color.WHITE);
        al_label.setText("Using the " + algorithm_name + " algorithm");

        JPanel al_panel = new JPanel();
        al_panel.setBounds(0, 70, 580, 24);
        al_panel.setBackground(new Color(hex));
        al_panel.add(al_label);

        JLabel count_label = new JLabel();
        count_label.setFont(new Font("Nunito", Font.PLAIN, 14));
        count_label.setForeground(Color.WHITE);
        count_label.setText(Long.toString(output.words_processed) + " Words Processed - ");

        JLabel time_label = new JLabel();
        time_label.setFont(new Font("Nunito", Font.PLAIN, 14));
        time_label.setForeground(Color.WHITE);
        time_label.setText(Long.toString(output.exec_time) + "ms Time taken - ");

        JLabel mem_label = new JLabel();
        mem_label.setFont(new Font("Nunito", Font.PLAIN, 14));
        mem_label.setForeground(Color.WHITE);
        mem_label.setText(Long.toString(output.mem_usage / 1000) + "kB memory used");

        JPanel res_panel = new JPanel();
        res_panel.setBounds(0, 105, 580, 24);
        res_panel.setBackground(new Color(hex));

        res_panel.add(count_label);
        res_panel.add(time_label);
        res_panel.add(mem_label);

        JPanel res_title = new JPanel();
        res_title.setBounds(0, 130, 580, 30);
        res_title.setBackground(new Color(hex));

        JLabel res_label = new JLabel();
        res_label.setFont(new Font("Nunito", Font.PLAIN, 20));
        res_label.setForeground(Color.WHITE);
        res_label.setText("==Path found==");

        res_title.add(res_label);

        JPanel path_panel = new JPanel();
        path_panel.setBounds(10, 165, 550, 580);
        path_panel.setBackground(new Color(hex));


        boolean first = true;
        for(int i = 0 ; i < output.path.size() ; i++){
            JLabel label = new JLabel();
            if(first){
                label.setText(output.path.get(i));
                label.setFont(new Font("Nunito", Font.BOLD, 20));
                first = false;
                label.setForeground(Color.RED);
            } else if (i == output.path.size() - 1){
                label.setText(" → " + output.path.get(i));
                label.setFont(new Font("Nunito", Font.BOLD, 20));
                label.setText(" → " + output.path.get(i));
                label.setForeground(Color.BLUE);
            } else {
                label.setText(" → " + output.path.get(i));
                label.setFont(new Font("Nunito", Font.PLAIN, 20));
                label.setForeground(Color.GREEN);
            }
            path_panel.add(label);
        }

        this.setSize(580, 580);
        this.getContentPane().setBackground(new Color(hex));
        this.setLayout(null);

        this.add(title_panel);
        this.add(res_panel);
        this.add(res_title);
        this.add(path_panel);
        this.add(al_panel);

        this.setVisible(true);
    }
}