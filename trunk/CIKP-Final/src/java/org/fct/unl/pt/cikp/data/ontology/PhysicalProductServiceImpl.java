
package org.fct.unl.pt.cikp.data.ontology;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.fct.unl.pt.cikp.service.ontology.OntServiceImpl;
import org.fct.unl.pt.cikp.service.ontology.manager.PersistentOntology;
import org.fct.unl.pt.cikp.service.ontology.manager.exceptions.MissingParamException;

/**
 *
 * @author Paulo Figueiras
 */
public class PhysicalProductServiceImpl implements PhysicalProductService {

    private OntServiceImpl ont ;

    public PhysicalProduct createPhysicalProduct(PhysicalProduct prod, PersistentOntology p) {
        OntServiceImpl onts = getOnt() ;
        try {
            onts.createIndividual(prod.getType(), prod.getName(), p);
            onts.addLiteralByProperty("has_Location", prod.getName(), prod.getLocation(), p);
            onts.addLiteralByProperty("has_Name", prod.getName(), prod.getName(), p);
            onts.addLiteralByProperty("has_Event_Affiliation", prod.getName(), prod.getEvent_affiliation(), p);
            onts.addLiteralByProperty("has_Process_Affiliation", prod.getName(), prod.getProcess_affiliation(), p);
            onts.addLiteralByProperty("has_Project_Affiliation", prod.getName(), prod.getProject_affiliation(), p);
        } catch (IOException ex) {
            Logger.getLogger(PhysicalProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(PhysicalProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PhysicalProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prod ;
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
