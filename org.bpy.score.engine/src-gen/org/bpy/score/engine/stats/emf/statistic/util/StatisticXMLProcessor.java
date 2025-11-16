/**
 */
package org.bpy.score.engine.stats.emf.statistic.util;

import java.util.Map;

import org.bpy.score.engine.stats.emf.statistic.StatisticPackage;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class StatisticXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatisticXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		StatisticPackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the StatisticResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new StatisticResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new StatisticResourceFactoryImpl());
		}
		return registrations;
	}

} //StatisticXMLProcessor
