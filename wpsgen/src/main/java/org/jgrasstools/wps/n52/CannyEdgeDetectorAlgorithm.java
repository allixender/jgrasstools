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
import org.jgrasstools.modules.CannyEdgeDetector; 
 
@Algorithm(version = "1.0.0", abstrakt = "Edge detection operations")
public class CannyEdgeDetectorAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(CannyEdgeDetectorAlgorithm.class); 

  public CannyEdgeDetectorAlgorithm() { 
    super();
  }
    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outmap;

  @LiteralDataInput(identifier = "outMap", abstrakt = "The resulting map.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutMap(String outmap) { 
    this.outmap = outmap;
  }

  private String res_outmap;

  @LiteralDataOutput(identifier = "res_outMap", abstrakt = "The resulting map.", binding = LiteralStringBinding.class)
  public String getRes_outMap() { 
    return res_outmap;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inmap;

  @LiteralDataInput(identifier = "inMap", abstrakt = "The map on which to perform edge detection.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinMap(String inmap) { 
    this.inmap = inmap;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = Float
    // fieldBindingType = Float
    // fieldVariableType = Float
  private Float plowthres;

  @LiteralDataInput(identifier = "pLowthres", abstrakt = "The low threshold for the algorithm (default = 2.5).", minOccurs = 1, maxOccurs = 1, binding = LiteralFloatBinding.class)
  public void setpLowthres(Float plowthres) { 
    this.plowthres = plowthres;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = Float
    // fieldBindingType = Float
    // fieldVariableType = Float
  private Float phighthres;

  @LiteralDataInput(identifier = "pHighthres", abstrakt = "The hight threshold for the algorithm (default = 7.5).", minOccurs = 1, maxOccurs = 1, binding = LiteralFloatBinding.class)
  public void setpHighthres(Float phighthres) { 
    this.phighthres = phighthres;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = Float
    // fieldBindingType = Float
    // fieldVariableType = Float
  private Float pradiusgauss;

  @LiteralDataInput(identifier = "pRadiusgauss", abstrakt = "The radius of the gaussian kernel (default = 2).", minOccurs = 1, maxOccurs = 1, binding = LiteralFloatBinding.class)
  public void setpRadiusgauss(Float pradiusgauss) { 
    this.pradiusgauss = pradiusgauss;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = Integer
    // fieldBindingType = Int
    // fieldVariableType = Integer
  private Integer pwidthgauss;

  @LiteralDataInput(identifier = "pWidthgauss", abstrakt = "The width of the gaussian kernel (default= 16).", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
  public void setpWidthgauss(Integer pwidthgauss) { 
    this.pwidthgauss = pwidthgauss;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean donormcontrast;

  @LiteralDataInput(identifier = "doNormcontrast", abstrakt = "Switch to normalize the contrast.", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoNormcontrast(Boolean donormcontrast) { 
    this.donormcontrast = donormcontrast;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.CannyEdgeDetectorAlgorithm");
    
    CannyEdgeDetector tmpModule = new CannyEdgeDetector(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("pWidthgauss",  (Integer) pwidthgauss); 
    logger.info("pWidthgauss " + ( (Integer) pwidthgauss) );
    inputs.put("pRadiusgauss",  (Float) pradiusgauss); 
    logger.info("pRadiusgauss " + ( (Float) pradiusgauss) );
    inputs.put("pLowthres",  (Float) plowthres); 
    logger.info("pLowthres " + ( (Float) plowthres) );
    inputs.put("pHighthres",  (Float) phighthres); 
    logger.info("pHighthres " + ( (Float) phighthres) );
    inputs.put("inMap",  (String) inmap); 
    logger.info("inMap " + ( (String) inmap) );
    inputs.put("doNormcontrast",  (Boolean) donormcontrast); 
    logger.info("doNormcontrast " + ( (Boolean) donormcontrast) );
    inputs.put("outMap",  (String) outmap); 
    logger.info("outMap " + ( (String) outmap) );
    
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
    
    outputs.put("outMap", "String"); 
    
    res_outmap = (String) outmap; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outMap")) { 
            // and put them into the output result variables 
            res_outmap = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

