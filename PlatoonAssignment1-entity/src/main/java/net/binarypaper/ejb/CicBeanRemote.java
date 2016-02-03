package net.binarypaper.ejb;

import net.binarypaper.entity.Cic;

public interface CicBeanRemote {

    Cic addCic(Cic cic) throws CicException;

    Cic getCic(Long cicId) throws CicException;

}
