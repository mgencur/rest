/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.seam.rest;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.jboss.seam.rest.exceptions.RestResource;

/**
 * TODO: This listener will be replaced with Seam Servlet.
 * Do not observe the event fired by this listener as it will be removed in future releases.
 * @author <a href="mailto:jharting@redhat.com">Jozef Hartinger</a>
 *
 */
@WebListener
public class StartupListener implements ServletContextListener
{
   @Inject @RestResource
   private Event<ServletContext> event;
   
   @Override
   public void contextInitialized(ServletContextEvent sce)
   {
      event.fire(sce.getServletContext());
   }

   @Override
   public void contextDestroyed(ServletContextEvent sce)
   {
   }
}
