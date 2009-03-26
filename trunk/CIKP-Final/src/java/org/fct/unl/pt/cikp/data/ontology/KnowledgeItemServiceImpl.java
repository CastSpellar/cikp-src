package org.fct.unl.pt.cikp.data.ontology;

import com.hp.hpl.jena.datatypes.xsd.AbstractDateTime;
import java.io.IOException;
import java.util.ArrayList;
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
            String kikey = ki.getName() + "_" + ki.getKnowledge_item_author();
            onts.createIndividual(ki.getKnowledge_item_type(), kikey);
            onts.addLiteralByProperty("has_Knowledge_Item_Author", kikey, ki.getKnowledge_item_author());
            onts.addLiteralByProperty("has_Knowledge_Item_Composition_Language", kikey, ki.getKnowledge_item_composition_language());
            onts.addLiteralByProperty("has_Knowledge_Item_Copyright_Owner", kikey, ki.getKnowledge_item_copyright_owner());
            onts.addLiteralByProperty("has_Knowledge_Item_Creation_Date", kikey, new AbstractDateTime(ki.getKnowledge_item_creation_date()));
            onts.addLiteralByProperty("has_Knowledge_Item_Creation_Time", kikey, new AbstractDateTime(ki.getKnowledge_item_creation_time()));
            onts.addLiteralByProperty("has_Knowledge_Item_Destination", kikey, ki.getKnowledge_item_destination());
            onts.addLiteralByProperty("has_Knowledge_Item_File_Size", kikey, ki.getKnowledge_item_file_size());
            onts.addLiteralByProperty("has_Knowledge_Item_File_Type", kikey, ki.getKnowledge_item_file_type());
            if (!ki.getKnowledge_item_keyword().isEmpty()) {
                Iterator iter = ki.getKnowledge_item_keyword().iterator();
                while (iter.hasNext()) {
                    onts.addLiteralByProperty("has_Knowledge_Item_Keyword", kikey, iter.next());
                }
            }
            onts.addLiteralByProperty("has_Name", kikey, ki.getName());
            onts.addLiteralByProperty("has_Knowledge_Item_Security_Clearance", kikey, ki.getKnowledge_item_security_clearance());
            onts.addLiteralByProperty("has_Knowledge_Item_Source", kikey, ki.getKnowledge_item_source());
            onts.addLiteralByProperty("has_Subject_Domain", kikey, ki.getSubject_domain());
            onts.addLiteralByProperty("has_Knowledge_Item_Type", kikey, ki.getKnowledge_item_type());
            onts.addLiteralByProperty("has_Event_Affiliation", kikey, ki.getEvent_affiliation());
            onts.addLiteralByProperty("has_Geographic_Affiliation", kikey, ki.getGeographic_affiliation());
            onts.addLiteralByProperty("has_Product_Affiliation", kikey, ki.getProduct_affiliation());
            onts.addLiteralByProperty("has_Project_Affiliation", kikey, ki.getProject_affiliation());
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

    public KnowledgeItem getKnowledgeItem(String entityname) {
        OntService onts = getOnt() ;
        KnowledgeItem item = new KnowledgeItem() ;
        try {
            item.setEvent_affiliation((String) onts.getLiteralByProperty(entityname, "has_Event_Affiliation"));
            item.setGeographic_affiliation((String)onts.getLiteralByProperty(entityname, "has_Geographic_Affiliation"));
            item.setKnowledge_item_author((String)onts.getLiteralByProperty(entityname, "has_Knowledge_Item_Author"));
            item.setKnowledge_item_composition_language((String)onts.getLiteralByProperty(entityname, "has_Knowledge_Item_Composition_Language"));
            item.setKnowledge_item_copyright_owner((String)onts.getLiteralByProperty(entityname, "has_Knowledge_Item_Copyright_Owner"));
            item.setKnowledge_item_creation_date((String)onts.getLiteralByProperty(entityname, "has_Knowledge_Item_Creation_Date"));
            item.setKnowledge_item_creation_time((String)onts.getLiteralByProperty(entityname, "has_Knowledge_Item_Creation_Time"));
            item.setKnowledge_item_destination((String)onts.getLiteralByProperty(entityname, "has_Knowledge_Item_Destination"));
            item.setKnowledge_item_file_size((Integer)onts.getLiteralByProperty(entityname, "has_Knowledge_Item_File_Size"));
            item.setKnowledge_item_file_type((String)onts.getLiteralByProperty(entityname, "has_Knowledge_Item_File_Type"));
            ArrayList<String> list = new ArrayList<String>() ;
            while(onts.getLiteralByProperty(entityname, "has_Knowledge_Item_Keyword") != null) {
                list.add((String)onts.getLiteralByProperty(entityname, "has_Knowledge_Item_Keyword"));
            }
            item.setKnowledge_item_keyword(list);
            item.setKnowledge_item_security_clearance((String)onts.getLiteralByProperty(entityname, "has_Knowledge_Item_Security_Clearance"));
            item.setKnowledge_item_source((String)onts.getLiteralByProperty(entityname, "has_Knowledge_Item_Source"));
            item.setKnowledge_item_type((String)onts.getLiteralByProperty(entityname, "has_Knowledge_Item_Type"));
            item.setName((String)onts.getLiteralByProperty(entityname, "has_Name"));
            item.setProduct_affiliation((String)onts.getLiteralByProperty(entityname, "has_Product_Affiliation"));
            item.setProject_affiliation((String)onts.getLiteralByProperty(entityname, "has_Project_Affiliation"));
            item.setSubject_domain((String)onts.getLiteralByProperty(entityname, "has_Subject_Domain"));
        } catch (IOException ex) {
            Logger.getLogger(KnowledgeItemServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MissingParamException ex) {
            Logger.getLogger(KnowledgeItemServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KnowledgeItemServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return item ;
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
