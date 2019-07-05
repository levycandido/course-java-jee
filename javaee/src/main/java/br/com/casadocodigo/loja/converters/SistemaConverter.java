package br.com.casadocodigo.loja.converters;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.casadocodigo.loja.models.Sistema;

@FacesConverter("sistemaConverter")
public class SistemaConverter implements Converter, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Object getAsObject(FacesContext context, UIComponent component, String id) {
	    if (id == null || id.trim().isEmpty()) 
	        return null;

	    Sistema sistema = new Sistema();
	    sistema.setId(Integer.valueOf(id));

	    return sistema;
	}

	public String getAsString(FacesContext context, UIComponent component, Object sistemaObject) {
	    if (sistemaObject == null)
	        return null;

	    Sistema sistema = (Sistema) sistemaObject;
	    return sistema.getId().toString();
	}

}
