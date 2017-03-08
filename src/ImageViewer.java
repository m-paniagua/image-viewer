import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ImageViewer extends JFrame{
	
	private JPanel imagePanel;     // To hold the label
	private JPanel buttonPanel;    // To hold a button
	private JLabel imageLabel;     // To show an image
	private JButton button;        // To get an image
	private JFileChooser fChooser;
	
	public ImageViewer() {
		
		setTitle("Image Viewer");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		buildImagePanel();
		buildButtonPanel();
		
		add(imagePanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
	}
	
	private void buildImagePanel() {
		imagePanel = new JPanel();
		
		imageLabel = new JLabel("Click button to open image.");
		
		imagePanel.add(imageLabel);
	}
	
	private void buildButtonPanel() {
		buttonPanel = new JPanel();
		
		button = new JButton("Open image");
		button.setToolTipText("Click here to open image");
		button.setMnemonic(KeyEvent.VK_O);
		
		button.addActionListener(new ButtonListener());
		
		buttonPanel.add(button);
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			fChooser = new JFileChooser();
			int status = fChooser.showOpenDialog(null);
			
			if (status == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fChooser.getSelectedFile();
				String fileNameString = selectedFile.getPath();
				ImageIcon selImage = new ImageIcon(fileNameString);
				imageLabel.setIcon(selImage);
			}

	         // Remove the text from the label.
	         imageLabel.setText(null);

	         // Pack the frame again to accomodate the 
	         // new size of the label.
	         pack();
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ImageViewer();
	}

}
