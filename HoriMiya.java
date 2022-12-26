//Ar_Lazy_Dev
import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.io.*;

public class HoriMiya{
    
    
    public static void main(String[] args)throws Exception{
        
        MyFrame frame = new MyFrame(); //created an instance of my frame

        ImageIcon frame_icon = new ImageIcon("music.png"); //created an icon from the image
        frame.setIconImage(frame_icon.getImage()); //added my image as the icon for my frame

        //now I'm going to add my imgae and text to the frame using the Jlabel class
        JLabel main_label = new JLabel();
        frame.add(main_label); //added the main label to the frame to make it visible
        main_label.setBounds(40, 40, 400, 225); //label size and position

        //I'll add a border to my label as well
        Border border = BorderFactory.createLineBorder(new Color(0xFFFFFF), 4);
        main_label.setBorder(border);

        main_label.setText("Miyamura-kun to Hori-san"); //set the text to display
        
        //imported the main image and added it to the label
        ImageIcon main_image = new ImageIcon("Horimiya kawaii.png");
        main_label.setIcon(main_image);
        
        //all the alignmnet for the main label and text are done here
        main_label.setHorizontalAlignment(JLabel.CENTER);
        main_label.setVerticalAlignment(JLabel.TOP);
        main_label.setVerticalTextPosition(JLabel.BOTTOM);
        main_label.setHorizontalTextPosition(JLabel.CENTER);
        main_label.setIconTextGap(-25);

        //adding and applying my custom font to the label text >_<

        /*
            to add your custom font in java and use it, there are several methods to do that.
            Currently the easiest way I found to do it is the one use below.
            We need to create an inputstream from our font file, then we need to create a font
            object form the inputstream that we just created and finally to increase the font size
            of the newly created font we use the deriveFont() method to generate a font with larger
            size. Now we're redy to use it :)
         */
        InputStream custom_font = new FileInputStream("NeonLights-22d.ttf");
        Font NeonLight = Font.createFont(Font.TRUETYPE_FONT, custom_font).deriveFont(25f);
        main_label.setFont(NeonLight);
        main_label.setForeground(new Color(0xC7C7C7));
    }
}