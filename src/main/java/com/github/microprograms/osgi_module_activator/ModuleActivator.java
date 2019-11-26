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
		log.info("starting module {}", getClass().getName());
		this.context = context;
		onStart();
	}

	protected void onStart() throws Exception {
	}

	protected Logger getLog() {
		return log;
	}

	protected BundleContext getContext() {
		return context;
	}

	protected void registerApi(Object api) {
		String apiClassName = api.getClass().getName();
		log.info("register api {}", apiClassName);
		context.registerService(apiClassName, api, null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		log.info("stopping module {}", getClass().getName());
		onStop();
	}

	protected void onStop() throws Exception {
	}
}
