import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.sound.sampled.*;


public class MyFrame extends JFrame  implements ActionListener{
    public boolean isPlaying = false;
    Mypanel panel = new Mypanel();
    File file = new File("horimiya_op.wav");

    JButton pause_button = new JButton();
    JButton play_button = new JButton();
    JButton replay_button = new JButton();

    ImageIcon play_icon = new ImageIcon("play.png"); //created icon for play image
    Image img1 = play_icon.getImage(); //from the icon extraxted the image
    Image new_img1 = img1.getScaledInstance(60, 60, Image.SCALE_SMOOTH); //resized the image
    ImageIcon resized_play_icon = new ImageIcon(new_img1); //created another icon with the resized image


    ImageIcon pause_icon = new ImageIcon("pause.png");
    Image img2 = pause_icon.getImage();
    Image new_img2 = img2.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
    ImageIcon resized_pause_icon = new ImageIcon(new_img2);


    ImageIcon replay_icon = new ImageIcon("refresh.png");
    Image img3 = replay_icon.getImage();
    Image new_img3 = img3.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
    ImageIcon resized_replay_icon = new ImageIcon(new_img3);

    MusicStuffs music = new MusicStuffs();

    //test

    static AudioInputStream audio_stream;
    static Clip clip;

    public void playaudio(File audioFile){
        try{
	    isPlaying = true;
	    try{		
		audio_stream = AudioSystem.getAudioInputStream(audioFile);
	    }catch(Exception e){
		System.out.println("Cannot get Audio Input Stream");
	    }
	    try{
		clip = AudioSystem.getClip();
	    }catch(Exception e){
		System.out.println("Cannot get Audio Clip");
	    }
	    try
		{
		    clip.open(audio_stream);
		}catch(Exception e){
		System.out.println("Cannot get the clip to be opened");
	    }
	    try{
		
            clip.start();
	    }catch(Exception e){
		System.out.println("Cannot start the Clip");
	    }
        }catch(Exception e){
	    System.out.println("Fuck you!");
        }
    }

    public void pauseaudio(){
        try{
	    isPlaying = false;
            clip.stop();
        }catch(Exception e){

        }
    }

    public void replayaudio(){
        try{
            clip.setMicrosecondPosition(0);
        }catch(Exception e){

        }
    }

    //test

    MyFrame(){
      
        //basic settings of the frame such as size, visibility, close_operation

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Horimiya Player");
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(500, 500);

        //setting the background color for the frame
        this.getContentPane().setBackground(new Color(145,70,255));

        //changing the default to null(manual)
        this.setLayout(null);

        //let's add my panel to hold all my buttons
        this.add(panel);
        panel.setBounds(40, 310, 400, 100);
        panel.setLayout(null);
        
        //adding my buttons to  the panel 

        panel.add(pause_button);
        pause_button.setBounds(40, 10, 80, 80);
        pause_button.setIcon(resized_pause_icon);
        pause_button.addActionListener(this);

        panel.add(play_button);
        play_button.setBounds(160, 10, 80, 80);
        play_button.setIcon(resized_play_icon);
        play_button.addActionListener(this);

        panel.add(replay_button);
        replay_button.setBounds(280, 10, 80, 80);
        replay_button.setIcon(resized_replay_icon);
        replay_button.addActionListener(this);

    }
    @Override
    public  void actionPerformed(ActionEvent e) {
        if(e.getSource()==play_button){
	    if (isPlaying == false){
            playaudio(file);
	    }
            System.out.println("Playing");
        }
        else if(e.getSource()==pause_button){
	    pauseaudio();
            System.out.println("Paused");
        }
        else if(e.getSource()==replay_button){
	    replayaudio();
            System.out.println("re-Playing");
        }
        
    }
    
    
}
