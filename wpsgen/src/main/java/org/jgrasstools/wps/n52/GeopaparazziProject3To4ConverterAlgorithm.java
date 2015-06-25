/* THIS FILE IS GENERATED, DO NOT EDIT, IT WILL BE OVERWRITTEN */
package org.jgrasstools.wps.n52; 
 
import java.util.Collection; 
import java.util.HashMap; 
import java.util.ArrayList; 
import java.util.List; 
import java.io.*; 
 
import oms3.Access; 
import oms3.ComponentAccess; 
import oms3.annotations.Execute; 
import oms3.annotations.Finalize; 
import oms3.annotations.Initialize; 
 
import org.n52.wps.server.AbstractAnnotatedAlgorithm;
import org.n52.wps.algorithm.annotation.*; 
 
import org.n52.wps.io.data.binding.literal.*; 
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
 
import org.geotools.process.ProcessException; 
import org.jgrasstools.modules.GeopaparazziProject3To4Converter; 
 
@Algorithm(version = "1.0.0", abstrakt = "Convert a geopaparazzi 3 folder project into a geopaparazzi 4 database.")
public class GeopaparazziProject3To4ConverterAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(GeopaparazziProject3To4ConverterAlgorithm.class); 

  public GeopaparazziProject3To4ConverterAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infolder
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String ingeopaparazzi;

  @LiteralDataInput(identifier = "inGeopaparazzi", abstrakt = "Geopaparazzi 3 input folder to convert.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinGeopaparazzi(String ingeopaparazzi) { 
    this.ingeopaparazzi = ingeopaparazzi;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.GeopaparazziProject3To4ConverterAlgorithm");
    
    GeopaparazziProject3To4Converter tmpModule = new GeopaparazziProject3To4Converter(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("inGeopaparazzi",  (String) ingeopaparazzi); 
    logger.info("inGeopaparazzi " + ( (String) ingeopaparazzi) );
    
    // trigger execution of the module 
    try { 
        java.util.logging.Logger uLog = java.util.logging.Logger.getLogger(RasterReprojectorAlgorithm.class.getName()); 
        ComponentAccess.setInputData(inputs, tmpModule, uLog); 
    } catch (Exception ex) { 
       ex.printStackTrace();
    }
    // trigger execution of the module 
    try { 
        java.util.logging.Logger uLog = java.util.logging.Logger.getLogger(RasterReprojectorAlgorithm.class.getName()); 
        ComponentAccess.callAnnotated(tmpModule, Initialize.class, true); 
    } catch (Exception ex) { 
       ex.printStackTrace();
    }
    try { 
        ComponentAccess.callAnnotated(tmpModule, Execute.class, false); 
    } catch (Exception ex) { 
       ex.printStackTrace();
    }
    try { 
        ComponentAccess.callAnnotated(tmpModule, Finalize.class, true); 
    } catch (Exception ex) { 
       ex.printStackTrace();
    }
    
    // get the results 
    HashMap<String, String> outputs = new HashMap<String, String>();
    ComponentAccess cA = new ComponentAccess(tmpModule); 
    Collection<Access> outputsCollection = cA.outputs(); 
    
    
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        } 
    
    }

}

