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
import org.jgrasstools.modules.Shp2DxfConverter; 
 
@Algorithm(version = "1.0.0", abstrakt = "Shapefiles to dxf converter (Based on work of Michael Michaud)")
public class Shp2DxfConverterAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(Shp2DxfConverterAlgorithm.class); 

  public Shp2DxfConverterAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infolder
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String infolder;

  @LiteralDataInput(identifier = "inFolder", abstrakt = "The folder containing the shapefiles.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinFolder(String infolder) { 
    this.infolder = infolder;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String felev;

  @LiteralDataInput(identifier = "fElev", abstrakt = "Optional field name for elevation value (in case of lines it will be applied to the whole feature).", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setfElev(String felev) { 
    this.felev = felev;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean dosuffix;

  @LiteralDataInput(identifier = "doSuffix", abstrakt = "Do the suffix.", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoSuffix(Boolean dosuffix) { 
    this.dosuffix = dosuffix;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String indxfpath;

  @LiteralDataInput(identifier = "inDxfpath", abstrakt = "The output dxf file path.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinDxfpath(String indxfpath) { 
    this.indxfpath = indxfpath;
  }

  private String res_indxfpath;

  @LiteralDataOutput(identifier = "res_inDxfpath", abstrakt = "The output dxf file path.", binding = LiteralStringBinding.class)
  public String getRes_inDxfpath() { 
    return res_indxfpath;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.Shp2DxfConverterAlgorithm");
    
    Shp2DxfConverter tmpModule = new Shp2DxfConverter(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("inDxfpath",  (String) indxfpath); 
    logger.info("inDxfpath " + ( (String) indxfpath) );
    inputs.put("doSuffix",  (Boolean) dosuffix); 
    logger.info("doSuffix " + ( (Boolean) dosuffix) );
    inputs.put("fElev",  (String) felev); 
    logger.info("fElev " + ( (String) felev) );
    inputs.put("inFolder",  (String) infolder); 
    logger.info("inFolder " + ( (String) infolder) );
    
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
    
    outputs.put("inDxfpath", "String"); 
    
    res_indxfpath = (String) indxfpath; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("inDxfpath")) { 
            // and put them into the output result variables 
            res_indxfpath = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

