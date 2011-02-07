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


/**
 * 
 *         [
 *         The interceptor-bindingType element describes the binding of
 *         interceptor classes to beans within the ejb-jar or .war.
 *         It consists of :
 *         
 *         - An optional description.
 *         - The name of an ejb within the module or the wildcard value "*",
 *         which is used to define interceptors that are bound to all
 *         beans in the ejb-jar or .war.
 *         - A list of interceptor classes that are bound to the contents of
 *         the ejb-name element or a specification of the total ordering
 *         over the interceptors defined for the given level and above.
 *         - An optional exclude-default-interceptors element.  If set to true,
 *         specifies that default interceptors are not to be applied to 
 *         a bean-class and/or business method.
 *         - An optional exclude-class-interceptors element.  If set to true,
 *         specifies that class interceptors are not to be applied to 
 *         a business method.
 *         - An optional set of method elements for describing the name/params
 *         of a method-level interceptor.
 *         
 *         Interceptors bound to all classes using the wildcard syntax
 *         "*" are default interceptors for the components in the ejb-jar or .war. 
 *         In addition, interceptors may be bound at the level of the bean
 *         class (class-level interceptors) or business methods (method-level
 *         interceptors ).
 *         
 *         The binding of interceptors to classes is additive.  If interceptors
 *         are bound at the class-level and/or default-level as well as the
 *         method-level, both class-level and/or default-level as well as
 *         method-level will apply. 
 *         
 *         There are four possible styles of the interceptor element syntax :
 *         
 *         1.
 *         <interceptor-binding>
 *         <ejb-name>*</ejb-name>
 *         <interceptor-class>INTERCEPTOR</interceptor-class>
 *         </interceptor-binding>
 *         
 *         Specifying the ejb-name as the wildcard value "*" designates
 *         default interceptors (interceptors that apply to all session and
 *         message-driven beans contained in the ejb-jar or .war).
 *         
 *         2. 
 *         <interceptor-binding>
 *         <ejb-name>EJBNAME</ejb-name>
 *         <interceptor-class>INTERCEPTOR</interceptor-class>
 *         </interceptor-binding>
 *         
 *         This style is used to refer to interceptors associated with the
 *         specified enterprise bean(class-level interceptors).
 *         
 *         3. 
 *         <interceptor-binding>
 *         <ejb-name>EJBNAME</ejb-name>
 *         <interceptor-class>INTERCEPTOR</interceptor-class>
 *         <method>
 *         <method-name>METHOD</method-name>
 *         </method>
 *         </interceptor-binding>
 *         
 *         This style is used to associate a method-level interceptor with 
 *         the specified enterprise bean.  If there are multiple methods
 *         with the same overloaded name, the element of this style refers
 *         to all the methods with the overloaded name.  Method-level
 *         interceptors can only be associated with business methods of the
 *         bean class.   Note that the wildcard value "*" cannot be used
 *         to specify method-level interceptors.
 *         
 *         4. 
 *         <interceptor-binding>
 *         <ejb-name>EJBNAME</ejb-name>
 *         <interceptor-class>INTERCEPTOR</interceptor-class>
 *         <method>
 *         <method-name>METHOD</method-name>
 *         <method-params>
 *         <method-param>PARAM-1</method-param>
 *         <method-param>PARAM-2</method-param>
 *         ...
 *         <method-param>PARAM-N</method-param>
 *         </method-params>
 *         </method>
 *         </interceptor-binding>
 *         
 *         This style is used to associate a method-level interceptor with 
 *         the specified method of the specified enterprise bean.  This 
 *         style is used to refer to a single method within a set of methods
 *         with an overloaded name.  The values PARAM-1 through PARAM-N
 *         are the fully-qualified Java types of the method's input parameters
 *         (if the method has no input arguments, the method-params element
 *         contains no method-param elements). Arrays are specified by the
 *         array element's type, followed by one or more pair of square 
 *         brackets (e.g. int[][]).
 *         
 *         
 *       
 * 
 * <p>Java class for interceptor-bindingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="interceptor-bindingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://java.sun.com/xml/ns/javaee}descriptionType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ejb-name" type="{http://java.sun.com/xml/ns/javaee}string"/>
 *         &lt;choice>
 *           &lt;element name="interceptor-class" type="{http://java.sun.com/xml/ns/javaee}fully-qualified-classType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="interceptor-order" type="{http://java.sun.com/xml/ns/javaee}interceptor-orderType"/>
 *         &lt;/choice>
 *         &lt;element name="exclude-default-interceptors" type="{http://java.sun.com/xml/ns/javaee}true-falseType" minOccurs="0"/>
 *         &lt;element name="exclude-class-interceptors" type="{http://java.sun.com/xml/ns/javaee}true-falseType" minOccurs="0"/>
 *         &lt;element name="method" type="{http://java.sun.com/xml/ns/javaee}named-methodType" minOccurs="0"/>
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
@XmlType(name = "interceptor-bindingType", propOrder = {
    "description",
    "ejbName",
    "interceptorClass",
    "interceptorOrder",
    "excludeDefaultInterceptors",
    "excludeClassInterceptors",
    "method"
})
public class InterceptorBindingType {

    protected List<DescriptionType> description;
    @XmlElement(name = "ejb-name", required = true)
    protected org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.String ejbName;
    @XmlElement(name = "interceptor-class")
    protected List<FullyQualifiedClassType> interceptorClass;
    @XmlElement(name = "interceptor-order")
    protected InterceptorOrderType interceptorOrder;
    @XmlElement(name = "exclude-default-interceptors")
    protected TrueFalseType excludeDefaultInterceptors;
    @XmlElement(name = "exclude-class-interceptors")
    protected TrueFalseType excludeClassInterceptors;
    protected NamedMethodType method;
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
     * Gets the value of the ejbName property.
     * 
     * @return
     *     possible object is
     *     {@link org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.String }
     *     
     */
    public org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.String getEjbName() {
        return ejbName;
    }

    /**
     * Sets the value of the ejbName property.
     * 
     * @param value
     *     allowed object is
     *     {@link org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.String }
     *     
     */
    public void setEjbName(org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.String value) {
        this.ejbName = value;
    }

    /**
     * Gets the value of the interceptorClass property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the interceptorClass property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInterceptorClass().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FullyQualifiedClassType }
     * 
     * 
     */
    public List<FullyQualifiedClassType> getInterceptorClass() {
        if (interceptorClass == null) {
            interceptorClass = new ArrayList<FullyQualifiedClassType>();
        }
        return this.interceptorClass;
    }

    /**
     * Gets the value of the interceptorOrder property.
     * 
     * @return
     *     possible object is
     *     {@link InterceptorOrderType }
     *     
     */
    public InterceptorOrderType getInterceptorOrder() {
        return interceptorOrder;
    }

    /**
     * Sets the value of the interceptorOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link InterceptorOrderType }
     *     
     */
    public void setInterceptorOrder(InterceptorOrderType value) {
        this.interceptorOrder = value;
    }

    /**
     * Gets the value of the excludeDefaultInterceptors property.
     * 
     * @return
     *     possible object is
     *     {@link TrueFalseType }
     *     
     */
    public TrueFalseType getExcludeDefaultInterceptors() {
        return excludeDefaultInterceptors;
    }

    /**
     * Sets the value of the excludeDefaultInterceptors property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrueFalseType }
     *     
     */
    public void setExcludeDefaultInterceptors(TrueFalseType value) {
        this.excludeDefaultInterceptors = value;
    }

    /**
     * Gets the value of the excludeClassInterceptors property.
     * 
     * @return
     *     possible object is
     *     {@link TrueFalseType }
     *     
     */
    public TrueFalseType getExcludeClassInterceptors() {
        return excludeClassInterceptors;
    }

    /**
     * Sets the value of the excludeClassInterceptors property.
     * 
     * @param value
     *     allowed object is
     *     {@link TrueFalseType }
     *     
     */
    public void setExcludeClassInterceptors(TrueFalseType value) {
        this.excludeClassInterceptors = value;
    }

    /**
     * Gets the value of the method property.
     * 
     * @return
     *     possible object is
     *     {@link NamedMethodType }
     *     
     */
    public NamedMethodType getMethod() {
        return method;
    }

    /**
     * Sets the value of the method property.
     * 
     * @param value
     *     allowed object is
     *     {@link NamedMethodType }
     *     
     */
    public void setMethod(NamedMethodType value) {
        this.method = value;
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
