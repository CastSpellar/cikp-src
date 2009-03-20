package org.fct.unl.pt.cikp.data.ontology;

import com.hp.hpl.jena.datatypes.xsd.AbstractDateTime;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.fct.unl.pt.cikp.service.ontology.OntService;
import org.fct.unl.pt.cikp.service.ontology.OntServiceImpl;
import org.fct.unl.pt.cikp.service.ontology.manager.exceptions.MissingParamException;

/**
 *
 * @author Paulo Figueiras
 */

public class KnowledgeItemServiceImpl implements  KnowledgeItemService{

    private OntService ont ;

    public KnowledgeItem createKnowledgeItem(KnowledgeItem ki) {
        try {
            OntService onts = getOnt();
            String kikey = ki.getAuthor() + "_" + ki.getName();
            onts.createIndividual(ki.getType(), kikey);
            onts.addLiteralByProperty("has_Knowledge_Item_Author", kikey, ki.getAuthor());
            onts.addLiteralByProperty("has_Knowledge_Item_Composition_Language", kikey, ki.getComplanguage());
            onts.addLiteralByProperty("has_Knowledge_Item_Copyright_Owner", kikey, ki.getCopyrightowner());
            onts.addLiteralByProperty("has_Knowledge_Item_Creation_Date", kikey, new AbstractDateTime(ki.getCreationdate()));
            onts.addLiteralByProperty("has_Knowledge_Item_Creation_Time", kikey, new AbstractDateTime(ki.getCreationtime()));
            onts.addLiteralByProperty("has_Knowledge_Item_Destination", kikey, ki.getDestination());
            onts.addLiteralByProperty("has_Knowledge_Item_File_Size", kikey, ki.getFilesize());
            onts.addLiteralByProperty("has_Knowledge_Item_File_Type", kikey, ki.getFiletype());
            if (!ki.getKeywords().isEmpty()) {
                Iterator iter = ki.getKeywords().iterator();
                while (iter.hasNext()) {
                    onts.addLiteralByProperty("has_Knowledge_Item_Keyword", kikey, iter.next());
                }
            }
            onts.addLiteralByProperty("has_Name", kikey, ki.getName());
            onts.addLiteralByProperty("has_Knowledge_Item_Security_Clearance", kikey, ki.getSecurityclearance());
            onts.addLiteralByProperty("has_Knowledge_Item_Source", kikey, ki.getSource());
            onts.addLiteralByProperty("has_Subject_Domain", kikey, ki.getSubjectdom());
            onts.addLiteralByProperty("has_Knowledge_Item_Type", kikey, ki.getType());
            onts.addLiteralByProperty("has_Event_Affiliation", kikey, ki.getEventaffiliation());
            onts.addLiteralByProperty("has_Geographic_Affiliation", kikey, ki.getGeoaffiliation());
            onts.addLiteralByProperty("has_Product_Affiliation", kikey, ki.getProdaffiliation());
            onts.addLiteralByProperty("has_Project_Affiliation", kikey, ki.getProjectaffiliation());
            return ki;
        } catch (IOException ex) {
            Logger.getLogger(KnowledgeItemServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null ;
        } catch (MissingParamException ex) {
            Logger.getLogger(KnowledgeItemServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null ;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KnowledgeItemServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null ;
        }
    }

    /**
     * @return the ont
     */
    public OntService getOnt() {
        return new OntServiceImpl() ;
    }

    /**
     * @param ont the ont to set
     */
    public void setOnt(OntService ont) {
        this.ont = ont;
    }
}
