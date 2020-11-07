package modelo;

public enum Error {
	Campos("Hay campos erroneos"), Existente("Ya existe ese libro"), SinSeleccion("Ningun libro seleccionado"), Cantidad("La cantidad debe ser mayor a cero");
	
	private String display;
	
	Error(String display){
		this.display = display;
	}
	
	public String getDisplay() {
		return display;
	}
}
