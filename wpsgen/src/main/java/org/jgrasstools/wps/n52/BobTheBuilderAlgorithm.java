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
import org.jgrasstools.modules.BobTheBuilder; 
 
@Algorithm(version = "1.0.0", abstrakt = "Builds rasterized artifacts on a raster.")
public class BobTheBuilderAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(BobTheBuilderAlgorithm.class); 

  public BobTheBuilderAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inraster;

  @LiteralDataInput(identifier = "inRaster", abstrakt = "The input raster.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinRaster(String inraster) { 
    this.inraster = inraster;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inarea;

  @LiteralDataInput(identifier = "inArea", abstrakt = "The vector map containing the polygonal area to modify.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinArea(String inarea) { 
    this.inarea = inarea;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inelevations;

  @LiteralDataInput(identifier = "inElevations", abstrakt = "The vector map containing the points that provide the new elevations.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinElevations(String inelevations) { 
    this.inelevations = inelevations;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double pmaxbuffer;

  @LiteralDataInput(identifier = "pMaxbuffer", abstrakt = "The maximum radius to use for interpolation.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpMaxbuffer(double pmaxbuffer) { 
    this.pmaxbuffer = pmaxbuffer;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String felevation;

  @LiteralDataInput(identifier = "fElevation", abstrakt = "The field of the elevations map that contain the elevation of the point.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setfElevation(String felevation) { 
    this.felevation = felevation;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean doerode;

  @LiteralDataInput(identifier = "doErode", abstrakt = "Switch that defines if the module should erode in places the actual raster is higher (default is false).", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoErode(Boolean doerode) { 
    this.doerode = doerode;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean douseonlyinternal;

  @LiteralDataInput(identifier = "doUseOnlyInternal", abstrakt = "Switch that defines if the module should use only points contained in the polygon for the interpolation (default is false. i.e. use all).", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoUseOnlyInternal(Boolean douseonlyinternal) { 
    this.douseonlyinternal = douseonlyinternal;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean dopolygonborder;

  @LiteralDataInput(identifier = "doPolygonborder", abstrakt = "Switch that defines if the module should add the border of the polygon as elevation point to aid connection between new and old (default is false).", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoPolygonborder(Boolean dopolygonborder) { 
    this.dopolygonborder = dopolygonborder;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outraster;

  @LiteralDataInput(identifier = "outRaster", abstrakt = "The modified raster map.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutRaster(String outraster) { 
    this.outraster = outraster;
  }

  private String res_outraster;

  @LiteralDataOutput(identifier = "res_outRaster", abstrakt = "The modified raster map.", binding = LiteralStringBinding.class)
  public String getRes_outRaster() { 
    return res_outraster;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.BobTheBuilderAlgorithm");
    
    BobTheBuilder tmpModule = new BobTheBuilder(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("inElevations",  (String) inelevations); 
    logger.info("inElevations " + ( (String) inelevations) );
    inputs.put("inArea",  (String) inarea); 
    logger.info("inArea " + ( (String) inarea) );
    inputs.put("outRaster",  (String) outraster); 
    logger.info("outRaster " + ( (String) outraster) );
    inputs.put("doErode",  (Boolean) doerode); 
    logger.info("doErode " + ( (Boolean) doerode) );
    inputs.put("inRaster",  (String) inraster); 
    logger.info("inRaster " + ( (String) inraster) );
    inputs.put("doPolygonborder",  (Boolean) dopolygonborder); 
    logger.info("doPolygonborder " + ( (Boolean) dopolygonborder) );
    inputs.put("fElevation",  (String) felevation); 
    logger.info("fElevation " + ( (String) felevation) );
    inputs.put("doUseOnlyInternal",  (Boolean) douseonlyinternal); 
    logger.info("doUseOnlyInternal " + ( (Boolean) douseonlyinternal) );
    inputs.put("pMaxbuffer",  (double) pmaxbuffer); 
    logger.info("pMaxbuffer " + ( (double) pmaxbuffer) );
    
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

