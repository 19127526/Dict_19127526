import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

/**
 * PACKAGE_NAME
 * Created by Admin
 * Date 12/31/2021 - 10:35 PM
 * Description: ...
 */
public class Random_UI implements ActionListener {
    private JFrame confirm=new JFrame();
    private JFrame random_ui =new JFrame();
    private JLabel slang_text;
    private JLabel mean_text;
    private JTextField slang;
    private JTextField mean;
    private JButton refresh;
    private JButton cancel;
    private JPanel panel1;
    private JPanel panel_slang;
    private JPanel panel_mean;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel text;
    private String [][]Value;
    private Dict dict=new Dict();
    public void random_ui(){
        BoxLayout boxx=new BoxLayout(random_ui.getContentPane(),BoxLayout.Y_AXIS);
        random_ui.setLayout(boxx);
        random_ui.getContentPane().setBackground(new Color(103,104,171));

        text=new JLabel("Random Slang Word");
        text.setFont(new Font("Serif", Font.PLAIN, 70));
        panel1=new JPanel();
        panel1.setBackground(new Color(103,104,171));
        panel1.add(text, BorderLayout.CENTER);
        random_ui.add(panel1,BorderLayout.NORTH);
        random_ui.add(Box.createRigidArea(new Dimension(0,30)));

        panel2=new JPanel();
        BoxLayout box=new BoxLayout(panel2,BoxLayout.Y_AXIS);
        panel2.setLayout(box);
        panel2.setBackground(new Color(103,104,171));

        slang_text=new JLabel("Slang Word ");
        slang=new JTextField("");
        slang.setBackground(new Color(103,104,171));
        slang.setBorder(new LineBorder(Color.black,2));
        slang.disable();

        mean_text=new JLabel("Mean ");
        mean=new JTextField("");
        mean.setBackground(new Color(103,104,171));
        mean.setBorder(new LineBorder(Color.black,2));
        mean.disable();

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

        panel2.add(panel_slang);
        panel2.add(Box.createRigidArea(new Dimension(0,15)));
        panel2.add(panel_mean);


        random_ui.add(panel2,BorderLayout.CENTER);
        random_ui.add(Box.createRigidArea(new Dimension(0,30)));

        panel3=new JPanel();
        BoxLayout box_3=new BoxLayout(panel3,BoxLayout.X_AXIS);
        panel3.setLayout(box_3);
        panel3.setBackground(new Color(103,104,171));

        refresh =new JButton("Refresh");
        refresh.setBackground(new Color(171,136,103));
        refresh.setActionCommand("refresh");
        refresh.addActionListener(this);
        refresh.setFont(new Font("Serif", Font.PLAIN, 20));
        refresh.setBorder(new LineBorder(new Color(255, 221, 189),2));

        cancel =new JButton("Cancel");
        cancel.setActionCommand("cancel");
        cancel.setBackground(new Color(171,136,103));
        cancel.addActionListener(this);
        cancel.setFont(new Font("Serif", Font.PLAIN, 20));
        cancel.setBorder(new LineBorder(new Color(255, 221, 189),2));

        refresh.setMaximumSize(new Dimension(100,100));
        cancel.setMaximumSize(new Dimension(100,100));

        panel3.add((Box.createRigidArea(new Dimension(30,0))));
        panel3.add(refresh);
        panel3.add((Box.createRigidArea(new Dimension(10,0))));
        panel3.add(cancel);
        panel3.setAlignmentX(Component.CENTER_ALIGNMENT);
        random_ui.add(panel3,BorderLayout.SOUTH);
        random_ui.add(Box.createRigidArea(new Dimension(0,500)));

        random_ui.setTitle("Random Slang Words");
        random_ui.setDefaultCloseOperation(random_ui.DISPOSE_ON_CLOSE);
        random_ui.resize(620, 400);
        random_ui.setResizable(false);
        random_ui.setLocationRelativeTo(null);
        random_ui.setVisible(true);
    }
    public static void main(String arv[]){
        Random_UI a= new Random_UI();
        try {
            a.random_ui();
        }
        catch (Exception ev){
            ev.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command=e.getActionCommand();
        String temp=slang.getText();
        String temp1=mean.getText();
        try {
            Value = dict.readfile();
        }
        catch (Exception ev){
            ev.printStackTrace();
        }
        if(command=="refresh") {
            Random rand=new Random();
            String[] currentRoom=Value[rand.nextInt(Value.length)];
            currentRoom[1]=currentRoom[1].replace("[","").replace("]","");
            slang.setText(" "+currentRoom[0]);
            mean.setText(" "+currentRoom[1]);
        }
        if(command=="cancel"){
            random_ui.dispose();
            Menu_UI menu_ui=new Menu_UI();
            menu_ui.menu_ui();
        }

    }
}
