//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.2-hudson-jaxb-ri-2.2-63- 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.02.07 at 11:30:48 AM GMT 
//


package org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 
 * 
 *         The timerType specifies an enterprise bean timer.  Each
 *         timer is automatically created by the container upon
 *         deployment.  Timer callbacks occur based on the 
 *         schedule attributes.  All callbacks are made to the
 *         timeout-method associated with the timer.  
 *         
 *         A timer can have an optional start and/or end date. If
 *         a start date is specified, it takes precedence over the
 *         associated timer schedule such that any matching
 *         expirations prior to the start time will not occur.
 *         Likewise, no matching expirations will occur after any
 *         end date.   Start/End dates are specified using the
 *         XML Schema dateTime type, which follows the ISO-8601
 *         standard for date(and optional time-within-the-day) 
 *         representation.
 *         
 *         An optional flag can be used to control whether
 *         this timer has persistent(true) delivery semantics or
 *         non-persistent(false) delivery semantics.  If not specified,
 *         the value defaults to persistent(true).
 *         
 *         A time zone can optionally be associated with a timer.
 *         If specified, the timer's schedule is evaluated in the context
 *         of that time zone, regardless of the default time zone in which
 *         the container is executing.   Time zones are specified as an
 *         ID string.  The set of required time zone IDs is defined by
 *         the Zone Name(TZ) column of the public domain zoneinfo database.
 *         
 *         An optional info string can be assigned to the timer and 
 *         retrieved at runtime through the Timer.getInfo() method.
 *         
 *         The timerType can only be specified on stateless session
 *         beans, singleton session beans, and message-driven beans.
 *         
 *       
 * 
 * <p>Java class for timerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="timerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://java.sun.com/xml/ns/javaee}descriptionType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="schedule" type="{http://java.sun.com/xml/ns/javaee}timer-scheduleType"/>
 *         &lt;element name="start" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="end" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="timeout-method" type="{http://java.sun.com/xml/ns/javaee}named-methodType"/>
 *         &lt;element name="persistent" type="{http://java.sun.com/xml/ns/javaee}true-falseType" minOccurs="0"/>
 *         &lt;element name="timezone" type="{http://java.sun.com/xml/ns/javaee}string" minOccurs="0"/>
 *         &lt;element name="info" type="{http://java.sun.com/xml/ns/javaee}string" minOccurs="0"/>
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
@XmlType(name = "timerType", propOrder = {
    "description",
    "schedule",
    "start",
    "end",
    "timeoutMethod",
    "persistent",
    "timezone",
    "info"
})
public class TimerType {

    protected List<DescriptionType> description;
    @XmlElement(required = true)
    protected TimerScheduleType schedule;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar start;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar end;
    @XmlElement(name = "timeout-method", required = true)
    protected NamedMethodType timeoutMethod;
    protected TrueFalseType persistent;
    protected org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.String timezone;
    protected org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.String info;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected java.lang.String id;

    /**
     * Gets the value of the description property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the description property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DescriptionType }
     * 
     * 
     */
    public List<DescriptionType> getDescription() {
        if (description == null) {
            description = new ArrayList<DescriptionType>();
        }
        return this.description;
    }

    /**
     * Gets the value of the schedule property.
     * 
     * @return
     *     possible object is
     *     {@link TimerScheduleType }
     *     
     */
    public TimerScheduleType getSchedule() {
        return schedule;
    }

    /**
     * Sets the value of the schedule property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimerScheduleType }
     *     
     */
    public void setSchedule(TimerScheduleType value) {
        this.schedule = value;
    }

    /**
     * Gets the value of the start property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStart(XMLGregorianCalendar value) {
        this.start = value;
    }

    /**
     * Gets the value of the end property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEnd() {
        return end;
    }

    /**
     * Sets the value of the end property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEnd(XMLGregorianCalendar value) {
        this.end = value;
    }

    /**
     * Gets the value of the timeoutMethod property.
     * 
     * @return
     *     possible object is
     *     {@link NamedMethodType }
     *     
     */
    public NamedMethodType getTimeoutMethod() {
        return timeoutMethod;
    }

    /**
     * Sets the value of the timeoutMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link NamedMethodType }
     *     
     */
    public void setTimeoutMethod(NamedMethodType value) {
        this.timeoutMethod = value;
    }

    /**
     * Gets the value of the persistent property.
     * 
     * @return
     *     possible object is
     *     {@link TrueFalseType }
     *     
     */
    public TrueFalseType getPersistent() {
        return persistent;
    }

    /**
     * Sets the value of the persistent property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrueFalseType }
     *     
     */
    public void setPersistent(TrueFalseType value) {
        this.persistent = value;
    }

    /**
     * Gets the value of the timezone property.
     * 
     * @return
     *     possible object is
     *     {@link org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.String }
     *     
     */
    public org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.String getTimezone() {
        return timezone;
    }

    /**
     * Sets the value of the timezone property.
     * 
     * @param value
     *     allowed object is
     *     {@link org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.String }
     *     
     */
    public void setTimezone(org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.String value) {
        this.timezone = value;
    }

    /**
     * Gets the value of the info property.
     * 
     * @return
     *     possible object is
     *     {@link org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.String }
     *     
     */
    public org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.String getInfo() {
        return info;
    }

    /**
     * Sets the value of the info property.
     * 
     * @param value
     *     allowed object is
     *     {@link org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.String }
     *     
     */
    public void setInfo(org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.String value) {
        this.info = value;
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
