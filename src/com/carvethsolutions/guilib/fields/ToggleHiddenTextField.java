package com.carvethsolutions.guilib.fields;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class ToggleHiddenTextField extends JPanel {

    private JButton toggle;

    private HiddenTextField htf;

    private boolean hidden;

    private ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (hidden) {
                htf.showInput();
            } else {
                htf.hideInput();
            }
            hidden = !hidden;
        }
    };

    public ToggleHiddenTextField() {
        htf = new HiddenTextField();
        htf.setBorder(null);
        hidden = true;

        try {
            Image image = ImageIO.read(getClass().getResource("/visibility-button.png"));
            image = image.getScaledInstance(htf.getPreferredSize().height, htf.getPreferredSize().height,
                    Image.SCALE_AREA_AVERAGING);

            toggle = new JButton(new ImageIcon(image));
            toggle.setBorder(null);
            toggle.addActionListener(al);
        } catch (IOException e) {
            System.out.println("IOException : ");
            e.printStackTrace();
        }

        this.add(htf);
        this.add(toggle);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.triggerMomentaryBehaviour();
    }

    /**
     * Changes the Icon's behaviour from click on/off to touch and release
     */
    public void triggerMomentaryBehaviour() {
        toggle.removeActionListener(al);

        toggle.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                htf.showInput();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                htf.hideInput();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

}
