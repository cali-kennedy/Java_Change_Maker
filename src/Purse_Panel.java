import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class Purse_Panel {
    public static class PursePanel extends JPanel {
        private Purse purse;

        // initialize the purse as empty
        public PursePanel() {
            this.purse = new Purse();

        }

        public void setPurse(Purse purse) {
            this.purse = purse;
            repaint();
        }

        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            if(purse == null || purse.getValue() == 0) {
                g.drawString("Empty Purse", 10, 20);
            }else{

            }
        }
    }


}
