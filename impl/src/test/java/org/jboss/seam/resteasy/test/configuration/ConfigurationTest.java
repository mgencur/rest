package org.jboss.seam.resteasy.test.configuration;

import static org.testng.Assert.assertEquals;

import org.apache.commons.httpclient.methods.GetMethod;
import org.jboss.arquillian.api.Run;
import org.jboss.arquillian.api.RunModeType;
import org.jboss.seam.resteasy.test.SeamResteasyClientTest;
import org.testng.annotations.Test;

@Run(RunModeType.AS_CLIENT)
public class ConfigurationTest extends SeamResteasyClientTest
{
   @Test
   public void testResource() throws Exception
   {
      test("http://localhost:8080/test/foo", 200, "foo");
   }

   @Test
   public void testProvider() throws Exception
   {
      GetMethod get = new GetMethod("http://localhost:8080/test/foo/student");
      get.setRequestHeader("Accept", "foo/bar");
      assertEquals(client.executeMethod(get), 200);
      assertEquals(get.getResponseBodyAsString(), "Jozef Hartinger");
   }

   @Test
   public void testExceptionMapping1() throws Exception
   {
      test("http://localhost:8080/test/foo/exception1", 410, null);
   }
   
   @Test
   public void testExceptionMapping2() throws Exception
   {
      test("http://localhost:8080/test/foo/exception2", 410, "You should not call methods on a null reference.");
   }
   
   @Test
   public void testBasicExceptionMapping() throws Exception
   {
      test("http://localhost:8080/test/foo/exception3", 410, null);
   }

   @Test
   public void testMediaTypeMapping() throws Exception
   {
      test("http://localhost:8080/test/foo.xml", 200, "<foo/>");
   }
}