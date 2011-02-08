/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.jboss.shrinkwrap.descriptor.api.spec.ee.ejbjar.ScheduleTimerDescriptor;
import org.jboss.shrinkwrap.descriptor.api.spec.ee.ejbjar.TimerDescriptor;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.DescriptionType;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.SessionBeanType;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.TimerType;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.TrueFalseType;

/**
 * @author "Davide D'Alto"
 * @version $Revision: $
 *
 */
public class TimerDescriptorImpl extends SessionDescriptorImpl implements TimerDescriptor
{

   private final TimerType timer;

   public TimerDescriptorImpl(EjbJarModel model, SessionBeanType sessionBean)
   {
      this(model, sessionBean, new TimerType(), null);
   }
   
   public TimerDescriptorImpl(EjbJarModel model, SessionBeanType sessionBean, String id)
   {
      this(model, sessionBean, new TimerType(), id);
   }
   
   public TimerDescriptorImpl(EjbJarModel model, SessionBeanType sessionBean, TimerType timer)
   {
      this(model, sessionBean, timer, null);
   }
   
   public TimerDescriptorImpl(EjbJarModel model, SessionBeanType sessionBean, TimerType timer, String id)
   {
      super(model, sessionBean);
      this.timer = getElement(sessionBean.getTimer(), timer);
      this.timer.setId(id);
   }

   
   @Override
   public TimerDescriptor description(String... descriptions)
   {
      for (String description : descriptions)
      {
         DescriptionType descType = new DescriptionType();
         descType.setValue(description);
         timer.getDescription().add(descType);
      }
      return this;
   }

   @Override
   public ScheduleTimerDescriptor schedule()
   {
      return new ScheduleTimerDescriptorImpl(getSchemaModel(), getSessionBean(), timer);
   }
   
   @Override
   public ScheduleTimerDescriptor schedule(String id)
   {
      return new ScheduleTimerDescriptorImpl(getSchemaModel(), getSessionBean(), timer, id);
   }

   @Override
   public TimerDescriptor persistent()
   {
      TrueFalseType persistent = new TrueFalseType();
      persistent.setValue(true);
      timer.setPersistent(persistent);
      return this;
   }

   @Override
   public TimerDescriptor notPersistent()
   {
      TrueFalseType persistent = new TrueFalseType();
      persistent.setValue(false);
      timer.setPersistent(persistent);
      return this;
   }

   @Override
   public TimerDescriptor timezone(String timezone)
   {
      timer.setTimezone(convertToXmlString(timezone));
      return this;
   }

   @Override
   public TimerDescriptor info(String info)
   {
      timer.setInfo(convertToXmlString(info));
      return this;
   }

   @Override
   public TimerDescriptor start(Date start)
   {
      XMLGregorianCalendar xmlDate = convertToXml(start);
      timer.setStart(xmlDate);
      return this;
   }

   @Override
   public TimerDescriptor end(Date end)
   {
      XMLGregorianCalendar xmlDate = convertToXml(end);
      timer.setEnd(xmlDate);
      return this;
   }
   
   private XMLGregorianCalendar convertToXml(Date date)
   {
      try
      {
         GregorianCalendar startCal = new GregorianCalendar();
         startCal.setTime(date);
         XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(startCal);
         return xmlDate;
      }
      catch (DatatypeConfigurationException e)
      {
         throw new RuntimeException("Problem converting date <" + date + "> to xml", e);
      }
   }

}
