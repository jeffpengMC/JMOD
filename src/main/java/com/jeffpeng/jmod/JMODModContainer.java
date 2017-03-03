package com.jeffpeng.jmod;



import java.io.File;
import java.util.Arrays;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import cpw.mods.fml.client.FMLFileResourcePack;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLConstructionEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLLoadCompleteEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLStateEvent;


public class JMODModContainer extends DummyModContainer {
	
	protected ModMetadata meta;
	
	public JMODModContainer(){
		super(new ModMetadata());
		JMOD.getInstance().modcontainer = this;
		meta = super.getMetadata();
		meta.modId = JMOD.MODID;
		meta.autogenerated = false;
		meta.version = JMOD.VERSION;
		meta.name = JMOD.NAME;
		meta.authorList = Arrays.asList(new String[]{"SvenKayser","reteo","nmarshall23"});
		meta.url="https://github.com/SvenKayser/JMOD";
		meta.description = "The JavaScript MOD Loader provides an API to write simple mods in JavaScript and takes care of loading them.\n\nFor MineCraft 1.7.10 / Forge 10.13.4.1558+ Loaded JMODs:";
		meta.credits = "The people at Forge / FML for their amazing ModLoader / API and Reika and many, many others for making their sources publically available for others to learn";
		meta.logoFile = "/assets/jmod/logo.png";
	}
	
	@Override
	public Object getMod(){
		return JMOD.getInstance();
	}
	
	@Override
    public boolean registerBus(EventBus bus, LoadController controller)
    {
		bus.register(this);
		return true;
    }
	
	@Subscribe
	public void on(FMLStateEvent event){
		if(event instanceof FMLConstructionEvent) JMOD.getInstance().on((FMLConstructionEvent) event); else
		if(event instanceof FMLPreInitializationEvent) JMOD.getInstance().on((FMLPreInitializationEvent) event); else
		if(event instanceof FMLInitializationEvent) JMOD.getInstance().on((FMLInitializationEvent) event); else
		if(event instanceof FMLPostInitializationEvent) JMOD.getInstance().on((FMLPostInitializationEvent) event); else
		if(event instanceof FMLLoadCompleteEvent) JMOD.getInstance().on((FMLLoadCompleteEvent) event); else
		if(event instanceof FMLServerStartedEvent) JMOD.getInstance().on((FMLServerStartedEvent) event); 
	}
	
	@Override
	public Class<?> getCustomResourcePackClass(){
		return FMLFileResourcePack.class;
	}
	
    @Override
    public File getSource()
    {
    	if(JMOD.isDevVersion()) return new File("mods/jmod-untyped-devtest.jar");
        return new File("mods/jmod-" + JMOD.VERSION + ".jar");
    }
}