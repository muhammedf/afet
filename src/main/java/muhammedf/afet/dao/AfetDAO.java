package muhammedf.afet.dao;

import muhammedf.afet.model.Afet;

import javax.ejb.Stateless;

@Stateless
public class AfetDAO extends GenericDAOImpl<Afet, Long> {

    @Override
    protected Class<Afet> claz() {
        return Afet.class;
    }
}
