import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * PACKAGE_NAME
 * Created by Admin
 * Date 12/15/2021 - 9:44 PM
 * Description: ...
 */
public class Menu_UI extends JFrame {
    private Button search_button;
    private JPanel panel1;
    private JPanel panel2;
    private TextField Search_text;
    private Button edit_button;
    private Button delete_button;
    private JTable table1;
    private JScrollPane scrollPane;
    String[] columnname = new String[]{"Slang", "World"};
    public void menu_ui() {
        try {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            /*setLayout(new GridLayout(7, 2, 15, 15));*/
            panel1 = new JPanel();
            Search_text = new TextField("Enter");
            Dict value = new Dict();
            String[][] Value = value.readfile();
            table1 = new JTable(Value, columnname);
            scrollPane = new JScrollPane(table1);
            Search_text.setMaximumSize(new Dimension(table1.getMaximumSize().width, 20));
            scrollPane.setMaximumSize(new Dimension(table1.getMaximumSize().width,200));
            BoxLayout box = new BoxLayout(panel1, BoxLayout.Y_AXIS);
            panel1.setLayout(box);
            panel1.add(Search_text);
            panel1.add(scrollPane);
            add(panel1, BorderLayout.WEST);


            panel2=new JPanel();
            SpringLayout layout = new SpringLayout();
            panel2.setLayout(layout);
            search_button = new Button("Search");
            panel2.add(search_button);

            add(panel2);

            setTitle("Menu");
            resize(700, 700);
            setResizable(false);
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
}
