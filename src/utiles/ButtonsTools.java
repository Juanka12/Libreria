package utiles;

import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;

public class ButtonsTools {
	public static String getSelectedButtonText(ButtonGroup buttonGroup) {
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
			if (button.isSelected()) {
				return button.getText();
			}
		}
		return null;
	}
	
	public static void clearListeners(JButton e) {
		for (int i = 0; i < e.getActionListeners().length; i++) {
			e.removeActionListener(e.getActionListeners()[i]);
		}
	}
	
	public static ButtonModel getButtonModel(ButtonGroup buttonGroup, String name) {
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
			if (button.getText().equals(name)) {
				return button.getModel();
			}
		}
		return null;
	}
}
