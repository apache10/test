import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by gaurav on 21-08-2016.
 */
public class saveManager implements ActionListener {

    JFrame tempFrame;
    JTextField name;
    JTextField exp;
    JFrame frame;

public saveManager(JFrame frame , JTextField empName,JTextField empExp){
 tempFrame = frame;
    name= empName;
    exp= empExp;

}
    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println(name.getText());
        System.out.println(exp.getText());

        FileWriter out = null;
        try{
            out = new FileWriter("Manager.txt",true);
            out.write(name.getText()+","+exp.getText()+"    "+'\n');
            out.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }



        tempFrame.setVisible(false);
        tempFrame.dispose();
        frame = new JFrame("saved data");

        frame.setVisible(true);
        frame.setSize(600, 500);
        JPanel panel = new JPanel();
        frame.add(panel);


        JLabel label = new JLabel("profile has been added successfully");
        panel.add(label);

        JButton button = new JButton("BACK");
        panel.add(button);
        button.addActionListener(new AddManager(frame));


    }
}

