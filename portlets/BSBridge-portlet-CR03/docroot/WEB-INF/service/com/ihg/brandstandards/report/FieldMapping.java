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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fieldMapping complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fieldMapping">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="xls_column_name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="xls_column_width" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="class_field_name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="return_entries" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="default_value_from" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="field_type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="show_translation" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fieldMapping")
public class FieldMapping {

    @XmlAttribute(name = "xls_column_name", required = true)
    protected String xlsColumnName;
    @XmlAttribute(name = "xls_column_width", required = true)
    protected int xlsColumnWidth;
    @XmlAttribute(name = "class_field_name", required = true)
    protected String classFieldName;
    @XmlAttribute(name = "return_entries")
    protected String returnEntries;
    @XmlAttribute(name = "default_value_from")
    protected String defaultValueFrom;
    @XmlAttribute(name = "field_type")
    protected String fieldType;
    @XmlAttribute
    protected Long value;
    @XmlAttribute(name = "show_translation")
    protected Boolean showTranslation;

    /**
     * Gets the value of the xlsColumnName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXlsColumnName() {
        return xlsColumnName;
    }

    /**
     * Sets the value of the xlsColumnName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXlsColumnName(String value) {
        this.xlsColumnName = value;
    }

    /**
     * Gets the value of the xlsColumnWidth property.
     * 
     */
    public int getXlsColumnWidth() {
        return xlsColumnWidth;
    }

    /**
     * Sets the value of the xlsColumnWidth property.
     * 
     */
    public void setXlsColumnWidth(int value) {
        this.xlsColumnWidth = value;
    }

    /**
     * Gets the value of the classFieldName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassFieldName() {
        return classFieldName;
    }

    /**
     * Sets the value of the classFieldName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassFieldName(String value) {
        this.classFieldName = value;
    }

    /**
     * Gets the value of the returnEntries property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnEntries() {
        return returnEntries;
    }

    /**
     * Sets the value of the returnEntries property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnEntries(String value) {
        this.returnEntries = value;
    }

    /**
     * Gets the value of the defaultValueFrom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultValueFrom() {
        return defaultValueFrom;
    }

    /**
     * Sets the value of the defaultValueFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultValueFrom(String value) {
        this.defaultValueFrom = value;
    }

    /**
     * Gets the value of the fieldType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldType() {
        return fieldType;
    }

    /**
     * Sets the value of the fieldType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldType(String value) {
        this.fieldType = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setValue(Long value) {
        this.value = value;
    }

    /**
     * Gets the value of the showTranslation property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isShowTranslation() {
        if (showTranslation == null) {
            return false;
        } else {
            return showTranslation;
        }
    }

    /**
     * Sets the value of the showTranslation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowTranslation(Boolean value) {
        this.showTranslation = value;
    }

}
