/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 *
 * @author Elisa Bothy
 */
public class MyFrame extends JFrame implements ActionListener{

    private JMenuBar jmb;
    private JMenuItem red, green, blue, quit;
    private JMenu color, file;
    private JPanel jp;

    private static final long serialVersionUID = 1L;

    public MyFrame(String title) throws HeadlessException {
        super(title);
        jmb = new JMenuBar();
        file = new JMenu("File");
        color = new JMenu("Color");
        blue = new JMenuItem("Blue");
        green = new JMenuItem("Green");
        red = new JMenuItem("Red");
        quit = new JMenuItem("Quit");
        jp = new JPanel();
        

        initGui();
        initEvents();

        this.pack();
        //centrer fenêtre
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    private void initGui() {
        file.setMnemonic(KeyEvent.VK_F);
        red.setMnemonic(KeyEvent.VK_R);
        green.setMnemonic(KeyEvent.VK_G);
        blue.setMnemonic(KeyEvent.VK_B);
        color.setMnemonic(KeyEvent.VK_C);
        quit.setMnemonic(KeyEvent.VK_Q);
        red.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_R, 
                        InputEvent.CTRL_DOWN_MASK
                )
        );
        green.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_G, 
                        InputEvent.CTRL_DOWN_MASK
                )
        );
        blue.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_B, 
                        InputEvent.CTRL_DOWN_MASK
                )
        );
        quit.setAccelerator(
                KeyStroke.getKeyStroke(
                        KeyEvent.VK_Q, 
                        InputEvent.CTRL_DOWN_MASK
                )
        );
        file.add(quit);
        file.add(quit);
        color.add(blue);
        color.add(green);
        color.add(red);
        jmb.add(file);
        jmb.add(color);
        
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        jp.setPreferredSize(new Dimension(200, 400));
        jp.setOpaque(true);
        this.add(jp);
        this.setJMenuBar(jmb);
    }

    private void initEvents() {
        red.addActionListener(this);
        green.addActionListener(this);
        blue.addActionListener(this);
        quit.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        switch (e.getActionCommand()) {
            case "Red" -> jp.setBackground(Color.RED);
            case "Blue" -> jp.setBackground(Color.blue);
            case "Green" -> jp.setBackground(Color.GREEN);
            case "Quit" -> System.exit(0);
        }
        
    }
}