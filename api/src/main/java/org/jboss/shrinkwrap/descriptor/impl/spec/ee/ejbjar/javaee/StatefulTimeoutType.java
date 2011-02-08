//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.2-hudson-jaxb-ri-2.2-63- 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.02.07 at 11:30:48 AM GMT 
//


package org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 * 
 *         The stateful-timeoutType represents the amount of time
 *         a stateful session bean can be idle(not receive any client
 *         invocations) before it is eligible for removal by the container.
 *         
 *         A timeout value of 0 means the bean is immediately eligible for removal.
 *         
 *         A timeout value of -1 means the bean will never be removed due to timeout.
 *         
 *       
 * 
 * <p>Java class for stateful-timeoutType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="stateful-timeoutType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="timeout" type="{http://java.sun.com/xml/ns/javaee}xsdIntegerType"/>
 *         &lt;element name="unit" type="{http://java.sun.com/xml/ns/javaee}time-unit-typeType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stateful-timeoutType", propOrder = {
    "timeout",
    "unit"
})
public class StatefulTimeoutType {

    @XmlElement(required = true)
    protected XsdIntegerType timeout;
    @XmlElement(required = true)
    protected TimeUnitTypeType unit;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected java.lang.String id;

    /**
     * Gets the value of the timeout property.
     * 
     * @return
     *     possible object is
     *     {@link XsdIntegerType }
     *     
     */
    public XsdIntegerType getTimeout() {
        return timeout;
    }

    /**
     * Sets the value of the timeout property.
     * 
     * @param value
     *     allowed object is
     *     {@link XsdIntegerType }
     *     
     */
    public void setTimeout(XsdIntegerType value) {
        this.timeout = value;
    }

    /**
     * Gets the value of the unit property.
     * 
     * @return
     *     possible object is
     *     {@link TimeUnitTypeType }
     *     
     */
    public TimeUnitTypeType getUnit() {
        return unit;
    }

    /**
     * Sets the value of the unit property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeUnitTypeType }
     *     
     */
    public void setUnit(TimeUnitTypeType value) {
        this.unit = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setId(java.lang.String value) {
        this.id = value;
    }

}