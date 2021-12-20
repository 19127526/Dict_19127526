import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Set;

/**
 * PACKAGE_NAME
 * Created by Admin
 * Date 12/19/2021 - 7:44 PM
 * Description: ...
 */
public class Add_UI  implements ActionListener {
    private JFrame confirm=new JFrame();
    private JFrame add_slang=new JFrame();
    private JLabel slang_text;
    private JLabel mean_text;
    private JTextField slang;
    private JTextField mean;
    private JButton Ok_button;
    private JButton Cancel_button;
    private JPanel panel1;
    private JPanel panel_slang;
    private JPanel panel_mean;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel text;
    private JButton Overwrite=new JButton("Overwire");
    private JButton duplicate=new JButton("Duplicate");
    private String [][]Value;
    private Dict dict=new Dict();

    public void confirm(){
        JLabel text=new JLabel("     Slang word is available in the dictionary!!!");
        text.setFont(new Font("Serif", Font.PLAIN, 15));
        confirm.add(text,BorderLayout.NORTH);
        confirm.getContentPane().setBackground(new Color(103,104,171));

        JPanel panel=new JPanel();
        BoxLayout bo=new BoxLayout(panel,BoxLayout.X_AXIS);
        panel.setLayout(bo);
        Overwrite.setActionCommand("overwrite");
        Overwrite.addActionListener(this);
        Overwrite.setBackground(new Color(171,136,103));
        duplicate.setActionCommand("duplicate");
        duplicate.addActionListener(this);
        duplicate.setBackground(new Color(171,136,103));

        duplicate.setMaximumSize(new Dimension(100,20));
        Overwrite.setMaximumSize(new Dimension(100,20));

        panel.add(Box.createRigidArea(new Dimension(30,0)));
        panel.add(Overwrite);
        panel.add(Box.createRigidArea(new Dimension(20,0)));
        panel.add(duplicate);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.setBackground(new Color(103,104,171));
        confirm.add(panel,BorderLayout.CENTER);

        confirm.setTitle("Confirm");
        confirm.setDefaultCloseOperation(confirm.DISPOSE_ON_CLOSE);
        confirm.resize(300, 100);
        confirm.setResizable(false);
        confirm.setLocationRelativeTo(null);
        confirm.setVisible(true);
    }
    public void add_ui(){
        BoxLayout boxx=new BoxLayout(add_slang.getContentPane(),BoxLayout.Y_AXIS);
        add_slang.setLayout(boxx);
        add_slang.getContentPane().setBackground(new Color(103,104,171));

        text=new JLabel("Add Slang Word");
        text.setFont(new Font("Serif", Font.PLAIN, 70));
        panel1=new JPanel();
        panel1.setBackground(new Color(103,104,171));
        panel1.add(text, BorderLayout.CENTER);
        add_slang.add(panel1,BorderLayout.NORTH);
        add_slang.add(Box.createRigidArea(new Dimension(0,30)));

        panel2=new JPanel();
        BoxLayout box=new BoxLayout(panel2,BoxLayout.Y_AXIS);
        panel2.setLayout(box);
        slang_text=new JLabel("Slang Word");
        slang=new JTextField("");
        mean_text=new JLabel("Mean");
        mean=new JTextField("");
        panel_mean=new JPanel();
        BoxLayout box_mean=new BoxLayout(panel_mean,BoxLayout.LINE_AXIS);
        panel_mean.setLayout(box_mean);
        panel_mean.setBackground(new Color(103,104,171));

        panel_slang=new JPanel();
        BoxLayout box_slang=new BoxLayout(panel_slang,BoxLayout.LINE_AXIS);
        panel_slang.setLayout(box_slang);
        panel_slang.setBackground(new Color(103,104,171));

        slang_text.setFont(new Font("Serif", Font.PLAIN, 20));
        slang.setMaximumSize(new Dimension(500,1000));
        slang.setFont(new Font("Serif", Font.PLAIN, 20));
        mean.setFont(new Font("Serif", Font.PLAIN, 20));
        mean.setMaximumSize(new Dimension(500,1000));
        mean_text.setFont(new Font("Serif", Font.PLAIN, 20));
        panel_mean.add(Box.createRigidArea(new Dimension(20,0)));
        panel_mean.add(mean_text);
        panel_mean.add(Box.createRigidArea(new Dimension(30,30)));
        panel_mean.add(mean);

        panel_slang.add(slang_text);
        panel_slang.add(Box.createRigidArea(new Dimension(0,30)));
        panel_slang.add(slang);

        panel2.add(panel_slang,BorderLayout.NORTH);
        panel2.add(panel_mean,BorderLayout.SOUTH);
        add_slang.add(panel2,BorderLayout.CENTER);

        add_slang.add(Box.createRigidArea(new Dimension(0,30)));
        panel3=new JPanel();
        BoxLayout box_3=new BoxLayout(panel3,BoxLayout.X_AXIS);
        panel3.setLayout(box_3);
        panel3.setBackground(new Color(103,104,171));

        Ok_button=new JButton("OK");
        Ok_button.setBackground(new Color(171,136,103));
        Ok_button.setActionCommand("ok");
        Ok_button.addActionListener(this);
        Ok_button.setFont(new Font("Serif", Font.PLAIN, 20));

        Cancel_button=new JButton("Cancel");
        Cancel_button.setActionCommand("cancel");
        Cancel_button.setBackground(new Color(171,136,103));
        Cancel_button.addActionListener(this);
        Cancel_button.setFont(new Font("Serif", Font.PLAIN, 20));

        Ok_button.setMaximumSize(new Dimension(100,100));
        Cancel_button.setMaximumSize(new Dimension(100,100));

        panel3.add(Ok_button);
        panel3.add((Box.createRigidArea(new Dimension(10,0))));
        panel3.add(Cancel_button);
        panel3.setAlignmentX(Component.CENTER_ALIGNMENT);
        add_slang.add(panel3,BorderLayout.SOUTH);
        add_slang.add(Box.createRigidArea(new Dimension(0,500)));

        add_slang.setTitle("Add Slang Words");
        add_slang.setDefaultCloseOperation(add_slang.DISPOSE_ON_CLOSE);
        add_slang.resize(600, 400);
        add_slang.setResizable(false);
        add_slang.setLocationRelativeTo(null);
        add_slang.setVisible(true);
    }
    public void set(){
        slang.setText("");
        mean.setText("");
    }

