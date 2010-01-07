/*
 * JBoss, a division of Red Hat
 * Copyright 2009, Red Hat Middleware, LLC, and individual
 * contributors as indicated by the @authors tag. See the
 * copyright.txt in the distribution for a full listing of
 * individual contributors.
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
package org.exoplatform.wsrp.webui.component;

import org.exoplatform.container.ExoContainer;
import org.exoplatform.container.ExoContainerContext;
import org.exoplatform.webui.config.annotation.ComponentConfig;
import org.exoplatform.webui.core.UIContainer;
import org.exoplatform.webui.core.lifecycle.UIApplicationLifecycle;
import org.gatein.wsrp.producer.config.ProducerConfigurationService;

/** @author Wesley Hales */
@ComponentConfig(
   lifecycle = UIApplicationLifecycle.class,
   template = "app:/groovy/wsrp/webui/component/UIWsrpProducerOverview.gtmpl"
)
public class UIWsrpProducerOverview extends UIContainer
{
   private UIWsrpProducerEditor producerForm;

   public UIWsrpProducerOverview() throws Exception
   {
      producerForm = createUIComponent(UIWsrpProducerEditor.class, null, "Producer Editor");
      producerForm.initWith(getProducerConfigurationService());
      addChild(producerForm);
   }

   public ProducerConfigurationService getProducerConfigurationService() throws Exception
   {
      ExoContainer manager = ExoContainerContext.getCurrentContainer();
      return (ProducerConfigurationService)manager.getComponentInstanceOfType(ProducerConfigurationService.class);
   }
}
