import org.w3c.dom.Text;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Vector;
import java.util.regex.PatternSyntaxException;

/**
 * PACKAGE_NAME
 * Created by Admin
 * Date 12/15/2021 - 9:44 PM
 * Description: ...
 */
public class Menu_UI extends JFrame implements ActionListener {
    private JPanel panel1;
    private JPanel panel2;
    private DefaultTableModel mode;
    private JTextField Search_text;
    private JButton search_mean_button;
    private JButton search_slang_button;
    private JButton edit_button;
    private JButton delete_button;
    private JButton random_button;
    private JButton reset_button;
    private JButton history_button;
    private JButton add_button;
    private JButton game_random_slang_button;
    private JButton game_defini_button;
    private JButton game;
    private String[][] Value;
    private JTable table1;
    private JScrollPane scrollPane;
    private JFrame select_game;
    private JButton game_slang_button;
    private JButton game_meaning_button;
    private Dict dict;
    String[] columnname = new String[]{"Slang Word", "Meaning"};
    public void menu_ui() {
        try {
            game_meaning_button=new JButton("Meaning");
            game_slang_button=new JButton("Slang Word");
            select_game =new JFrame();
            this.getContentPane().setBackground(new Color(103,104,171));
            JLabel EnterSlang=new JLabel("Enter Slang Word");
            EnterSlang.setFont(new Font("Serif", Font.PLAIN,25));
            dict=new Dict();
            dict.Copy_File();
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel3=new JPanel();
            panel3.setBackground(new Color(103,104,171));
            JLabel text=new JLabel("Dictionary");
            text.setFont(new Font("Serif", Font.PLAIN, 70));
            panel3.add(text,BorderLayout.CENTER);
            add(panel3,BorderLayout.NORTH);;
            JPanel text_slang=new JPanel();
            BoxLayout box1 = new BoxLayout(text_slang, BoxLayout.LINE_AXIS);
            text_slang.setLayout(box1);
            text_slang.setBackground(new Color(103,104,171));


            panel1 = new JPanel();
            Search_text = new JTextField("");
            Search_text.setBackground(new Color(103,104,171));
            mode= new DefaultTableModel(null,columnname);
            table1 = new JTable(mode);
            table1.setRowHeight(30);
            table1.setDefaultEditor(Object.class, null);
            table1.setBackground(new Color(103,104,171));
            table1.getTableHeader().setFont(new Font("Serif", Font.PLAIN,25));
            table1.setFont(new Font("Serif", Font.PLAIN,20));
            table1.getTableHeader().setBackground(new Color(103,104,171));
            table1.getTableHeader().setBorder(new LineBorder(Color.black,2));

            scrollPane = new JScrollPane(table1);
            scrollPane.setBackground(new Color(103,104,171));
            scrollPane.setBorder(BorderFactory.createLineBorder(new Color(103,104,171),3));
            Search_text.setMaximumSize(new Dimension(500, 1000));
            Search_text.setFont(new Font("Serif", Font.PLAIN, 20));
            /*Search_text.setBorder(BorderFactory.createLineBorder(Color.black));*/
            Search_text.setBorder(new LineBorder(Color.black,2));
            BoxLayout box = new BoxLayout(panel1, BoxLayout.Y_AXIS);
            panel1.setLayout(box);
            panel1.setBackground(new Color(103,104,171));
            text_slang.add(EnterSlang);
            text_slang.add(Box.createRigidArea(new Dimension(20,0)));
            text_slang.add(Search_text);
            panel1.add(text_slang);
            panel1.add(Box.createRigidArea(new Dimension(0,5)));
            panel1.add(scrollPane);
            add(panel1,BorderLayout.CENTER);

            panel2=new JPanel();
            panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
            search_slang_button=new JButton("Search Slang Word");
            search_slang_button.setFont(new Font("Serif", Font.PLAIN,20));
            search_slang_button.setBorder(new LineBorder(new Color(255, 221, 189),2));
            search_mean_button = new JButton("Search Definition");
            search_mean_button.setFont(new Font("Serif", Font.PLAIN,20));
            search_mean_button.setBorder(new LineBorder(new Color(255, 221, 189),2));
            edit_button=new JButton("Edit Slang Word");
            edit_button.setFont(new Font("Serif", Font.PLAIN,20));
            edit_button.setBorder(new LineBorder(new Color(255, 221, 189),2));
            delete_button=new JButton("Delete Slang Word");
            delete_button.setFont(new Font("Serif", Font.PLAIN,20));
            delete_button.setBorder(new LineBorder(new Color(255, 221, 189),2));
            random_button=new JButton("Random Slang Word");
            random_button.setFont(new Font("Serif", Font.PLAIN,20));
            random_button.setBorder(new LineBorder(new Color(255, 221, 189),2));
            reset_button=new JButton("Reset Slang Word");
            reset_button.setFont(new Font("Serif", Font.PLAIN,20));
            reset_button.setBorder(new LineBorder(new Color(255, 221, 189),2));
            history_button=new JButton("History Search");
            history_button.setFont(new Font("Serif", Font.PLAIN,20));
            history_button.setBorder(new LineBorder(new Color(255, 221, 189),2));
            add_button=new JButton("Add Slang Word");
            add_button.setFont(new Font("Serif", Font.PLAIN,20));
            add_button.setBorder(new LineBorder(new Color(255, 221, 189),2));
            game_random_slang_button=new JButton("Random Slang World");
            game_random_slang_button.setFont(new Font("Serif", Font.PLAIN,20));
            game_random_slang_button.setBorder(new LineBorder(new Color(255, 221, 189),2));
            game_defini_button=new JButton(" Random Definition");
            game_defini_button.setFont(new Font("Serif", Font.PLAIN,20));
            game_defini_button.setBorder(new LineBorder(new Color(255, 221, 189),2));
            game =new JButton("Game Random");
            game.setFont(new Font("Serif", Font.PLAIN,20));
            game.setBorder(new LineBorder(new Color(255, 221, 189),2));


            search_slang_button.setActionCommand("search_slang");
            search_slang_button.addActionListener(this);
            search_slang_button.setBackground(new Color(171,136,103));
            search_slang_button.setMaximumSize(new Dimension(game_random_slang_button.getMaximumSize().width,table1.getTableHeader().getMaximumSize().height));

            search_mean_button.setActionCommand("search_mean");
            search_mean_button.addActionListener(this);
            search_mean_button.setBackground(new Color(171,136,103));
            search_mean_button.setMaximumSize(new Dimension(game_random_slang_button.getMaximumSize().width,table1.getTableHeader().getMaximumSize().height));

            edit_button.setActionCommand("edit");
            edit_button.addActionListener(this);
            edit_button.setBackground(new Color(171,136,103));
            edit_button.setMaximumSize(new Dimension(game_random_slang_button.getMaximumSize().width,table1.getTableHeader().getMaximumSize().height));

            delete_button.setActionCommand("delete");
            delete_button.addActionListener(this);
            delete_button.setBackground(new Color(171,136,103));
            delete_button.setMaximumSize(new Dimension(game_random_slang_button.getMaximumSize().width,table1.getTableHeader().getMaximumSize().height));

            reset_button.setActionCommand("reset");
            reset_button.addActionListener(this);
            reset_button.setBackground(new Color(171,136,103));
            reset_button.setMaximumSize(new Dimension(game_random_slang_button.getMaximumSize().width,table1.getTableHeader().getMaximumSize().height));

            random_button.setActionCommand("random");
            random_button.addActionListener(this);
            random_button.setBackground(new Color(171,136,103));
            random_button.setMaximumSize(new Dimension(game_random_slang_button.getMaximumSize().width,table1.getTableHeader().getMaximumSize().height));

            history_button.setActionCommand("history");
            history_button.addActionListener(this);
            history_button.setBackground(new Color(171,136,103));
            history_button.setMaximumSize(new Dimension(game_random_slang_button.getMaximumSize().width,table1.getTableHeader().getMaximumSize().height));

            add_button.setActionCommand("add");
            add_button.addActionListener(this);
            add_button.setBackground(new Color(171,136,103));
            add_button.setMaximumSize(new Dimension(game_random_slang_button.getMaximumSize().width,table1.getTableHeader().getMaximumSize().height));

            game_defini_button.setActionCommand("randomdefini");
            game_defini_button.addActionListener(this);
            game_defini_button.setBackground(new Color(171,136,103));
            game_defini_button.setMaximumSize(new Dimension(game_random_slang_button.getMaximumSize().width,table1.getTableHeader().getMaximumSize().height));



            game_slang_button.setActionCommand("randomslang");
            game_slang_button.addActionListener(this);
            game_slang_button.setBackground(new Color(171,136,103));
            game_slang_button.setFont(new Font("Serif", Font.PLAIN,18));
            game_slang_button.setBorder(new LineBorder(new Color(255, 221, 189),2));

            game_meaning_button.setActionCommand("randomdefini");
            game_meaning_button.addActionListener(this);
            game_meaning_button.setBackground(new Color(171,136,103));
            game_meaning_button.setFont(new Font("Serif", Font.PLAIN,18));
            game_meaning_button.setBorder(new LineBorder(new Color(255, 221, 189),2));

            game_meaning_button.setMaximumSize(new Dimension(120,35));
            game_slang_button.setMaximumSize(new Dimension(120,35));

            game.setActionCommand("game");
            game.setBackground(new Color(171,136,103));
            game.setMaximumSize(new Dimension(game_random_slang_button.getMaximumSize().width,table1.getTableHeader().getMaximumSize().height));
            game.addActionListener(new ActionListener() {
                                                           @Override
                                                           public void actionPerformed(ActionEvent e) {
                                                               JPanel text1=new JPanel();
                                                               JLabel text=new JLabel("Select game type");
                                                               text1.setBackground(new Color(103,104,171));
                                                               text.setFont(new Font("Serif", Font.PLAIN, 28));
                                                               text1.add(text);
                                                               select_game.add(text1,BorderLayout.NORTH);
                                                               select_game.getContentPane().setBackground(new Color(103,104,171));
                                                               


                                                               JPanel panel=new JPanel();
                                                               BoxLayout bo=new BoxLayout(panel,BoxLayout.X_AXIS);
                                                               panel.setLayout(bo);
                                                               panel.add(Box.createRigidArea(new Dimension(58,0)));
                                                               panel.add(game_slang_button);
                                                               panel.add(Box.createRigidArea(new Dimension(30,0)));
                                                               panel.add(game_meaning_button);
                                                               panel.setAlignmentX(Component.CENTER_ALIGNMENT);
                                                               panel.setBackground(new Color(103,104,171));
                                                               select_game.add(panel/*,BorderLayout.CENTER*/);
                                                               select_game.setTitle("Game");
                                                               select_game.setDefaultCloseOperation(select_game.DISPOSE_ON_CLOSE);
                                                               select_game.resize(400, 200);
                                                               select_game.setResizable(false);
                                                               select_game.setLocationRelativeTo(null);
                                                               select_game.setVisible(true);
                                                           }
                                                       });
            panel2.add(Box.createRigidArea(new Dimension(0,50)));
            panel2.add(search_slang_button);
            panel2.add(Box.createRigidArea(new Dimension(10,35)));
            panel2.add(search_mean_button);
            panel2.add(Box.createRigidArea(new Dimension(10,30)));
            panel2.add(add_button);
            panel2.add(Box.createRigidArea(new Dimension(10,30)));
            panel2.add(edit_button);
            panel2.add(Box.createRigidArea(new Dimension(10,30)));
            panel2.add(delete_button);
            panel2.add(Box.createRigidArea(new Dimension(10,30)));
            panel2.add(reset_button);
            panel2.add(Box.createRigidArea(new Dimension(10,30)));
            panel2.add(history_button);
            panel2.add(Box.createRigidArea(new Dimension(10,30)));
            panel2.add(random_button);
            panel2.add(Box.createRigidArea(new Dimension(10,30)));
            panel2.add(game);
            JLabel a=new JLabel("<html>Name: Phạm Tiến Quân <br>ID: 19127526<br> HCMUS-K19-CLC</html>");
            a.setFont(new Font("Serif", Font.PLAIN,20));
            panel2.add(Box.createRigidArea(new Dimension(0,20)));
            panel2.add(a);
            panel2.setBackground(new Color(103,104,171));
            /*panel2.add(Box.createRigidArea(new Dimension(0,100)));*/
            add(panel2,BorderLayout.EAST);
            setTitle("Menu");
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setResizable(true);
            setLocationRelativeTo(null);
            setVisible(true);
        }
        catch (Exception ev){
            ev.printStackTrace();
        }
    }
    public static void main(String[] args) {
       Menu_UI a=new Menu_UI();
        a.menu_ui();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command=e.getActionCommand();
        try {
            Value = dict.readfile();
        }
        catch (Exception ev){
            ev.printStackTrace();
        }
        if(command=="search_mean"){
            String temp=Search_text.getText();
            mode.getDataVector().removeAllElements();
            boolean k=false;
            for(int i=0;i<Value.length;i++){
                if(Value[i][1].toLowerCase().contains(temp.toLowerCase())){
                    k=true;
                    mode.addRow(new Object[]{Value[i][0],Value[i][1].replace("[","").replace("]","")});
                }
            }
            if(k==false){
                JOptionPane.showMessageDialog(null, "Nothing!", "Nothing", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if(command=="search_slang"){
            String temp=Search_text.getText();
            mode.getDataVector().removeAllElements();
            boolean k=false;
            for(int i=0;i<Value.length;i++){
                if(Value[i][0].toLowerCase().equals(temp.toLowerCase())){
                    k=true;
                    Object []Temp=new Object[]{Value[i][0],Value[i][1].replace("[","").replace("]","")};
                    mode.addRow(Temp);
                    System.out.println(Value[i][0]);
                    try {
                        dict.Writefile_History(Temp);
                    }
                    catch (Exception ev){
                        ev.printStackTrace();
                    }
                }
            }
            if(k==false){
                JOptionPane.showMessageDialog(null, "Nothing!", "Nothing", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if(command=="history"){
            try {
                History_UI history = new History_UI();
                history.history_ui();
            }
            catch (Exception ev){
                JOptionPane.showMessageDialog(null, "Empty", "Empty", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if(command=="edit"){
            Edit_UI edit=new Edit_UI();
            edit.edit_ui();
            this.dispose();
        }

        if(command=="delete"){
            Delete_UI delete=new Delete_UI();
            delete.delete_ui();
            this.dispose();
        }

        if(command=="reset"){
            try {
                dict.Writefile_data("", "", 5);
                mode.setRowCount(0);
                Search_text.setText("");
                JOptionPane.showMessageDialog(null, "Success!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            catch (Exception ev){
                JOptionPane.showMessageDialog(null, "Error!", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        if(command=="random"){
            mode.getDataVector().removeAllElements();
            Random rand=new Random();
            String[] currentRoom=Value[rand.nextInt(Value.length)];
            System.out.println(currentRoom.length);
            currentRoom[1]=currentRoom[1].replace("[","").replace("]","");
            mode.addRow(currentRoom);
            try {
                dict.Writefile_History(currentRoom);
            }
            catch (Exception ev){
                ev.printStackTrace();
            }
        }

        if(command=="add"){
            Add_UI add=new Add_UI();
            add.add_ui();
            this.dispose();
        }

        if(command=="randomdefini"){
            select_game.dispose();
            this.dispose();
            random_meaning_ui ranmeaning=new random_meaning_ui();
            ranmeaning.Random_Meaning_UI();
        }

        if(command=="randomslang"){
            select_game.dispose();
            this.dispose();
            random_slang_ui ranslang=new random_slang_ui();
            ranslang.Random_Slang_UI();
        }
    }
}
