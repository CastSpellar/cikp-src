/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class EventServiceImpl implements EventService {

    private OntServiceImpl ont ;

    public Event createEvent(Event ev) {
        OntServiceImpl onts = getOnt() ;
        try {
            String aux = (ev.getUsername() + "_" + ev.getEventtype()) ;
            onts.createIndividual(ev.getEventtype(), aux);
            onts.addLiteralByProperty("has_Location", aux, ev.getLocation());
            onts.addLiteralByProperty("has_Subject_Domain", aux, ev.getSubjectDomain());
            onts.addLiteralByProperty("has_Event_Cost", aux, ev.getEventcost());
            onts.addLiteralByProperty("has_Event_Starting_Time", aux, new AbstractDateTime(ev.getEventstartingtime()));
            onts.addLiteralByProperty("has_Event_Ending_Time", aux, new AbstractDateTime(ev.getEventendingtime()));
        } catch (IOException ex) {
            Logger.getLogger(EventServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(EventServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EventServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ev ;
    }

    /**
     * @return the ont
     */
    public OntServiceImpl getOnt() {
        return new OntServiceImpl() ;
    }

    /**
     * @param ont the ont to set
     */
    public void setOnt(OntServiceImpl ont) {
        this.ont = ont;
    }
}
