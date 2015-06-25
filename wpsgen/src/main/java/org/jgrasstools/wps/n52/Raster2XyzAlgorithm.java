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
import org.jgrasstools.modules.Raster2Xyz; 
 
@Algorithm(version = "1.0.0", abstrakt = "Convert a raster to XYZ triplets.")
public class Raster2XyzAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(Raster2XyzAlgorithm.class); 

  public Raster2XyzAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inraster;

  @LiteralDataInput(identifier = "inRaster", abstrakt = "The map to convert.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinRaster(String inraster) { 
    this.inraster = inraster;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String infile;

  @LiteralDataInput(identifier = "inFile", abstrakt = "The file into which to save the result.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinFile(String infile) { 
    this.infile = infile;
  }

  private String res_infile;

  @LiteralDataOutput(identifier = "res_inFile", abstrakt = "The file into which to save the result.", binding = LiteralStringBinding.class)
  public String getRes_inFile() { 
    return res_infile;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean doremovenv;

  @LiteralDataInput(identifier = "doRemovenv", abstrakt = "Flag to remove novalues.", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoRemovenv(Boolean doremovenv) { 
    this.doremovenv = doremovenv;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.Raster2XyzAlgorithm");
    
    Raster2Xyz tmpModule = new Raster2Xyz(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("inRaster",  (String) inraster); 
    logger.info("inRaster " + ( (String) inraster) );
    inputs.put("doRemovenv",  (Boolean) doremovenv); 
    logger.info("doRemovenv " + ( (Boolean) doremovenv) );
    inputs.put("inFile",  (String) infile); 
    logger.info("inFile " + ( (String) infile) );
    
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
    
    outputs.put("inFile", "String"); 
    
    res_infile = (String) infile; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("inFile")) { 
            // and put them into the output result variables 
            res_infile = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

