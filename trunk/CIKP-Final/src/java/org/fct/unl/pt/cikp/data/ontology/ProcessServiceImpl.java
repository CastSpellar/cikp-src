
package org.fct.unl.pt.cikp.data.ontology;

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
        String aux = proc.getProcess_type() + "_" + proc.getUsername() ;
        try {
            onts.createIndividual(proc.getProcess_type(), aux);
            onts.addLiteralByProperty("has_Location", aux, proc.getLocation());
            onts.addLiteralByProperty("has_Subject_Domain", aux, proc.getSubject_domain());
            onts.addLiteralByProperty("has_Process_Cost", aux, proc.getProcess_cost());
            onts.addLiteralByProperty("has_Process_Starting_Time", aux, proc.getProcess_starting_time());
            onts.addLiteralByProperty("has_Process_Ending_Time", aux, proc.getProcess_ending_time());
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
