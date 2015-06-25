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
import org.jgrasstools.modules.Xyz2Raster; 
 
@Algorithm(version = "1.0.0", abstrakt = "Convert evenly spaced XYZ triplets to regular raster grid.")
public class Xyz2RasterAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(Xyz2RasterAlgorithm.class); 

  public Xyz2RasterAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String infile;

  @LiteralDataInput(identifier = "inFile", abstrakt = "The file of regularly distributed xyz triplets.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinFile(String infile) { 
    this.infile = infile;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = Double
    // fieldBindingType = Double
    // fieldVariableType = Double
  private Double pres;

  @LiteralDataInput(identifier = "pRes", abstrakt = "The resolution to use.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpRes(Double pres) { 
    this.pres = pres;
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
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String pseparator;

  @LiteralDataInput(identifier = "pSeparator", abstrakt = "The value separator (if not set, spaces will be used).", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setpSeparator(String pseparator) { 
    this.pseparator = pseparator;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outraster;

  @LiteralDataInput(identifier = "outRaster", abstrakt = "The generated raster.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutRaster(String outraster) { 
    this.outraster = outraster;
  }

  private String res_outraster;

  @LiteralDataOutput(identifier = "res_outRaster", abstrakt = "The generated raster.", binding = LiteralStringBinding.class)
  public String getRes_outRaster() { 
    return res_outraster;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.Xyz2RasterAlgorithm");
    
    Xyz2Raster tmpModule = new Xyz2Raster(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("outRaster",  (String) outraster); 
    logger.info("outRaster " + ( (String) outraster) );
    inputs.put("inFile",  (String) infile); 
    logger.info("inFile " + ( (String) infile) );
    inputs.put("pRes",  (Double) pres); 
    logger.info("pRes " + ( (Double) pres) );
    inputs.put("pCode",  (String) pcode); 
    logger.info("pCode " + ( (String) pcode) );
    inputs.put("pSeparator",  (String) pseparator); 
    logger.info("pSeparator " + ( (String) pseparator) );
    
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

