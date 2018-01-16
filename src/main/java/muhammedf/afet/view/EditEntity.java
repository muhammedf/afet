package muhammedf.afet.view;

import muhammedf.afet.dao.AfetDAO;
import muhammedf.afet.model.Afet;
import muhammedf.afet.util.FacesUtil;

import javax.annotation.PostConstruct;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.UUID;

@Named
@ViewScoped
public class EditEntity implements Serializable {

    @Inject
    private AfetDAO afetDao;

    private Afet afet;

    private String state;

    @PostConstruct
    public void init(){
        state = FacesUtil.getParameter("state");

        switch (state){
            case "new": initNewAfet(); break;
            case "old": initOldAfet(); break;
        }
    }

    public Afet getAfet() {
        return afet;
    }

    public void setAfet(Afet afet) {
        this.afet = afet;
    }

    private void initNewAfet(){
        String randomUUID = UUID.randomUUID().toString();
        afet = new Afet();
        afet.setSeriNo(randomUUID);
        afet.setGlideNo(randomUUID);
    }

    private void initOldAfet(){
        Long id = Long.parseLong(FacesUtil.getParameter("id"));
        afet = afetDao.read(id);
    }

    public void saveEntity(){
        switch (state){
            case "new": afetDao.create(afet); state="old"; break;
            case "old": afetDao.update(afet); break;
        }
    }

    private void resetValues(String...s){
        Arrays.stream(s).forEach(v->{
            switch (v){
                case "ilce": afet.setIlce(null); break;
                case "koy": afet.setKoy(null); break;
                case "mahalle": afet.setMahalle(null); break;
            }
        });
    }

    public void onIlChange(AjaxBehaviorEvent event){
        resetValues("koy", "mahalle");
    }
    public void onIlceChange(AjaxBehaviorEvent event){
        resetValues("mahalle");
    }
    public void onKoyChange(AjaxBehaviorEvent event){
        resetValues();
    }

}
