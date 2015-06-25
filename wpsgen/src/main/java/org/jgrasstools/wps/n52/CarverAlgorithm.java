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
import org.jgrasstools.modules.Carver; 
 
@Algorithm(version = "1.0.0", abstrakt = "Carves a raster using a vector map.")
public class CarverAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(CarverAlgorithm.class); 

  public CarverAlgorithm() { 
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
  private String incarverpolygons;

  @LiteralDataInput(identifier = "inCarverPolygons", abstrakt = "The polygon vector map used to carve the raster.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinCarverPolygons(String incarverpolygons) { 
    this.incarverpolygons = incarverpolygons;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String incarverlines;

  @LiteralDataInput(identifier = "inCarverLines", abstrakt = "The lines vector map used to carve the raster.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinCarverLines(String incarverlines) { 
    this.incarverlines = incarverlines;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String fdepthlines;

  @LiteralDataInput(identifier = "fDepthLines", abstrakt = "The optional vector lines field containing the depth to be carved.", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setfDepthLines(String fdepthlines) { 
    this.fdepthlines = fdepthlines;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double pdepthlines;

  @LiteralDataInput(identifier = "pDepthLines", abstrakt = "The carve depth to use for vector lines if no field is supplied.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpDepthLines(double pdepthlines) { 
    this.pdepthlines = pdepthlines;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String fdepthpolygons;

  @LiteralDataInput(identifier = "fDepthPolygons", abstrakt = "The optional vector polygons field containing the depth to be carved.", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setfDepthPolygons(String fdepthpolygons) { 
    this.fdepthpolygons = fdepthpolygons;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
  private double pdepthpolygons;

  @LiteralDataInput(identifier = "pDepthPolygons", abstrakt = "The carve depth to use for vector polygons if no field is supplied.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpDepthPolygons(double pdepthpolygons) { 
    this.pdepthpolygons = pdepthpolygons;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outraster;

  @LiteralDataInput(identifier = "outRaster", abstrakt = "The carved raster map.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutRaster(String outraster) { 
    this.outraster = outraster;
  }

  private String res_outraster;

  @LiteralDataOutput(identifier = "res_outRaster", abstrakt = "The carved raster map.", binding = LiteralStringBinding.class)
  public String getRes_outRaster() { 
    return res_outraster;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.CarverAlgorithm");
    
    Carver tmpModule = new Carver(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("outRaster",  (String) outraster); 
    logger.info("outRaster " + ( (String) outraster) );
    inputs.put("inRaster",  (String) inraster); 
    logger.info("inRaster " + ( (String) inraster) );
    inputs.put("fDepthLines",  (String) fdepthlines); 
    logger.info("fDepthLines " + ( (String) fdepthlines) );
    inputs.put("inCarverPolygons",  (String) incarverpolygons); 
    logger.info("inCarverPolygons " + ( (String) incarverpolygons) );
    inputs.put("pDepthPolygons",  (double) pdepthpolygons); 
    logger.info("pDepthPolygons " + ( (double) pdepthpolygons) );
    inputs.put("inCarverLines",  (String) incarverlines); 
    logger.info("inCarverLines " + ( (String) incarverlines) );
    inputs.put("fDepthPolygons",  (String) fdepthpolygons); 
    logger.info("fDepthPolygons " + ( (String) fdepthpolygons) );
    inputs.put("pDepthLines",  (double) pdepthlines); 
    logger.info("pDepthLines " + ( (double) pdepthlines) );
    
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

