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
import org.jgrasstools.modules.RasterResolutionResampler; 
 
@Algorithm(version = "1.0.0", abstrakt = "Module to do coverage resolution resampling.")
public class RasterResolutionResamplerAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(RasterResolutionResamplerAlgorithm.class); 

  public RasterResolutionResamplerAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String ingeodata;

  @LiteralDataInput(identifier = "inGeodata", abstrakt = "The input coverage.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinGeodata(String ingeodata) { 
    this.ingeodata = ingeodata;
  }

    // inputOutputIndicator = input
    // fileIndicator = combo:nearest neightbour,bilinear,bicubic
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String pinterpolation;

  @LiteralDataInput(identifier = "pInterpolation", abstrakt = "The interpolation type to use", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setpInterpolation(String pinterpolation) { 
    this.pinterpolation = pinterpolation;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
  private Double pxres;

  @LiteralDataInput(identifier = "pXres", abstrakt = "The new resolution in X", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpXres(Double pxres) { 
    this.pxres = pxres;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
  private Double pyres;

  @LiteralDataInput(identifier = "pYres", abstrakt = "The new resolution in Y (if null taken same as pXres)", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpYres(Double pyres) { 
    this.pyres = pyres;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outgeodata;

  @LiteralDataInput(identifier = "outGeodata", abstrakt = "The output coverage.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutGeodata(String outgeodata) { 
    this.outgeodata = outgeodata;
  }

  private String res_outgeodata;

  @LiteralDataOutput(identifier = "res_outGeodata", abstrakt = "The output coverage.", binding = LiteralStringBinding.class)
  public String getRes_outGeodata() { 
    return res_outgeodata;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.RasterResolutionResamplerAlgorithm");
    
    RasterResolutionResampler tmpModule = new RasterResolutionResampler(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("pYres",  (Double) pyres); 
    logger.info("pYres " + ( (Double) pyres) );
    inputs.put("pInterpolation",  (String) pinterpolation); 
    logger.info("pInterpolation " + ( (String) pinterpolation) );
    inputs.put("outGeodata",  (String) outgeodata); 
    logger.info("outGeodata " + ( (String) outgeodata) );
    inputs.put("inGeodata",  (String) ingeodata); 
    logger.info("inGeodata " + ( (String) ingeodata) );
    inputs.put("pXres",  (Double) pxres); 
    logger.info("pXres " + ( (Double) pxres) );
    
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
    
    outputs.put("outGeodata", "String"); 
    
    res_outgeodata = (String) outgeodata; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outGeodata")) { 
            // and put them into the output result variables 
            res_outgeodata = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

