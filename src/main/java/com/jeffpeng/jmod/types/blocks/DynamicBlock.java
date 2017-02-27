package com.jeffpeng.jmod.types.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

import com.jeffpeng.jmod.JMOD;
import com.jeffpeng.jmod.JMODRepresentation;
import com.jeffpeng.jmod.Lib.SIDES;
import com.jeffpeng.jmod.interfaces.ISettingsProcessor;
import com.jeffpeng.jmod.interfaces.ISettingsReceiver;


public class DynamicBlock extends CoreBlock implements ISettingsProcessor{
	
	private int power = 0;
	private boolean powered = false;
	private int poweredSides = SIDES.NONE;

	public DynamicBlock(JMODRepresentation owner, Material mat) {
		super(owner, mat);
	}
	
	@Override
    public boolean canProvidePower()
    {
        return powered;
    }
	
	@Override
    public int isProvidingWeakPower(IBlockAccess world, int x, int y, int z, int side)
    {
		JMOD.LOG.info(""+ (1<<poweredSides) + " " + side);
		
		if(((1 << side) & poweredSides) > 0 && powered) return power;
		return 0;
    }   
	
	public void setPower(int power, int sides){
		this.power = power & 15;
		this.poweredSides = sides & 63;
	}
	
	public void setPowered(boolean powerable){
		this.powered = powerable;
	}

	@Override
	public void processSettings(ISettingsReceiver settings) {

		
	}
	
	

}
