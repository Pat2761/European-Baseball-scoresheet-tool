package org.bpy.score.graphics.tests;

import static org.junit.jupiter.api.Assertions.assertNull;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.bpy.score.engine.manager.IActionManager;
import org.bpy.score.graphics.ScoringSheetGraphicalManager;
import org.junit.jupiter.api.Test;

public class CheckMandatoryOverride {

	@Test
	public void checkMandatoryOverrideAbstractEngine() {
		Method[] methodsToOverride = IActionManager.class.getDeclaredMethods();
		Method[] declaredMethods = ScoringSheetGraphicalManager.class.getDeclaredMethods();
		
		for (Method methodToOverride : methodsToOverride) {
			String message = checkExistingMethod(methodToOverride, declaredMethods);
			assertNull(message,"Error in " + ScoringSheetGraphicalManager.class.getSimpleName());
		}
	}
	
	private String checkExistingMethod(Method methodToOverride, Method[] declaredMethods) {
		boolean methodFound = false;
		
		for (Method declaredMethod : declaredMethods) {
			if (methodToOverride.getName().equals(declaredMethod.getName()) && 
				methodToOverride.getParameterCount() == declaredMethod.getParameterCount() ) {
				
				Parameter[] neededParameters = methodToOverride.getParameters();
				Parameter[] checkedParameters = declaredMethod.getParameters();

				boolean checkParameters = checkParameters(neededParameters,checkedParameters); 
				if (checkParameters) {
					methodFound = true;
				}
			}
		}
		
		if (methodFound) {
			return null;
		} else {
			StringBuilder strBuilder = new StringBuilder("Can't found method: ");
			strBuilder.append(methodToOverride.toString());
			return strBuilder.toString();
		}
	}

	private boolean checkParameters(Parameter[] neededParameters, Parameter[] checkedParameters) {
		boolean state = true;
		for (int i=0 ;i<neededParameters.length ; i++) {
			Parameter neededParameter = neededParameters[i];
			Parameter checkedParameter = checkedParameters[i];
			
			if (!neededParameter.getType().equals(checkedParameter.getType())) {
				state = false;
			}
		}
		return state;
	}

}
