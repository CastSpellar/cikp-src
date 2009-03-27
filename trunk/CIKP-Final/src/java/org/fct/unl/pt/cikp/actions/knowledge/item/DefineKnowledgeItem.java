/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fct.unl.pt.cikp.actions.knowledge.item;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.io.File;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import org.fct.unl.pt.cikp.data.ontology.KnowledgeItem;
import org.fct.unl.pt.cikp.service.CikpService;
import org.fct.unl.pt.cikp.service.CikpServiceImpl;
import org.fct.unl.pt.cikp.data.portal.KnowledgeItemPortal;

/**
 *
 * @author Figueiras
 */
public class DefineKnowledgeItem extends ActionSupport implements SessionAware, ModelDriven<KnowledgeItem> {

    private CikpService cikpService ;

    private String uploadFileName ;
    private File file ;
    private KnowledgeItem knowledge_item = new KnowledgeItem() ;

    private Map session ;

    @Override
    public String execute() throws Exception {
        getCikpService().createKnowledgeItem(knowledge_item) ;
        KnowledgeItemPortal kip = new KnowledgeItemPortal() ;
        kip.setKnowledgeItemType(knowledge_item.getKnowledge_item_type()) ;
        kip.setKnowledgeItemFileType(knowledge_item.getKnowledge_item_file_type());
        return SUCCESS ;
    }

    public void setSession(Map arg0) {
        this.session = arg0;
    }

    /**
     * @return the cikpService
     */
    public CikpService getCikpService() {
        return new CikpServiceImpl();
    }

    /**
     * @param cikpService the cikpService to set
     */
    public void setCikpService(CikpService cikpService) {
        this.cikpService = cikpService;
    }

    /**
     * @return the uploadFileName
     */
    public String getUploadFileName() {
        return uploadFileName;
    }

    /**
     * @param uploadFileName the uploadFileName to set
     */
    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    /**
     * @return the file
     */
    public File getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(File file) {
        this.file = file;
    }

    public KnowledgeItem getModel() {
        return knowledge_item ;
    }
}
