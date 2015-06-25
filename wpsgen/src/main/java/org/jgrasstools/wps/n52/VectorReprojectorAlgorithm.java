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
import org.jgrasstools.modules.VectorReprojector; 
 
@Algorithm(version = "1.0.0", abstrakt = "Module for vector reprojection.")
public class VectorReprojectorAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(VectorReprojectorAlgorithm.class); 

  public VectorReprojectorAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String invector;

  @LiteralDataInput(identifier = "inVector", abstrakt = "The vector that has to be reprojected.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinVector(String invector) { 
    this.invector = invector;
  }

    // inputOutputIndicator = input
    // fileIndicator = crs
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String pcode;

  @LiteralDataInput(identifier = "pCode", abstrakt = "The code defining the target coordinate reference system, composed by authority and code number (ex. EPSG:4328).", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setpCode(String pcode) { 
    this.pcode = pcode;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = Boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean dolongitudefirst;

  @LiteralDataInput(identifier = "doLongitudeFirst", abstrakt = "A flag to modify the axes order.", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoLongitudeFirst(Boolean dolongitudefirst) { 
    this.dolongitudefirst = dolongitudefirst;
  }

    // inputOutputIndicator = input
    // fileIndicator = crs
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String pforcecode;

  @LiteralDataInput(identifier = "pForceCode", abstrakt = "A coordinate reference system on which to force the input, composed by authority and code number (ex. EPSG:4328).", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setpForceCode(String pforcecode) { 
    this.pforcecode = pforcecode;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean dolenient;

  @LiteralDataInput(identifier = "doLenient", abstrakt = "Switch that set to true allows for some error due to different datums. If set to false, it won't reproject without Bursa Wolf parameters.", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoLenient(Boolean dolenient) { 
    this.dolenient = dolenient;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outvector;

  @LiteralDataInput(identifier = "outVector", abstrakt = "The output reprojected vector.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutVector(String outvector) { 
    this.outvector = outvector;
  }

  private String res_outvector;

  @LiteralDataOutput(identifier = "res_outVector", abstrakt = "The output reprojected vector.", binding = LiteralStringBinding.class)
  public String getRes_outVector() { 
    return res_outvector;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.VectorReprojectorAlgorithm");
    
    VectorReprojector tmpModule = new VectorReprojector(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("outVector",  (String) outvector); 
    logger.info("outVector " + ( (String) outvector) );
    inputs.put("pForceCode",  (String) pforcecode); 
    logger.info("pForceCode " + ( (String) pforcecode) );
    inputs.put("doLongitudeFirst",  (Boolean) dolongitudefirst); 
    logger.info("doLongitudeFirst " + ( (Boolean) dolongitudefirst) );
    inputs.put("doLenient",  (Boolean) dolenient); 
    logger.info("doLenient " + ( (Boolean) dolenient) );
    inputs.put("pCode",  (String) pcode); 
    logger.info("pCode " + ( (String) pcode) );
    inputs.put("inVector",  (String) invector); 
    logger.info("inVector " + ( (String) invector) );
    
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
    
    outputs.put("outVector", "String"); 
    
    res_outvector = (String) outvector; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outVector")) { 
            // and put them into the output result variables 
            res_outvector = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

