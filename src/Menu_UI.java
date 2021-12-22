import org.w3c.dom.Text;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private TextField Search_text;
    private Button search_mean_button;
    private Button search_slang_button;
    private Button edit_button;
    private Button delete_button;
    private Button random_button;
    private Button reset_button;
    private Button history_button;
    private Button add_button;
    private Button game_random_slang_button;
    private Button game_defini_button;
    private String[][] Value;
    private JTable table1;
    private JScrollPane scrollPane;
    private Dict dict;
    String[] columnname = new String[]{"Slang", "Meaning"};
    public void menu_ui() {
        try {
            this.getContentPane().setBackground(new Color(103,104,171));
            dict=new Dict();
            dict.Copy_File();
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel3=new JPanel();
            panel3.setBackground(new Color(103,104,171));
            JLabel text=new JLabel("Dictionary");
            text.setFont(new Font("Serif", Font.PLAIN, 70));
            panel3.add(text,BorderLayout.CENTER);
            add(panel3,BorderLayout.NORTH);;


            panel1 = new JPanel();
            Search_text = new TextField("Enter");
            Search_text.setBackground(new Color(103,104,171));
            mode= new DefaultTableModel(null,columnname/*Value,columnname*/);
            table1 = new JTable(mode);
            table1.setBackground(new Color(103,104,171));
            table1.getTableHeader().setFont(new Font("Serif", Font.PLAIN,20));
            table1.setFont(new Font("Serif", Font.PLAIN,20));
            table1.getTableHeader().setBackground(new Color(103,104,171));
            table1.setRowHeight(30);
            table1.setDefaultEditor(Object.class, null);
            scrollPane = new JScrollPane(table1);
            Search_text.setMaximumSize(new Dimension(table1.getMaximumSize().width, 1000));
            Search_text.setFont(new Font("Serif", Font.PLAIN, 20));
            BoxLayout box = new BoxLayout(panel1, BoxLayout.Y_AXIS);
            panel1.setLayout(box);
            panel1.add(Search_text);
            panel1.add(scrollPane);
            add(panel1,BorderLayout.CENTER);

            panel2=new JPanel();
            panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
            search_slang_button=new Button("Search with Slang");
            search_slang_button.setFont(new Font("Serif", Font.PLAIN,20));
            search_mean_button = new Button("Search with Definition");
            search_mean_button.setFont(new Font("Serif", Font.PLAIN,20));
            edit_button=new Button("Edit");
            edit_button.setFont(new Font("Serif", Font.PLAIN,20));
            delete_button=new Button("Delete");
            delete_button.setFont(new Font("Serif", Font.PLAIN,20));
            random_button=new Button("Random");
            random_button.setFont(new Font("Serif", Font.PLAIN,20));
            reset_button=new Button("Reset");
            reset_button.setFont(new Font("Serif", Font.PLAIN,20));
            history_button=new Button("History");
            history_button.setFont(new Font("Serif", Font.PLAIN,20));
            add_button=new Button("Add");
            add_button.setFont(new Font("Serif", Font.PLAIN,20));
            game_random_slang_button=new Button("Random Slang World");
            game_random_slang_button.setFont(new Font("Serif", Font.PLAIN,20));
            game_defini_button=new Button(" Random Definition");
            game_defini_button.setFont(new Font("Serif", Font.PLAIN,20));


            search_slang_button.setActionCommand("search_slang");
            search_slang_button.addActionListener(this);
            search_slang_button.setBackground(new Color(171,136,103));

            search_mean_button.setActionCommand("search_mean");
            search_mean_button.addActionListener(this);
            search_mean_button.setBackground(new Color(171,136,103));

            edit_button.setActionCommand("edit");
            edit_button.addActionListener(this);
            edit_button.setBackground(new Color(171,136,103));

            delete_button.setActionCommand("delete");
            delete_button.addActionListener(this);
            delete_button.setBackground(new Color(171,136,103));

            reset_button.setActionCommand("reset");
            reset_button.addActionListener(this);
            reset_button.setBackground(new Color(171,136,103));

            random_button.setActionCommand("random");
            random_button.addActionListener(this);
            random_button.setBackground(new Color(171,136,103));

            history_button.setActionCommand("history");
            history_button.addActionListener(this);
            history_button.setBackground(new Color(171,136,103));

            add_button.setActionCommand("add");
            add_button.addActionListener(this);
            add_button.setBackground(new Color(171,136,103));

            game_defini_button.setActionCommand("randomdefini");
            game_defini_button.addActionListener(this);
            game_defini_button.setBackground(new Color(171,136,103));

            game_random_slang_button.setActionCommand("randomslang");
            game_random_slang_button.addActionListener(this);
            game_random_slang_button.setBackground(new Color(171,136,103));
            panel2.add(search_slang_button);
            panel2.add(Box.createRigidArea(new Dimension(10,35)));
            panel2.add(search_mean_button);
            panel2.add(Box.createRigidArea(new Dimension(10,30)));
            panel2.add(edit_button);
            panel2.add(Box.createRigidArea(new Dimension(10,30)));
            panel2.add(delete_button);
            panel2.add(Box.createRigidArea(new Dimension(10,30)));
            panel2.add(random_button);
            panel2.add(Box.createRigidArea(new Dimension(10,30)));
            panel2.add(reset_button);
            panel2.add(Box.createRigidArea(new Dimension(10,30)));
            panel2.add(history_button);
            panel2.add(Box.createRigidArea(new Dimension(10,30)));
            panel2.add(add_button);
            panel2.add(Box.createRigidArea(new Dimension(10,30)));
            panel2.add(game_random_slang_button);
            panel2.add(Box.createRigidArea(new Dimension(10,30)));
            panel2.add(game_defini_button);
            panel2.setBackground(new Color(103,104,171));
            /*panel2.add(Box.createRigidArea(new Dimension(0,100)));*/
            add(panel2,BorderLayout.EAST);

            setTitle("Menu");
            resize(1000, 600);
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
                    mode.addRow(new Object[]{Value[i][0],Value[i][1]});
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
                    Object []Temp=new Object[]{Value[i][0],Value[i][1]};
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
            random_meaning_ui ranmeaning=new random_meaning_ui();
            ranmeaning.Random_Meaning_UI();
        }

        if(command=="randomslang"){
            /*this.dispose();*/
            random_slang_ui ranslang=new random_slang_ui();
            ranslang.Random_Slang_UI();
        }
    }
}
