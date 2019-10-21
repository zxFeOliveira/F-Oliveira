package br.edu.semi.presencial.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JSFUtil {
	
	public static void enviarMensagemInformacao(String msg) {
		FacesMessage fm = new FacesMessage();
		fm.setSummary(msg);
		fm.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, fm);
		
	}

}
