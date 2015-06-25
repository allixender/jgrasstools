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
import org.jgrasstools.modules.Vectorizer; 
 
@Algorithm(version = "1.0.0", abstrakt = "Module for raster to vector conversion.")
public class VectorizerAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(VectorizerAlgorithm.class); 

  public VectorizerAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inraster;

  @LiteralDataInput(identifier = "inRaster", abstrakt = "The raster that has to be converted.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinRaster(String inraster) { 
    this.inraster = inraster;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
  private Double pvalue;

  @LiteralDataInput(identifier = "pValue", abstrakt = "The value to use to trace the polygons. If it is null then all the value of the raster are used.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpValue(Double pvalue) { 
    this.pvalue = pvalue;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String fdefault;

  @LiteralDataInput(identifier = "fDefault", abstrakt = "The field name to use as a name for the raster value in the vector.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setfDefault(String fdefault) { 
    this.fdefault = fdefault;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double pthres;

  @LiteralDataInput(identifier = "pThres", abstrakt = "A threshold on cell number to filter away polygons with cells less than that.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpThres(double pthres) { 
    this.pthres = pthres;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean doregioncheck;

  @LiteralDataInput(identifier = "doRegioncheck", abstrakt = "Make a check on the raster first and shrink the boundaries on the region with data.", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoRegioncheck(Boolean doregioncheck) { 
    this.doregioncheck = doregioncheck;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outvector;

  @LiteralDataInput(identifier = "outVector", abstrakt = "The extracted vector.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutVector(String outvector) { 
    this.outvector = outvector;
  }

  private String res_outvector;

  @LiteralDataOutput(identifier = "res_outVector", abstrakt = "The extracted vector.", binding = LiteralStringBinding.class)
  public String getRes_outVector() { 
    return res_outvector;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.VectorizerAlgorithm");
    
    Vectorizer tmpModule = new Vectorizer(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("outVector",  (String) outvector); 
    logger.info("outVector " + ( (String) outvector) );
    inputs.put("doRegioncheck",  (Boolean) doregioncheck); 
    logger.info("doRegioncheck " + ( (Boolean) doregioncheck) );
    inputs.put("pValue",  (Double) pvalue); 
    logger.info("pValue " + ( (Double) pvalue) );
    inputs.put("inRaster",  (String) inraster); 
    logger.info("inRaster " + ( (String) inraster) );
    inputs.put("pThres",  (double) pthres); 
    logger.info("pThres " + ( (double) pthres) );
    inputs.put("fDefault",  (String) fdefault); 
    logger.info("fDefault " + ( (String) fdefault) );
    
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

