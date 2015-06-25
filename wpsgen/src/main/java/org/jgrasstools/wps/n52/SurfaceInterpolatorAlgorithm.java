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
import org.jgrasstools.modules.SurfaceInterpolator; 
 
@Algorithm(version = "1.0.0", abstrakt = "Thin Plate Spline and IWD Interpolators")
public class SurfaceInterpolatorAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(SurfaceInterpolatorAlgorithm.class); 

  public SurfaceInterpolatorAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String invector;

  @LiteralDataInput(identifier = "inVector", abstrakt = "The input vector map of points.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinVector(String invector) { 
    this.invector = invector;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String ingrid;

  @LiteralDataInput(identifier = "inGrid", abstrakt = "The grid on which to interpolate.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinGrid(String ingrid) { 
    this.ingrid = ingrid;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inmask;

  @LiteralDataInput(identifier = "inMask", abstrakt = "A mask raster map. Values will be computed only where the mask has values.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinMask(String inmask) { 
    this.inmask = inmask;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String fcat;

  @LiteralDataInput(identifier = "fCat", abstrakt = "Field from which to take the category value.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setfCat(String fcat) { 
    this.fcat = fcat;
  }

    // inputOutputIndicator = input
    // fileIndicator = combo:TPS,IDW
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String pmode;

  @LiteralDataInput(identifier = "pMode", abstrakt = "Interpolation mode.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setpMode(String pmode) { 
    this.pmode = pmode;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = m
  private double pbuffer;

  @LiteralDataInput(identifier = "pBuffer", abstrakt = "The buffer to use for interpolation.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpBuffer(double pbuffer) { 
    this.pbuffer = pbuffer;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = int
    // fieldBindingType = Int
    // fieldVariableType = int
  private int pmaxthreads;

  @LiteralDataInput(identifier = "pMaxThreads", abstrakt = "Max threads to use.", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
  public void setpMaxThreads(int pmaxthreads) { 
    this.pmaxthreads = pmaxthreads;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outraster;

  @LiteralDataInput(identifier = "outRaster", abstrakt = "The interpolated raster", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutRaster(String outraster) { 
    this.outraster = outraster;
  }

  private String res_outraster;

  @LiteralDataOutput(identifier = "res_outRaster", abstrakt = "The interpolated raster", binding = LiteralStringBinding.class)
  public String getRes_outRaster() { 
    return res_outraster;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.SurfaceInterpolatorAlgorithm");
    
    SurfaceInterpolator tmpModule = new SurfaceInterpolator(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("pBuffer",  (double) pbuffer); 
    logger.info("pBuffer " + ( (double) pbuffer) );
    inputs.put("outRaster",  (String) outraster); 
    logger.info("outRaster " + ( (String) outraster) );
    inputs.put("pMode",  (String) pmode); 
    logger.info("pMode " + ( (String) pmode) );
    inputs.put("inMask",  (String) inmask); 
    logger.info("inMask " + ( (String) inmask) );
    inputs.put("pMaxThreads",  (int) pmaxthreads); 
    logger.info("pMaxThreads " + ( (int) pmaxthreads) );
    inputs.put("inVector",  (String) invector); 
    logger.info("inVector " + ( (String) invector) );
    inputs.put("fCat",  (String) fcat); 
    logger.info("fCat " + ( (String) fcat) );
    inputs.put("inGrid",  (String) ingrid); 
    logger.info("inGrid " + ( (String) ingrid) );
    
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

