/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat Middleware LLC, and individual contributors
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
package org.jboss.shrinkwrap.descriptor.impl.ejbjar30; 

import org.jboss.shrinkwrap.descriptor.spi.Node;
import org.jboss.shrinkwrap.descriptor.gen.TestDescriptorImpl;
import org.jboss.shrinkwrap.descriptor.api.Descriptors;import org.junit.Test;
import static org.junit.Assert.*;
import org.jboss.shrinkwrap.descriptor.api.ejbjar30.EjbJar30Descriptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jboss.shrinkwrap.descriptor.api.Child;
import org.jboss.shrinkwrap.descriptor.impl.base.XMLDate;
import org.jboss.shrinkwrap.descriptor.spi.xml.dom.XmlDomExporter;
import org.jboss.shrinkwrap.descriptor.impl.base.Strings;
import org.jboss.shrinkwrap.descriptor.spi.DescriptorExporter;
import org.jboss.shrinkwrap.descriptor.api.ejbjar30.EnterpriseBeansType;
import org.jboss.shrinkwrap.descriptor.impl.ejbjar30.EnterpriseBeansTypeImpl;
import org.jboss.shrinkwrap.descriptor.api.ejbjar30.InterceptorsType;
import org.jboss.shrinkwrap.descriptor.impl.ejbjar30.InterceptorsTypeImpl;
import org.jboss.shrinkwrap.descriptor.api.ejbjar30.RelationshipsType;
import org.jboss.shrinkwrap.descriptor.impl.ejbjar30.RelationshipsTypeImpl;
import org.jboss.shrinkwrap.descriptor.api.ejbjar30.AssemblyDescriptorType;
import org.jboss.shrinkwrap.descriptor.impl.ejbjar30.AssemblyDescriptorTypeImpl;
import org.jboss.shrinkwrap.descriptor.api.javaee5.IconType;
import org.jboss.shrinkwrap.descriptor.impl.javaee5.IconTypeImpl;

public class EjbJar30DescriptorImplTestCase
{   
   @Test
   public void testNullArg() throws Exception
   {
      EjbJar30Descriptor type = Descriptors.create(EjbJar30Descriptor.class);
      TestDescriptorImpl.testNullArgs(type);
   }
   
   @Test
   public void testEnterpriseBeans() throws Exception
   {
      EjbJar30Descriptor type = Descriptors.create(EjbJar30Descriptor.class);
      type.enterpriseBeans().up();
      type.removeEnterpriseBeans();
      assertNull(((EjbJar30DescriptorImpl)type).getRootNode().getSingle("enterprise-beans"));
   }
   
   @Test
   public void testInterceptors() throws Exception
   {
      EjbJar30Descriptor type = Descriptors.create(EjbJar30Descriptor.class);
      type.interceptors().up();
      type.removeInterceptors();
      assertNull(((EjbJar30DescriptorImpl)type).getRootNode().getSingle("interceptors"));
   }
   
   @Test
   public void testRelationships() throws Exception
   {
      EjbJar30Descriptor type = Descriptors.create(EjbJar30Descriptor.class);
      type.relationships().up();
      type.removeRelationships();
      assertNull(((EjbJar30DescriptorImpl)type).getRootNode().getSingle("relationships"));
   }
   
   @Test
   public void testAssemblyDescriptor() throws Exception
   {
      EjbJar30Descriptor type = Descriptors.create(EjbJar30Descriptor.class);
      type.assemblyDescriptor().up();
      type.removeAssemblyDescriptor();
      assertNull(((EjbJar30DescriptorImpl)type).getRootNode().getSingle("assembly-descriptor"));
   }
   
   @Test
   public void testEjbClientJar() throws Exception
   {
      EjbJar30Descriptor type = Descriptors.create(EjbJar30Descriptor.class);
      type.setEjbClientJar("test");
      assertEquals(type.getEjbClientJar(), "test");
      type.removeEjbClientJar();
      assertNull(type.getEjbClientJar());
   }
   
   @Test
   public void testVersion() throws Exception
   {
      EjbJar30Descriptor type = Descriptors.create(EjbJar30Descriptor.class);
      type.setVersion("test");
      assertEquals(type.getVersion(), "test");
      type.removeVersion();
      assertNull(type.getVersion());
   }
   
   @Test
   public void testMetadataComplete() throws Exception
   {
      EjbJar30Descriptor type = Descriptors.create(EjbJar30Descriptor.class);
      type.setMetadataComplete(true);
      assertTrue(type.isMetadataComplete());
      type.removeMetadataComplete();
      assertFalse(type.isMetadataComplete());
   }
   
   @Test
   public void testDescription() throws Exception
   {
      EjbJar30Descriptor type = Descriptors.create(EjbJar30Descriptor.class);
      type.setDescription("value1");
      type.setDescription("value2");
      type.setDescriptionList("value3", "value4");
      assertTrue(type.getDescriptionList().size() == 4);
      assertEquals(type.getDescriptionList().get(0), "value1");
      assertEquals(type.getDescriptionList().get(1), "value2");
      assertEquals(type.getDescriptionList().get(2), "value3");
      assertEquals(type.getDescriptionList().get(3), "value4");
      type.removeAllDescription();
      assertTrue(type.getDescriptionList().size() == 0);
   }
   
   @Test
   public void testDisplayName() throws Exception
   {
      EjbJar30Descriptor type = Descriptors.create(EjbJar30Descriptor.class);
      type.setDisplayName("value1");
      type.setDisplayName("value2");
      type.setDisplayNameList("value3", "value4");
      assertTrue(type.getDisplayNameList().size() == 4);
      assertEquals(type.getDisplayNameList().get(0), "value1");
      assertEquals(type.getDisplayNameList().get(1), "value2");
      assertEquals(type.getDisplayNameList().get(2), "value3");
      assertEquals(type.getDisplayNameList().get(3), "value4");
      type.removeAllDisplayName();
      assertTrue(type.getDisplayNameList().size() == 0);
   }
   
   @Test
   public void testIcon() throws Exception
   {
      EjbJar30Descriptor type = Descriptors.create(EjbJar30Descriptor.class);
      type.icon().up();
      type.icon().up();
      assertTrue(type.getIconList().size() == 2);
      type.removeAllIcon();
      assertTrue(type.getIconList().size() == 0);
   }
}
