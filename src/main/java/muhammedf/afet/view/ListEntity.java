package muhammedf.afet.view;

import muhammedf.afet.dao.AfetDAO;
import muhammedf.afet.model.Afet;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ListEntity implements Serializable {

    @Inject
    private AfetDAO afetDao;

    private List<Afet> afets;

    @PostConstruct
    public void init(){
        afets = afetDao.findAll();
    }

    public List<Afet> getAfets() {
        return afets;
    }

    public void setAfets(List<Afet> afets) {
        this.afets = afets;
    }
}
