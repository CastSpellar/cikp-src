package org.fct.unl.pt.cikp.data.portal;
// Generated 29/Mar/2009 7:11:13 by Hibernate Tools 3.2.1.GA


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
 * KnowledgeItemPortal generated by hbm2java
 */
@Entity
@Table(name="knowledge_item_portal"
    ,catalog="cikp"
)
public class KnowledgeItemPortal  implements java.io.Serializable {


     private Integer knowledgeItemId;
     private UserPortal userPortal;
     private FilePortal filePortal;
     private String name;
     private int knowledgeItemFileSize;
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
     private Set<KeywordPortal> keywordPortals = new HashSet<KeywordPortal>(0);
     private Set<SubscriptionPortal> subscriptionPortals = new HashSet<SubscriptionPortal>(0);

    public KnowledgeItemPortal() {
    }

	
    public KnowledgeItemPortal(UserPortal userPortal, FilePortal filePortal, String name, int knowledgeItemFileSize, Date knowledgeItemCreationTime, Date knowledgeItemCreationDate, String knowledgeItemAuthor, String knowledgeItemFileType, String knowledgeItemType) {
        this.userPortal = userPortal;
        this.filePortal = filePortal;
        this.name = name;
        this.knowledgeItemFileSize = knowledgeItemFileSize;
        this.knowledgeItemCreationTime = knowledgeItemCreationTime;
        this.knowledgeItemCreationDate = knowledgeItemCreationDate;
        this.knowledgeItemAuthor = knowledgeItemAuthor;
        this.knowledgeItemFileType = knowledgeItemFileType;
        this.knowledgeItemType = knowledgeItemType;
    }
    public KnowledgeItemPortal(UserPortal userPortal, FilePortal filePortal, String name, int knowledgeItemFileSize, Date knowledgeItemCreationTime, Date knowledgeItemCreationDate, String knowledgeItemAuthor, String knowledgeItemCompositionLanguage, String knowledgeItemCopyrightOwner, String knowledgeItemDestination, String knowledgeItemFileType, String knowledgeItemSecurityClearance, String knowledgeItemSource, String knowledgeItemType, String subjectDomain, Set<KeywordPortal> keywordPortals, Set<SubscriptionPortal> subscriptionPortals) {
       this.userPortal = userPortal;
       this.filePortal = filePortal;
       this.name = name;
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
       this.keywordPortals = keywordPortals;
       this.subscriptionPortals = subscriptionPortals;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="Knowledge_Item_ID", unique=true, nullable=false)
    public Integer getKnowledgeItemId() {
        return this.knowledgeItemId;
    }
    
    public void setKnowledgeItemId(Integer knowledgeItemId) {
        this.knowledgeItemId = knowledgeItemId;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="User_ID", nullable=false)
    public UserPortal getUserPortal() {
        return this.userPortal;
    }
    
    public void setUserPortal(UserPortal userPortal) {
        this.userPortal = userPortal;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="File_ID", nullable=false)
    public FilePortal getFilePortal() {
        return this.filePortal;
    }
    
    public void setFilePortal(FilePortal filePortal) {
        this.filePortal = filePortal;
    }
    
    @Column(name="Name", nullable=false)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="Knowledge_Item_File_Size", nullable=false)
    public int getKnowledgeItemFileSize() {
        return this.knowledgeItemFileSize;
    }
    
    public void setKnowledgeItemFileSize(int knowledgeItemFileSize) {
        this.knowledgeItemFileSize = knowledgeItemFileSize;
    }
    @Temporal(TemporalType.TIME)
    @Column(name="Knowledge_Item_Creation_Time", nullable=false, length=8)
    public Date getKnowledgeItemCreationTime() {
        return this.knowledgeItemCreationTime;
    }
    
    public void setKnowledgeItemCreationTime(Date knowledgeItemCreationTime) {
        this.knowledgeItemCreationTime = knowledgeItemCreationTime;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="Knowledge_Item_Creation_Date", nullable=false, length=10)
    public Date getKnowledgeItemCreationDate() {
        return this.knowledgeItemCreationDate;
    }
    
    public void setKnowledgeItemCreationDate(Date knowledgeItemCreationDate) {
        this.knowledgeItemCreationDate = knowledgeItemCreationDate;
    }
    
    @Column(name="Knowledge_Item_Author", nullable=false, length=20)
    public String getKnowledgeItemAuthor() {
        return this.knowledgeItemAuthor;
    }
    
    public void setKnowledgeItemAuthor(String knowledgeItemAuthor) {
        this.knowledgeItemAuthor = knowledgeItemAuthor;
    }
    
    @Column(name="Knowledge_Item_Composition_Language", length=20)
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
    
    @Column(name="Knowledge_Item_File_Type", nullable=false, length=50)
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
    
    @Column(name="Knowledge_Item_Type", nullable=false, length=100)
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
@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinTable(name="knowledge_item_keyword_portal", catalog="cikp", joinColumns = { 
        @JoinColumn(name="Knowledge_Item_ID", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="Keyword_ID", nullable=false, updatable=false) })
    public Set<KeywordPortal> getKeywordPortals() {
        return this.keywordPortals;
    }
    
    public void setKeywordPortals(Set<KeywordPortal> keywordPortals) {
        this.keywordPortals = keywordPortals;
    }
@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinTable(name="knowledge_item_subscription_portal", catalog="cikp", joinColumns = { 
        @JoinColumn(name="Knowledge_Item_ID", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="Subscription_ID", nullable=false, updatable=false) })
    public Set<SubscriptionPortal> getSubscriptionPortals() {
        return this.subscriptionPortals;
    }
    
    public void setSubscriptionPortals(Set<SubscriptionPortal> subscriptionPortals) {
        this.subscriptionPortals = subscriptionPortals;
    }




}


