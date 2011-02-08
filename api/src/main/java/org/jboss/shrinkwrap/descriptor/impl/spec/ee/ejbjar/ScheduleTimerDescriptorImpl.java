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

import org.jboss.shrinkwrap.descriptor.api.spec.ee.ejbjar.ScheduleTimerDescriptor;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.SessionBeanType;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.TimerScheduleType;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.javaee.TimerType;

/**
 * @author "Davide D'Alto"
 * @version $Revision: $
 *
 */
public class ScheduleTimerDescriptorImpl extends TimerDescriptorImpl implements ScheduleTimerDescriptor
{

   private final TimerScheduleType schedule;

   public ScheduleTimerDescriptorImpl(EjbJarModel model, SessionBeanType sessionBean, TimerType timer)
   {
      this(model, sessionBean, timer, null);
   }

   public ScheduleTimerDescriptorImpl(EjbJarModel model, SessionBeanType sessionBean, TimerType timer, String id)
   {
      super(model, sessionBean, timer);
      TimerScheduleType scheduleType = new TimerScheduleType();
      scheduleType.setId(id);
      
      timer.setSchedule(scheduleType);
      this.schedule = scheduleType;
   }

   @Override
   public ScheduleTimerDescriptor second(int value)
   {
      schedule.setSecond(convertToXmlString(String.valueOf(value)));
      return this;
   }

   @Override
   public ScheduleTimerDescriptor minute(int value)
   {
      schedule.setMinute(convertToXmlString(String.valueOf(value)));
      return this;
   }

   @Override
   public ScheduleTimerDescriptor hour(int value)
   {
      schedule.setHour(convertToXmlString(String.valueOf(value)));
      return this;
   }

   @Override
   public ScheduleTimerDescriptor dayOfMonth(int value)
   {
      schedule.setDayOfMonth(convertToXmlString(String.valueOf(value)));
      return this;
   }

   @Override
   public ScheduleTimerDescriptor month(int value)
   {
      schedule.setMonth(convertToXmlString(String.valueOf(value)));
      return this;
   }

   @Override
   public ScheduleTimerDescriptor dayOfWeek(int value)
   {
      schedule.setDayOfWeek(convertToXmlString(String.valueOf(value)));
      return this;
   }

   @Override
   public ScheduleTimerDescriptor year(int value)
   {
      schedule.setYear(convertToXmlString(String.valueOf(value)));
      return this;
   }


}
