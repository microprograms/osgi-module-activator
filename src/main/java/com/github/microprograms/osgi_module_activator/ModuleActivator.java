package com.github.microprograms.osgi_module_activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModuleActivator implements BundleActivator {
	protected final Logger log;
	protected BundleContext context;

	public ModuleActivator() {
		log = LoggerFactory.getLogger(getClass());
	}

	@Override
	public void start(BundleContext context) throws Exception {
		log.info("{} starting ...", getClass().getName());
		this.context = context;
	}

	protected Logger getLog() {
		return log;
	}

	protected BundleContext getContext() {
		return context;
	}

	protected void registerApi(Object api) {
		context.registerService(api.getClass().getName(), api, null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		log.info("{} stopping ...", getClass().getName());
	}
}
