package org.fct.unl.pt.cikp.data.portal;
// Generated 2/Abr/2009 23:48:37 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SubscriptionPortal generated by hbm2java
 */
@Entity
@Table(name="subscription_portal"
    ,catalog="cikp"
)
public class SubscriptionPortal  implements java.io.Serializable {


     private Integer subscriptionId;
     private UserPortal userPortal;
     private String knowledgeItemFileName;
     private Integer knowledgeItemFileSize;
     private Date knowledgeItemCreationTime;
     private Date knowledgeItemCreationDate;
     private String knowledgeItemAuthor;
     private String knowledgeItemCompositionLanguage;
     private String knowledgeItemCopyrightOwner;
     private String knowledgeItemDestination;
     private String knowledgeItemFileType;
     private String knowledgeItemSecurityClearance;
     private String knowledgeItemSource;
     private String knowledgeItemType;
     private String subjectDomain;
     private Set<KnowledgeItemPortal> knowledgeItemPortals = new HashSet<KnowledgeItemPortal>(0);
     private Set<KeywordPortal> keywordPortals = new HashSet<KeywordPortal>(0);

    public SubscriptionPortal() {
    }

	
    public SubscriptionPortal(UserPortal userPortal) {
        this.userPortal = userPortal;
    }
    public SubscriptionPortal(UserPortal userPortal, String knowledgeItemFileName, Integer knowledgeItemFileSize, Date knowledgeItemCreationTime, Date knowledgeItemCreationDate, String knowledgeItemAuthor, String knowledgeItemCompositionLanguage, String knowledgeItemCopyrightOwner, String knowledgeItemDestination, String knowledgeItemFileType, String knowledgeItemSecurityClearance, String knowledgeItemSource, String knowledgeItemType, String subjectDomain, Set<KnowledgeItemPortal> knowledgeItemPortals, Set<KeywordPortal> keywordPortals) {
       this.userPortal = userPortal;
       this.knowledgeItemFileName = knowledgeItemFileName;
       this.knowledgeItemFileSize = knowledgeItemFileSize;
       this.knowledgeItemCreationTime = knowledgeItemCreationTime;
       this.knowledgeItemCreationDate = knowledgeItemCreationDate;
       this.knowledgeItemAuthor = knowledgeItemAuthor;
       this.knowledgeItemCompositionLanguage = knowledgeItemCompositionLanguage;
       this.knowledgeItemCopyrightOwner = knowledgeItemCopyrightOwner;
       this.knowledgeItemDestination = knowledgeItemDestination;
       this.knowledgeItemFileType = knowledgeItemFileType;
       this.knowledgeItemSecurityClearance = knowledgeItemSecurityClearance;
       this.knowledgeItemSource = knowledgeItemSource;
       this.knowledgeItemType = knowledgeItemType;
       this.subjectDomain = subjectDomain;
       this.knowledgeItemPortals = knowledgeItemPortals;
       this.keywordPortals = keywordPortals;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="Subscription_ID", unique=true, nullable=false)
    public Integer getSubscriptionId() {
        return this.subscriptionId;
    }
    
