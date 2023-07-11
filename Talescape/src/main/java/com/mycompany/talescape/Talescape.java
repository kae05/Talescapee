package com.mycompany.talescape;
import java.io.IOException;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.*;

public class Talescape {

    private static String[] messages = {
            "The heavy rain began to pour in the middle of the night on the road.",
            "You stumbled upon an old, abandoned house and decided to take shelter there for a while.",
            "While searching, an old man suddenly appeared in the middle of the night.",
            "\"There is no longer anyone living here. If I were you, I'd turn back. You should be careful.\"",
            "You have no idea what is going on, yet you decide to keep walking inside, driven by the tiredness you feel.",
            "But a lost soul lingers. ",
            "The air thickens with the anguished cries of tortured souls. Survival hangs by a thread as you navigate this macabre nightmare.",
            "Can you escape the clutches of this haunted abyss, or will you become just another lost spirit, forever trapped within its walls?"
    };
    private static int currentMessageIndex = 0;

    public static void playBackgroundMusic(String musicFilePath) {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(Talescape.class.getResourceAsStream(musicFilePath));
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel();
        CardLayout cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        // Slide 1
        JPanel slide1 = new JPanel(null);
        slide1.setBackground(Color.BLACK);
        slide1.setLayout(new BorderLayout());

        JPanel labelContainer = new JPanel();
        labelContainer.setBounds(100, 100, 200, 30);
        labelContainer.setBackground(Color.WHITE);
        labelContainer.setLayout(new FlowLayout(FlowLayout.LEFT)); // Update layout manager

        JButton gameButton = new JButton("Game");
        JButton helpButton = new JButton("Help");

        labelContainer.add(gameButton);
        labelContainer.add(helpButton);

        slide1.add(labelContainer, BorderLayout.NORTH);
        mainPanel.add(slide1, "Slide 1");

        // Slide 2
        JPanel slide2 = new JPanel(null);
        slide2.setBackground(Color.BLUE);
        slide2.setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setPreferredSize(new Dimension(300, 200));
        contentPanel.setLayout(new BorderLayout());

        JPanel messagePanel = new JPanel();
        messagePanel.setBackground(Color.BLACK);
        messagePanel.setPreferredSize(new Dimension(250, 150));
        messagePanel.setLayout(new BorderLayout());

        JLabel messageLabel = new JLabel(messages[currentMessageIndex]);
        messageLabel.setForeground(Color.white);
        messageLabel.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        messagePanel.add(messageLabel, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.RED);
        backButton.setPreferredSize(new Dimension(100, 40));
        backButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));

        JButton nextButton = new JButton("Next");
        nextButton.setForeground(Color.WHITE);
        nextButton.setBackground(Color.RED);
        nextButton.setPreferredSize(new Dimension(100, 40));
        nextButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(backButton);
        buttonPanel.add(nextButton);

        contentPanel.add(messagePanel, BorderLayout.CENTER);
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);

        slide2.add(contentPanel, BorderLayout.CENTER);
        mainPanel.add(slide2, "Slide 2");

        // Slide 3
        JPanel slide3 = new JPanel(null);
        slide3.setBackground(Color.CYAN);;

        // Slide 4
        JPanel slide4 = new JPanel(null);
        // Customize Slide 4 as desired

        // Slide 5
        JPanel slide5 = new JPanel(null);
        // Customize Slide 5 as desired

        // Slide 6
        JPanel slide6 = new JPanel(null);
        // Customize Slide 6 as desired

        // Slide 7
        JPanel slide7 = new JPanel(null);
        // Customize Slide 7 as desired

        // Add slides to the mainPanel
        mainPanel.add(slide3, "Slide 3");
        mainPanel.add(slide4, "Slide 4");
        mainPanel.add(slide5, "Slide 5");
        mainPanel.add(slide6, "Slide 6");
        mainPanel.add(slide7, "Slide 7");

        JButton button = new JButton("BEGIN");
        button.setForeground(Color.WHITE);
        button.setBackground(Color.RED);
        button.setPreferredSize(new Dimension(150, 40));
        button.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Ciphered Spirits: Midnight Enigma");
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(new BorderLayout());

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(button, BorderLayout.CENTER);

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setSize(1000, 1000);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Slide 2"); // Switch to Slide 2
                bottomPanel.remove(button);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentMessageIndex > 0) {
                    currentMessageIndex--;
                    messageLabel.setText(messages[currentMessageIndex]);
                }
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentMessageIndex < messages.length - 1) {
                    currentMessageIndex++;
                    messageLabel.setText(messages[currentMessageIndex]);
                } else {
                    if (currentMessageIndex == messages.length - 1) {
                        cardLayout.show(mainPanel, "Slide 3"); // Switch to Slide 3
                    } else {
                        cardLayout.show(mainPanel, "Slide 1"); // Switch back to Slide 1
                    }
                }
            }
        });
    }
}
