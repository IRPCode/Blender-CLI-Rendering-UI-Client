package blenderCommandLineInterfaceUserInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

import javax.swing.*;

public class UISetup {

	static boolean isFileSelected = false;
	static String filePath;
	static JRadioButton CPUDevice;
	static JRadioButton CUDADevice;
	static JRadioButton OPTIXDevice;
	static JRadioButton HIPDevice;
	static JRadioButton ONEAPIDevice;
	static JRadioButton METALDevice;
	static JRadioButton Cycles;
	static JRadioButton EEVEE;
	static JRadioButton EEVEELegacy;
	static JRadioButton Workbench;
	static JRadioButton sceneDefault;
	static JRadioButton SingleFrame;
	static JRadioButton Animation;
	static JLabel chosenFileText;
	static JTextField startFrame;
	static JTextField endFrame;
	static JTextField singleFrame;

	public static void main(String args[]) throws UnsupportedLookAndFeelException {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			CommandLineExecuter.errorPrompt("A class not found exception occured. Please try again.");
		} catch (InstantiationException e) {
			CommandLineExecuter.errorPrompt("An instantiation exception occured. Please try again.");
		} catch (IllegalAccessException e) {
			CommandLineExecuter.errorPrompt("An illegal access exception occured. Please try again.");
		} catch (UnsupportedLookAndFeelException e) {
			CommandLineExecuter.errorPrompt("An unsupported look and feel exception occured. Please try again.");
		}

		JFrame frame = new JFrame();
		JButton fileButton = new JButton("Select Blender File");
		JButton renderButton = new JButton("Render!");
		chosenFileText = new JLabel("No file selected!");
		JLabel renderLabel = new JLabel("Set rendering device:");
		JLabel fileLabel = new JLabel("Choose file:");
		JLabel verWarning = new JLabel(
				"<html> <font color = 'B42D2A'> Note: </font>This may be the version of Blender first installed on your device.</html>");
		JLabel verWarningPT2 = new JLabel(
				"<html><font color = '808080'>Check C:\\Program Files\\Blender Foundation for a </font><font color = '707070'><b>folder</b></font><font color = '808080'> named Blender X.X</font></html>");
		JLabel legacyInfo = new JLabel(
				"<html> <font color = 'B42D2A'> Note: </font>EEVEE Legacy is only for older versions of blender.</html>");
		JLabel legacyInfoPT2 = new JLabel(
				"<html><font color = '808080'>Blender versions 4.2 and up uses EEVEE Next.</font></html>");

		JLabel engineText = new JLabel("Choose rendering engine:");
		JLabel renderTypeText = new JLabel("Choose render type:");
		JLabel startFrameText = new JLabel("Start frame:");
		JLabel endFrameText = new JLabel("End frame:");
		JLabel singleFrameText = new JLabel("Single frame:");
		JSeparator fileSeparator = new JSeparator();
		JSeparator separator1 = new JSeparator();
		JSeparator separator2 = new JSeparator();
		JSeparator separator3 = new JSeparator();
		JSeparator separator4 = new JSeparator();
		JSeparator separator5 = new JSeparator();
		JTextField blenderVersionJT = new JTextField(null);

		startFrame = new JTextField(null);
		endFrame = new JTextField(null);
		singleFrame = new JTextField(null);

		blenderVersionJT.setMaximumSize(new Dimension(50, 20));
		singleFrame.setMaximumSize(new Dimension(60, 20));
		startFrame.setMaximumSize(new Dimension(60, 20));
		endFrame.setMaximumSize(new Dimension(60, 20));

		startFrame.setBackground(new Color(225, 225, 225, 255));
		endFrame.setBackground(new Color(225, 225, 225, 255));
		startFrameText.setForeground(new Color(75, 75, 75, 255));
		endFrameText.setForeground(new Color(75, 75, 75, 255));

		// prevent TextField editing
		startFrame.setEditable(false);
		endFrame.setEditable(false);

