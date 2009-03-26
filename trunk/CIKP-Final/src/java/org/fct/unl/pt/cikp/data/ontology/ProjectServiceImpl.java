package org.fct.unl.pt.cikp.data.ontology;

import com.hp.hpl.jena.datatypes.xsd.AbstractDateTime;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.fct.unl.pt.cikp.service.ontology.OntService;
import org.fct.unl.pt.cikp.service.ontology.OntServiceImpl;
import org.fct.unl.pt.cikp.service.ontology.manager.exceptions.MissingParamException;

/**
 *
 * @author Paulo Figueiras
 */

public class ProjectServiceImpl implements ProjectService {

    private OntService ont ;

    public Project createProject(Project proj) {
        try {
            OntService onts = getOnt();
            onts.createIndividual(proj.getProject_type(), proj.getName());
            onts.addLiteralByProperty("has_Project_Closing_Date", proj.getName(), new AbstractDateTime(proj.getProject_closing_date()));
            onts.addLiteralByProperty("has_Project_Delivery_Method", proj.getName(), proj.getProject_delivery_method());
            onts.addLiteralByProperty("has_Location", proj.getName(), proj.getLocation());
            onts.addLiteralByProperty("has_Project_Name", proj.getName(), proj.getName());
            onts.addLiteralByProperty("has_Project_Starting_Date", proj.getName(), new AbstractDateTime(proj.getProject_starting_date()));
            onts.addLiteralByProperty("has_Project_Total_Investment", proj.getName(), proj.getProject_total_investiment());
            onts.addLiteralByProperty("has_Product_Affiliation", proj.getName(), proj.getProduct_affiliation());
            return proj;
        } catch (IOException ex) {
            Logger.getLogger(ProjectServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null ;
        } catch (MissingParamException ex) {
            Logger.getLogger(ProjectServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null ;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProjectServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null ;
        }
    }

    /**
     * @return the ont
     */
    public OntService getOnt() {
        return new OntServiceImpl();
    }

    /**
     * @param ont the ont to set
     */
    public void setOnt(OntService ont) {
        this.ont = ont;
    }

}
