package net.binarypaper.service;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import net.binarypaper.ejb.CicException;
import net.binarypaper.entity.Cic;

@Stateless
@LocalBean
@WebService
public class CicRegistrationEngine {

    @EJB
    private net.binarypaper.ejb.CicBeanRemote cicBean;

    @WebMethod
    public Cic registerCic(@WebParam(name = "cic") Cic cic) throws CicException {
        return cicBean.addCic(cic);
    }

    @WebMethod
    public Cic retrieveCicInfo(@WebParam(name = "cicId") Long cicId) throws CicException {
        return cicBean.getCic(cicId);
    }
}
