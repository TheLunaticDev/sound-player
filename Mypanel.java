// creating a panel to hold all my buttons
//It's not necessary but let's do this 

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.*;

public class Mypanel extends JPanel{

    Border border = BorderFactory.createRaisedBevelBorder();

    Mypanel(){
        this.setBorder(border);
        this.setBackground(new Color(0xC7C7C7));
    }
}