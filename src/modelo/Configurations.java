package modelo;

import java.io.Serializable;

public class Configurations implements Serializable {
	private final String RUTA_CONFIG = "config.conf";
	private boolean oscuro;
	
	public Configurations() {
		this.oscuro=false;
	}
	
	public String getRUTA_CONFIG() {
		return this.RUTA_CONFIG;
	}

	public boolean isOscuro() {
		return this.oscuro;
	}

	public void setOscuro(boolean oscuro) {
		this.oscuro = oscuro;
	}
	
}
