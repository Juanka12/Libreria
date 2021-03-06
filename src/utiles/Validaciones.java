package utiles;

import java.util.regex.Pattern;

public class Validaciones {

		public static boolean validar(String campo, String name) {
			if (name.equals("ISBN")) {
				return validateISBN(campo);
			}else if (name.equals("Precio")) {
				return isNumberFloat(campo);
			}else if (name.equals("Autor")){
				return validateLetters(campo);
			}else {
				return !campo.equals("");
			}
		}
		public static boolean validateLetters(String string) {
			return Pattern.matches("[a-zA-Z\\s]+", string);
		}
		
		public static boolean validateISBN(String string) {
			return Pattern.matches("\\d{13}", string);
		}
		
		public static boolean isNumberFloat(String string) {
			try {
				Float.parseFloat(string);
				char charAt = string.charAt(string.length()-1);
				if (charAt == 'f' || charAt == 'd') {
					return false;
				}
			} catch (NumberFormatException e) {
				return false;
			}
			return true;
		}
		
		public static boolean validateNumber(String nombre) {
	        return Pattern.matches("[0-9]+", nombre);
	    }
}
