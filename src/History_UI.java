import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * PACKAGE_NAME
 * Created by Admin
 * Date 12/19/2021 - 12:44 AM
 * Description: ...
 */
public class History_UI extends JFrame implements ActionListener {
    private JPanel panel1;
    private JTable table1;
    private DefaultTableModel mode;
    private JButton back;
    private Dict dict=new Dict();
    String[]Column_name={"Date","Slang","Mean"};
    public void history_ui() throws IOException {
        JPanel panel=new JPanel();
        JLabel label=new JLabel("History");
        panel.setBackground(new Color(103,104,171));
        label.setFont(new Font("Serif", Font.PLAIN, 70));

        panel.add(label,BorderLayout.CENTER);
        add(panel,BorderLayout.NORTH);


        String[][]value=dict.Readfile_History();
        panel1=new JPanel();
        mode=new DefaultTableModel(value,Column_name);
        BoxLayout box=new BoxLayout(panel1,BoxLayout.Y_AXIS);
        panel1.setLayout(box);
        table1=new JTable(mode);
        table1.getTableHeader().setFont(new Font("Serif", Font.PLAIN,20));
        table1.setFont(new Font("Serif", Font.PLAIN,20));
        table1.setRowHeight(30);
        table1.getTableHeader().setBackground(new Color(103,104,171));
        table1.setDefaultEditor(Object.class, null);
        table1.setBackground(new Color(103,104,171));
        JScrollPane scrollPane = new JScrollPane(table1);

        back=new JButton("Back");
        back.setFont(new Font("Serif", Font.PLAIN,20));
        back.setMaximumSize(new Dimension(100,100));
        back.setAlignmentX(CENTER_ALIGNMENT);
        back.setActionCommand("Back");
        back.setBackground(new Color(103,104,171));
        back.addActionListener(this);

        panel1.add(scrollPane,BorderLayout.CENTER);
        panel1.add(back);
        panel1.add(Box.createRigidArea(new Dimension(0,30)));
        add(panel1,BorderLayout.CENTER);
        setTitle("History");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        resize(600, 400);
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String arv[]){
        History_UI a= new History_UI();
        try {
            a.history_ui();
        }
        catch (Exception ev){
            ev.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command=e.getActionCommand();
        if(command=="Back"){
            super.dispose();
        }
    }
}
