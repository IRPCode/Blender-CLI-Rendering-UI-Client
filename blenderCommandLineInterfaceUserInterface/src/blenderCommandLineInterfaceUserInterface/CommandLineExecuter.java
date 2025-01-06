package blenderCommandLineInterfaceUserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class CommandLineExecuter {
	public static void commandExecuter(String filePath, String version, String device, String frames, String engine) {
		try {
			
			//sends command out to CMD to render file
			String command = "\"C:\\Program Files\\Blender Foundation\\Blender " + version
					+ "\\blender.exe\" --background \"" + filePath + "\"" + engine + frames + device;
			
			ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "start", "cmd.exe", "/k", command);
			builder.start();
			
			//automatically opens up output folder
			Desktop.getDesktop().open(new File("C:\\tmp"));
			
			//closes OpenJDK Platform Binary to free system resources to optimize rendering
			System.exit(0);

		} catch (Exception e) {
			errorPrompt("Program failed to start command prompt.");
			e.printStackTrace();
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e1) {
				errorPrompt("There were multiple illegal exceptions that caused the program to crash.");
				throw new RuntimeException("There were multiple illegal exceptions that caused the program to crash.");
			}
		}
	}

	//prompts user if a fatal error occurs
	public static void errorPrompt(String errorType) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("Fatal Error");
			JPanel panel = new JPanel();
			UISetup.setFrameIcon(frame);
			panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JLabel errorMessage = new JLabel(errorType);
			JButton closeButton = new JButton("Ok");

			panel.add(Box.createRigidArea(new Dimension(0, 20)));

			errorMessage.setAlignmentX(Component.CENTER_ALIGNMENT);
			closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);

			panel.add(errorMessage);
			panel.add(Box.createRigidArea(new Dimension(0, 20)));
			panel.add(closeButton);

			frame.add(panel);

			frame.pack();
			frame.setVisible(true);

			Toolkit.getDefaultToolkit().beep();

			closeButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
					System.out.println("Java closed.");
				}

			});

		});
	}
}
