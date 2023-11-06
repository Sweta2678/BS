package com.ihg.brandstandards.gem.process;

import com.ihg.brandstandards.gem.process.impl.SETemplateProcessor;
import com.ihg.brandstandards.gem.process.impl.SelfAuditTemplateProcessor;
import com.ihg.brandstandards.gem.process.impl.WaiverTemplateProcessor;
import com.ihg.brandstandards.gem.util.GemConstants;

/**
 * 
 * @author AkhaniC
 *
 */
public class ProcessorFactory {
	
	/**
	 * @param template
	 * @return Processor
	 */
	public static Processor getProcessorObject (String template) {
		Processor processor = null;
		if (GemConstants.TEMPLATE_TYPE_WAIVER.equals(template)) {
			processor = new WaiverTemplateProcessor();
		} else if (GemConstants.TEMPLATE_TYPE_SA.equals(template)) {
			processor = new SelfAuditTemplateProcessor();
		} else if (GemConstants.TEMPLATE_TYPE_SE.equals(template)) {
			processor = new SETemplateProcessor();
		} 
		
		return processor;
	}

}
