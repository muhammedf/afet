package muhammedf.afet.util;

import javax.faces.context.FacesContext;

public class FacesUtil {

    private FacesUtil(){}

    public static String getParameter(String name){
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name);
    }

}
