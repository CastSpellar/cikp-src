/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class EventServiceImpl implements EventService {

    private OntServiceImpl ont ;

    public Event createEvent(Event ev) {
        OntServiceImpl onts = getOnt() ;
        try {
            String aux = (ev.getEventtype() + "_" + ev.getUsername()) ;
            onts.createIndividual(ev.getEventtype(), aux);
            onts.addLiteralByProperty("has_Location", aux, ev.getEvent_location());
            onts.addLiteralByProperty("has_Subject_Domain", aux, ev.getEvent_subject_domain());
            onts.addLiteralByProperty("has_Event_Cost", aux, ev.getEvent_cost());
            onts.addLiteralByProperty("has_Event_Starting_Time", aux, ev.getEvent_starting_time());
            onts.addLiteralByProperty("has_Event_Ending_Time", aux, ev.getEvent_ending_time());
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
