
package org.fct.unl.pt.cikp.data.ontology;

import com.hp.hpl.jena.datatypes.xsd.AbstractDateTime;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.fct.unl.pt.cikp.service.ontology.OntServiceImpl;
import org.fct.unl.pt.cikp.service.ontology.manager.exceptions.MissingParamException;

/**
 *
 * @author Paulo Figueiras
 */
public class ProcessServiceImpl implements ProcessService {

    private OntServiceImpl ont ;

    public Process createProcess(Process proc) {
        OntServiceImpl onts = getOnt() ;
        String aux = proc.getProctype() + "_" + proc.getUsername() ;
        try {
            onts.createIndividual(proc.getProctype(), aux);
            onts.addLiteralByProperty("has_Location", aux, proc.getLocation());
            onts.addLiteralByProperty("has_Subject_Domain", aux, proc.getSubjectdomain());
            onts.addLiteralByProperty("has_Process_Cost", aux, proc.getProccost());
            onts.addLiteralByProperty("has_Process_Starting_Time", aux, new AbstractDateTime(proc.getProcstartingtime()));
            onts.addLiteralByProperty("has_Process_Ending_Time", aux, new AbstractDateTime(proc.getProcendingtime()));
        } catch (IOException ex) {
            Logger.getLogger(ProcessServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(ProcessServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProcessServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proc ;
    }

    /**
     * @return the ont
     */
    public OntServiceImpl getOnt() {
        return new OntServiceImpl();
    }

    /**
     * @param ont the ont to set
     */
    public void setOnt(OntServiceImpl ont) {
        this.ont = ont;
    }

}
