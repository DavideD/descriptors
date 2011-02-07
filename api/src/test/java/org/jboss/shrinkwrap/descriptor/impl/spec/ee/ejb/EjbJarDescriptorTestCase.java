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

import java.util.logging.Logger;

import junit.framework.Assert;

import org.jboss.shrinkwrap.descriptor.api.Descriptors;
import org.jboss.shrinkwrap.descriptor.api.spec.ee.ejbjar.EjbJarDescriptor;
import org.jboss.shrinkwrap.descriptor.impl.spec.ee.ejb.dummy.Dummy;
import org.junit.Test;

/**
 * EjbDescriptor TestCase
 *
 * @author "Davide D'Alto"
 * @version $Revision: $
 */
public class EjbJarDescriptorTestCase
{

   private final Logger log = Logger.getLogger(EjbJarDescriptorTestCase.class.getName());

   @Test
   public void shouldBeAbleToCreateDescriptor() throws Exception
   {
      String ejbJar = create().exportAsString();
      Assert.assertNotNull("Ejb descriptor not created", ejbJar);
   }

   @Test
   public void shouldBeAbleToAddModuleName() throws Exception
   {
      String expected = "test.jar";
      EjbJarDescriptor ejbJar = create().moduleName(expected);
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/module-name", expected);
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
      String expected = Dummy.class.getName();
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
      String expected = Dummy.class.getName();
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
      String expected = Dummy.class.getName();
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
      String expected = Dummy.class.getName();
      EjbJarDescriptor ejbJar = create()
         .enterpriseBeans()
            .session()
               .local(Dummy.class);
      String desc = ejbJar.exportAsString();
      
      assertXPath(desc, "/ejb-jar/enterprise-beans/session/local", expected);
   }

   
   private EjbJarDescriptor create()
   {
      return Descriptors.create(EjbJarDescriptor.class);
   }
}
