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
package org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejb;

import static org.jboss.shrinkwrap.descriptor.impl.spec.AssertXPath.assertXPath;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import junit.framework.Assert;

import org.jboss.shrinkwrap.descriptor.api.Descriptors;
import org.jboss.shrinkwrap.descriptor.api.spec.ee.ejbjar.EjbJarDescriptor;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejb.dummy.Dummy;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejb.dummy.Dummy2;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejbjar.SessionType;
import org.junit.Test;

/**
 * EjbDescriptor TestCase
 *
 * @author "Davide D'Alto"
 * @version $Revision: $
 */
public class EjbJarDescriptorTestCase
{

   private static final String XML_DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
   
   private final Logger log = Logger.getLogger(EjbJarDescriptorTestCase.class.getName());

   @Test
   public void shouldBeAbleToCreateDescriptor() throws Exception
   {
      String ejbJar = create().exportAsString();
      Assert.assertNotNull("Ejb descriptor not created", ejbJar);
   }

   @Test
   public void shouldBeAbleToAddId() throws Exception
   {
      String expected = "id_ejb_jar";
      EjbJarDescriptor ejbJar = create().idEjbJar(expected);
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar[@id='" + expected + "']", "");
   }
   
   @Test
   public void shouldBeAbleToAddVersion() throws Exception
   {
      String expected = "2.0.3";
      EjbJarDescriptor ejbJar = create().version(expected);
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar[@version='" + expected + "']", "");
   }

   @Test
   public void shouldBeAbleToAddMetadataComplete() throws Exception
   {
      String expected = Boolean.TRUE.toString().toLowerCase();
      EjbJarDescriptor ejbJar = create().metadataComplete();
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar[@metadata-complete='" + expected + "']", "");
   }

   @Test
   public void shouldBeAbleToAddNotMetadataComplete() throws Exception
   {
      String expected = Boolean.FALSE.toString().toLowerCase();
      EjbJarDescriptor ejbJar = create().notMetaDataComplete();
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar[@metadata-complete='" + expected + "']", "");
   }
   
   @Test
   public void shouldBeAbleToAddDisplayName() throws Exception
   {
      String expected = "Display name";
      EjbJarDescriptor ejbJar = create().displayName(expected);
      String desc = ejbJar.exportAsString();

      assertXPath(desc, "/ejb-jar/display-name", expected);
   }
   
   @Test
   public void shouldBeAbleToAddDisplayNameId() throws Exception
   {
      String expected = "Display name";
      EjbJarDescriptor ejbJar = create().displayName(expected).id("23");
      String desc = ejbJar.exportAsString();

      assertXPath(desc, "/ejb-jar/display-name[@id=23]", expected);
   }
   
   @Test
   public void shouldBeAbleToAddDisplayNameLang() throws Exception
   {
      String expected = "Display name";
      EjbJarDescriptor ejbJar = create().displayName(expected).lang("eng");
      String desc = ejbJar.exportAsString();

      assertXPath(desc, "/ejb-jar/display-name[@lang='eng']", expected);
   }

   @Test
   public void shouldBeAbleToAddMultipleDisplayName() throws Exception
   {
      String expected1 = "DisplayName1";
      String expected2 = "DisplayName1";
      
      EjbJarDescriptor ejbJar = create()
         .displayName(expected1)
            .id("1")
            .lang("lang1")
         .displayName(expected2)
            .id("2")
            .lang("lang2");
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/display-name[@id='1' and @lang='lang1']", expected1);
      assertXPath(desc, "/ejb-jar/display-name[@id='2' and @lang='lang2']", expected2);
   }
   
   @Test
   public void shouldBeAbleToAddDescription() throws Exception
   {
      String expected = "Description for a brand new test";
      EjbJarDescriptor ejbJar = create().description(expected);
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/description", expected);
   }
   
   @Test
   public void shouldBeAbleToAddDescriptionId() throws Exception
   {
      String expected = "Best description ever";
      EjbJarDescriptor ejbJar = create().description(expected).id("23");
      String desc = ejbJar.exportAsString();

      assertXPath(desc, "/ejb-jar/description[@id=23]", expected);
   }
   
   @Test
   public void shouldBeAbleToAddDescriptionLang() throws Exception
   {
      String expected = "Best description ever";
      EjbJarDescriptor ejbJar = create().description(expected).lang("eng");
      String desc = ejbJar.exportAsString();

      assertXPath(desc, "/ejb-jar/description[@lang='eng']", expected);
   }
   
