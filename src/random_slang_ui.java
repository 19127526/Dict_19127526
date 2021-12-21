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
 * Date 12/20/2021 - 6:27 PM
 * Description: ...
 */
public class random_slang_ui implements ActionListener {
    private JFrame frame_ran_slang=new JFrame();
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
    public void Random_Slang_UI(){
        BoxLayout box=new BoxLayout(frame_ran_slang.getContentPane(),BoxLayout.Y_AXIS);
        frame_ran_slang.setLayout(box);
        JPanel dung_sai=new JPanel();

        dung_sai.setBackground(new Color(103,104,171));

        BoxLayout box_dungsai=new BoxLayout(dung_sai,BoxLayout.LINE_AXIS);
        dung_sai.setLayout(box_dungsai);
        dung=new JLabel("True: ");
        dung.setFont(new Font("Serif", Font.PLAIN, 20));
        sai=new JLabel("False: ");
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
        frame_ran_slang.add(panel_head1/*,BorderLayout.NORTH*/);
        frame_ran_slang.add(Box.createRigidArea(new Dimension(0,10)));

        panel_head=new JPanel();

        panel_head.setBackground(new Color(103,104,171));

        question=new JLabel("text");
        question.setFont(new Font("Serif", Font.PLAIN, 70));
        panel_head.add(question,BorderLayout.CENTER);
        frame_ran_slang.add(panel_head);
        frame_ran_slang.add(Box.createRigidArea(new Dimension(0,30)));


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
        frame_ran_slang.add(panel_center,BorderLayout.CENTER);
        frame_ran_slang.add(Box.createRigidArea(new Dimension(0,30)));

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
        finish.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel_end.add(Box.createRigidArea(new Dimension(350,0)));
        panel_end.add(finish);
        panel_end.add(Box.createRigidArea(new Dimension(250,0)));
        panel_end.add(next);
        frame_ran_slang.add(panel_end,BorderLayout.SOUTH);

        try {
            setrandom();
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame_ran_slang.setTitle("Add Slang Words");
        frame_ran_slang.getContentPane().setBackground(new Color(103,104,171));
        frame_ran_slang.setDefaultCloseOperation(frame_ran_slang.DISPOSE_ON_CLOSE);
        frame_ran_slang.resize(800, 500);
        frame_ran_slang.setResizable(false);
        frame_ran_slang.setLocationRelativeTo(null);
        frame_ran_slang.setVisible(true);
    }
    public void setrandom() throws IOException {
        Value=dict.readfile();
        ArrayList<String>random=new ArrayList<>();
        Random rand=new Random();
        String[] currentRoom_ans=Value[rand.nextInt(Value.length)];
        random.add(currentRoom_ans[1]);
        String[] currentRoom1=Value[rand.nextInt(Value.length)];
        random.add(currentRoom1[1]);
        String[] currentRoom2=Value[rand.nextInt(Value.length)];
        random.add(currentRoom2[1]);
        String[] currentRoom3=Value[rand.nextInt(Value.length)];
        random.add(currentRoom3[1]);
        question.setText(currentRoom_ans[0]);
        ans=currentRoom_ans[1];
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
        random_slang_ui a= new random_slang_ui();
        a.Random_Slang_UI();
    }
    public void sete(){
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
        /*String ques=question.getText();
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
        }*/
        if(command=="back"){
            frame_ran_slang.dispose();
        }
        if(command=="answer1"){
            sete();
            next.setEnabled(true);
        }
        if(command=="answer2"){
            sete();
            next.setEnabled(true);
        }
        if(command=="answer3"){
            sete();
            next.setEnabled(true);
        }
        if(command=="answer4") {
            sete();
            next.setEnabled(true);
        }
        if(command=="finish"){

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
    }
}