    public void setSubscriptionId(Integer subscriptionId) {
        this.subscriptionId = subscriptionId;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    public UserPortal getUserPortal() {
        return this.userPortal;
    }
    
    public void setUserPortal(UserPortal userPortal) {
        this.userPortal = userPortal;
    }
    
    @Column(name="Knowledge_Item_File_Name", length=20)
    public String getKnowledgeItemFileName() {
        return this.knowledgeItemFileName;
    }
    
    public void setKnowledgeItemFileName(String knowledgeItemFileName) {
        this.knowledgeItemFileName = knowledgeItemFileName;
    }
    
    @Column(name="Knowledge_Item_File_Size")
    public Integer getKnowledgeItemFileSize() {
        return this.knowledgeItemFileSize;
    }
    
    public void setKnowledgeItemFileSize(Integer knowledgeItemFileSize) {
        this.knowledgeItemFileSize = knowledgeItemFileSize;
    }
    @Temporal(TemporalType.TIME)
    @Column(name="Knowledge_Item_Creation_Time", length=8)
    public Date getKnowledgeItemCreationTime() {
        return this.knowledgeItemCreationTime;
    }
    
    public void setKnowledgeItemCreationTime(Date knowledgeItemCreationTime) {
        this.knowledgeItemCreationTime = knowledgeItemCreationTime;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="Knowledge_Item_Creation_Date", length=10)
    public Date getKnowledgeItemCreationDate() {
        return this.knowledgeItemCreationDate;
    }
    
    public void setKnowledgeItemCreationDate(Date knowledgeItemCreationDate) {
        this.knowledgeItemCreationDate = knowledgeItemCreationDate;
    }
    
    @Column(name="Knowledge_Item_Author", length=200)
    public String getKnowledgeItemAuthor() {
        return this.knowledgeItemAuthor;
    }
    
    public void setKnowledgeItemAuthor(String knowledgeItemAuthor) {
        this.knowledgeItemAuthor = knowledgeItemAuthor;
    }
    
    @Column(name="Knowledge_Item_Composition_Language", length=100)
    public String getKnowledgeItemCompositionLanguage() {
        return this.knowledgeItemCompositionLanguage;
    }
    
    public void setKnowledgeItemCompositionLanguage(String knowledgeItemCompositionLanguage) {
        this.knowledgeItemCompositionLanguage = knowledgeItemCompositionLanguage;
    }
    
    @Column(name="Knowledge_Item_Copyright_Owner", length=200)
    public String getKnowledgeItemCopyrightOwner() {
        return this.knowledgeItemCopyrightOwner;
    }
    
    public void setKnowledgeItemCopyrightOwner(String knowledgeItemCopyrightOwner) {
        this.knowledgeItemCopyrightOwner = knowledgeItemCopyrightOwner;
    }
    
    @Column(name="Knowledge_Item_Destination", length=100)
    public String getKnowledgeItemDestination() {
        return this.knowledgeItemDestination;
    }
    
    public void setKnowledgeItemDestination(String knowledgeItemDestination) {
        this.knowledgeItemDestination = knowledgeItemDestination;
    }
    
    @Column(name="Knowledge_Item_File_Type", length=50)
    public String getKnowledgeItemFileType() {
        return this.knowledgeItemFileType;
    }
    
    public void setKnowledgeItemFileType(String knowledgeItemFileType) {
        this.knowledgeItemFileType = knowledgeItemFileType;
    }
    
    @Column(name="Knowledge_Item_Security_Clearance", length=100)
    public String getKnowledgeItemSecurityClearance() {
        return this.knowledgeItemSecurityClearance;
    }
    
    public void setKnowledgeItemSecurityClearance(String knowledgeItemSecurityClearance) {
        this.knowledgeItemSecurityClearance = knowledgeItemSecurityClearance;
    }
    
    @Column(name="Knowledge_Item_Source", length=20)
    public String getKnowledgeItemSource() {
        return this.knowledgeItemSource;
    }
    
    public void setKnowledgeItemSource(String knowledgeItemSource) {
        this.knowledgeItemSource = knowledgeItemSource;
    }
    
    @Column(name="Knowledge_Item_Type", length=100)
    public String getKnowledgeItemType() {
        return this.knowledgeItemType;
    }
    
    public void setKnowledgeItemType(String knowledgeItemType) {
        this.knowledgeItemType = knowledgeItemType;
    }
    
    @Column(name="Subject_Domain", length=100)
    public String getSubjectDomain() {
        return this.subjectDomain;
    }
    
    public void setSubjectDomain(String subjectDomain) {
        this.subjectDomain = subjectDomain;
    }
@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="subscriptionPortals")
    public Set<KnowledgeItemPortal> getKnowledgeItemPortals() {
        return this.knowledgeItemPortals;
    }
    
    public void setKnowledgeItemPortals(Set<KnowledgeItemPortal> knowledgeItemPortals) {
        this.knowledgeItemPortals = knowledgeItemPortals;
    }
@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinTable(name="subscription_keyword_portal", catalog="cikp", joinColumns = { 
        @JoinColumn(name="Subscription_ID", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="Keyword_ID", nullable=false, updatable=false) })
    public Set<KeywordPortal> getKeywordPortals() {
        return this.keywordPortals;
    }
    
    public void setKeywordPortals(Set<KeywordPortal> keywordPortals) {
        this.keywordPortals = keywordPortals;
    }




}