   @Test
   public void shouldBeAbleToAddMultipleDescritpions() throws Exception
   {
      String expected1 = "Description node 1";
      String expected2 = "Description node 2";
      
      EjbJarDescriptor ejbJar = create()
         .description(expected1)
            .id("1")
            .lang("lang1")
         .description(expected2)
            .id("2")
            .lang("lang2");
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/description[@id='1' and @lang='lang1']", expected1);
      assertXPath(desc, "/ejb-jar/description[@id='2' and @lang='lang2']", expected2);
   }

   @Test
   public void shouldBeAbleToAddIconTypeLargeIcon() throws Exception
   {
      String expectedLarge = "/icon/large1.png";
      EjbJarDescriptor ejbJar = create()
         .icon()
            .largeIcon(expectedLarge);
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/icon/large-icon", expectedLarge);
   }
   
   @Test
   public void shouldBeAbleToAddIconTypeSmallIcon() throws Exception
   {
      String expectedLarge = "/icon/large1.png";
      EjbJarDescriptor ejbJar = create()
         .icon()
            .smallIcon(expectedLarge);
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/icon/small-icon", expectedLarge);
   }
   
   @Test
   public void shouldBeAbleToAddIconTypeId() throws Exception
   {
      String expected = "/icon/icon1.png";
      EjbJarDescriptor ejbJar = create()
         .icon()
            .id("12").smallIcon(expected);
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/icon[@id=12]/small-icon", expected);
   }
   
   @Test
   public void shouldBeAbleToAddIconTypeLang() throws Exception
   {
      String expected = "/icon/icon1.png";
      EjbJarDescriptor ejbJar = create()
         .icon()
            .lang("eng").smallIcon(expected);
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/icon[@lang='eng']/small-icon", expected);
   }
   
   @Test
   public void shouldBeAbleToAddMultipleIcons() throws Exception
   {
      String expectedLarge1 = "/icon/large1.png";
      String expectedSmall1 = "/icon/small1.png";
      
      String expectedLarge2 = "/icon/large2.png";
      String expectedSmall2 = "/icon/small2.png";
      
      EjbJarDescriptor ejbJar = create()
         .icon()
            .id("1")
            .lang("lang1")
            .largeIcon(expectedLarge1)
            .smallIcon(expectedSmall1)
         .icon()
            .id("2")
            .lang("lang2")
            .largeIcon(expectedLarge2)
            .smallIcon(expectedSmall2);
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/icon[@id='1' and @lang='lang1']/large-icon", expectedLarge1);
      assertXPath(desc, "/ejb-jar/icon[@id='1' and @lang='lang1']/small-icon", expectedSmall1);
      
      assertXPath(desc, "/ejb-jar/icon[@id='2' and @lang='lang2']/large-icon", expectedLarge2);
      assertXPath(desc, "/ejb-jar/icon[@id='2' and @lang='lang2']/small-icon", expectedSmall2);
   }
   
   @Test
   public void shouldBeAbleToAddEjbClientJar() throws Exception
   {
      String expected = "employee_service_client.jar";
      EjbJarDescriptor ejbJar = create()
         .ejbClientJar(expected);
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/ejb-client-jar", expected);
   }
   
   @Test
   public void shouldBeAbleToAddEnterpriseBeans() throws Exception
   {
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans();
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/enterprise-beans", "");
   }
   
   @Test
   public void shouldBeAbleToAddEnterpriseBeansId() throws Exception
   {
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans().id("12");
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/enterprise-beans[@id=12]", "");
   }
   
   @Test
   public void shouldBeAbleToAddSessionBean() throws Exception
   {
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans()
            .session();
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/enterprise-beans/session", "");
   }
   
   @Test
   public void shouldBeAbleToAddSessionBeanEjbName() throws Exception
   {
      String expected = "beanName";
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans()
            .session()
               .ejbName(expected);
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/enterprise-beans/session/ejb-name", expected);
   }
   
   @Test
   public void shouldBeAbleToAddSessionBeanMappedName() throws Exception
   {
      String expected = "mappedName";
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans()
            .session()
               .mappedName(expected);
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/enterprise-beans/session/mapped-name", expected);
   }
   
   @Test
   public void shouldBeAbleToAddSessionBeanHome() throws Exception
   {
      String expected = Dummy.class.getCanonicalName();
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans()
            .session()
               .home(Dummy.class);
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/enterprise-beans/session/home", expected);
   }
   
