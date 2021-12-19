import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * PACKAGE_NAME
 * Created by Admin
 * Date 12/20/2021 - 1:30 AM
 * Description: ...
 */
public class Edit_UI implements ActionListener {
    private JFrame edit_slang=new JFrame();
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
    private JButton Check=new JButton("Check");
    private String [][]Value;
    private Dict dict=new Dict();
    public void edit_ui(){
        BoxLayout boxx=new BoxLayout(edit_slang.getContentPane(),BoxLayout.Y_AXIS);
        edit_slang.setLayout(boxx);
        text=new JLabel("Edit Slang Word");
        text.setFont(new Font("Serif", Font.PLAIN, 70));
        panel1=new JPanel();
        panel1.add(text, BorderLayout.CENTER);
        edit_slang.add(panel1,BorderLayout.NORTH);
        edit_slang.add(Box.createRigidArea(new Dimension(0,30)));


        panel2=new JPanel();
        BoxLayout box=new BoxLayout(panel2,BoxLayout.Y_AXIS);
        panel2.setLayout(box);
        Check.setActionCommand("check");
        Check.addActionListener(this);
        slang_text=new JLabel("Slang Word");
        slang=new JTextField("");
        mean_text=new JLabel("Mean");
        mean=new JTextField("");
        panel_mean=new JPanel();
        BoxLayout box_mean=new BoxLayout(panel_mean,BoxLayout.LINE_AXIS);
        panel_mean.setLayout(box_mean);
        panel_slang=new JPanel();
        BoxLayout box_slang=new BoxLayout(panel_slang,BoxLayout.LINE_AXIS);
        panel_slang.setLayout(box_slang);


        slang_text.setFont(new Font("Serif", Font.PLAIN, 20));
        slang.setMaximumSize(new Dimension(500,1000));
        slang.setFont(new Font("Serif", Font.PLAIN, 20));
        mean.setFont(new Font("Serif", Font.PLAIN, 20));
        mean.setMaximumSize(new Dimension(500,1000));
        mean_text.setFont(new Font("Serif", Font.PLAIN, 20));
        mean.disable();
        panel_mean.add(Box.createRigidArea(new Dimension(20,0)));
        panel_mean.add(mean_text);
        panel_mean.add(Box.createRigidArea(new Dimension(30,30)));
        panel_mean.add(mean);
        panel_mean.add(Box.createRigidArea(Check.getMaximumSize()));

        panel_slang.add(slang_text);
        panel_slang.add(Box.createRigidArea(new Dimension(0,30)));
        panel_slang.add(slang);
        panel_slang.add(Check);

        panel2.add(panel_slang,BorderLayout.NORTH);
        panel2.add(panel_mean,BorderLayout.SOUTH);
        edit_slang.add(panel2,BorderLayout.CENTER);

        edit_slang.add(Box.createRigidArea(new Dimension(0,30)));
        panel3=new JPanel();
        BoxLayout box_3=new BoxLayout(panel3,BoxLayout.X_AXIS);
        panel3.setLayout(box_3);
        Ok_button=new JButton("OK");
        Ok_button.setActionCommand("ok");
        Ok_button.addActionListener(this);
        Cancel_button=new JButton("Cancel");
        Cancel_button.setActionCommand("cancel");
        Cancel_button.addActionListener(this);
        Ok_button.setMaximumSize(new Dimension(100,100));
        Cancel_button.setMaximumSize(new Dimension(100,100));
        panel3.add(Ok_button);
        panel3.add((Box.createRigidArea(new Dimension(10,0))));
        panel3.add(Cancel_button);
        panel3.setAlignmentX(Component.CENTER_ALIGNMENT);
        edit_slang.add(panel3,BorderLayout.SOUTH);
        edit_slang.add(Box.createRigidArea(new Dimension(0,500)));

        edit_slang.setTitle("Add Slang Words");
        edit_slang.setDefaultCloseOperation(edit_slang.DISPOSE_ON_CLOSE);
        edit_slang.resize(600, 400);
        edit_slang.setResizable(false);
        edit_slang.setLocationRelativeTo(null);
        edit_slang.setVisible(true);
    }
    public void set_empty(){
        slang.setText("");
        mean.setText("");
        mean.disable();
    }
    public void set(){
        mean.setText("");
    }
    public static void main(String[] args) {
        Edit_UI a=new Edit_UI();
        a.edit_ui();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command=e.getActionCommand();
        if(command=="check"){
            String temp=slang.getText();
            if (!temp.equals("")) {
                try {
                    Value = dict.readfile();
                    boolean k = false;
                    for (int i = 0; i < Value.length; i++) {
                        if (Value[i][0].toLowerCase().equals(temp.toLowerCase())) {
                            k = true;
                            mean.enable();
                            mean.setText(Value[i][1]);
                            break;
                        }
                    }
                    if (k == false) {
                        JOptionPane.showMessageDialog(null, "Slang Word does not exist!", "Empty", JOptionPane.INFORMATION_MESSAGE);
                        set();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error!", "Error Add", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        if(command=="ok"){

        }
        if(command=="cancel"){
            edit_slang.dispose();
        }
    }
}