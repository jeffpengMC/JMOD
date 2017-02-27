package com.jeffpeng.jmod.primitives;

import org.apache.logging.log4j.Logger;

import com.jeffpeng.jmod.Config;
import com.jeffpeng.jmod.JMODRepresentation;
import com.jeffpeng.jmod.Lib;
import com.jeffpeng.jmod.interfaces.IEventObject;
import com.jeffpeng.jmod.interfaces.IOwned;


public class OwnedObject implements IEventObject, IOwned {
	protected JMODRepresentation owner;
	protected Config config;
	protected Lib lib;
	protected Logger log;
	
	public OwnedObject(JMODRepresentation owner){
		this.owner = owner;
		this.lib = owner.getLib();
		this.config = owner.getConfig();
		this.log = owner.getLogger();
	}
	
	public JMODRepresentation getOwner(){
		return owner;
	}

	@Override
	public void on(String trigger) {
		
	}

	@Override
	public boolean fire(String trigger) {
		return false;
		
	}

}
