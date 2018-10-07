package org.xulei.url;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

/**
 * Gson utils.
 *
 * @author Lei
 */
public class JsonUtils {
	
	private static  final JaxbAnnotationModule module = new JaxbAnnotationModule();
	public static  final ObjectMapper mapper=new ObjectMapper().registerModule(module);
	
	/*public static void Gson(){
		
		ObjectMapper mapper = new ObjectMapper();
		
		JaxbAnnotationModule module = new JaxbAnnotationModule();
		mapper.registerModule(module);
		
		AnnotationIntrospector introspector =
		    new JaxbAnnotationIntrospector(mapper.getTypeFactory());   

		mapper.setAnnotationIntrospector(introspector);
		
	}*/

	
//    public static final Gson DEFAULT_GSON = new GsonBuilder()
//            .serializeNulls()
//            .excludeFieldsWithoutExposeAnnotation()
//            .setDateFormat("yyyy-MM-dd HH:mm:ss").create();
}
