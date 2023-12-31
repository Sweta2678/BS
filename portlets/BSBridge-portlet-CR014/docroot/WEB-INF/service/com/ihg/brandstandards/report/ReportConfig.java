//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.16 at 01:06:10 PM EST 
//


package com.ihg.brandstandards.report;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for reportConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="reportConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}index"/>
 *         &lt;element ref="{}record"/>
 *         &lt;element name="selectClause" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="table" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="whereClause" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="secLanguage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="active" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="feature" type="{http://www.w3.org/2001/XMLSchema}string" default="StandardAdmin" />
 *       &lt;attribute name="qualifier" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="requireSecondLang" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="report_type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reportConfig", propOrder = {
    "index",
    "record",
    "selectClause",
    "table",
    "whereClause",
    "secLanguage"
})
public class ReportConfig {

    @XmlElement(required = true)
    protected IndexConfig index;
    @XmlElement(required = true)
    protected RecordConfig record;
    protected String selectClause;
    protected String table;
    protected String whereClause;
    @XmlElement(required = true)
    protected String secLanguage;
    @XmlAttribute(required = true)
    protected String id;
    @XmlAttribute(required = true)
    protected String name;
    @XmlAttribute(required = true)
    protected boolean active;
    @XmlAttribute
    protected String feature;
    @XmlAttribute
    protected String qualifier;
    @XmlAttribute
    protected Boolean requireSecondLang;
    @XmlAttribute(name = "report_type")
    protected String reportType;

    /**
     * Gets the value of the index property.
     * 
     * @return
     *     possible object is
     *     {@link IndexConfig }
     *     
     */
    public IndexConfig getIndex() {
        return index;
    }

    /**
     * Sets the value of the index property.
     * 
     * @param value
     *     allowed object is
     *     {@link IndexConfig }
     *     
     */
    public void setIndex(IndexConfig value) {
        this.index = value;
    }

    /**
     * Gets the value of the record property.
     * 
     * @return
     *     possible object is
     *     {@link RecordConfig }
     *     
     */
    public RecordConfig getRecord() {
        return record;
    }

    /**
     * Sets the value of the record property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecordConfig }
     *     
     */
    public void setRecord(RecordConfig value) {
        this.record = value;
    }

    /**
     * Gets the value of the selectClause property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSelectClause() {
        return selectClause;
    }

    /**
     * Sets the value of the selectClause property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSelectClause(String value) {
        this.selectClause = value;
    }

    /**
     * Gets the value of the table property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTable() {
        return table;
    }

    /**
     * Sets the value of the table property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTable(String value) {
        this.table = value;
    }

    /**
     * Gets the value of the whereClause property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWhereClause() {
        return whereClause;
    }

    /**
     * Sets the value of the whereClause property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWhereClause(String value) {
        this.whereClause = value;
    }

    /**
     * Gets the value of the secLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecLanguage() {
        return secLanguage;
    }

    /**
     * Sets the value of the secLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecLanguage(String value) {
        this.secLanguage = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the active property.
     * 
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     * 
     */
    public void setActive(boolean value) {
        this.active = value;
    }

    /**
     * Gets the value of the feature property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeature() {
        if (feature == null) {
            return "StandardAdmin";
        } else {
            return feature;
        }
    }

    /**
     * Sets the value of the feature property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeature(String value) {
        this.feature = value;
    }

    /**
     * Gets the value of the qualifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQualifier() {
        return qualifier;
    }

    /**
     * Sets the value of the qualifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQualifier(String value) {
        this.qualifier = value;
    }

    /**
     * Gets the value of the requireSecondLang property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isRequireSecondLang() {
        if (requireSecondLang == null) {
            return false;
        } else {
            return requireSecondLang;
        }
    }

    /**
     * Sets the value of the requireSecondLang property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRequireSecondLang(Boolean value) {
        this.requireSecondLang = value;
    }

    /**
     * Gets the value of the reportType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportType() {
        return reportType;
    }

    /**
     * Sets the value of the reportType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportType(String value) {
        this.reportType = value;
    }

}
