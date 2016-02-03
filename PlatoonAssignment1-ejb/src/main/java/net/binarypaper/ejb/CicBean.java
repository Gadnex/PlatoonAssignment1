package net.binarypaper.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import net.binarypaper.entity.Cic;

@Stateless
@Remote(CicBeanRemote.class)
public class CicBean implements CicBeanRemote {

    @PersistenceContext(unitName = "PlatoonAssignment1PU")
    private EntityManager em;

    @Override
    public Cic addCic(Cic cic) throws CicException {
        try {
            em.persist(cic);
            return cic;
        } catch (Exception e) {
            throw new CicException("The cic could not be added");
        }
    }

    @Override
    public Cic getCic(Long cicId) throws CicException {
        try {
            return em.find(Cic.class, cicId);
        } catch (Exception e) {
            throw new CicException("The cic could not be found");
        }
    }

}
