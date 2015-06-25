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
import org.jgrasstools.modules.Mapcalc; 
 
@Algorithm(version = "1.0.0", abstrakt = "Module for doing raster map algebra.")
public class MapcalcAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(MapcalcAlgorithm.class); 

  public MapcalcAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inraster1;

  @LiteralDataInput(identifier = "inRaster1", abstrakt = "Raster map to process.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinRaster1(String inraster1) { 
    this.inraster1 = inraster1;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inraster2;

  @LiteralDataInput(identifier = "inRaster2", abstrakt = "Optional raster map to process.", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinRaster2(String inraster2) { 
    this.inraster2 = inraster2;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inraster3;

  @LiteralDataInput(identifier = "inRaster3", abstrakt = "Optional raster map to process.", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinRaster3(String inraster3) { 
    this.inraster3 = inraster3;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inraster4;

  @LiteralDataInput(identifier = "inRaster4", abstrakt = "Optional raster map to process.", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinRaster4(String inraster4) { 
    this.inraster4 = inraster4;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inraster5;

  @LiteralDataInput(identifier = "inRaster5", abstrakt = "Optional raster map to process.", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinRaster5(String inraster5) { 
    this.inraster5 = inraster5;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outraster;

  @LiteralDataInput(identifier = "outRaster", abstrakt = "The resulting map picked from the inserted function.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutRaster(String outraster) { 
    this.outraster = outraster;
  }

  private String res_outraster;

  @LiteralDataOutput(identifier = "res_outRaster", abstrakt = "The resulting map picked from the inserted function.", binding = LiteralStringBinding.class)
  public String getRes_outRaster() { 
    return res_outraster;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = List
    // fieldBindingType = String
    // fieldVariableType = String
  private String inrasters;

  @LiteralDataInput(identifier = "inRasters", abstrakt = "The maps that are used in the calculation.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinRasters(String inrasters) { 
    this.inrasters = inrasters;
  }

    // inputOutputIndicator = input
    // fileIndicator = multiline10,mapcalc
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String pfunction;

  @LiteralDataInput(identifier = "pFunction", abstrakt = "The function to process.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setpFunction(String pfunction) { 
    this.pfunction = pfunction;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.MapcalcAlgorithm");
    
    Mapcalc tmpModule = new Mapcalc(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("inRaster2",  (String) inraster2); 
    logger.info("inRaster2 " + ( (String) inraster2) );
    inputs.put("outRaster",  (String) outraster); 
    logger.info("outRaster " + ( (String) outraster) );
    inputs.put("inRaster3",  (String) inraster3); 
    logger.info("inRaster3 " + ( (String) inraster3) );
    inputs.put("pFunction",  (String) pfunction); 
    logger.info("pFunction " + ( (String) pfunction) );
    inputs.put("inRaster4",  (String) inraster4); 
    logger.info("inRaster4 " + ( (String) inraster4) );
    inputs.put("inRaster5",  (String) inraster5); 
    logger.info("inRaster5 " + ( (String) inraster5) );
    inputs.put("inRasters",  (String) inrasters); 
    logger.info("inRasters " + ( (String) inrasters) );
    inputs.put("inRaster1",  (String) inraster1); 
    logger.info("inRaster1 " + ( (String) inraster1) );
    
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
    
    outputs.put("outRaster", "String"); 
    
    res_outraster = (String) outraster; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outRaster")) { 
            // and put them into the output result variables 
            res_outraster = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