		Font currentFont = verWarning.getFont();
		verWarning.setFont(new Font(currentFont.getName(), currentFont.getStyle(), 10));
		verWarningPT2.setFont(new Font(currentFont.getName(), currentFont.getStyle(), 9));
		legacyInfo.setFont(new Font(currentFont.getName(), currentFont.getStyle(), 10));
		legacyInfoPT2.setFont(new Font(currentFont.getName(), currentFont.getStyle(), 9));

		JLabel blenderVLabel = new JLabel("Select Blender version:");

		// Device RB
		CPUDevice = new JRadioButton("CPU");
		CUDADevice = new JRadioButton("CUDA");
		OPTIXDevice = new JRadioButton("OPTIX");
		HIPDevice = new JRadioButton("HIP");
		ONEAPIDevice = new JRadioButton("ONEAPI");
		METALDevice = new JRadioButton("METAL");

		// Engine RB
		sceneDefault = new JRadioButton("Use Scene Settings");
		Cycles = new JRadioButton("Cycles");
		EEVEE = new JRadioButton("EEVEE");
		EEVEELegacy = new JRadioButton("EEVEE Legacy");
		Workbench = new JRadioButton("Workbench");

		// Render type RB
		SingleFrame = new JRadioButton("Single Frame");
		Animation = new JRadioButton("Animation");

		setFrameIcon(frame);

		// Set the layout for the content pane
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		frame.getContentPane().setLayout(groupLayout);

		// keep size consistent
		frame.setPreferredSize(new Dimension(440, 517));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Button groups
		ButtonGroup deviceGroup = new ButtonGroup();
		deviceGroup.add(CPUDevice);
		deviceGroup.add(CUDADevice);
		deviceGroup.add(OPTIXDevice);
		deviceGroup.add(HIPDevice);
		deviceGroup.add(ONEAPIDevice);
		deviceGroup.add(METALDevice);
		OPTIXDevice.setSelected(true);

		ButtonGroup renderGroup = new ButtonGroup();
		renderGroup.add(sceneDefault);
		renderGroup.add(Cycles);
		renderGroup.add(EEVEE);
		renderGroup.add(EEVEELegacy);
		renderGroup.add(Workbench);
		sceneDefault.setSelected(true);

		ButtonGroup renderTypeGroup = new ButtonGroup();
		renderTypeGroup.add(SingleFrame);
		renderTypeGroup.add(Animation);
		SingleFrame.setSelected(true);

		// GroupLayout settings
		groupLayout.setAutoCreateGaps(true);
		groupLayout.setAutoCreateContainerGaps(true);