   @Test
   public void shouldBeAbleToAddSessionBeanRemote() throws Exception
   {
      String expected = Dummy.class.getCanonicalName();
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans()
            .session()
               .remote(Dummy.class);
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/enterprise-beans/session/remote", expected);
   }
   
   @Test
   public void shouldBeAbleToAddSessionBeanLocalHome() throws Exception
   {
      String expected = Dummy.class.getCanonicalName();
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans()
            .session()
               .localHome(Dummy.class);
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/enterprise-beans/session/local-home", expected);
   }
   
   @Test
   public void shouldBeAbleToAddSessionBeanLocal() throws Exception
   {
      String expected = Dummy.class.getCanonicalName();
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans()
            .session()
               .local(Dummy.class);
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/enterprise-beans/session/local", expected);
   }
   
   @Test
   public void shouldBeAbleToAddSessionBusinnessLocal() throws Exception
   {
      String expected1 = Dummy.class.getCanonicalName();
      String expected2 = Dummy2.class.getCanonicalName();
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans()
         .session()
            .businnessLocal(Dummy.class, Dummy2.class);
      String desc = ejbJar.exportAsString();

      assertXPath(desc, "/ejb-jar/enterprise-beans/session/business-local", expected1, expected2);
   }

   @Test
   public void shouldBeAbleToAddSessionBusinnessRemote() throws Exception
   {
      String expected1 = Dummy.class.getCanonicalName();
      String expected2 = Dummy2.class.getCanonicalName();
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans()
            .session()
               .businnessRemote(Dummy.class, Dummy2.class);
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/enterprise-beans/session/business-remote", expected1, expected2);
   }
   
   @Test
   public void shouldBeAbleToAddSessionLocalBean() throws Exception
   {
      String expected = "";
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans()
            .session()
               .localBean();
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/enterprise-beans/session/local-bean", expected);
   }
   
   @Test
   public void shouldBeAbleToAddSessionServiceEndpoint() throws Exception
   {
      String expected = Dummy.class.getCanonicalName();
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans()
            .session()
               .serviceEndpoint(Dummy.class);
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/enterprise-beans/session/service-endpoint", expected);
   }
   
   @Test
   public void shouldBeAbleToAddSessionEjbClass() throws Exception
   {
      String expected = Dummy.class.getCanonicalName();
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans()
            .session()
               .ejbClass(Dummy.class);
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/enterprise-beans/session/ejb-class", expected);
   }
   
   @Test
   public void shouldBeAbleToAddSessionType() throws Exception
   {
      String expected = SessionType.STATEFUL.getType();
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans()
            .session()
               .sessionType(SessionType.STATEFUL);
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/enterprise-beans/session/session-type", expected);
   }
   
   @Test
   public void shouldBeAbleToAddSessionStatefulTimeout() throws Exception
   {
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans()
            .session()
               .statefulTimeout(12, "ms");
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/enterprise-beans/session/stateful-timeout/timeout", "12");
      assertXPath(desc, "/ejb-jar/enterprise-beans/session/stateful-timeout/unit", "ms");
   }
   
   @Test
   public void shouldBeAbleToAddSessionStatefulTimeoutMethod() throws Exception
   {
      String expectedMethodName = "methodname";
      String[] expectedParams = {"param1", "param2", "param3"};
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans()
            .session()
               .timeoutMehod(expectedMethodName, expectedParams);
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/enterprise-beans/session/timeout-method/method-name", expectedMethodName);
      assertXPath(desc, "/ejb-jar/enterprise-beans/session/timeout-method/method-params/method-param", expectedParams);
   }
   
   @Test
   public void shouldBeAbleToAddSessionSessionTimer() throws Exception
   {
      String expectedMethodName = "";
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans()
            .session()
               .timer();
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/enterprise-beans/session/timer", expectedMethodName);
   }
   
   @Test
   public void shouldBeAbleToAddSessionSessionTimerId() throws Exception
   {
      String expected = "id_timer";
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans()
            .session()
               .timer(expected);
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/enterprise-beans/session/timer[@id='" + expected + "']", "");
   }
   
   @Test
   public void shouldBeAbleToAddSessionSessionTimerDescriptions() throws Exception
   {
      String[] expected = {"Description 0", "Description 1"};
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans()
            .session()
               .timer()
                  .description(expected);
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/enterprise-beans/session/timer/description", expected);
   }
   
   @Test
   public void shouldBeAbleToAddSessionSessionTimerScheduleId() throws Exception
   {
      String expected = "id_schedule";
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans()
            .session()
               .timer()
                  .schedule(expected);
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/enterprise-beans/session/timer/schedule[@id='" + expected + "']", "");
   }
   
