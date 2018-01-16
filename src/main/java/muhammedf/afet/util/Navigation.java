package muhammedf.afet.util;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class Navigation {

    public String redirect(String url){
        return url+"&amp;faces-redirect=true";
    }

    public String newAfet(){
        return redirect("/afet/view?state=new");
    }

    public String editAfet(Long id){
        return redirect("/afet/view?state=old&amp;id="+id);
    }
}
