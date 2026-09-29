package vblectures;
import java.awt.*;
import javax.swing.*;
public class VBLectures {
 public static void main(String[] args) {
 JFrame frame = new JFrame();
 frame.setSize(new Dimension(300, 300));
 JPanel panel=new JPanel();
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 JButton button1 = new JButton("Ok");
 JLabel lb1 = new JLabel("Label-1");
 JLabel lb2 = new JLabel("Label-2");
 panel.add(button1);
 panel.add(lb2);
 frame.add(lb1);
 frame.add(panel);
 frame.setVisible(true);