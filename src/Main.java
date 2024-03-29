import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main{
	public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE); 
                FileChooser fc = new FileChooser();
                fc.createAndShowGUI();
            }
        });
    }
}