   /* public static void main(String arv[]){
        Add_UI a= new Add_UI(dict);
        try {
            a.add_ui();
        }
        catch (Exception ev){
            ev.printStackTrace();
        }
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {
        String command=e.getActionCommand();
        String temp=slang.getText();
        String temp1=mean.getText();
        if(command=="overwrite") {
            try {
                dict.Writefile_data(temp, temp1, 1);
                JOptionPane.showMessageDialog(null, "Success Overwrite!", "Success Overwrite", JOptionPane.INFORMATION_MESSAGE);
                add_slang.revalidate();
                confirm.dispose();
                set();
            }
            catch (IOException ev){
                JOptionPane.showMessageDialog(null, "Error!", "Error Add", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if(command=="duplicate"){
            try {
                dict.Writefile_data(temp, temp1, 2);
                JOptionPane.showMessageDialog(null, "Success Duplicate!", "Success Duplicate", JOptionPane.INFORMATION_MESSAGE);
                add_slang.revalidate();
                confirm.dispose();
                set();
            }
            catch (IOException ev){
                JOptionPane.showMessageDialog(null, "Error!", "Error Add", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if(command=="ok") {
            if (!temp.equals("") && !temp1.equals("")) {
                try {
                    Value = dict.readfile();
                    boolean k = false;
                    for (int i = 0; i < Value.length; i++) {
                        if (Value[i][0].toLowerCase().equals(temp.toLowerCase())) {
                            k = true;
                            confirm();
                            break;
                        }
                    }
                    if (k == false) {
                        dict.Writefile_data(temp, temp1, 0);
                        JOptionPane.showMessageDialog(null, "Success Add Slang Word!", "Success Add Slang Word", JOptionPane.INFORMATION_MESSAGE);
                        set();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error!", "Error Add", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        if(command=="cancel"){
            add_slang.dispose();
            Menu_UI menu_ui=new Menu_UI();
            menu_ui.menu_ui();
        }

    }
}
