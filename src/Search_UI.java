import javax.swing.*;

/**
 * PACKAGE_NAME
 * Created by Admin
 * Date 12/18/2021 - 4:00 PM
 * Description: ...
 */
public class Search_UI extends JFrame {
    private JTextField enterSlangTextField;
    private JButton searchButton;
    private JButton button1;
    private JButton button2;
    private JTable table1;
    private JPanel panel1;
    private JScrollPane scrollPane;
    Search_UI(){
        try {
            Dict value = new Dict();
            String [][]Value=value.readfile();
            for(int k=0;k<Value.length;k++){
                for(int j=0;j<Value[k].length;j++){
                    System.out.println(Value[k][j]);
                }
            }
            String[] columnname = new String[]{"Slang", "World"};
            table1=new JTable(Value,columnname);
            scrollPane= new JScrollPane(table1);
        }
        catch (Exception ev){
            ev.printStackTrace();
        }

    }
    public void createUIComponents() {
        this.setTitle("Menu");
        this.setSize(600, 350);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new Search_UI().panel1);
        this.setVisible(true);
    }
    public static void main(String[]args){
        Search_UI a= new Search_UI();
        a.createUIComponents();
    }
}
