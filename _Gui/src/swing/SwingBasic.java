package swing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class SwingBasic {

	public SwingBasic(){
		JFrame jFrame = new JFrame("First Swing Demo");
		jFrame.setSize(200, 150);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
		
		//Set Layout or the component locations will be the same
		jFrame.setLayout(new FlowLayout());
		
		//Create JLabels
		JLabel jLabel1 = new JLabel("Label1");
		JLabel jLabel2 = new JLabel("Label2");
		jFrame.add(jLabel1);
		jFrame.add(jLabel2);
		
		//Create JButton
		JButton jButtonL = new JButton("Left");
		JButton jButtonR = new JButton("Right");
		jFrame.add(jButtonL);
		jFrame.add(jButtonR);
		
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				new SwingBasic();
			}
		});
	}
}
