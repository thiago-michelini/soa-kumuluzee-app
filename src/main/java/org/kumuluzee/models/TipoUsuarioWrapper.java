package org.kumuluzee.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TipoUsuarioWrapper {

	private TipoUsuario[] tiposUsuario;
	
	public TipoUsuarioWrapper() {
		setTiposUsuario(TipoUsuario.values());
	}

	public TipoUsuario[] getTiposUsuario() {
		return tiposUsuario;
	}

	public void setTiposUsuario(TipoUsuario[] tiposUsuario) {
		this.tiposUsuario = tiposUsuario;
	}
	
}