		// frame components
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(separator1).addComponent(fileLabel).addComponent(fileButton).addComponent(chosenFileText)
				.addComponent(fileSeparator).addComponent(renderLabel)
				.addGroup(groupLayout.createSequentialGroup().addComponent(CPUDevice).addComponent(CUDADevice)
						.addComponent(OPTIXDevice))
				.addGroup(groupLayout.createSequentialGroup().addComponent(HIPDevice).addComponent(ONEAPIDevice)
						.addComponent(METALDevice))
				.addComponent(separator2)
				.addGroup(
						groupLayout.createSequentialGroup().addComponent(blenderVLabel).addComponent(blenderVersionJT))
				.addComponent(verWarning).addComponent(verWarningPT2).addComponent(separator3).addComponent(engineText)
				.addGroup(groupLayout.createSequentialGroup().addComponent(sceneDefault).addComponent(Cycles)
						.addComponent(EEVEE).addComponent(EEVEELegacy).addComponent(Workbench))
				.addComponent(legacyInfo).addComponent(legacyInfoPT2).addComponent(separator4)
				.addComponent(renderTypeText)
				.addGroup(groupLayout.createSequentialGroup().addComponent(SingleFrame).addComponent(Animation))
				.addGroup(groupLayout.createSequentialGroup().addComponent(singleFrameText).addComponent(singleFrame))
				.addGroup(groupLayout.createSequentialGroup().addComponent(startFrameText).addComponent(startFrame))
				.addGroup(groupLayout.createSequentialGroup().addComponent(endFrameText).addComponent(endFrame))
				.addComponent(separator5).addComponent(renderButton));
		groupLayout

				.setVerticalGroup(groupLayout.createSequentialGroup().addComponent(separator1).addComponent(fileLabel)
						.addComponent(fileButton).addComponent(chosenFileText).addComponent(fileSeparator)
						.addComponent(renderLabel)
						.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(CPUDevice).addComponent(CUDADevice).addComponent(OPTIXDevice))
						.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(HIPDevice).addComponent(ONEAPIDevice).addComponent(METALDevice))
						.addComponent(separator2)
						.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(blenderVLabel).addComponent(blenderVersionJT))
						.addComponent(verWarning).addComponent(verWarningPT2).addComponent(separator3)
						.addComponent(engineText)
						.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(sceneDefault).addComponent(Cycles).addComponent(EEVEE)
								.addComponent(EEVEELegacy).addComponent(Workbench))
						.addComponent(legacyInfo).addComponent(legacyInfoPT2).addComponent(separator4)
						.addComponent(renderTypeText)
						.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(SingleFrame).addComponent(Animation))
						.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(singleFrame).addComponent(singleFrameText))
						.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(startFrameText).addComponent(startFrame))
						.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(endFrameText).addComponent(endFrame))
						.addComponent(separator5).addComponent(renderButton));

		// final setup
		frame.setTitle("Blender CLI Rendering Assistant");
		frame.pack();
		frame.setVisible(true);

		// button functionality
		fileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UIManager.put("FileChooser.saveButtonText", "Open");
				JFileChooser filePrompt = new JFileChooser();
				filePrompt.setDialogTitle("File Explorer");
				int returnVal = filePrompt.showSaveDialog(frame);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File selectedFile = filePrompt.getSelectedFile();
					filePath = selectedFile.getAbsolutePath();
					chosenFileText.setText("Selected file: " + filePath);
					isFileSelected = true;
				}
			}
		});

		renderButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String blenderVerVal = blenderVersionJT.getText().trim();
		        boolean isSingleFrameSelected = SingleFrame.isSelected();
		        boolean isAnimationSelected = Animation.isSelected();
		        String singleFrameValue = singleFrame.getText().trim();
		        String startFrameValue = startFrame.getText().trim();
		        String endFrameValue = endFrame.getText().trim();
		        
		        //Resets UI after error
		        fileButton.setBackground(new Color(255, 255, 255, 255));
		        blenderVersionJT.setBackground(new Color(255, 255, 255, 255));
		        
		        if(isAnimationSelected == false) {
		        	singleFrame.setBackground(new Color(255, 255, 255, 255));
		        }
		        
		        else {
		        	startFrame.setBackground(new Color(255, 255, 255, 255));
		        	endFrame.setBackground(new Color(255, 255, 255, 255));
		        }
		        
		        //checks for user errors
						if (isFileSelected == false) {
							Toolkit.getDefaultToolkit().beep();
							fileButton.setBackground(Color.decode("#FFD1D1"));
							renderButton.setText("Enter empty fields!");
						}
						
						if (blenderVerVal.isEmpty()) {
							renderButton.setText("Enter empty fields!");
							blenderVersionJT.setBackground(Color.decode("#FFD1D1"));
							Toolkit.getDefaultToolkit().beep();
						}
							
						if (isSingleFrameSelected == true && singleFrameValue.isEmpty()) {
							renderButton.setText("Enter empty fields!");
							singleFrame.setBackground(Color.decode("#FFD1D1"));
							Toolkit.getDefaultToolkit().beep();
						}
						
						if (isAnimationSelected == true && (startFrameValue.isEmpty() || endFrameValue.isEmpty())) {
							if (startFrameValue.isEmpty()) {
								renderButton.setText("Enter empty fields!");
								startFrame.setBackground(Color.decode("#FFD1D1"));
								Toolkit.getDefaultToolkit().beep();
							}
							if (endFrameValue.isEmpty())
							{
								renderButton.setText("Enter empty fields!");
								endFrame.setBackground(Color.decode("#FFD1D1"));
								Toolkit.getDefaultToolkit().beep();
							}
						}
				
				//if everything looks good, command is sent out to the CommandLineExecuter class
				if ((isFileSelected == true) && (!blenderVerVal.isEmpty())
						&& ((isSingleFrameSelected == true && !singleFrameValue.isEmpty())
								|| (isAnimationSelected == true
										&& (!startFrameValue.isEmpty() && !endFrameValue.isEmpty())))) {
					CommandLineExecuter.commandExecuter(filePath, blenderVerVal, devices(), frameGetter(),renderingEngineGetter());
				}		
		    }
		});

		//more button functions
		Animation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				singleFrame.setBackground(new Color(225, 225, 225, 255));
				singleFrameText.setForeground(new Color(75, 75, 75, 255));
				singleFrame.setEditable(false);
				singleFrame.setText("");

				startFrame.setBackground(new Color(255, 255, 255, 255));
				endFrame.setBackground(new Color(255, 255, 255, 255));
				startFrameText.setForeground(new Color(0, 0, 0, 255));
				endFrameText.setForeground(new Color(0, 0, 0, 255));
				startFrame.setEditable(true);
				endFrame.setEditable(true);
			}

		});

		SingleFrame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				singleFrame.setBackground(new Color(255, 255, 255, 255));
				singleFrameText.setBackground(new Color(0, 0, 0, 255));
				singleFrame.setEditable(true);
				singleFrame.setText("");

				startFrame.setBackground(new Color(225, 225, 225, 255));
				endFrame.setBackground(new Color(225, 225, 225, 255));
				startFrameText.setForeground(new Color(75, 75, 75, 255));
				endFrameText.setForeground(new Color(75, 75, 75, 255));
				startFrame.setEditable(false);
				endFrame.setEditable(false);
				startFrame.setText("");
				endFrame.setText("");
			}
		});
	}

	public static void setFrameIcon(JFrame frame) {
		URL iconURL = UISetup.class.getResource("/images/blenderIcon.png");
		if (iconURL != null) {
			Image icon = Toolkit.getDefaultToolkit().getImage(iconURL);
			frame.setIconImage(icon);
		} else {
			System.out.println(iconURL);
		}
	}

	//tells CLI which device is needed
	public static String devices() {
		String renderDevice = " -- --cycles-device ";
		if (CUDADevice.isSelected()) {
			renderDevice = renderDevice + "CUDA";
		} else if (OPTIXDevice.isSelected()) {
			renderDevice = renderDevice + "OPTIX";
		} else if (HIPDevice.isSelected()) {
			renderDevice = renderDevice + "HIP";
		} else if (ONEAPIDevice.isSelected()) {
			renderDevice = renderDevice + "ONEAPI";
		} else if (METALDevice.isSelected()) {
			renderDevice = renderDevice + "METAL";
		} else {
			renderDevice = renderDevice + "CPU";
		}
		return renderDevice;
	}

	//tells CLI which frames are needed
	public static String frameGetter() {
		String frames = null;
		if (SingleFrame.isSelected()) {
			frames = " -f " + singleFrame.getText();
		} else if (Animation.isSelected()) {
			frames = " -s " + startFrame.getText() + " -e " + endFrame.getText() + " -a ";
		}
		return frames;
	}

	//tells CLI which engine is needed
	public static String renderingEngineGetter() {
		String engine = null;
		if (Cycles.isSelected()) {
			engine = " -E CYCLES ";
		} else if (EEVEE.isSelected()) {
			engine = " -E BLENDER_EEVEE_NEXT ";
		} else if (EEVEELegacy.isSelected()) {
			engine = " -E BLENDER_EEVEE ";
		} else if (Workbench.isSelected()) {
			engine = " -E BLENDER_WORKBENCH ";
		} else {
			engine = "";
		}
		return engine;
	}
}
