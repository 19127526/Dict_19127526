import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * PACKAGE_NAME
 * Created by Admin
 * Date 12/22/2021 - 11:59 PM
 * Description: ...
 */
public class random_meaning_ui implements ActionListener {
    private JFrame frame_ran_meaning =new JFrame();
    private JButton button;
    private JButton back;
    private JLabel question;
    private JButton answer_1;
    private JButton answer_2;
    private JButton answer_3;
    private JButton answer_4;
    private JButton finish;
    private JButton next;
    private JPanel panel_head1;
    private JPanel panel_head;
    private JPanel panel_center;
    private JPanel panel_end;
    private JLabel dung;
    private JLabel sai;
    private String[][] Value;
    private Dict dict=new Dict();
    private String ans=new String();
    private int tr=0;
    private int fa=0;
    public void Random_Meaning_UI(){
        BoxLayout box=new BoxLayout(frame_ran_meaning.getContentPane(),BoxLayout.Y_AXIS);
        frame_ran_meaning.setLayout(box);
        JPanel dung_sai=new JPanel();

        dung_sai.setBackground(new Color(103,104,171));

        BoxLayout box_dungsai=new BoxLayout(dung_sai,BoxLayout.LINE_AXIS);
        dung_sai.setLayout(box_dungsai);
        dung=new JLabel("True: "+tr);
        dung.setFont(new Font("Serif", Font.PLAIN, 20));
        sai=new JLabel("False: "+fa);
        sai.setFont(new Font("Serif", Font.PLAIN, 20));
        dung_sai.add(dung);
        dung_sai.add(Box.createRigidArea(new Dimension(10,0)));
        dung_sai.add(sai);
        dung_sai.setFont(new Font("Serif", Font.PLAIN, 20));
        panel_head1=new JPanel();
        BoxLayout box_head1=new BoxLayout(panel_head1,BoxLayout.X_AXIS);
        panel_head1.setLayout(box_head1);
        back=new JButton("Back");
        back.addActionListener(this);
        back.setActionCommand("back");
        back.setFont(new Font("Serif", Font.PLAIN, 20));
        back.setBackground(new Color(171,136,103));

        panel_head1.add(back,BorderLayout.WEST);
        panel_head1.add(Box.createRigidArea(new Dimension(560,0)));
        panel_head1.add(dung_sai,BorderLayout.EAST);
        panel_head1.add(Box.createRigidArea(new Dimension(45,0)));
        panel_head1.setBackground(new Color(103,104,171));
        frame_ran_meaning.add(panel_head1/*,BorderLayout.NORTH*/);
        frame_ran_meaning.add(Box.createRigidArea(new Dimension(0,10)));

        panel_head=new JPanel();

        panel_head.setBackground(new Color(103,104,171));

        question=new JLabel("text");
        question.setFont(new Font("Serif", Font.PLAIN, 35));
        panel_head.add(question,BorderLayout.CENTER);
        frame_ran_meaning.add(panel_head);
        frame_ran_meaning.add(Box.createRigidArea(new Dimension(0,30)));


        panel_center=new JPanel(new GridLayout(2, 2, 30, 35));
        panel_center.setBackground(new Color(103,104,171));
        answer_1=new JButton("ans1");
        answer_1.setActionCommand("answer1");
        answer_1.addActionListener(this);
        answer_2=new JButton("ans2");
        answer_2.setActionCommand("answer2");
        answer_2.addActionListener(this);
        answer_3=new JButton("ans3");
        answer_3.setActionCommand("answer3");
        answer_3.addActionListener(this);
        answer_4=new JButton("ans4");
        answer_4.setActionCommand("answer4");
        answer_4.addActionListener(this);
        answer_1.setBackground(new Color(171,136,103));
        answer_2.setBackground(new Color(171,136,103));
        answer_3.setBackground(new Color(171,136,103));
        answer_4.setBackground(new Color(171,136,103));

        panel_center.add(answer_1);
        panel_center.add(answer_2);
        panel_center.add(answer_3);
        panel_center.add(answer_4);
        frame_ran_meaning.add(panel_center,BorderLayout.CENTER);
        frame_ran_meaning.add(Box.createRigidArea(new Dimension(0,30)));

        panel_end=new JPanel();
        BoxLayout box_end=new BoxLayout(panel_end,BoxLayout.LINE_AXIS);

        panel_end.setBackground(new Color(103,104,171));

        panel_end.setLayout(box_end);
        finish=new JButton("Finish");
        finish.setActionCommand("finish");
        finish.addActionListener(this);
        next=new JButton("Next");
        next.setActionCommand("next");
        next.addActionListener(this);
        finish.setBackground(new Color(171,136,103));
        next.setBackground(new Color(171,136,103));
        finish.setFont(new Font("Serif", Font.PLAIN, 30));
        next.setFont(new Font("Serif", Font.PLAIN, 20));
        next.setFont(new Font("Aria",Font.BOLD,20));
        finish.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel_end.add(Box.createRigidArea(new Dimension(350,0)));
        panel_end.add(finish);
        panel_end.add(Box.createRigidArea(new Dimension(250,0)));
        panel_end.add(next);
        frame_ran_meaning.add(panel_end,BorderLayout.SOUTH);

        try {
            setrandom();
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame_ran_meaning.setTitle("Add Slang Words");
        frame_ran_meaning.getContentPane().setBackground(new Color(103,104,171));
        frame_ran_meaning.setDefaultCloseOperation(frame_ran_meaning.DISPOSE_ON_CLOSE);
        frame_ran_meaning.resize(800, 500);
        frame_ran_meaning.setResizable(false);
        frame_ran_meaning.setLocationRelativeTo(null);
        frame_ran_meaning.setVisible(true);
    }
    public void setrandom() throws IOException {
        Value=dict.readfile();
        ArrayList<String> random=new ArrayList<>();
        Random rand=new Random();
        String[] currentRoom_ans=Value[rand.nextInt(Value.length)];
        random.add(currentRoom_ans[0]);
        String[] currentRoom1=Value[rand.nextInt(Value.length)];
        random.add(currentRoom1[0]);
        String[] currentRoom2=Value[rand.nextInt(Value.length)];
        random.add(currentRoom2[0]);
        String[] currentRoom3=Value[rand.nextInt(Value.length)];
        random.add(currentRoom3[0]);

        String temp=currentRoom_ans[1].replace("[","").replace("]","");
        System.out.println(temp);
        String[]tmp=temp.split("\\|");
        Collections.shuffle(List.of(tmp));
        System.out.println(tmp[0]);
        question.setText(tmp[0]);


        ans=currentRoom_ans[0];
        Collections.shuffle(random);
        answer_1.setText(random.get(0).replace("[","").replace("]",""));
        answer_2.setText(random.get(1).replace("[","").replace("]",""));
        answer_3.setText(random.get(2).replace("[","").replace("]",""));
        answer_4.setText(random.get(3).replace("[","").replace("]",""));
        answer_1.setFont(new Font("Serif", Font.PLAIN, 20));
        answer_2.setFont(new Font("Serif", Font.PLAIN, 20));
        answer_3.setFont(new Font("Serif", Font.PLAIN, 20));
        answer_4.setFont(new Font("Serif", Font.PLAIN, 20));
        next.setEnabled(false);

    }

    public static void main(String[] args) {
        random_meaning_ui a= new random_meaning_ui();
        a.Random_Meaning_UI();
    }
    public void set(){
        String ques=question.getText();
        answer_1.setEnabled(false);
        answer_2.setEnabled(false);
        answer_3.setEnabled(false);
        answer_4.setEnabled(false);
        JButton[]Ans={answer_1,answer_2,answer_3,answer_4};
        boolean flag=false;
        int temp=-1;
        for(int i=0;i<Ans.length;i++){
            if(Ans[i].getText().equals(ans.replace("[","").replace("]",""))){
                Ans[i].setBackground(Color.green);
                temp=i;
            }
            else{
                Ans[i].setBackground(Color.red);
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command=e.getActionCommand();
        if(command=="back"){
            frame_ran_meaning.dispose();
        }
        if(command=="answer1"){
            set();
            if(answer_1.getText().equals(ans.replace("[","").replace("]",""))){
                JOptionPane.showMessageDialog(null, "True!", "True", JOptionPane.INFORMATION_MESSAGE);
                tr++;
            }
            else{
                JOptionPane.showMessageDialog(null, "False!", "False", JOptionPane.INFORMATION_MESSAGE);
                fa++;
            }
            next.setEnabled(true);
        }
        if(command=="answer2"){
            set();
            if(answer_2.getText().equals(ans.replace("[","").replace("]",""))){
                JOptionPane.showMessageDialog(null, "True!", "True", JOptionPane.INFORMATION_MESSAGE);
                tr++;
            }
            else{
                JOptionPane.showMessageDialog(null, "False!", "False", JOptionPane.INFORMATION_MESSAGE);
                fa++;
            }
            next.setEnabled(true);
        }
        if(command=="answer3"){
            set();
            if(answer_3.getText().equals(ans.replace("[","").replace("]",""))){
                JOptionPane.showMessageDialog(null, "True!", "True", JOptionPane.INFORMATION_MESSAGE);
                tr++;
            }
            else{
                JOptionPane.showMessageDialog(null, "False!", "False", JOptionPane.INFORMATION_MESSAGE);
                fa++;
            }
            next.setEnabled(true);
        }
        if(command=="answer4") {
            set();
            if(answer_4.getText().equals(ans.replace("[","").replace("]",""))){
                JOptionPane.showMessageDialog(null, "True!", "True", JOptionPane.INFORMATION_MESSAGE);
                tr++;
            }
            else{
                JOptionPane.showMessageDialog(null, "False!", "False", JOptionPane.INFORMATION_MESSAGE);
                fa++;
            }
            next.setEnabled(true);
        }
        if(command=="finish"){
            JOptionPane.showMessageDialog(null, dung.getText()+"\n"+sai.getText(),"Finish", JOptionPane.INFORMATION_MESSAGE);
            frame_ran_meaning.dispose();
        }
        if(command=="next"){
            /*            frame_ran_slang.dispose();*/
            try {
                setrandom();
                answer_1.setEnabled(true);
                answer_2.setEnabled(true);
                answer_3.setEnabled(true);
                answer_4.setEnabled(true);
                answer_1.setBackground(new Color(171,136,103));
                answer_2.setBackground(new Color(171,136,103));
                answer_3.setBackground(new Color(171,136,103));
                answer_4.setBackground(new Color(171,136,103));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        dung.setText("True: "+tr);
        sai.setText("False: "+fa);
    }
}