   @Test
   public void shouldBeAbleToAddSessionSessionTimerScheduleSecond() throws Exception
   {
      String expected = "10";
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans()
            .session()
               .timer()
                  .schedule()
                     .second(Integer.valueOf(expected));
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/enterprise-beans/session/timer/schedule/second", expected);
   }
   
   @Test
   public void shouldBeAbleToAddSessionSessionTimerScheduleMinute() throws Exception
   {
      String expected = "10";
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans()
            .session()
               .timer()
                  .schedule()
                     .minute(Integer.valueOf(expected));
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/enterprise-beans/session/timer/schedule/minute", expected);
   }
   
   @Test
   public void shouldBeAbleToAddSessionSessionTimerScheduleHour() throws Exception
   {
      String expected = "10";
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans()
            .session()
               .timer()
                  .schedule()
                     .hour(Integer.valueOf(expected));
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/enterprise-beans/session/timer/schedule/hour", expected);
   }
   
   @Test
   public void shouldBeAbleToAddSessionSessionTimerScheduleDayOfWeek() throws Exception
   {
      String expected = "10";
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans()
            .session()
               .timer()
                  .schedule()
                     .dayOfWeek(Integer.valueOf(expected));
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/enterprise-beans/session/timer/schedule/day-of-week", expected);
   }
   
   @Test
   public void shouldBeAbleToAddSessionSessionTimerScheduleDayOfMonth() throws Exception
   {
      String expected = "10";
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans()
            .session()
               .timer()
                  .schedule()
                     .dayOfMonth(Integer.valueOf(expected));
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/enterprise-beans/session/timer/schedule/day-of-month", expected);
   }
   
   @Test
   public void shouldBeAbleToAddSessionSessionTimerScheduleMonth() throws Exception
   {
      String expected = "10";
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans()
            .session()
               .timer()
                  .schedule()
                     .month(Integer.valueOf(expected));
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/enterprise-beans/session/timer/schedule/month", expected);
   }
   
   @Test
   public void shouldBeAbleToAddSessionSessionTimerScheduleYear() throws Exception
   {
      String expected = "10";
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans()
            .session()
               .timer()
                  .schedule()
                     .year(Integer.valueOf(expected));
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/enterprise-beans/session/timer/schedule/year", expected);
   }
   
   @Test
   public void shouldBeAbleToAddSessionSessionTimerPersistent() throws Exception
   {
      String expected = Boolean.TRUE.toString().toLowerCase();
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans()
            .session()
               .timer()
                  .persistent();
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/enterprise-beans/session/timer/persistent", expected);
   }
   
   @Test
   public void shouldBeAbleToAddSessionSessionTimerPersistentNot() throws Exception
   {
      String expected = Boolean.FALSE.toString().toLowerCase();
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans()
            .session()
               .timer()
                  .notPersistent();
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/enterprise-beans/session/timer/persistent", expected);
   }

   @Test
   public void shouldBeAbleToAddSessionSessionTimerInfo() throws Exception
   {
      String expected = "Information for you";
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans()
            .session()
               .timer()
                  .info(expected);
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/enterprise-beans/session/timer/info", expected);
   }
   
   @Test
   public void shouldBeAbleToAddSessionSessionTimerTimezone() throws Exception
   {
      String expected = "GMT+8 hours";
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans()
            .session()
               .timer()
                  .timezone(expected);
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/enterprise-beans/session/timer/timezone", expected);
   }
   
   @Test
   public void shouldBeAbleToAddSessionSessionTimerStart() throws Exception
   {
      String expected = "2011-02-08T12:02:37.057Z";
      SimpleDateFormat formatter = new SimpleDateFormat(XML_DATE_PATTERN);
      Date date = formatter.parse(expected);
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans()
            .session()
               .timer()
                  .start(date);
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/enterprise-beans/session/timer/start", expected);
   }
   
   @Test
   public void shouldBeAbleToAddSessionSessionTimerEnd() throws Exception
   {
      String expected = "2011-02-08T12:02:37.057Z";
      SimpleDateFormat formatter = new SimpleDateFormat(XML_DATE_PATTERN);
      Date date = formatter.parse(expected);
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans()
            .session()
               .timer()
                  .end(date);
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/enterprise-beans/session/timer/end", expected);
   }
   
   private EjbJarDescriptor create()
   {
      return Descriptors.create(EjbJarDescriptor.class);
   }
}

